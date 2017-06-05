
package com.prasad.spring.api.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.prasad.spring.api.entity.Weather;
import com.prasad.spring.api.exception.BadInputException;
import com.prasad.spring.api.exception.NotFoundException;
import com.prasad.spring.api.repository.WeatherRepository;
import com.prasad.spring.api.service.WeatherService;

@Service
public class WeatherServiceImpl implements WeatherService{
	//Business Logic and Validation should be here, so error basic handling should be done here
	
	private WeatherRepository wthrepo;
	
	@Override
	public List<Weather> findAll() {
		// TODO Auto-generated method stub
		return this.wthrepo.findAll();
	}

	@Override
	public Weather findOne(String id) {
		// TODO Auto-generated method stub
		return this.wthrepo.findOne(id);
	}

	@Override
	public Weather create(Weather wth) {
		// TODO Auto-generated method stub
		if (wthrepo.exists(wth))	{
			throw new BadInputException("Weather Record for the city for given time already exists.");
		}
		return wthrepo.create(wth);
	}

	@Override
	public Weather update(String id, Weather wth) {
		// TODO Auto-generated method stub
		if (! wthrepo.exists(wth))	{
			throw new NotFoundException("Weather with given id do not exists.");
		}
		return wthrepo.update(id, wth);
	}

	@Override
	public void delete(String id) {
		// TODO Auto-generated method stub
		wthrepo.delete(id);
	}

}