
   <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Rossuie Books-Online Book Store</title>

</head>
<body>
   <jsp:directive.include file="header.jsp"/>
   <div align="center">
   <h1>Please Login:</h1>
   <form>
   Email:<input type="text" size="10"><br/>
   Password:<input type="password" size="10"/><br/>
   <input type="submit" value="Login"/>
   </form>
   </div>
    <jsp:directive.include file="footer.jsp"/>
</body>
</html>