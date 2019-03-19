package fr.vilment.universite.note.domain;

import java.io.Serializable;

public class NotePK implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
    private int id_etudiant;
    private int id_matiere;

	public int getId_etudiant() {
		return id_etudiant;
	}

	public void setId_etudiant(int id_etudiant) {
		this.id_etudiant = id_etudiant;
	}

	public int getId_matiere() {
		return id_matiere;
	}

	public void setId_matiere(int id_matiere) {
		this.id_matiere = id_matiere;
	}
}
