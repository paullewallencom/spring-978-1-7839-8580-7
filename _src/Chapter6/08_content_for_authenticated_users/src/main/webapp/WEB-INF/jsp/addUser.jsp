<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>		

<sec:authorize access="isAuthenticated()">
  Username: <sec:authentication property="principal.username" />
</sec:authorize>

<form:form method="POST" modelAttribute="defaultUser">

	<form:input path="firstName" />
	<form:checkbox path="married" />

	<input type="submit" value="Submit" />
</form:form>
