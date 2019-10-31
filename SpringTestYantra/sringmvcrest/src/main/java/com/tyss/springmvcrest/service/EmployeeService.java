package com.tyss.springmvcrest.service;

import java.util.List;

import com.tyss.springmvcrest.dto.Employee;

public interface EmployeeService {
	public boolean addEmployee(Employee employee);
	public boolean removeEmployee(int id);
	public boolean modifyEmloyee(Employee employee);
	public Employee getEmloyee(int id);
	public List<Employee> getAllEmloyee();
}
