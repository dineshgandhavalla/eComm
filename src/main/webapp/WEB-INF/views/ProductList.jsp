<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
        <%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head> 
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Product List</title>
<link rel="stylesheet" href="<c:url value="resources/assets/bootstrap/css/bootstrap.min.css"/>">
    <link rel="stylesheet" href="<c:url value="resources/assets/css/styles.css"/>">
    <link rel="stylesheet" href="<c:url value="resources/assets/css/category.css"/>">


</head>
<body>

<div 
   <c:import url="/WEB-INF/views/header.jsp"/>>

</div>


<div class="container">
<div class="well well-lg">
<c:forEach items="${prodList}" var="product">

            
                <div class="col-md-4 col-md-offset-0">
                    <div>
                        <div class="row">
                            <div class="col-md-12"><img atl="${product.id}"
			src="<c:url value="/resources/images/${product.id}.jpg"></c:url>">></div>
                            <div class="col-md-12">
                                <h4>${product.product_name}</h4>
                                <p>
                                <ul>
                                <li> ${product.price}</li>
                                <li> ${product.description}</li>
                               
                                <li>
                                <form:form action="addToCart/${product.id}" method="POST">
                                <input type="submit" value="Add to Cart" class="btn btn-primary">
                                </form:form>
                                </li>
                                </ul></p>
                            </div>
                        </div>
                    </div>
                
                </div>
                
           </c:forEach>
        </div>
        
        <%-- <div class="well">     
		<table class ="table table-hover ">
		<thead>
		<tr>
	
	<th>Product name</th>
	<th>Product desc</th>
	<th>product price</th>
	<th>image</th>
</tr>
</thead>	
<tbody>	
<c:forEach items="${prodList}" var="product">
		<tr>
			<td>${product.product_name}</td>
			<td>${product.description}</td>
			<td>${product.price}</td>
			<td><div class="thumbnail">
			<img height="200px" width="200px" atl="${product.id}"
			src="<c:url value="/resources/images/${product.id}.jpg"></c:url>">
			</div></td>
			
			
		</tr>
	</c:forEach>
	</tbody>	
	
</table>
</div>
 --%></div>


<script src="<c:url value="resources/assets/js/jquery.min.js"/>"></script>
    <script src="<c:url value="resources/assets/bootstrap/js/bootstrap.min.js"/>"></script>



</body>
</html>