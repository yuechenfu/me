<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<head>
<link rel='stylesheet' id='main-css' href='../css/drop_down.css' type='text/css' media='all' />
</head>
<html>
<body>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarText" aria-controls="navbarText" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>
  <div class="collapse navbar-collapse" id="navbarText">
    <ul class="navbar-nav mr-auto">
      <li class="nav-item active">
        <a class="nav-link" href="#">Buy</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="#">Sell</a>
      </li>
    </ul>
    <ul class="navbar-nav mr-auto">
      <li class="nav-item active">
       <a href="/"> <img alt="logo" src="../images/logo.png" width="100px" height="50px"></a>
      </li>
    </ul>
    <c:if test="${empty loginAccount}">   
    <a href="/account/login" class="nav-link">Sign in or Join</a>
    </c:if>
    <c:if test="${not empty loginAccount}"> 
    <li id="logon">
		  <div class="dropdown">
			  <a href="#"  class="nav-link">${loginAccount.username }</a>
			  <div class="dropdown-content">
			    <p></p>
			    <p  systle="font-size: 18px;font-weight:bold;" >&nbsp;My Home</p>
			    <p><a href="#"  systle="font-size: 10px;font-weight: bold;"> Claim my home </a></p>
			    <p>.....................................</p>
			    <p  systle="font-size: 18px;font-weight: 1000;">&nbsp;My Account </p>
			    <p><a href="#"  systle="font-size: 10px;font-weight: 400;"> Profile </a></p>
			    <p><a href="#"  systle="font-size: 10px;font-weight: 400;"> Subscribtions </a></p>
			    <p><a href="#"  systle="font-size: 10px;font-weight: 400;"> Settings </a></p>
			    <p>.....................................</p>
			    <a href="/account/signout">Sign out</a>
			  </div>
			</div>
      </li> 
      </c:if>
    <a class="nav-link" href="#">Help</a>
  </div>
  <div>
 
  </div>
</nav>
</body>
</html>