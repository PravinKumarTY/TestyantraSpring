package com.tyss.springmvcrest.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.tyss.springmvcrest.dto.Employee;
import com.tyss.springmvcrest.dto.EmployeeResponse;
import com.tyss.springmvcrest.service.EmployeeService;
@RestController//Spring RestController annotation is used to create RESTful web services using Spring MVC
@RequestMapping("/employee")
public class EmployeeController {
	@Autowired
	private EmployeeService service;
	
	@GetMapping(path= "/get",produces=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody EmployeeResponse getEmployee(@RequestParam("id") int id) {
		Employee employee=service.getEmloyee(id);
		EmployeeResponse response=new EmployeeResponse();
		if(employee==null) {
			response.setStatusCode(401);
			response.setMessage("Failed");
			response.setDescription("No record found");
		}else {
			response.setStatusCode(201);
			response.setMessage("Success");
			response.setDescription("Data found");
			response.setEmployees(Arrays.asList(employee));
		}
		return response;
	}
	
	@GetMapping(path="/get-all",produces=MediaType.APPLICATION_JSON_VALUE)
	public EmployeeResponse getAllEmployee(){
		//return service.getAllEmloyee();
		List<Employee> employees=service.getAllEmloyee();
		EmployeeResponse response=new EmployeeResponse();
		if(employees==null) {
			response.setStatusCode(401);
			response.setMessage("Failed");
			response.setDescription("No record found");
		}else {
			response.setStatusCode(201);
			response.setMessage("Success");
			response.setDescription("Data found");
			response.setEmployees(employees);
		}
		return response;
	}
	
	@PostMapping(path="/add",produces=MediaType.APPLICATION_JSON_VALUE,consumes=MediaType.APPLICATION_JSON_VALUE)
	public EmployeeResponse addEmployee(@RequestBody Employee employee) {
		//return service.addEmployee(employee);
		EmployeeResponse response=new EmployeeResponse();
		if(service.addEmployee(employee)) {
			response.setStatusCode(201);
			response.setMessage("Success");
			response.setDescription("Record Added Successfully");
		}else {
			response.setStatusCode(401);
			response.setMessage("Failed");
			response.setDescription("Record Not Added");
		}
		return response;
	}
	
	@PutMapping(path="/modify",produces=MediaType.APPLICATION_JSON_VALUE,consumes=MediaType.APPLICATION_JSON_VALUE)
	public EmployeeResponse modifyEmployee(@RequestBody Employee employee) {
		//return service.modifyEmloyee(employee);
		EmployeeResponse response=new EmployeeResponse();
		if(service.modifyEmloyee(employee)) {
			response.setStatusCode(201);
			response.setMessage("Success");
			response.setDescription("Record Modified Successfully");
		}else {
			response.setStatusCode(401);
			response.setMessage("Failed");
			response.setDescription("Record Not Modified");
		}
		return response;
	}
	@DeleteMapping(path="/remove/{id}",produces=MediaType.APPLICATION_JSON_VALUE)
	public EmployeeResponse removeEmployee(@PathVariable("id") int id) {
		//return service.removeEmployee(id);
		
		EmployeeResponse response=new EmployeeResponse();
		if(service.removeEmployee(id)) {
			response.setStatusCode(201);
			response.setMessage("Success");
			response.setDescription("Removed");
		}else {
			response.setStatusCode(401);
			response.setMessage("Failed");
			response.setDescription("Not Removed");
		}
		return response;
		
	}

}
