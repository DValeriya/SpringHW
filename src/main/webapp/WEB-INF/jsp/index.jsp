<!DOCTYPE HTML>
<html>
<head>
    <meta charset="UTF-8" />
    <title>Welcome</title>
</head>
<body>
<h1>Usernames</h1>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<table>
    <c:forEach items="${usernames}" var="username">
        <tr>
            <td><c:out value="${username.getId()}" /></td>
            <td><c:out value="${username.getFirstname()}" /></td>
            <td><c:out value="${username.getLastname()}" /></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>