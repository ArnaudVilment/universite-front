package fr.vilment.universite.etudiant.repository.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import fr.vilment.universite.etudiant.domain.Etudiant;
import fr.vilment.universite.etudiant.repository.IEtudiantRepository;

@Repository
public class EtudiantRepositoryImpl implements IEtudiantRepository {

	@Override
	public List<Etudiant> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Etudiant getOne(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteById(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void save(Etudiant etu) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Etudiant> findAllByOrderByNom() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Etudiant> findAllByOrderByNomDesc() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Etudiant> findEtudiantByNom(String nom) {
		// TODO Auto-generated method stub
		return null;
	}

}
