package com.example.gestion.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.gestion.models.Departement;


public interface DepartementRepository extends JpaRepository<Departement, Long> {
	
}
