package com.midterm.demo.models;
import jakarta.persistence.*;
import jakarta.persistence.Id;
import com.fasterxml.jackson.annotation.JsonFormat;


@Entity
@Table(name="drinks")

public class Drink {

    // public Drink(String code, String drinkname, String category, String price, String note){
    //     this.code = code;
    //     this.drinkname = drinkname;
    //     this.category = category;
    //     this.price = price;
    //     this.note = note;
    // }
    
    // public Drink(){
        
    // }

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
        name = "code",
        nullable = false,
        columnDefinition = "TEXT"
    )
    private String code;

    @Column(
        name = "drinkname",
        nullable = false,
        columnDefinition = "TEXT"
    )
    private String drinkname;

    @Column(
        name = "category",
        nullable = false,
        columnDefinition = "TEXT"
    )
    private String category;

    @Column(
        name = "price",
        nullable = false,
        columnDefinition = "TEXT"
    )
    private String price;

    @Column(
        name = "note",
        nullable = false,
        columnDefinition = "TEXT"
    )
    private String note;

    @Column(
        name = "image_path",
        nullable = false
    )
    private String image_path;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDrinkname() {
        return drinkname;
    }

    public void setDrinkname(String drinkname) {
        this.drinkname = drinkname;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }


}

