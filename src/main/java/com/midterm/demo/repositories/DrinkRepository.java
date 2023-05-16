package com.midterm.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.midterm.demo.models.Drink;





// public interface DrinkRepository extends JpaRepository <Drink,Long>{
//     @Query("SELECT q FROM drinks  where q.drink LIKE %?1?")
//     List<Drink> getContainingDrinks(String word);
// }

@Repository
public interface DrinkRepository extends JpaRepository<Drink, Long>
{

}