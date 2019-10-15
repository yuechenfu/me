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
      <h4>Agent Information</h4>
      <span>About agent information .</span>
    </div>
  </div>
  <!-- Page Top -->

  <div class="panel-content">
    <div class="widget pad50-65">
      <form class="contact-form" action="${pageContext.request.contextPath }/agent/save" method="post">
        <div class="row mrg20">
          <input type="hidden" name="id" value ="${Agent.id }">
          <div class="col-md-12 col-sm-12 col-lg-12">
                    <input class="brd-rd5" type="text" name="overview" placeholder="simple description" />
           </div>
          <div class="col-md-12 col-sm-12 col-lg-12">
            <textarea class="brd-rd5" placeholder="Enter your detail information , tell the customer something about you !" name="aboutme" >${Agent.aboutme }</textarea>
          </div>
          <div class="col-md-6 col-sm-6 col-lg-2">
              <button class="green-bg brd-rd6" type="button" id="pre_button">
              <i class="ti-arrow-top-left"></i> Previous</button>
          </div>
          <div class="col-md-6 col-sm-6 col-lg-10">
              <button class="green-bg brd-rd6" type="submit">
              <i class="fa fa-paper-plane"></i> Save</button>
          </div>
        </div>
      </form>
     
    </div>
  </div>
  <!-- Panel Content -->
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