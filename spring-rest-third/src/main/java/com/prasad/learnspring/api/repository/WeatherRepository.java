package com.prasad.learnspring.api.repository;

import java.util.List;
import java.util.Optional;

import com.prasad.learnspring.api.entity.Weather;

public interface WeatherRepository {
	
	List<Weather>findAll();
	Optional<Weather> findOne(String id);
	Weather create(Weather wth);
	Weather update(Weather wth);
	void delete(Weather wthr);
	Boolean exists(Weather wthr);
	
}
