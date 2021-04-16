package com.mphasis.SpringBoot.service;

import com.mphasis.SpringBoot.model.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Service
public class ProductService {

    ArrayList<Product> arrayList = new ArrayList<Product>();

    private static Map<String, Product> productRepo = new HashMap<>();
    static {
        Product honey = new Product();
        honey.setId("1");
        honey.setName("Honey");
        productRepo.put(honey.getId(), honey);

        Product almond = new Product();
        almond.setId("2");
        almond.setName("Almond");
        productRepo.put(almond.getId(), almond);
    }

    public Map<String, Product> getlist(){

      return productRepo;
    }

    public void addProduct(Product product) {

        productRepo.put(product.getId(),product);

    }

    public void delProduct(String id) {

        productRepo.remove(id);
    }

    public void upProduct(String id, Product product) {

        productRepo.remove(id);
        product.setId(id);
        productRepo.put(id,product);
    }

}
