package fr.vilment.universite.note.controller.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import fr.vilment.universite.etudiant.service.impl.EtudiantServiceImpl;
import fr.vilment.universite.matiere.service.impl.MatiereServiceImpl;
import fr.vilment.universite.note.controller.INoteController;
import fr.vilment.universite.note.domain.Note;
import fr.vilment.universite.note.domain.NotePK;
import fr.vilment.universite.note.service.impl.NoteServiceImpl;

@Controller
public class NoteControllerImpl implements INoteController {

	// Logger
	Logger log = LoggerFactory.getLogger(NoteControllerImpl.class);
	
	@Autowired
	private NoteServiceImpl nS;
	@Autowired
	private MatiereServiceImpl mS;
	@Autowired
	private EtudiantServiceImpl eS;
		
	@Override
	@GetMapping(path="/listNote")
	public String selectAllNote(Model model) {
		
		model.addAttribute("listNote", nS.selectAll());
		log.info("Taille de la liste des Notes : " + nS.selectAll().size());
		return "note/listNote";
	}
	
	@Override
	@GetMapping(value = "/infoNote/{id}")
	public String getNote(Model model, @PathVariable NotePK notePK) {
		// TODO Auto-generated method stub
		//model.addAttribute("not", nS.findtOn(notePK));
		return "noteinfoNote";
	}

	@Override
	@GetMapping(value = "/delNote/{id_etudiant}/{id_matiere}")
	public String delNote(Model model, @PathVariable int id_etudiant, @PathVariable int id_matiere) {
		// TODO Auto-generated method stub
		Note note = nS.findOn(id_etudiant, id_matiere);
		NotePK npk = new NotePK();
		npk.setId_etudiant(id_etudiant);
		npk.setId_matiere(id_matiere);
		note.setNotePK(npk);

		nS.deleteOne(note);
		return "redirect:/listNote";
	}
	
	@Override
	@GetMapping(value = "/newNote")
	public String newNote(Model model) {
		// TODO Auto-generated method stub
		Note note = new Note();
		model.addAttribute("note", note);
		model.addAttribute("listMatiere", mS.selectAll());
		model.addAttribute("listEtudiant", eS.selectAll());
		return "note/newNote";
	}

	@Override
	@PostMapping(value = "/newNote")
	public String newNote(Model model, Note note) {
		// TODO Auto-generated method stub
		NotePK npk = new NotePK();
		npk.setId_etudiant(note.getEtudiant().getId());
		npk.setId_matiere(note.getMatiere().getId());
		note.setNotePK(npk);
		nS.newNote(note);
		return "redirect:/listNote";
	}
	
	@Override
	@GetMapping(value = "/editNote/{id_etudiant}/{id_matiere}")
	public String editNote(Model model, @PathVariable int id_etudiant, @PathVariable int id_matiere) {
		// TODO Auto-generated method stub
		model.addAttribute("note", nS.findOn(id_etudiant, id_matiere));
		model.addAttribute("mat", mS.selectOn(id_matiere));
		model.addAttribute("etu", eS.selectOn(id_etudiant));
		return "note/editNote";
	}
	
	@Override
	@PostMapping(value = "/editNote")
	public String editNote(Model model, Note note, int id_etudiant, int id_matiere) {
		// TODO Auto-generated method stub
		NotePK npk = new NotePK();
		npk.setId_etudiant(id_etudiant);
		npk.setId_matiere(id_matiere);
		note.setNotePK(npk);
		nS.newNote(note);
		return "redirect:/listNote";
	}
	
	@Override
	@GetMapping(value = "/triNoteAsc")
	public String getListNoteTrierAsc(Model model) {
		
		model.addAttribute("listNote", nS.findAllByOrderByNote());
		return "note/listNote";
	}
	
	@Override
	@GetMapping(value = "/triNoteDesc")
	public String getListNoteTrierDesc(Model model) {
		
		model.addAttribute("listNote", nS.findAllByOrderByNoteDesc());
		return "note/listNote";
	}
	

}
