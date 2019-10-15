<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>

<head>
  <!-- Meta-Information -->
  <title>Fuzen Admin Panel</title>
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
      <h4>Agent information</h4>
      <span>Fill in base information.</span>
    </div>
  </div>
  <!-- Page Top -->

  <div class="panel-content">
      <c:if test='${msg != null}'>
       <div class="alert alert-danger"><strong>Oh snap!</strong> ${msg }</div>
      </c:if>
    <div class="widget pad50-65">
      <form class="form-wrp" action="${pageContext.request.contextPath }/agent/insert" enctype="multipart/form-data" method="POST">
        <div class="row mrg20">
          <div class="col-md-6 col-sm-6 col-lg-6">
            <input class="brd-rd5" type="text" name="firstname" value="${Agent.firstname }" placeholder="First Name*" />
          </div>
          <div class="col-md-6 col-sm-6 col-lg-6">
            <input class="brd-rd5" type="text" name="lastname" value="${Agent.lastname }" placeholder="Last Name*" />
          </div>
          <div class="col-md-6 col-sm-6 col-lg-6">
            <input class="brd-rd5" type="text" name="company" value="${Agent.company }" placeholder="Company Name*" />
          </div>
          <div class="col-md-6 col-sm-6 col-lg-6">
            <input class="brd-rd5" type="text" name="phone" value="${Agent.phone }" placeholder="Phone*" />
          </div>
          <div class="col-md-6 col-sm-6 col-lg-6">
            <input class="brd-rd5" type="text" name="city" value="${Agent.city }" placeholder="Town/City*" />
          </div>
          <div class="col-md-6 col-sm-6 col-lg-6">
            <div class="slct-bx">
              <span>
                <select name="state">
                  <option value="Ca" >Ca</option>
                </select>
              </span>
            </div>
          </div>
          <div class="col-md-6 col-sm-6 col-lg-6">
            <input class="brd-rd5" type="text" name="postcode" value="${Agent.postcode }" placeholder="Zip/Postal Code*" />
          </div>
          <div class="col-md-6 col-sm-6 col-lg-6">
            <input class="brd-rd5" type="email" name="email" value="${Agent.email }" placeholder="Email Address*" />
          </div>
          <div class="col-md-12 col-sm-12 col-lg-12">
            <div class="gender-box">
              <strong>Gender</strong>
              <span class="rdio-bx">
                <input type="radio" name="gender" value="male" id="male1" />
                <label for="male1">Male</label>
              </span>
              <span class="rdio-bx">
                <input type="radio" name="gender" value="female" id="female1" />
                <label for="female1">Female</label>
              </span>
            </div>
          </div>
          <div class="col-md-12 col-sm-12 col-lg-12">
            <div class="file-upload-box">
              <strong>Photograph:</strong>
              <div class="file-box">
                <label class="fileContainer">
                  <span class="blue-bg brd-rd5">Upload  Photo</span>
                  <input type="file" name="imgsrc"/>
                </label>
              </div>
            </div>
          </div>
          <div class="col-md-6 col-sm-6 col-lg-2">
              <button class="green-bg brd-rd6" type="button" id="pre_button">
              <i class="ti-arrow-top-left"></i> Back</button>
          </div>
          <div class="col-md-6 col-sm-6 col-lg-10">
            <button class="green-bg brd-rd5" type="submit">
              <i class="fa fa-paper-plane"></i> Next</button>
          </div>
        </div>
      </form>
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
<script>
$(document).ready(function(){
	  $("#pre_button").click(function(){ 
		  history.go(-1);
	  });
});	
</script>
</html>