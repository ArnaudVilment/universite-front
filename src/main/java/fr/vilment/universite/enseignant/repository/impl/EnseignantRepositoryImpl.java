package fr.vilment.universite.enseignant.repository.impl;

import java.util.List;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import fr.vilment.universite.enseignant.domain.Enseignant;
import fr.vilment.universite.enseignant.repository.IEnseignantRepository;

@Repository
public class EnseignantRepositoryImpl implements IEnseignantRepository {

	RestTemplate restT = new RestTemplate();
	
	@Override
	public List<Enseignant> findAll() {
	
		List<Enseignant> lE = restT.exchange("http://localhost:8080/listEnseignant", 
											 HttpMethod.GET, 
											 null,
											 new ParameterizedTypeReference<List<Enseignant>>(){}
										    ).getBody();
	
		
		return lE;
	}

	@Override
	public Enseignant getOne(int id) {
				
		Enseignant ens = restT.getForObject("http://localhost:8080/Enseignant/" + id, Enseignant.class);
		return ens;
	}

	@Override
	public void deleteById(int id) {
		
		restT.delete("http://localhost:8080/delEnseignant/" + id);
		
	}

	@Override
	public Enseignant save(Enseignant ens) {

		Enseignant e = restT.postForObject("http://localhost:8080/saveEnseignant", ens, Enseignant.class);
		return e;
	}

	@Override
	public Enseignant update(Enseignant ens, int id) {
		
		restT.put("http://localhost:8080/updateEnseignant", ens, Enseignant.class);
		return null;
	}
	
	@Override
	public List<Enseignant> rechercheEnseignants(String nom) {
		
		List<Enseignant> lE = restT.exchange("http://localhost:8080/enseignants/search/{nom}", 
				 HttpMethod.GET, 
				 null,
				 new ParameterizedTypeReference<List<Enseignant>>(){},
				 nom
			    ).getBody();


		return lE;
	}
	
	@Override
	public List<Enseignant> triEnseignantAsc() {
		
		List<Enseignant> lE = restT.exchange("http://localhost:8080/enseignants/triAsc", 
				 HttpMethod.GET, 
				 null,
				 new ParameterizedTypeReference<List<Enseignant>>(){}
			    ).getBody();


		return lE;
	}
	
	@Override
	public List<Enseignant> triEnseignantDesc() {
		
		List<Enseignant> lE = restT.exchange("http://localhost:8080/enseignants/triDesc", 
				 HttpMethod.GET, 
				 null,
				 new ParameterizedTypeReference<List<Enseignant>>(){}
			    ).getBody();


		return lE;
	}
}
