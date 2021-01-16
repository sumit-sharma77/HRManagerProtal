package com.nagarro.hrmanagerREST.entity;



import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Employee")
public class Employee {
	
	@Id
	int empCode;
	String empName;
	String loc;
	String email;
	String dob;
	
	
	public Employee(String empName, String loc, String email, String dob) {
		
		this.empName = empName;
		this.loc = loc;
		this.email = email;
		this.dob = dob;
	}


	public Employee() {
		super();
	}
	

	public int getEmpCode() {
		return empCode;
	}


	public void setEmpCode(int empCode) {
		this.empCode = empCode;
	}


	public String getEmpName() {
		return empName;
	}


	public void setEmpName(String empName) {
		this.empName = empName;
	}


	public String getLoc() {
		return loc;
	}


	public void setLoc(String loc) {
		this.loc = loc;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getDob() {
		return dob;
	}


	public void setDob(String dob) {
		this.dob = dob;
	}


}
