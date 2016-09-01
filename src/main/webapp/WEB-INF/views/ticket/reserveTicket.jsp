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
				<h1 class="lead">Online Ticket Reservation System</h1>
				<div class="list-group">
					<a href="${pageContext.request.contextPath}/flight" class="list-group-item">Home</a> <a
				
				</div>
			</div>

			<div class="col-md-9">

				<div class="jumbotron">
					<h2><span class="glyphicon glyphicon-user"></span>Check the Selected Flight ID </h2>
				</div>

				<form:form modelAttribute="reserveTicket" cssClass="form">
					<div class="well">
						<div class="row">
							<div class="col-md-12">
								<span class="glyphicon glyphicon-star"></span> here is the Flight ID you have choosen
								<span class="pull-right">&nbsp;</span>
							</div>
						</div>
					</div>

					<!-- <div class="form-group">
                        <input type="hidden" class="form-control" name="id" id="id" value="" />
                    </div> -->
                   
                    <!--  <input id="user" name="user" class="form-control"  type="hidden" />  -->

					<div class="form-group">
						<label for="title"> Flight_Id </label>
						<!--  <input type="text" class="form-control" name="name" id="name" placeholder="Name of contact person" value="" required /> -->
						<form:input path="flightId" cssClass="form-control" placeholder="flight Id" required="required" />
						<form:errors path="flightId" cssClass="has-error" />
					</div>

	                               <div class="text-right">
						<button type="submit" class="btn-lg btn-primary">RESERVE</button>
						<button type="reset" class="btn-lg btn-success">CLEAR</button>
					</div>
				</form:form>
                                  <div class="text-right">
                                          <a href="${pageContext.request.contextPath}/flight">
				    <button type="submit" class="btn-lg btn-primary">BackToFlightList</button>
					</a>
					</div>
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

