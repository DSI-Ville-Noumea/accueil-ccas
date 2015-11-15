package accueilccas.services.impl;

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
