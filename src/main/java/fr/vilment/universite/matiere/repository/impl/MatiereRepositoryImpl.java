package fr.vilment.universite.matiere.repository.impl;

import java.util.List;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import fr.vilment.universite.matiere.domain.Matiere;
import fr.vilment.universite.matiere.repository.IMatiereRepository;

@Repository
public class MatiereRepositoryImpl implements IMatiereRepository {

	RestTemplate restT = new RestTemplate();
	
	@Override
	public List<Matiere> findAll() {
		List<Matiere> lM = restT.exchange("http://localhost:8080/matieres", 
				 HttpMethod.GET, 
				 null,
				 new ParameterizedTypeReference<List<Matiere>>(){}
			    ).getBody();

		return lM;
	}

	@Override
	public List<Matiere> findAllNonEns(int idEns) {
		List<Matiere> lM = restT.exchange("http://localhost:8080/matieresEns/{idEns}", 
				 HttpMethod.GET, 
				 null,
				 new ParameterizedTypeReference<List<Matiere>>(){},
				 idEns
			    ).getBody();

		return lM;
	}

	@Override
	public List<Matiere> findAllByIdMatiere(int idMat) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Matiere getOne(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteById(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void save(Matiere mat) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Matiere> findAllByOrderByNom() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Matiere> findAllByOrderByNomDesc() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Matiere> findMatiereByNom(String nom) {
		// TODO Auto-generated method stub
		return null;
	}

}
