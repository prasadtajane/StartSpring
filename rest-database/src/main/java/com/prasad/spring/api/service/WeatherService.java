package com.prasad.spring.api.service;

import java.util.List;
import com.prasad.spring.api.entity.Weather;

public interface WeatherService {
	
	List<Weather>findAll();
	Weather findOne(String id);
	Weather create(Weather wth);
	Weather update(String id, Weather wth);
	void delete(String id);
	
}
