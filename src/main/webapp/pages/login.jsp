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
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <!-- Our Website CSS Styles -->
  <link rel="stylesheet" href="../css/icons.min.css" type="text/css">
  <link rel="stylesheet" href="../css/main.css" type="text/css">
  <link rel="stylesheet" href="../css/responsive.css" type="text/css">
   
</head>
<body class="expand-data panel-data">
  <!-- Options Panel -->
  <div class="panel-content">
    <div class="lgn-wrp grysh">
      <div class="bg-img" style="background-image: url(../images/resource/bg-img1.png);"></div>
      <div class="lgn-innr">
        <div class="widget lgn-frm">
          <div class="frm-tl">
            <h4>Login to Admin</h4>
            <span>Fill your detail to get in</span>
          </div>
          <form  action="/account/login" method="GET">
            <div class="row mrg10">
              <div class="col-md-12 col-sm-12 col-lg-12">
                <input class="brd-rd5"  id="username" name="username" required="required" type="text" placeholder="User name"/>
              </div>
              <div class="col-md-12 col-sm-12 col-lg-12">
                <input class="brd-rd5"  id="password" name="password" required="required" type="password" placeholder="Password"/>
              </div>
              <p>&nbsp;</p>
              <div class="col-md-12 col-sm-12 col-lg-12">
                <button class="green-bg brd-rd5" type="submit" id="Login">Login Now</button>
                <span class="chbx">
                  <input type="checkbox" id="chk1" />
                  <label for="chk1">Remember Me</label>
                </span>
              </div>
              
            </div>
          </form>
        </div>
      </div>
     <footer>
    <p>Copyright
      <a href="http://www.washingtonproperty.com/">Washington</a> &amp; 2019 - 2020</p>
    <span>California Property</span>
  </footer>
    </div>
    <!-- Login Wrapper -->
  </div>
</body>

</html>