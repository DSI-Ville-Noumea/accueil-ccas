package accueilccas.web.validators;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import accueilccas.bean.Accueil;

public class AccueilValidator implements Validator {

	@SuppressWarnings("rawtypes")
	public boolean supports(Class classe) {
		return classe.equals(Accueil.class);
	}

	public void validate(Object obj, Errors errors) {
		Accueil accueil = (Accueil)obj;
		
		if(accueil.getTypeReception()==null)
			errors.rejectValue("typeReception", "error.typeReception.null",null, "Selectionner un type de reception");
	
		if(accueil.getTypePublic()==null)
			errors.rejectValue("typePublic", "error.typePublic.null",null, "Selectionner un type de public");
		
		if(accueil.getTypeReponse()==null)
			errors.rejectValue("typeReponse", "error.typeReponse.null",null, "Selectionner un type de reponse");
	}

}
