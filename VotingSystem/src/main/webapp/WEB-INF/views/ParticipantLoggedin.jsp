<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <title>Participant Page</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<style>
ul {
    list-style-type: none;
    margin: 0;
    padding: 0;
    overflow: hidden;
    background-color: #333;
    height: 1.5cm;
    text-align: center;
}

li {
    text-align: center;
    float: left;
}

li a {
    height: 2cm;
    display: block;
    color: white;
    font-size: 20px;
    text-align: center;
    padding: 19px 16px;
    text-decoration: none;
}

li a:hover:not(.active) {
    background-color: #111;
}

.active {
    background-color: #4CAF50;
}

li.hover{
    background-color: skyblue;
}

.first {
	width: 100%;
}
.second {
    padding-top:2%;
	padding-left: 13%;
    font-size: 25px;
}
.third{
  padding-top:3%;
  padding-right:1%;
  padding-left: 1%;
  padding-bottom: 10%;
}
.four{
 background-color:yellow;
}
label {
  display: inline-block;
  width: 140px;
  font-size: 15px;
  text-align: right;
}
body{
    background-color: lightgoldenrodyellow;
}​
</style>
</head>
<body>
	<div class="first">
		<div>
			<ul>
				<li><a class="active" href="#home">HOME</a></li>
				<li><a class="message" href="#messagesGet">Messages</a></li>
				<li><a href="logout.htm">Logout</a></li>
			</ul>
		</div>
	</div>
	<div class="second">
		<div class="row">
			<div class="col-sm-4"></div>
			<div class="col-sm-4">Welcome ${param.username}</div>
			<div class="col-sm-4"></div>
		</div>
	</div>
	<div class="third">
		<div class="row">
			<div class="col-sm-1"></div>
			<div class="col-sm-10" id="messagesGet">
				<jsp:include page="Messages.jsp"></jsp:include>
			</div>
			<div class="col-sm-1"></div>
		</div>
	</div>
</body>
</html>