package accueilccas.dao;

import java.util.List;

import accueilccas.bean.Groupe;

public interface GroupeDAO {
	public Groupe getGroupe(int id);
	public void saveGroupe(Groupe g);
	public List<Groupe> getGroups();
	public void reOrderGroupe(int[] orderInt);
}
