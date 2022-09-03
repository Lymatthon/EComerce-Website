package com.mycompany.spring_mvc_project_final.entities;

import com.mycompany.spring_mvc_project_final.enums.OrderStatus;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "orderentity")
public class OrderEntity extends Customer implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long orderId;

    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "MM/dd/yyyy")
    private Date dateCreate;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private OrderStatus status;

    @Column(nullable = true, length = 50)
    private String code;

    @Column(nullable = true)
    private Integer discount;
    
    @Column(nullable = false)
    private double amount;
    
    

    @OneToMany(mappedBy = "order", fetch = FetchType.LAZY)
    private List<OrderDetail> orderDetails;

    @OneToMany(mappedBy = "order", fetch = FetchType.LAZY)
    private List<Payment> payments;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(name = "order_promotion",
            joinColumns = @JoinColumn(name = "order_id",
                    referencedColumnName = "orderId"),
            inverseJoinColumns = @JoinColumn(
                    name = "promotion_id",
                    referencedColumnName = "promotionId"))
    private List<Promotion> promotions;

    @ManyToOne
    @JoinColumn(name = "accountId")
    Account account;
    
    public long getOrderId() {
        return orderId;
    }

    public void setOrderId(long orderId) {
        this.orderId = orderId;
    }

    public Date getDateCreate() {
        return dateCreate;
    }

    public void setDateCreate(Date dateCreate) {
        this.dateCreate = dateCreate;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Integer getDiscount() {
        return discount;
    }

    public void setDiscount(Integer discount) {
        this.discount = discount;
    }

    public List<OrderDetail> getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(List<OrderDetail> orderDetails) {
        this.orderDetails = orderDetails;
    }

    public List<Payment> getPayments() {
        return payments;
    }

    public void setPayments(List<Payment> payments) {
        this.payments = payments;
    }

    public List<Promotion> getPromotions() {
        return promotions;
    }

    public void setPromotions(List<Promotion> promotions) {
        this.promotions = promotions;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
    
    
    

}
