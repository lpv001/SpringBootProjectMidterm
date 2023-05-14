package com.midterm.demo.repositories;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;

import com.midterm.demo.models.Cashier;

public class CustomCashierIMP implements CustomCashierRepository{

    @PersistenceContext
    private EntityManager entityManager;

    // @Override
    // public Cashier findByName(String username){
    //     String sql = "SELECT * from cashier_table WHERE username = '" + username + "'";
    //     final TypedQuery<Cashier> query = entityManager.createQuery(sql, Cashier.class);
    //     return query.getSingleResult();
    // }

}
