<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE HTML>
<html>
<head>
    <title>Add Comment</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
</head>
<body>
<h1>Add Comment</h1>
<form:form method="POST" action="/${post_id}/add_comment" modelAttribute="comment">
    <table>
        <tr>
            <td><form:label path="id">Id</form:label></td>
            <td><form:input path="id"/></td>
        </tr>
        <tr>
            <td><form:label path="message">Message</form:label></td>
            <td><form:input path="message"/></td>
        </tr>
        <tr>
            <td><input type="submit" value="Add"/></td>
        </tr>
        <td>
            <button><a href="/${post_id}">Go back</a></button>
        </td>
        <td>
            <button><a href="/">To main page</a></button>
        </td>
    </table>
</form:form>
</body>
</html>