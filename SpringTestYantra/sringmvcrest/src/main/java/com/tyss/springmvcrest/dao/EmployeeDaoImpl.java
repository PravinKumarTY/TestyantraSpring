package com.tyss.springmvcrest.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.tyss.springmvcrest.dto.Employee;

@Repository
public class EmployeeDaoImpl implements EmployeeDao {
	@PersistenceUnit
	private EntityManagerFactory factory;

	@Override
	public boolean addEmployee(Employee employee) {
		if (checkEmail(employee.getEmail())) {
			return false;
		}
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		transaction.begin();
		try {
			manager.persist(employee);
			transaction.commit();
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean removeEmployee(int id) {
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		transaction.begin();
		Employee employee = manager.find(Employee.class, id);
		if (employee == null) {
			return false;
		}
		try {
			manager.remove(employee);
			transaction.commit();
			return true;
		} catch (Exception e) {
			
			return false;
		}

	}

	@Override
	public boolean modifyEmloyee(Employee employee) {
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		transaction.begin();
		Employee emp = manager.find(Employee.class, employee.getId());
		if (emp == null) {
			return false;
		}
		emp.setName(employee.getName());
		emp.setPassword(employee.getPassword());
		emp.setDate(employee.getDate());
		transaction.commit();
		return true;
	}

	@Override
	public Employee getEmloyee(int id) {
		EntityManager manager = factory.createEntityManager();
		String jpql = "from Employee where id=:id";
		Query query = manager.createQuery(jpql);
		query.setParameter("id", id);
		return (Employee) query.getSingleResult();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Employee> getAllEmloyee() {
		EntityManager manager = factory.createEntityManager();
		String jpql = "from Employee";
		Query query = manager.createQuery(jpql);
		List<Employee> employees = query.getResultList();
		return employees;
	}

	private boolean checkEmail(String email) {
		EntityManager manager = factory.createEntityManager();
		String jpql = "from Employee where email=:email";
		Query query = manager.createQuery(jpql);
		query.setParameter("email", email);
		try {
			Employee employee = (Employee) query.getSingleResult();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

}
