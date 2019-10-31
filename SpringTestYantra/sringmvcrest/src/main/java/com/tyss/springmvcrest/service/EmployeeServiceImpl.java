package com.tyss.springmvcrest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tyss.springmvcrest.dao.EmployeeDao;
import com.tyss.springmvcrest.dto.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService{
	
	@Autowired
    private EmployeeDao dao;
	
	@Override
	public boolean addEmployee(Employee employee) {
		if(employee.getName()==null || employee.getEmail()==null||employee.getPassword()==null) 
			return false;
		return dao.addEmployee(employee);
	}

	@Override
	public boolean removeEmployee(int id) {
		return dao.removeEmployee(id);
	}

	@Override
	public boolean modifyEmloyee(Employee employee) {
		if(employee.getName()==null || employee.getEmail()==null||employee.getPassword()==null) 
			return false;
		return dao.modifyEmloyee(employee);
	}
	@Override
	public Employee getEmloyee(int id) {
		return dao.getEmloyee(id);
	}

	@Override
	public List<Employee> getAllEmloyee() {
		return dao.getAllEmloyee();
	}
}
