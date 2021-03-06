<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>N BakesAndCakes</title>
    <link rel="stylesheet" href="<c:url value="/resources/assets/bootstrap/css/bootstrap.min.css"/>">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Cookie">
    <link rel="stylesheet" href="<c:url value="/resources/assets/fonts/font-awesome.min.css"/>">
    <link rel="stylesheet" href="<c:url value="/resources/assets/css/styles.css"/>">
    <link rel="stylesheet" href="<c:url value="/resources/assets/css/Pretty-Footer.css"/>">
    <link rel="stylesheet" href="<c:url value="/resources/assets/css/Pretty-Registration-Form.css"/>">
    <link rel="stylesheet" href="<c:url value="/resources/assets/css/Google-Style-Login.css"/>">
    <style>
    div.modal-content{
    max-width:75%;
   
    }
    
    </style>
</head>

<body>
${error}
${logout }
   <nav class="navbar navbar-inverse navbar-fixed-top">
        <div class="container">
            <div class="navbar-header">
                <a class="navbar-brand navbar-link" href="index"><img src="resources/assets/img/90a3d103aa1d8fc2bff6448dcd2edc53.svg" width="70px" id="logo"> N Bakes &amp; Cakes</a>
                <button class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navcol-1"><span class="sr-only">Toggle navigation</span><span class="icon-bar"></span><span class="icon-bar"></span><span class="icon-bar"></span></button>
            </div>
            <div class="collapse navbar-collapse" id="navcol-1">
                <ul class="nav navbar-nav navbar-right">
                    <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" aria-expanded="false" href="#" data-hover="dropdown">Menu<i class="glyphicon glyphicon-align-justify"></i> <span class="caret hidden"></span></a>
                        <ul class="dropdown-menu" role="menu">
                        <c:forEach items="${categoryList}" var="category">
                            <li role="presentation"><a href="product${category.id}">${category.categoryName}</a></li>
                            </c:forEach>
                        </ul>
                    </li>

 			 <sec:authorize access="!isAuthenticated()">                
 	    			<li role="presentation"><a href="login">Login <i class="glyphicon glyphicon-log-in"></i></a></li>
                    <li role="presentation"><a href="signup">SignUp <i class="glyphicon glyphicon-user"></i></a></li>
             </sec:authorize>
            
             <sec:authorize access="isAuthenticated()">
            		  <li class="active" role="presentation"><a href="cart">Shop<i class="glyphicon glyphicon-shopping-cart"></i><%--  <span class="badge">${size}</span> --%></a></li>
                      <li class="dropdown">
                        <a class="dropdown-toggle" data-toggle="dropdown" aria-expanded="true" href="#" data-hover="dropdown" > <i class="glyphicon glyphicon-user"></i><!-- <span class="caret"></span> --></a>
                        <ul class="dropdown-menu" role="menu">
                            <li role="presentation"><a href="#">My Account</a></li>
                            <li role="presentation"><a href="myorders">My Orders</a></li>
                            <li> <a href="<c:url value="j_spring_security_logout" />">Logout</a></li>
                        </ul>
                    </li>
                      
             </sec:authorize>

                </ul>
            </div>
        </div>
    </nav>
<!--End of Navbar (header) -->
    <br>
    <br>
    <br>

  <div class="jumbotron">
  <h1>N Bakes & Cakes Welcomes you</h1>      
  <p>One Destination for all your Celebrations</p>
