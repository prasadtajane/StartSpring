package com.prasad.learnspring.api.service;

import java.util.List;
import java.util.Optional;

import com.prasad.learnspring.api.entity.Weather;

public interface WeatherService {
	
	List<Weather>findAll();
	Weather findOne(String id);
	Weather create(Weather wth);
	Weather update(String id, Weather wth);
	void delete(String id);
	
}
