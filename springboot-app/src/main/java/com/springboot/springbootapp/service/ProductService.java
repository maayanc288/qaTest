package com.springboot.springbootapp.service;

import java.util.List;

import com.springboot.springbootapp.model.Product;

public interface ProductService {
	
    Product addProduct(Product product);

    Product updateProduct(Product product);

    List < Product > getAllProduct();

    Product getProductById(String productCode);
        
    void deleteProduct(String productCode);

	boolean UpdateQuantity(String productId, long  changeInQuantity);

	int getProductQuantityByIdCode(String productCode);

}
