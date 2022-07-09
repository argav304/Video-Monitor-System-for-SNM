

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html  lang="en" dir="ltr">
<head>
<title>Trust-Based Video Management Framework for Social Multimedia Networks</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<link rel="stylesheet" href="layout/styles/loginstyle.css" type="text/css" />
</head>
<body>
  <header>
    <div class="container">
      <h1 class="logo">TRUSTY</h1>

      <nav>
        <ul>
          <li><a href="index.html">Home</a></li>
          <li><a href="RemoteUser.jsp">Remote User</a></li>
          <li><a href="VideoServer.jsp">Video Server</a></li>
          
        </ul>
      </nav>
    </div>
  </header>
  <div class="center">
    <h1>Video Server Login</h1>
    <form action="ServerAction.jsp" method="post">
      <div class="txt_field">
        <input type="text"   name="uname" required="">
        <span></span>
        <label>Username</label>
      </div>
      <div class="txt_field">
        <input type="password" name="pwd" required="">
        <span></span>
        <label>Password</label>
      </div>
      
      <input type="submit" value="Login">
      
    </form>
  </div>
</body>
</html>