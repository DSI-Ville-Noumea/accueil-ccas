package accueilccas.services.impl;

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