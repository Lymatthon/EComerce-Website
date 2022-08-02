package com.mycompany.spring_mvc_project_final.entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "productdetail")
public class ProductDetail implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long pDetailId;
        
    @Column(nullable = true, length = 100)
    private String description;
    
    @Column(nullable = false)
    private int quantity;
    
    @ManyToOne
    @JoinColumn(name = "productId")
    Product product;

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
    
    @ManyToOne
    @JoinColumn(name = "colorId")
    Color color;
    
    @ManyToOne
    @JoinColumn(name = "sizeId")
    SizeEntity size;

    public long getpDetailId() {
        return pDetailId;
    }

    public void setpDetailId(long pDetailId) {
        this.pDetailId = pDetailId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public SizeEntity getSize() {
        return size;
    }

    public void setSize(SizeEntity size) {
        this.size = size;
    }
    
    
    
}
