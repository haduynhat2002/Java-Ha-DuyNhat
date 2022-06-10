package com.example.baitapcrud.service;

import com.example.baitapcrud.entity.Account;
import com.example.baitapcrud.model.AccountModel;
import com.example.baitapcrud.model.MySqlAccountModel;
import com.example.baitapcrud.util.SHA512Hasher;

public class AccountService {
    private AccountModel accountModel;

    public AccountService() {
        this.accountModel = new MySqlAccountModel();
    }

    public Account register(Account account) {
        String salt = SHA512Hasher.randomString(7);
        String passwordHash = SHA512Hasher.encode(account.getPassword(), salt);
        account.setPassword(passwordHash + "." + salt);
        accountModel.save(account);
        return account;
    }

    public Account login(String username, String password) {
        Account account = accountModel.findByUsername(username);
        if (account != null && SHA512Hasher.checkPassword(account.getPassword(), password)) {
            return account;
        }
        return null;
    }
}
