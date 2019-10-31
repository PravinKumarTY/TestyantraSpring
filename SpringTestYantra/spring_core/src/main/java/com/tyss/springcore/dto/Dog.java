package com.tyss.springcore.dto;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.stereotype.Component;
@Component("dog")
public class Dog implements Animal{
   public Dog() {
	   System.out.println("Dog object created");
   }
   @PostConstruct
   public void init() {
	   System.out.println("Dog Init method");
   }
   @PreDestroy
   public void destroy() {
	   System.out.println("Dog destroy method");
   }
@Override
public void makeSound() {
	System.out.println("Bao Bao");
}
}
