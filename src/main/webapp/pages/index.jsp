<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Property</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
  <link rel='stylesheet' id='main-css' href='../css/home_list.css' type='text/css' media='all' />
</head>

<body>
<%@include file="header.jsp"%>
	<div id="container">
		<h1 align ="center">Reimagine home <br>
		<h3 align ="center">We’ll help you find a place you’ll love.</h3>
		<br>
		<form action="/house/search" id="search_box">
			<div class="wrapper">
				<input type="text" id="search" name="searchText" placeholder="Enter an address, city, or ZIP code" />
				<button type="submit" class="search_btn"><img src="../images/search_icon.png" title="Search" /></button>
			</div>
		</form>
	
	</div>
 <script src="/js/jquery-1.4.2.min.js"></script>
<script>
    $(function () {
        var $placeholder = $('input[placeholder]');
        if ($placeholder.length > 0) {
            var attrPh = $placeholder.attr('placeholder');
            $placeholder.attr('value', attrPh)
              .bind('focus', function () {
                  var $this = $(this);
                  if ($this.val() === attrPh)
                      $this.val('').css('color', '#171207');
              }).bind('blur', function () {
                  var $this = $(this);
                  if ($this.val() === '')
                      $this.val(attrPh).css('color', '#333');
              });
        }
    });
</script>
<p>

</p>
<div style="text-align:center;clear:both">
</div>
</body>
</html>