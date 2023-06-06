package com.midterm.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.midterm.demo.models.Tables;

@Repository
public interface TableRepository extends JpaRepository<Tables, Long> {
    
    @Modifying
    @Query(nativeQuery = true , value = "UPDATE tables_table SET status = (:status) WHERE id = (:id)")
    public int setStatusTableById(@Param("id") int id, @Param("status") int status);

    @Modifying
    @Query(nativeQuery = true , value = "UPDATE tables_table SET status = (:status) WHERE table_no = (:id)")
    public int setStatusTableByIdOrder(@Param("id") int id, @Param("status") int status);

}
