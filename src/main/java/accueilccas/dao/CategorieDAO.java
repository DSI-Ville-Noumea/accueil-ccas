package accueilccas.dao;

import java.util.List;

import accueilccas.bean.AttributCategorie;
import accueilccas.bean.Categorie;

public interface CategorieDAO {
	public Categorie getCategorie(int id);
	public List<Categorie> getListCategorie();
	public void saveCategorie(Categorie categorie);
	public AttributCategorie getAttributById(int id);
	public void reOrderCategorie(int[] orderInt);
}
