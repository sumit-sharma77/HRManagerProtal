<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@include file="./baselinks.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<script type="text/javascript" src="views/js/edit.js" ></script>
<title>Home Page</title>

<style>
<%@include file="/WEB-INF/views/css/home.css"%>
</style>
</head>
<body>
 <div class="container mt-3">
   <div class="container footer">
      <h1 align="left">Header goes here</h1>
    <div align="right">
    <label id = "namePlate">Welcome ${user }</label>
     <% 
    
    String username = (String)request.getAttribute("user");
    	request.getSession().setAttribute("user", username );
    %>
    <a class="border "href="${pageContext.request.contextPath}/" style="font-size: 30px;color:red;border: 1px" title="LogOut"><i class="fas fa-times-circle" style=""></i></a>
    </div>
   </div>
		<div class="container text-center">
			<%
				if (request.getAttribute("authorized") != null) {
			%>
			<p class="form " style="color: red">EmpCode Already Exist in
				Database..!!
			<p>
				<%
					request.setAttribute("authorized", null);
					}
				%>
			
		</div>
	</div>
	<div class="container  p-5">
	<fieldset class="border p-2">
	<legend class="scheduler-border">Add Employee Details</legend>
		<div class="container p-5">
		
			<form name="edit_form" action="${pageContext.request.contextPath}/addEmployee" method="post" onSubmit="return validateEdit()">
				<div class="form-group row">
					<label for="empCode" class="col-sm-2 col-form-label">Employee Code</label>
					<div class="col-sm-10">
						<input type="number" class="form-control" id="empCode" name="empCode"
							placeholder="Employee Id"  required="required">
					</div>
				</div>
				<div class="form-group row">
					<label for="empName" class="col-sm-2 col-form-label">Employee Name</label>
					<div class="col-sm-10">
						<input type="Text" class="form-control" id="empName" name="empName"
							placeholder="Employee Name"  required="required">
					</div>
				</div>
				<div class="form-group row">
					<label for="Location" class="col-sm-2 col-form-label">Location</label>
						<div class="col-sm-10">
						<textarea class="form-control" id="loc"
							aria-describedby="wmailHelp" rows="3" name="loc"
							placeholder="Employee location"
							required="required"></textarea>
							</div>
					</div>

					<div class="form-group row">
						<label for="email" class="col-sm-2 col-form-label">Email</label>
						<div class="col-sm-10">
							<input type="email" class="form-control" id="email" name="email"
								placeholder="abc@example.com" pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,}$"
								oninvalid="this.setCustomValidity('Enter a Valid Email')"
								oninput="this.setCustomValidity('')" required="required">
						</div>
					</div>
					<div class="form-group row">
					<label for="Dob" class="col-sm-2 col-form-label">Date of Birth</label>
					<div class="col-sm-10">
						<input type="date" class="form-control" id="date" name="date"
						placeholder="Enter date"  required="required">
					</div>
				</div>
			
			
				<div class="form-group row">
					<div class="col-sm-10">
					<div class="container text-center">
						<button type="submit" class="btn btn-primary">Save</button>
						<!-- <input type="button" class="btn btn-outline-danger" value="Cancel" /> -->
						<a href="${pageContext.request.contextPath }/home" 
							class="btn btn-outline-danger">Cancel</a>
							</div>
					</div>
				</div>
			</form>
			</div>
			
		</fieldset>
	</div>

	 <div class="container footer">
    <p>Footer goes here</p>
  </div>
</body>
</html>