package com.mphasis.SpringBoot.controller;

import com.mphasis.SpringBoot.model.Product;
import com.mphasis.SpringBoot.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.net.Authenticator;
import java.util.Map;

@RestController
@RequestMapping("/api/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/getProducts")
    public Map<String, Product> getProduct(){
     return productService.getlist();
    }

    @PostMapping(value = "/addProduct" )
    public ResponseEntity addProduct(@RequestBody Product product){

        productService.addProduct(product);
        return new ResponseEntity("Product added ", HttpStatus.OK);
     }

     @RequestMapping(value ="delProduct/{id}", method = RequestMethod.DELETE)
    public ResponseEntity removeProd(@PathVariable("id") String id){

        productService.delProduct(id);
         return new ResponseEntity("Product added ", HttpStatus.OK);
     }

    @RequestMapping(value = "upProduct/{id}" , method = RequestMethod.PUT)
    public ResponseEntity upProd(@PathVariable("id") String id,@RequestBody Product product){

        productService.upProduct(id,product);
        return new ResponseEntity("Product added ", HttpStatus.OK);
    }


}
