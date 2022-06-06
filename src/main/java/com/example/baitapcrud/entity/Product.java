package com.example.baitapcrud.entity;
import com.example.baitapcrud.entity.Base.BaseEntity;
import com.example.baitapcrud.entity.myenum.ProductStatus;
import java.time.LocalDateTime;
import java.util.HashMap;


public class Product extends BaseEntity {
    private int id;
    private String name;
    private String thumbnail;
    private double price;
    private int categoryId;
    private String description;
    private String detail;
    private ProductStatus status;

    public Product() {
        this.setName("");
        this.setThumbnail("");
        this.setDetail("");
        this.setDescription("");
        this.setPrice(0);
        this.setCreatedAt(LocalDateTime.now());
        this.setUpdatedAt(LocalDateTime.now());
        this.setCreatedBy(0);
        this.setUpdatedBy(0);
        this.setStatus(ProductStatus.ACTIVE);
    }

    @Override
    public String toString() {
        return String.format("%s - %s - %f", this.id, this.name, this.price);
    }

    public Product(int id, String name, String thumbnail, double price, int categoryId, String description, String detail) {
        this.id = id;
        this.name = name;
        this.thumbnail = thumbnail;
        this.price = price;
        this.categoryId = categoryId;
        this.description = description;
        this.detail = detail;
    }

    public Product(int id, String name, String thumbnail, double price, int categoryId, String description, String detail, ProductStatus status) {
        this.id = id;
        this.name = name;
        this.thumbnail = thumbnail;
        this.price = price;
        this.categoryId = categoryId;
        this.description = description;
        this.detail = detail;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public ProductStatus getStatus() {
        return status;
    }

    public void setStatus(ProductStatus status) {
        this.status = status;
    }

    private HashMap<String, String> errors = new HashMap<>();

    public boolean isValid() {
        checkValid();
        return errors.size() == 0;
    }

    private void checkValid() {
        if (name == null || name.length() == 0) {
            errors.put("name", "Please enter product name.");
        }
        if (thumbnail == null || thumbnail.length() == 0) {
            errors.put("thumbnail", "Please enter thumbnail.");
        }
        if (description == null || description.length() == 0) {
            errors.put("description", "Please enter thumbnail.");
        }
        if (detail == null || detail.length() == 0) {
            errors.put("detail", "Please enter thumbnail.");
        }
    }

    public HashMap<String, String> getErrors() {
        return errors;
    }

    public void setErrors(HashMap<String, String> errors) {
        this.errors = errors;
    }


    public static final class ProductBuilder {
        private int id;
        private String name;
        private String thumbnail;
        private double price;
        private int categoryId;
        private String description;
        private String detail;
        private ProductStatus status;
        private HashMap<String, String> errors = new HashMap<>();
        private LocalDateTime createdAt;
        private LocalDateTime updatedAt;
        private LocalDateTime deletedAt;
        private int createdBy;
        private int updatedBy;
        private int deletedBy;

        private ProductBuilder() {
            this.name = ("");
            this.price = (0);
            this.createdAt = (LocalDateTime.now());
            this.updatedAt = (LocalDateTime.now());
            this.createdBy = (0);
            this.updatedBy = (0);
            this.status = (ProductStatus.ACTIVE);
        }

        public static ProductBuilder aProduct() {
            return new ProductBuilder();
        }

        public ProductBuilder withId(int id) {
            this.id = id;
            return this;
        }

        public ProductBuilder withName(String name) {
            this.name = name;
            return this;
        }

        public ProductBuilder withThumbnail(String thumbnail) {
            this.thumbnail = thumbnail;
            return this;
        }

        public ProductBuilder withPrice(double price) {
            this.price = price;
            return this;
        }

        public ProductBuilder withCategoryId(int categoryId) {
            this.categoryId = categoryId;
            return this;
        }

        public ProductBuilder withDescription(String description) {
            this.description = description;
            return this;
        }

        public ProductBuilder withDetail(String detail) {
            this.detail = detail;
            return this;
        }

        public ProductBuilder withStatus(ProductStatus status) {
            this.status = status;
            return this;
        }

        public ProductBuilder withErrors(HashMap<String, String> errors) {
            this.errors = errors;
            return this;
        }

        public ProductBuilder withCreatedAt(LocalDateTime createdAt) {
            this.createdAt = createdAt;
            return this;
        }

        public ProductBuilder withUpdatedAt(LocalDateTime updatedAt) {
            this.updatedAt = updatedAt;
            return this;
        }

        public ProductBuilder withDeletedAt(LocalDateTime deletedAt) {
            this.deletedAt = deletedAt;
            return this;
        }

        public ProductBuilder withCreatedBy(int createdBy) {
            this.createdBy = createdBy;
            return this;
        }

        public ProductBuilder withUpdatedBy(int updatedBy) {
            this.updatedBy = updatedBy;
            return this;
        }

        public ProductBuilder withDeletedBy(int deletedBy) {
            this.deletedBy = deletedBy;
            return this;
        }

        public Product build() {
            Product product = new Product();
            product.setId(id);
            product.setName(name);
            product.setThumbnail(thumbnail);
            product.setPrice(price);
            product.setCategoryId(categoryId);
            product.setDescription(description);
            product.setDetail(detail);
            product.setStatus(status);
            product.setCreatedAt(createdAt);
            product.setUpdatedAt(updatedAt);
            product.setDeletedAt(deletedAt);
            product.setCreatedBy(createdBy);
            product.setUpdatedBy(updatedBy);
            product.setDeletedBy(deletedBy);
            product.errors = this.errors;
            return product;
        }
    }
}
