<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>

<head>
  <!-- Meta-Information -->
  <title>Admin Panel</title>
  <meta charset="utf-8">
  <meta name="description" content="">
  <meta name="viewport" content="width=device-width, initial-scale=1">

  <!-- Vendor: Bootstrap 4 Stylesheets  -->
  <link rel="stylesheet" href="http://cdn.bootstrapmb.com/bootstrap/4.0.0/css/bootstrap.min.css" type="text/css">

  <!-- Our Website CSS Styles -->
    <link rel="stylesheet" href="../css/icons.min.css" type="text/css">
    <link rel="stylesheet" href="../css/main.css" type="text/css">
    <link rel="stylesheet" href="../css/responsive.css" type="text/css">

    <!-- Color Scheme -->
    <link rel="stylesheet" href="css/color-schemes/color.css" type="text/css" title="color3">
    <link rel="alternate stylesheet" href="../css/color-schemes/color1.css" title="color1">
    <link rel="alternate stylesheet" href="../css/color-schemes/color2.css" title="color2">
    <link rel="alternate stylesheet" href="../css/color-schemes/color4.css" title="color4">
    <link rel="alternate stylesheet" href="../css/color-schemes/color5.css" title="color5">
</head>

<body class="expand-data panel-data">
   <!-- Topbar -->
    <%@include file="header.jsp"%>
    <!-- Side Header -->
    <%@include file="left.jsp"%>
  <!-- Options Panel -->
  <div class="pg-tp">
    <i class="ion-cube"></i>
    <div class="pr-tp-inr">
      <h4>Agent management</h4>
      <span>Agent management,add new or update or delete operation.</span>
    </div>
  </div>
  <!-- Page Top -->

  <div class="panel-content">
    <div class="widget pad50-65">
      <div class="rmv-ext6">
        <div class="row mrg20">
          <div class="col-md-4 col-sm-6 col-lg-4">
           <a href="/agent/add">
            <div class="serv-bx styl1 brd-rd5 text-center">
              <i class="brd-rd50 badge-warning fa fa-cubes"></i>
              <div class="serv-inf">
                <h4>Add New</h4>
                <p>Add a New Agent.
                </p>
              </div>
            </div>
            </a>
          </div>
          <div class="col-md-4 col-sm-6 col-lg-4">
          <a href="/agent/edit" >
            <div class="serv-bx styl1 brd-rd5 text-center">
              <i class="brd-rd50 badge-success fa fa-magnet"></i>
              <div class="serv-inf">
                <h4>Update Agent</h4>
                <p>update agent information .
                </p>
              </div>
            </div>
            </a>
          </div>
          <div class="col-md-4 col-sm-6 col-lg-4">
          <a href="/agent/delete"  >
            <div class="serv-bx styl1 brd-rd5 text-center">
              <i class="brd-rd50 badge-info fa fa-diamond"></i>
              <div class="serv-inf">
                <h4>Delete Agent</h4>
                <p>delete a agent information.
                </p>
              </div>
            </div>
            </a>
          </div>
        </div>
      </div>
    </div>
  </div>
  <!-- Panel Content -->
    <%@include file="footer.html"%>

    <!-- Vendor: Javascripts -->
    <script src="../js/jquery.min.js" type="text/javascript"></script>
    <!-- Vendor: Followed by our custom Javascripts -->
    <script src="../js/bootstrap.min.js" type="text/javascript"></script>
    <script src="../js/select2.min.js" type="text/javascript"></script>
    <script src="../js/slick.min.js" type="text/javascript"></script>

    <!-- Our Website Javascripts -->
    <script src="../js/isotope.min.js" type="text/javascript"></script>
    <script src="../js/isotope-int.js" type="text/javascript"></script>
    <script src="../js/jquery.counterup.js" type="text/javascript"></script>
    <script src="../js/waypoints.min.js" type="text/javascript"></script>
    <script src="../js/highcharts.js" type="text/javascript"></script>
    <script src="../js/exporting.js" type="text/javascript"></script>
    <script src="../js/highcharts-more.js" type="text/javascript"></script>
    <script src="../js/moment.min.js" type="text/javascript"></script>
    <script src="../js/jquery.circliful.min.js" type="text/javascript"></script>
    <script src="../js/fullcalendar.min.js" type="text/javascript"></script>
    <script src="../js/jquery.downCount.js" type="text/javascript"></script>
    <script src="../js/jquery.bootstrap-touchspin.min.js" type="text/javascript"></script>
    <script src="../js/jquery.formtowizard.js" type="text/javascript"></script>
    <script src="../js/form-validator.min.js" type="text/javascript"></script>
    <script src="../js/form-validator-lang-en.min.js" type="text/javascript"></script>
    <script src="../js/cropbox-min.js" type="text/javascript"></script>
    <script src="../js/jquery.slimscroll.min.js" type="text/javascript"></script>
    <script src="../js/ion.rangeSlider.min.js" type="text/javascript"></script>
    <script src="../js/jquery.poptrox.min.js" type="text/javascript"></script>
    <script src="../js/styleswitcher.js" type="text/javascript"></script>
    <script src="../js/main.js" type="text/javascript"></script>
</body>

</html>