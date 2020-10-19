<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>String Visualization</title>
		<link rel="icon" href="img/logo.jpg">
		<link href="./bootstrap/css/bootstrap.min.css" rel="stylesheet" />
		<style type="text/css">
			body {
               font-family: Arial;
               color: #122e4d;
               background: #cedded;
           }
           
        } 
		</style>
		
	</head>
	<body>
		<div>
			<%  
		        String str=request.getParameter("geneSymbol");
		     %>  
		     
        	<input type="text" value="<%=str%>" id="geneSymbol" style="display: none;" />
      
		</div>
		<center>
			<div id="stringEmbedded" >
			</div>
		</center>
		
	</body>
	<script type="text/javascript" src="./js/combined_embedded_network_v2.0.2.js"></script>
	<script>
	
          var inputField = document.getElementById('geneSymbol');
          var text = inputField.value;
          var proteins = text.split(',');
          
          
          /* the actual API query */
          getSTRING('https://string-db.org', {
                      'species':'9606',
                      'identifiers':proteins,
                      'network_flavor':'confidence', 
                      //'required_score':00,
                      'add_white_nodes':10,                          
                      'caller_identity': 'www.awesome_app.org'

          })
      </script>
</html>