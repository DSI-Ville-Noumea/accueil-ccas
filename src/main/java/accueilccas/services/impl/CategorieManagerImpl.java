package accueilccas.services.impl;

import java.util.List;

import accueilccas.bean.AttributCategorie;
import accueilccas.bean.Categorie;
import accueilccas.bean.Groupe;
import accueilccas.dao.CategorieDAO;
import accueilccas.dao.GroupeDAO;
import accueilccas.services.CategorieManager;

public class CategorieManagerImpl implements CategorieManager {

		
	public AttributCategorie getAttributById(int id) {
		return categoriedao.getAttributById(id);
	}
	
	private GroupeDAO groupedao;
		
	public GroupeDAO getGroupedao() {
		return groupedao;
	}

	public void setGroupedao(GroupeDAO groupedao) {
		this.groupedao = groupedao;
	}
	private CategorieDAO categoriedao ;
		
	public Categorie getCategorieById(int id) {
		return categoriedao.getCategorie(id);
	}

	public List<Categorie> getCategories() {
		return categoriedao.getListCategorie();
	}

	public Categorie ajouterCategorie(int idGroupe, String libCat){
		
		Categorie newCategorie  = new Categorie();
		Groupe groupe = new Groupe();
		
		groupe= groupedao.getGroupe(idGroupe);
		newCategorie.setGroupe(groupe);
		newCategorie.setLibelleCategorie(libCat);
		newCategorie.setEnabled(true);
		newCategorie.setPositionCategorie(groupedao.getGroupe(idGroupe).getCategories().size());
		categoriedao.saveCategorie(newCategorie);
		return newCategorie;
	}
		
	public void saveCategorie(Categorie c) {
			categoriedao.saveCategorie(c);
	}

	public CategorieDAO getCategoriedao() {
		return categoriedao;
	}

	public void setCategoriedao(CategorieDAO categoriedao) {
		this.categoriedao = categoriedao;
	}

	public void reOrderCategorie(String newOrder) {
		String order[] = newOrder.split("-");
		
		int[] orderInt= new int[order.length];
		
		for(int i=0;i<order.length;i++)
			orderInt[i]=Integer.parseInt(order[i]);
		
		 categoriedao.reOrderCategorie(orderInt);
	}

	public Categorie modifierCategorie(int elementId, String libelleCat) {
		
		Categorie modCat= new Categorie();
		modCat = categoriedao.getCategorie(elementId);
		modCat.setLibelleCategorie(libelleCat);
		categoriedao.saveCategorie(modCat);
		return modCat;
	}

	
	public void enableCategorie(int elementId, boolean b) {
		
		Categorie modCat = categoriedao.getCategorie(elementId);
		modCat.setEnabled(b);
		categoriedao.saveCategorie(modCat);
		
	}

}
