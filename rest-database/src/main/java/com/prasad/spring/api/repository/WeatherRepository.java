package com.prasad.spring.api.repository;

import java.util.List;
import com.prasad.spring.api.entity.Weather;

public interface WeatherRepository {
	
	List<Weather>findAll();
	Weather findOne(String id);
	Weather create(Weather wth);
	Weather update(String id, Weather wth);
	void delete(String id);
	Boolean exists(Weather wthr);
	
}
