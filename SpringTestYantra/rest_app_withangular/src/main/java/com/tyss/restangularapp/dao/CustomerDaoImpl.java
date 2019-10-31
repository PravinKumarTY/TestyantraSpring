package com.tyss.restangularapp.dao;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;

import com.tyss.restangularapp.dto.Customer;
@Repository
public class CustomerDaoImpl implements CustomerDao{
	
	@Autowired
	private EntityManagerFactory factory;
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		CustomDateEditor editor = new CustomDateEditor(format, true);
		binder.registerCustomEditor(Date.class, editor);
	}

	@Override
	public boolean addCustomer(Customer customer) {
		EntityManager manager=factory.createEntityManager();
		EntityTransaction transaction=manager.getTransaction();
		transaction.begin();
		try {
			manager.persist(customer);
			transaction.commit();
			return true;
		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public Customer getCustomer(int id) {
		EntityManager manager=factory.createEntityManager();
		Customer customer=manager.find(Customer.class,id);
		return customer;
	}

	@Override
	public List<Customer> getAllCustomer() {
		EntityManager manager=factory.createEntityManager();
		String jpql="from Customer";
		Query query=manager.createQuery(jpql);
		List<Customer> customerList=query.getResultList();
		return customerList;
	}

	@Override
	public boolean updateCustomer(Customer customer) {
		EntityManager manager=factory.createEntityManager();
		EntityTransaction transaction=manager.getTransaction();
		Customer cust=manager.find(Customer.class,customer.getId());
		if(cust==null) {
			return false;
		}else {
			transaction.begin();
			cust.setName(customer.getName());
			cust.setAddress(customer.getAddress());
			cust.setDob(customer.getDob());
			cust.setPhone(customer.getPhone());
			transaction.commit();
			return true;
		}
	}

	@Override
	public boolean removeCustomer(int id) {
		EntityManager manager=factory.createEntityManager();
		EntityTransaction transaction=manager.getTransaction();
		Customer customer=manager.find(Customer.class,id);
		if(customer==null) {
			return false;
		}else {
			transaction.begin();
			manager.remove(customer);
			transaction.commit();
			return true;
		}
	}

}
