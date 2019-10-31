package com.tyss.restangularapp.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
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

import com.tyss.restangularapp.dto.Customer;
import com.tyss.restangularapp.service.CustomerService;
@CrossOrigin
@RestController
@RequestMapping("/customer")
public class Customer_Controller {
	
	@Autowired
	private CustomerService service;
	// method to get Single Customer .
	@GetMapping(path="/get",produces=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Customer getCustomer(@RequestParam("id") int id) {
		System.out.println(id);
		Customer customer=service.getCustomer(id);
		return customer;
	}
	
	//Method to get All Customer list

	@GetMapping(path="/get-all",produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Customer> getAllCustomer(){
		List<Customer> customers=service.getAllCustomer();
		return customers;
	}
	
	//Method to post add customer
	@PostMapping(path="/add",produces=MediaType.APPLICATION_JSON_VALUE, consumes=MediaType.APPLICATION_JSON_VALUE)
    public boolean addCustomer(@RequestBody Customer customer) {
		System.out.println("Customer Name..:"+customer.getDob());
		return service.addCustomer(customer);
	}
	
	//Method to update customer
	@PutMapping(path="/update",produces=MediaType.APPLICATION_JSON_VALUE,consumes=MediaType.APPLICATION_JSON_VALUE)
	public boolean updateCustomer(@RequestBody Customer customer) {
		return service.updateCustomer(customer);
	}
	
	//Method to delete Customer.
	@DeleteMapping(path="/delete/{id}",produces=MediaType.APPLICATION_JSON_VALUE,consumes=MediaType.APPLICATION_JSON_VALUE)
	public boolean deleteCustomer(@PathVariable("id") int id) {
		return service.removeCustomer(id);
	}
}
