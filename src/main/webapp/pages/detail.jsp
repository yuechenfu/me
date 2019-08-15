<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head> 
<link rel='stylesheet' id='main-css' href='../css/main_list.css' type='text/css' media='all' />
<script type="text/javascript" src="http://code.jquery.com/jquery-1.9.1.min.js"></script> 
<style type="text/css">
position: fixed;
}

</style>
</head>
<body>
    <section class="flexModal fixedLeft">
      <nav> 
       <div id="map1" ></div>
      </nav>
      <article>
      
       <table border="1" align="center">
        
       <p align="left"  style="padding-left:40px;">${searchText} Real Estate & Homes For Sale</p>
       <p align="left"  style="padding-left:40px;">${searchCount } results</p>
        <c:forEach var="property" items="${propertyList}" varStatus="status">
           <c:if test="${status.index%2==0}">
			<tr>
		   </c:if>
			<td>
			    <div>
                    <a href="" class="woocommerce-LoopProduct-link woocommerce-loop-product__link">
                        <img width="350" height="200" src="${property.mediaURL}" class="primary_image" alt="" />
                    </a>
                    <div >
                      <span style="font-style:Courier New;font-size:20px;">$${property.price }</span>
                      <span style="font-style:Courier New;font-size:15px;">${property.bedRooms } bds | ${property.bathRooms } ba | ${property.livingArea } sqft</span>
                      <p style="font-style:Courier New;font-size:15px;">${property.address }</p>
                    </div>
                </div>
			</td>
		  <c:if test="${status.index%2!=0}">
			</tr>
			</c:if>
        </c:forEach>
        
        <tr>
        <td colspan=2>
        <p class="paging">
                            <a href="Staff_ListServlet?page=${paging.indexpage-1}">&lt;&lt; first </a>
                            <a href="Staff_ListServlet?page=${paging.page-1 }">    &lt; last </a>
                            <strong>${paging.page+1}/total ${paging.pagenumber}</strong>
                            <a href="Staff_ListServlet?page=${paging.page+1}">next &gt;</a>
                            <a href="Staff_ListServlet?page=${paging.pagenumber-1}">end &gt;&gt;</a>
        </p>
        </td>
        <tr>
        </table>
        
      </article>
      
    </section> 
   
    </body>
  </html>