package accueilccas.web.validators;

/*
 * #%L
 * Accueil CCAS
 * %%
 * Copyright (C) 2012 - 2015 Mairie de Nouméa
 * %%
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public
 * License along with this program.  If not, see
 * <http://www.gnu.org/licenses/gpl-3.0.html>.
 * #L%
 */


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
