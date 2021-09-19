package com.item.app.item.models.service;

import java.util.List;

import com.item.app.item.models.Item;

import com.products.app.productscommons.models.entity.Product;

public interface ItemService {
    
    public List<Item> findAll();

    public Item findById(Long id, Integer cantidad);

    public Product save(Product product);

    public Product update(Product product, Long id);

    public void delete(Long id);
}
