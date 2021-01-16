package com.nagarro.hrmanagerREST.controller;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.nagarro.hrmanagerREST.dao.EmployeeDAO;
import com.nagarro.hrmanagerREST.dao.EmployeeDAOImpl;
import com.nagarro.hrmanagerREST.dao.UserDAO;
import com.nagarro.hrmanagerREST.dao.UserDAOImpl;
import com.nagarro.hrmanagerREST.entity.Employee;
import com.nagarro.hrmanagerREST.entity.User;


@Path("employees")
public class MainController {

	@GET
	@Produces("application/json")
	public List<Employee> getEmployees() {
		EmployeeDAOImpl dao = new EmployeeDAOImpl();
		List<Employee> employees = dao.getEmployees();
		return employees;
	}
	
	@GET
	@Path("employee/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Employee getEmployee(@PathParam("id") int id) {
		EmployeeDAO dao= new EmployeeDAOImpl();
		return dao.getEmployee(id);
	}

	@POST
	@Path("/employee")
	@Consumes("application/json")
	public Employee addEmployee(Employee emp) {
	/*	emp.setName(emp.getName());
		emp.setAge(emp.getAge());*/

		EmployeeDAO dao = new EmployeeDAOImpl();
		dao.addEmployee(emp);

		return emp;
	}

	@PUT
	@Path("/employee/{id}")
	@Consumes("application/json")
	public int updateEmployee(@PathParam("id") int id,Employee emp) {
		
		EmployeeDAO dao = new EmployeeDAOImpl();
				
		int count = dao.updateEmployee(id, emp);
		if (count == 0) {
			return count;
		}
		return count;
	}

	@DELETE
	@Path("/employee/{id}")
	@Consumes("application/json")
	public int deleteEmployee(@PathParam("id") int id) {
		EmployeeDAO dao = new EmployeeDAOImpl();
		int count = dao.deleteEmployee(id);
		if (count == 0) {
			return count;
		}
		return count;
	}
	
	@GET
	@Path("user/{username}")
	@Produces(MediaType.APPLICATION_JSON)
	public User getUser(@PathParam("username") String username) {
		UserDAO userDao = new UserDAOImpl();
		return userDao.getUser(username);
	}

}
