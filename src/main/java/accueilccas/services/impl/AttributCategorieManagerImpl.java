package accueilccas.services.impl;

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


import java.util.List;

import accueilccas.bean.AttributCategorie;
import accueilccas.bean.Categorie;
import accueilccas.dao.AttributCategorieDAO;
import accueilccas.dao.CategorieDAO;
import accueilccas.services.AttributCategorieManager;

public class AttributCategorieManagerImpl implements AttributCategorieManager {

	private AttributCategorieDAO attributCategoriedao ;
	private CategorieDAO categoriedao;
	
	
	public CategorieDAO getCategoriedao() {
		return categoriedao;
	}

	public void setCategoriedao(CategorieDAO categoriedao) {
		this.categoriedao = categoriedao;
	}

	public AttributCategorie getAttribut(int id) {
		return attributCategoriedao.getAttribut(id);
	}

	public AttributCategorie ajouterAttribut(int idCategorie, String libelleAttribut){
		AttributCategorie newAttr = new AttributCategorie();
		Categorie categ  = categoriedao.getCategorie(idCategorie);
		newAttr.setCategorie(categ);
		newAttr.setEnabled(true);
		newAttr.setLibelleAttribut(libelleAttribut);
		int position = categoriedao.getCategorie(idCategorie).getAttributs().size()+1;
			
		newAttr.setPositionAttribut(position);
		
		
		attributCategoriedao.saveAttribut(newAttr);
		return newAttr;
	}
	public void saveAttribut(AttributCategorie attribut) {
		
		attributCategoriedao.saveAttribut(attribut);
	}
	
	public AttributCategorieDAO getAttributCategoriedao() {
		return attributCategoriedao;
	}

	public void setAttributCategoriedao(AttributCategorieDAO attributCategoriedao) {
		this.attributCategoriedao = attributCategoriedao;
	}
	
	public List<AttributCategorie> getAttributsByCategorieId(int id)
	{
		return attributCategoriedao.getAttributsByCategorieId(id);
	}

	public int getPositionMaxAttributCategorie(int id) {
	
		return (int)attributCategoriedao.getPositionMaxAttributCategorie(id);
	}


	public AttributCategorie modifierAttributCategorie(int elementId,String libelleAttributCategorie) {
		
		AttributCategorie modAttrCat= new AttributCategorie();
		modAttrCat = attributCategoriedao.getAttribut(elementId);
		modAttrCat.setLibelleAttribut(libelleAttributCategorie);
		attributCategoriedao.saveAttribut(modAttrCat);
		return modAttrCat;
		
	}

	@Override
	public void reOrderAttributCategorie(String newOrder) {
		String order[] = newOrder.split("-");
		
		int[] orderInt= new int[order.length];
		
		for(int i=0;i<order.length;i++)
			orderInt[i]=Integer.parseInt(order[i]);
		
		 attributCategoriedao.reOrderAttributCategorie(orderInt);
		
	}

	@Override
	public void enableAttribut(int elementId, boolean b) {
		
		AttributCategorie enabelAttrCat= attributCategoriedao.getAttribut(elementId);
		enabelAttrCat.setEnabled(b);
		attributCategoriedao.saveAttribut(enabelAttrCat);
		
		
	}
	

}