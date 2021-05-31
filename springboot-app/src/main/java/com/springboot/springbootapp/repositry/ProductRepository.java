package com.springboot.springbootapp.repositry;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.springbootapp.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{

}