<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>

<body>
    <h2>Spring MVC Demo</h2>

    <form:form action="${pageContext.request.contextPath}/logout" method="POST">
        <input type="submit" value="Logout" />
    </form:form>
</body>

</html>