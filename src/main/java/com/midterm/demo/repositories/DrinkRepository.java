package com.midterm.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.midterm.demo.models.Drink;





// public interface DrinkRepository extends JpaRepository <Drink,Long>{
//     @Query("SELECT q FROM drinks  where q.drink LIKE %?1?")
//     List<Drink> getContainingDrinks(String word);
// }

@Repository
public interface DrinkRepository extends JpaRepository<Drink, Long>
{
    
    @Modifying
    // @Query(nativeQuery = true , value = "UPDATE drinks SET category = 'category', code = 'code', drinkname = 'drinkname', image_path = 'path', note = 'note' WHERE id = 102")
    @Query(nativeQuery = true , value = "UPDATE drinks SET category = (:category), code = (:code), drinkname = (:drinkname), image_path = (:image_path), note = (:note) WHERE id = (:id)")
    public int setUpdateTableById(@Param("category") String category, @Param("code") String code, @Param("drinkname") String drinkname, @Param("image_path") String image_path, @Param("note") String note, @Param("id") int id);
}