package com.prasad.spring.persistence;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.prasad.spring.persistence.entity.Weather;

public class Tester {

	public static void main(String args[])	{

		EntityManagerFactory eMFactory = Persistence.createEntityManagerFactory("jpa-example");
		//Should be created only Once per database per connection
		//This is enough for DDL

		EntityManager eManagerInsert = eMFactory.createEntityManager();
		EntityManager eManagerSelect = eMFactory.createEntityManager();
		EntityManager eManagerUpdate = eMFactory.createEntityManager();
		EntityManager eManagerDelete = eMFactory.createEntityManager();
		//You can create as many entity manager as you want
		//This is required for the DML

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
		//***By default the autoCommit property is set to 'false'***
		//***Without transaction begin and commit the persist is of no use.***
		
		Weather getwthr = eManagerSelect.find(Weather.class, "abc1243");
		//find method requires the Class name to relate to a table and an Id to find out the record.
		System.out.println(getwthr);
		//The find returns 'null' if record pertaining to given id does not exist

		Weather updtwthr = eManagerUpdate.find(Weather.class, "abc1243");
		updtwthr.setCity("NewYork");
		eManagerUpdate.getTransaction().begin();
		eManagerUpdate.merge(updtwthr);			//***Need to 'merge' the object to run update in database***
		eManagerUpdate.getTransaction().commit();
		
		Weather dltwthr = eManagerDelete.find(Weather.class, "abc1243");
		eManagerDelete.getTransaction().begin();
		eManagerDelete.remove(dltwthr);
		eManagerDelete.getTransaction().commit();
		
		
		eManagerDelete.close();
		eManagerUpdate.close();
		eManagerSelect.close();
		eManagerInsert.close();

		eMFactory.close();
	}
}