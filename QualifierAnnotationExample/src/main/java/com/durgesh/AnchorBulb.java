package com.durgesh;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Qualifier("anchorBulb")
@Component
public class AnchorBulb implements Bulb {

	public void on() {
		System.out.println("Anchor Bulb On");
		
	}

	public void off() {
		System.out.println("Anchor Bulb Off");
		
	}

}
