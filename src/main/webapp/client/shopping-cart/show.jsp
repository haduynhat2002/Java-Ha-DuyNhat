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
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
    <script src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
<section class="h-100 h-custom" style="background-color: #d2c9ff;">
    <div class="container py-5 h-100">
        <div class="row d-flex justify-content-center align-items-center h-100">
            <div class="col-12">
                <div class="card card-registration card-registration-2" style="border-radius: 15px;">
                    <div class="card-body p-0">
                        <div class="row g-0">
                            <div class="col-lg-8">
                                <div class="p-5">
                                    <div class="d-flex justify-content-between align-items-center mb-5">
                                        <h1 class="fw-bold mb-0 text-black">Shopping Cart</h1>
                                        <h6 class="mb-0 text-muted">3 items</h6>
                                    </div>
                                    <hr class="my-4">
                                    <% for (CartItem cartItem: shoppingCart.getListItems()) {%>
                                    <div class="row mb-4 d-flex justify-content-between align-items-center">
                                        <div class="col-md-2 col-lg-2 col-xl-2">
                                            <img
                                                    src="<%=cartItem.getProductThumbnail()%>"
                                                    class="img-fluid rounded-3">
                                        </div>
                                        <div class="col-md-3 col-lg-3 col-xl-3">
                                            <h6 class="text-muted">Name</h6>
                                            <h6 class="text-black bg-blue mb-0"><%=cartItem.getProductName()%></h6>
                                        </div>
                                        <div class="col-md-3 col-lg-3 col-xl-2 d-flex">
                                            <a href="/shopping-cart/add?productId=<%=cartItem.getProductId()%>&quantity=1" class="btn btn-link px-2" style="background-color: #0c84ff"
                                                    onclick="this.parentNode.querySelector('input[type=number]').stepDown()">
                                                +
                                            </a>

                                            <input style="margin: 0 2px; height: 38px; width: 40px;" id="form1" min="0" name="quantity" value="1" type="number"
                                                   class="form-control form-control-sm" />

                                            <a href="/shopping-cart/sub?productId=<%=cartItem.getProductId()%>&quantity=1" class="btn bg-blue btn-link px-2" style="background-color: #0c84ff"
                                                    onclick="this.parentNode.querySelector('input[type=number]').stepUp()">
                                                -
                                            </a>
                                        </div>
                                        <div class="col-2">
                                            <h6 class="mb-0">€ <%=cartItem.getUnitPrice()%></h6>
                                        </div>
                                        <div class="col-3">
                                            <a href="/shopping-cart/remove?productId=<%=cartItem.getProductId()%>" class="text-muted">Remove</a>
                                        </div>
                                    </div>
                                    <%}%>
                                    <hr class="my-4">

                                    <div class="pt-5">
                                        <h6 class="mb-0"><a href="/products" class="text-body"><i
                                                class="fas fa-long-arrow-alt-left me-2"></i>Back to shop</a></h6>
                                    </div>
                                </div>
                            </div>
                            <div class="col-lg-4 bg-grey">
                                <div class="p-5">
                                    <h3 class="fw-bold mb-5 mt-2 pt-1">Summary</h3>
                                    <hr class="my-4">

                                    <div class="d-flex justify-content-between mb-5">
                                        <h5 class="text-uppercase">Total price</h5>
                                        <h5> <%=nf.format(shoppingCart.getTotalPrice())%></h5>
                                    </div>



                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>
</body>
</html>
