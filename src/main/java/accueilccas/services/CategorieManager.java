package accueilccas.services;

import java.util.List;

import accueilccas.bean.AttributCategorie;
import accueilccas.bean.Categorie;

public interface CategorieManager {

	public List<Categorie> getCategories();
	public Categorie getCategorieById(int id);
	public void saveCategorie(Categorie c);
	public AttributCategorie getAttributById(int id);
	public void reOrderCategorie(String newOrder);
	public Categorie ajouterCategorie(int idGroupe, String libCat);
	public Categorie modifierCategorie(int elementId, String libelleCat);
	public void enableCategorie(int elementId, boolean b);
}