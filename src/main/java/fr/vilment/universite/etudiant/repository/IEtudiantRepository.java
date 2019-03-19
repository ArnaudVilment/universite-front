package fr.vilment.universite.etudiant.repository;

import java.util.List;

import fr.vilment.universite.etudiant.domain.Etudiant;

public interface IEtudiantRepository {

	public List<Etudiant> findAll();
	public Etudiant getOne(int id);
	public void deleteById(int id);
	public void save(Etudiant etu);
	
	public List<Etudiant> findAllByOrderByNom();
	public List<Etudiant> findAllByOrderByNomDesc();
	public List<Etudiant> findEtudiantByNom(String nom);
	
}
