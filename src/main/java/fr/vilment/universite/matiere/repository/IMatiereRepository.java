package fr.vilment.universite.matiere.repository;

import java.util.List;

import fr.vilment.universite.matiere.domain.Matiere;

public interface IMatiereRepository {

	public List<Matiere> findAll();
    public List<Matiere> findAllNonEns(int idEns);
    public List<Matiere> findAllByIdMatiere(int idMat);
    public Matiere getOne(int id);
    public void deleteById(int id);
    public void save(Matiere mat);
    public List<Matiere> findAllByOrderByNom();
    public List<Matiere> findAllByOrderByNomDesc();
    public List<Matiere> findMatiereByNom(String nom);
}
