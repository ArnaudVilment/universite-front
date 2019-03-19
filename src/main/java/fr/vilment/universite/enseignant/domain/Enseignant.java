package fr.vilment.universite.enseignant.domain;


import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import fr.vilment.universite.matiere.domain.Matiere;

public class Enseignant implements Serializable {

	private int id;
	private int numero_enseignant;
	private String nom;
	private String prenom;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date date_naissance;
	private String sexe;
	private String grade;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date date_embauche;
	private String photo;
	
	private List<Matiere> lM;
	
	public List<Matiere> getlM() {
		return lM;
	}
	public void setlM(List<Matiere> lM) {
		this.lM = lM;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getNumero_enseignant() {
		return numero_enseignant;
	}
	public void setNumero_enseignant(int numero_enseignant) {
		this.numero_enseignant = numero_enseignant;
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
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public Date getDate_embauche() {
		return date_embauche;
	}
	public void setDate_embauche(Date date_embauche) {
		this.date_embauche = date_embauche;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
}
