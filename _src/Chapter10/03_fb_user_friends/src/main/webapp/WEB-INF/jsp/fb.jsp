<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ page isELIgnored="false" %>

<html>
<body>

<h1>User friends</h1>

<c:forEach items="${friendProfileList}" var="profile">
	<h2>${profile.name}</h2>
	<p>
		id: ${profile.id}<br />
		name: ${profile.name}<br />
		gender: ${profile.gender}<br />
	</p>
</c:forEach>

</body>
</html>