+ <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 
  <div align="center">
             <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  

<div align="center">

</div>

		<img src=" <c:url value='../images/BookstoreAdminLogo.png'/>" />	
<div>
      Welcome,<c:out value="${sessionScope.useremail}"/>|<a href="logout">logout</a>
      <br><br/>
</div>
<div id="headermenu">
    <div  style="display:table-cell ;padding-right:20px;">
         <a href="list_user">
         <img src="../images/user.png" /><br/>Users
         </a>
    
    </div>
    
    <div  style="display:table-cell;padding-right:20px;" />
           <a href="list_category">
           <img src="../images/category.png" /><br/>Categories
           </a>
      
    </div>
    
    <div style="display:table-cell;padding-right:20px;" / >
           <a href="list_books       ">
           <img src="../images/images%20(1).jpg" /><br/>Books
           </a>
      
    </div>
    
    <div style="display:table-cell;padding-right:20px;" /  >
           <a href="customer">
           <img src="../images/customer.png" /><br/>Customers
           </a>
      
    </div>
    
    <div style="display:table-cell;padding-right:20px;" / >
           <a href="reviews">
           <img src="../images/review.png" /><br/>Reviews
           </a>
      
    </div>
    
     <div style="display:table-cell;padding-right:20px;" / >
           <a href="Orders">
           <img  src="<c:url value='./images/order.jpg '/>"><br/>Orders
           </a>
      
    </div>
    
</div>
</div>