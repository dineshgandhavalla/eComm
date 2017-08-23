 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
   
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
        <%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>product</title>
    <link rel="stylesheet" href="<c:url value="resources/assets/bootstrap/css/bootstrap.min.css"/>">
    <link rel="stylesheet" href="<c:url value="resources/assets/css/styles.css"/>">
    <link rel="stylesheet" href="<c:url value="resources/assets/css/category.css"/>">
     <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Cookie">
        <link rel="stylesheet" href="<c:url value="resources/assets/css/Pretty-Footer.css"/>">
        <link rel="stylesheet" href="<c:url value="resources/assets/fonts/font-awesome.min.css"/>">
</head>

<body>
    <nav class="navbar navbar-inverse">
        <div class="container-fluid">
            <div class="navbar-header">
            <a class="navbar-brand navbar-link" href="index"><img src="resources/assets/img/90a3d103aa1d8fc2bff6448dcd2edc53.svg" width="70px" id="logo"> N Bakes &amp; Cakes</a>
             
                <button class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navcol-1"><span class="sr-only">Toggle navigation</span><span class="icon-bar"></span><span class="icon-bar"></span><span class="icon-bar"></span></button>
            </div>
            <div class="collapse navbar-collapse" id="navcol-1">
                <ul class="nav navbar-nav">
                    <li role="presentation"><a href="category">Category </a></li>
                    <li class="active" role="presentation"><a href="product">Product </a></li>
                    <li role="presentation"><a href="supplier">Supplier </a></li>
                    <%-- <sec:authorize access="isAuthenticated()">
                    <li> <a href="<c:url value="j_spring_security_logout" />">Logout</a></li>
                   </sec:authorize> --%>
                </ul>
                  <ul class="nav navbar-nav navbar-right">
                 <sec:authorize access="isAuthenticated()">
                    <li> <a href="<c:url value="j_spring_security_logout" />">Logout</a></li>
                   </sec:authorize>
                   </ul>
            </div>
        </div>
    </nav>
    <div class="container">
        <div class="well">
            <form:form method="POST" action="product.do" modelAttribute="product" enctype="multipart/form-data">
                
                    <div class="row">
                    <div class="col-md-offset-3 col-sm-2 col-xs-6">
                        <form:label path="id" >Product Id </form:label>
                    </div>
                    <div class="col-sm-4 col-xs-6">
                        <form:input path="id" class="form-control" type="text"/>
                    </div>
                </div>
            
                
                <div class="row">
                    <div class="col-md-offset-3 col-sm-2 col-xs-6">
                        <form:label path="product_name" >Product Name </form:label>
                    </div>
                    <div class="col-sm-4 col-xs-6">
                        <form:input path="product_name" class="form-control" type="text"/>
                        <form:errors path="product_name"></form:errors>
                    </div>
                </div>
                <div class="row">
                    <div class="col-md-offset-3 col-sm-2 col-xs-6">
                        <form:label path="description" >Description </form:label>
                    </div>
                    <div class="col-sm-4 col-xs-6">
                        <form:textarea path="description" class="form-control"></form:textarea>
                        <form:errors path="description"></form:errors>
                    </div>
                </div>
                <div class="row">
                    <div class="col-md-offset-3 col-sm-2 col-xs-6">
                        <form:label path="price" >Price </form:label>
                        </div>
                    <div class="col-sm-4 col-xs-6">
                        <form:input path="price" class="form-control" type="text"/>
                         <form:errors path="price"></form:errors>
                  
                    </div>
                </div>
                <div class="row">
                    <div class="col-md-offset-3 col-sm-2 col-xs-6">
                        <form:label path="stock" >Stock </form:label>
                     </div>
                    <div class="col-sm-4 col-xs-6">
                        <form:input path="stock" class="form-control" type="text"/>
                     </div>
                </div>
                
                <div class="row">
                    <div class="col-md-offset-3 col-sm-2 col-xs-6">
                        <form:label path="image" >Image </form:label>
                          <form:errors path="image"></form:errors>
                    </div>
    		 
               <div class="col-sm-4 col-xs-6">
               
               <input type="file" name="file" />
               
           <%--    <form:input type="file" class=" btn btn-default btn-block form-control" path="image" />
 --%>				</div>
	</div>
            
            <div class="row">
            <div class="col-md-offset-3 col-sm-2 col-xs-6">
            <form:label  path="Supid">Supplier</form:label>
            </div>
            
               <div class="col-sm-4 col-xs-6">
            
				<form:select path="Supid" class=" btn btn-default btn-block dropdown-toggle form-control" data-toggle="dropdown" required="true">
						
								<c:forEach items="${supplierList}" var="supplier">
								
									<form:option class="form-control" value="${supplier.id}">${supplier.supplier_name}</form:option>
								</c:forEach>
								
							</form:select>
</div>
</div>
							  
            <div class="row">
            <div class="col-md-offset-3 col-sm-2 col-xs-6">
							<form:label  path="Catid">Category</form:label>
							</div>
						
						<div class="col-sm-4 col-xs-6">
            
						<form:select class="form-control" path="Catid" required="true">
						
								<c:forEach items="${categoryList}" var="category">
								
									<form:option class="form-control" value="${category.id}">${category.categoryName}</form:option>
								</c:forEach>
							</form:select>
					</div>
	</div>
	  <div class="row">
	  <div class="col-md-offset-2 col-sm-8 col-xs-6">
	
                <input class="btn-block" type="submit" name="action" value="Add" />
				<input class="btn-block" type="submit" name="action" value="Edit" />
				<input class="btn-block" type="submit" name="action" value="Delete" />
				<input class="btn-block" type="submit" name="action" value="Search" />
                </div>
    </div>     
 </form:form>
</div>

</div>   

 
    
    
     <br>
<div class="container">
        <div class="well">     
		<table class ="table table-hover ">
		<thead>
		<tr>
	<th>ID</th>
	<th>Product name</th>
	<th>Product desc</th>
	<th>product price</th>
	<th>product stock</th>
	<th>image</th>
</tr>
</thead>	
<tbody>	
<c:forEach items="${productList}" var="product">
		<tr>
			<td>${product.id}</td>
			<td>${product.product_name}</td>
			<td>${product.description}</td>
			<td>${product.price}</td>
			<td>${product.stock}</td>
			<td><div class="thumbnail">
			<img src="/eComm/myImage/imageDisplay?id=${product.id}" alt="" width="298" height="398" />
			</div></td>
			
			
		</tr>
	</c:forEach>
	</tbody>	
	
</table>
</div>
</div>
<div 
   <c:import url="/WEB-INF/views/footer.jsp" />>
</div>

    <script src="<c:url value="resources/assets/js/jquery.min.js"/>"></script>
    <script src="<c:url value="resources/assets/bootstrap/js/bootstrap.min.js"/>"></script>
</body>

</html>