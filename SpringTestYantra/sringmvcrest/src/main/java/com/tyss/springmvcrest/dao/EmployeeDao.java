package com.tyss.springmvcrest.dao;

import java.util.List;

import com.tyss.springmvcrest.dto.Employee;

public interface EmployeeDao {
	public boolean addEmployee(Employee employee);
	public boolean removeEmployee(int id);
	public boolean modifyEmloyee(Employee employee);
	public Employee getEmloyee(int id);
	public List<Employee> getAllEmloyee();
}
