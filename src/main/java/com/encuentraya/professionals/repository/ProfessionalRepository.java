package com.encuentraya.professionals.repository;

import com.encuentraya.professionals.models.Professional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfessionalRepository extends JpaRepository<Professional, Long> {
}