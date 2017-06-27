package com.prasad.spring.persistence;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.prasad.spring.persistence.entity.Weather;

public class SimpleTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub


		EntityManagerFactory eMFactory = Persistence.createEntityManagerFactory("jpa-example");
		//Should be created only Once per database per connection
		//This is enough for DDL

		EntityManager eManagerInsert = eMFactory.createEntityManager();


		Weather wthr = new Weather(); 			Weather wthr2 = new Weather();
		wthr.setCity("Chicago"); 				wthr2.setCity("Boston");
		wthr.setDescription("Its a Dry day"); 	wthr2.setDescription("Its a Rainy day today");
		wthr.setHumidity(10); 					wthr2.setHumidity(50);
		wthr.setPressure(10); 					wthr2.setPressure(20);
		wthr.setTemperature(100); 				wthr2.setTemperature(80);
		//Every entry in database corresponds to an object instance
		eManagerInsert.getTransaction().begin();
		eManagerInsert.persist(wthr); 			eManagerInsert.persist(wthr2);	
		//***This forces java to add the object in the database***
		eManagerInsert.getTransaction().commit();	
		
		eManagerInsert.close();
		eMFactory.close();
	}

}
