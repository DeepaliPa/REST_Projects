<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<title>Messages</title>

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

.first {
	height: 45%;
	width: 100%;
}
.second1 {
    padding-top:2%;
	height: 55%;
}
.third1{
  padding-top:2%;
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
	<div class="second1">
		<div class="row">
			<div class="col-sm-4"></div>
			
			<div class="col-sm-4 third1" style="background-color: pink;">
				
					<div>
						<label for="Message">MESSAGE : </label>
						<textarea id="msgTextArea">Please select the option</textarea>
					</div>
					
					<div>
						 <input type="hidden" id="hiddenField" name="messageId" value="">
					</div>
					
					<div><label>SELECT OPTION: </label>
					
				
						  <input type="radio" id ="option1" name="options" value="opt1"> Chinese
                          | <input type="radio" id ="option2" name="options" value="opt2"> Indian
                          | <input type="radio" id ="option3" name="options" value="opt3"> Mexican
                          | <input type="radio" id ="option4" name="options" value="opt4"> Italian
					</div>
					
					<div>
						<label for="date">DATE:</label> <input id="dateCreated" type="datetime-local" name="dateCreated" value="2017-23-10T08:30">
					</div>
					
					<div>
					    <label></label><button type='button' id="submitButton">SUBMIT</button>
					    <button type='button' id="editButton">EDIT</button>
					    <button type='button' id="updateButton">UPDATE</button>
					</div>
					
			</div>
			
			<div class="col-sm-4"></div>
		</div>
	</div>
</body>
<script>
	$(document).ready(function() {
		$("#msgTextArea").prop('disabled', true);
		$.ajax({
			type : "GET",
			dataType : "json",
			url : "http://localhost:8080/messenger/webapi/messages/",
			success : function(data) {
				document.getElementById("msgTextArea").innerHTML = "";
				document.getElementById("option1").innerHTML = "";
				document.getElementById("option2").innerHTML = "";
				document.getElementById("option3").innerHTML = "";
				document.getElementById("option4").innerHTML = ""; 
				document.getElementById("hiddenField").innerHTML = ""; 
				
				alert('success');
				document.getElementById("msgTextArea").innerHTML = data[3].message;
				document.getElementById("option1").innerHTML = data[4].opt1;
				document.getElementById("option2").innerHTML = data[5].opt2;
				document.getElementById("option3").innerHTML = data[6].opt3;
				document.getElementById("option4").innerHTML = data[7].opt4; 
			},
			error : function(data) {
				alert('Something went Wrong!');
			}
		});
		
		$("#submitButton").click(function() {
			
			var username =  $("#username").val();
			var msgId = $("#hiddenField").val();
			var vote = $('input:radio[name="options"]:checked').val()
			var dateVal = $("#dateCreated").val();
			
			$("#username").prop('disabled', true);
			$('input:radio[name="options"]:checked').prop('disabled', true);
			$("#dateCreated").prop('disabled', true);

			var msg = {}

			msg.username=username;
			msg.dateCreated=dateCreated;
			msg.vote = vote;
			msg.msgId =msgId;
			
			var strFinal = JSON.stringify({Message: msg});
			
			var options = {};
			  options.url = "http://localhost:8080/messenger/webapi/votes/";
			  options.type = "POST";
			  options.data = strFinal;
			  options.dataType = "json";
			  options.contentType = "application/json";
			  options.success = function () { alert("Success"); };
			  options.error = function () { alert("Error"); };

			  $.ajax(options);
			
		});
		
		$("#editButton").click(function() {

			$("#username").prop('disabled', false);
			$('input:radio[name="options"]:checked').prop('disabled', false);
			$("#dateCreated").prop('disabled', false);
			$("#submitButton").attr('disabled','disabled');

		});
		
	
	$("#updateButton").click(function() {
		var username = $("#username").val();
		var msgId = $("#hiddenField").val();
		var vote = $('input:radio[name="options"]:checked').val()
		var dateVal = $("#dateCreated").val();
		
		$("#username").prop('disabled', true);
		$('input:radio[name="options"]:checked').prop('disabled', true);
		$("#dateCreated").prop('disabled', true);

		var msg = {}

		msg.username=username;
		msg.dateCreated=dateCreated;
		msg.vote = vote;
		msg.msgId =msgId;
		
		var strFinal = JSON.stringify({Message: msg});
		
		var options = {};
		  options.url = "http://localhost:8080/messenger/webapi/votes/";
		  options.type = "POST";
		  options.data = strFinal;
		  options.dataType = "json";
		  options.contentType = "application/json";
		  options.success = function () { alert('Updated successfully!'); };
		  options.error = function () { alert('Something went Wrong!'); };

		  $.ajax(options);

		});
	});
</script>
						
</html>