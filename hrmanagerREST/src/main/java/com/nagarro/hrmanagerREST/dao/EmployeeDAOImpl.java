package com.nagarro.hrmanagerREST.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.nagarro.hrmanagerREST.entity.Employee;
import com.nagarro.hrmanagerREST.utilities.HibernateSessionUtil;
/**
 * 
 * @author sumitsharma03
 *
 */
public class EmployeeDAOImpl implements EmployeeDAO {

	/**
	 * 
	 * @return list of employees from DB
	 */
	public List<Employee> getEmployees() {
		
		Session session = HibernateSessionUtil.getSession();
		Query query = session.createQuery("from Employee");
		List<Employee> employees = query.list();
		session.close();
		return employees;
	}
	
	/**
	 * 
	 * @param id
	 * @return Requested Employee
	 */
	public  Employee getEmployee(int id) {
		try {
		Session session = HibernateSessionUtil.getSession();
		Query query = session.createQuery("from Employee where empCode=:id");
		query.setParameter("id", id);
		Employee employee = (Employee) query.uniqueResult();
		session.close();
		return employee;
		}catch (Exception e) {
			return null;
		}
	}

	/**
	 * Adding employee to DB
	 * @param emp
	 */
	public void addEmployee(Employee emp) {
		try {
		Session session = HibernateSessionUtil.getSession();
		Transaction tx = session.beginTransaction();
		session.save(emp);
		tx.commit();
		session.close();
		}catch (Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * updating employee in Database
	 * @param id
	 * @param emp
	 * @return
	 */
	public int updateEmployee(int id, Employee emp) {
		try {
		if (id <= 0)
			return 0;
		Session session = HibernateSessionUtil.getSession();
		Transaction tx = session.beginTransaction();
		Query query = session.createQuery(
				"update Employee set empName = :name , loc=:loc , email=:email , dob=:dob where empCode = :id");
		query.setParameter("id", id);
		query.setParameter("name", emp.getEmpName());
		query.setParameter("loc", emp.getLoc());
		query.setParameter("email", emp.getEmail());
		query.setParameter("dob", emp.getDob());
		int rowCount = query.executeUpdate();
		tx.commit();
		session.close();
		return rowCount;
		}catch (Exception e) {
			return 0;
		}
	}
	
	/**
	 * Delete employee from DB
	 * @param id
	 * @return
	 */

	public int deleteEmployee(int id) {
		
		try {
		Session session = HibernateSessionUtil.getSession();
		Transaction tx = session.beginTransaction();
		String hql = "delete from Employee where empCode = :id";
		Query query = session.createQuery(hql);
		query.setParameter("id", id);
		int rowCount = query.executeUpdate();
		System.out.println("Rows affected: " + rowCount);
		tx.commit();
		session.close();
		return rowCount;
		}catch (Exception e) {
			return 0;
		}
	}

}
