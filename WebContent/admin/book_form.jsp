<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
             <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Create New Book</title>
	<link rel="stylesheet" href="../css/style.css" >
     <script type="text/javascript" src="../js/jquery-3.3.1.min(1).js"></script>
	<script type="text/javascript" src="<../js/jquery.validate.min.js"></script>
</head>
<body>  

<jsp:directive.include file="header.jsp"/>

<div align="center">
         <h2 class="pageheading">
         <c:if test="${book!=null}">
         Edit Book
         </c:if>	
             <c:if test="${book==null}">
             Create New Book
             </c:if>
         </h2>
</div>
<div align="center">
 <c:if test="${book!=null}">
             <form action="update_user" method="post" onsubmit="return validateFormInput()">
            <input type="hidden" name="userId" value="${user.userId}">
   </c:if>
   <c:if test="${book==null}">
         
    <form action="create_user" method="post" onsubmit=" return validateFormInput()">
   </c:if>
    <table class="form">
    
      <tr>
         <td align="right">Category:</td>
         <td align="left">
         <select name="category">
           <c:forEach items="${listCategory }" var="category">
           <option value="${category.categoryId}" >
           ${category.name}

           </c:forEach>
         </select>
         </td>
         </tr>
    
      <tr>
        <td align="right">Title:</td>
        <td align="left"><input type="text"  id="title" name="title" size="20" value="${book.title}"></td>
        
      </tr>
      <tr>
        <td align="right">Author:</td>
        <td align="left"><input type="text" id="author" name="author" size="20" value="${book.author}"></td>
        
      </tr>
      <tr>
        <td align="right">ISBN:</td>
        <td align="left"><input type="text" id="isbn" name="isbn" size="20" value="${book.isbn}"></td>
        
      </tr>
      <tr>
        <td align="right">Publish Date:</td>
        <td align="left"><input type="text" id="publishDate" name="publishDate" size="20" value="${book.publishDate}"></td>
        
      </tr>
      <tr>
        <td align="right">Book Image:</td>
        <td align="left"><input type="file" id="bookImage" name="bookIamge" size="20" ">
        <img id="thumbnail"  alt="Image Preview"/>
        </td>
        
      </tr>
      <tr>
        <td align="right">Price:</td>
        <td align="left"><input type="price" id="password" name="price" size="20" value="${book.price}"></td>
        
      </tr>
      <tr>
        <td align="right">Description:</td>
        <td align="left"><textarea rows="5" col="50" name="description" id="description"></textarea>
        </td>
        
      </tr>
      <tr>
      <tr><td>&nbsp;</td></tr>
      </tr>
    <tr>
      <td colspan="2" align="center">
      <button type="submit">Save</button>&nbsp;&nbsp;&nbsp;
        <input type="button" value="cancel"  onclick="javascript:history.go(-1);">
      </td>
    </tr>
     
    </table>
    </form>

</div>
 <jsp:directive.include file="footer.jsp"/>
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
var fieldfullname=document.getElementById("fullname");
	
	if(fieldfullname.value.length==0){
		alert("fullname is required");
		fieldfullname.focus();
		return false;
	}
	return true;
	
}
  function showImageThumbnail(fileInput){
	  var file=fileInput.files[0];
	  var reader=new FileReader();
	  reader.onload=function(e){
		  $('#thumbnail').attr('src',e.target.result);
		  
	  };
	  reader.readAsDataURL(file);
  }
  $( function() {
	    $( "#publishDate" ).datepicker();
	  } );
</script>
</html>