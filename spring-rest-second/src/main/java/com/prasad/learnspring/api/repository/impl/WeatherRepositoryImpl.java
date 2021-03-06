package com.prasad.learnspring.api.repository.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import com.prasad.learnspring.api.entity.Weather;
import org.springframework.stereotype.Repository;
import com.prasad.learnspring.api.repository.WeatherRepository;

@Repository
public class WeatherRepositoryImpl implements WeatherRepository {
	
	@PersistenceContext
	private EntityManager em;
	
	@Override
	public List<Weather> findAll() {
		/*
		Weather wthr1 = new Weather();
		wthr1.setCity("Chicago");
		Weather wthr2 = new Weather();
		wthr2.setCity("Boston");
		Weather wthr3 = new Weather();
		wthr3.setCity("NewYork");
		
		List<Weather> wthrList = new ArrayList<Weather>();
		wthrList.add(wthr1);
		wthrList.add(wthr2);
		wthrList.add(wthr3);
		*/
		
		TypedQuery<Weather> query = em.createNamedQuery("weather.findAll", Weather.class);
		List<Weather> wthrList = query.getResultList();
		
		return wthrList;
	}

	@Override
	public Weather findOne(String id) {
		/*
		Weather wthr1 = new Weather();
		wthr1.setCity("Chicago");
		*/
		/*
		TypedQuery<Weather> query = em.createNamedQuery("weather.findOne", Weather.class);
		query.setParameter("wCity", id);
		List<Weather> wthrList = query.getResultList();
		if (wthrList.isEmpty())	{
			return null;
		}
		return wthrList.get(0);*/
		return em.find(Weather.class, id);
	}
	 
	@Override
	public Weather create(Weather wth) {
		em.persist(wth);
		return wth;
	}

	@Override
	public Weather update(Weather wth) {
		return em.merge(wth);
	}

	@Override
	public void delete(Weather wth) {
		em.remove(wth);
	}

	@Override
	public Boolean exists(Weather wthr) {
		// TODO Auto-generated method stub
		return false;
	}

}
