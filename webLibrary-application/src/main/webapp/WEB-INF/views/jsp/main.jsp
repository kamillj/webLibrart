<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <title>Welcome</title>
</head>
<body>
<h2>Hello to WebLibrary application!</h2>


<c:url var="saveAction" value="/account/save"/>

<form:form method="POST" modelAttribute="accountForm" action="${saveAction}">
    <table>
        <tr>
            <td><form:label path="firstName">First Name</form:label></td>
            <td><form:input path="firstName"/></td>
        </tr>
        <tr>
            <td><form:label path="lastName">Last Name</form:label></td>
            <td><form:input path="lastName"/></td>
        </tr>
        <tr>
            <td><form:label path="birthday">Date of birth</form:label></td>
            <td><form:input type="date" path="birthday"/></td>
        </tr>
        <tr>
            <td><input type="submit" value="Submit"/></td>
        </tr>
    </table>
</form:form>

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
                    <td>${account.birthday}</td>
                    <td><a href="<c:url value='/account/delete/${account.id}'/>">Delete</a></td>
                </tr>
            </c:forEach>
        </c:when>
    </c:choose>
</table>
</body>
</html>
