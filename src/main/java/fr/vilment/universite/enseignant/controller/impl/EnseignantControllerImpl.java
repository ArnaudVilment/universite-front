package fr.vilment.universite.enseignant.controller.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import fr.vilment.universite.enseignant.controller.IEnseignantController;
import fr.vilment.universite.enseignant.domain.Enseignant;
import fr.vilment.universite.enseignant.service.impl.EnseignantServiceImpl;

@Controller
public class EnseignantControllerImpl implements IEnseignantController {

	// Logger
	Logger log = LoggerFactory.getLogger(EnseignantControllerImpl.class);
	
	@Autowired
	private EnseignantServiceImpl eS;
	
	@Override
	@GetMapping(path="/listEnseignant")
	public String selectAllEnseignant(Model model) {
		
		model.addAttribute("listEnseignant", eS.selectAll());
		return "enseignant/listEnseignant";
	}
	
	@Override
	@GetMapping(value = "/infoEnseignant/{id}")
	public String getEnseignant(Model model, @PathVariable int id) {
		// TODO Auto-generated method stub
		model.addAttribute("ens", eS.selectOn(id));
		return "enseignant/infoEnseignant";
	}

	@Override
	@GetMapping(value = "/delEnseignant/{id}")
	public String delEnseignant(Model model, @PathVariable int id) {
		// TODO Auto-generated method stub
		eS.deleteOne(id);
		return "redirect:/listEnseignant";
	}
	
	@Override
	@GetMapping(value = "/newEnseignant")
	public String newEnseignant(Model model) {
		// TODO Auto-generated method stub
		Enseignant ens = new Enseignant();
		model.addAttribute("ens", ens);
		return "enseignant/newEnseignant";
	}

	@Override
	@PostMapping(value = "/saveEnseignant")
	public String newEnseignant(Model model, Enseignant ens) {
		// TODO Auto-generated method stub
		log.info("Nom enseignant : {}" , ens.getNom());
		log.info("Prenom enseignant : {}" , ens.getPrenom());
		Enseignant e = eS.newEnseignant(ens);
		//Matiere m = ens.get
		if(e == null) {
			return "redirect:/newEnseignant";
		} else {
			return "redirect:/listEnseignant";
		}
	}
	
	@Override
	@GetMapping(value = "editEnseignant/{id}")
	public String editEnseignant(Model model, @PathVariable int id) {
		// TODO Auto-generated method stub
		Enseignant ens = eS.selectOn(id);
		model.addAttribute("ens", ens);
		return "enseignant/newEnseignant";
	}
	
	@Override
	@GetMapping(value = "/triEnseignantAsc")
	public String getListEnseignantTrierAsc(Model model) {
		
		model.addAttribute("listEnseignant", eS.findAllByOrderByNom());
		return "enseignant/listEnseignant";
	}
	
	@Override
	@GetMapping(value = "/triEnseignantDesc")
	public String getListEnseignantTrierDesc(Model model) {
		
		model.addAttribute("listEnseignant", eS.findAllByOrderByNomDesc());
		return "enseignant/listEnseignant";
	}

	@Override
	@PostMapping(value = "/cherchEnseignant")
	public String findEnseignantByNom(Model model, String nom) {
		// TODO Auto-generated method stub
		List<Enseignant> lE = eS.findEnseignantByNom(nom);
		
		if(lE.size() == 1) {
			Enseignant ens = lE.get(0);
			model.addAttribute("ens", ens);
			return "enseignant/infoEnseignant";
		} else {
			model.addAttribute("listEnseignant", lE);
			return "enseignant/listEnseignant";
		}
		
	}
}
