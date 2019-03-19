package fr.vilment.universite.enseignant.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;

import fr.vilment.universite.enseignant.domain.Enseignant;

public interface IEnseignantController {

	public String selectAllEnseignant(Model model);
	public String getEnseignant(Model model, @PathVariable int id);
	public String delEnseignant(Model model, @PathVariable int id);
	public String newEnseignant(Model model);
	public String newEnseignant(Model model, Enseignant pz);
	public String editEnseignant(Model model, @PathVariable int id);
	public String getListEnseignantTrierAsc(Model model);
	public String getListEnseignantTrierDesc(Model model);

	
	public String findEnseignantByNom(Model model, String nom);
}
