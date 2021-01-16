package hrmanagerWebPortal.controller;

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
import hrmanagerWebPortal.service.EmployeeService;

@Controller
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;
	
	/**
	 * Mapping for display of edit employee page
	 * 
	 * @param empCode
	 * @param request
	 * @param m
	 * @return
	 */
	@RequestMapping(path="/edit/{id}",method = RequestMethod.GET)
	public String editPage(@PathVariable("id") int empCode,HttpServletRequest request,Model m) {
		
		Employee employee= employeeService.getEmployee(empCode);
		m.addAttribute("employee", employee);
		
		m.addAttribute("user", request.getAttribute("user"));
		return "EditEmp";
	}
	
	/**
	 *  Mapping For UPDATE request
	 * @param empCode
	 * @param empName
	 * @param loc
	 * @param email
	 * @param date
	 * @param request
	 * @param m
	 * @return
	 * @throws JsonProcessingException
	 */
	@RequestMapping(path="/update/{id}",method = RequestMethod.POST)
	public String updatePage(
			@PathVariable("id") int empCode,
			@RequestParam("empName") String empName,
			@RequestParam("loc") String loc,
			@RequestParam("email") String email,
			@RequestParam("date") String date
			,HttpServletRequest request,Model m) throws JsonProcessingException {
		
		Employee emp = new Employee(empCode, empName, loc, email, date);
		System.out.println(request.getAttribute("user"));
		m.addAttribute("user", request.getSession().getAttribute("user"));
		employeeService.updateEmployee(emp);
		
		return "redirect:/home";
		
	}

	@RequestMapping(path = "/addEmpPage", method = RequestMethod.POST)
	public String addPage() {

		return "AddEmp";

	}
	@RequestMapping(path="/addEmployee",method = RequestMethod.POST)
	public String addEmp(
			@RequestParam("empCode") int empCode,
			@RequestParam("empName") String empName,
			@RequestParam("loc") String loc,
			@RequestParam("email") String email,
			@RequestParam("date") String date
			,HttpServletRequest request,Model m) throws JsonProcessingException {
		
		
		Employee emp = new Employee(empCode, empName, loc, email, date);
	
		m.addAttribute("user", request.getSession().getAttribute("user"));
		
		if(employeeService.addEmployee(emp))	return "redirect:/home";

		m.addAttribute("authorized", "false");
		return "forward:/addEmpPage";
		
	}
}
