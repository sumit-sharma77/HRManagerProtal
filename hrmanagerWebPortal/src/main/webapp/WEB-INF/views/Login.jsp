<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<script type="text/javascript" src="views/js/login.js" ></script>
<title>Login</title>

<style>
<%@include file="/WEB-INF/views/css/login.css"%>
</style>
</head>
<body>
<div class="container footer">
        <h1>Header goes here</h1>
    </div>



    <fieldset>
        <legend>Login</legend>
        <div class="container">
            
            <form name="login_form" action="afterlogin" onSubmit="return validateForm()" method="post">
                <center>
                <table>
                    <tr>
                        <td><label><b>User Id:</b></label></td>
                        <td><input type="text" placeholder="Enter UserId"
                            id="username" name="username" required></td>
                    </tr>
                    <tr>
                        <td><label><b>Password:</b></label></td>
                        <td><input type="password" placeholder="Enter Password"
                            id="password" name="password" required></td>
                    </tr>
                </table>
               
                <button type="submit" name="loginbtn" class="loginbtn" >Login</button>
                
                  <div class="form-login">
			<%
				if (request.getAttribute("authorized") != null) {
			%>
			<h1 class="form " style="color: red" >Invalid User</h1>
			<%
				request.setAttribute("authorized", null);
				}
			%>
		</div>
        	</center>
          </form>
        </div>
    </fieldset>
    <div class="container footer">
        <p>Footer goes here</p>
    </div>
</body>
</html>