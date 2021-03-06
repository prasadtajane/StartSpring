package com.prasad.spring.persistence.entity;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import org.hibernate.annotations.NamedQueries;
import org.hibernate.annotations.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
//@Table(name="WEATHER")

@NamedQueries({
	@NamedQuery(name="wthr.findAll", query="SELECT w FROM Weather w"),
	@NamedQuery(name="wthr.findByCity", query="SELECT w FROM Weather w WHERE w.city = :wCity")
})

public class Weather {
	
	@Id
	private String id;
	
	private String city;
	private int humidity;
	private int pressure;
	private int temperature;
	
	@OneToOne
	private Wind wind;
	
	@Column(columnDefinition="VARCHAR(500)", unique=false)
	private String description;
	//By default the string is varchar(255)
	
	public Weather(){
		this.id=UUID.randomUUID().toString();
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getHumidity() {
		return humidity;
	}
	public void setHumidity(int humidity) {
		this.humidity = humidity;
	}
	public int getPressure() {
		return pressure;
	}
	public void setPressure(int pressure) {
		this.pressure = pressure;
	}
	public int getTemperature() {
		return temperature;
	}
	public void setTemperature(int temperature) {
		this.temperature = temperature;
	}
	public Wind getWind() {
		return wind;
	}
	public void setWind(Wind wind) {
		this.wind = wind;
	}
	
	@Override
	public String toString() {
		return "Weather [id=" + id + ", city=" + city + ", humidity=" + humidity + ", pressure=" + pressure
				+ ", temperature=" + temperature + ", wind=" + wind + ", description=" + description + "]";
	}
}
