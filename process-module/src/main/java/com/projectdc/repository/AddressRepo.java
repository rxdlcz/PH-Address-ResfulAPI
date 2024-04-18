package com.projectdc.repository;

import com.projectdc.entities.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AddressRepo extends JpaRepository<Address, Integer> {

//    @Query("SELECT u FROM Address u WHERE u.code = :code AND u.name = :name")
//    List<Address> findByParam(@Param("code") int code, @Param("name") String name);

    /**
     * Delete all data and reset the identity of table
     */
    @Modifying
    @Query(value = "TRUNCATE TABLE address RESTART IDENTITY", nativeQuery = true)
    void truncate();
}