package fr.vilment.universite.enseignant.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import fr.vilment.universite.enseignant.domain.Enseignant;

@Repository
public interface IEnseignantRepository {

	public List<Enseignant> findAll();
	public Enseignant getOne(int id);
	public void deleteById(int id);
	public Enseignant save(Enseignant ens);
	public Enseignant update(Enseignant ens, int id);
	
	public List<Enseignant> triEnseignantAsc();
	public List<Enseignant> triEnseignantDesc();
	public List<Enseignant> rechercheEnseignants(String nom);
	
}
