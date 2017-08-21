<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
   
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Invoice</title>
 <link rel="stylesheet" href="<c:url value="/resources/assets/bootstrap/css/bootstrap.min.css"/>">
    <link rel="stylesheet" href="<c:url value="/resources/assets/css/styles.css"/>">
    <link rel="stylesheet" href="<c:url value="/resources/assets/css/invoice.css"/>">

</head>
<body>
<div id= "printableArea">
 <form:form modelAttribute="user" commandName="user">
<div class="container">
        <div class="well">
       
            <div class="row">
            
                <div class="col-md-4">
                    <label>Name:${user.name} </label>
                </div> 
            </div>
            <div class="row">
                <div class="col-md-4">
                    <label>email:${user.email} </label>
                </div>
            </div>
            <div class="row">
                <div class="col-md-4">
                    <label>contact no:${user.contact_number} </label>
                </div>
            </div>
            <div class="row">
                <div class="col-md-4">
                    <label>Shipping Address:${user.address} </label>
                </div>
            </div>
            <hr>
        </div>
    </div>
    </form:form>
     <div class="container">
        <div class="well">     


		<table class ="table table-hover ">
		<thead>
		<tr>
	
	<!-- <th>image</th>
	
	 --><th>Product name</th>
	<th>product price</th>
	<th>Quantity</th>
	<th>SubTotal</th>

	
	
</tr>
</thead>	
<tbody>	
<c:forEach items="${cd}" var="cd">
		<tr>
			<%-- <td>${cd.id}</td>
			 --%><td>${cd.productname}</td>

			<td>${cd.productprice}</td>
			<td>${cd.quantity}</td>
			<td>${cd.subTotal}</td>
				
			
			<%-- <td><div class="thumbnail">
			<img height="200px" width="200px" atl="${product.id}"
			src="<c:url value="/resources/images/${product.id}.jpg"></c:url>">
			</div></td> --%>
			
			
		</tr>
</c:forEach>	
	</tbody>	
	
</table>


	

     <div class='form-control'>
                  Total:
                  <span class='amount'>Rs.${total}</span>
                </div>  
 
  
 </div>
 
</div>
</div>
<div class="row">
<div class="col-md-offset-2 col-md-2">
<button class="btn btn-info" onclick="printDiv('printableArea')">Print Invoice</button>
</div>
<div class="col-md-4"></div>

       <!-- <button class="btn btn-danger">Continue Shopping</button> -->
       <a href="index" class="btn btn-danger" role="button">Continue Shopping</a>
     
 </div>
 	<script src="<c:url value="/resources/assets/js/print.js"/>"></script>
    
    <script src="<c:url value="/resources/assets/js/jquery.min.js"/>"></script>
    <script src="<c:url value="/resources/assets/bootstrap/js/bootstrap.min.js"/>"></script>

</body>
</html>