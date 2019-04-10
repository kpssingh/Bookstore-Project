<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
         <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Manage Category-Evergreen BookStore Administration</title>
<link rel="stylesheet" href="../css/style.css">
</head>
<body>  

<jsp:directive.include file="header.jsp"/>
<div align="center">
<h1 class="pageheading">Category Management</h1>
<a href="category_form.jsp">Create New Category</a>
</div>
<div align="center">
<h4 class="message"><i>${message}</i></h4>
</div>
<div align="center">
<table border="1"  cellpadding="5">
<tr>
<th>index</th>
<th>ID</th>
<th> Name</th>
<th>Action</th>
</tr>
<c:forEach var="cat" items="${listCategory}" varStatus="status">
    <tr>
       <td>${status.index+1}</td>
       <td>${cat.categoryId}</td>
       <td>${cat.name}</td>
       <td>
       <a href="edit_category?id=${cat.categoryId}">Edit</a>&nbsp;
       <a href="javascript:confirmDelete(${cat.categoryId})">Delete</a>
       </td>
       
    </tr>
</c:forEach>
</table>
</div>
<div align="center">

</div>
 <jsp:directive.include file="footer.jsp"/>
 <script>
    function confirmDelete(categoryId){
       if(confirm('Are you sure you want to delete the category with ID= ' +categoryId+' ?')){
    	   window.location='delete_category?id='+categoryId;
       }
    }
 </script>
</body>
</html>