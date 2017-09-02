<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
            <%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>supplier</title>
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
                    <li role="presentation"><a href="product">Product </a></li>
                    <li class="active" role="presentation"><a href="supplier">Supplier </a></li>
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
            <form:form method="POST" action="supplier.do" modelAttribute="supplier">
                
                <div class="row">
                    <div class="col-md-offset-4 col-sm-2 col-xs-6">
                        <form:label path="id">Supplier Id </form:label>
                    </div>
                        <div class="col-sm-4 col-xs-6">
                        <form:input path="id" class="form-control" type="text"/>
                    </div>
               </div>
                <div class="row">
                    <div class="col-md-offset-4 col-sm-2 col-xs-6">
                        <form:label path="supplier_name" >Supplier name </form:label>
                    </div>
                    <div class="col-sm-4 col-xs-6">
                        <form:input path="supplier_name" class="form-control" type="text"/>
                    </div>
                </div>
                 <div class="row" align="center">
                <button class="btn btn-warning" type="submit" name="action" value="Add" ><span class="glyphicon glyphicon-plus"></span></button>
				<button class="btn btn-warning" type="submit" name="action" value="Edit" ><span class="glyphicon glyphicon-edit"></span></button>
				<button class="btn btn-warning" type="submit" name="action" value="Delete" ><span class="glyphicon glyphicon-trash"></span></button>
				<button class="btn btn-warning" type="submit" name="action" value="Search" ><span class="glyphicon glyphicon-search"></span></button>
                </div>
            </form:form>
             </div>
            </div>
            <br>
            
            <div class="container">
        <div class="well">  
<table class="table table-hover">
<thead>
<tr>
	<th>ID</th>
	<th>Supplier name</th>
</tr>
</thead>
<tbody>	
	<c:forEach items="${supplierList}" var="supplier">
		<tr>
			<td>${supplier.id}</td>
			<td>${supplier.supplier_name}</td>
			
			
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