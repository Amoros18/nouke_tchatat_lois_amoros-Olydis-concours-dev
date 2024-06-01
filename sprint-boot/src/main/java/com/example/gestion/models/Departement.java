package com.example.gestion.models;

import javax.persistence.*;

@Entity
@Table(name = "departements")
public class Departement {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "name")
	private String name;
	

	public Departement() {
    }

    public Departement(String nom) {
        this.name = nom;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return name;
    }

    public void setNom(String nom) {
        this.name = nom;
    }


}
