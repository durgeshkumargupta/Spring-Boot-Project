package com.durgesh;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

//@Component   // Or we can use @Service annotation
@Service
public class ServiceClass {
	
	@Autowired
	@Qualifier("lgBulb")
	private Bulb bulb;
	
//	@Autowired
//	@Qualifier("anchorBulb")
//	private Bulb bulb;
	
	public void display() {
		bulb.on();
		bulb.off();
	}

}
