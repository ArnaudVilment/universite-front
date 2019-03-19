package fr.vilment.universite.matiere.controller.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import fr.vilment.universite.enseignant.domain.Enseignant;
import fr.vilment.universite.enseignant.service.impl.EnseignantServiceImpl;
import fr.vilment.universite.matiere.controller.IMatiereController;
import fr.vilment.universite.matiere.domain.Matiere;
import fr.vilment.universite.matiere.service.impl.MatiereServiceImpl;

@Controller
public class MatiereControllerImpl implements IMatiereController {

	// Logger
	Logger log = LoggerFactory.getLogger(MatiereControllerImpl.class);
	
	@Autowired
	private MatiereServiceImpl mS;
	@Autowired
	private EnseignantServiceImpl eS;
		
	@Override
	@GetMapping(path="/listMatiere")
	public String selectAllMatiere(Model model) {
		
		model.addAttribute("listMatiere", mS.selectAll());
		log.info("Taille de la liste des Matieres : " + mS.selectAll().size());
		return "matiere/listMatiere";
	}
	
	@Override
	@GetMapping(path="/listMatiereNonEns/{idEns}")
	public String selectAllMatiereNonEns(Model model, @PathVariable int idEns) {
		
		model.addAttribute("listMatiere", mS.selectAllMatiereNonEns(idEns));
		return "matiere/listMatiere";
	}
	
	@Override
	@GetMapping(value = "/infoMatiere/{id}")
	public String getMatiere(Model model, @PathVariable int id) {
		// TODO Auto-generated method stub
		model.addAttribute("mat", mS.selectOn(id));
		return "matiere/infoMatiere";
	}

	@Override
	@GetMapping(value = "/delMatiere/{id}")
	public String delMatiere(Model model, @PathVariable int id) {
		// TODO Auto-generated method stub
		mS.deleteOne(id);
		return "redirect:/listMatiere";
	}
	
	@Override
	@GetMapping(value = "/newMatiere")
	public String newMatiere(Model model) {
		// TODO Auto-generated method stub
		Matiere mat = new Matiere();
		model.addAttribute("mat", mat);
		model.addAttribute("listEnseignant", eS.selectAll());
		return "matiere/newMatiere";
	}

	@Override
	@PostMapping(value = "/newMatiere")
	public String newMatiere(Model model, Matiere mat) {
		// TODO Auto-generated method stub
		mS.newMatiere(mat);
		return "redirect:/listMatiere";
	}

	@Override
	@GetMapping(value = "/editMatiere/{id}")
	public String editMatiere(Model model, @PathVariable int id) {
		// TODO Auto-generated method stub
		model.addAttribute("mat", mS.selectOn(id));
		model.addAttribute("listEnseignant", eS.selectAll());
		return "matiere/newMatiere";
	}
	
	// Matiere Enseignant
	@Override
	@PostMapping(value = "/editMatiereEns")
	public String editMatiereEns(Model model, int idMat, int idEns) {
		// TODO Auto-generated method stub
		log.info("idma : {}" , idMat);
		log.info("idEns : {}" , idEns);
		Matiere mat = mS.selectOn(idMat);
		
		Enseignant ens = eS.selectOn(idEns);
		mat.setEnseignant(ens);
		mS.newMatiere(mat);
		return "redirect:/editEnseignant/" + idEns;
	}
	@Override
	@GetMapping(value = "/delMatiereEns/{idMat}/{idEns}")
	public String delMatiereEns(Model model, @PathVariable int idMat, @PathVariable int idEns) {
		
		Matiere mat = mS.selectOn(idMat);

		mat.setEnseignant(null);
		mS.newMatiere(mat);
		return "redirect:/editEnseignant/" + idEns;
	}
	
	@Override
	@GetMapping(value = "/triMatiereAsc")
	public String getListMatiereTrierAsc(Model model) {
		
		model.addAttribute("listMatiere", mS.findAllByOrderByNom());
		return "matiere/listMatiere";
	}
	
	@Override
	@GetMapping(value = "/triMatiereDesc")
	public String getListMatiereTrierDesc(Model model) {
		
		model.addAttribute("listMatiere", mS.findAllByOrderByNomDesc());
		return "matiere/listMatiere";
	}
	
	@Override
	@PostMapping(value = "/cherchMatiere")
	public String findMatiereByNom(Model model, String nom) {
		// TODO Auto-generated method stub
		List<Matiere> lM = mS.findMatiereByNom(nom);
		
		if(lM.size() == 1) {
			Matiere mat = lM.get(0);
			model.addAttribute("mat", mat);
			return "matiere/infoMatiere";
		} else {
			model.addAttribute("listMatiere", lM);
			return "matiere/listMatiere";
		}
		
	}
}
