package fr.vilment.universite.matiere.domain;

import java.io.Serializable;

import fr.vilment.universite.enseignant.domain.Enseignant;

public class Matiere implements Serializable {

	private int id;
	private int numero_matiere;
	private String nom;
	private int coef;

	private Enseignant enseignant;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getNumero_matiere() {
		return numero_matiere;
	}
	public void setNumero_matiere(int numero_matiere) {
		this.numero_matiere = numero_matiere;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public int getCoef() {
		return coef;
	}
	public void setCoef(int coef) {
		this.coef = coef;
	}
	public Enseignant getEnseignant() {
		return enseignant;
	}
	public void setEnseignant(Enseignant enseignant) {
		this.enseignant = enseignant;
	}
}
