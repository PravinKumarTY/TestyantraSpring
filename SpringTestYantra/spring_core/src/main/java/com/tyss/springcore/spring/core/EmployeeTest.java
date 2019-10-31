package com.tyss.springcore.spring.core;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.tyss.springcore.dto.Employee;

public class EmployeeTest {

	public static void main(String[] args) {
		ApplicationContext context=new ClassPathXmlApplicationContext("beans.xml");
		Employee emp=(Employee)context.getBean("emp");
		System.out.println(emp.getName());
		System.out.println(emp.getAddress());
		System.out.println(emp.getPhno());
		
	}
}
