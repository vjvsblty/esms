<!DOCTYPE html>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="java.util.ArrayList" %>

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

.block {
  display: block;
  width: 100%;
  border: none;
  background-color: #04AA6D;
  color: white;
  padding: 14px 28px;
  font-size: 16px;
  cursor: pointer;
  text-align: center;
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
      <li class="active"><a href="/">Home</a></li>
    </ul>
    <ul class="nav navbar-nav navbar-right">
      <li><a href="#"><span class="glyphicon glyphicon-user"></span>Welcome ${name}</a></li>
      <li><a href="/login"><span class="glyphicon glyphicon-log-out"></span> LogOut</a></li>
    </ul>
  </div>
</nav>

<div class="container container-table">
<div class="table-responsive">
 <table border="1" class="table">
 	<thead>
 	<tr><th colspan="7" style="color: green; text-align: center">All Drivers List</th></tr>
 		<tr>
 		    <th>#</th>
 			<th>First Name</th>
 			<th>Last Name</th>
 			<th>Mobile Number</th>
 			<th>Email</th>
 			<th>City</th>
 			<th>State</th>
 			<th>Country</th>
 		</tr>
 	</thead>
 	<tbody>
 	<c:set var="i" value="1" />
 	<c:forEach items="${drivers}" var="u">
 		<tr>
 			<td>${i}</td>
 			<td>${u.firstName}</td>
 			<td>${u.lastName}</td>
 			<td>${u.mobile}</td>
 			<td>${u.email}</td>
 			<td>${u.city}</td>
 			<td>${u.state}</td>
 			<td>${u.country}</td>
 		</tr>
 		<c:set var="i" value="${i+1}" />
 	</c:forEach>
 	</tbody>
 </table>
</div>
</div>

<div class="container container-table">
<div class="table-responsive">
 <table border="1" class="table">
 	<thead>
 	<tr><th colspan="8" style="color: green; text-align: center">All Donors List</th></tr>
 		<tr>
 		    <th>#</th>
 			<th>First Name</th>
 			<th>Last Name</th>
 			<th>Blood Group</th>
 			<th>Mobile Number</th>
 			<th>Email</th>
 			<th>City</th>
 			<th>State</th>
 			<th>Country</th>
 		</tr>
 	</thead>
 	<tbody>
 	<c:set var="i" value="1" />
 	<c:forEach items="${donors}" var="u">
 		<tr>
 			<td>${i}</td>
 			<td>${u.firstName}</td>
 			<td>${u.lastName}</td>
 			<td>${u.bloodGroup}</td>
 			<td>${u.mobile}</td>
 			<td>${u.email}</td>
 			<td>${u.city}</td>
 			<td>${u.state}</td>
 			<td>${u.country}</td>
 		</tr>
 		<c:set var="i" value="${i+1}" />
 	</c:forEach>
 	</tbody>
 </table>
</div>
</div>

<br><br>
<footer align="center">All rights reserved @Pvp college 2022</footer>
</body>
</html>