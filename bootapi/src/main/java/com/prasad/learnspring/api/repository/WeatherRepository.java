package com.prasad.learnspring.api.repository;

import java.util.List;
import java.util.Optional;
import com.prasad.learnspring.api.entity.Weather;

import org.springframework.data.repository.Repository;

public interface WeatherRepository extends Repository<Weather, String>{
	
/*	List<Weather>findAll();
	Optional<Weather> findOne(String id);
	Weather create(Weather wth);
	Weather update(Weather wth);
	void delete(Weather wthr);
	Boolean exists(Weather wthr);*/
	
	public List<Weather> findAll();
	public Optional<Weather> findOne(String id);
	public Weather save(Weather wth);
	public void delete(String id);
	public boolean exists(String id);
	
	public Optional<Weather> findByCity(String city);
	public Optional<Weather> findByIdOrderByCity(String id);
	
}
