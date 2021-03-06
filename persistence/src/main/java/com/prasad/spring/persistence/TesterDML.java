package com.prasad.spring.persistence;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import com.prasad.spring.persistence.entity.Weather;

public class TesterDML {

	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa-example");
		EntityManager em = emf.createEntityManager();
		
		TypedQuery<Weather> tquery = em.createQuery("SELECT w from Weather w", Weather.class);
		//createQuery everytime compiles everything the input string into JPQL class (Java Persistence Query Language)
		List<Weather> rsltLst = tquery.getResultList();
		System.out.println(rsltLst);
		
		TypedQuery<Weather> cquery = em.createQuery("SELECT w from Weather w where w.city = :wCity", Weather.class);
		cquery.setParameter("wCity", "NewYork");
		List<Weather> rsltCLst = cquery.getResultList();
		System.out.println(rsltCLst);
		
		System.out.println("Named Queries");
		
		TypedQuery<Weather> tnquery = em.createNamedQuery("wthr.findAll", Weather.class);
		//createNamedQuery are pre-compiled quries so need to compile again and again
		List<Weather> nRsltLst = tnquery.getResultList();
		System.out.println(nRsltLst);
		
		TypedQuery<Weather> cnquery = em.createNamedQuery("wthr.findByCity", Weather.class);
		cnquery.setParameter("wCity", "New York");
		List<Weather> cnRsltCLst = cnquery.getResultList();
		System.out.println(cnRsltCLst);
		
		
		
		em.close();
		emf.close();
		
	}

}
