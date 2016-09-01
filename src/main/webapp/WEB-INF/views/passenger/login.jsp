<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"  %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"  %>

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
				<h1>Online Ticket Reservation System</h1>
				<h2>Welcome our Customer</h2>
			</div>
		</div>
	</section>
<div class="container">
    <div class="row">
		<div class="col-md-4 col-md-offset-4">
    		<div class="panel panel-default">
			  	<div class="panel-heading">
			    	<h3 class="panel-title">Please sign in</h3>
			 	</div>
			  	<div class="panel-body">
                                     <c:if test="${not empty SPRING_SECURITY_LAST_EXCEPTION}">
      <font color="red">
        Your login attempt was not successful due to <br/><br/>
        <c:out value="${SPRING_SECURITY_LAST_EXCEPTION.message}"/>.
      </font>
    </c:if>
			  	<c:if test="${not empty error}">
					<div class="alert alert-danger">
						<spring:message code="AbstractUserDetailsAuthenticationProvider.badCredentials"/><br />
					</div>
				</c:if>
			    	<form:form  modelAttribute="newCustomer" method="post">
                    <fieldset>
			    	  			<div class="form-group">
						<label for="title">UserName</label>
						<!--  <input type="text" class="form-control" name="name" id="name" placeholder="Name of contact person" value="" required /> -->
						<form:input path="username" cssClass="to-control" placeholder="Name of flight" required="required" />
						<form:errors path="username" cssClass="has-error" />
					</div>
						<div class="form-group">
						<label for="title">Password</label>
						<!--  <input type="text" class="form-control" name="name" id="name" placeholder="Name of contact person" value="" required /> -->
						<form:input path="password" cssClass="to-control" placeholder="Name of flight" required="required" />
						<form:errors path="password" cssClass="has-error" />
					</div>

					
			    		<input class="btn btn-lg btn-success btn-block" type="submit" value="Login">
			    	</fieldset>
			      	</form:form>
       <a href="${pageContext.request.contextPath}/passenger/logincancel" class="list-group-item active"> <button class="btn btn-primary">Cancel</button>
			    </div>
			</div>
		</div>
	</div>
</div>
</body>
