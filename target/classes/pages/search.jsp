<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
  </head>
<body>
<%@include file="header.jsp"%>
 
<nav class="navbar navbar-expand-sm bg-light">
  <!-- Links -->
  <ul class="navbar-nav">
  <form class="form-inline" action="/property/house/search">
    <li class="nav-item">
     <div class="input-group">
      <div class="input-icon-group">
        <div class="input-group" style="width:100%">
           <input type="text" class="form-control" id="search" name="search" value="${searchText}" data-clearbtn="true">
               <span class="input-group-addon"><i class="md md-center-focus-weak fa-lg"> </i></span> 
           </input>
        </div>
      </div>
	</div>
    </li>
    <li class="nav-item">
      <a class="nav-link mr-1" href="#" border:1px;>Listing type</a>
    </li>
	<li class="nav-item">
      <a class="nav-link mr-1" href="#">Price</a>
    </li>
	<li class="nav-item">
      <a class="nav-link mr-1" href="#">Beds</a>
    </li>
    <!-- Dropdown -->
    <li class="nav-item dropdown">
      <a class="nav-link dropdown-toggle mr-1" href="#" id="navbardrop" data-toggle="dropdown">
        Home type
      </a>
      <div class="dropdown-menu">
        <a class="dropdown-item" href="#">Link 1</a>
        <a class="dropdown-item" href="#">Link 2</a>
        <a class="dropdown-item" href="#">Link 3</a>
      </div>
    </li>
	<li class="nav-item">
      <a class="nav-link mr-3" href="#">More</a>
    </li>
	<li class="nav-item">	
		<button class="btn btn-primary" type="submit">Save Search</button>
    </li>
	</form>
  </ul>
  <ul>
  <li><hr></li>
  </ul>
<hr>
</nav>
</body>
</html>
