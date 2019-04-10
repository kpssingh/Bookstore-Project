<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
             <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>admin Login</title>
<link rel="stylesheet" href="file:///C:/Users/krishna/Desktop/servlet/BookStoreWebsite/WebContent/css/style.css">
</head>
<body>
   <div align="center" >
      <h2> Book Store Administration</h2>
      <h1>Admin Login</h1>
        <c:if test="${message != null}">
			<div align="center">
				<h4 class="message">${message}</h4>
			</div>
		</c:if>
		
      <form  action="login" method="post" onsubmit=" return validateFormInput()">
      <table>
      <tr>
        <td>Email:</td>
        <td><input type="text" name="email" id="email" size="20"></td>
        </tr>
        <tr>
       <td>Password:</td>
        <td><input type="password" name="password" id="password" size="20"></td>
        </tr>
        <tr>
        <td colspan="2" align="center">
        
        <button type="submit">Login</button>
        </td>
        </tr> 
        <tr>
        
      </table>
      </form>
   
   </div>
</body>
<script type="text/javascript">
  
function validateFormInput(){
	var fieldEmail=document.getElementById("email");
	
	if(fieldEmail.value.length==0){
		alert("Email is required");
		fieldEmail.focus();
		return false;
	}
	
var fieldpassword=document.getElementById("password");
	
	if(fieldpassword.value.length==0){
		alert("password is required");
		fieldpassword.focus();
		return false;
	}

	return true;
	
}
  
</script>
</html>