package fr.vilment.universite.etudiant.service;

import java.util.List;

import fr.vilment.universite.etudiant.domain.Etudiant;

public interface IEtudiantService {

	public List<Etudiant> selectAll();
	public Etudiant selectOn(int id);
	public void deleteOne(int id);
	public void newEtudiant(Etudiant etu);
	public void editEtudiant(Etudiant etu);
	public List<Etudiant> findAllByOrderByNom();
	public List<Etudiant> findAllByOrderByNomDesc();
	
	public List<Etudiant> checkPhoto(List<Etudiant> lE);
	public Etudiant checkPhoto(Etudiant lE);
	
	public List<Etudiant> findEtudiantByNom(String nom);
}
