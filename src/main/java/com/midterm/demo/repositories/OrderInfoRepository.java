package com.midterm.demo.repositories;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.midterm.demo.models.OrderInfo;

@Repository
public interface OrderInfoRepository extends JpaRepository<OrderInfo, Integer> {
    
    // @Query(nativeQuery = true, value = "SELECT * FROM order_info ORDER BY order_id DESC LIMIT 1")
    // public OrderInfo getLastestOrder();

}
