package com.prasad.spring.persistence;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import com.prasad.spring.persistence.entity.Weather;
import com.prasad.spring.persistence.entity.Wind;

public class TesterTableRelationships {

	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa-example");
		EntityManager em = emf.createEntityManager();
		
		//OneToOne
		Weather wthr = new Weather();
		wthr.setCity("Chicago");
		wthr.setDescription("Its a Warm day");
		wthr.setHumidity(8);
		wthr.setPressure(50);
		wthr.setTemperature(67);
		//One weather record will have only one wind corresponding to it.
		Wind wnd = new Wind();
		wnd.setDegree(18);
		wnd.setSpeed(19);
		//For ONE TO ONE relationship database automatically adds  
		//a foreign key (id_wind) column in the weather table 
		em.getTransaction().begin();
		em.persist(wnd);
		//First record of Wind should be created in the database and only then you can add into Weather
		wthr.setWind(wnd);
		em.persist(wthr);
		em.getTransaction().commit();
		
		/*
		 * For OneToMany relationship database automatically creates a new table of two columns consisting of
		 * 'id_weather' and 'id_wind'. If one weather has too many winds then id_wind will be the Primary Key.
		 * It`s sort of Join Table. 
		 * 
		 * For ManyToOne relationship database automatically adds a new column (id_wind) in the weather table.
		 *  
		 * For ManyToMany relationship database automatically creates a new table of two columns consisting of
		 * 'id_weather' and 'id_wind'. It`s sort of Join Table and combination of both columns can be used as 
		 * unique key for the 'weather' table.  
		*/
		
		
		TypedQuery<Weather> tq = em.createQuery("SELECT w FROM Weather w", Weather.class);
		Weather rsltWthr = tq.getResultList().get(0);
		System.out.println(rsltWthr);
		//This will automatically create a left outer join query and fetch the whole record for given weather id.
		
		em.close();
		emf.close();
		
	}
}
