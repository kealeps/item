package com.item.app.item.models.service;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.item.app.item.models.Item;

import com.products.app.productscommons.models.entity.Product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service("restTemplate-service")
public class ItemServiceImpl  implements ItemService{

    @Autowired
    private RestTemplate restClient;

    @Override
    public List<Item> findAll() {
        List<Product> products = Arrays.asList(restClient.getForObject("http://products-service/list", Product[].class));
        return products.stream().map(p -> new Item(p, 1)).collect(Collectors.toList());
    }

    @Override
    public Item findById(Long id, Integer cantidad) {
        Map<String, String> pathVariables = new HashMap<String, String>();
        pathVariables.put("id", id.toString());
        Product product = restClient.getForObject("http://products-service/detail/{id}", Product.class, pathVariables);
        return new Item(product, cantidad);
    }

    @Override
    public Product save(Product product) {
        HttpEntity<Product> body = new HttpEntity<Product>(product);
        ResponseEntity<Product> response = restClient.exchange("http://products-service/save", HttpMethod.POST, body, Product.class);
        return response.getBody();
    }

    @Override
    public Product update(Product product, Long id) {
        Map<String, String> pathVariables = new HashMap<String, String>();
        pathVariables.put("id", id.toString());
        HttpEntity<Product> body = new HttpEntity<Product>(product);
        ResponseEntity<Product> response = restClient.exchange("http://products-service/save/{id}", HttpMethod.PUT, body, Product.class, pathVariables);
        return response.getBody();
    }

    @Override
    public void delete(Long id) {
        restClient.delete("http://products-service/delete/{id}", id);
    }
    
}
