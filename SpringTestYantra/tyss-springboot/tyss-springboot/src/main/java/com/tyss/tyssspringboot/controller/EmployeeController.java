package com.tyss.tyssspringboot.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tyss.tyssspringboot.dto.Employee;
import com.tyss.tyssspringboot.dto.EmployeeResponse;
import com.tyss.tyssspringboot.service.EmployeeService;

/*	@controller+@ResponseBody=@RestController
 * 
 */
@RestController
// @CrossOrigin(origins="*",allowedHeaders="*",allowCredentials="true")
@RequestMapping("/employee")
public class EmployeeController {
	@Autowired
	private EmployeeService service;

	@GetMapping(path = "/get", produces = MediaType.APPLICATION_JSON_VALUE)
	public EmployeeResponse getEmployee(@RequestParam("id") int id) {
		EmployeeResponse response = new EmployeeResponse();
		Employee employee = service.getEmployee(id);
		if (employee == null) {
			response.setStatusCode(401);
			response.setMessage("failure");
			response.setDescription("data not found");
		} else {
			response.setStatusCode(201);
			response.setMessage("success");
			response.setDescription("data got successfully..");
			response.setEmployees(Arrays.asList(employee));
		}
		return response;
	}

	@RequestMapping(path = "/get-all", produces = MediaType.APPLICATION_JSON_VALUE)
	public EmployeeResponse getAllEmployee() {
		EmployeeResponse response = new EmployeeResponse();
		List<Employee> employees = service.getAllEmployee();
		if (employees == null) {
			response.setStatusCode(410);
			response.setMessage("failure");
			response.setDescription("data not found");
		} else {
			response.setStatusCode(210);
			response.setMessage("success");
			response.setDescription("data got successfully..");
			response.setEmployees(employees);
		}
		return response;

	}

	@PostMapping(path = "/add", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public EmployeeResponse addEmployee(@RequestBody Employee employee) {
		EmployeeResponse response = new EmployeeResponse();
		if (service.addEmployee(employee)) {
			response.setStatusCode(201);
			response.setMessage("success");
			response.setDescription("data added successfully..");
		} else {
			response.setStatusCode(401);
			response.setMessage("failure");
			response.setDescription("data not added successfully");
		}
		return response;
	}

	@PutMapping(path = "/modify", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public EmployeeResponse modifyEmployee(@RequestBody Employee employee) {
		EmployeeResponse response = new EmployeeResponse();
		if (service.modifyEmployee(employee)) {
			response.setStatusCode(250);
			response.setMessage("success");
			response.setDescription("data modified successfully..");
		} else {
			response.setStatusCode(450);
			response.setMessage("failure");
			response.setDescription("data not  modified successfully..");
		}
		return response;
	}

	@DeleteMapping(path = "/remove/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public EmployeeResponse removeEmployee(@PathVariable("id") int id) {
		EmployeeResponse response = new EmployeeResponse();
		if (service.removeEmployee(id)) {
			response.setStatusCode(205);
			response.setMessage("success");
			response.setDescription("data deleted successfully..");
		} else {
			response.setStatusCode(405);
			response.setMessage("failure");
			response.setDescription("data not  deleted successfully..");
		}
		return response;
	}
}
