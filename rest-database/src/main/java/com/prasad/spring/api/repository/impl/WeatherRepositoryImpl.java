package com.prasad.spring.api.repository.impl;

import java.util.ArrayList;
import java.util.List;
import com.prasad.spring.api.entity.Weather;
import org.springframework.stereotype.Repository;
import com.prasad.spring.api.repository.WeatherRepository;

@Repository
public class WeatherRepositoryImpl implements WeatherRepository {
	
	@Override
	public List<Weather> findAll() {
		// TODO Auto-generated method stub
		Weather wthr1 = new Weather();
		wthr1.setCity("Chicago");
		Weather wthr2 = new Weather();
		wthr1.setCity("Boston");
		Weather wthr3 = new Weather();
		wthr1.setCity("NewYork");
		
		List<Weather> wthrList = new ArrayList<Weather>();
		wthrList.add(wthr1);
		wthrList.add(wthr2);
		wthrList.add(wthr3);
		
		return wthrList;
	}

	@Override
	public Weather findOne(String id) {
		// TODO Auto-generated method stub
		Weather wthr1 = new Weather();
		wthr1.setCity("Chicago");
		
		return wthr1;
	}

	@Override
	public Weather create(Weather wth) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Weather update(String id, Weather wth) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(String id) {
		// TODO Auto-generated method stub

	}

	@Override
	public Boolean exists(Weather wthr) {
		// TODO Auto-generated method stub
		return null;
	}

}

