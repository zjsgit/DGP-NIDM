<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link rel="icon" href="img/logo.jpg">
	<title>Wait</title>
	<link href="./bootstrap/css/bootstrap.min.css" rel="stylesheet" />
	<style >
		.center-in-center{   
            position: absolute;   
            top: 50%;   
            left: 50%;   
            -webkit-transform: translate(-50%, -50%);   
            -moz-transform: translate(-50%, -50%);   
            -ms-transform: translate(-50%, -50%);   
            -o-transform: translate(-50%, -50%);   
            transform: translate(-50%, -50%);
         }   
	</style>
</head>
<body>
	<% 
		String omimId=(String) session.getAttribute("omimId");
		if(omimId == null){
			response.sendRedirect("NID.jsp");
		}
	%>
	<div class="container">
		<div class="center-in-center">
			<img alt="Waiting……" src="img/loading.gif" calss="img-thumbnail" width="280px" >
		</div>
	</div>
	
	<script type="text/javascript" src="js/jquery-1.12.0.min.js"></script>
	<script type="text/javascript" src="bootstrap/js/bootstrap.min.js"></script>
	<script type="text/javascript">
		$(document).ready(function(){
			setTimeout(function(){
				window.location.href="runalgo"
			}, 1000);
		});
	
	</script>
</body>
</html>