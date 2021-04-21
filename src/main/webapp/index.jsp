<!DOCTYPE html>
<html>

<body>
    <h2>Spring REST Demo</h2>

    <hr>
    <br>

    <a href="${pageContext.request.contextPath}/api/students">API: Get All Students</a>
    <br><br>

    <a href="${pageContext.request.contextPath}/api/students/999">API: Test error exception -> Student not found</a>
    <br><br>

    <a href="${pageContext.request.contextPath}/api/students/ldkfsj">API: Test error exception -> General error exception</a>

</body>

</html>