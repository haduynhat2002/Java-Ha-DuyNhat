package com.example.baitapcrud.controller.category;
import com.example.baitapcrud.model.CategoryModel;
import com.example.baitapcrud.model.MySqlCategoryModel;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ListCategory extends HttpServlet {
    private CategoryModel categoryModel;
    public ListCategory() {
        this.categoryModel = new MySqlCategoryModel();
    }
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("categories", categoryModel.findAll());
        req.getRequestDispatcher("list.jsp").forward(req, resp);
    }
}
