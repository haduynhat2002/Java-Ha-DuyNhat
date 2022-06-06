package com.example.baitapcrud.controller.product.client;

import com.example.baitapcrud.model.MySqlProductModel;
import com.example.baitapcrud.model.ProductModel;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ListProductClient extends HttpServlet {
    private ProductModel productModel;

    public ListProductClient() {
        this.productModel = new MySqlProductModel();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("product", productModel.findAll());
        req.getRequestDispatcher("/client/product/list.jsp").forward(req, resp);
    }
}
