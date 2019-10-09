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
      <h4>Agent Profile</h4>
      <span>You can easily style a Profile Page.</span>
    </div>
  </div>
  <!-- Page Top -->

  <div class="panel-content">
    <div class="widget pad50-65">
      <div class="profile-wrp">
        <div class="row">
          <div class="col-md-4 col-sm-12 col-lg-4">
            <div class="profile-info-wrp">
              <div class="insta-wrp">
                <span>
                  <img class="brd-rd50" src="../${Agent.photoUrl }" alt="" />
                  <span class="sts online"></span>
                </span>
                <div class="insta-inf">
                  <h2>
                    <a href="#" title="">${Agent.firstname } . ${Agent.lastname }</a>
                  </h2>
                  <div class="prf-btns">
                    <p><i class="fa fa-envelope-o"></i>${Agent.email }</p>
                    <p><i class="fa fa-phone"></i>${Agent.phone }</p>
                  </div>
                </div>
              </div>
              <div class="usr-abut">
                <h5 class="prf-edit-tl">About Me
                </h5>
                <p>${Agent.aboutme }</p>
              </div>
              <div class="usr-gnrl-inf">
                <h5 class="prf-edit-tl">General Info
                </h5>
                <div class="grn-inf-lst">
                  <i class="fa fa-home"></i> Company Name:
                  <span class="green-clr">${Agent.company }</span>
                </div>
                <div class="grn-inf-lst">
                  <i class="fa fa-graduation-cap"></i> Location:
                  <span>${Agent.location }</span>
                </div>
                <div class="grn-inf-lst">
                  <i class="fa fa-graduation-cap"></i> City:
                  <span>${Agent.city } | ${Agent.state } | CA${Agent.postcode } </span>
                </div>
              </div>
              <div class="usr-cnt-inf">
                <h5 class="prf-edit-tl">Contact Information
                </h5>
                <ul class="usr-cnt-inf-lst">
                  <li>
                    <i class="fa fa-home"></i>
                    <strong>Address:</strong>
                    <p>${Agent.location }</p>
                  </li>
                  <li>
                    <i class="fa fa-phone"></i>
                    <strong>Phone:</strong>
                    <p>${Agent.phone }</p>
                  </li>
                  <li>
                    <i class="fa fa-envelope"></i>
                    <strong>Email ID:</strong>
                    <p>${Agent.email }</p>
                  </li>
                </ul>
              </div>
            </div>
          </div>
          <div class="col-md-8 col-sm-12 col-lg-8">
            <div class="usr-actvty-wrp widget pad50-40">
              <h4 class="widget-title">Activity Listings</h4>
              <div class="act-pst-lst">
                <div class="act-pst">
                  <img class="brd-rd50" src="../images/resource/acti-thmb1.jpg" alt="" />
                  <div class="act-pst-inf">
                    <div class="act-pst-inr">
                      <h5>
                        <a href="#" title="">Sadi Orlaf</a>
                      </h5> posted in
                      <a href="#" title="">Material</a>
                    </div>
                    <span class="spnd-tm">5 Min Ago</span>
                    <div class="act-pst-dta">
                      <p>That's awesome!</p>
                    </div>
                    <span class="pst-tm">
                      <a href="#" title="">
                        <i class="fa fa-trash-o"></i> Remove</a>
                    </span>
                    <div class="act-pst-lk-stm">
                      <a class="brd-rd5 green-bg-hover" href="#" title="">
                        <i class="ion-heart"></i> Love</a>
                      <a class="brd-rd5 blue-bg-hover" href="#" title="">
                        <i class="ion-thumbsup"></i> Like</a>
                    </div>
                  </div>
                </div>
                <div class="act-pst">
                  <img class="brd-rd50" src="../images/resource/acti-thmb2.jpg" alt="" />
                  <div class="act-pst-inf">
                    <div class="act-pst-inr">
                      <h5>
                        <a href="#" title="">Overtunk</a>
                      </h5> posted in
                      <a href="#" title="">New Blog</a>
                    </div>
                    <span class="spnd-tm">37 Min Ago</span>
                    <div class="act-pst-dta">
                      <p>That's awesome!</p>
                    </div>
                    <span class="pst-tm">
                      <a href="#" title="">
                        <i class="fa fa-trash-o"></i> Remove</a>
                    </span>
                    <div class="act-pst-lk-stm">
                      <a class="brd-rd5 green-bg-hover" href="#" title="">
                        <i class="ion-heart"></i> Love</a>
                      <a class="brd-rd5 blue-bg-hover" href="#" title="">
                        <i class="ion-thumbsup"></i> Like</a>
                    </div>
                  </div>
                </div>

              </div>
              <!-- Activity Post List -->
              <div class="vw-mr-act">
                <div class="pgntn-wrp">
			        <div class="pgntn style2">
			          <ul class="pgntn-lst">
			            <li class="prv">
			              <a href="#" title="">Previous</a>
			            </li>
			            <li>
			              <a href="#" title="">1</a>
			            </li>
			            <li>
			              <span class="active">2</span>
			            </li>
			            <li>
			              <a href="#" title="">3</a>
			            </li>
			            <li>
			              <a href="#" title="">4</a>
			            </li>
			            <li>....</li>
			            <li>
			              <a href="#" title="">9</a>
			            </li>
			            <li class="nxt">
			              <a href="#" title="">Next</a>
			            </li>
			          </ul>
			        </div>
	      </div>
              </div>
            </div>
            
            <div class="usr-actvty-wrp widget pad50-40">
              <h4 class="widget-title">Past Sales</h4>
              <div class="act-pst-lst">
                <div class="act-pst">
                  <img class="brd-rd50" src="../images/resource/acti-thmb1.jpg" alt="" />
                  <div class="act-pst-inf">
                    <div class="act-pst-inr">
                      <h5>
                        <a href="#" title="">Sadi Orlaf</a>
                      </h5> posted in
                      <a href="#" title="">Material</a>
                    </div>
                    <span class="spnd-tm">5 Min Ago</span>
                    <div class="act-pst-dta">
                      <p>That's awesome!</p>
                    </div>
                    <span class="pst-tm">
                      <a href="#" title="">
                        <i class="fa fa-trash-o"></i> Remove</a>
                    </span>
                    <div class="act-pst-lk-stm">
                      <a class="brd-rd5 green-bg-hover" href="#" title="">
                        <i class="ion-heart"></i> Love</a>
                      <a class="brd-rd5 blue-bg-hover" href="#" title="">
                        <i class="ion-thumbsup"></i> Like</a>
                    </div>
                  </div>
                </div>
                <div class="act-pst">
                  <img class="brd-rd50" src="../images/resource/acti-thmb2.jpg" alt="" />
                  <div class="act-pst-inf">
                    <div class="act-pst-inr">
                      <h5>
                        <a href="#" title="">Overtunk</a>
                      </h5> posted in
                      <a href="#" title="">New Blog</a>
                    </div>
                    <span class="spnd-tm">37 Min Ago</span>
                    <div class="act-pst-dta">
                      <p>That's awesome!</p>
                    </div>
                    <span class="pst-tm">
                      <a href="#" title="">
                        <i class="fa fa-trash-o"></i> Remove</a>
                    </span>
                    <div class="act-pst-lk-stm">
                      <a class="brd-rd5 green-bg-hover" href="#" title="">
                        <i class="ion-heart"></i> Love</a>
                      <a class="brd-rd5 blue-bg-hover" href="#" title="">
                        <i class="ion-thumbsup"></i> Like</a>
                    </div>
                  </div>
                </div>

              </div>
              <!-- Activity Post List -->
              <div class="vw-mr-act">
                <div class="pgntn style2">
			          <ul class="pgntn-lst">
			            <li class="prv">
			              <a href="#" title="">Previous</a>
			            </li>
			            <li>
			              <a href="#" title="">1</a>
			            </li>
			            <li>
			              <span class="active">2</span>
			            </li>
			            <li>
			              <a href="#" title="">3</a>
			            </li>
			            <li>
			              <a href="#" title="">4</a>
			            </li>
			            <li>....</li>
			            <li>
			              <a href="#" title="">9</a>
			            </li>
			            <li class="nxt">
			              <a href="#" title="">Next</a>
			            </li>
			          </ul>
			        </div>
              </div>
            </div>
            
          </div>
        </div>
      </div>
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

</html>