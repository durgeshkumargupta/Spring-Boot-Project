package com.durgesh;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Qualifier("lgBulb")
@Component
public class LgBulb implements Bulb{

	public void on() {
		System.out.println("Lg Bulb On");
		
	}
	public void off() {
		System.out.println("Lg Bulb Off");
		
	}
}
