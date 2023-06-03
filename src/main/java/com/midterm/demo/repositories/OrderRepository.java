package com.midterm.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.midterm.demo.models.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {
    
    @Query(nativeQuery = true, value = "SELECT * FROM orders ORDER BY id DESC LIMIT 1")
    public Order getLastestOrder();

}
