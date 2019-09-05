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
  <link rel='stylesheet' id='main-css' href='../css/drop_down.css' type='text/css' media='all' />
  <style type="text/css">
    .nav-sign{
      padding-left:100px;
    }
  </style>
  </head>
<body>
<nav class="navbar navbar-expand-sm bg-light"  >
  <ul class="navbar-nav mr-auto">
      <li class="nav-item active">
       <a href="/"> <img alt="logo" src="../images/logo.png" width="100px" height="50px"></a>
      </li>
   </ul>
   <ul class="navbar-nav mr-auto">
      <li class="nav-item active">
        <a class="nav-link" href="#">Buy</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="#">Sell</a>
      </li>
    </ul>
  <!-- Links -->
  <ul class="navbar-nav">
  <form class="form-inline" action="/house/search">
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
       <p class="dropdown-item"><input type="checkbox" name="" id="" value="Houses" />Houses</p>
       <p class="dropdown-item"><input type="checkbox" name="" id="" value="Apartments" />Apartments</p>
       <p class="dropdown-item"><input type="checkbox" name="" id="" value="Condos/co-ops" />Condos/co-ops</p>
       <p class="dropdown-item"><input type="checkbox" name="" id="" value="Townhomes" />Townhomes</p>
       <p class="dropdown-item"><input type="checkbox" name="" id="" value="Manufactured" />Manufactured</p>
       <p class="dropdown-item"><input type="checkbox" name="" id="" value="Lots/Land" />Lots/Land</p>
       <hr>
       <p class="dropdown-button" ><input type="button" value="Done" class="btn btn-primary" /></p>
      </div>
 
    </li>
	<li class="nav-item">
      <a class="nav-link mr-3" href="#">More</a>
    </li>
	<li class="nav-item">	
		<button class="btn btn-primary" type="submit">Save Search</button>
    </li>
    
    <c:if test="${empty loginAccount}">   
    <li  class="nav-sign">
    <a href="/account/login"  class="nav-link">Sign in or Join</a>
    </li>
    </c:if>
    <c:if test="${not empty loginAccount}"> 
    <li class="nav-sign">
		  <div class="dropdown">
			  <a href="#"  class="nav-link mr-3">${loginAccount.username }</a>
			  <div class="dropdown-content">
			    <p></p>
			    <p  systle="font-size: 18px;font-weight:bold;" >&nbsp;My Home</p>
			    <p><a href="#"  systle="font-size: 10px;font-weight: 400;">Claim my home</a></p>
			    <p>.......................................................</p>
			    <p  systle="font-size: 18px;font-weight: 1000;">&nbsp;My Account</p>
			    <p><a href="#"  systle="font-size: 10px;font-weight: 400;">Profile</a></p>
			    <p><a href="#"  systle="font-size: 10px;font-weight: 400;">Subscribtions</a></p>
			    <p><a href="#"  systle="font-size: 10px;font-weight: 400;">Settings</a></p>
			    <p>.......................................................</p>
			    <a href="/account/signout">Sign out</a>
			  </div>
			</div>
      </li> 
      </c:if>
	</form>
  </ul>
  <ul>
  <li><hr></li>
  </ul>
<hr>
</nav>
</body>
</html>
