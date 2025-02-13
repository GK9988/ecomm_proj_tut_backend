package org.garvk.ecombackend.controller;

import org.garvk.ecombackend.model.Product;
import org.garvk.ecombackend.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class ProductsController {

    @Autowired
    private ProductService productService;

    @GetMapping("products")
    public ResponseEntity<List<Product>> getProducts(){
        List<Product> aOutEntityList = new ArrayList<>();

        aOutEntityList = productService.getAllProducts();

        return new ResponseEntity<>(aOutEntityList,HttpStatus.OK);
    }

    @GetMapping("product/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable("id") Integer aInId){
        Product aOutProduct = productService.getProductById(aInId);

        if(null == aOutProduct){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(aOutProduct, HttpStatus.OK);
    }

}
