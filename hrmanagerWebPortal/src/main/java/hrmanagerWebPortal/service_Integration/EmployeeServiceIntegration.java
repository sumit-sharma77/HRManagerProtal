package hrmanagerWebPortal.service_Integration;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;


import hrmanagerWebPortal.constants.URLs;
import hrmanagerWebPortal.dto.Employee;

/**
 *  *@author sumitsharma03
 * Class to send requests to REST Application
 *
 */
@Repository
public class EmployeeServiceIntegration {

	/**
	 * fetch request to get all employees from DB
	 * @return List of Employees
	 */
	public List<Employee> getEmployees() {
		
		 RestTemplate restTemplate = new RestTemplate();
	    
	    List<Employee> employeesList=   restTemplate.getForObject(URLs.GET_EMPLOYEES, List.class);
	    
	    return employeesList;
	}
	
	/**
	 * fetch request to get requested employee from empCode
	 * @param empCode
	 * @return Single Employee
	 */
	public Employee getEmployee(int empCode) {
		try {
		RestTemplate restTemplate = new RestTemplate();
		Employee employee=restTemplate.getForObject(URLs.EMPLOYEE+empCode, Employee.class);
		return employee;
		}catch (Exception e) {
			return null;
		}
	}
	
	/**
	 * PUT request to Update Employee details
	 * @param emp
	 * @throws JsonProcessingException
	 */

	public void updateEmployee(Employee emp) throws JsonProcessingException {
		
		
		RestTemplate restTemplate = new RestTemplate();
		
		restTemplate.put(URLs.EMPLOYEE+emp.getEmpCode(), emp);
		
		/*Employee empExist=getEmployee(emp.getEmpCode());
		if()*/
		/*ObjectMapper m = new ObjectMapper();
		String json = m.writerWithDefaultPrettyPrinter().writeValueAsString(emp);
		Client c  = Client.create();
        WebResource resource = c.resource(URLs.EMPLOYEE+emp.getEmpCode());
        ClientResponse response = resource
                .type("application/json").put(ClientResponse.class,json);
        
        response.close();*/
	}

	public void addEmp(Employee emp) {
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.postForObject(URLs.EMPLOYEE, emp,Employee.class);
		
	}
}
