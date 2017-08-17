<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cart Details</title>
</head>
<body>
<c:forEach items="${cartList}" var="cd">
 
            
                <div class="col-md-4 col-md-offset-0">
                    <div>
                        <div class="row">
                            <%-- <div class="col-md-12"><img atl="${cd.id}"
			src="<c:url value="/resources/images/${product.id}.jpg"></c:url>">></div>
                             --%><div class="col-md-12">
                                <h4>${cd.id}</h4>
                                <p>
                                <ul>
                                <li> ${cd.productname}</li>
                                <li> ${cd.subTotal}</li>
                               
                               <%--  <li>
                                <form:form action="addToCart/${product.id}" method="POST">
                                <input type="submit" value="Add to Cart" class="btn btn-primary">
                                </form:form>
                                </li>
                                </ul></p>
                            </div>
                        </div> --%>
                    </div>
                
                </div>
                
           </c:forEach>
        </div>


</body>
</html>