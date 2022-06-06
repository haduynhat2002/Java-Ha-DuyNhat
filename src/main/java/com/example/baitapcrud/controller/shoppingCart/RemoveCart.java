package com.example.baitapcrud.controller.shoppingCart;

import com.example.baitapcrud.entity.ShoppingCart;
import com.example.baitapcrud.model.MySqlProductModel;
import com.example.baitapcrud.model.ProductModel;
import com.example.baitapcrud.util.ShoppingCartHelper;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RemoveCart extends HttpServlet {
    private ProductModel productModel;
    public RemoveCart() {
        this.productModel = new MySqlProductModel();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            Integer productId = Integer.parseInt(req.getParameter("productId"));
            ShoppingCartHelper shoppingCartHelper = new ShoppingCartHelper(req);
            ShoppingCart shoppingCart = shoppingCartHelper.getCart();
            shoppingCart.remove(productId);
            shoppingCartHelper.saveCart(shoppingCart);
            resp.sendRedirect("/shopping-cart/get");
        } catch (Exception e) {
            resp.getWriter().println(e.getMessage());
        }
    }
}
