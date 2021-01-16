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


</div>
	<div class="container  p-5">
	<fieldset class="border p-2">
	<legend class="scheduler-border">Edit Employee Details</legend>
		<div class="container p-5">
		
			<form name="edit_form" action="${pageContext.request.contextPath}/update/${employee.empCode }" method="post" onSubmit="return validateEdit()">
				<div class="form-group row">
					<label for="empCode" class="col-sm-2 col-form-label">Employee Code</label>
					<div class="col-sm-10">
						<input type="text" class="form-control" id="empCode" name="empCode"
							placeholder="Employee Id" value="${employee.empCode }" readonly="readonly">
					</div>
				</div>
				<div class="form-group row">
					<label for="empName" class="col-sm-2 col-form-label">Employee Name</label>
					<div class="col-sm-10">
						<input type="Text" class="form-control" id="empName" name="empName"
							placeholder="Employee Name" value="${employee.empName }" required="required">
					</div>
				</div>
				<div class="form-group row">
					<label for="Location" class="col-sm-2 col-form-label">Location</label>
						<div class="col-sm-10">
						<textarea class="form-control" id="loc"
							aria-describedby="wmailHelp" rows="3" name="loc"
							placeholder="Employee location"
							required="required">${employee.loc }</textarea>
							</div>
					</div>
				
				<div class="form-group row">
					<label for="email" class="col-sm-2 col-form-label">Email</label>
					<div class="col-sm-10">
						<input type="email" class="form-control" id="email" name="email"
							placeholder="Email" value="${employee.email }" required="required">
					</div>
				</div>
				<div class="form-group row">
					<label for="Dob" class="col-sm-2 col-form-label">Date of Birth</label>
					<div class="col-sm-10">
						<input type="date" class="form-control" id="date" name="date"
						placeholder="Enter date" value="${employee.dob }" required="required">
					</div>
				</div>
			
			
				<div class="form-group row">
					<div class="col-sm-10">
					<div class="container text-center">
						<button type="submit" class="btn btn-primary">Save</button>
						<!-- <input type="button" class="btn btn-outline-danger" value="Cancel" onclick="history.back()"/> -->
					<!-- 	<input type="button" class="btn btn-outline-danger"  value="Cancel" /> -->
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