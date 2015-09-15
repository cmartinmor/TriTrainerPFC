<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">

<title>TriTrainer</title>

<!-- Bootstrap core CSS -->
	<script type="text/javascript" src="/js/jquery.easing-1.3.pack.js"></script>
	<script type="text/javascript" src="/js/jquery.mousewheel-3.0.4.pack.js"></script>

	<script type="text/javascript" src="/js/jquery.fancybox-1.3.4.js"></script>
	<link rel="stylesheet" type="text/css" href="/js/jquery.fancybox-1.3.4.css" media="screen" />
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css?family=Open+Sans:400,600,800">
<link href="../css/bootstrap.css" rel="stylesheet">
<link href="../css/stats.css" rel="stylesheet">
<link href="../css/sb-admin.css" rel="stylesheet">
<link
	href="//netdna.bootstrapcdn.com/font-awesome/4.1.0/css/font-awesome.min.css"
	rel="stylesheet">
<!-- Page Specific CSS -->


<link rel="stylesheet"
	href="http://cdn.oesmith.co.uk/morris-0.4.3.min.css">
<script type="text/javascript" src="../js/jquery.min.js"></script>
<script type="text/javascript" src="../js/jquery.sparkline.js"></script>

</head>

<body>

	<div>

		<!-- Sidebar -->
