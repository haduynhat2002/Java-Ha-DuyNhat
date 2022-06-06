package com.example.baitapcrud.controller.category;

import com.example.baitapcrud.entity.Category;
import com.example.baitapcrud.entity.Product;
import com.example.baitapcrud.entity.myenum.CategoryStatus;
import com.example.baitapcrud.entity.myenum.ProductStatus;
import com.example.baitapcrud.model.CategoryModel;
import com.example.baitapcrud.model.MySqlCategoryModel;
import com.example.baitapcrud.model.MySqlProductModel;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CreateCategory extends HttpServlet {
    private CategoryModel categoryModel;
    public CreateCategory() {
        this.categoryModel = new MySqlCategoryModel();
    }
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("create.jsp").forward(req, resp);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");
        resp.setCharacterEncoding("UTF-8");
        try {
            String name = req.getParameter("name");

            Category category = Category.CategoryBuilder.aCategory()
                    .withName(name)
                    .build();
            if (category.isValid()) {
                boolean result = categoryModel.save(category);
                if (result) {
                    resp.sendRedirect("/admin/category/list");
                } else {
                    throw new Exception("Can save product");
                }
            } else {
                req.setAttribute("error", category.getErrors());
                req.setAttribute("category", categoryModel.findAll());
                req.getRequestDispatcher("/admin/product/list.jsp").forward(req, resp);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            req.getRequestDispatcher("/admin/error/500.jsp").forward(req, resp);
        }

    }
}