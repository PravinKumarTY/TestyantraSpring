package com.tyss.springbootdemo1.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tyss.springbootdemo1.dto.Employee;
import com.tyss.springbootdemo1.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository repository;
	@Override
	public boolean addEmployee(Employee employee) {
		//employee.getQualification().setEmployee(employee);
		repository.save(employee);
		//Employee<--Employee.builder().id(1).name("jhfj").email("abc@gmail.com").password("1234").build();-->Return EmployeeBuilder object. It is nothing but builder design pattern.
		//If a class has methods which retrns the object of same class. 
		return true;
	}

	@Override
	public boolean removeEmployee(int id) {
		repository.deleteById(id);
		return true;
	}

	@Override
	public boolean modifyEmployee(Employee employee) {
		//repository.update(employee.getName(), employee.getPassword(), employee.getId());
		return true;
	}

	@Override
	public Employee getEmployee(int id) {

		// return repository.getOne(id);
		return repository.findById(id).get();
	}

	@Override
	public List<Employee> getAllEmployee() {
		return repository.findAll();
	}

	/*@Override
	public List<Employee> getEmployeeByName(String name) {

		return repository.findByName(name);
	}*/

}
