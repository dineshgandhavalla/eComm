<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>product</title>
    <link rel="stylesheet" href="<c:url value="resources/assets/bootstrap/css/bootstrap.min.css"/>">
    <link rel="stylesheet" href="<c:url value="resources/assets/css/styles.css"/>">
    <link rel="stylesheet" href="<c:url value="resources/assets/css/category.css"/>">
</head>

<body>
    <nav class="navbar navbar-inverse">
        <div class="container-fluid">
            <div class="navbar-header">
                <button class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navcol-1"><span class="sr-only">Toggle navigation</span><span class="icon-bar"></span><span class="icon-bar"></span><span class="icon-bar"></span></button>
            </div>
            <div class="collapse navbar-collapse" id="navcol-1">
                <ul class="nav navbar-nav">
                    <li role="presentation"><a href="category">Category </a></li>
                    <li class="active" role="presentation"><a href="product">Product </a></li>
                    <li role="presentation"><a href="supplier">Supplier </a></li>
                </ul>
            </div>
        </div>
    </nav>
    <div class="container">
        <div class="well">
            <form:form method="POST" action="product.do" encode="multipart/form-data" modelAttribute="product">
                <div class="row">
                    <div class="col-md-offset-3 col-sm-2 col-xs-6">
                        <form:label path="product_name" >Productname </form:label>
                    </div>
                    <div class="col-sm-4 col-xs-6">
                        <form:input path="product_name" class="form-control" type="text"/>
                    </div>
                </div>
                <div class="row">
                    <div class="col-md-offset-3 col-sm-2 col-xs-6">
                        <form:label path="description" >Description </form:label>
                    </div>
                    <div class="col-sm-4 col-xs-6">
                        <form:textarea path="description" class="form-control"></form:textarea>
                    </div>
                </div>
                <div class="row">
                    <div class="col-md-offset-3 col-sm-2 col-xs-6">
                        <form:label path="price" >Price </form:label>
                    </div>
                    <div class="col-sm-4 col-xs-6">
                        <form:input path="price" class="form-control" type="text"/>
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
                    </div>
    		 
               <div class="col-sm-4 col-xs-6">
              <form:input type="file" class=" btn btn-default btn-block form-control" path="image" />
				</div>
	</div>
            
            <div class="row">
            <form:label class="btn btn-default btn-block" path="Supid">Supplier</form:label>
				<form:select path="Supid" class="form-control" required="true">
						
								<c:forEach items="${supplierList}" var="supplier">
								
									<form:option class="form-control" value="${supplier.id}">${supplier.supplier_name}</form:option>
								</c:forEach>
								
							</form:select>
							<form:label class="btn btn-default btn-block" path="Catid">Category</form:label>
						<br>
						<form:select class="form-control" path="Catid" required="true">
						
								<c:forEach items="${categoryList}" var="category">
								
									<form:option class="form-control" value="${category.id}">${category.categoryName}</form:option>
								</c:forEach>
							</form:select>
					
	</div>
	
	
	<!-- 
	 <tr>
                    <td>Pick file #1:</td>
                    <td><input type="file" name="fileUpload" size="50" /></td>
                </tr>
	 -->						
							<%--  <div class="row">
                    <div class="col-md-offset-3 col-sm-2 col-xs-6">
                        <form:label path="img" >image </form:label>
                    </div>
                    <div class="col-sm-4 col-xs-6">
                        <form:input path="img" class="form-control" type="file"/>
                    </div> --%>
                </div>
							
    <!--             <div class="col-md-offset-5 col-sm-2">
                    <button class="btn btn-primary btn-block" type="submit">SAVE</button>
                </div>
     -->    
      <div class="row">
                <input type="submit" name="action" value="Add" />
				<input type="submit" name="action" value="Edit" />
				<input type="submit" name="action" value="Delete" />
				<input type="submit" name="action" value="Search" />
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
			<img height="100px" width="100px" atl="${product.id}"
			src="<c:url value="/resources/images/${product.id}.jpg"></c:url>">
			</div></td>
			
			
		</tr>
	</c:forEach>
	</tbody>	
	
</table>
</div>
</div>

    <script src="<c:url value="resources/assets/js/jquery.min.js"/>"></script>
    <script src="<c:url value="resources/assets/bootstrap/js/bootstrap.min.js"/>"></script>
</body>

</html>