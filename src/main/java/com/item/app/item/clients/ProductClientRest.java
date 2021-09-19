package com.item.app.item.clients;

import java.util.List;


import com.products.app.productscommons.models.entity.Product;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "products-service")
public interface ProductClientRest {

    @GetMapping("/list")
    public List<Product> listar();

    @GetMapping("/detail/{id}")
    public Product detail(@PathVariable Long id);
    
}
