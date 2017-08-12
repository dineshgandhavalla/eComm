<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>category</title>
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
                    <li class="active" role="presentation"><a href="category">Category </a></li>
                    <li role="presentation"><a href="product">Product </a></li>
                    <li role="presentation"><a href="supplier">Supplier </a></li>
                </ul>
            </div>
        </div>
    </nav>
        <div class="container">
            <div class="well">
            <form:form method="POST" action="category.do" modelAttribute="category">
    
            	 <div class="row">
                    <div class="col-md-offset-3 col-sm-2 col-xs-6">
                        <form:label path="id">Category Id </form:label>
                    </div>
                    <div class="col-sm-4 col-xs-6">
                        <form:input path="id" class="form-control" type="text"/>
                    </div>
                </div>
               
            	
                <div class="row">
                    <div class="col-md-offset-3 col-sm-2 col-xs-6">
                        <form:label path="categoryName">Category Name </form:label>
                    </div>
                    <div class="col-sm-4 col-xs-6">
                        <form:input path="categoryName" class="form-control" type="text"/>
                    </div>
                </div>
                <div class="row">
                    <div class="col-md-offset-3 col-sm-2 col-xs-6">
                        <form:label path="categoryDescription">Category Description </form:label>
                    </div>
                    <div class="col-sm-4 col-xs-6">
                        <form:textarea path="categoryDescription" class="form-control"></form:textarea>
                    </div>
                </div>
                 <div class="row">
                <input type="submit" name="action" value="Add" />
				<input type="submit" name="action" value="Edit" />
				<input type="submit" name="action" value="Delete" />
				<input type="submit" name="action" value="Search" />
                </div>
               <!--  <div class="row">
                    <div class="col-lg-offset-2 col-md-offset-5 col-sm-2 col-xs-4">
                        <button class="btn btn-primary btn-block" type="submit">SAVE</button>
                    </div>
                </div>
 -->            </div>
        </div>
    </form:form>
    
    
    <br>
   <div class="container">
        <div class="well">  
<table class="table table-hover" >
<thead>
<tr>
	<th>ID</th>
	<th>Category name</th>
	<th>Category desc</th>
	</tr>
	</thead>
	<tbody>
	<c:forEach items="${categoryList}" var="category">
		<tr>
			<td>${category.id}</td>
			<td>${category.categoryName}</td>
			<td>${category.categoryDescription}</td>
			
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