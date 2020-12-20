<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ page isELIgnored="false" %>

<html>
<body>

<h1>User tweets</h1>
<c:forEach items="${tweets}" var="tweet">
	<p>${tweet.text}</p>
</c:forEach>

</body>
</html>