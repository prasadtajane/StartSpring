package com.prasad.learnspring.SpringOne;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
//By default its of type Singleton

public class WindState {
	private int speed = 0;
	private int degree = 0;
	
	public int getSpeed() {
		return speed;
	}
	public void setSpeed(int speed) {
		this.speed = speed;
	}
	public int getDegree() {
		return degree;
	}
	public void setDegree(int degree) {
		this.degree = degree;
	}
	
	public WindState() {
		super();
	}
	public WindState(int speed, int degree) {
		super();
		this.speed = speed;
		this.degree = degree;
	}
	
	@Override
	public String toString() {
		return "WindState [speed=" + speed + ", degree=" + degree + "]";
	}
	
}
