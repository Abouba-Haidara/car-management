<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en" ng-app="location">
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <meta name="author" content="">
  <title>Inscription</title>
  <!-- Bootstrap core CSS-->
  <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
  <!-- Custom fonts for this template-->
  <link href="vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
  <!-- Custom styles for this template-->
  <link href="css/sb-admin.css" rel="stylesheet">
</head>
<body class="bg-success" ng-controller="locationCtrl">
  <div class="container">
   <div class="card card-register mx-auto mt-5">
      <div class="card-header">Inscription</div>
      <div class="card-body">
        <form  name="form" action="${pageContext.request.contextPath}/location?action=registration" method="post">
            <span>
                  <c:if test="${!empty error}">${error}</c:if>
              </span>
          <div class="form-group">
            <div class="form-row">
              <div class="col-md-6">
                <label for="exampleInputName">Nom</label>
                <input class="form-control" name="nom" id="exampleInputName" type="text" aria-describedby="nameHelp" required ng-model="nom" placeholder="Nom">
              </div>
              <div class="col-md-6">
                <label for="exampleInputLastName">Prenom</label>
                <input class="form-control" name="prenom" id="exampleInputLastName" type="text" aria-describedby="nameHelp" required placeholder="Prenom" ng-model="prenom">
              </div>
            </div>
          </div>
          <div class="form-group">
            <label for="exampleInputEmail1">Email address</label>
            <input class="form-control" id="exampleInputEmail1" type="email" aria-describedby="emailHelp" placeholder="email" required ng-model="email">
          </div>
          <div class="form-group">
            <div class="form-row">
              <div class="col-md-6">
                <label for="exampleInputPassword1">Password</label>
                <input class="form-control" id="exampleInputPassword1" type="password" placeholder="Password" required name="password" ng-model="password">
              </div>
              <div class="col-md-6">
                <label for="exampleConfirmPassword">Confirm password</label>
                <input class="form-control" id="exampleConfirmPassword" type="password" placeholder="Confirm password" name="pwd_confirm" required ng-model="pwd_confirm">
              </div>
            </div>
          </div>
              <button class="btn btn-primary btn-block"  ng-disabled="form.$invalid">Register</button>
        </form>
        <div class="text-center">
           <a class="d-block small mt-3" href="${pageContext.request.contextPath}/location?action=login">Login</a>
          <a class="d-block small" href="${pageContext.request.contextPath}/location?action=forget">Mot de passe oublie</a>
       </div>
      </div>
    </div>
  </div>
  <!-- Bootstrap core JavaScript-->
  <script src="${pageContext.request.contextPath}/js/angular.min.js" type="text/javascript"></script>
  <script src="${pageContext.request.contextPath}/js/app.js" type="text/javascript"></script>
  <script src="${pageContext.request.contextPath}/vendor/jquery/jquery.min.js"></script>
  <script src="${pageContext.request.contextPath}/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
  <!-- Core plugin JavaScript-->
  <script src="${pageContext.request.contextPath}/vendor/jquery-easing/jquery.easing.min.js"></script>
</body>

</html>
