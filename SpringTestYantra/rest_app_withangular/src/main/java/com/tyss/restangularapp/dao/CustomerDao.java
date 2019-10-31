package com.tyss.restangularapp.dao;

import java.util.List;

import com.tyss.restangularapp.dto.Customer;

public interface CustomerDao {
	public boolean addCustomer(Customer customer);
	public Customer getCustomer(int id);
	public List<Customer> getAllCustomer();
	public boolean updateCustomer(Customer customer);
	public boolean removeCustomer(int id);
}
