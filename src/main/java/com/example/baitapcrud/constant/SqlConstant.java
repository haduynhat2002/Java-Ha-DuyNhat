package com.example.baitapcrud.constant;


public class SqlConstant {
    public static final String ACCOUNT_INSERT = "insert into accounts (username, password, fullName, createdAt, updatedAt, createdBy, updatedBy, status) values (?,?,?,?,?,?,?,?)";
    public static final String ACCOUNT_SELECT_ALL = "select * from accounts where status = ?";
    public static final String ACCOUNT_SELECT_BY_ID = "select * from accounts where status = ? and id = ?";
    public static final String ACCOUNT_SELECT_BY_USERNAME = "select * from accounts where status = ? and username = ?";
    public static final String ACCOUNT_UPDATE = "update accounts set username = ?, password = ?, fullName = ?, createdAt = ?, updatedAt = ?, createdBy = ?, updatedBy = ?, status = ? where id = ?";
    public static final String ACCOUNT_DELETE = "update accounts set status = ? where id = ?";

    public static final String CATEGORY_INSERT = "insert into categories (name, createdAt, updatedAt, createdBy, updatedBy, status) values (?,?,?,?,?,?)";
    public static final String CATEGORY_UPDATE = "update categories set name = ?, updatedAt = ?, updatedBy = ?, status = ? where id = ?";
    public static final String CATEGORY_DELETE = "update categories set status = ? where id = ?";
    public static final String CATEGORY_SELECT_ALL = "select * from categories where status = ?";
    public static final String CATEGORY_SELECT_BY_ID = "select * from categories where status = ? and id = ?";

    public static final String PRODUCT_INSERT = "insert into products (name, thumbnail, price, categoryId, description, detail, createdAt, updatedAt, createdBy, updatedBy, status) values (?,?,?,?,?,?,?,?,?,?,?)";
    public static final String PRODUCT_UPDATE = "update products set name = ?, thumbnail = ?, price = ?, categoryId = ?, description = ?, detail = ?, updatedAt = ?, updatedBy = ?, status = ? where id = ?";
    public static final String PRODUCT_DELETE = "update products set status = ? where id = ?";
    public static final String PRODUCT_SELECT_ALL = "select * from products where status = ?";
    public static final String PRODUCT_SELECT_BY_ID = "select * from products where status = ? and id = ?";

    public static final String CATEGORY_FIELD_ID = "id";
    public static final String CATEGORY_FIELD_NAME = "name";
    public static final String CATEGORY_FIELD_STATUS = "status";

    public static final String PRODUCT_FIELD_ID = "id";
    public static final String PRODUCT_FIELD_NAME = "name";
    public static final String PRODUCT_FIELD_THUMBNAIL = "thumbnail";
    public static final String PRODUCT_FIELD_PRICE = "price";
    public static final String PRODUCT_FIELD_CATEGORY_ID = "categoryID";
    public static final String PRODUCT_FIELD_DESCRIPTION = "description";
    public static final String PRODUCT_FIELD_DETAIL = "detail";
    public static final String PRODUCT_FIELD_STATUS = "status";


    public static final String FIELD_CREATED_AT = "createdAt";
    public static final String FIELD_UPDATED_AT = "updatedAt";
    public static final String FIELD_DELETED_AT = "deletedAt";
    public static final String FIELD_CREATED_BY = "createdBy";
    public static final String FIELD_UPDATED_BY = "updatedBy";
    public static final String FIELD_DELETED_BY = "deletedBy";
}