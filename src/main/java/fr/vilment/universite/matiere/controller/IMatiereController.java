package fr.vilment.universite.matiere.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;

import fr.vilment.universite.matiere.domain.Matiere;

public interface IMatiereController {

	public String selectAllMatiere(Model model);
	public String getMatiere(Model model, @PathVariable int id);
	public String delMatiere(Model model, @PathVariable int id);
	public String newMatiere(Model model);
	public String newMatiere(Model model, Matiere pz);
	public String editMatiere(Model model, @PathVariable int id);
	
	public String editMatiereEns(Model model, int idMat, int idEns);
	public String delMatiereEns(Model model, @PathVariable int idMat, @PathVariable int idEns);
	
	public String getListMatiereTrierAsc(Model model);
	public String getListMatiereTrierDesc(Model model);
	
	public String selectAllMatiereNonEns(Model model, @PathVariable int idEns);
	public String findMatiereByNom(Model model, String nom);
}
