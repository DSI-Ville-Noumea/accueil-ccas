package accueilccas.services;

import java.util.List;

import accueilccas.bean.AttributCategorie;

public interface AttributCategorieManager {
	
	public AttributCategorie getAttribut(int id);
	public void saveAttribut(AttributCategorie attribut);
	public List<AttributCategorie> getAttributsByCategorieId(int id);
	public int getPositionMaxAttributCategorie(int id);
	public AttributCategorie ajouterAttribut(int idCategorie, String libelleAttribut);
	public AttributCategorie modifierAttributCategorie(int elementId, String libelleAttributCategorie);
	public void reOrderAttributCategorie(String newOrder);
	public void enableAttribut(int elementId, boolean b);
}
