package com.midterm.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.midterm.demo.models.Drinksize;

@Repository
public interface DrinksizeRepository extends JpaRepository<Drinksize, Long>{

}
