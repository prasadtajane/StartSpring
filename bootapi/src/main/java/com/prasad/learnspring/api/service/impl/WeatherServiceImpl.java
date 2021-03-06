
package com.prasad.learnspring.api.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.prasad.learnspring.api.entity.Weather;
import com.prasad.learnspring.api.exception.BadInputException;
import com.prasad.learnspring.api.exception.NotFoundException;
import com.prasad.learnspring.api.repository.WeatherRepository;
import com.prasad.learnspring.api.service.WeatherService;

@Service
public class WeatherServiceImpl implements WeatherService{
	//Business Logic and Validation should be here, so error basic handling should be done here
	
	private WeatherRepository wthrepo;
	
	public WeatherServiceImpl(WeatherRepository wthrepo)	{
		this.wthrepo = wthrepo;
	}
	
	@Override
	@Transactional(readOnly=true)
	public List<Weather> findAll() {
		// TODO Auto-generated method stub
		return wthrepo.findAll();
	}

	@Override
	public Weather findOne(String id) {
		// TODO Auto-generated method stub
		return this.wthrepo.findOne(id).orElseThrow(() -> new NotFoundException("Given Id is Not Present"));
	}

	@Override
	@Transactional
	public Weather create(Weather wth) {
		if (wthrepo.exists(wth.getId()))	{
			throw new BadInputException("Weather Record for the city for given time already exists.");
		}
		return wthrepo.save(wth);
	}

	@Override
	@Transactional
	public Weather update(String id, Weather wth) {
		wthrepo.findOne(id).orElseThrow(() -> new NotFoundException(id + " Is Not Present."));
		return wthrepo.save(wth);
	}

	@Override
	@Transactional
	public void delete(String id) {
		wthrepo.findOne(id).orElseThrow(() -> new NotFoundException(id + " Is Not Present."));
		wthrepo.delete(id);
	}

}
