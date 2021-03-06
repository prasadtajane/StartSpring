package com.prasad.learnspring.api.entity;

import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.NamedQueries;
import org.hibernate.annotations.NamedQuery;

@Entity
//@Table(name="WEATHER")
@NamedQueries({
	@NamedQuery(name="weather.findAll", query="SELECT w from Weather w"),
	@NamedQuery(name="weather.findOne", query="SELECT w from Weather w where w.city = :wCity")
})
public class Weather {

	@Id
	private String id;
	private String city;
	private String description;
	private int humidity;
	private int pressure;
	private int temperature;
	
	@OneToOne(cascade = {CascadeType.ALL})
	private Wind wnd;
	
	public Weather()	{
		super();
		this.id = UUID.randomUUID().toString();
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

	public Wind getWnd() {
		return wnd;
	}

	public void setWnd(Wind wnd) {
		this.wnd = wnd;
	}

	@Override
	public String toString() {
		return "Weather [id=" + id + ", city=" + city + ", description=" + description + ", humidity=" + humidity
				+ ", pressure=" + pressure + ", temperature=" + temperature + ", wnd=" + wnd + "]";
	}

	
}