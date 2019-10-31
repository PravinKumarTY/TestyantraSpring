package com.tyss.springcore.dto;

import org.springframework.beans.factory.config.BeanPostProcessor;

public class PostProcessor implements BeanPostProcessor{
	@Override
	public Object postProcessBeforeInitialization(Object bean,String beanName) {
		System.out.println("Bean Name..:"+beanName);
		if(beanName.equals("obj")) {
			System.out.println("Hello world Before Init");
		}else if(beanName.equals("dog")){
			System.out.println("Dog Before Init");
		}
			
		return bean;
	}
	@Override
	public Object postProcessAfterInitialization(Object bean,String beanName) {
		System.out.println("Bean Name.."+beanName);
		return bean;
	}
	

}
