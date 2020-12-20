<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<form:form method="POST" modelAttribute="defaultUser">
	<form:input path="firstName" />
	<form:input path="age" />
	<input type="submit" value="Submit" />
</form:form>
