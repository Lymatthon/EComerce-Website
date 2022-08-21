package com.mycompany.spring_mvc_project_final.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "color")
public class Color implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long colorId;
    
    @Column(nullable = false, length = 20)
    private String color;
    
    @OneToMany(mappedBy = "color",cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ProductDetail> pDetail = new ArrayList<>();

    public long getColorId() {
        return colorId;
    }

    public void setColorId(long colorId) {
        this.colorId = colorId;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public List<ProductDetail> getpDetail() {
        return pDetail;
    }

    public void setpDetail(List<ProductDetail> pDetail) {
        this.pDetail = pDetail;
    }
    
    
}
