package com.encuentraya.professionals.repository;

import com.encuentraya.professionals.models.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepository extends JpaRepository<Country, Long> {
    Country findByName(String name);

    boolean existsByName(String name);
}