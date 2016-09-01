<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"  %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet"	href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
<title>Products</title>
</head>
<body>
	<section>
		<div class="jumbotron">
			<div class="container">
				<h1>Passenger</h1>
				<p>Create Passenger Account</p>
                                    <a href="${pageContext.request.contextPath}/flight">
			<button class="btn btn-primary">HOME</button>
					</a>
			</div>
				
			
			
		</div>
	</section>
	<section class="container">
		<form:form  modelAttribute="newPassenger" class="form-horizontal" enctype="multipart/form-data">
			<fieldset>
				<legend>Add new passenger</legend>

				<form:errors path="*" cssClass="alert alert-danger" element="div"/>
				

				

				<div class="form-group">
					<label class="control-label col-lg-2" for="unitPrice"><spring:message code="addPassenger.form.firstName.label"/></label>
					<div class="col-lg-10">
						<div class="form:input-prepend">
							<form:input id="firstName" path="firstName" type="text" class="form:input-large"/>
							<form:errors path="firstName" cssClass="text-danger"/>
						</div>
					</div>
				</div>

				<div class="form-group">
					<label class="control-label col-lg-2" for="description"><spring:message code="addPassenger.form.lastName.label"/></label>
					<div class="col-lg-10">
						<div class="form:input-prepend">
							<form:input id="lastName" path="lastName" type="text" class="form:input-large"/>
							<form:errors path="lastName" cssClass="text-danger"/>
						</div>
					</div>
				</div>
                                <div class="form-group">
					<label class="control-label col-lg-2" for="unitPrice"><spring:message code="addPassenger.form.username.label"/></label>
					<div class="col-lg-10">
						<div class="form:input-prepend">
							<form:input id="userName" path="userName" type="text" class="form:input-large"/>
							<form:errors path="userName" cssClass="text-danger"/>
						</div>
					</div>
				</div>

                                    <div class="form-group">
					<label class="control-label col-lg-2" for="name"><spring:message code="addPassenger.form.password.label"/></label>
					<div class="col-lg-10">
						<form:input id="password" path="password" type="text" class="form:input-large"/>
						<form:errors path="password" cssClass="text-danger"/>
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-lg-2" for="tel_no"><spring:message code="addPassenger.form.tel_no.label"/></label>
					<div class="col-lg-10">
						<form:input id="tel_no" path="tel_no" type="text" class="form:input-large"/>
                                                <form:errors path="tel_no" cssClass="text-danger"/>
                                               
					</div>
				</div>

				<div class="form-group">
					<label class="control-label col-lg-2" for="email_id"><spring:message code="addPassenger.form.email.label"/></label>
					<div class="col-lg-10">
						<form:input id="email_id" path="email_id" type="text" class="form:input-large"/>
                                                <form:errors path="email_id" cssClass="text-danger"/>
					</div>
				</div>



				<div class="form-group">
					<div class="col-lg-offset-2 col-lg-10">
						<input type="submit" id="btnAdd" class="btn btn-primary" value ="Add"/>
					</div>
				</div>
				
			</fieldset>
		</form:form>
	</section>
</body>
</html>
