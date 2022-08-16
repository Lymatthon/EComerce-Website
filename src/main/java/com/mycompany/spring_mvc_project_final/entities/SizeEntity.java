package com.mycompany.spring_mvc_project_final.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "sizeTable")
public class SizeEntity implements Serializable{
     @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long sizeId;
    
    @Column(nullable = false, length = 20)
    private String productSize;
    
    @OneToMany(mappedBy = "size",fetch = FetchType.EAGER)
    private List<ProductDetail> pDetail;

    public long getSizeId() {
        return sizeId;
    }

    public void setSizeId(long sizeId) {
        this.sizeId = sizeId;
    }

    public String getSize() {
        return productSize;
    }

    public void setSize(String size) {
        this.productSize = size;
    }

    public List<ProductDetail> getpDetail() {
        return pDetail;
    }

    public void setpDetail(List<ProductDetail> pDetail) {
        this.pDetail = pDetail;
    }
    
    
}
