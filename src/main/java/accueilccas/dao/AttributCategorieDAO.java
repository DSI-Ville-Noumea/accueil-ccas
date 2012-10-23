package accueilccas.dao;

import java.util.List;

import accueilccas.bean.AttributCategorie;

public interface AttributCategorieDAO {
	public AttributCategorie getAttribut(int id);
	public void saveAttribut(AttributCategorie attribut);
	public List<AttributCategorie> getAttributsByCategorieId(int id);
	public int getPositionMaxAttributCategorie(int id);
	public void reOrderAttributCategorie(int[] orderInt);
}
