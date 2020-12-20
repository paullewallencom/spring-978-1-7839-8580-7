<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<form:form method="POST" modelAttribute="defaultUser">

	<form:input path="firstName" />
	<form:checkboxes items="${languages}" path="languages" />

	<input type="submit" value="Submit" />
</form:form>
