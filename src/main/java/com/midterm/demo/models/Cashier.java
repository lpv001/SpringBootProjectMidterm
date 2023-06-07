package com.midterm.demo.models;


import java.time.LocalDateTime;
import java.util.Date;

import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import com.fasterxml.jackson.annotation.JsonFormat;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;


@Entity(name = "Cashier")
@Table(
    name = "cashier_table",
    uniqueConstraints = {@UniqueConstraint( name = "username",  columnNames = "username")}
)
public class Cashier {

    public Cashier(String firstname, String lastname, String type, String sex, String dob, String username, String password, String image_path){
        this.firstname = firstname;
        this.lastname = lastname;
        this.type = type;
        this.dob = dob;
        this.sex = sex;
        this.username = username;
        this.password = password;
        this.image_path = image_path;
    }

    public Cashier(){
        
    }

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
        name = "firstname",
        nullable = false,
        columnDefinition = "TEXT"
    )
    private String firstname;

    @Column(
        name = "lastname",
        nullable = false,
        columnDefinition = "TEXT"
    )
    private String lastname;

    @Column(
        name = "type",
        nullable = false,
        columnDefinition = "TEXT"
    )
    private String type;

    @Column(
        name = "sex",
        nullable = false,
        columnDefinition = "TEXT"
    )
    private String sex;

    @Column(
        name = "dob",
        nullable = false,
        columnDefinition = "TEXT"
    )
    // @JsonFormat(pattern="yyyy-MM-dd")
    private String dob;

    @Column(
        name = "username",
        nullable = false,
        columnDefinition = "TEXT"
    )
    private String username;

    @Column(
        name = "password",
        nullable = false,
        columnDefinition = "TEXT"
    )
    private String password;

    @Column(
        name = "image_path",
        nullable = true,
        columnDefinition = "TEXT"
    )
    private String image_path;

    @CreationTimestamp
    @Column(nullable = false, updatable = false, columnDefinition="TIMESTAMP default CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP")
    private Date createdDate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }



    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    // public void setPassword(String password) throws Exception {
    //     Encrypt encrypt = new Encrypt();
    //     encrypt.initFromStrings("XB7Pcvfdpa3YRVcILaVgiA==", "00d2U2RXvp589tur");
    //     String encryptedPassword = encrypt.encrypt(password);
    //     this.password = encryptedPassword;
    // }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getImage_path() {
        return image_path;
    }

    public void setImage_path(String image_path) {
        this.image_path = image_path;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    

}