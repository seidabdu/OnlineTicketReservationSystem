<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="en">

<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="Siken and team">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.10.4/themes/smoothness/jquery-ui.css">
<script src="//code.jquery.com/jquery-1.10.2.js"></script>
<script src="//code.jquery.com/ui/1.10.4/jquery-ui.js"></script>
<script>
	$(function() {
		$("#datepicker").datepicker();
                $("#datepicker2").datepicker();
	});
       

</script>

<title>NoteAssistant 2016 | Contact</title>

<!-- Bootstrap Core CSS -->
<!--<link href="<c:url value='../resources/css/bootstrap.min.css'/>" 	rel="stylesheet">-->

<!-- Custom CSS -->
<!--<link href="<c:url value='../resources/css/style.css'/>" 	rel="stylesheet">-->

<!-- Favicon -->
<!--<link rel='shortcut icon' type='image/x-icon' 	href='../resources/images/favicon.ico' />-->

<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
<style>
.jumbotron {
	background-color: #6ca77c;
}
</style>
</head>

<body>

	<!-- Navigation -->
	

	<!-- Page Content -->
	<div class="container">
		<div class="row">

			<div class="col-md-3">
				<p class="lead">Contact</p>
				<div class="list-group">
					<a href="${pageContext.request.contextPath}/flight" class="list-group-item">Contact List</a> <a
						href="${pageContext.request.contextPath}/flight/add" class="list-group-item active">Add New Contact</a>
				</div>
			</div>

			<div class="col-md-9">

				<div class="jumbotron">
					<h2><span class="glyphicon glyphicon-user"></span> Contact Person</h2>
				</div>

				<form:form modelAttribute="newFlight" cssClass="form">
					<div class="well">
						<div class="row">
							<div class="col-md-12">
								<span class="glyphicon glyphicon-star"></span> Add your friend, family or any person to your contact list.
								<span class="pull-right">&nbsp;</span>
							</div>
						</div>
					</div>

					<!-- <div class="form-group">
                        <input type="hidden" class="form-control" name="id" id="id" value="" />
                    </div> -->
                   
                    <!--  <input id="user" name="user" class="form-control"  type="hidden" />  -->

					<div class="form-group">
						<label for="title"> AirLine Name </label>
						<!--  <input type="text" class="form-control" name="name" id="name" placeholder="Name of contact person" value="" required /> -->
						<form:input path="airline_name" cssClass="form-control" placeholder="Name of flight" required="required" />
						<form:errors path="airline_name" cssClass="has-error" />
					</div>

                   <div class="form-group">
						<label for="title"> From_location </label>
						<!--  <input type="text" class="form-control" name="name" id="name" placeholder="Name of contact person" value="" required /> -->
						<form:input path="from_location" cssClass="from-control" placeholder="Name of flight" required="required" />
						<form:errors path="from_location" cssClass="has-error" />
					</div>
					<div class="form-group">
						<label for="title"> to_location </label>
						<!--  <input type="text" class="form-control" name="name" id="name" placeholder="Name of contact person" value="" required /> -->
						<form:input path="to_location" cssClass="to-control" placeholder="Name of flight" required="required" />
						<form:errors path="to_location" cssClass="has-error" />
					</div>
					

					<div class="form-group">
						<label for="tags">Total Seats</label>
						<!-- <input type="text" class="form-control" name="homephone" id="homephone" value="" /> -->
						<form:input path="total_seats" cssClass="form-control" placeholder="Home Phone" />
						<form:errors path="total_seats" cssClass="has-error" />
					</div>

				

					<div class="form-group">
						<label for="tags"> Price </label>
						<!-- <input type="email" class="form-control" name="email" id="email" placeholder="Email Address" value="" />  -->
						<form:input path="price"  cssClass="form-control" placeholder="price Address" />
						<form:errors path="price" cssClass="has-error" />
					</div>

					 <div class="form-group">
						<label for="tags"> Departure Time </label>
						
                                                <fmt:formatDate pattern="MM/dd/yyyy" value="${newFlight.departure_time}"
					var="fmtdeparturetime" />
                                          <form:input path="departure_time" id="datepicker" value="${fmtdeparturetime}"/>
						<form:errors path="departure_time" cssClass="has-error" />
                                                
                                               
					</div>
                                                
					 <div class="form-group">
						<label for="tags"> Arrival Time </label>
					
                                                <fmt:formatDate pattern="MM/dd/yyyy" value="${newFlight.arrival_time}"
					var="fmtarrivaltime" />
                                          <form:input path="arrival_time" id="datepicker2" value="${fmtarrivaltime}"/>
						<form:errors path="arrival_time" cssClass="has-error" />
                                                
                                               
					</div>

					<div class="text-right">
						<button type="submit" class="btn-lg btn-primary">Save</button>
						<button type="reset" class="btn-lg btn-success">Clear</button>
					</div>
				</form:form>
			</div>
		</div>
		<!-- /.row -->
	</div>
	<!-- /.container -->

	<div class="container">

		<!-- Footer -->
		<%--<%@ include file="common/footer.jsp"%>--%>

	</div>
	<!-- /.container -->

	<!-- jQuery -->
	<!--<script src="<c:url value='resources/js/jquery.min.js'/>"></script>-->

	<!-- Bootstrap Core JavaScript -->
	<!--<script src="<c:url value='resources/js/bootstrap.min.js'/>"></script>-->

</body>
</html>

