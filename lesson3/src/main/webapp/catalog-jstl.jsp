<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <title>Товары</title>
</head>
<body>
<%@include file="Main_menu.jsp"%>
</body>

<table>
    <tr>
        <th>Id</th>
        <th>Name</th>
        <th>Price</th>
        <th>Description</th>
    </tr>
    <%-- При помощи requestScope мы получаем доступ к аттрибутам --%>
    <%-- которые были сохранены в контекст в коде сервлета --%>
    <%-- Данный коду в файле products.jsp, но использует JSTL теги --%>
    <c:forEach items="${requestScope.products}" var="product">
    <tr>
        <td>${product.getId()}</td>
        <td>${product.name}</td>
        <td>${product.price}</td>
        <td>${product.description}</td>
    </tr>
    </c:forEach>
</table>

</html>
