<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<!DOCTYPE html>
<html>

<body>
    <h2>Spring MVC Demo</h2>

    <hr>
    <!-- Display user name and role -->
    <p>
        User: <security:authentication property="principal.username" />
        <br><br>
        Roles: <security:authentication property="principal.authorities" />
    </p>
    <hr>

    <form:form action="${pageContext.request.contextPath}/logout" method="POST">
        <input type="submit" value="Logout" />
    </form:form>
</body>

</html>