package com.tyss.springcore.dto;

import org.springframework.stereotype.Component;

@Component("human")
public class Human implements Animal {

	@Override
	public void makeSound() {
		System.out.println("Bla Bla Bla");
	}

}
