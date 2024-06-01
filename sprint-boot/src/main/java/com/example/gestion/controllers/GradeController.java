package com.example.gestion.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.gestion.models.Grade;
import com.example.gestion.repositories.GradeRepository;


@RestController
@RequestMapping("/api/grade")
public class GradeController {

	@Autowired
	GradeRepository gradeRepository;

	@GetMapping("/")
	public ResponseEntity<List<Grade>> getAllTutorials(@RequestParam(required = false) String name) {
		try {
			List<Grade> tutorials = new ArrayList<Grade>();

			if (name == null)
				gradeRepository.findAll().forEach(tutorials::add);
			else
				gradeRepository.findByGrade(name).forEach(tutorials::add);

			if (tutorials.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}

			return new ResponseEntity<>(tutorials, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/{id}")
	public ResponseEntity<Grade> getTutorialById(@PathVariable("id") long id) {
		Optional<Grade> gradeData = gradeRepository.findById(id);

		if (gradeData.isPresent()) {
			return new ResponseEntity<>(gradeData.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping("/post")
	public ResponseEntity<Grade> createTutorial(@RequestBody Grade grade) {
		try {
			Grade _grade = gradeRepository
					.save(new Grade(grade.getname(), grade.getfrom_date(),grade.getto_date(), false));
			return new ResponseEntity<>(_grade, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/get/{id}")
	public ResponseEntity<Grade> updateGrade(@PathVariable("id") long id, @RequestBody Grade grade) {
		Optional<Grade> gradeData = gradeRepository.findById(id);

		if (gradeData.isPresent()) {
			Grade _tutorial = gradeData.get();
			_tutorial.setName(grade.getname());
			_tutorial.setFromDate(grade.getfrom_date());
			_tutorial.setToDate(grade.getto_date());
			return new ResponseEntity<>(gradeRepository.save(_tutorial), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<HttpStatus> deleteTutorial(@PathVariable("id") long id) {
		try {
			gradeRepository.deleteById(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping("/delete/all")
	public ResponseEntity<HttpStatus> deleteAllTutorials() {
		try {
			gradeRepository.deleteAll();
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@GetMapping("/null")
	public ResponseEntity<List<Grade>> findByPublished() {
		try {
			List<Grade> tutorials = gradeRepository.findByGrade("");

			if (tutorials.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tutorials, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
