package com.test.restservice.repository;

import com.test.restservice.model.Domain;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Set;



@Repository
public interface DomainRepository extends JpaRepository<Domain, Long> {

    @Query("SELECT d.name FROM Domain d WHERE d.name like :name")
    Set<String> existsByName(@Param("name") String name);
}
