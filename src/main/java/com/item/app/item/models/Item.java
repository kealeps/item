package com.item.app.item.models;
 


import com.products.app.productscommons.models.entity.Product;
import lombok.Data;

@Data
public class Item {

    private Product product;
    private Integer cantidad;

    public Item() {
    }

    public Item(Product product, Integer items) {
        this.product = product;
        this.cantidad = items;
    }
    public Double getTotal(){
        return product.getPrice() * cantidad.doubleValue();
    }
}
