<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Disease gene prediction</title>
		<link rel="icon" href="img/logo.jpg">
		<link href="./bootstrap/css/bootstrap.min.css" rel="stylesheet" />
		<link href="./css/NID.css"  rel="stylesheet" />
	</head>
	<body>
		
		<div class="header">
			<div class="web_title">
				<h1 >
					NIDM
				</h1>
			</div>
		</div>
		
		<div>
			<div class="container">
				<div class="content">
					<form role="form" style="width:800px;margin:0 auto;border:2px solid black;" class="form-horizontal">
					
						<div class="form-group" style="margin-top:5px; margin-left:5px;">
							<div class="form-inline">
								<label class="input_label">OMIM ID:</label>
								<input type="text" class="form-control" style="width:100px;" id="phenotype_id" />
								<button id="submit_button" class="btn btn-info">Submit</button>
							</div>
						</div>
						<!-- method section -->
						<div class="form-group" style="margin-top:5px; margin-left:5px;">
							<div class="form-inline">
								<label class="input_label">Method:</label>
								<select class="form-control" style="width:200px;" id="method">
									<option>NIDM_M_Vmt</option>
									<option>NIDM_M_Xmx</option>
									<option>NIDM_M_Xmn</option>
									<option>NIDM_M_Xmt</option>
									<option>NIDM_C_Vmt</option>
									<option>NIDM_C_Xmx</option>
									<option>NIDM_C_Xmn</option>
									<option>NIDM_C_Xmt</option>
									<option>NIDM_R_Vmt</option>
									<option>NIDM_R_Xmx</option>
									<option>NIDM_R_Xmn</option>
									<option>NIDM_R_Xmt</option>
									<option>NIDM_L_Vmt</option>
									<option>NIDM_L_Xmx</option>
									<option>NIDM_L_Xmn</option>
									<option>NIDM_L_Xmt</option>
									
								</select>
							</div>
						</div>
						<div class="tab">
							<ul class="tabs">
								<li><a href="#">Whole Genome</a></li>
								<li><a href="#">Genomical Location</a></li>
								<li><a href="#">Cytogenetic Location</a></li>
							</ul>
							
							<div class="tab_content">
								<div class="tabs_item">
									<div class="form-group" style="margin-top:5px; margin-left:5px;">
										<div class="form-inline">
											<label class="input_label">Top:</label>
											<input id="top_number" class="form-control" type="text" placeholder="10" style="width:80px;" id="top_number" />
										</div>
									</div>
								</div>
								<div class="tabs_item">
									<div class="form-group" style="margin-top:5px; margin-left:5px;">
										<div class="form-inline">
											<label class="input_label">Genomical Location chr:</label>
											<select class="form-control" style="width:100px;" id="geno">
												<option value="-1">select</option>
												<option value="1">1</option>
												<option value="2">2</option>
												<option value="3">3</option>
												<option value="4">4</option>
												<option value="5">5</option>
												<option value="6">6</option>
												<option value="7">7</option>
												<option value="8">8</option>
												<option value="9">9</option>
												<option value="10">10</option>
												<option value="11">11</option>
												<option value="12">12</option>
												<option value="13">13</option>
												<option value="14">14</option>
												<option value="15">15</option>
												<option value="16">16</option>
												<option value="17">17</option>
												<option value="18">18</option>
												<option value="19">19</option>
												<option value="20">20</option>
												<option value="21">21</option>
												<option value="22">22</option>
												<option value="23">23</option>
												<option value="X">X</option>
												<option value="Y">Y</option>
											</select>
											
											<input type="text" class="form-control" style="width:80px;" id="geno_begin_value" />~
											<input type="text" class="form-control" style="width:80px;" id="geno_end_value" />
										</div>
										
									</div>
								
								</div>
								<div class="tabs_item">
									<div class="form-group" style="margin-top:5px; margin-left:5px;">
										<div class="form-inline">
											<label class="input_label">Cytogenetic Location chr:</label>
											<select class="form-control" style="width:100px;" id="cyto">
												<option value="-1">select</option>
												<option value="1">1</option>
												<option value="2">2</option>
												<option value="3">3</option>
												<option value="4">4</option>
												<option value="5">5</option>
												<option value="6">6</option>
												<option value="7">7</option>
												<option value="8">8</option>
												<option value="9">9</option>
												<option value="10">10</option>
												<option value="11">11</option>
												<option value="12">12</option>
												<option value="13">13</option>
												<option value="14">14</option>
												<option value="15">15</option>
												<option value="16">16</option>
												<option value="17">17</option>
												<option value="18">18</option>
												<option value="19">19</option>
												<option value="20">20</option>
												<option value="21">21</option>
												<option value="22">22</option>
												<option value="23">23</option>
												<option value="X">X</option>
												<option value="Y">Y</option>
											</select>
											<select class="form-control" style="width:60px;" id="cyto_begin">
												<option>p</option>
												<option>q</option>
											</select>
											<input type="text" class="form-control" style="width:80px;" id="cyto_begin_value" />
											<select class="form-control" style="width:60px;" id="cyto_end">
												<option>p</option>
												<option>q</option>
											</select>
											<input type="text" class="form-control" style="width:80px;" id="cyto_end_value"/>
											
										</div>
									</div><!-- the section of Cytogenetic Location chr -->
								</div><!-- tabs_item -->
								
							</div>
						</div>
						
						
						
					</form>
					
					<!-- description -->
					<div style="margin-top:10px;font-size:15px;">
						<label>Description:</label>
						<div class="para">
						The development of genetic diseases is closely related to the mutations of disease-related genes. 
						The prediction of the disease-related genes is important to the investigation of the diseases due to high cost and time consumption of biological experiments. 
						Network propagation is a popular strategy for disease-gene prediction in computational biology, but existing methods of this type just focus on the stable solution of dynamics while ignoring the useful information contained in the dynamical process, and it is still a challenge to make full use of the information from various types of biological networks to effectively predict disease-related genes. 
						Therefore, we proposed a framework of network impulsive dynamics on multiplex biological network (NIDM) where the responses of nodes to impulsive signals at specific network nodes are used to identify disease-related genes. 
						We studied four variants of NIDM models and four impulsive dynamical signatures by experimental evaluation in multi-source biological networks (e.g., various protein-protein interactions, gene co-expression and gene semantic similarity), confirmed the excellent performance of NIDM in disease-gene prediction by comparing a series of classical network-based algorithms, and showed the superiority of multiplex network in fusion of multi-source biological networks. 
						For the convenience of experimental scientists, we developed a web server for NIDM (http://bioinformatics.csu.edu.cn/DGP/NIDM.html), by which the users can easily get the results of disease-related candidate genes by three search patterns (genomic location, cytogenetic location and whole network genome) and subnetwork visualization, enrichment analysis and external links of the genes. 
						NIDM is a protocol for disease-gene prediction integrating different types of biological networks, which may become a very useful computational tool for the study of disease-related genes.
					
						</div>
					</div>
					
					<!-- reference -->
					<div style="margin-top:10px;font-size:15px;">
						<label>Reference:</label>
						<div>
							[1] J. Xiang, J.-S. Zhang, M. Li, NIDM: Impulsive dynamics on multiplex biological network for disease-gene prediction, 2020.  <br />
							[2] S. Gómez, A. Díaz-Guilera, J. Gómez-Gardeñes, C. J. Pérez-Vicente, Y. Moreno, and A. Arenas, Diffusion Dynamics on Multiplex Networks, 2013 Physical Review Letters 110 028701.
						</div>
						
					</div>
				</div>
			</div>
		</div>
		
	</body>
	
	<script type="text/javascript" src="./js/jquery-1.12.0.min.js"></script>
	<script type="text/javascript" src="./bootstrap/js/bootstrap.min.js"></script>
	
	<script type="text/javascript">
		$("#document").ready(function(){
			
			(function ($) { 
				$('.tab ul.tabs').addClass('active').find('> li:eq(0)').addClass('current');
				
				$('.tab ul.tabs li a').click(function (g) { 
					var tab = $(this).closest('.tab'), 
						index = $(this).closest('li').index();
					
					tab.find('ul.tabs > li').removeClass('current');
					$(this).closest('li').addClass('current');
					
					tab.find('.tab_content').find('div.tabs_item').not('div.tabs_item:eq(' + index + ')').hide();
					tab.find('.tab_content').find('div.tabs_item:eq(' + index + ')').show();
					
					g.preventDefault();
				} );
			})(jQuery);
			
			
			$("#submit_button").click(function(e){
				
				var formInfo = {
					id:$("#phenotype_id").val(),
					method:$("#method option:selected").text(),
					topNumber:$("#top_number").val(),
					geno:$("#geno option:selected").text(),
					genoBeginValue:$("#geno_begin_value").val(),
					genoEndValue:$("#geno_end_value").val(),
					cyto:$("#cyto option:selected").text(),
					cytoBegin:$("#cyto_begin  option:selected").text(),
					cytoEnd:$("#cyto_end  option:selected").text(),
					cytoBeginValue:$("#cyto_begin_value").val(),
					cytoEndValue:$("#cyto_end_value").val()
				};
				
				e.preventDefault();
				
				$.ajax({
					type:"POST",
					url:"submmitForm",
					data:formInfo,
					dataType:"json",
					success:function(data){
						if(data.status == "OK"){
							location.href="wait.jsp";
						}
					},
					error:function(data){
						alert(JSON.stringify(data));
					}
				});
			});
		});
	
	</script>
</html>