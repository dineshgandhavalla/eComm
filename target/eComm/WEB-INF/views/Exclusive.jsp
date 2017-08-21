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
            <form:form method="POST" action="exclusive.do" encode="multipart/form-data" modelAttribute="exclusive">
                
                    <div class="row">
                    <div class="col-md-offset-3 col-sm-2 col-xs-6">
                        <form:label path="exid" >Product Id </form:label>
                    </div>
                    <div class="col-sm-4 col-xs-6">
                        <form:input path="exid" class="form-control" type="text"/>
                    </div>
                </div>
            
                
                <div class="row">
                    <div class="col-md-offset-3 col-sm-2 col-xs-6">
                        <form:label path="epname" >Product Name </form:label>
                    </div>
                    <div class="col-sm-4 col-xs-6">
                        <form:input path="epname" class="form-control" type="text"/>
                    </div>
                </div>
                <div class="row">
                    <div class="col-md-offset-3 col-sm-2 col-xs-6">
                        <form:label path="epdescription" >Description </form:label>
                    </div>
                    <div class="col-sm-4 col-xs-6">
                        <form:textarea path="epdescription" class="form-control"></form:textarea>
                    </div>
                </div>
                <div class="row">
                    <div class="col-md-offset-3 col-sm-2 col-xs-6">
                        <form:label path="eprice" >Price </form:label>
                    </div>
                    <div class="col-sm-4 col-xs-6">
                        <form:input path="eprice" class="form-control" type="text"/>
                    </div>
               
                
                <div class="row">
                    <div class="col-md-offset-3 col-sm-2 col-xs-6">
                        <form:label path="eximage" >Image </form:label>
                    </div>
    		 
               <div class="col-sm-4 col-xs-6">
              <input type="file" class=" btn btn-default btn-block form-control" name="eximage" />
				</div>
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
	<th>exclusive name</th>
	<th>exclusive desc</th>
	<th>exclusive price</th>

	<th>image</th>
</tr>
</thead>	
<tbody>	
<c:forEach items="${exclusiveList}" var="exclusive">
		<tr>
			<td>${exclusive.exid}</td>
			<td>${exclusive.epname}</td>
			<td>${exclusive.epdescription}</td>
			<td>${exclusive.eprice}</td>
		
			<td><div class="thumbnail">
			<img height="200px" width="200px" atl="${exclusive.exid}"
			src="<c:url value="/resources/images/${exclusive.exid}.jpg"></c:url>">
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