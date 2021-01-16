package hrmanagerWebPortal.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lowagie.text.DocumentException;

import hrmanagerWebPortal.dto.Employee;
import hrmanagerWebPortal.service.EmployeeService;
import hrmanagerWebPortal.utilities.EmployeePDFExporter;

@Controller
public class PdfFileController {

	@Autowired
	private EmployeeService employeeService;

	@RequestMapping("/export-pdf")
	public void pdfExporter(HttpServletResponse response) throws DocumentException, IOException {
		response.setContentType("application/pdf");

		String headerKey = "Content-Disposition";
		String headerValue = "attachment; filename=Employees.pdf";
		response.setHeader(headerKey, headerValue);
		List<Employee> empList = employeeService.getAllEmployees();

		EmployeePDFExporter exporter = new EmployeePDFExporter(empList);
		exporter.export(response);

	}

}
