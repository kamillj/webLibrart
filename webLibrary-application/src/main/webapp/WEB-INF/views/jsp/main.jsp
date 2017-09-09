<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Welcome</title>
</head>
<body>
<h2>Hello to WebLibrary application!</h2>
<table>
    <tr>
        <th width="200">First Name</th>
        <th width="200">Last Name</th>
        <th width="210">Birthdate</th>
    </tr>
    <c:choose>
        <c:when test="${!empty accounts}">
            <c:forEach items="${accounts}" var="account">
                <tr>
                    <td>${account.firstName}</td>
                    <td>${account.lastName}</td>
                    <td>${account.birthdate}</td>
                </tr>
            </c:forEach>
        </c:when>
    </c:choose>
</table>
</body>
</html>
