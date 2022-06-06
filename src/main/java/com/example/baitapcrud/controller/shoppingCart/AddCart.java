package com.example.baitapcrud.controller.shoppingCart;

import com.example.baitapcrud.entity.Product;
import com.example.baitapcrud.entity.ShoppingCart;
import com.example.baitapcrud.model.MySqlProductModel;
import com.example.baitapcrud.model.ProductModel;
import com.example.baitapcrud.util.ShoppingCartHelper;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AddCart extends HttpServlet {
    private ProductModel productModel;

    public AddCart() {
        this.productModel = new MySqlProductModel();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            Integer productId = Integer.parseInt(req.getParameter("productId"));
            Integer quantity = Integer.parseInt(req.getParameter("quantity"));
            Product product = productModel.findById(productId);
            if (product == null) {
                resp.getWriter().println("Product is not found!");
                return;
            }
            if (quantity <= 0) {
                resp.getWriter().println("Invalid quantity!");
                return;
            }
            ShoppingCartHelper shoppingCartHelper = new ShoppingCartHelper(req);
            ShoppingCart shoppingCart = shoppingCartHelper.getCart();
            shoppingCart.add(product, quantity);
            shoppingCartHelper.saveCart(shoppingCart);
            resp.sendRedirect("/shopping-cart/get");
        } catch (Exception e) {
            resp.getWriter().println(e.getMessage());
        }
    }
}
