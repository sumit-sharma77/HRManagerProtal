package hrmanagerWebPortal.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.fasterxml.jackson.core.JsonProcessingException;

import hrmanagerWebPortal.dto.Employee;
import hrmanagerWebPortal.dto.User;
import hrmanagerWebPortal.service.EmployeeService;
import hrmanagerWebPortal.service.UserService;


@Controller
public class mainController {
	
	@Autowired
	private EmployeeService employeeService;
	@Autowired
	private UserService userService;
	
	/**
	 * Mapping for first page on start up
	 * @return
	 */
	@RequestMapping("/")
	public String firstPage() {
		
	return "Login";
	}
	
	/**
	 * Mapping to check valid USER after login 
	 * 
	 * 
	 * @param userName
	 * @param userPassword
	 * @param m
	 * @return
	 */
	@RequestMapping(path="/afterlogin",method = RequestMethod.POST)
	public String afterlogin(
			@RequestParam("username") String userName,
			@RequestParam("password") String userPassword, Model m) {
		
		User users = new User(userName, userPassword);

		boolean loginSucess = userService.isValidUser(users);

		if (loginSucess) {
			m.addAttribute("user", userName);
			return "forward:/home";
		}
	
		m.addAttribute("authorized", "false");
		return "Login";
		
	}
	
	/**
	 * Mapping for display of Home Page
	 * @param m
	 * @return
	 */
	@RequestMapping(path="/home", method = {RequestMethod.POST,RequestMethod.GET})
	public String homePage(Model m) {
		
		List<Employee> employeesList = employeeService.getAllEmployees();
		
		m.addAttribute("employee",employeesList);
		
		return "Home";
	}



}
