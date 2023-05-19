package com.midterm.demo.models;


import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

@Entity(name = "Tables")
@Table(
    name = "Tables_table"
)
public class Tables {

    public Tables(Boolean isActive, int status, int table_no){
        this.isActive = isActive;
        this.status = status;
        this.table_no = table_no;
    }

    public Tables(){
        
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
        name = "isActive",
        nullable = false,
        columnDefinition = "BOOL DEFAULT TRUE"
    )
    private Boolean isActive;

    @Column(
        name = "status",
        nullable = false,
        columnDefinition = "INT DEFAULT 0"
    )
    private int status;

    @Column(
        name = "table_no",
        nullable = false,
        columnDefinition = "INT"
    )
    private int table_no;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getTable_no() {
        return table_no;
    }

    public void setTable_no(int table_no) {
        this.table_no = table_no;
    }

}