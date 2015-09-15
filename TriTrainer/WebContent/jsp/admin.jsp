<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<title>Admin Panel</title>
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1">
<meta name="description" content="">
<meta name="author" content="">

<!-- LOAD CSS ASSETS -->
<link rel="stylesheet" href="../css/font.awesome.css">
<link rel="stylesheet" href="../css/admin.css">
<link href="../css/badmin.css" rel="stylesheet">
<link href="../css/bootstrap-responsive.css" rel="stylesheet">
<link rel="stylesheet"
	href="//cdnjs.cloudflare.com/ajax/libs/morris.js/0.5.1/morris.css">
<script src="//ajax.googleapis.com/ajax/libs/jquery/1.9.0/jquery.min.js"></script>
<script
	src="//cdnjs.cloudflare.com/ajax/libs/raphael/2.1.0/raphael-min.js"></script>
<script
	src="//cdnjs.cloudflare.com/ajax/libs/morris.js/0.5.1/morris.min.js"></script>

<!--LOAD GOOGLE WEBFONTS -->
<link
	href='http://fonts.googleapis.com/css?family=Open+Sans:400italic,400,300,600,700'
	rel='stylesheet' type='text/css'>


<link rel="stylesheet"
	href="https://fonts.googleapis.com/css?family=Open+Sans:400,600,800">
<link href="../css/bootstrap.css" rel="stylesheet">
<link href="../css/stats.css" rel="stylesheet">
<link href="../css/sb-admin.css" rel="stylesheet">

<!-- Le HTML5 shim, for IE6-8 support of HTML5 elements -->
<!--[if lt IE 9]>
      <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
    <![endif]-->

<!-- Le fav and touch icons -->

</head>

