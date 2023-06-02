package com.midterm.demo.models;
import jakarta.persistence.*;
import jakarta.persistence.Id;
import com.fasterxml.jackson.annotation.JsonFormat;


@Entity
@Table(name="orders")

public class Order {
    
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
        name = "drink_id",
        columnDefinition = "TEXT",
        nullable = false
    )
    private Integer drink_id;

    @Column(
        name = "size",
        columnDefinition = "TEXT",
        nullable = false
    )
    private String size;

    @Column(
        name = "sugar",
        columnDefinition = "TEXT",
        nullable = false
    )
    private String sugar;

    @Column(
        name = "zone",
        columnDefinition = "TEXT",
        nullable = false
    )
    private String zone;

    @Column(
        name = "quantity",
        columnDefinition = "TEXT",
        nullable = false
    )
    private String quantity;

    @Column(
        name = "price",
        columnDefinition = "TEXT",
        nullable = false
    )
    private String price;

    @Column(
        name = "name",
        columnDefinition = "TEXT",
        nullable = false
    )
    private String name;

    @Column(
        name = "cream",
        columnDefinition = "BOOLEAN",
        nullable = false
    )
    private Boolean cream;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getDrink_id() {
        return drink_id;
    }

    public void setDrink_id(Integer drink_id) {
        this.drink_id = drink_id;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getSugar() {
        return sugar;
    }

    public void setSugar(String sugar) {
        this.sugar = sugar;
    }

    public String getZone() {
        return zone;
    }

    public void setZone(String zone) {
        this.zone = zone;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getCream() {
        return cream;
    }

    public void setCream(Boolean cream) {
        this.cream = cream;
    }

}

