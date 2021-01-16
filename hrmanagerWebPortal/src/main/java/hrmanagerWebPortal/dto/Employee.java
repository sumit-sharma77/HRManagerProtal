package hrmanagerWebPortal.dto;


public class Employee {
	
	int empCode;
	String empName;
	String loc;
	String email;
	String dob;

	
	public Employee(int empCode, String empName, String loc, String email, String dob) {
		super();
		this.empCode = empCode;
		this.empName = empName;
		this.loc = loc;
		this.email = email;
		this.dob = dob;
	}


	public Employee() {
	
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
	/*	SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		String stringReportPeriodDate = dateFormat.format(dob);*/
		return dob;
	}


	public void setDob(String dob) {
		this.dob = dob;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dob == null) ? 0 : dob.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + empCode;
		result = prime * result + ((empName == null) ? 0 : empName.hashCode());
		result = prime * result + ((loc == null) ? 0 : loc.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		if (dob == null) {
			if (other.dob != null)
				return false;
		} else if (!dob.equals(other.dob))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (empCode != other.empCode)
			return false;
		if (empName == null) {
			if (other.empName != null)
				return false;
		} else if (!empName.equals(other.empName))
			return false;
		if (loc == null) {
			if (other.loc != null)
				return false;
		} else if (!loc.equals(other.loc))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "Employee [empCode=" + empCode + ", empName=" + empName + ", loc=" + loc + ", email=" + email + ", dob="
				+ dob + "]";
	}


}
