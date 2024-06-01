package com.example.gestion.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.gestion.models.Grade;



public interface GradeRepository extends JpaRepository<Grade, Long> {
	List<Grade> findByGrade(String grade);

}
