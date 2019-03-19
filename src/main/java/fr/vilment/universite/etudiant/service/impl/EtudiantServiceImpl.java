package fr.vilment.universite.etudiant.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.vilment.universite.etudiant.domain.Etudiant;
import fr.vilment.universite.etudiant.repository.IEtudiantRepository;
import fr.vilment.universite.etudiant.service.IEtudiantService;

@Service
public class EtudiantServiceImpl implements IEtudiantService {

	@Autowired
	private IEtudiantRepository eR;
	
	@Override
	public List<Etudiant> selectAll() {
		// TODO Auto-generated method stub
		List<Etudiant> lE = eR.findAll();
		checkPhoto(lE);
		return lE;
	}

	@Override
	public Etudiant selectOn(int id) {
		// TODO Auto-generated method stub
		Etudiant etu = eR.getOne(id);
		checkPhoto(etu);
		return etu;
	}

	@Override
	public void deleteOne(int id) {
		// TODO Auto-generated method stub
		eR.deleteById(id);
	}

	@Override
	public void newEtudiant(Etudiant etu) {
		// TODO Auto-generated method stub
		eR.save(etu);
	}

	@Override
	public void editEtudiant(Etudiant etu) {
		// TODO Auto-generated method stub
		eR.save(etu);
	}

	@Override
	public List<Etudiant> findAllByOrderByNom() {
		// TODO Auto-generated method stub
		List<Etudiant> lE = eR.findAllByOrderByNom();
		checkPhoto(lE);
		return lE;
	}

	@Override
	public List<Etudiant> findAllByOrderByNomDesc() {
		// TODO Auto-generated method stub
		List<Etudiant> lE = eR.findAllByOrderByNomDesc();
		checkPhoto(lE);
		return lE;
	}

	@Override
	public List<Etudiant> checkPhoto(List<Etudiant> lE) {
		// Vérifier l'image pour chaque enseignant, si il ne possède pas d'image, on lui en donne une par defaut
		for(Etudiant etu : lE) {
			if(etu.getPhoto() == null || etu.getPhoto().equals("")) {
				etu.setPhoto("/images/uti.png");
			}
		}
		return lE;
	}

	@Override
	public Etudiant checkPhoto(Etudiant etu) {
		// TODO Auto-generated method stub
		if(etu.getPhoto() == null || etu.getPhoto().equals("")) {
			etu.setPhoto("/images/uti.png");
		}
		return etu;
	}

	@Override
	public List<Etudiant> findEtudiantByNom(String nom) {
		// TODO Auto-generated method stub
		List<Etudiant> lE = eR.findEtudiantByNom(nom);
		if(lE.size() == 1) {
			Etudiant e = lE.get(0);
			checkPhoto(e);
		} else {
			checkPhoto(lE);
		}
		return lE;
	}
}
