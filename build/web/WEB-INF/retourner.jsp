<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="en" ng-app="location">
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

<body class="fixed-nav sticky-footer bg-dark" id="page-top" ng-controller="locationCtrl">
  <!-- Navigation-->
  <nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top" id="mainNav">
    <a class="navbar-brand" href="index.html">Location voiture</a>
    <div class="collapse navbar-collapse" id="navbarResponsive">
      <ul class="navbar-nav navbar-sidenav" id="exampleAccordion">
        <li class="nav-item" data-toggle="tooltip" data-placement="right" title="Dashboard">
          <a class="nav-link" href="index.html">
            <i class="fa fa-fw fa-dashboard"></i>
            <span class="nav-link-text">Dashboard</span>
          </a>
        </li>
        <li class="nav-item" data-toggle="tooltip" data-placement="right" title="Components">
          <a class="nav-link nav-link-collapse collapsed" data-toggle="collapse" href="#collapseComponents" data-parent="#exampleAccordion">
            <i class="fa fa-fw fa-wrench"></i>
            <span class="nav-link-text">Gestion de Location</span>
          </a>
            <ul class="sidenav-second-level collapse" id="collapseComponents">
            <li>
              <a href="${pageContext.request.contextPath}/effectuer">Effectuer location</a>
            </li>
             <li>
              <a href="${pageContext.request.contextPath}/editcontrat">Rediger un contrat</a>
            </li>
            <li>
              <a href="${pageContext.request.contextPath}/loc-en-cours">Afficher locations en cours</a>
            </li>
             <li>
              <a href="${pageContext.request.contextPath}/loc-par-date">Afficher locations par date</a>
            </li>
             <li>
              <a href="${pageContext.request.contextPath}/all-loc">Afficher tous</a>
            </li>
             <li>
              <a href="${pageContext.request.contextPath}/archiver">Archiver tout les locations</a>
            </li>
          </ul>
        </li>
        <li class="nav-item" data-toggle="tooltip" data-placement="right" title="Example Pages">
          <a class="nav-link nav-link-collapse collapsed" data-toggle="collapse" href="#collapseExamplePages" data-parent="#exampleAccordion">
            <i class="fa fa-fw fa-users"></i>
            <span class="nav-link-text">Gestion de clients</span>
          </a>
          <ul class="sidenav-second-level collapse" id="collapseExamplePages">
            <li>
              <a href="${pageContext.request.contextPath}/creer">Ajouter un Client</a>
            </li>
            <li>
              <a href="${pageContext.request.contextPath}/edit">Modifier un client</a>
            </li>
            <li>
              <a href="${pageContext.request.contextPath}/delete">Supprimer un client</a>
            </li>
          </ul>
        </li>
        <li class="nav-item" data-toggle="tooltip" data-placement="right" title="Menu Levels">
          <a class="nav-link nav-link-collapse collapsed" data-toggle="collapse" href="#collapseMulti" data-parent="#exampleAccordion">
            <i class="fa fa-fw fa-car"></i>
            <span class="nav-link-text">Gestion de voiture</span>
          </a>
          <ul class="sidenav-second-level collapse" id="collapseMulti">
            <li>
              <a href="${pageContext.request.contextPath}/creer">Ajouter une voiture</a>
            </li>
            <li>
              <a href="${pageContext.request.contextPath}/edit">Modifier une voiture</a>
            </li>
            <li>
              <a href="${pageContext.request.contextPath}/listes">Listes de  voiture</a>
            </li>
          </ul>
        </li>
        <li class="nav-item" data-toggle="tooltip" data-placement="right" title="Link">
          <a class="nav-link" href="${pageContext.request.contextPath}/statistiques">
            <i class="fa fa-fw fa-link"></i>
            <span class="nav-link-text">Statistiques</span>
          </a>
        </li>
      </ul>
      <ul class="navbar-nav sidenav-toggler">
        <li class="nav-item">
          <a class="nav-link text-center" id="sidenavToggler">
            <i class="fa fa-fw fa-angle-left"></i>
          </a>
        </li>
      </ul>
      <ul class="navbar-nav ml-auto">
        <li class="nav-item dropdown">
          <a class="nav-link dropdown-toggle mr-lg-2" id="messagesDropdown" href="#" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
            <i class="fa fa-fw fa-envelope"></i>
            <span class="d-lg-none">Messages
              <span class="badge badge-pill badge-primary">12 New</span>
            </span>
            <span class="indicator text-primary d-none d-lg-block">
              <i class="fa fa-fw fa-circle"></i>
            </span>
          </a>
          <div class="dropdown-menu" aria-labelledby="messagesDropdown">
             <h6 class="dropdown-header">Retour de voiture d'ajourd'hui:</h6>
            <div class="dropdown-divider"></div>
            <a class="dropdown-item" href="#">
              <strong>Client Abouba Haidara</strong>
              <span class="small float-right text-muted">11:21 AM</span>
              <div class="dropdown-message small">indique</div>
            </a>
            <div class="dropdown-divider"></div>
            <a class="dropdown-item small" href="#">Afficher toutes</a>
          </div>
        </li>
        <li class="nav-item dropdown">
          <a class="nav-link dropdown-toggle mr-lg-2" id="alertsDropdown" href="#" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
            <i class="fa fa-fw fa-bell"></i>
            <span class="d-lg-none">Alerts
              <span class="badge badge-pill badge-warning">6 New</span>
            </span>
            <span class="indicator text-warning d-none d-lg-block">
              <i class="fa fa-fw fa-circle"></i>
            </span>
          </a>
          <div class="dropdown-menu" aria-labelledby="alertsDropdown">
            <h6 class="dropdown-header">New Alerts:</h6>
            <div class="dropdown-divider"></div>
            <a class="dropdown-item" href="#">
              <span class="text-success">
                <strong>
                  <i class="fa fa-long-arrow-up fa-fw"></i>Status Update</strong>
              </span>
              <span class="small float-right text-muted">11:21 AM</span>
              <div class="dropdown-message small">This is an automated server response message. All systems are online.</div>
            </a>
            <div class="dropdown-divider"></div>
            <a class="dropdown-item" href="#">
              <span class="text-danger">
                <strong>
                  <i class="fa fa-long-arrow-down fa-fw"></i>Status Update</strong>
              </span>
              <span class="small float-right text-muted">11:21 AM</span>
              <div class="dropdown-message small">This is an automated server response message. All systems are online.</div>
            </a>
            <div class="dropdown-divider"></div>
            <a class="dropdown-item small" href="#">View all alerts</a>
          </div>
        </li>
        <li class="nav-item">
          <form class="form-inline my-2 my-lg-0 mr-lg-2">
            <div class="input-group">
              <input class="form-control" type="text" placeholder="Search for...">
              <span class="input-group-append">
                <button class="btn btn-primary" type="button">
                  <i class="fa fa-search"></i>
                </button>
              </span>
            </div>
          </form>
        </li>
        <li class="nav-item">
          <a class="nav-link" data-toggle="modal" data-target="#exampleModal">
            <i class="fa fa-fw fa-sign-out"></i>Logout</a>
        </li>
      </ul>
    </div>
  </nav>
  <div class="content-wrapper">
    <div class="container-fluid">
      <!-- Breadcrumbs-->
      <ol class="breadcrumb">
        <li class="breadcrumb-item">
          <a href="#">Administration</a>
        </li>
        <li class="breadcrumb-item active">Location</li>
      </ol>
       <div class="card mb-3">
        <div class="card-header">
          <i class="fa fa-table"></i> Confirmation des location de voitures retourner</div>
        <div class="card-body">
          <div class="table-responsive">
            <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
              <thead>
                <tr>
                  <th>Ref</th>
                  <th>Date Retour</th>
                  <th>Ref Voiture</th>
                  <th>Nom & Prenom</th>
                  <th>Statut</th>
                </tr>
              </thead>
              <tfoot>
                <tr>
                    <th colspan="6" class="text-success" style="font-size: 12px;">Confime</th>
                </tr>
              </tfoot>
              <tbody>
              <c:forEach items="${lists}" var="l">
                 <tr>
                   <td>${l.idLocation.matricule}</td>
                  <td> <fmt:formatDate type = "both" dateStyle = "short" timeStyle = "short" value = "${l.dateretour}" />
                  </td>
                  <td>${l.idLocation.idvoiture.matricule}</td>
                  <td>${l.idLocation.idClient.nom}  ${l.idLocation.idClient.prenom}</td>
                  <td>
                      <form method="get">
                          <input type="hidden" value="action">
                          <button type="submit" value="${l.id}" ng-model="code" class="fa fa-check-circle-o btn btn-sm btn-success"  ng-click="confirm(${l.id})"></button>
                      </form>
                  </td>
                </tr>  
              </c:forEach>
              </tbody>
            </table>
          </div>
        </div>
        <div class="card-footer small  text-warning">Service location</div>
      </div>
    </div>
    <!-- /.container-fluid-->
    <!-- /.content-wrapper-->
    <footer class="sticky-footer">
      <div class="container">
        <div class="text-center">
          <small>Copyright © Location voiture 2018</small>
        </div>
      </div>
    </footer>
    <!-- Scroll to Top Button-->
    <a class="scroll-to-top rounded" href="#page-top">
      <i class="fa fa-angle-up"></i>
    </a>
    <!-- Logout Modal-->
    <div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
      <div class="modal-dialog" role="document">
        <div class="modal-content">
          <div class="modal-header">
            <h5 class="modal-title" id="exampleModalLabel">Ready to Leave?</h5>
            <button class="close" type="button" data-dismiss="modal" aria-label="Close">
              <span aria-hidden="true">×</span>
            </button>
          </div>
          <div class="modal-body">Select "Logout" below if you are ready to end your current session.</div>
          <div class="modal-footer">
            <button class="btn btn-secondary" type="button" data-dismiss="modal">Cancel</button>
            <a class="btn btn-primary" href="${pageContext.request.contextPath}/location?action=logout">Logout</a>
          </div>
        </div>
      </div>
    </div>
    <!-- Bootstrap core JavaScript-->
    <script src="${pageContext.request.contextPath}/vendor/jquery/jquery.min.js"></script>
    <script src="${pageContext.request.contextPath}/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
    <!-- Core plugin JavaScript-->
    <script src="${pageContext.request.contextPath}/vendor/jquery-easing/jquery.easing.min.js"></script>
    <!-- Page level plugin JavaScript
    <script src="${pageContext.request.contextPath}/vendor/chart.js/Chart.min.js"></script>
    <script src="/${pageContext.request.contextPath}vendor/datatables/jquery.dataTables.js"></script>
    <script src="/${pageContext.request.contextPath}vendor/datatables/dataTables.bootstrap4.js"></script>-->
   
    <script src="${pageContext.request.contextPath}/js/sb-admin.min.js"></script>
    <!-- Custom scripts for this page
    <script src="${pageContext.request.contextPath}/js/sb-admin-datatables.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/sb-admin-charts.min.js"></script>-->
    <script src="${pageContext.request.contextPath}/js/angular.min.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/js/app.js" type="text/javascript"></script>
  </div>
</body>

</html>
