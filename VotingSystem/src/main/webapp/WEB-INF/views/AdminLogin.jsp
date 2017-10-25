<!DOCTYPE html>
<html>
<head>
  <title>Admin Page</title>
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

.first {
	height: 45%;
	width: 100%;
}
.second {
    padding-top:2%;
	height: 55%;
}
.third{
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
}​
</style>

</head>
<body>
	<div class="first">
		<div>
			<ul>
				<li><a class="active" href="#home">HOME</a></li>
				<li><a href="logout.htm">LOGOUT</a></li>
			</ul>
		</div>
	</div>
	<div class="second">
		<div class="row">
			<div class="col-sm-4"></div>
			<div class="col-sm-4 third" style="background-color: pink;">
				
					<div>
						<label for="Message">MESSAGE : </label>
						<textarea name="comment" id="myTextarea" required autofocus></textarea>
					</div>
				

					<div id='TextBoxesGroup'>
						<div id="TextBoxDiv1">
							<label>OPTION 1 : </label> <input type='textbox' id='textbox1'> <input type='button' value='+' id='addButton'> <input
							type='button' value='-' id='removeButton'>
						</div>
					</div>
					<div>
						<label for="date">END DATE:</label> <input id="endDate" type="datetime-local" name="endDate" value="2017-23-10T08:30">
					</div>
					<div>
					    <label></label> <button type='button' id="postButton">POST</button>
					</div>
					
			
			</div>
			<div class="col-sm-4"></div>
		</div>
	</div>
</body>

	<script>
		$(document).ready(
						function() { 
							var counter = 2;
							$("#addButton")
									.click(
											function() {

												if (counter > 5) {
													alert("Only 5 options allow");
													return false;
												}

												var newTextBoxDiv = $(
														document
																.createElement('div'))
														.attr(
																"id",
																'TextBoxDiv'
																		+ counter);

												newTextBoxDiv
														.after()
														.html(
																'<label>OPTION '
																		+ counter
																		+ ' : </label>'
																		+ ' <input type="text" name="textbox' + counter +
		      '" id="textbox' + counter + '" value="" >');

												newTextBoxDiv
														.appendTo("#TextBoxesGroup");

												counter++;
											});

							$("#removeButton").click(function() {
								if (counter == 1) {
									alert("No more textbox to remove");
									return false;
								}

								counter--;

								$("#TextBoxDiv" + counter).remove();

							});

							$("#postButton").click(function() {
								
								var username = "DeepaliPa24";
								var msg = $("#myTextarea").val();
								var option1 = $("#textbox1").val();
								var option2 = $("#textbox2").val();
								var option3 = $("#textbox3").val();
								var option4 = $("#textbox4").val();
								var endDate = $("#endDate").val();
								alert('msg-->' + msg);
								alert('option1-->' + option1);
								alert('option2-->' + option2);
								alert('option3-->' + option3);
								alert('option4-->' + option4);
								alert('endDate-->' + endDate);
								
								var msg = {}
								
								msg.message = msg;
								msg.username=username;
								msg.endDate=endDate;
								msg.opt1 = option1;
								msg.opt2 =option2;
								msg.opt3 =option3;
								msg.opt4 =option4;
								
								var strFinal = JSON.stringify({msgg: msg});
								
								var options = {};
								  options.url = "http://localhost:8080/messenger/webapi/messages/";
								  options.type = "POST";
								  options.data = strFinal;
								  options.dataType = "json";
								  options.contentType = "application/json";
								  options.success = function () { alert("Success"); };
								  options.error = function () { alert("Error"); };

								  $.ajax(options);
								
							});
						});

	</script>
</body>
</html>