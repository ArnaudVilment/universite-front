function validerForm() {
	
	let formValid = document.getElementById("form");
	
	// Numéro enseignant
    let numEnseignantElement =
        document.getElementById("numero_enseignant");
    let numEnseignant = numEnseignantElement.value;

    if(numEnseignant === "") {
    	numEnseignantElement.classList.add("erreur");
    } else {
    	numEnseignantElement.classList.remove("erreur");
    }
    // Nom
    let nomEnseignantElement =
        document.getElementById("nom");
    let nomEnseignant = nomEnseignantElement.value;

    if(nomEnseignant === "") {
    	nomEnseignantElement.classList.add("erreur");
    } else {
    	nomEnseignantElement.classList.remove("erreur");
    }
    
    let lesClassErreur = document.getElementsByClassName("erreur");
    
    if(lesClassErreur.length === 0) {
    	formValid.submit();
    }
}