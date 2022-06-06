<%@ page import="com.example.baitapcrud.entity.Product" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: Hà Nhựt
  Date: 6/6/2022
  Time: 11:44 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    List<Product> products = (List<Product>) request.getAttribute("product");
%>
<html>
<head>
    <title>List product</title>
</head>
<body>
<h1>List product</h1>
<ul>
    <%for(Product product: products) {%>
    <li>
        <%=product.toString()%>
        <a href="/shopping-cart/add?productId=<%=product.getId()%>&quantity=1">Add to cart</a>
    </li>
    <%}%>
</ul>
</body>
</html>
