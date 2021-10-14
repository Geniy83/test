<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta charset="UTF-8"/>
    <title>employeeList</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css"/>
</head>
<body>
<h2>employeeList</h2>
<div>
    <table border="1">
        <tr class="cell-1">
            <th>employeeId</th>
            <th>firstName</th>
            <th>lastName</th>
            <th>departmentID</th>
            <th>jobTitle</th>
            <th>gender</th>
            <th>dataOfBirth</th>

        </tr>
        <c:forEach items="${employeeList}" var="employeeList">
        <tr>
            <td align="center">${employeeList.employeeId}</td>
            <td align="center">${employeeList.firstName}</td>
            <td align="center">${employeeList.lastName}</td>
            <td align="center">${employeeList.departmentID}</td>
            <td align="center">${employeeList.jobTitle}</td>
            <td align="center">${employeeList.gender}</td>
            <td align="center">${employeeList.dataOfBirth}</td>
            </c:forEach>
    </table>
    <h1></h1>
    <td>
        <h3><a href="/">Home</a></h3>
    </td>
</div>
</body>
</html>