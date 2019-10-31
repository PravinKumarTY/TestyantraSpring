package com.tyss.springcore.spring.core;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.tyss.springcore.dto.Animal;
import com.tyss.springcore.dto.HelloWorld;
import com.tyss.tyss.beanconfig.BeanConfig;

public class ConfiguratinAppTest {
	
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context=
				new AnnotationConfigApplicationContext(BeanConfig.class);
		HelloWorld obj=context.getBean(HelloWorld.class);
		System.out.println(obj.getMsg());
		System.out.println(obj.getCount());
		System.out.println(obj.getMap());
		obj.getAnimal().makeSound();
		
		Animal animal1=(Animal)context.getBean("dog");
		Animal animal2=(Animal)context.getBean("dog");
		System.out.println(animal1==animal2);
		context.close();
	}
}
