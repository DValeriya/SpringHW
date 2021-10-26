<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML>
<html>
<head>
    <meta charset="UTF-8" />
    <title>Welcome</title>
</head>
<body>
<h1>All Posts</h1>
<button type="button"><a href="/add_post">Add post</a></button>
<br><br>
<table>
    <c:forEach items="${posts}" var="post">
        <tr>
            <td><c:out value="${post.getId()}" /></td>
            <td><c:out value="${post.getTitle()}" /></td>
            <td><c:out value="${post.getDescription()}" /></td>
            <td><a href="/${post.getId()}">View</a></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>