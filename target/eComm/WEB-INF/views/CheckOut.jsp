
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
    
<title>Card Payment</title>

 <%-- <link rel="stylesheet" href="<c:url value="/resources/assets/bootstrap/css/bootstrap.min.css"/>">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Cookie">
    <link rel="stylesheet" href="<c:url value="/resources/assets/fonts/font-awesome.min.css"/>">
    <link rel="stylesheet" href="<c:url value="/resources/assets/css/styles.css"/>">
     <link rel="stylesheet" href="<c:url value="/resources/assets/css/Pretty-Registration-Form.css"/>">
   
    <link rel="stylesheet" href="<c:url value="/resources/assets/css/Google-Style-Login.css"/>">
    

<style type="text/css">
		.submit-button {
  margin-top: 10px;
}

.checkOut-card{
  max-width:1000px;
  background-color:rgba(125,192,207,0.75);
  margin:0 auto 25px;
  margin-top:150px;
  border-radius:2px;
  border-radius:20px;
  box-shadow:0px 2px 2px rgba(0, 0, 0, 0.3);
}


	</style>

</head>
<body>
<div class="container">
<div class="checkOut-card">

    <div class='row'>
    	
        <div class='col-md-4'></div>
        <div class='col-md-4'>
        <script src="<c:url value="resources/assets/js/cardscript.js"/>"></script>
     <form:form  action="invoice" var="cart"   method="POST">
     
     <div style="margin:0;padding:0;display:inline"><input name="utf8" type="hidden" value="✓" />
    <!--  <input name="_method" type="hidden" value="PUT" />
     <input name="authenticity_token" type="hidden" value="qLZ9cScer7ZxqulsUWazw4x3cSEzv899SP/7ThPCOV8=" /></div>
     -->        <div class='form-row'>
              <div class='col-xs-12 form-group required'>
                <label class='control-label'>Name on Card</label>
                <input class='form-control' size='4' type='text'>
              </div>
            </div>
            <div class='form-row'>
              <div class='col-xs-12 form-group card required'>
                <label class='control-label'>Card Number</label>
                <input autocomplete='off' class='form-control card-number' size='20' type='text'>
              </div>
            </div>
            <div class='form-row'>
              <div class='col-xs-4 form-group cvc required'>
                <label class='control-label'>CVV</label>
                <input autocomplete='off' class='form-control card-cvc' placeholder='ex. 311' size='4' type='text'>
              </div>
              <div class='col-xs-4 form-group expiration required'>
                <label class='control-label'>Expiration</label>
                <input class='form-control card-expiry-month' placeholder='MM' size='2' type='text'>
              </div>
              <div class='col-xs-4 form-group expiration required'>
                <label class='control-label'> Year</label>
                <input class='form-control card-expiry-year' placeholder='YYYY' size='4' type='text'>
              </div>
            </div>
            <div class='form-row'>
              <div class='col-md-12'>
                <div class='form-control total btn btn-info'>
                  Total:
                  <span class='amount'>Rs.${total}</span>
                </div>
              </div>
            </div>
            <div class='form-row'>
              <div class='col-md-12 form-group'>
                <button class='form-control btn btn-primary submit-button' type='submit'>Pay with card</button>
              </div>
            </div>
            <div class='form-row'>
              <div class='col-md-12 error form-group hide'>
                <div class='alert-danger alert'>
                  Please correct the errors and try again.
                </div>
              </div>
            </div>
          </form:form>
        </div>
        <div class='col-md-4'></div>
    </div>
</div>
</div>
 <script src="<c:url value="resources/assets/js/jquery.min.js"/>"></script>
    <script src="<c:url value="resources/assets/bootstrap/js/bootstrap.min.js"/>"></script>
   

</body> --%>

<link rel="stylesheet" href="<c:url value="/resources/assets/bootstrap/css/bootstrap.min.css"/>">
    <link rel="stylesheet" href="<c:url value="/resources/assets/fonts/font-awesome.min.css"/>">
   <link rel="stylesheet" href="assets/css/styles.css">
   <!--   <link rel="stylesheet" href="assets/css/invoice.css">
    -->  <link rel="stylesheet" href="<c:url value="/resources/assets/css/Bootstrap-Payment-Form.css"/>">
    <link rel="stylesheet" href="<c:url value="/resources/assets/css/payment.css"/>">
