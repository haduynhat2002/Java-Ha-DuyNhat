package com.example.baitapcrud.model;

import com.example.baitapcrud.constant.SqlConstant;
import com.example.baitapcrud.entity.Account;
import com.example.baitapcrud.entity.myenum.AccountStatus;
import com.example.baitapcrud.service.ConnectionHelper;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class MySqlAccountModel implements AccountModel{
    @Override
    public boolean save(Account obj) {
        try {
            Connection connection = ConnectionHelper.getConnection();
            PreparedStatement preparedStatement
                    = connection.prepareStatement(SqlConstant.ACCOUNT_INSERT);
            preparedStatement.setString(1, obj.getUsername());
            preparedStatement.setString(2, obj.getPassword());
            preparedStatement.setString(3, obj.getFullName());
            preparedStatement.setString(4, obj.getCreatedAt().toString());
            preparedStatement.setString(5, obj.getUpdatedAt().toString());
            preparedStatement.setInt(6, obj.getCreatedBy());
            preparedStatement.setInt(7, obj.getUpdatedBy());
            preparedStatement.setInt(8, obj.getStatus().getValue());
            preparedStatement.execute();
            return true;
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
            ex.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean update(int id, Account updateObj) {
        Connection connection = ConnectionHelper.getConnection();
        try {
            PreparedStatement preparedStatement =
                    connection.prepareStatement(SqlConstant.ACCOUNT_UPDATE);
            preparedStatement.setString(1, updateObj.getUsername());
            preparedStatement.setString(2, updateObj.getPassword());
            preparedStatement.setString(3, updateObj.getFullName());
            preparedStatement.setInt(4, updateObj.getCreatedBy());
            preparedStatement.setInt(5, updateObj.getUpdatedBy());
            preparedStatement.setInt(6, updateObj.getStatus().getValue());
            preparedStatement.execute();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean delete(int id) {
        Connection connection = ConnectionHelper.getConnection();
        try {
            PreparedStatement preparedStatement =
                    connection.prepareStatement(SqlConstant.ACCOUNT_DELETE);
            preparedStatement.setInt(1, -1);
            preparedStatement.setInt(2, id);
            preparedStatement.execute();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public List<Account> findAll() {
        List<Account> listObj = new ArrayList<>();
        try {
            Connection connection = ConnectionHelper.getConnection();
            PreparedStatement preparedStatement =
                    connection.prepareStatement(SqlConstant.ACCOUNT_SELECT_ALL);
            preparedStatement.setInt(1, AccountStatus.ACTIVE.getValue());
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Account account = convertResultSetToAccount(resultSet);
                if (account != null) {
                    listObj.add(account);
                }

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listObj;
    }

    @Override
    public Account findById(int id) {
        try {
            Connection connection = ConnectionHelper.getConnection();
            PreparedStatement preparedStatement =
                    connection.prepareStatement(SqlConstant.ACCOUNT_SELECT_BY_ID);
            preparedStatement.setInt(1, AccountStatus.ACTIVE.getValue());
            preparedStatement.setInt(2, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return convertResultSetToAccount(resultSet);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Account findByUsername(String username) {
        try {
            Connection connection = ConnectionHelper.getConnection();
            PreparedStatement preparedStatement =
                    connection.prepareStatement(SqlConstant.ACCOUNT_SELECT_BY_USERNAME);
            preparedStatement.setInt(1, AccountStatus.ACTIVE.getValue());
            preparedStatement.setString(2, username);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return convertResultSetToAccount(resultSet);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    private Account convertResultSetToAccount(ResultSet resultSet) {
        try {
            int id = resultSet.getInt(SqlConstant.ACCOUNT_FIELD_ID);
            String username = resultSet.getString(SqlConstant.ACCOUNT_FIELD_USERNAME);
            String passwordHash = resultSet.getString(SqlConstant.ACCOUNT_FIELD_PASSWORD);
            String fullName = resultSet.getString(SqlConstant.ACCOUNT_FIELD_FULLNAME);
            int status = resultSet.getInt(SqlConstant.ACCOUNT_FIELD_STATUS);
            LocalDateTime createdAt = resultSet.getTimestamp(SqlConstant.FIELD_CREATED_AT).toLocalDateTime();
            LocalDateTime updatedAt = resultSet.getTimestamp(SqlConstant.FIELD_UPDATED_AT).toLocalDateTime();
            LocalDateTime deletedAt = null;
            Timestamp timestamp = resultSet.getTimestamp(SqlConstant.FIELD_DELETED_AT);
            if (timestamp != null) {
                deletedAt = timestamp.toLocalDateTime();
            }
            int createdBy = resultSet.getInt(SqlConstant.FIELD_CREATED_BY);
            int updatedBy = resultSet.getInt(SqlConstant.FIELD_UPDATED_BY);
            int deletedBy = resultSet.getInt(SqlConstant.FIELD_DELETED_BY);
            Account account = new Account(id, username, passwordHash, fullName, AccountStatus.of(status));
            account.setCreatedAt(createdAt);
            account.setUpdatedAt(updatedAt);
            account.setDeletedAt(deletedAt);
            account.setCreatedBy(createdBy);
            account.setUpdatedBy(updatedBy);
            account.setDeletedBy(deletedBy);
            return account;
        } catch (SQLException ex) {
            return null;
        }
    }
}
