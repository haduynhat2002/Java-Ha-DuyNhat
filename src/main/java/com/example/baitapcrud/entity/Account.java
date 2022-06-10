package com.example.baitapcrud.entity;

import com.example.baitapcrud.entity.Base.BaseEntity;
import com.example.baitapcrud.entity.myenum.AccountStatus;
import com.example.baitapcrud.service.StringValidationHelper;

import java.time.LocalDateTime;
import java.util.HashMap;

public class Account extends BaseEntity {
    private int id;
    private String username;
    private String email;
    private String password;
    private String confirmPassword;
    private String fullName;
    private int roleId;
    private AccountStatus status;

    public Account(int id, String username, String email, String password, AccountStatus status) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
        this.confirmPassword = confirmPassword;
        this.fullName = fullName;
        this.roleId = roleId;
        this.status = status;
    }

    public Account(LocalDateTime createdAt, LocalDateTime updatedAt, LocalDateTime deletedAt, int createdBy, int updatedBy, int deletedBy, int id, String username, String email, String password, String confirmPassword, String fullName, int roleId, AccountStatus status) {
        super(createdAt, updatedAt, deletedAt, createdBy, updatedBy, deletedBy);
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
        this.confirmPassword = confirmPassword;
        this.fullName = fullName;
        this.roleId = roleId;
        this.status = status;
    }

    public Account() {
        this.email = "";
        this.username = "";
        this.fullName = "";
        this.setCreatedAt(LocalDateTime.now());
        this.setUpdatedAt(LocalDateTime.now());
        this.setCreatedBy(0);
        this.setUpdatedBy(0);
        this.status = AccountStatus.ACTIVE;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", confirmPassword='" + confirmPassword + '\'' +
                ", fullName='" + fullName + '\'' +
                ", roleId=" + roleId +
                ", status=" + status +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public AccountStatus getStatus() {
        return status;
    }

    public void setStatus(AccountStatus status) {
        this.status = status;
    }

    private HashMap<String, String> errors = new HashMap<>();

    public boolean isValid() {
        checkValid();
        return errors.size() == 0;
    }

    private void checkValid() {
        if (username == null || username.length() == 0) {
            errors.put("username", "Please enter username.");
        }
        if (password == null || password.length() == 0) {
            errors.put("password", "Please enter password.");
        }
        if (password != null && password.length() > 0
                && !password.equals(confirmPassword)) {
            errors.put("confirmPassword", "Confirm password is not match.");
        }
        if (fullName == null || fullName.length() == 0) {
            errors.put("fullName", "Please enter full name.");
        }
        if (email == null || email.length() == 0) {
            errors.put("email", "Please enter email.");
        }
        if(email != null && email.length() > 0 && !StringValidationHelper.checkValidEmail(email)){
            errors.put("email", "Invalid email.");
        }
    }

    public HashMap<String, String> getErrors() {
        return errors;
    }

    public void setErrors(HashMap<String, String> errors) {
        this.errors = errors;
    }


    public static final class AccountBuilder {
        private int id;
        private String username;
        private String email;
        private String password;
        private String confirmPassword;
        private String fullName;
        private int roleId;
        private AccountStatus status;
        private LocalDateTime createdAt;
        private LocalDateTime updatedAt;
        private LocalDateTime deletedAt;
        private int createdBy;
        private int updatedBy;
        private int deletedBy;

        private AccountBuilder() {
        }

        public static AccountBuilder anAccount() {
            return new AccountBuilder();
        }

        public AccountBuilder id(int id) {
            this.id = id;
            return this;
        }

        public AccountBuilder username(String username) {
            this.username = username;
            return this;
        }

        public AccountBuilder email(String email) {
            this.email = email;
            return this;
        }

        public AccountBuilder password(String password) {
            this.password = password;
            return this;
        }

        public AccountBuilder confirmPassword(String confirmPassword) {
            this.confirmPassword = confirmPassword;
            return this;
        }

        public AccountBuilder fullName(String fullName) {
            this.fullName = fullName;
            return this;
        }

        public AccountBuilder roleId(int roleId) {
            this.roleId = roleId;
            return this;
        }

        public AccountBuilder status(AccountStatus status) {
            this.status = status;
            return this;
        }

        public AccountBuilder createdAt(LocalDateTime createdAt) {
            this.createdAt = createdAt;
            return this;
        }

        public AccountBuilder updatedAt(LocalDateTime updatedAt) {
            this.updatedAt = updatedAt;
            return this;
        }

        public AccountBuilder deletedAt(LocalDateTime deletedAt) {
            this.deletedAt = deletedAt;
            return this;
        }

        public AccountBuilder createdBy(int createdBy) {
            this.createdBy = createdBy;
            return this;
        }

        public AccountBuilder updatedBy(int updatedBy) {
            this.updatedBy = updatedBy;
            return this;
        }

        public AccountBuilder deletedBy(int deletedBy) {
            this.deletedBy = deletedBy;
            return this;
        }

        public Account build() {
            Account account = new Account();
            account.setId(id);
            account.setUsername(username);
            account.setEmail(email);
            account.setPassword(password);
            account.setConfirmPassword(confirmPassword);
            account.setFullName(fullName);
            account.setRoleId(roleId);
            account.setStatus(status);
            account.setCreatedAt(createdAt);
            account.setUpdatedAt(updatedAt);
            account.setDeletedAt(deletedAt);
            account.setCreatedBy(createdBy);
            account.setUpdatedBy(updatedBy);
            account.setDeletedBy(deletedBy);
            return account;
        }
    }
}
