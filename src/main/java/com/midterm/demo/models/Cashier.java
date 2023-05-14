package com.midterm.demo.models;


import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import com.midterm.demo.Encrypt;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity(name = "Cashier")
@Table(
    name = "cashier_table"
)
public class Cashier {

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
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date dob;

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
        nullable = false,
        columnDefinition = "TEXT"
    )
    private String image_path;

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

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
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

    public void setPassword(String password) throws Exception {
        Encrypt encrypt = new Encrypt();
        encrypt.initFromStrings("XB7Pcvfdpa3YRVcILaVgiA==", "00d2U2RXvp589tur");
        String encryptedPassword = encrypt.encrypt(password);
        this.password = encryptedPassword;
    }

    public String getImage_path() {
        return image_path;
    }

    public void setImage_path(String image_path) {
        this.image_path = image_path;
    }

    

}