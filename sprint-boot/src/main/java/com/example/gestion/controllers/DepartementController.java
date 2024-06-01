package com.example.gestion.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.gestion.models.Departement;
import com.example.gestion.service.DepartementService;

@RestController
@RequestMapping("/api/departements")
public class DepartementController {

	private DepartementService departementService;

    @GetMapping
    public ResponseEntity<List<Departement>> getAllDepartements() {
        List<Departement> departements = departementService.getAllDepartements();
        return new ResponseEntity<>(departements, HttpStatus.OK);
    }
    
    @GetMapping("hello")
    public String hello2() {
        return "Hello Word 5";
    }

    @GetMapping("/{id}")
    public ResponseEntity<Departement> getDepartementById(@PathVariable("id") Long id) {
        Departement departement = departementService.getDepartementById(id);
        return new ResponseEntity<>(departement, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Departement> createDepartement(@RequestBody Departement departement) {
        Departement createdDepartement = departementService.createDepartement(departement);
        return new ResponseEntity<>(createdDepartement, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Departement> updateDepartement(@PathVariable("id") Long id, @RequestBody Departement departement) {
        Departement updatedDepartement = departementService.updateDepartement(id, departement);
        return new ResponseEntity<>(updatedDepartement, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteDepartement(@PathVariable("id") Long id) {
        departementService.deleteDepartement(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

	public DepartementController() {
		
	}
}