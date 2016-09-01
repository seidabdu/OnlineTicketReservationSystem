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
	
	<!-- /.container -->
        
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
<!--				<td>
					<a href="${pageContext.request.contextPath}/flight/${flight.flight_ID}">
					<button class="btn btn-cicle btn-xs btn-info">Upd</button>
					</a>
					<button class="btn btn-cicle btn-xs btn-danger" onclick="doDelete(${flight.flight_ID})">Del</button>
				</td>-->

                         
                           <td>
                             <a href="${pageContext.request.contextPath}/login">
			<button class="btn btn-cicle btn-xs btn-info">RESERVE</button>
					</a></td>
                             
                        
                            
                            
			</tr>
		</c:forEach>
	</tbody>
</table>

	<div class="container">

		<!-- Footer -->
		<%--<%@ include file="../common/footer.jsp"%>--%>

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
			var search = $("#search").val();
			var searchby = $("#searchby option:selected").val();

			$.ajax({
				"type" : "POST",
				"data" : {
					search : search
					,searchby : searchby
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