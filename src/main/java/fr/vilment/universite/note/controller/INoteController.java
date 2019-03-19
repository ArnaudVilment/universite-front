package fr.vilment.universite.note.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;

import fr.vilment.universite.note.domain.Note;
import fr.vilment.universite.note.domain.NotePK;

public interface INoteController {

	public String selectAllNote(Model model);
	public String getNote(Model model, @PathVariable NotePK notePK);
	public String delNote(Model model, @PathVariable int id_etudiant, @PathVariable int id_matiere);
	public String newNote(Model model);
	public String newNote(Model model, Note note);
	public String editNote(Model model, Note note, int id_etudiant, int id_matiere);
	public String editNote(Model model, @PathVariable int id_etudiant, @PathVariable int id_matiere);
	public String getListNoteTrierAsc(Model model);
	public String getListNoteTrierDesc(Model model);
}
