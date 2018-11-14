package com.codeorange.backendapp;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

public interface PersonRepository extends JpaRepository<PersonEntity, Long> {
    PersonEntity findByName(@Param("name") String name);
}
