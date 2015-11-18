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

import accueilccas.bean.TypePublic;
import accueilccas.dao.TypePublicDAO;
import accueilccas.services.TypePublicManager;

public class TypePublicManagerImpl implements TypePublicManager {

	private TypePublicDAO typepublicdao;
	
	
	public List<TypePublic> getListeTypePublic() {
		return typepublicdao.getListTypePublic();
	}

	public TypePublic getTypePublicById(int id) {
		return typepublicdao.getTypePublic(id);
	}

	public TypePublicDAO getTypepublicdao() {
		return typepublicdao;
	}

	public void setTypepublicdao(TypePublicDAO typepublicdao) {
		this.typepublicdao = typepublicdao;
	}

	public void saveTypePublic(TypePublic type) {
		typepublicdao.saveTypePublic(type);
		
	}

	public void reOrderPublic(String newOrder) {
			
		String order[]= newOrder.split("-");
		int[] orderInt = new int[order.length];
		
		for(int i=0;i<order.length;i++){
			orderInt[i]=Integer.parseInt(order[i]);
			}
		
		typepublicdao.reOrderPublic(orderInt);
		
	}

	public TypePublic modifierTypePublic(int elementId, String libellePub) {
		TypePublic modPub = new TypePublic();
		
		modPub = typepublicdao.getTypePublic(elementId);
		modPub.setLibelleTypePublic(libellePub);
		typepublicdao.saveTypePublic(modPub);		
		return modPub;
	}

	public TypePublic creerTypePublic(String libelleTypePublic) {
		TypePublic newPub = new TypePublic();
		
		newPub.setLibelleTypePublic(libelleTypePublic);
		newPub.setPositionTypePublic(getListeTypePublic().size());
		newPub.setEnabled(true);
		typepublicdao.saveTypePublic(newPub);		
		return newPub;
	}

	public void enablePublic(int elementId, boolean b) {
		
		TypePublic modPub = typepublicdao.getTypePublic(elementId);
		modPub.setEnabled(b);
		typepublicdao.saveTypePublic(modPub);
	}

}
