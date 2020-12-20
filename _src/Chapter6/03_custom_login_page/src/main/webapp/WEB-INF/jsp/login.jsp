<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isELIgnored="false" %>

<c:url var="loginUrl" value="/login" />
<form action="${loginUrl}" method="post">      
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>

    <c:if test="${param.error != null}">       
        <p>
            Invalid username and password.
        </p>
    </c:if>

    <p>
        <label for="username">Username</label>
        <input type="text" id="username" name="username"/> 
    </p>

    <p>
        <label for="password">Password</label>
        <input type="password" id="password" name="password"/> 
    </p>


    <button type="submit">Log in</button>
</form>