</head>

<body>
    <div class="container">
 
        <div class="col-xs-offset-2 col-xs-12">       
             <div class="form-group">
                 <label class="control-label" for="total"><h3><strong>Grand Total :${total}</strong></h3></label>
                </div>
                </div>                    
        
            <div class="row .payment-dialog-row" id="checkOut-box">
                <div class="col-md-4 col-md-offset-4 col-xs-12">
                    <div class="panel panel-default credit-card-box">
                        <div class="panel-heading">
                            <h3 class="panel-title"><span class="panel-title-text">Payment Details </span><img class="img-responsive panel-title-image" src="<c:url value="/resources/assets/img/accepted_cards.png"/>"></h3></div>
                        <div class="panel-body">
                            <form:form id="payment-form" method = "POST" modelAttribut="card" action="/cardPay/{id}" >
                            <div class="row">
                                    <div class="col-xs-12">
                                        <div class="form-group">
                                        	<form:label class="control-label" path="card_name" >Name on Card</form:label>
                                            <div class="input-group">
                                               <form:input class="form-control" type="text" path="card_name" required="" placeholder="Name on Your Card" id="cardName"/>
                                                <div class="input-group-addon"><span><i class="fa fa-user"></i></span></div>
                                                </div>
                                             </div>
                                        </div>
                                    </div>

                                <div class="row">
                                    <div class="col-xs-12">
                                        <div class="form-group">
                                            <form:label class="control-label" path="card_number" >Card number </form:label>
                                            <div class="input-group">
                                                <form:input class="form-control" type="tel" path="card_number" required="" placeholder="Valid Card Number" id="cardNumber"/>
                                                <div class="input-group-addon"><span><i class="fa fa-credit-card"></i></span></div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="col-xs-7">
                                        <div class="form-group">
                                            <label class="control-label" for="cardExpiry"><span class="hidden-xs">expiration </span><span class="visible-xs-inline">EXP </span> date</label>
                                            <input class="form-control" type="tel" required="" placeholder="MM / YY" id="cardExpiry">
                                        </div>
                                    </div>
                                    <div class="col-xs-5 pull-right">
                                        <div class="form-group">
                                            <label class="control-label" for="cardCVC">CVV code</label>
                                            <input class="form-control" type="tel" required="" placeholder="CVV" id="cardCVC">
                                        </div>
                                    </div>
                                </div>
                                <%-- <form:form  action="invoice" var="cd"   method="GET">
     --%>
                                <div class="row">
                                    <div class="col-xs-12">
                                    <!--  <input type="submit" value="Pay with Card" class="btn btn-success">
                                     -->   <a class="btn btn-success btn-block btn-lg" href="invoice" role="button" type="submit">Pay With Card</a> 
                                    </div>
                                </div>
                          </form:form>
                        </div>
                    </div>
                </div>
            </div>
   
   <br>
    <form:form id="payment-form" action="/cardPay/{id}">

  	<div class="row">
    <div class="col-md-4 col-md-offset-4 col-sm-4 col-sm-offset-4">
        <button class="btn btn-warning btn-block" data-toggle="modal" data-target="#myModal" type="button">Cash on Delivery</button>
    </div></div>
    <div class="modal fade" id="myModal" role="dialog" tabindex="-1">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">X</span></button>
                    <h4 class="modal-title">Cash On Delivery</h4></div>
                <div class="modal-body">
                    <p>A Shipping Charge of <Strong>Rs.99/-</Strong> is applicable for Cash on Delivery</p>
                </div>
                <div class="modal-footer">
                    <button class="btn btn-default" type="button" data-dismiss="modal">Close</button>
                    <a href="invoice" role="button" class="btn btn-success" type="submit">Agree & Place the Order</a>
                </div>
            </div>
        </div>
        
    </div>
   </form:form>
 
    </div>
    
    <script src="<c:url value="/resources/assets/js/jquery.min.js"/>"></script>
    <script src="<c:url value="/resources/assets/bootstrap/js/bootstrap.min.js"/>"></script>
</body>

 
</html>