<%@ include file="header.jsp" %>

		<div id="page-wrapper">

			<div class="row">
				<div class="col-lg-12">
					<h1>
						Training <small>Statistics Overview</small>
					</h1>
					<ol class="breadcrumb">
						<li class="active"><i class="fa fa-tasks"></i> Task</li>
					</ol>

				</div>
			</div>
			<!-- /.row -->

			<div class="row">
				<div class="col-lg-4">
					<div class="panel panel-info">
						<a href="#">
							<div class="panel-heading announcement-bottom">
								<div class="row">
									<div class="col-xs-6">Yesterdays</div>
									 
									<s:set var = "breakLoop" value = "%{false}" /> 
									<s:iterator value="entrenamientoAyer">
									<s:if test = "!#breakLoop">
										<div class="col-xs-6 text-right">
											<i class="fa fa-arrow-circle-right" href="#" class="" data-toggle="modal" data-target="#ModalAyer"></i>	
										</div>
										<s:set var = "breakLoop" value = "%{true}"/>
									</s:if>
									</s:iterator>
								</div>
							</div>
						</a>
						<div class="panel-heading">
							<div class="row">

								<div class="text-center">
									<table class="table table-striped">
										<thead align="center">
											<tr>
												
												<th>Descriptions</th>
												<th>Repeticiones</th>
												<th>Series</th>
												<th>Distance</th>
											</tr>
										</thead>
										<tbody>
										<s:iterator value="entrenamientoAyer">
											<s:set name="varSeries" value="series"/>
											<s:set name="varIdEntrenoEjercicioA" value="id_entreno_ejercicio"/>
											<s:set name="varFechaA" value="fechaA"/>



												<tr>

													<td><a rel="vimeo" id="vimeo_test3" href="<s:property value="uRL_video" />" title="Cargo (Trailer)"><s:property value="descripcion" /> </a></td>

													<td><s:property value="repeticiones" /></td>
													<s:if test="%{#varSeries!=0}">
														<td><s:property value="series" /></td>
													</s:if>
													<s:else>
														<td></td>
													</s:else>
													<td><s:property value="distancia" /></td>
													
												</tr>
											</s:iterator>	
										</tbody>
									</table>


									

								</div>
							</div>
						</div>

					</div>
				</div>
				<div class="col-lg-4">
					<div class="panel panel-warning">
						<a href="#">
							<div class="panel-heading announcement-bottom">
								<div class="row">
									<div class="col-xs-6">Today</div>

									<s:set var = "breakLoop" value = "%{false}" /> 
									<s:iterator value="entrenamientoHoy">
									<s:if test = "!#breakLoop">
									<div class="col-xs-6 text-right">
										<i class="fa fa-arrow-circle-right" href="#" class="" data-toggle="modal" data-target="#ModalHoy"></i>
									</div>
									<s:set var = "breakLoop" value = "%{true}"/>
									</s:if>
									</s:iterator>

								</div>
							</div>
						</a>
						<div class="panel-heading">
							<div class="row">

								<div class="text-center">

										<table class="table table-striped">
										<thead>
											<tr>
												
												<th>Description</th>
												<th>Repeticiones</th>
												<th>Series</th>
												<th>Distance</th>
											</tr>
										</thead>
										<tbody>
										<s:iterator value="entrenamientoHoy">
											<s:set name="varSeries" value="series"/>
											<s:set name="varIdEntrenoEjercicioH" value="id_entreno_ejercicio"/>
											<s:set name="varFechaH" value="fechaH"/>
											<tr>
												
												<td><a rel="vimeo" id="vimeo_test3" href="<s:property value="uRL_video" />" title="Cargo (Trailer)"><s:property value="descripcion"/></a></td>
												<td><s:property value="repeticiones"/></td>
												<s:if test="%{#varSeries!=0}">
													<td><s:property value="series"/>
													</td>	
													
												</s:if>
												<s:else>
													<td></td>
												</s:else>
												<td><s:property value="distancia"/></td>
											</tr>
										</s:iterator>	
										</tbody>
									</table>
									</ul>
									</p>
								</div>
							</div>
						</div>

					</div>
				</div>
				<div class="col-lg-4">
					<div class="panel panel-danger">
						<a href="#">
							<div class="panel-heading announcement-bottom">
								<div class="row">
									<div class="col-xs-6">Tomorrow</div>
									<s:set name="varIdEjercicio" value="idEjercicioM"/>
									<%--<s:if test="%{#varIdEjercicio>28}">--%>
										<div class="col-xs-6 text-right">
											<i class="fa fa-arrow-circle-right" href="#" class="" data-toggle="modal" data-target="#ModalManyana"></i>	
										</div>
									<%--</s:if>--%>
								</div>
							</div>
						</a>
						<div class="panel-heading">
							<div class="row">

								<div class="text-center">
										<table class="table table-striped">
										<thead>
											<tr>
												
												<th>Description</th>
												<th>Repeticiones</th>
												<th>Series</th>
												<th>Distance</th>
											</tr>
										</thead>
										<tbody>
										<s:iterator value="entrenamientoMayana">
											<s:set name="varSeries" value="series"/>
											<s:set name="varIdEntrenoEjercicioM" value="id_entreno_ejercicio"/>
											<s:set name="varFechaM" value="fechaM"/>
											<tr>
												
												<td><a rel="vimeo" id="vimeo_test3" href="<s:property value="uRL_video" />" title="Cargo (Trailer)"><s:property value="descripcion"/></a></td>
												<td><s:property value="repeticiones"/></td>
												<s:if test="%{#varSeries!=0}">
													<td><s:property value="series"/></td>	
												</s:if>
												<s:else>
													<td></td>
												</s:else>
												<td><s:property value="distancia"/></td>
											</tr>
										</s:iterator>	
										</tbody>
									</table>
									</ul>
									</p>
								</div>
							</div>
						</div>

					</div>
				</div>
				<div class="row">
					<div class="col-lg-12">

						<ol class="breadcrumb">
							<li class="active"><i class="fa fa fa-bar-chart-o"></i>
								Stats</li>
						</ol>

					</div>
				</div>


				<div class="row">
					<div class="col-lg-4">
						<div class="panel panel-primary">
							<div class="panel-heading">
								<h3 class="panel-title">
									<i class="fa fa-long-arrow-right"></i> Training distribution
								</h3>
							</div>
							<div class="panel-body">
								<div id="morris-chart-donut"></div>
								<div class="text-right">
									<a href="#">View Details <i
										class="fa fa-arrow-circle-right"></i></a>
								</div>
							</div>
						</div>
					</div>
					<div class="col-lg-4">
						<div class="panel panel-primary">
							<div class="panel-heading">
								<h3 class="panel-title">
									<i class="fa fa-clock-o"></i> Athlete BIO
								</h3>
							</div>
							<div class="panel-body">
								<div class="box">
									<div class="box-header">
										<span class="title">Here be your stats</span>
										<ul class="box-toolbar">
											<li><span class="label label-blue">189</span></li>
										</ul>
									</div>
									<div class="box-content">
										<table class="table table-normal">
											<thead>
												<tr>
													<td></td>
													<td>Item</td>
													<td>Stats</td>
												</tr>
											</thead>

											<tbody>
												<tr>
													<td style="width: 60px;"><span class="dynamicbar">Loading..</span></td>
													<td style="text-align: center;"><i class="fa fa-child"></i>
														Peso</td>
														<s:set var="varpeso" value="peso" />
													<s:if test="%{#varpeso > 0.0}">
													<td class="status-success"><i
														class="icon-circle-arrow-up"></i>+<s:property value="peso"/>% </td>
													</s:if>
													<s:else>
													<td class="status-error"><i
														class="icon-circle-arrow-down"></i><s:property value="peso"/>% </td>
													</s:else>
												</tr>

												<tr>
													<td style="width: 60px;"><span class="dynamicbarF">Loading..</span></td>
													<td style="text-align: center;"><i class="icon-heart"></i>
														FCR</td>
													<td class="status-success"><i
														class="icon-circle-arrow-up"></i> +10%</td>
												</tr>

												<tr>
													<td style="width: 60px;"><span class="dynamicbarM">Loading..</span></td>
													<td style="text-align: center;"><i class="icon-bell"></i>
														FCM</td>
													<s:if test="%{#FCM > 0.0}">
													<td class="status-success"><i
														class="icon-circle-arrow-up"></i>+<s:property value="FCM"/>% </td>
													</s:if>
													<s:else>
													<td class="status-error"><i
														class="icon-circle-arrow-down"></i><s:property value="FCM"/>% </td>
													</s:else>
												</tr>

												<tr>
													<td style="width: 60px;"><span class="dynamicbarR">Loading..</span></td>
													<td style="text-align: center;"><i class="icon-trophy"></i>
														Run 1k</td>
													
													<td class="status-success"><s:property value="mejorRun"/> </td>
												
												</tr>

												<tr>
													<td style="width: 60px;"><span class="dynamicbarS">Loading..</span></td>
													<td style="text-align: center;"><i class="icon-trophy"></i>
														Swim 100m</td>
													
													<td class="status-success"><s:property value="mejorSwim"/> </td>
													
												</tr>

												<tr>
													<td style="width: 60px;"><span class="dynamicbarC">Loading..</span></td>
													<td style="text-align: center;"><i class="icon-trophy"></i>
														Cycle 20k</td>
													
													<td class="status-success"><s:property value="mejorCicle"/> </td>
													
												</tr>
											</tbody>
										</table>


									</div>
								</div>

							</div>
						</div>
					</div>
					<div class="col-lg-4">
						<div class="panel panel-primary">
							<div class="panel-heading">
								<h3 class="panel-title">
									<i class="fa fa-money"></i> Recent Results Test
								</h3>
							</div>
							<div class="panel-body">
								<div class="table-responsive">
									<table
										class="table table-bordered table-hover table-striped tablesorter">
										<thead>
											<tr>
												<th>Date <i class="fa fa-sort"></i></th>
												<th>Sport <i class="fa fa-sort"></i></th>
												<th>Distance <i class="fa fa-sort"></i></th>
												<th>Time <i class="fa fa-sort"></i></th>
												<th>FCMax <i class="fa fa-sort"></i></th>
											</tr>
										</thead>
										<tbody>
										<s:iterator value="test">
											<tr>
												
												<td><s:property value="fecha"/></td>
												<td><s:property value="tipoEjercicio"/></td>
												<td><s:property value="distancia"/></td>
												<td><s:property value="tiempo"/></td>
												<td><s:property value="FCMax"/></td>
											</tr>
										</s:iterator>	
										</tbody>
									</table>
								</div>
								<div class="text-right">
									<a href="#">View All Transactions <i
										class="fa fa-arrow-circle-right"></i></a>
								</div>
							</div>
						</div>
					</div>
				</div>
				<!-- /.row -->

			</div>
			<div class="modal fade" id="ModalAyer" tabindex="-1">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">&times;</button>
					<h4 class="modal-title" id="myModalLabel">Introduce your data</h4>
				</div>
				<div class="modal-body">
					
		<div class="container">
		<s:actionerror />
		<div class="row">
			<div
				class="col-md-12">
				<s:form action="guardar.action" method="post" theme="simple"
					id="contact-form">
					<h2>
						Please fill up all the gaps. <small> Tell us how do you feel.</small>
					</h2>
					<hr class="colorgraph">
					<s:hidden name="id_entreno_ejercicioAyer" key="label.id_entreno_ejercicioAyer" value="%{#varIdEntrenoEjercicioA}" />
					<s:hidden name="fecha" key="label.fecha" value="%{#varFechaA}" />
					<div class="row">
						<div class="col-xs-4 col-sm-4 col-md-4">
							<div class="form-group">
								<s:textfield name="pulsaciones" key="label.pulsaciones"
									required="true" cssClass="form-control input-lg"
									placeholder="Max Heart Rate" label="" tabindex="1" />
							</div>
						</div>
						<div class="col-xs-4 col-sm-4 col-md-4">
							<div class="form-group">
								<s:textfield name="tiempo" key="label.tiempo"
									required="true" cssClass="form-control input-lg"
									placeholder="Time" tabindex="2" />
							</div>
						</div>
						<div class="col-xs-4 col-sm-4 col-md-4">
							<div class="form-group">
								<s:textfield name="Weight" key="label.Weight"
									required="true" cssClass="form-control input-lg"
									placeholder="Weight" tabindex="2" />
							</div>
						</div>
						<div class="col-xs-4 col-sm-4 col-md-4">
							<div class="form-group">
								<s:textfield name="AvHR" key="label.AvHR"
									required="true" cssClass="form-control input-lg"
									placeholder="Average HR" tabindex="2" />
							</div>
						</div>
					</div>
					<div class="row">
						<div class="col-xs-6 col-sm-6 col-md-6">
							<div class="form-group">
								<s:select label="Sesation" 
								headerKey="-1" headerValue="-- Sensation --"
								list="#{'1':'1', '2':'2', '3':'3', '4':'4', '5':'5'}" 
								name="Sensation" cssClass="form-control"/>
							</div>
						</div>
						<div class="col-xs-6 col-sm-6 col-md-6">
							<div class="form-group">
								<s:select label="conseguido" 
								headerKey="-1" headerValue="-- Finished --"
								list="#{'1':'Yes', '0':'No'}" 
								name="Finish" cssClass="form-control"/>
							</div>
						</div>
					</div>
					
					
					<hr class="colorgraph">
					<div class="row">
					<div class="col-md-4 "></div>
						<div class="col-md-4">
							<s:submit method="execute" key="label.Guardar"
								cssClass="btn btn-primary btn-block btn-lg" value="Save" />
						</div>
					<div class="col-md-4 "></div>	
					</div>
				</s:form>
			</div>
		</div>
					</div>
				</div>
				</div>
			</div>
		</div>
	<div class="modal fade" id="ModalHoy" tabindex="-1">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">&times;</button>
					<h4 class="modal-title" id="myModalLabel">Introduce your data</h4>
				</div>
				<div class="modal-body">
					
		<div class="container">
		<s:actionerror />
		<div class="row">
			<div
				class="col-md-12">
				<s:form action="guardar.action" method="post" theme="simple"
					id="contact-form">
					<h2>
						Please fill up all the gaps. <small> Tell us how do you feel.</small>
					</h2>
					<hr class="colorgraph">
					<s:hidden name="id_entreno_ejercicioHoy" key="label.id_entreno_ejercicioHoy" value="%{#varIdEntrenoEjercicioH}" />
					<s:hidden name="fecha" key="label.fecha" value="%{#varFechaH}" />
					<div class="row">
						<div class="col-xs-4 col-sm-4 col-md-4">
							<div class="form-group">
								<s:textfield name="pulsaciones" key="label.pulsaciones"
									required="true" cssClass="form-control input-lg"
									placeholder="Max Heart Rate" label="" tabindex="1" />
							</div>
						</div>
						<div class="col-xs-4 col-sm-4 col-md-4">
							<div class="form-group">
								<s:textfield name="tiempo" key="label.tiempo"
									required="true" cssClass="form-control input-lg"
									placeholder="Time" tabindex="2" />
							</div>
						</div>
						<div class="col-xs-4 col-sm-4 col-md-4">
							<div class="form-group">
								<s:textfield name="Weight" key="label.Weight"
									required="true" cssClass="form-control input-lg"
									placeholder="Weight" tabindex="2" />
							</div>
						</div>
						<div class="col-xs-4 col-sm-4 col-md-4">
							<div class="form-group">
								<s:textfield name="AvHR" key="label.AvHR"
									required="true" cssClass="form-control input-lg"
									placeholder="Average HR" tabindex="2" />
							</div>
						</div>
					</div>
					<div class="row">
						<div class="col-xs-6 col-sm-6 col-md-6">
							<div class="form-group">
								<s:select label="Sesation" 
								headerKey="-1" headerValue="-- Sensation --"
								list="#{'1':'1', '2':'2', '3':'3', '4':'4', '5':'5'}" 
								name="Sensation" cssClass="form-control"/>
							</div>
						</div>
						<div class="col-xs-6 col-sm-6 col-md-6">
							<div class="form-group">
								<s:select label="conseguido" 
								headerKey="-1" headerValue="-- Finished --"
								list="#{'1':'Yes', '0':'No'}" 
								name="Finish" cssClass="form-control"/>
							</div>
						</div>
					</div>
					
					
					<hr class="colorgraph">
					<div class="row">
					<div class="col-md-4 "></div>
						<div class="col-md-4">
							<s:submit method="execute" key="label.Guardar"
								cssClass="btn btn-primary btn-block btn-lg" value="Save" />
						</div>
					<div class="col-md-4 "></div>	
					</div>
				</s:form>
			</div>
		</div>
					</div>
				</div>
				</div>
			</div>
		</div>
		<div class="modal fade" id="ModalManyana" tabindex="-1">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">&times;</button>
					<h4 class="modal-title" id="myModalLabel">Introduce your data</h4>
				</div>
				<div class="modal-body">
					
		<div class="container">
		<s:actionerror />
		<div class="row">
			<div
				class="col-md-12">
				<s:form action="guardar.action" method="post" theme="simple"
					id="contact-form">
					<h2>
						Please fill up all the gaps. <small> Tell us how do you feel.</small>
					</h2>
					<hr class="colorgraph">
					<s:hidden name="id_entreno_ejercicioManyana" key="label.id_entreno_ejercicioManyana" value="%{#varIdEntrenoEjercicioM}" />
					
					
					<s:hidden name="fecha" key="label.fecha" value="%{#varFechaM}" />
					<%-- <script type="text/javascript">alert("${varFechaM}"); </script> --%>
					<div class="row">
						<div class="col-xs-4 col-sm-4 col-md-4">
							<div class="form-group">
								<s:textfield name="pulsaciones" key="label.pulsaciones"
									required="true" cssClass="form-control input-lg"
									placeholder="Max Heart Rate" label="" tabindex="1" />
							</div>
						</div>
						<div class="col-xs-4 col-sm-4 col-md-4">
							<div class="form-group">
								<s:textfield name="tiempo" key="label.tiempo"
									required="true" cssClass="form-control input-lg"
									placeholder="Time" tabindex="2" />
							</div>
						</div>
						<div class="col-xs-4 col-sm-4 col-md-4">
							<div class="form-group">
								<s:textfield name="Weight" key="label.Weight"
									required="true" cssClass="form-control input-lg"
									placeholder="Weight" tabindex="2" />
							</div>
						</div>
						<div class="col-xs-4 col-sm-4 col-md-4">
							<div class="form-group">
								<s:textfield name="AvHR" key="label.AvHR"
									required="true" cssClass="form-control input-lg"
									placeholder="Average HR" tabindex="2" />
							</div>
						</div>
					</div>
					<div class="row">
						<div class="col-xs-6 col-sm-6 col-md-6">
							<div class="form-group">
								<s:select label="Sesation" 
								headerKey="-1" headerValue="-- Sensation --"
								list="#{'1':'1', '2':'2', '3':'3', '4':'4', '5':'5'}" 
								name="Sensation" cssClass="form-control"/>
							</div>
						</div>
						<div class="col-xs-6 col-sm-6 col-md-6">
							<div class="form-group">
								<s:select label="conseguido" 
								headerKey="-1" headerValue="-- Finished --"
								list="#{'1':'Yes', '0':'No'}" 
								name="Finish" cssClass="form-control"/>
							</div>
						</div>
					</div>
					
					
					<hr class="colorgraph">
					<div class="row">
					<div class="col-md-4 "></div>
						<div class="col-md-4">
							<s:submit method="execute" key="label.Guardar"
								cssClass="btn btn-primary btn-block btn-lg" value="Save" />
						</div>
					<div class="col-md-4 "></div>	
					</div>
				</s:form>
			</div>
		</div>
					</div>
				</div>
				</div>
			</div>
		</div>
			<!-- /#page-wrapper -->
			<s:set var="varDet" value="prueba" />

		</div>


		<script src="../js/bootstrap.js"></script>
		<script src="../js/raphael-min.js"></script>
		<script src="http://cdn.oesmith.co.uk/morris-0.4.3.min.js"></script>

		<script>
			var run = parseInt(<s:property value="porcentageR"/>);
			var swim = parseInt(<s:property value="porcentageS"/>);
			var cycle = parseInt(<s:property value="porcentageC"/>);

			var prueba2 = [ {
				label : 'Running',
				value : cycle
			}, {
				label : 'Cycling',
				value : run
			}, {
				label : 'Swiming',
				value : swim
			} ];

			//var prueba2=varDet;
			if (run>0 || swim>0 || cycle>0){
			Morris.Donut({
				element : 'morris-chart-donut',
				data : prueba2

			});}
		</script>
		<script type="text/javascript">
			/* <![CDATA[ */
			$(function() {
				
				var myvalues =[];
				//myvalues = [1,2,3,4,5,6,7];
				<s:iterator id="arrayPeso" value="arrayPeso" status="stat">
					myvalues.push(<s:property/>);
				</s:iterator>
				//var myvalues = [1,2,3,4,5,6,7];
				$('.dynamicsparkline').sparkline(myvalues);
		
		
				$('.dynamicbar').sparkline(myvalues, {
					type : 'bar',
					barColor : 'green'
				});
				
				
				myvalues =[];
				//myvalues = [1,2,3,4,5,6,7];
				<s:iterator id="arrayFCR" value="arrayFCR" status="stat">
					myvalues.push(<s:property/>);
				</s:iterator>
				//var myvalues = [1,2,3,4,5,6,7];
				$('.dynamicsparkline').sparkline(myvalues);
		
		
				$('.dynamicbarF').sparkline(myvalues, {
					type : 'bar',
					barColor : 'green'
				});
				
				
				
				myvalues =[];
				//myvalues = [1,2,3,4,5,6,7];
				<s:iterator id="arrayFCM" value="arrayFCM" status="stat">
					myvalues.push(<s:property/>);
				</s:iterator>
				//var myvalues = [1,2,3,4,5,6,7];
				$('.dynamicsparkline').sparkline(myvalues);
		
		
				$('.dynamicbarM').sparkline(myvalues, {
					type : 'bar',
					barColor : 'green'
				});
				
				
				
				myvalues =[];
				//myvalues = [1,2,3,4,5,6,7];
				<s:iterator id="arrayRun" value="arrayRun" status="stat">
					myvalues.push(<s:property/>);
				</s:iterator>
				//var myvalues = [1,2,3,4,5,6,7];
				$('.dynamicsparkline').sparkline(myvalues);
		
		
				$('.dynamicbarR').sparkline(myvalues, {
					type : 'bar',
					barColor : 'green'
				});
				
				
				
				myvalues =[];
				//myvalues = [1,2,3,4,5,6,7];
				<s:iterator id="arraySwim" value="arraySwim" status="stat">
					myvalues.push(<s:property/>);
				</s:iterator>
				//var myvalues = [1,2,3,4,5,6,7];
				$('.dynamicsparkline').sparkline(myvalues);
		
		
				$('.dynamicbarS').sparkline(myvalues, {
					type : 'bar',
					barColor : 'green'
				});
				
				myvalues =[];
				//myvalues = [1,2,3,4,5,6,7];
				<s:iterator id="arrayCycle" value="arrayCycle" status="stat">
					myvalues.push(<s:property/>);
				</s:iterator>
				//var myvalues = [1,2,3,4,5,6,7];
				$('.dynamicsparkline').sparkline(myvalues);
		
		
				$('.dynamicbarC').sparkline(myvalues, {
					type : 'bar',
					barColor : 'green'
				});
		
			});
			/* ]]> */
		</script>
</body>
</html>
