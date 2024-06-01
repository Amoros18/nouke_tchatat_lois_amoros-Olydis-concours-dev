package com.example.gestion.models;

import javax.persistence.*;

@Entity
@Table(name = "departement_employers")
public class DepartementEmployer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "departement_id", nullable = false)
	private Departement departement;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "employer_id", nullable = false)
	private Employer employer;
	
	public DepartementEmployer() {
		
	}

}
