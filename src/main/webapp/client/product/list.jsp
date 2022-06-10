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
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
    <script src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
<%--<h1>List product</h1>--%>
<%--<ul>--%>
<%--    <%for(Product product: products) {%>--%>
<%--    <li>--%>
<%--        <%=product.toString()%>--%>
<%--        <a href="/shopping-cart/add?productId=<%=product.getId()%>&quantity=1">Add to cart</a>--%>
<%--    </li>--%>
<%--    <%}%>--%>
<%--</ul>--%>
<div class="container">
    <h2 class="section-title text-center">For Every Developer</h2>
    <div class="section-intro mb-5 text-center">More cool programming tees available at <a class="theme-link" href="https://made4dev.com" target="_blank">made4dev.com</a></div>
    <div class="row">
        <%for(Product product: products) {%>
        <div class="col-6 col-lg-3 mb-5">
            <div class="card text-center">
                <a href="https://made4dev.com/collections/tees/products/binary-joke-t-shirt-for-developers" target="_blank"></a>
                <div class="card-body">
                    <img class="img-fluid" src="<%=product.getThumbnail()%>">
                    <h5 class="card-title"><%=product.getName()%></h5>
                    <p class="card-text"><%=product.getPrice()%>đ</p>
                    <a class="btn btn-primary" href="/shopping-cart/add?productId=<%=product.getId()%>&quantity=1" target="_blank">Add to cart</a>
                    <p class="card-text mt-2"><small class="text-muted">made4dev.com</small></p>

                </div><!--//card-body-->
            </div><!--//card-->
        </div><!--//col-->
        <%}%>
    </div><!--//row-->
</div>
</body>
</html>
