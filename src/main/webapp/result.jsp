<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Result</title>
		<link rel="icon" href="img/logo.jpg">
		<link href="./bootstrap/css/bootstrap.min.css" rel="stylesheet" />
		<link href="./css/bootstrap-table.min.css" rel="stylesheet">
		<link href="./css/result.css"  rel="stylesheet" />
	</head>
	<body>
	
		<% 
			String omimId=(String) session.getAttribute("omimId");
			if(omimId == null){
				response.sendRedirect("NID.jsp");
			}
		%>
		<div class="header">
			<div class="web_title">
				<h1 style="text-align:center;">
					NIDM
				</h1>
				<div  style="text-align:right;">
					<a href="bakcHome" class="btn btn-info btn-sm"><span class="glyphicon glyphicon-home"></span> Home</a>
					
				</div>
				
			</div>
			
		</div>
		
		
		<div>
			<div class="container">
				<div class="content">
					<div>
						<div>
							<font style="font-size:20px;"><strong style="font-size:25px;"><a href="${phenotypeIdLink}" target="_blank">${phenotypeId}</a></strong>: 
								<a href="${phenotypeNameIdLink}" target="_blank">${phenotypeName}</a></font>
							<br />
							<font style="font-size:18px;">#Found genes:${totalGene} &nbsp;&nbsp;&nbsp;
															#Known disease genes:${knownGene}&nbsp;&nbsp;&nbsp;
															#Candidate genes:${unknown}</font>&nbsp;&nbsp;&nbsp;
							<font  style="margin-left:90px;">
								<a href="downloadFile" type="button" class="btn btn-info" >Download</a>&nbsp;&nbsp;&nbsp;
								<a href="./vis.jsp?geneSymbol=${totalGenes}" target="_blank" class="btn btn-info" >Network Visualization </a>
							</font>
							
						</div>
						<table id="top_genes">
						</table>
					</div>
				</div>
			</div>
		</div>
		
		<div class="footer">
			
		</div>
	</body>
	<script type="text/javascript" src="./js/jquery-1.12.0.min.js"></script>
	<script type="text/javascript" src="./bootstrap/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="./bootstrap/js/bootstrap-table.min.js"></script>
	<script type="text/javascript">
		$(function(){
			var top_gene = ${genes};
			$("#top_genes").bootstrapTable({
				data: top_gene,
				striped:true,
				showRefresh:false,
				pagination:true,
				slidePagination:"client",
				pageSize:10,
				pageNumber:1,
				paginationFirstText:"first",
				paginationPreText:"up",
				paginationNextText:"next",
				paginationLastText:"last",
				buttonClass:"btn",
				iconSize:"page",
				columns:[{
					field:"rank",
					title:"Rank"
				},{
					field:"symbol",
					title:"Gene Symbol"
				},{
					field:"id",
					title:"Entrez Id"
				},{
					field:"score",
					title:"Score"
				},{
					field:"chromosome",
					title:"Chr"
				},{
					field:"cyto",
					title:"Cyto Location"
				},{
					field:"locationBegin",
					title:"Gene Start"
				},{
					field:"locationEnd",
					title:"Gene End"
				},{
					field:"omimInfo",
					title:"OMIM"
				},{
					field:"genecards",
					title:"Genecards"
				},{
					field:"bioGPS",
					title:"BioGPS"
				},{
					field:"visualization",
					title:"VIS"
				}],
				onLoadSuccess:function(){
					
				},
				onLoadError:function(){
					return "load error";
				},
				formatLoadingMessage:function(){
					return "loading";
				}
			});
			
		});
	</script>
</html>