package com.test.restservice.repository;

import com.test.restservice.model.Tld;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface TldRepository extends JpaRepository<Tld, Long> {

}
