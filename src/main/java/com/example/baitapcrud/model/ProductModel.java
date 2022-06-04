package com.example.baitapcrud.model;
import com.example.baitapcrud.entity.Product;

import java.util.List;

public interface ProductModel {
    boolean save(Product product);
    boolean update(int id, Product productUpdate);
    boolean delete(int id);
    List<Product> findAll();
    Product findById(int id);
}
