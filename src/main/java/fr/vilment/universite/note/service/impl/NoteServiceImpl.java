package fr.vilment.universite.note.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.vilment.universite.note.domain.Note;
import fr.vilment.universite.note.domain.NotePK;
import fr.vilment.universite.note.repository.INoteRepository;
import fr.vilment.universite.note.service.INoteService;

@Service
public class NoteServiceImpl implements INoteService {

	@Autowired
	private INoteRepository nR;
	
	@Override
	public List<Note> selectAll() {
		// TODO Auto-generated method stub
		return nR.findAll();
	}

	@Override
	public Note findOn(int id_etudiant, int id_matiere) {
		// TODO Auto-generated method stub
		NotePK npk = new NotePK();
		npk.setId_etudiant(id_etudiant);
		npk.setId_matiere(id_matiere);
		
		Note note = nR.getOne(npk);
		return note;
	}

	@Override
	public void deleteOne(Note note) {
		// TODO Auto-generated method stub
		nR.delete(note);
	}

	@Override
	public Note newNote(Note note) {
		// TODO Auto-generated method stub
		nR.save(note);
		return note;
	}

	@Override
	public void editNote(Note not) {
		// TODO Auto-generated method stub
		nR.save(not);
	}

	@Override
	public List<Note> findAllByOrderByNote() {
		// TODO Auto-generated method stub
		return nR.findAllByOrderByNote();
	}

	@Override
	public List<Note> findAllByOrderByNoteDesc() {
		// TODO Auto-generated method stub
		return nR.findAllByOrderByNoteDesc();
	}
}
