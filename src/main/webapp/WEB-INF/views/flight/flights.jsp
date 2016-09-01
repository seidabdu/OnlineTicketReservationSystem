<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html lang="en">
<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="Siken and team">

<title>OnlineTicketReservationSystem 2016 | Flight Detail</title>

<!-- Bootstrap Core CSS -->
<link href="<c:url value='resources/css/bootstrap.min.css'/>"
	rel="stylesheet">

<!-- Custom CSS -->
<link href="<c:url value='resources/css/style.css'/>" rel="stylesheet">

<!-- Favicon -->
<link rel='shortcut icon' type='image/x-icon'
	href='resources/images/favicon.ico' />

<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
<style>
.jumbotron {
	background-color: #77ab59;
}
</style>
</head>

<body>

	<!-- Navigation -->
	<%@ include file="../common/nav_menu_note.jsp"%>

	<!-- Page Content -->
	<div class="container">
		<div class="row">

			<div class="col-md-3">
				<p class="lead">Ethiopian AirLine</p>
				<div class="list-group">
					<a href="${pageContext.request.contextPath}/flight/add" class="list-group-item active">Admin</a> 
                                        <a href="${pageContext.request.contextPath}/passenger/add" class="list-group-item active">SIGN-UP</a> 
                                        <a href="${pageContext.request.contextPath}/ticket/status" class="list-group-item active">YOUR TICKET STATUS</a>
                                         <a href="${pageContext.request.contextPath}/login" class="list-group-item active"> <button class="btn btn-success">Log In</button>
                                        <a href="${pageContext.request.contextPath}/logout" class="list-group-item active"> <button class="btn btn-danger">Log Out</button>
					</a>
					
				</div>
			</div>

			<div class="col-md-9">
				<div class="jumbotron">
					<h2><span class="glyphicon glyphicon-list-alt"></span> Flights</h2>
				</div>

				<div class="col-md-15">
					<form class="form-inline" role="form" id="xyz">
						<div class="form-group">
                                                    <c:forEach items="${sections}" var="section">
						<option value="${section.sectionId}">${section.sectionName}</option>
								</c:forEach>
							<!--<label for="section">Search </label>-->
						</div>
						<div class="form-group">
						    <label for="section">Departure </label>
						
                                                    <select class="form-control input-lg" name="from" id="from">
								<option value="Dallas">Dallas</option>
								<option value="AddisAbaba">Addis Ababa</option>
								<option value="Mekelle">Mekelle</option>
								<option value="Newyork">Newyork</option>
							</select>
                                                   <!--<input type="text" class="form-control input-lg" name="search" id="search" size="10" />-->
						   <!--<input type="text" class="form-control input-lg" name="search" id="search" size="10" />-->
                                                        <label for="section">Arrival </label>
							<select class="form-control input-lg" name="to" id="to">
								<option value="Dallas">Dallas</option>
								<option value="AddisAbaba">Addis Ababa</option>
								<option value="Mekelle">Mekelle</option>
								<option value="Newyork">Newyork</option>
							</select>
						</div>
						<button class="btn btn-lg btn-primary" onclick="doFind()">Search</button>
					</form>
					
				
<!--			<div id="newdata">		
                                        
                                        <table class="table table-hover table-striped table-condensed">
	<thead>
		<tr>
			<th>Flight_ID</th>
			<th>airline_name</th>
			<th>From_location</th>
			<th>To_Location</th>
                        <th>Departure_time</th>
                        <th>price</th>
                         <th>Total_seats</th>
                        <th>Available_seats</th>
			<th>&nbsp;</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${flights}" var="flight">
			<tr>
				<td><c:out value="${flight.flight_ID}" /></td>
				<td><c:out value="${flight.airline_name}" /></td>
				<td><c:out value="${flight.from_location}" /></td>
				<td><c:out value="${flight.to_location}" /></td>
				<td><c:out value="${flight.departure_time}" /></td>
				<td><c:out value="${flight.price}" /></td>
                                <td><c:out value="${flight.total_seats}" /></td>
                                <td><c:out value="${flight.available_seats}" /></td>
				<td>
					<a href="${pageContext.request.contextPath}/flight/${flight.flight_ID}">
					<button class="btn btn-cicle btn-xs btn-info">Upd</button>
					</a>
					<button class="btn btn-cicle btn-xs btn-danger" onclick="doDelete(${flight.flight_ID})">Del</button>
				</td>

                         
                           <td>
                             <a href="${pageContext.request.contextPath}/login">
			<button class="btn btn-cicle btn-xs btn-info">RESERVE</button>
					</a></td>
                             
                        
                            
                            
			</tr>
		</c:forEach>
	</tbody>
