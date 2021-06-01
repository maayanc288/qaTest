package com.springboot.springbootapp.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.springboot.springbootapp.exceptions.ResourceNotFoundException;
import com.springboot.springbootapp.model.Product;
import com.springboot.springbootapp.repositry.ProductRepository;



@Service
@Transactional
public class ProductServiceImpl implements ProductService {


    @Autowired
    private ProductRepository productRepository;


    @Override
    public Product addProduct(Product product) {
    	Product p =  new Product();
    	p.setDescription(product.getDescription());
    	p.setInventoryCode(product.getInventoryCode());
    	p.setName(product.getName());
    	p.setPrice(product.getPrice());
    	p.setQuantity(product.getQuantity());
        return productRepository.save(p);
    }

    @Override
    public Product updateProduct(Product product) {
         Product  productUpdate =  getProductFromDbByProductId(product.getId());

        if ( productUpdate  != null) { 
            productUpdate.setId(product.getId());
            productUpdate.setName(product.getName());
            productUpdate.setDescription(product.getDescription());
            productUpdate.setQuantity(product.getQuantity());
            productUpdate.setPrice(product.getPrice());
            productUpdate.setInventoryCode(product.getInventoryCode());
            productRepository.save(productUpdate);
            return productUpdate;
        } else {
            throw new ResourceNotFoundException("Record not found with id : " + product.getId());
        }
    }

    

    @Override
    public List < Product > getAllProduct() {
        return this.productRepository.findAll();
    }

    @Override
    public Product getProductById(String productCode) {
        Product productDb =  getProductFromDbByProductCode(productCode);
        if (productDb != null) {
            return productDb;
        } else {
            throw new ResourceNotFoundException("Record not found with id : " + productCode);
        }
    }

	

	@Override
    public void deleteProduct(String productCode) {
        Product productDb =  getProductFromDbByProductCode(productCode);
        if (productDb != null) {
            this.productRepository.delete(productDb);
        } else {
            throw new ResourceNotFoundException("Record not found with id : " + productCode);
        }

    }

	@Override
	
	public int getProductQuantityByIdCode(String productCode) {
		Product product =  getProductFromDbByProductCode(productCode);
		if (product !=  null) { 
			return product.getQuantity();
		}
		else {
			throw new ResourceNotFoundException("Record not found with id : " + productCode);
		}
	}

	

	@Override
	
	public boolean UpdateQuantity(long  productId,long  changeInQuantity) {
		boolean issucssess = false;
		Product product =  getProductFromDbByProductId(productId);
		if (product == null)throw new ResourceNotFoundException("Record not found with id : " + productId);
		if (product !=  null) {
			int quantity = product.getQuantity();
			product.setQuantity(quantity += changeInQuantity);
			issucssess = true;
		}
		return issucssess;
		
			
			
	}
	
	   private Product getProductFromDbByProductId(long productId) {
	    	 Optional<Product> ProductDb =  this.productRepository.findById(productId);
	    	 if (ProductDb == null)  return null;
	    	 return ProductDb.get();
			
	    }

	   private Product getProductFromDbByProductCode(String productCode) {
			List<Product> products =  this.productRepository.findAll();
			if (products != null) {
				for (Product p : products) {
					if (p.getInventoryCode().equals(productCode))return p;
				}
			}
			return null;
		}

}