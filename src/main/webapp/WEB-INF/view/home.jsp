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

    <!-- Add a link to point to /leaders for the managers -->
    <!-- The link will be only shown if the user has the appropriate role -->
    <security:authorize access="hasRole('MANAGER')">
        <p>
            <a href="${pageContext.request.contextPath}/leaders">Leadership Meeting</a>
        </p>
    </security:authorize>

    <!-- Add a link to point to /systems for the admins -->
    <!-- The link will be only shown if the user has the appropriate role -->
    <security:authorize access="hasRole('ADMIN')">
        <p>
            <a href="${pageContext.request.contextPath}/systems">IT Admins Meeting</a>
        </p>
    </security:authorize>

    <form:form action="${pageContext.request.contextPath}/logout" method="POST">
        <input type="submit" value="Logout" />
    </form:form>
</body>

</html>