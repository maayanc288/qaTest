package com.springboot.springbootapp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.springboot.springbootapp.model.Product;
import com.springboot.springbootapp.service.ProductService;

@RestController
	public class Productcontroller {

	    @Autowired
	    private ProductService productService;
	  //checked
	    @GetMapping("/products")
	    public ResponseEntity < List < Product >> getAllProduct() {
	        return ResponseEntity.ok().body(productService.getAllProduct());
	    }

	    //checked
	    @GetMapping("/products/{id}")
	    public ResponseEntity < Product > getProductById(@PathVariable String id) {
	        return ResponseEntity.ok().body(productService.getProductById(id));
	    }

	  //checked
	    @PostMapping(
	   value = "/add_product", consumes = "application/json", produces = "application/json")
	    public ResponseEntity < Product > createProduct(@RequestBody Product product  ) {
	    	return ResponseEntity.ok().body(this.productService.addProduct(product));

	    }

	    //checked
	    @PutMapping("/update_product/{id}")
	    public ResponseEntity < Product > updateProduct(@PathVariable long id, @RequestBody Product product) {
	        
	        return ResponseEntity.ok().body(this.productService.updateProduct(product));
	    }
	    
	   
    
	    @PutMapping("/update_quantity/{q}")
	    public ResponseEntity<Boolean> updateProductQuantity(@PathVariable long q, @RequestBody Product product) {
	        
	        return ResponseEntity.ok().body(this.productService.UpdateQuantity(product.getId(), q));
	    }
	    
	    
	    //checked 
	    @GetMapping("/quantity/{id}")
	    public ResponseEntity<Integer> getProductQuantityById(@PathVariable String id) {
	        return ResponseEntity.ok().body(productService.getProductQuantityByIdCode(id));
	    }
}
