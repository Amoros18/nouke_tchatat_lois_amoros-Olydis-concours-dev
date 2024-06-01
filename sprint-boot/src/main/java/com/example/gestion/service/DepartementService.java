package com.example.gestion.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.gestion.models.Departement;
import com.example.gestion.repositories.DepartementRepository;

@Service
public class DepartementService {
	
    private DepartementRepository departementRepository;

    public List<Departement> getAllDepartements() {
        return departementRepository.findAll();
    }

    public Departement getDepartementById(Long id) {
        Optional<Departement> optionalDepartement = departementRepository.findById(id);
        return optionalDepartement.orElse(null);
    }

    public Departement createDepartement(Departement departement) {
        return departementRepository.save(departement);
    }

    public Departement updateDepartement(Long id, Departement departement) {
        Optional<Departement> optionalDepartement = departementRepository.findById(id);
        if (optionalDepartement.isPresent()) {
            Departement existingDepartement = optionalDepartement.get();
            existingDepartement.setNom(departement.getNom());
            return departementRepository.save(existingDepartement);
        }
        return null;
    }

    public void deleteDepartement(Long id) {
        departementRepository.deleteById(id);
    }

	public DepartementService() {
		// TODO Auto-generated constructor stub
	}

}
