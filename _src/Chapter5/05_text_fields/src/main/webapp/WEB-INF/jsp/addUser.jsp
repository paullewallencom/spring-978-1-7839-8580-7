<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<form:form method="POST" modelAttribute="defaultUser">


	<form:input path="firstName1" />
	<form:textarea path="firstName2" />
	<form:password path="firstName3" />
	<form:hidden path="firstName4" />

	<input type="submit" value="Submit" />
</form:form>
