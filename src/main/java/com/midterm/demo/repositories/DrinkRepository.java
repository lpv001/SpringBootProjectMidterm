package com.midterm.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
// import com.midterm.demo.models.Drink;
// import org.springframework.data.jpa.repository.JpaRepository;
// import org.springframework.data.jpa.repository.Query;
// import java.util.List;

import com.fasterxml.jackson.core.sym.Name;
import com.midterm.demo.models.Drink;




// public interface DrinkRepository extends JpaRepository <Drink,Long>{
//     @Query("SELECT q FROM drinks  where q.drink LIKE %?1?")
//     List<Drink> getContainingDrinks(String word);
// }

public interface DrinkRepository extends JpaRepository<Name, Long>
{

}