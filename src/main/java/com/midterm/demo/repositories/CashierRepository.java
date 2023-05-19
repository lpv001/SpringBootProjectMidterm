package com.midterm.demo.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.midterm.demo.models.Cashier;

@Repository
public interface CashierRepository extends JpaRepository<Cashier, Long>{

    Optional<Cashier> findByUsername(String username);
    
}
