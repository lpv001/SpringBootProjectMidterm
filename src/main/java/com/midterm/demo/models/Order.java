package com.midterm.demo.models;
import java.util.Date;

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
    @Column(
        name="date",
        columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP",
        nullable = false
    )
    private Date date;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

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

    

}

