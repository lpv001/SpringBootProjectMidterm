package com.midterm.demo.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Column;

@Entity
@Table(name="drinksize")
public class Drinksize {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(
        name = "price",
        updatable = false
    )
    private Float price;

    @Column(
        name = "size",
        nullable = false,
        columnDefinition = "TEXT"
    )
    private String size;
    public String getSize() {
        return size;
    }
    public void setSize(String size) {
        this.size = size;
    }
    // private Float price;
    public Float getPrice() {
        return price;
    }
    public void setPrice(Float price) {
        this.price = price;
    }
    @Override
    public String toString() {
        return "Drinksize [size=" + size + ", price=" + price + "]";
    }
   
   
   
    
   

    
   


    
}
