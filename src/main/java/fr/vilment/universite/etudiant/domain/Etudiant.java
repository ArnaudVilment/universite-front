package fr.vilment.universite.etudiant.domain;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class Etudiant implements Serializable {



	private int id;
	private int numero_etudiant;
	private String nom;
	private String prenom;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date date_naissance;
	private String sexe;
	private String photo;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getNumero_etudiant() {
		return numero_etudiant;
	}
	public void setNumero_etudiant(int numero_etudiant) {
		this.numero_etudiant = numero_etudiant;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public Date getDate_naissance() {
		return date_naissance;
	}
	public void setDate_naissance(Date date_naissance) {
		this.date_naissance = date_naissance;
	}
	public String getSexe() {
		return sexe;
	}
	public void setSexe(String sexe) {
		this.sexe = sexe;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
}
