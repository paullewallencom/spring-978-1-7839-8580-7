<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<form:form method="POST" modelAttribute="defaultUser">

	<form:input path="firstName" />
	<form:errors path="firstName" cssclass="error"></form:errors>

	<form:input path="age" />
	<form:errors path="age" cssclass="error"></form:errors>


	<input type="submit" value="Submit" />
</form:form>
