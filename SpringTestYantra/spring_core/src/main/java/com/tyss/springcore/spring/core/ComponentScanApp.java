package com.tyss.springcore.spring.core;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.tyss.springcore.dto.HelloWorld;
import com.tyss.springcore.dto.SpringConfig;
import com.tyss.tyss.beanconfig.BeanConfig;

public class ComponentScanApp {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context=
				new AnnotationConfigApplicationContext(SpringConfig.class);
		HelloWorld hw=context.getBean(HelloWorld.class);
		hw.getAnimal().makeSound();
	}

}
