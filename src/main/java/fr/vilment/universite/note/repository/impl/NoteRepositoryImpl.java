package fr.vilment.universite.note.repository.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import fr.vilment.universite.note.domain.Note;
import fr.vilment.universite.note.domain.NotePK;
import fr.vilment.universite.note.repository.INoteRepository;

@Repository
public class NoteRepositoryImpl implements INoteRepository {

	@Override
	public List<Note> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Note getOne(NotePK npk) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Note note) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Note save(Note note) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Note> findAllByOrderByNote() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Note> findAllByOrderByNoteDesc() {
		// TODO Auto-generated method stub
		return null;
	}
 
}
