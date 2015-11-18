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

import accueilccas.bean.TypeReception;
import accueilccas.dao.TypeReceptionDAO;
import accueilccas.services.TypeReceptionManager;

public class TypeReceptionManagerImpl implements TypeReceptionManager {

	private TypeReceptionDAO typereceptiondao;
	
	public List<TypeReception> getListeTypeReception() {
		return typereceptiondao.getListTypeReception();
	}

	public TypeReception getTypeReceptionById(int id) {
		return typereceptiondao.getTypeReception(id);
	}

	public void saveTypeReception(TypeReception type) {
		typereceptiondao.saveTypeReception(type);
		
	}

	public TypeReceptionDAO getTypereceptiondao() {
		return typereceptiondao;
	}

	public void setTypereceptiondao(TypeReceptionDAO typereceptiondao) {
		this.typereceptiondao = typereceptiondao;
	}

	public void reOrder(String newOrder) {
		String[] order = newOrder.split("-");
		int[] orderInt = new int[order.length];
		
		for(int i=0;i<order.length;i++)
			orderInt[i]=Integer.parseInt(order[i]);
		
		typereceptiondao.reOrderTypeReception(orderInt);
		
	}
	
	public TypeReception modifierTypeReception(int elementId, String libelleRec) {
		
		TypeReception modRec = new TypeReception();
		modRec = typereceptiondao.getTypeReception(elementId);
		modRec.setLibelleTypeReception(libelleRec);
		typereceptiondao.saveTypeReception(modRec);		
		return modRec;
	}

	
	public TypeReception creerTypeReception(String lib) {
		TypeReception newRec = new TypeReception();
		
		newRec.setLibelleTypeReception(lib);
		newRec.setPositionTypeReception(getListeTypeReception().size());
		newRec.setEnabled(true);
		typereceptiondao.saveTypeReception(newRec);		
		return newRec;
	}

	public void enableReception(int elementId, boolean b) {
			
		TypeReception	modRec = typereceptiondao.getTypeReception(elementId);
		modRec.setEnabled(b);
		typereceptiondao.saveTypeReception(modRec);
		System.out.println("ici test");
	
	}

}
