package com.tyss.tyssspringboot.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.tyss.tyssspringboot.dto.Employee;

@Repository
public class EmployeeDaoImpl implements EmployeeDao {

	@PersistenceUnit
	private EntityManagerFactory factory;

	@Override
	public boolean addEmployee(Employee employee) {
		EntityManager em = factory.createEntityManager();
		EntityTransaction et = em.getTransaction();

		try {
			et.begin();
			em.persist(employee);
			et.commit();
		} catch (Exception e) {
			et.rollback();
			e.printStackTrace();
		}
		return true;
	}

	@Override
	public boolean removeEmployee(int id) {
		EntityManager em = factory.createEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();
		Employee employee = em.find(Employee.class, id);

		if (employee == null) {
			return false;
		} else {

			try {
				em.remove(employee);
				et.commit();
			} catch (Exception e) {
				et.rollback();
				e.printStackTrace();
			}
			return true;
		}
	}

	@Override
	public boolean modifyEmployee(Employee employee) {
		EntityManager em = factory.createEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();
		Employee emp = em.find(Employee.class, employee.getId());

		emp.setDob(employee.getDob());
		emp.setName(employee.getName());
		emp.setPassword(employee.getPassword());
		et.commit();
		return true;
	}

	@Override
	public Employee getEmployee(int id) {
		EntityManager em = factory.createEntityManager();

		Employee employee = em.find(Employee.class, id);
		if (employee == null) {
			return null;
		}
		return employee;
	}

	@Override
	public List<Employee> getAllEmployee() {
		EntityManager em = factory.createEntityManager();
		String jpqsl = "from Employee";
		Query q = em.createQuery(jpqsl);

		List<Employee> list = q.getResultList();
		return list;
	}

}
