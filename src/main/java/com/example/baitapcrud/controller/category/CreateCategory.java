package com.example.baitapcrud.controller.category;

import com.example.baitapcrud.entity.Category;
import com.example.baitapcrud.entity.myenum.CategoryStatus;
import com.example.baitapcrud.model.CategoryModel;
import com.example.baitapcrud.model.MySqlCategoryModel;

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
        String name = req.getParameter("name");
        Category category = Category.CategoryBuilder.aCategory()
                .withName(name)
                .build();
        if(!category.isValid()){
            req.setAttribute("category", category);
            req.getRequestDispatcher("/admin/category/form.jsp").forward(req, resp);
            return;
        }
        categoryModel.save(category);
        req.setAttribute("category", category);
        req.getRequestDispatcher("/user/register-success.jsp").forward(req, resp);
    }
}