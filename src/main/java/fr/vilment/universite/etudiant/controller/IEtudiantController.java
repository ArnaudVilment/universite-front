package fr.vilment.universite.etudiant.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;

import fr.vilment.universite.etudiant.domain.Etudiant;

public interface IEtudiantController {

	public String selectAllEtudiant(Model model);
	public String getEtudiant(Model model, @PathVariable int id);
	public String delEtudiant(Model model, @PathVariable int id);
	public String newEtudiant(Model model);
	public String newEtudiant(Model model, Etudiant pz);
	public String editEtudiant(Model model, @PathVariable int id);
	public String getListEtudiantTrierAsc(Model model);
	public String getListEtudiantTrierDesc(Model model);
	public String findEtudiantByNom(Model model, String nom);
}
