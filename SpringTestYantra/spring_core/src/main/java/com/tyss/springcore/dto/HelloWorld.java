package com.tyss.springcore.dto;

import java.util.Map;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
@Component("hello")
public class HelloWorld implements InitializingBean,DisposableBean{
	public HelloWorld() {
		System.out.println("Helloworld Object Created");
	}
	private String msg;
	@Autowired                  //This @Autowired Search for the Type.
	@Qualifier("human")
	private Animal animal;
	private int count;
	private Map<String,Integer> map;

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public Map<String, Integer> getMap() {
		return map;
	}

	public void setMap(Map<String, Integer> map) {
		this.map = map;
	}

	public Animal getAnimal() {
		return animal;
	}

	public void setAnimal(Animal animal) {
		this.animal = animal;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	@Override
	public void destroy() throws Exception {
		System.out.println("Destroying HelloworldBean");
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("Initializing HelloworldBean");
	}

}
