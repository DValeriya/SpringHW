<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE HTML>
<html>
<head>
    <title>Add Post</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
</head>
<body>
<h1>Add Post</h1>
<form:form method="POST" action="/add_post" modelAttribute="post">
    <table>
        <tr>
            <td><form:label path="id">Id</form:label></td>
            <td><form:input path="id"/></td>
        </tr>
        <tr>
            <td><form:label path="title">Title</form:label></td>
            <td><form:input path="title"/></td>
        </tr>
        <tr>
            <td><form:label path="description">Description</form:label></td>
            <td><form:input path="description"/></td>
        </tr>
        <tr>
            <td><input type="submit" value="Add"/></td>
        </tr>

        <td>
            <button><a href="/">To main page</a></button>
        </td>
    </table>
</form:form>
</body>
</html>