package com.tyss.restangularapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tyss.restangularapp.dao.CustomerDao;
import com.tyss.restangularapp.dto.Customer;

@Service
public class CustomerServiceImpl implements CustomerService{
	@Autowired
	private CustomerDao dao;
	@Override
	public boolean addCustomer(Customer customer) {
		return dao.addCustomer(customer);
	}

	@Override
	public Customer getCustomer(int id) {
		return dao.getCustomer(id);
	}

	@Override
	public List<Customer> getAllCustomer() {
		return dao.getAllCustomer();
	}

	@Override
	public boolean updateCustomer(Customer customer) {
		return dao.updateCustomer(customer);
	}

	@Override
	public boolean removeCustomer(int id) {
		return dao.removeCustomer(id);
	}

}