</div>

   <div class="carousel slide" data-ride="carousel" id="carousel-1">
      <div class="carousel-inner" role="listbox">
            <div class="item">
            <img class="img-responsive" src="resources/assets/img/choc-salted-caramel-cake2.jpg" alt="Slide Image" ></div>
            <div class="item"><img src="resources/assets/img/cupcake.jpg" alt="Slide Image" ></div>
            <div class="item active"><img src="resources/assets/img/food-wood-coffee-cup.jpg" alt="Slide Image" ></div>
        </div>
        
        <div>
        <a class="left carousel-control" href="#carousel-1" role="button" data-slide="prev"><i class="glyphicon glyphicon-chevron-left"></i><span class="sr-only">Previous</span></a>
        <a class="right carousel-control" href="#carousel-1" role="button" data-slide="next"><i class="glyphicon glyphicon-chevron-right"></i><span class="sr-only">Next</span></a>
        </div>
        
        <ol class="carousel-indicators">
            <li data-target="#carousel-1" data-slide-to="0"></li>
            <li data-target="#carousel-1" data-slide-to="1"></li>
            <li data-target="#carousel-1" data-slide-to="2" class="active"></li>
        </ol>
    </div>
    <!-- End of Carousels --> 
    <br>
     <div>
        <h1 class="text-center text-info">Exclusive Deals<i class="glyphicon glyphicon-tags"></i></h1>
	</div>
    <br>
     <div class="container-fluid">
     <div >
        <div class="row">
     <c:forEach items="${HomeList}" var="product">
            <div class="col-md-4 col-sm-3">
                <div class="thumbnail"><img src="/eComm/myImage/imageDisplay?id=${product.id}" alt="" width="298" height="398" />
                <div class="caption">
                        <h3>${product.product_name}</h3>
                        <ul>
                        <li>Price: Rs.<Strong>${product.price}</Strong></li>
                    		<form:form action="addToCart/${product.id}">
                                <button type="submit" value="Add to Cart" class="btn btn-primary btn-lg btn-cart"><span class="glyphicon glyphicon-shopping-cart"></span> Add to Cart </button>
                                 
          </form:form>
          <div>                 
                                <button class="btn btn-primary btn-lg btn-cart" data-toggle="modal" data-target="#${product.id}" type="button">More details</button>
    							   
    							<div class="modal fade" id="${product.id}" role="dialog" tabindex="-1">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">�</span></button>
                    
    							   
                    <h4 class="modal-title">${product.product_name}</h4></div>
                <div class="modal-body">
             		
                <div class="thumbnail"><img src="/eComm/myImage/imageDisplay?id=${product.id}" alt="" width="200" height="300" />
                     <ul>
               
                  <p>${product.description}</p>
                    <li>Price: Rs.<Strong>${product.price}</Strong></li>
                                  	</ul>
                  <div class="col-xs-offset-2 col-xs-12">
               </div>                    
        </div>
                </div>
                <div class="modal-footer">
                    <button class="btn btn-default" type="button" data-dismiss="modal">Close</button>
                    <form:form action="addToCart/${product.id}">
                     <button type="submit" value="Add to Cart" class="btn btn-primary btn-lg btn-cart"><span class="glyphicon glyphicon-shopping-cart"></span> Add to Cart </button>
              		</form:form>
                </div>
            </div>
        </div>
   </div>   
                   </ul>
                    </div>
                </div>
               
            </div>
            
         </c:forEach>
                </div>
            </div>
        </div>
        
        
        <div class="container">
        <div id="map" style="width:100%;height:300px"></div>
        </div>
        
        <script>
function myMap() {
  var myCenter = new google.maps.LatLng(17.4836979,78.3158338);
  var mapCanvas = document.getElementById("map");
  var mapOptions = {center: myCenter, zoom: 5};
  var map = new google.maps.Map(mapCanvas, mapOptions);
  var marker = new google.maps.Marker({position:myCenter});
  marker.setMap(map);

  // Zoom to 9 when clicking on marker
  google.maps.event.addListener(marker,'click',function() {
    map.setZoom(9);
    map.setCenter(marker.getPosition());
  });
}
</script>

<script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyALCNrf2vvP9ECAFAWh0I4OQIhnLLFTKoE&callback=myMap"></script>
        
    
    <footer class="navbar">
        <div class="row">
            <div class="col-md-4 col-sm-6 footer-navigation">
                <h3 class="text-center"> N Bakes &amp; Cakes</h3>
                <p class="text-center links"><a href="#">Home</a><strong> � </strong><a href="#">Gallery </a><strong> � </strong><a href="#">About</a><strong> � </strong><a href="#">Faq</a><strong> � </strong><a href="#">Contact</a></p>
                <p class="text-center company-name"> N Bakes&amp;Cakes � 2017 </p>
            </div>
            <div class="col-md-4 col-sm-6 footer-contacts">
                <div><span class="fa fa-map-marker footer-contacts-icon"> </span>
                    <p> Lingampally,Hyderbad,India</p>
                </div>
                <div><i class="fa fa-phone footer-contacts-icon"></i>
                    <p class="footer-center-info email text-left"> +91 9160 596953</p>
                </div>
                <div><i class="fa fa-envelope footer-contacts-icon"></i>
                    <p> <a href="#" target="_blank">NBCOnline@Gmail.com</a></p>
                </div>
            </div>
            <div class="clearfix visible-sm-block"></div>
            <div class="col-md-4 footer-about">
                <h4 class="text-center">About Us</h4>
                <p class="text-justify"> We N Bakes&amp;Cakes provides a variety of cakes and desserts with lots of customization options, We have a variety of premium and exotic flavors for customization in every dishes we serve.Our motto is to make ur dream thoughts into actions.
                </p>
                <div class="social-links social-icons"><a href="#"><i class="fa fa-facebook"></i></a><a href="#"><i class="fa fa-twitter"></i></a><a href="#"><i class="fa fa-linkedin"></i></a><a href="#"><i class="fa fa-github"></i></a></div>
            </div>
        </div>
    </footer>
   	 <script src="<c:url value="/resources/assets/js/nav.js"/>"></script>
     <script src="<c:url value="resources/assets/js/jquery.min.js"/>"></script>
    <script src="<c:url value="resources/assets/bootstrap/js/bootstrap.min.js"/>"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-hover-dropdown/2.2.1/bootstrap-hover-dropdown.min.js"></script>
</body>

</html>