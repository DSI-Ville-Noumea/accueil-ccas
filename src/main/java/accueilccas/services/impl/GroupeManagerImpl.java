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

import accueilccas.bean.Groupe;
import accueilccas.dao.GroupeDAO;
import accueilccas.services.GroupeManager;

public class GroupeManagerImpl implements GroupeManager{

	private GroupeDAO dao;
	
	
	public Groupe getGroupe(int id) {
		return dao.getGroupe(id);
	}

	public GroupeDAO getDao() {
		return dao;
	}

	public void setDao(GroupeDAO dao) {
		this.dao = dao;
	}

	public void saveGroupe(Groupe g) {
		dao.saveGroupe(g);
	}

	public List<Groupe> getGroups() {
		return dao.getGroups();
	}

	public Groupe modifierGroupe(int element_id, String nomGroupe) {
		Groupe modGroupe = new Groupe();
		modGroupe = dao.getGroupe(element_id);
		modGroupe.setNom(nomGroupe);
		dao.saveGroupe(modGroupe);		
		return modGroupe;
	}
	
	public Groupe creerGroupe(String nomGroupe) {
		
		Groupe newGroupe = new Groupe();
		newGroupe.setNom(nomGroupe);
		newGroupe.setPosition(getGroups().size());
		newGroupe.setEnabled(true);
		dao.saveGroupe(newGroupe);		
		return newGroupe;
	}
	
	public void reOrderGroupe(String newOrder) {
		
		String order[] = newOrder.split("-");
		
		int[] orderInt= new int[order.length];
		
		for(int i=0;i<order.length;i++)
			orderInt[i]=Integer.parseInt(order[i]);
		
		 dao.reOrderGroupe(orderInt);
		
	}

	
	public void enableGroupe(int elementId, boolean b) {
		
		Groupe newGroupe = dao.getGroupe(elementId);
		newGroupe.setEnabled(b);
		dao.saveGroupe(newGroupe);
		
	}
}
