package fr.vilment.universite.note.service;

import java.util.List;

import fr.vilment.universite.note.domain.Note;

public interface INoteService {

	public List<Note> selectAll();
	public Note findOn(int id_etudiant, int id_matiere);
	public void deleteOne(Note note);
	public Note newNote(Note not);
	public void editNote(Note not);
	public List<Note> findAllByOrderByNote();
	public List<Note> findAllByOrderByNoteDesc();
}
