package com.encuentraya.professionals.repository;

import com.encuentraya.professionals.models.Professional;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProfessionalRepository extends JpaRepository<Professional, Long> {
}