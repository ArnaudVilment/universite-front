package fr.vilment.universite.note.repository;

import java.util.List;

import fr.vilment.universite.note.domain.Note;
import fr.vilment.universite.note.domain.NotePK;

public interface INoteRepository {

	public List<Note> findAll();
	public Note getOne(NotePK npk);
	public void delete(Note note);
	public Note save(Note note);
	
	public List<Note> findAllByOrderByNote();
	public List<Note> findAllByOrderByNoteDesc();
}
