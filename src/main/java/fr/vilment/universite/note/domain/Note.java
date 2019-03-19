package fr.vilment.universite.note.domain;

import java.io.Serializable;

import fr.vilment.universite.etudiant.domain.Etudiant;
import fr.vilment.universite.matiere.domain.Matiere;

public class Note implements Serializable {

    private NotePK notePK;
	private Double note;
	private Etudiant etudiant;
	private Matiere matiere;
	
	public NotePK getNotePK() {
		return notePK;
	}
	public void setNotePK(NotePK notePK) {
		this.notePK = notePK;
	}
	public Double getNote() {
		return note;
	}
	public void setNote(Double note) {
		this.note = note;
	}
	public Etudiant getEtudiant() {
		return etudiant;
	}
	public void setEtudiant(Etudiant etudiant) {
		this.etudiant = etudiant;
	}
	public Matiere getMatiere() {
		return matiere;
	}
	public void setMatiere(Matiere matiere) {
		this.matiere = matiere;
	}
}
