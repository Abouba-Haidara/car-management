<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <meta name="author" content="">
  <title>location voiture</title>
  <!-- Bootstrap core CSS-->
  <link href="${pageContext.request.contextPath}/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
  <!-- Custom fonts for this template-->
  <link href="${pageContext.request.contextPath}/vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
  <!-- Page level plugin CSS-->
  <link href="${pageContext.request.contextPath}/vendor/datatables/dataTables.bootstrap4.css" rel="stylesheet">
  <!-- Custom styles for this template-->
  <link href="${pageContext.request.contextPath}/css/sb-admin.css" rel="stylesheet">
  <link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet" type="text/css"/>
</head>
<body> 
  
<div class="preloader" id="preloader">
    <img style="margin-left: 650px; margin-top: 200px;"  src="https://loading.io/assets/img/landing/curved-bars.svg" class="img-responsive center-block loadText">
        <p class="text-center loadText">Loading...</p>
    </div>
    <div class="container">
      <div class="navbar navbar-default navbar-fixed-top" role="navigation" style="background: teal;">
        <div class="navbar-header">
            <a  href="#" class="navbar-brand list-inline" style="color: #fff; margin-top: -10px;" >
                <span> Raider Auto </span>
            </a>
        </div>
        <ul class="nav  list-inline">
          <c:choose>
                  <c:when test="${ sessionScope.user == null}">
                        <li>
                            <a class="btn btn-success btn-sm" href="${pageContext.request.contextPath}/location?action=login">
                        <strong style="color:#fff;">Login</strong>
                        <span class="glyphicon glyphicon-home" style="color: #fff;"></span>
                    </a>
                </li>
                  </c:when> 
                  <c:when test="${ sessionScope.user !=null}"> 
                        <li style="margin-left: 15px;">
                    <a class="btn btn-warning btn-sm" href="${pageContext.request.contextPath}/location?action=dashboard">
                        <strong style="color:#fff;">Dashboard</strong>
                        <span class="glyphicon glyphicon-home" style="color: #fff;"></span>
                    </a>
                </li>
                   </c:when>
          </c:choose>    
       </ul>
      </div>  
  <div class="banner slider">
    <div id="demo" class="carousel slide" data-ride="carousel"  data-interval="false">

  <!-- Indicators -->
  <ul class="carousel-indicators">
    <li data-target="#demo" data-slide-to="0" class="active"></li>
    <li data-target="#demo" data-slide-to="1"></li>
    <li data-target="#demo" data-slide-to="2"></li>
  </ul>

  <!-- The slideshow -->
  <div class="carousel-inner">
    <div class="carousel-item active">
      <img src="https://images.cardekho.com/images/featuredcarimages/Maruti-Swift-17/Swift-new-0.jpg" alt="Los Angeles">
      <div class="carousel-caption">
        <div class="col-md-7">
            <h1 class="pb-2"><strong>Raider Auto </strong> </h1>
            <h4>Votre plaisir notre desir!</h4>
            <button type="button" class="btn btn-success mt-4">Location</button>
            <button type="button" class="btn btn-dark mt-4">Voir plus</button>
        </div>
      </div>   
    </div>
    <div class="carousel-item">
      <img src="https://images.cardekho.com/images/featuredcarimages/Maruti-Swift-17/Swift-new-0.jpg" alt="Chicago">
      <div class="carousel-caption">
         <div class="col-md-7">
            <h1 class="pb-2"><strong>Raider Auto </strong> </h1>
            <h4>Votre plaisir notre desir!</h4>
            <button type="button" class="btn btn-success mt-4">Location</button>
            <button type="button" class="btn btn-dark mt-4">Voir plus</button>
        </div>
      </div>   
    </div>
    <div class="carousel-item">
      <img src="https://images.cardekho.com/images/featuredcarimages/Maruti-Swift-17/Swift-new-0.jpg" alt="New York">
      <div class="carousel-caption">
         <div class="col-md-7">
            <h1 class="pb-2"><strong>Raider Auto </strong> </h1>
            <h4>Votre plaisir notre desir!</h4>
            <button type="button" class="btn btn-success mt-4">Location</button>
            <button type="button" class="btn btn-dark mt-4">Voir plus</button>
        </div>
      </div>  
    </div>
  </div>

  <!-- Left and right controls -->
  <a class="carousel-control-prev" href="#demo" data-slide="prev">
    <span class="carousel-control-prev-icon"></span>
  </a>
  <a class="carousel-control-next" href="#demo" data-slide="next">
    <span class="carousel-control-next-icon"></span>
  </a>

</div>
</div>
    <!-- Bootstrap core JavaScript-->
    <script src="${pageContext.request.contextPath}/vendor/jquery/jquery.min.js"></script>
    <script src="${pageContext.request.contextPath}/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
    <!-- Core plugin JavaScript-->
    <script src="${pageContext.request.contextPath}/vendor/jquery-easing/jquery.easing.min.js"></script>
    <!-- Page level plugin JavaScript-->
    <script src="${pageContext.request.contextPath}/vendor/chart.js/Chart.min.js"></script>
    <script src="${pageContext.request.contextPath}/vendor/datatables/jquery.dataTables.js"></script>
    <script src="${pageContext.request.contextPath}/vendor/datatables/dataTables.bootstrap4.js"></script>
    <!-- Custom scripts for all pages-->
    <script src="${pageContext.request.contextPath}/js/sb-admin.min.js"></script>
    <!-- Custom scripts for this page-->
    <script src="${pageContext.request.contextPath}/js/sb-admin-datatables.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/sb-admin-charts.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/scriptA.js" type="text/javascript"></script>
      </div>
</body>
</html>