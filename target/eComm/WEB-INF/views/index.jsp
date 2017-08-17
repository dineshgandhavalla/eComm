<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>N BakesAndCakes</title>
    <link rel="stylesheet" href="<c:url value="resources/assets/bootstrap/css/bootstrap.min.css"/>">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Cookie">
    <link rel="stylesheet" href="<c:url value="resources/assets/fonts/font-awesome.min.css"/>">
    <link rel="stylesheet" href="<c:url value="resources/assets/css/styles.css"/>">
    <link rel="stylesheet" href="<c:url value="resources/assets/css/Pretty-Footer.css"/>">
    <link rel="stylesheet" href="<c:url value="resources/assets/css/Pretty-Registration-Form.css"/>">
    <link rel="stylesheet" href="<c:url value="resources/assets/css/Google-Style-Login.css"/>">
</head>

<body>
${error}
${logout }
   <!--  <div class="btn-group">
        <button class="btn btn-default" type="button">Button </button>
        <button class="btn btn-default dropdown-toggle" data-toggle="dropdown" aria-expanded="false" type="button"><span class="caret"></span></button>
        <ul class="dropdown-menu" role="menu">
            <li role="presentation"><a href="#">First Item</a></li>
            <li role="presentation"><a href="#">Second Item</a></li>
            <li role="presentation"><a href="#">Third Item</a></li>
        </ul>
    </div>
    <div class="btn-group" role="group">
        <button class="btn btn-default" type="button">Button 1</button>
        <button class="btn btn-default" type="button">Button 2</button>
    </div>
    --> <nav class="navbar navbar-inverse navbar-fixed-top">
        <div class="container">
            <div class="navbar-header">
                <a class="navbar-brand navbar-link" href="#"><img src="resources/assets/img/90a3d103aa1d8fc2bff6448dcd2edc53.svg" width="70px" id="logo"> N Bakes &amp; Cakes</a>
                <button class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navcol-1"><span class="sr-only">Toggle navigation</span><span class="icon-bar"></span><span class="icon-bar"></span><span class="icon-bar"></span></button>
            </div>
            <div class="collapse navbar-collapse" id="navcol-1">
                <ul class="nav navbar-nav navbar-right">
                    <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" aria-expanded="false" href="#" data-hover="dropdown">Menu<i class="glyphicon glyphicon-align-justify"></i> <span class="caret hidden"></span></a>
                        <ul class="dropdown-menu" role="menu">
                        <c:forEach items="${categoryList}" var="category">
                            <li role="presentation"><a href="product${category.id}">${category.categoryName}</a></li>
                           <!--  <li role="presentation"><a href="#">Donuts </a></li>
                            <li role="presentation"><a href="#">Cookies </a></li>
                            <li role="presentation"><a href="#">Muffins </a></li>
                            <li role="presentation"><a href="#">Desserts </a></li> -->
                            </c:forEach>
                        </ul>
                    </li>
                    <!--  <li role="presentation"><a href="admin">Admin </a></li>
                    
 -->
 			 <sec:authorize access="!isAuthenticated()">                
 	    <li role="presentation"><a href="login">Login <i class="glyphicon glyphicon-log-in"></i></a></li>
                    <li role="presentation"><a href="signup">SignUp <i class="glyphicon glyphicon-user"></i></a></li>
                    </sec:authorize>
                    <sec:authorize access="isAuthenticated()">
                  				  <li class="active" role="presentation"><a href="cart">Shop </a></li>
                  
                              <li> <a href="<c:url value="j_spring_security_logout" />">Logout</a></li>
                              </sec:authorize>
                </ul>
            </div>
        </div>
    </nav>
    <div class="carousel slide" data-ride="carousel" id="carousel-1">
        <div class="carousel-inner" role="listbox">
            <div class="item"><img class="img-responsive" src="resources/assets/img/thumb-1920-417990.jpg" alt="Slide Image" width="100%" max-width="200px" height="200px" ></div>
            <div class="item"><img src="resources/assets/img/thumb-1920-772586.jpg" alt="Slide Image"></div>
            <div class="item active"><img src="resources/assets/img/gq1khg1ullp31lkyimxg.jpg" alt="Slide Image" width="1400" height="100"></div>
        </div>
        <div><a class="left carousel-control" href="#carousel-1" role="button" data-slide="prev"><i class="glyphicon glyphicon-chevron-left"></i><span class="sr-only">Previous</span></a>
            <a class="right carousel-control" href="#carousel-1" role="button" data-slide="next"><i class="glyphicon glyphicon-chevron-right"></i><span class="sr-only">Next</span></a>
        </div>
        <ol class="carousel-indicators">
            <li data-target="#carousel-1" data-slide-to="0"></li>
            <li data-target="#carousel-1" data-slide-to="1"></li>
            <li data-target="#carousel-1" data-slide-to="2" class="active"></li>
        </ol>
    </div>
    <footer class="navbar-fixed-bottom">
        <div class="row">
            <div class="col-md-4 col-sm-6 footer-navigation">
                <h3 class="text-center"> N Bakes &amp; Cakes</h3>
                <p class="text-center links"><a href="#">Home</a><strong> · </strong><a href="#">Gallery </a><strong> · </strong><a href="#">About</a><strong> · </strong><a href="#">Faq</a><strong> · </strong><a href="#">Contact</a></p>
                <p class="text-center company-name"> N Bakes&amp;Cakes © 2017 </p>
            </div>
            <div class="col-md-4 col-sm-6 footer-contacts">
                <div><span class="fa fa-map-marker footer-contacts-icon"> </span>
                    <p> Lingampally,Hyderbad,India</p>
                </div>
                <div><i class="fa fa-phone footer-contacts-icon"></i>
                    <p class="footer-center-info email text-left"> +91 9160 596953</p>
                </div>
                <div><i class="fa fa-envelope footer-contacts-icon"></i>
                    <p> <a href="#" target="_blank">NBCOnline@gmail.com</a></p>
                </div>
            </div>
            <div class="clearfix visible-sm-block"></div>
            <div class="col-md-4 footer-about">
                <h4 class="text-center">About Us</h4>
                <p class="text-justify"> We N Bakes&amp;Cakes provides a varitey of cakes and desserts with losts of customisation options We have a varitey of premium and exotic flavours for coustomisation in every dishes we serve.Our motto is to make ur dream thoughts into actions.
                </p>
                <div class="social-links social-icons"><a href="#"><i class="fa fa-facebook"></i></a><a href="#"><i class="fa fa-twitter"></i></a><a href="#"><i class="fa fa-linkedin"></i></a><a href="#"><i class="fa fa-github"></i></a></div>
            </div>
        </div>
    </footer>
    <script src="<c:url value="resources/assets/js/jquery.min.js"/>"></script>
    <script src="<c:url value="resources/assets/bootstrap/js/bootstrap.min.js"/>"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-hover-dropdown/2.2.1/bootstrap-hover-dropdown.min.js"></script>
</body>

</html>