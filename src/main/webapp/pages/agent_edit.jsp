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
            <h4>Agent Update</h4>
            <span>Update agent information  in the washington .</span>
             
        </div>
    </div>
    <!-- Page Top -->
    <div class="panel-content">
        <div class="widget pad50-65">
        
            <table class="table table-inverse">
                <thead>
                    <tr>
                        <th>#</th>
                        <th>Photo</th>
                        <th>First Name</th>
                        <th>Last Name</th>
                        <th>Phone</th>
                        <th>Email</th>
                    </tr>
                </thead>
                <tbody>
                  <c:forEach var="agent" items="${agentList}" varStatus="status">
                    <tr>
                        <td><a href ="${pageContext.request.contextPath }/agent/update?id=${agent.id }" ><i class="fa fa-pencil-square-o"></i></a></td>
                        <td><a href="${pageContext.request.contextPath }/agent/detail?id=${agent.id }"><img src="../${agent.photoUrl }" width="40px" height="40px"></a></td>
                        <td>${agent.firstname }</td>
                        <td>${agent.lastname }</td>
                        <td>${agent.phone }</td>
                        <td>${agent.email }</td>
                    </tr>
                    </c:forEach>
                    
                </tbody>
            </table>
        </div>
        
	      <div class="pgntn-wrp">
	        <div class="pgntn style2">
	          <ul class="pgntn-lst">
	            <li>
	              <a href="${pageContext.request.contextPath }/agent/list?currentPage=${Pagination.fristPage }" title="" id="page" >${Pagination.fristPage }</a>
	            </li>
	            <c:forEach var="p"  begin="${Pagination.rangeMin }" end="${Pagination.rangeMax }">
	              <li>
	              <a href="${pageContext.request.contextPath }/agent/list?currentPage=${p}" title="" id="page" >${p}</a>
	            </li>
	            </c:forEach>
	          </ul>
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