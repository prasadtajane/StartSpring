package com.prasad.learnspring.api.controller;

import java.util.List;
import org.springframework.http.MediaType;
import com.prasad.learnspring.api.constant.URI;
import com.prasad.learnspring.api.entity.Weather;
import com.prasad.learnspring.api.service.WeatherService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
//@RestController = @ResponseBody + @Controller
//@RequestMapping(value = "/weather")
@RequestMapping(value = URI.WTHR)
//Instead of writing @ResponseBody on every function we can directly write it on top of the class
//No need to write '/' in the value section as spring automatically adds forward slash at the beginning
//Try to remove hard coding by using enum or constants

public class WeatherController {
	
	private WeatherService wthrserv;
	
	//Used for Constructor based DI
	public WeatherController(WeatherService wthrserv) {
		super();
		this.wthrserv = wthrserv;
	}

	@RequestMapping(method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	//No need to write produces if you have jackson libraries
	public List<Weather> findAll()	{
		return wthrserv.findAll();
	}
	
	@RequestMapping(method=RequestMethod.GET, value=URI.ID)
	public Weather findOne(@PathVariable("id") String id)	{
		return wthrserv.findOne(id);
	}
	
	@RequestMapping(method=RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_UTF8_VALUE, produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Weather create (@RequestBody Weather wth)	{
		return wthrserv.create(wth);
	}
	
	@RequestMapping(method=RequestMethod.PUT, value=URI.ID, consumes=MediaType.APPLICATION_JSON_UTF8_VALUE, produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	//public Weather update (@PathVariable("id") String id, @RequestBody Weather wth)	{
	public Weather update (@PathVariable("id") String id, @RequestBody Weather wth)	{
		return wthrserv.update(id, wth);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value=URI.ID, consumes=MediaType.APPLICATION_JSON_UTF8_VALUE, produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public void delete (@PathVariable("id") String id)	{
		wthrserv.delete(id);
	}
}
