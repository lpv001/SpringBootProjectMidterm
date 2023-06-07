package com.midterm.demo.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.midterm.demo.models.Cashier;

@Repository
public interface CashierRepository extends JpaRepository<Cashier, Long>{

    Optional<Cashier> findByUsername(String username);
    
    @Modifying
    // @Query(nativeQuery = true , value = "UPDATE drinks SET category = 'category', code = 'code', drinkname = 'drinkname', image_path = 'path', note = 'note' WHERE id = 102")
    @Query(nativeQuery = true , value = "UPDATE cashier_Table SET firstname = (:firstname), lastname = (:lastname), username= (:username), image_path = (:image_path), sex = (:sex), dob = (:dob), password = (:password), type = (:type) WHERE id = (:id)")
    public int setUpdateCashierById(@Param("firstname") String firstname, @Param("lastname") String lastname, @Param("username") String username, @Param("image_path") String image_path, @Param("sex") String sex, @Param("id") int id, @Param("dob") String dob, @Param("password") String password, @Param("type") String type);

}
