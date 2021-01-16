<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@include file="./baselinks.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home Page</title>

<%-- <link href="<c:url value="/views/css/home.css"></c:url>"> --%>
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
	<legend class="scheduler-border">Employee Listings</legend>
		<div align="right">
		<form action="" method="post" >	
			<button name="uploadEmpDetails" formaction="addEmpPage">Upload
				Employee Details</button>
			<button name="downloadEmpDetails" formaction="export-pdf">Download Employee Details</button>
		</form>
		</div>
		
		<table class="table " id="myTable">
			<thead class="thead-light">
				<tr>
					<th scope="col">Employee Code</th>
					<th scope="col">Employee Name</th>
					<th scope="col">Location</th>
					<th scope="col">Email</th>
					<th scope="col">Date Of Birth</th>
					<th scope="col">Action</th>
				</tr>
			</thead>
			<tbody>
						<c:forEach items="${employee }" var="p">
							<tr>
								<th scope="row">${p.empCode }</th>
								<td>${p.empName }</td>
								<td>${p.loc }</td>
								<td>${p.email }</td>
								<td>${p.dob }</td>
								<td><a href="edit/${p.empCode }">Edit</a></td>
							</tr>
						</c:forEach>
					</tbody>
		</table>
		</fieldset>
	</div>
	
	 <div class="container footer">
    <p>Footer goes here</p>
  </div>
</body>
</html>