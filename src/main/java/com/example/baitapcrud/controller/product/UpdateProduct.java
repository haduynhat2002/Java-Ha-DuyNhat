package com.example.baitapcrud.controller.product;

import com.example.baitapcrud.entity.Product;
import com.example.baitapcrud.model.MySqlProductModel;
import com.example.baitapcrud.model.ProductModel;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;

public class UpdateProduct extends HttpServlet {
    private ProductModel productModel;
    public UpdateProduct() {
        this.productModel = new MySqlProductModel();
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Product product = productModel.findById(Integer.parseInt(req.getParameter("id")));
        if(product == null) {
            product = new Product();
        }
        req.setAttribute("product", product);
        req.getRequestDispatcher("/products/update.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


    }
}
