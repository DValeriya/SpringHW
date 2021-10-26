<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Post</title>
</head>
<body>
<h1>${post.getId()}. ${post.getTitle()}</h1>
<p>
    Descroption: ${post.getDescription()}
</p>
<br>
<h6>Comments</h6>
<table>
    <c:forEach items="${post.getComments()}" var="comment">
        <tr>
            <td><c:out value="${comment.getId()}" /></td>
            <td><c:out value="${comment.getMessage()}" /></td>
        </tr>
    </c:forEach>
    <tr>
        <td>
            <button><a href="/${post.getId()}/add_comment">Add comment</a></button>
        </td>

        <td>
            <button><a href="/">To main page</a></button>
        </td>
    </tr>
</table>

</body>
</html>