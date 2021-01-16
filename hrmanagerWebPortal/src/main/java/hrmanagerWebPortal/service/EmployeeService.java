package hrmanagerWebPortal.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;

import hrmanagerWebPortal.dto.Employee;
import hrmanagerWebPortal.service_Integration.EmployeeServiceIntegration;

@Service
public class EmployeeService {

	@Autowired
	EmployeeServiceIntegration serviceIntegration;
	
	public List<Employee> getAllEmployees(){
		
		return serviceIntegration.getEmployees();
	}

	public Employee getEmployee(int empCode) {
		
		return serviceIntegration.getEmployee(empCode);
	}

	public void updateEmployee(Employee emp) throws JsonProcessingException {
		
		serviceIntegration.updateEmployee(emp);
	}

	public Boolean addEmployee(Employee emp) {
		try {
			Employee empExist = getEmployee(emp.getEmpCode());
			if (empExist.getEmpCode() == emp.getEmpCode()) {
				return false;
			}
			
		} catch (NullPointerException e) {

			serviceIntegration.addEmp(emp);
			
		}
		return true;
		 
		
		
	}
	
}