</table>

                     </div>                  
                                        -->
<!--					<table class="table table-hover table-striped table-condensed">
						<thead>
							<tr>
								<th width="100"></th>
								<th><a href="#" onclick="doList('title')">Title</a> <a href="#" onclick="doListD('title')"> &hearts; </a></th>
								<th><a href="#" onclick="doList('cdate')">Created Date</a> <a href="#" onclick="doListD('cdate')"> &hearts; </a></th>
								<th><a href="#" onclick="doList('mdate')">Modified Date</a> <a href="#" onclick="doListD('mdate')"> &hearts; </a></th>
							</tr>
						</thead>
					</table>	-->
					
                                        
                               
	
                                        
<!--					 this will be the loop 
-->					<div id="newdata">
						<c:forEach items="${flights}" var="flight" varStatus="count">
							<div class="panel panel-success show100">
								<div class="panel-heading">
									<h4>
										 ${count.count}. <span style="padding:2px;background-color:${note.section.theme};"><c:out value="${note.section.sectionName}" /></span> | <c:out value="${note.title}" /> 
									</h4>
								</div>
								<div class="panel-body">
									<p class="small" style="color:#337AB7;">
									<c:out value="${flight.airline_name}" />
                                                                        <c:out value="${flight.from_location}" />
                                                                        <c:out value="${flight.to_location}" />
                                                                        <c:out value="${flight.price}"/>
									
									
									
																		
								</div>
							</div>
						</c:forEach>
					</div><!--
					
					 -->
            
					<!--  /#newdata 
				</div>

			</div>
		</div>
		<!-- /.row -->
	</div>
	<!-- /.container -->

	<div class="container">

		<!-- Footer -->
		<%@ include file="../common/footer.jsp"%>

	</div>
	<!-- /.container -->

	<!-- jQuery -->
	<script src="<c:url value='resources/js/jquery.min.js'/>"></script>

	<!-- Bootstrap Core JavaScript -->
	<script src="<c:url value='resources/js/bootstrap.min.js'/>"></script>
	<script>
		$('#xyz').submit(function(e) {
			e.preventDefault();
		});

		function doFind() {

			var section = $("#section option:selected").val();
			//alert(section);
			//return;
//			var search = $("#search").val();
                        var from=$("#from option:selected").val();
                        var to=$("#to option:selected").val();
//			var searchby = $("#searchby option:selected").val();
//                         var search=searchby;

			$.ajax({
				"type" : "POST",
				"data" : {
					from : from
					,to : to
					,section : section
				},
				"url" : "${pageContext.request.contextPath}/flight/find",
				"success" : function(msg) {
				}
			}).done(function(data) {
				$("#newdata").html(data);
			});
		}

		function doList(sortby) {
			$.ajax({
				"type" : "POST",
				"data" : {
					sort : sortby,
					order : "asc"
				},
				"url" : "${pageContext.request.contextPath}/note/list",
				"success" : function(msg) {
				}
			}).done(function(data) {
				$("#newdata").html(data);
			});
		}

		function doListD(sortby) {
			$.ajax({
				"type" : "POST",
				"data" : {
					sort : sortby,
					order : "desc"
				},
				"url" : "${pageContext.request.contextPath}/note/list",
				"success" : function(msg) {
				}
			}).done(function(data) {
				$("#newdata").html(data);
			});
		}
		
		/* note deleting due to some fk constraints */
		function doDelete(id) {
			var r = confirm("Delete this note ?");
			if (r == true) {
				$.ajax(
						{
							"type" : "POST",
							"url" : "${pageContext.request.contextPath}/note/delete/" + id,
							"success" : function(msg) {
							}
						}).done(function(data) {
					$("#newdata").html(data);
				});
			}
		}
	</script>
</body>
</html>