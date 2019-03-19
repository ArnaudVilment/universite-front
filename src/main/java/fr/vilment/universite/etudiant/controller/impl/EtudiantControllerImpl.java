package fr.vilment.universite.etudiant.controller.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import fr.vilment.universite.etudiant.controller.IEtudiantController;
import fr.vilment.universite.etudiant.domain.Etudiant;
import fr.vilment.universite.etudiant.service.impl.EtudiantServiceImpl;
import fr.vilment.universite.matiere.service.impl.MatiereServiceImpl;

@Controller
public class EtudiantControllerImpl implements IEtudiantController {

	// Logger
	Logger log = LoggerFactory.getLogger(EtudiantControllerImpl.class);
		
	@Autowired
	private EtudiantServiceImpl eS;
	@Autowired
	private MatiereServiceImpl mS;
	
	@Override
	@GetMapping(path="/listEtudiant")
	public String selectAllEtudiant(Model model) {
		
		model.addAttribute("listEtudiant", eS.selectAll());
		return "etudiant/listEtudiant";
	}

	@Override
	@GetMapping(value = "/infoEtudiant/{id}")
	public String getEtudiant(Model model, @PathVariable int id) {
		// TODO Auto-generated method stub
		Etudiant etu = eS.selectOn(id);
		model.addAttribute("etu", etu);
		
		//for("etu" : )
		///model.addAttribute("mat", mS.selectAllMatiereByIdMat(etu.getListNote().get));
		return "etudiant/infoEtudiant";
	}

	@Override
	@GetMapping(value = "/delEtudiant/{id}")
	public String delEtudiant(Model model, @PathVariable int id) {
		// TODO Auto-generated method stub
		eS.deleteOne(id);
		return "redirect:/listEtudiant";
	}
	
	@Override
	@GetMapping(value = "/newEtudiant")
	public String newEtudiant(Model model) {
		// TODO Auto-generated method stub
		Etudiant etu = new Etudiant();
		model.addAttribute("etu", etu);
		return "etudiant/newEtudiant";
	}

	@Override
	@PostMapping(value = "/newEtudiant")
	public String newEtudiant(Model model, Etudiant etu) {
		// TODO Auto-generated method stub
		eS.newEtudiant(etu);
		return "redirect:/listEtudiant";
	}

	@Override
	@GetMapping(value = "/editEtudiant/{id}")
	public String editEtudiant(Model model, @PathVariable int id) {
		// TODO Auto-generated method stub
		model.addAttribute("etu", eS.selectOn(id));
		return "etudiant/newEtudiant";
	}
	
	@Override
	@GetMapping(value = "/triEtudiantAsc")
	public String getListEtudiantTrierAsc(Model model) {
		
		model.addAttribute("listEtudiant", eS.findAllByOrderByNom());
		return "etudiant/listEtudiant";
	}
	
	@Override
	@GetMapping(value = "/triEtudiantDesc")
	public String getListEtudiantTrierDesc(Model model) {
		
		model.addAttribute("listEtudiant", eS.findAllByOrderByNomDesc());
		return "etudiant/listEtudiant";
	}
	
	@Override
	@PostMapping(value = "/cherchEtudiant")
	public String findEtudiantByNom(Model model, String nom) {
		// TODO Auto-generated method stub
		List<Etudiant> lE = eS.findEtudiantByNom(nom);
		
		if(lE.size() == 1) {
			Etudiant etu = lE.get(0);
			model.addAttribute("etu", etu);
			return "etudiant/infoEtudiant";
		} else {
			model.addAttribute("listEtudiant", lE);
			return "etudiant/listEtudiant";
		}
		
	}
}
