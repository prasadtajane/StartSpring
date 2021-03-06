package com.prasad.learnspring.api.repository;

import java.util.List;
import com.prasad.learnspring.api.entity.Weather;

public interface WeatherRepository {
	
	List<Weather>findAll();
	Weather findOne(String id);
	Weather create(Weather wth);
	Weather update(String id, Weather wth);
	void delete(String id);
	Boolean exists(Weather wthr);
	
}
