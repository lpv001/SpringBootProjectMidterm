package com.midterm.demo.models;
import jakarta.persistence.*;
import jakarta.persistence.Id;
import com.fasterxml.jackson.annotation.JsonFormat;


@Entity
@Table(name="drinks")

public class Drink {
    private Long id;
    private String name;
    
    public Drink(String name){
        this.name = name;
    }
    public Drink(){
        
    }

    @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    @Override
    public String toString() {
        return "Drink [id=" + id + ", name=" + name + "]";
    }


//     public Long getId()
//     {
//         return id;
//     }
//     @GeneratedValue(strategy = GenerationType.IDENTITY)

//     private Long id;



// public void setId(Long id) {
//         this.id = id;
//     }

// public String getNameDrink() {
//     return nameDrink;
// }

// public void setNameDrink(String nameDrink) {
//     this.nameDrink = nameDrink;
// }
// @Column(name="nameDrink", nullable = false)
//     private String nameDrink;

// public String getName() {
//     return name;
// }
// public void setName(String name) {
//     this.name = name;
// }




    
}

