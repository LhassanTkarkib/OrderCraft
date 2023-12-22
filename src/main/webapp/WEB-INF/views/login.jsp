<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
<%--${pageContext.request.contextPath}--%>
<form action="${pageContext.request.contextPath}/auth/login" method="POST">

    <input type="text" name="username" placeholder="username" required>
    <input type="password" name="password" placeholder="password" required>
    <input type="submit" value="login">
</form>

</body>
</html>
