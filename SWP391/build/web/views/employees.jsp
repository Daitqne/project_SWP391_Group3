<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
    <head>
        <title>Employee Management</title>
    </head>
    <body>
    <center>
        <h2>Employee List</h2>
        <a href="employees?action=new">Add New Employee</a>
        <table border="1" width="80%">
            <tr>
                <th>First Name</th>
                <th>Last Name</th>
                <th>Phone</th>
                <th>Email</th>
                <th>Actions</th>
            </tr>
            <c:forEach var="employee" items="${requestScope.employeeList}">
                <tr>
                    <td>${employee.firstName}</td>
                    <td>${employee.lastName}</td>
                    <td>${employee.phone}</td>
                    <td>${employee.email}</td>
                    <td>
                        <a href="employees?action=edit&id=${employee.employeeId}">Edit</a> |
                        <a href="employees?action=delete&id=${employee.employeeId}">Delete</a>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </center>
</body>
</html>
