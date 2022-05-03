<!DOCTYPE html>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

<style>
body {font-family: Arial, Helvetica, sans-serif;}
form {border: 3px solid #f1f1f1;}

input[type=text], input[type=password] {
  width: 100%;
  padding: 12px 20px;
  margin: 8px 0;
  display: inline-block;
  border: 1px solid #ccc;
  box-sizing: border-box;
}

button {
  background-color: #04AA6D;
  color: white;
  padding: 14px 20px;
  margin: 8px 0;
  border: none;
  cursor: pointer;
  width: 100%;
}

button:hover {
  opacity: 0.8;
}

.cancelbtn {
  width: auto;
  padding: 10px 18px;
  background-color: #f44336;
}

.imgcontainer {
  text-align: center;
  margin: 24px 0 12px 0;
}

img.avatar {
  width: 40%;
  border-radius: 50%;
}

.container {
  padding: 16px;
}

span.psw {
  float: right;
  padding-top: 16px;
}

/* Change styles for span and cancel button on extra small screens */
@media screen and (max-width: 300px) {
  span.psw {
     display: block;
     float: none;
  }
  .cancelbtn {
     width: 100%;
  }
}
</style>
</head>
<body>

<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="/">Emergency Services</a>
    </div>
    <ul class="nav navbar-nav">
      <li><a href="/">Home</a></li>
    </ul>
    <ul class="nav navbar-nav navbar-right">
      <li class="active"><a href="#"><span class="glyphicon glyphicon-user"></span> Sign Up</a></li>
      <li><a href="/login"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
    </ul>
  </div>
</nav>

<form:form action="/register" method="POST" modelAttribute="user">
  <div class="imgcontainer">
    <img src="./images/login_avatar.png" alt="Avatar" class="avatar" style="width:160px">
  </div>

  <div class="container container-table">
  <h3 class="box-title" style="color:red"><strong>${register_msg}</strong></h3>
    <form:label path="email"><b>Email</b></form:label>
    <form:input type="text" placeholder="Enter Email" path="email" required="required"/>

    <form:label path="firstName"><b>First Name</b></form:label>
    <form:input type="text" placeholder="Enter First Name" path="firstName" required="required"/>

    <form:label path="lastName"><b>Last Name</b></form:label>
    <form:input type="text" placeholder="Enter Last Name" path="lastName" required="required"/>

    <form:label path="mobile"><b>Mobile</b></form:label>
    <form:input type="text" placeholder="Enter Mobile" path="mobile" required="required"/>

    <form:label path="bloodGroup"><b>Blood Group</b></form:label>
    <form:input type="text" placeholder="Enter Blood Group" path="bloodGroup" required="required"/>

    <form:label path="city"><b>City</b></form:label>
    <form:input type="text" placeholder="Enter City" path="city" required="required"/>

    <form:label path="state"><b>State</b></form:label>
    <form:input type="text" placeholder="Enter State" path="state" required="required"/>

    <form:label path="country"><b>Country</b></form:label>
    <form:input type="text" placeholder="Enter Country" path="country" required="required"/>

    <form:label path="password"><b>Password</b></form:label>
    <form:input type="password" placeholder="Enter Password" path="password" required="required"/>

    <button type="submit">Register</button>
  </div>

</form:form>
<br><br><footer align="center">All rights reserved @Pvp college 2022</footer>
</body>
</html>
