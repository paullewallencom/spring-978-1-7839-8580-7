<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ page isELIgnored="false" %>

<html>
<body>

<h1>User profile</h1>
<p>
	id: ${profile.id}<br />
	username: ${profile.username}<br />
	name: ${profile.name}<br />
	gender: ${profile.gender}<br />
	email: ${profile.email}<br />
	birthday: ${profile.birthday}<br />
	hometown: ${profile.hometown}<br />
</p>

</body>
</html>