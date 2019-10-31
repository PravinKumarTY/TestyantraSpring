package com.tyss.tyssspringboot.dao;

import java.util.List;

import com.tyss.tyssspringboot.dto.Employee;



public interface EmployeeDao {
	public boolean addEmployee(Employee employee );
	public boolean removeEmployee(int id);
	public boolean modifyEmployee(Employee employee);
	public Employee getEmployee(int id);
	public List<Employee> getAllEmployee();
}
