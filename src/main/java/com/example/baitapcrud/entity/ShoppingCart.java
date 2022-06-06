package com.example.baitapcrud.entity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ShoppingCart {
    private double totalPrice;
    private String shipName;
    private String addressName;
    private String shipPhone;
    private String shipNote;
    private HashMap<Integer, CartItem> items;

    public ShoppingCart() {
        items = new HashMap<>();
    }

    public List<CartItem> getListItems() {
        return new ArrayList<>(items.values());
    }

    public boolean add(Product product, int quantity) {

        CartItem cartItem = null;
        if (items.containsKey(product.getId())) {
            cartItem = items.get(product.getId());
            cartItem.setQuantity(cartItem.getQuantity() + quantity);
        } else {
            cartItem = CartItem.CartItemBuilder.aCartItem()
                    .productId(product.getId())
                    .productName(product.getName())
                    .productThumbnail(product.getThumbnail())
                    .unitPrice(product.getPrice())
                    .quantity(quantity)
                    .build();
        }
        items.put(product.getId(), cartItem);
        return true;
    }

    public boolean sub(Product product, int quantity) {
        CartItem cartItem = null;
        if (items.containsKey(product.getId())) {
            cartItem = items.get(product.getId());
            int updateQuantity = cartItem.getQuantity() - quantity;
            if (updateQuantity <= 0) {
                items.remove(product.getId());
            } else {
                cartItem.setQuantity(updateQuantity);
            }
        }
        return true;
    }

    public boolean remove(int productId) {
        if (items.containsKey(productId)) {
            items.remove(productId);
            return true;
        }
        return false;
    }

    public void clear() {
        items.clear();
    }

    public double getTotalPrice() {
        if (items.size() == 0) {
            return 0;
        }
        totalPrice = 0;
        for (CartItem item : getListItems()) {
            totalPrice += item.getUnitPrice() * item.getQuantity();
        }
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getShipName() {
        return shipName;
    }

    public void setShipName(String shipName) {
        this.shipName = shipName;
    }

    public String getAddressName() {
        return addressName;
    }

    public void setAddressName(String addressName) {
        this.addressName = addressName;
    }

    public String getShipPhone() {
        return shipPhone;
    }

    public void setShipPhone(String shipPhone) {
        this.shipPhone = shipPhone;
    }

    public String getShipNote() {
        return shipNote;
    }

    public void setShipNote(String shipNote) {
        this.shipNote = shipNote;
    }

}
