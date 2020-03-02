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
  <title>Recuperation</title>
  <!-- Bootstrap core CSS-->
  <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
  <!-- Custom fonts for this template-->
  <link href="vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
  <!-- Custom styles for this template-->
  <link href="css/sb-admin.css" rel="stylesheet">
</head>
<body class="bg-success" ng-controller="locationCtrl">
  <div class="container">
    <div class="card card-login mx-auto mt-5">
      <div class="card-header">Recuperation de mot de passe</div>
      <div class="card-body">
          <form name="form" action="${pageContext.request.contextPath}/location?action=logged" method="post">
              <span>
                  <c:if test="${!empty error}">${error}</c:if>
              </span>
          <div class="form-group">
            <label for="exampleInputEmail1">Email</label>
            <input size="20" maxlength="60" class="form-control" ng-model="email" name="email" required id="exampleInputEmail1" type="email" aria-describedby="emailHelp" placeholder="Enter email">
          
          </div>
          <div class="form-group">
            <label for="exampleInputPassword1">Ancien mot de passe</label>
            <input class="form-control" size="20" maxlength="20"  ng-model="password" name="password"  required id="exampleInputPassword1" type="password" placeholder="Password"> 
          </div>
         
          <button class="btn btn-primary btn-block"  ng-disabled="form.$invalid" type="submit">Login</button>
        </form>
        <div class="text-center">
          <a class="d-block small mt-3" href="${pageContext.request.contextPath}/location?action=register">Inscription</a>
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
