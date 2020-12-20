<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ page isELIgnored="false" %>

<html>
<body>

<h1>User profile</h1>
<p>
	name: ${profile.name}<br />
	screenName: ${profile.screenName}<br />
	url: ${profile.url}<br />
	profileImageUrl: ${profile.profileImageUrl}<br />
	description: ${profile.description}<br />
	location: ${profile.location}<br />
	createdDate: ${profile.createdDate}<br />
	language: ${profile.language}<br />
	statusesCount: ${profile.statusesCount}<br />
	followersCount: ${profile.followersCount}<br />
</p>


</body>
</html>