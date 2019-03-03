<%@ page import="java.util.Collection" %>
<%@ page import="ru.geekbrains.servlet.entity.Product" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
    <%
        for (Product product: (Collection<Product>) application.getAttribute("products")
             ) { %>
    <tr>
        <td><%=product.getId()%></td>
        <td><%=product.getName()%></td>
        <td><%=product.getPrice()%></td>
        <td><%=product.getDescription()%></td>
    </tr>
    <%  } %>
</table>

</html>
