package com.item.app.item.models.service;

import java.util.List;
import java.util.stream.Collectors;

import com.item.app.item.clients.ProductClientRest;
import com.item.app.item.models.Item;

import com.products.app.productscommons.models.entity.Product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service("service-feign")
@Primary
public class ItemServiceFeign implements ItemService{

    @Autowired
    private ProductClientRest clientRest;

    @Override
    public List<Item> findAll() {
        return clientRest.listar().stream().map(p -> new Item(p, 1)).collect(Collectors.toList());
    }

    @Override
    public Item findById(Long id, Integer cantidad) {
        return new Item(clientRest.detail(id), cantidad);
    }

    @Override
    public Product save(Product product) {
        return null;
    }

    @Override
    public Product update(Product product, Long id) {
        return null;
    }

    @Override
    public void delete(Long id) {
        
    }
    
}
