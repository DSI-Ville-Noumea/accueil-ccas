package accueilccas.web.editors;

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


import java.beans.PropertyEditorSupport;

import accueilccas.bean.TypeReception;
import accueilccas.services.TypeReceptionManager;

public class TypeReceptionProperty extends PropertyEditorSupport {
	
	private TypeReceptionManager typeReceptionManager;
	private TypeReception util;
	
	public TypeReception getValue() {
		return util;
		
	}

	public void setAsText(String id) throws IllegalArgumentException {
		TypeReception type = null;
		try {
			type = typeReceptionManager.getTypeReceptionById(Integer.parseInt(id));
		} 
		catch (NumberFormatException e) {
			//e.printStackTrace();
		}
		setValue(type);
	}

	public String getAsText() {
		if(util!=null)
			return String.valueOf(util.getIdTypeReception());
		else
			return "";
	}
	
	
	public void setValue(Object arg0) {
		util = (TypeReception)arg0;
	}

	public TypeReceptionManager getTypeReceptionManager() {
		return typeReceptionManager;
	}

	public void setTypeReceptionManager(TypeReceptionManager typeReceptionManager) {
		this.typeReceptionManager = typeReceptionManager;
	}



}
