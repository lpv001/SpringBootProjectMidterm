package com.midterm.demo.models;
import java.util.Date;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.*;
import jakarta.persistence.Id;


@Entity
@Table(name="orders")
public class Order{
    
    @Id
    @SequenceGenerator(
        name = "cashier_sequence",
        sequenceName = "cashier_sequence",
        allocationSize = 1
    )
    @GeneratedValue(
        strategy = GenerationType.SEQUENCE,
        generator = "cashier_sequence"
    )

    @Column(
        name = "id",
        updatable = false
    )
    private Integer id;

    @Column(
        name = "total_price",
        columnDefinition = "TEXT",
        nullable = false
    )
    private String total_price;

    @CreationTimestamp
    @Column(nullable = false, updatable = false, columnDefinition="TIMESTAMP default CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP")
    private Date date;

    @Column(
        name = "cashier_id",
        columnDefinition = "INTEGER",
        nullable = false
    )
    private int cashier_id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTotal_price() {
        return total_price;
    }

    public void setTotal_price(String total_price) {
        this.total_price = total_price;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getCashier_id() {
        return cashier_id;
    }

    public void setCashier_id(int cashier_id) {
        this.cashier_id = cashier_id;
    }

    

}

