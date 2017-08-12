<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>NBakesAndCakes</title>
    <link rel="stylesheet" href="<c:url value="resources/assets/bootstrap/css/bootstrap.min.css"/>">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Cookie">
    <link rel="stylesheet" href="<c:url value="resources/assets/fonts/font-awesome.min.css"/>">
    <link rel="stylesheet" href="<c:url value="resources/assets/css/styles.css"/>">
    <link rel="stylesheet" href="<c:url value="resources/assets/css/Pretty-Footer.css"/>">
    <link rel="stylesheet" href="<c:url value="resources/assets/css/Pretty-Registration-Form.css"/>">
    <link rel="stylesheet" href="<c:url value="resources/assets/css/Google-Style-Login.css"/>">
</head>

<body>
    <div class="row register-form">
        <div class="col-md-8 col-md-offset-2">
            <form:form class="form-horizontal custom-form"  method="POST" action="saveUser" modelAttribute="users">
                <h1>Sign Up</h1>
                <div class="form-group">
                    <div class="col-sm-4 label-column">
                        <form:label path="name" class="control-label" for="name-input-field" >Name </form:label>
                    </div>
                    <div class="col-sm-6 input-column">
                        <form:input path="name" class="form-control" type="text"   required="true" placeholder="enter your name"/>
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-sm-4 label-column">
                        <form:label path="email" class="control-label" for="email-input-field">Email </form:label>
                    </div>
                    <div class="col-sm-6 input-column">
                        <form:input path="email" class="form-control" type="email" placeholder="enter email"/>
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-sm-4 label-column">
                        <form:label path="password" class="control-label" for="pawssword-input-field">Password </form:label>
                    </div>
                    <div class="col-sm-6 input-column">
                        <form:input path="password" class="form-control" type="password" placeholder="enter password"/>
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-sm-4 label-column">
                        <form:label  path="repeat_password" class="control-label" for="repeat-pawssword-input-field">Repeat Password </form:label>
                    </div>
                    <div class="col-sm-6 input-column">
                        <form:input path="repeat_password" class="form-control" type="password" placeholder="repeat password"/>
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-sm-4 col-sm-push-1">
                        <form:label path="contact_number" class="control-label">Contact Number</form:label>
                    </div>
                    <div class="col-sm-6">
                        <form:input path="contact_number" class="form-control" type="tel" placeholder="phone number"/>
                    </div>
                </div>
                <div class="checkbox">
                    <label>
                        <input type="checkbox">I've read and accept the terms and conditions</label>
                </div>
                <button class="btn btn-default submit-button" type="submit">Sign Up</button>
            </form:form>
        </div>
    </div>
    <script src="<c:url value="resources/assets/js/jquery.min.js"/>"></script>
    <script src="<c:url value="resources/assets/bootstrap/js/bootstrap.min.js"/>"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-hover-dropdown/2.2.1/bootstrap-hover-dropdown.min.js"></script>
</body>

</html>