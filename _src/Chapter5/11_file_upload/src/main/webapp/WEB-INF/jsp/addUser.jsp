<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<form:form method="POST" modelAttribute="defaultUser" enctype="multipart/form-data">

	<form:input path="firstName" />

	<form:input path="age" />

	<input type="file" name="file" />

	<input type="submit" value="Submit" />
</form:form>
