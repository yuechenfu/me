<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
  <title>Property</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
  
    <style>
      #map {
		  width: 65%;
		  height: 900px;
		  float: left;
		  border: 1px;
		  align:center;
		}     
	 #datalist {
		  width: 35%;
		  height:900px;
		  float: right;
		  align:center;
	}
    </style>
  </head>
  <body>
    
    <div class="container">
     <div class="row">
      <div id="map" class="col"></div>
      <div id="datalist" class="col"> 
        <c:forEach var="property" items="${propertyList}">
           <div class="item-col col-12 col-sm-6 col-md-4 col-xl-3 post-13170 product type-product status-publish has-post-thumbnail product_cat-dried-fruits first instock sale shipping-taxable purchasable product-type-simple">
                                                <div class="product-wrapper">
                                                    <div class="list-col4">
                                                        <div class="product-image">
                                                            <a href="" class="woocommerce-LoopProduct-link woocommerce-loop-product__link">
                                                                <img width="300" height="300" src="${property.mediaURL}" class="primary_image" alt="" />
                                                                <span class="shadow"></span>
                                                            </a>
                                                            <div class="wishlist-inner">
                                                                
                                                                <div class="clear"></div>
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <div class="list-col8">
                                                        <div class="gridview">
                                                            <h2 class="product-name">
                                                                <a href="">${property.mediaURL }</a>
                                                            </h2>
                                                         
                                                            <div class="price-box">    
                                                                <ins>
                                                                <span class="woocommerce-Price-amount amount">
                                                                  <span class="woocommerce-Price-currencySymbol">&dollar;</span>
                                                                   ${property.price }
                                                                 </span>
                                                                </ins>
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <div class="clearfix"></div>
                                                </div>
                                            </div>
        </c:forEach>
      </div>
      </div>
	</div>
    <script>
	function initMap() {
	  var la = {lat: 34.0522, lng: -118.2437};
	  var map = new google.maps.Map(
	      document.getElementById('map'), {zoom: 7, center: la});
	  var marker = new google.maps.Marker({position: la, map: map});
	}
    </script>
    <script async defer
    src="https://maps.googleapis.com/maps/api/js?key=AIzaSyCuMhCNOD0HtouNQ_rm9igVmd3LD1Z1a-8&callback=initMap">
    </script>
  </body>
</html>