package com.tyss.tyss.beanconfig;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.tyss.springcore.dto.Animal;
import com.tyss.springcore.dto.Dog;
import com.tyss.springcore.dto.HelloWorld;
import com.tyss.springcore.dto.Human;

@Configuration
public class BeanConfig {
   //@Bean(name="obj", autowire=Autowire.BY_TYPE)//It is not mand but its good practice
   @Bean(name="obj")
   public HelloWorld getHelloWorld() {//It represent bean element
	   HelloWorld helloWorld=new HelloWorld();
	   helloWorld.setMsg("Hello World......");
	   helloWorld.setCount(1000);
	   HashMap<String,Integer> map=new HashMap<String,Integer>();
	   map.put("abc",123);
	   map.put("xyz",890);
	   helloWorld.setMap(map);
	   //Animal animal=getDog();
	   //helloWorld.setAnimal(getDog());
	   return helloWorld;
   }
   
   @Bean(name="dog")
   @Scope(value="prototype")
   public Dog getDog() {
	   return new Dog();
   }
   @Bean(name="human")
   public Human getHuman() {
	   return new Human();
   }
   
   
}
