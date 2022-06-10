package com.example.baitapcrud.controller.user;

import com.example.baitapcrud.entity.Account;
import com.example.baitapcrud.service.AccountService;
import com.mysql.cj.Session;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class LoginServlet extends HttpServlet{

    private AccountService accountService;

    public LoginServlet() {
        this.accountService = new AccountService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/client/user/login.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        Account account = this.accountService.login(username, password);
        if (account != null) {
            HttpSession session = req.getSession();
            session.setAttribute("currentAccount", account);
            System.out.println("Login success with username: " + username);
            resp.sendRedirect("/products");
        } else {
            req.setAttribute("message", "Invalid information");
            req.getRequestDispatcher("/client/user/login.jsp").forward(req, resp);
        }
    }
}
