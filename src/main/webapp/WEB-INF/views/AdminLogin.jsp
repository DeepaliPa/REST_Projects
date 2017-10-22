<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<title>Registration</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<script type="application/x-javascript">
	
	
	
	
	
	 addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } 





</script>
<meta name="keywords"
	content="Cofrestru Registration Form Responsive Templates, Iphone Widget Template, Smartphone login forms,Login form, Widget Template, Responsive Templates, a Ipad 404 Templates, Flat Responsive Templates" />
<link href="resources/css/styleRegistration.css" rel='stylesheet'
	type='text/css' />
<!--webfonts-->
<link
	href='http://fonts.googleapis.com/css?family=Open+Sans:700,300,600,800,400'
	rel='stylesheet' type='text/css'>
<link href='http://fonts.googleapis.com/css?family=Marvel:400,700'
	rel='stylesheet' type='text/css'>
<!--//webfonts-->
<style type="text/css">
body {
	background: url(resources/images/bg3.png);
	font-family: 'Open Sans', sans-serif;
	text-align: center;
}

a.facebook {
	background: url(resources/images/img-sprite.png) no-repeat 8px 0px;
	width: 38px;
	height: 46px;
	display: block;
}

a.twitter {
	background: url(resources/images/img-sprite.png) no-repeat -25px 0px;
	width: 38px;
	height: 29px;
	display: block;
}

a.gp {
	background: url(resources/images/img-sprite.png) no-repeat -58px 0px;
	width: 38px;
	height: 30px;
	display: block;
}
</style>

</head>
<body>

	<div class="registration">
		<h2>Admin Pannel</h2>

		<button type='button' onclick='RestGet()'>GET</button>
		<!-- form -->

		<div class="clear"></div>
	</div>
	<script>
		//var prefix = "http://localhost:8081";
		var RestGet = function() {
			$.ajax({
				type : 'GET',
				url :  'http://localhost:8080/messenger/webapi/messages',
				async : true,
				success : function(result) {
					alert('First');
				},
				error : function(jqXHR, textStatus, errorThrown) {
					alert('Error');
				}
			});
		}
	</script>
</body>
</html>