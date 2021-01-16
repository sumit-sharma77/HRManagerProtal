package com.nagarro.hrmanagerREST.dao;

import java.util.List;

import com.nagarro.hrmanagerREST.entity.Employee;

public interface EmployeeDAO {

	public List<Employee> getEmployees();
	public  Employee getEmployee(int id);
	public void addEmployee(Employee emp);
	public int updateEmployee(int id, Employee emp);
	public int deleteEmployee(int id);
	
}
