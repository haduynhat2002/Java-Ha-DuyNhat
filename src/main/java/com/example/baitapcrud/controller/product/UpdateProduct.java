package com.example.baitapcrud.controller.product;

import thang.t2009m1.t2009m1java.entity.Product;
import thang.t2009m1.t2009m1java.model.product.MySqlProductModel;
import thang.t2009m1.t2009m1java.model.product.ProductModel;
import thang.t2009m1.t2009m1java.myenum.ProductStatus;

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

        int id = Integer.parseInt(req.getParameter("id"));
        String name = req.getParameter("name");
        String thumbnail = req.getParameter("thumbnail");
        BigDecimal price = BigDecimal.valueOf(Long.parseLong(req.getParameter("price")));
        String manufactureEmail = req.getParameter("manufactureEmail");
        String manufacturePhone = req.getParameter("manufacturePhone");
        String description = req.getParameter("description");
        String detail = req.getParameter("detail");
        Product product = new Product();
        product.setName(name);
        product.setDescription(description);
        product.setDetail(detail);
        product.setPrice(price);
        product.setThumbnail(thumbnail);
        product.setManufactureEmail(manufactureEmail);
        product.setManufacturePhone(manufacturePhone);
        product.setStatus(ProductStatus.STOCK);
        if (!product.isValid()) {
            req.setAttribute("product", product);
            req.setAttribute("errors", product.getErrors());
            req.getRequestDispatcher("/product/create-product.jsp").forward(req, resp);
            return;
        }
        boolean result = productModel.update(id, product);
        if (result) {
            resp.sendRedirect("/list-product");
        }
    }
}
