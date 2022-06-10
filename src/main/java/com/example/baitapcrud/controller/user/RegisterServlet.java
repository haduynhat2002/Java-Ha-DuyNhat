package com.example.baitapcrud.controller.user;

import com.example.baitapcrud.entity.Account;
import com.example.baitapcrud.model.AccountModel;
import com.example.baitapcrud.model.MySqlAccountModel;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;

public class RegisterServlet extends HttpServlet {
    private AccountModel accountModel;

    public RegisterServlet() {
        this.accountModel = new MySqlAccountModel();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/client/user/register.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
//        resp.setContentType("text/html; charset=UTF-8");
//        resp.setCharacterEncoding("UTF-8");
        // lấy giá trị từ form gửi lên.
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String email = req.getParameter("email");
        String confirmPassword = req.getParameter("confirmPassword");
        String fullName = req.getParameter("fullName");
        // Khởi tạo đối tượng account từ thông tin truyền lên.
        Account account = Account.AccountBuilder.anAccount()
                .username(username)
                .email(email)
                .password(password)
                .password(confirmPassword)
                .fullName(fullName)
                .build();
//        Account account = new Account();
//        account.setUsername(username);
//        account.setEmail(email);
//        account.setPassword(password);
//        account.setConfirmPassword(confirmPassword);
//        account.setFullName(fullName);
        if(!account.isValid()){
            // trả dữ liệu cũ về form
            req.setAttribute("account", account);
            // kèm theo thông tin lỗi
            req.setAttribute("errors", account.getErrors());
            // tất cả được trả về
            req.getRequestDispatcher("/user/register.jsp").forward(req, resp);
            return;
        }
        // thực hiện save
        accountModel.save(account);
        req.setAttribute("account", account);
        req.getRequestDispatcher("/client/users/login.jsp").forward(req, resp);
    }

    public static void main(String[] args) {
        HashMap<String, String> errors = new HashMap<>();
        errors.put("username", "Please enter username");
        errors.put("password", "Please enter password");
        errors.put("confirmPassword", "Please enter confirm password");
        errors.put("fullName", "Please enter fullName");
        if (errors.containsKey("username")) {
        }
    }
}
