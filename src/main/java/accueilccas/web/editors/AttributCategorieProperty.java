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

import accueilccas.bean.AttributCategorie;
import accueilccas.services.CategorieManager;

public class AttributCategorieProperty extends PropertyEditorSupport {
	
	private CategorieManager categorieManager;
	private AttributCategorie util;
	
	@Override
	public AttributCategorie getValue() {
		return util;
	}

	@Override
	public void setAsText(String id) throws IllegalArgumentException {
		AttributCategorie type = null;
		try {
			type = categorieManager.getAttributById(Integer.parseInt(id));
		} catch (Exception e) {
		}
		setValue(type);
	}

	public String getAsText() {
		if(util!=null)
			return String.valueOf(util.getIdAttribut());
		else
			return "";
	}
	
	
	@Override
	public void setValue(Object arg0) {
		util = (AttributCategorie)arg0;
	}

	public CategorieManager getCategorieManager() {
		return categorieManager;
	}

	public void setCategorieManager(CategorieManager categorieManager) {
		this.categorieManager = categorieManager;
	}



}
