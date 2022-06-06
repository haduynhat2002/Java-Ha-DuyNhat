<%@ page import="com.example.baitapcrud.entity.ShoppingCart" %>
<%@ page import="com.example.baitapcrud.util.ShoppingCartHelper" %>
<%@ page import="com.example.baitapcrud.entity.CartItem" %>
<%@ page import="java.util.Locale" %>
<%@ page import="java.text.NumberFormat" %><%--
  Created by IntelliJ IDEA.
  User: Hà Nhựt
  Date: 6/7/2022
  Time: 12:29 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    ShoppingCartHelper shoppingCartHelper = new ShoppingCartHelper(request);
    ShoppingCart shoppingCart = shoppingCartHelper.getCart();
    Locale loc = new Locale("vi", "VN");
    NumberFormat nf = NumberFormat.getCurrencyInstance(loc);
%>
<html>
<head>
    <title>Shopping cart</title>
</head>
<body>
<h1>
    List products in shopping cart
</h1>
<ul>
    <% for (CartItem cartItem: shoppingCart.getListItems()) {%>
        <li>
            <%=cartItem.getProductName()%>
            <%=nf.format(cartItem.getUnitPrice())%>
            <%=cartItem.getQuantity()%>
            <a href="/shopping-cart/add?productId=<%=cartItem.getProductId()%>&quantity=1" style="text-decoration: none">+</a>
            <a href="/shopping-cart/sub?productId=<%=cartItem.getProductId()%>&quantity=1" style="text-decoration: none">-</a>
            <a href="/shopping-cart/remove?productId=<%=cartItem.getProductId()%>" style="text-decoration: none">x</a>

        </li>


    <%}%>
</ul>
<strong>Total price: <%=nf.format(shoppingCart.getTotalPrice())%></strong>
</body>
</html>
