package com.example.baitapcrud.entity.myenum;

public enum ProductStatus {
    ACTIVE(1), DEACTIVE(0), DELETED(-1), UNDEFINED(-2);
    private int value;

    ProductStatus(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public static ProductStatus of(int value){
        for (ProductStatus productStatus: ProductStatus.values()
             ) {
            if (productStatus.getValue() == value) {
                return productStatus;
            }
        }
        return UNDEFINED;
    }
}
