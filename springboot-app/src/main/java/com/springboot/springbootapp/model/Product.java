package com.springboot.springbootapp.model;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name = "products")
public class Product {
	
	public Product () {}

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "price")
    private BigDecimal price;


    @Column(name = "quantity")
	private int quantity;

    @Column(name = "ineventoryCode")
	private String ineventoryCode;


    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public BigDecimal getPrice() {
        return price;
    }
    public void setPrice(BigDecimal price) {
        this.price = price;
    }
    
	public int getQuantity() {
		// TODO Auto-generated method stub
		return quantity;
	}
	
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getInventoryCode() {
		// TODO Auto-generated method stub
		return ineventoryCode;
	}
	public void setInventoryCode(String invCode) {
		this.ineventoryCode = invCode;
	}
	@CreationTimestamp
    private Date createdAt;

    @CreationTimestamp
    private Date updatedAt;

	
	


	
}
	