<body>

	<%@ include file="header.jsp"%>

	<!--principal -->

	<div class="container" style="margin-top: 30px;">


		<!--START STATS-WIDGET -->
		<div id="page-wrapper">
			<div class="row">
				<div class="span7">
					<div class="widget_heading">
						<h4>Statistics</h4>
					</div>
					<div class="widget_container">

						<ul id="sortable" class="unstyled" style="padding-left: 20px;width:81%;margin-left:20%;">
							<li class="span2 ui-state-default"><div
									class="infoblock shadow">
									<h1 style="color: #4DB848;">
										<s:property value="totalUsers" />
									</h1>
									<p>Total Users</p>
								</div></li>
							<li class="span2 ui-state-default"><div
									class="infoblock shadow">
									<h1 style="color: #0099FF;">
										<s:property value="totalActiveUsers" />
									</h1>
									<p>Total Active Users</p>
								</div></li>

							<li class="span2 ui-state-default"><div
									class="infoblock shadow">
									<h1 style="color: #ff4056;">
										<s:property value="totalEntrenos" />
									</h1>
									<p>Active Trainings</p>
								</div></li>

							<li class="span2 ui-state-default"><div
									class="infoblock shadow">
									<h1 style="color: #ff9900;"><s:property value="totalTrainings" /></h1>
									<p>Total Trainigs</p>
								</div></li>
							
						</ul>


					</div>
				</div>

				<!--end -->



					<div class="col-lg-4">
						<div class="span4">
							<div class="widget_heading">
								<h4>Actions Log</h4>
							</div>
							<div class="widget_container">
								<div class="table-responsive">
									<table
										class="table table-bordered table-hover table-striped tablesorter">
										<thead>
											<tr>
												<th>Description</th>
											</tr>
										</thead>
										<tbody>
										<s:iterator value="historico">
											<tr>
												<td><s:property value="descripcion"/></td>
											</tr>
										</s:iterator>	
										</tbody>
									</table>
								</div>
							</div>
						</div>
					</div>
			</div>
		</div>

		<!--END-RECENT-POSTS-WIDGET -->





		<!--START-DAILY REPORT-WIDGET -->


		<div class="row">
			<div class="span12">
				<div class="widget_heading">
					<h4>Daily Report</h4>
				</div>
				<div class="widget_container">
					<!-- Begin demo markup -->

					<!--START-LINE GRAPH -->

					<div id="wijlinechartDefault"
						class="ui-widget ui-widget-content ui-corner-all"
						style="width: 100%; height: 248px; background: white; border: 0px;">

					</div>

					<!--END-LINE GRAPH -->


				</div>
			</div>

		</div>

		<!--END-DAILY REPORT-WIDGET -->


		<!--START-QUICK-POST-WIDGET -->
		<div class="row">
			<div class="span12">
				<div class="widget_heading">
					<h4>Configuration</h4>
				</div>
				<div class="widget_container">

					<s:actionerror />
					<div class="row">
						<div class="col-md-12 ">
							<s:form action="registro.action" method="post" theme="simple"
								id="contact-form">

								<hr class="colorgraph">
								<div class="row">
									<div class="col-md-4"></div>
										<div class="col-md-2">
										<select id="status" name="status" onChange="mostrar(this.value);" style=" width: 100%;">
		        							<option value=""></option>
		        							<option value="sprint">Sprint</option>
		        							<option value="olimpic">Olimpic</option>
		        							<option value="half">Half</option>
		        							
		     							</select>
	     								</div>
	     							<div class="col-md-4"></div>
	     						</div>
	     						
	     						<br>
     							
								<div class="row" id="sprint" style="display: none;">
									<div class="col-md-12">
										<div class="form-group">
											<div class="col-md-4">
												<s:label class="">Dist. Swim Base Sprint:</s:label>
												<s:textfield name="first_name" key="label.first_name"
													required="true" cssClass="col-md-4" style="float: none;"
													placeholder="Distancia Base Sprint" tabindex="1"
													value="%{DistNatSprintBase}" />
											</div>
											<div class="col-md-4">
												<s:label class="">Dist. Run Base Sprint:</s:label>
												<s:textfield name="first_name" key="label.first_name"
													required="true" cssClass="col-md-4" style="float: none;"
													placeholder="Distancia Base Sprint" tabindex="1"
													value="%{DistRunSprintBase}" />
											</div>
											<div class="col-md-4">
												<s:label class="">Dist. Cycle Base Sprint:</s:label>
												<s:textfield name="first_name" key="label.first_name"
													required="true" cssClass="col-md-4" style="float: none;"
													placeholder="Distancia Base Sprint" tabindex="1"
													value="%{DistCycleSprintBase}" />
											</div>
										</div>
									</div>
								</div>
								<div class="row" id="sprint2" style="display: none;">
									<div class="col-md-12">
										<div class="form-group">
											<div class="col-md-4">
												<s:label class="">Dist. Swim General Sprint:</s:label>
												<s:textfield name="first_name" key="label.first_name"
													required="true" cssClass="col-md-4" style="float: none;"
													placeholder="Dist. Swim General Sprint" tabindex="1"
													value="%{DistNatSprintGeneral}" />
											</div>
											<div class="col-md-4">
												<s:label class="">Dist. Run General Sprint:</s:label>
												<s:textfield name="first_name" key="label.first_name"
													required="true" cssClass="col-md-4" style="float: none;"
													placeholder="Dist. Run General Sprint" tabindex="1"
													value="%{DistRunSprintGeneral}" />
											</div>
											<div class="col-md-4">
												<s:label class="">Dist. Cycle General Sprint:</s:label>
												<s:textfield name="first_name" key="label.first_name"
													required="true" cssClass="col-md-4" style="float: none;"
													placeholder="Dist. Cycle General Sprint" tabindex="1"
													value="%{DistCycleSprintGeneral}" />
											</div>
										</div>
									</div>
								</div>
								<div class="row" id="sprint3" style="display: none;">
									<div class="col-md-12">
										<div class="form-group">
											<div class="col-md-4">
												<s:label class="">Time Swim Test Sprint:</s:label>
												<s:textfield name="first_name" key="label.first_name"
													required="true" cssClass="col-md-4" style="float: none;"
													placeholder="Time Swim Test Sprint" tabindex="1"
													value="%{tiempoTestSwimSprint}" />
											</div>
											<div class="col-md-4">
												<s:label class="">Time Cycle Test Sprint:</s:label>
												<s:textfield name="first_name" key="label.first_name"
													required="true" cssClass="col-md-4" style="float: none;"
													placeholder="Time Cycle Base Sprint" tabindex="1"
													value="%{tiempoTestCycleSprint}" />
											</div>
											<div class="col-md-4">
												<s:label class="">Time Run Test Sprint:</s:label>
												<s:textfield name="first_name" key="label.first_name"
													required="true" cssClass="col-md-4" style="float: none;"
													placeholder="Time Run Base Sprint" tabindex="1"
													value="%{tiempoTestRunSprint}" />
											</div>
										</div>
									</div>
								</div>
								<div class="row" id="olimpic" style="display: none;">
									<div class="col-md-12">
										<div class="form-group">
											<div class="col-md-4" >
												<s:label class="col-xs-2" >Dist. Swim Base Olimpic:</s:label>
												<s:textfield name="first_name" key="label.first_name"
													required="true" cssClass="col-md-4" style="float: none;"
													placeholder="Dist. Swim Base Olimpic" tabindex="1"
													value="%{DistSwimOlimpicBase}" />
											</div>
											<div class="col-md-4">
												<s:label class="col-xs-2">Dist. Cycle Base Olimpic:</s:label>
												<s:textfield name="first_name" key="label.first_name"
													required="true" cssClass="col-md-4" style="float: none;"
													placeholder="Dist. Cycle Base Olimpic" tabindex="1"
													value="%{DistCycleOlimpicBase}" />
											</div>
											<div class="col-md-4">
												<s:label class="col-md-2" >Dist. Run Base Olimpic:</s:label>
												<s:textfield name="first_name" key="label.first_name"
													required="true" cssClass="col-md-4 " style="float: none;"
													placeholder="Dist. Run Base Olimpic" tabindex="1"
													value="%{DistRunOlimpicBase}" />
											</div>
											
											
										</div>
									</div>
								</div>
								<div class="row" id="olimpic2" style="display: none;">
									<div class="col-md-12">
										<div class="form-group">
											<div class="col-md-4" >
												<s:label class="col-xs-2" >Dist. Swim General  Olimpic:</s:label>
												<s:textfield name="first_name" key="label.first_name"
													required="true" cssClass="col-md-4" style="float: none;"
													placeholder="Dist. Swim Base Olimpic" tabindex="1"
													value="%{DistNatOlimpicGeneral}" />
											</div>
											<div class="col-md-4">
												<s:label class="col-xs-2">Dist. Cycle General  Olimpic:</s:label>
												<s:textfield name="first_name" key="label.first_name"
													required="true" cssClass="col-md-4" style="float: none;"
													placeholder="Dist. Cycle Base Olimpic" tabindex="1"
													value="%{DistCycleOlimpicGeneral }" />
											</div>
											<div class="col-md-4">
												<s:label class="col-md-2" >Dist. Run General  Olimpic:</s:label>
												<s:textfield name="first_name" key="label.first_name"
													required="true" cssClass="col-md-4 " style="float: none;"
													placeholder="Dist. Run Base Olimpic" tabindex="1"
													value="%{DistRunOlimpicGeneral }" />
											</div>
											
											
										</div>
									</div>
								</div>
								<div class="row" id="olimpic3" style="display: none;">
									<div class="col-md-12">
										<div class="form-group">
											<div class="col-md-4">
												<s:label class="">Time Swim Test Olimpic:</s:label>
												<s:textfield name="first_name" key="label.first_name"
													required="true" cssClass="col-md-4" style="float: none;"
													placeholder="Time Swim Test Sprint" tabindex="1"
													value="%{tiempoTestSwimOlimpic}" />
											</div>
											<div class="col-md-4">
												<s:label class="">Time Cycle Test Olimpic:</s:label>
												<s:textfield name="first_name" key="label.first_name"
													required="true" cssClass="col-md-4" style="float: none;"
													placeholder="Time Cycle Base Sprint" tabindex="1"
													value="%{tiempoTestCycleOlimpic}" />
											</div>
											<div class="col-md-4">
												<s:label class="">Time Run Test Olimpic:</s:label>
												<s:textfield name="first_name" key="label.first_name"
													required="true" cssClass="col-md-4" style="float: none;"
													placeholder="Time Run Base Sprint" tabindex="1"
													value="%{tiempoTestRuOlimpic}" />
											</div>
										</div>
									</div>
								</div>
								<div class="row" id="half" style="display: none;">
									<div class="col-md-12">
										<div class="form-group">
											<div class="col-md-4">
												<s:label class="">Dist. Swim Base Half:</s:label>
												<s:textfield name="first_name" key="label.first_name"
													required="true" cssClass="col-md-4" style="float: none;"
													placeholder="Distancia Base Half" tabindex="1"
													value="%{distSwimHalfBase}" />
											</div>
											<div class="col-md-4">
												<s:label class="">Dist. Run Base Half:</s:label>
												<s:textfield name="first_name" key="label.first_name"
													required="true" cssClass="col-md-4" style="float: none;"
													placeholder="Distancia Base Half" tabindex="1"
													value="%{DistRunHalfBase}" />
											</div>
											<div class="col-md-4">
												<s:label class="">Dist. Cycle Base Half:</s:label>
												<s:textfield name="first_name" key="label.first_name"
													required="true" cssClass="col-md-4" style="float: none;"
													placeholder="Distancia Base Half" tabindex="1"
													value="%{DistCycleHalfBase}" />
											</div>
										</div>
									</div>
								</div>
								<div class="row" id="half2" style="display: none;">
									<div class="col-md-12">
										<div class="form-group">
											<div class="col-md-4">
												<s:label class="">Dist. Swim General Half:</s:label>
												<s:textfield name="first_name" key="label.first_name"
													required="true" cssClass="col-md-4" style="float: none;"
													placeholder="Dist. Swim General Half" tabindex="1"
													value="%{DistNatHalfGeneral}" />
											</div>
											<div class="col-md-4">
												<s:label class="">Dist. Run General Half:</s:label>
												<s:textfield name="first_name" key="label.first_name"
													required="true" cssClass="col-md-4" style="float: none;"
													placeholder="Dist. Run General Half" tabindex="1"
													value="%{DistRunHalfGeneral}" />
											</div>
											<div class="col-md-4">
												<s:label class="">Dist. Cycle General Half:</s:label>
												<s:textfield name="first_name" key="label.first_name"
													required="true" cssClass="col-md-4" style="float: none;"
													placeholder="Dist. Cycle General Half" tabindex="1"
													value="%{DistCycleHalfGeneral}" />
											</div>
										</div>
									</div>
								</div>
								<div class="row" id="half3" style="display: none;">
									<div class="col-md-12">
										<div class="form-group">
											<div class="col-md-4">
												<s:label class="">Time Swim Test Sprint:</s:label>
												<s:textfield name="first_name" key="label.first_name"
													required="true" cssClass="col-md-4" style="float: none;"
													placeholder="Time Swim Test Sprint" tabindex="1"
													value="%{tiempoTestSwimSprint}" />
											</div>
											<div class="col-md-4">
												<s:label class="">Time Cycle Test Sprint:</s:label>
												<s:textfield name="first_name" key="label.first_name"
													required="true" cssClass="col-md-4" style="float: none;"
													placeholder="Time Cycle Base Sprint" tabindex="1"
													value="%{tiempoTestCycleSprint}" />
											</div>
											<div class="col-md-4">
												<s:label class="">Time Run Test Sprint:</s:label>
												<s:textfield name="first_name" key="label.first_name"
													required="true" cssClass="col-md-4" style="float: none;"
													placeholder="Time Run Base Sprint" tabindex="1"
													value="%{tiempoTestRunSprint}" />
											</div>
										</div>
									</div>
								</div>
					<div class="row">
					<div class="col-md-4"></div>
						<div class="col-md-2">
							<s:submit method="execute" key="label.Save"
								cssClass="btn btn-primary btn-block" value="Save" />
						</div>
					<div class="col-md-4"></div>	
					</div>



							</s:form>
						</div>
					</div>

				</div>
			</div>

		</div>

		<!--END-QUICK-POST-WIDGET -->


		<!--START-STATIC TEXT-WIDGETS -->



	</div>
	</div>

	<!--END-STATIC TEXT-WIDGETS -->





	<!--LOAD JQUERY UI ASSETS-->

	<script>
		var run = parseInt(<s:property value="porcentageTotalR"/>);
		var swim = parseInt(<s:property value="porcentageTotalS"/>);
		var cycle = parseInt(<s:property value="porcentageTotalC"/>);

		var prueba2 = [ {
			label : 'Running',
			value : 33
		}, {
			label : 'Cycling',
			value : 33
		}, {
			label : 'Swiming',
			value : 34
		} ];

		//var prueba2=varDet;

		Morris.Donut({
			element : 'donut-example',
			data : [ {
				label : "Swim",
				value : 12
			}, {
				label : "",
				value : 78
			}

			],
			resize : true
		});
	</script>
	<!--jQuery References-->
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"
		type="text/javascript"></script>
	<script
		src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.8.18/jquery-ui.min.js"
		type="text/javascript"></script>


	<!--Wijmo Widgets JavaScript-->
	<!--Wijmo Widgets JavaScript-->
	<script src="http://cdn.wijmo.com/jquery.wijmo-open.all.2.1.4.min.js"
		type="text/javascript"></script>
	<script
		src="http://cdn.wijmo.com/jquery.wijmo-complete.all.2.1.4.min.js"
		type="text/javascript"></script>


	<!--LOAD JQUERY/JAVASCRIPT ASSETS-->

	<script type="text/javascript" src="../js/bootstrap.js"></script>
	<script type="text/javascript">

	$(document).ready(function () {
	            //$(":wijmo-wijdialog").wijdialog("destroy").remove();
		  		var myvalues =[];
		  		myvalues = [1,2,3,4,5,6,7];
	            $("#dialog-message").wijdialog({
	                autoOpen: false,
	                height: 180,
	                width: 400,
	                modal: true,
	                buttons: {
	                    Ok: function () {
	                        $(this).wijdialog("close");
	                    }
	                },
	                captionButtons: {
	                    pin: { visible: false },
	                    refresh: { visible: false },
	                    toggle: { visible: false },
	                    minimize: { visible: false },
	                    maximize: { visible: false }
	                }
	            });
	        });



	  $(document).ready(function () {
	      $("#wijlinechartDefault").wijlinechart({

	        animation: {
	          direction: "vertical"
	        },

	        axis: {

	          y: {

	            text: "Number of Hits",

	            labels: {

	              style: {

	                fill: "#4BB446",

	                "font-size": 11

	              }

	            },

	            gridMajor: {

	              style: { stroke: "#4BB446", "stroke-dasharray": "- " }

	            },

	            tickMajor: { position: "outside", style: { stroke: "#4BB446"} },

	            tickMinor: { position: "outside", style: { stroke: "#4BB446"} },

	            autoMax: false,

	            max: 100,

	            autoMin: false,

	            min: 0

	          },

	          x: {

	            text: "Months of the Year",

	            labels: {

	              style: {

	                fill: "#4BB446",

	                "font-size": 11,
	                valueLabels:[],

	                rotation: -45

	              }

	            },

	            tickMajor: { position: "outside", style: { stroke: "#7f7f7f"} }

	          }

	        },

	        showChartLabels: false,

	        hint: {

	          content: function () {

	            return this.data.lineSeries.label + '\n' +

	            this.x + '\n' + this.y + '';

	          },

	          contentStyle: {

	            "font-size": 10

	          },

	          offsetY: -10

	        },

	        legend: {

	          visible: false

	        },

	        seriesList: [createRandomSeriesList("2015")],

	        seriesStyles: [

	          { stroke: "#4BB446", "stroke-width": 3 }

	        ],

	        seriesHoverStyles: [

	          {"stroke-width": 4 }

	        ]

	      });

	    });



	    function createRandomSeriesList(label) {
	      var data = [];
	      var labels =[];
	     
	      <s:iterator id="arrayEntrenos" value="arrayEntrenos" status="stat">
	      	data.push(<s:property/>);
	      </s:iterator>
	      <s:iterator id="arrayMeses" value="arrayMeses" status="ctr">
	      		labels.push(<s:property/>);
	      </s:iterator>

	      return {
		        label: "",
		        legendEntry: false,
		        data: { x: labels, y: data }
		      };
	    }	     
		 

	    function mostrar(id) {
	        if (id == "sprint") {
	            $("#sprint").show();
	            $("#olimpic").hide();
	            $("#half").hide();
	            $("#sprint2").show();
	            $("#olimpic2").hide();
	            $("#half2").hide();
	            $("#sprint3").show();
	            $("#olimpic3").hide();
	            $("#half3").hide();
	           
	        }

	        if (id == "olimpic") {
	            $("#sprint").hide();
	            $("#olimpic").show();
	            $("#half").hide();
	            $("#sprint2").hide();
	            $("#olimpic2").show();
	            $("#half2").hide();
	            $("#sprint3").hide();
	            $("#olimpic3").show();
	            $("#half3").hide();
	          
	        }

	        if (id == "half") {
	            $("#sprint").hide();
	            $("#olimpic").hide();
	            $("#half").show();
	            $("#sprint2").hide();
	            $("#olimpic2").hide();
	            $("#half2").show();
	            $("#sprint3").hide();
	            $("#olimpic3").hide();
	            $("#half3").show();
	        
	        }

	        
	    }
	</script>


</body>
</html>