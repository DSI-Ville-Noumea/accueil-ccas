package accueilccas.services;

import java.util.List;

import accueilccas.bean.Groupe;

public interface GroupeManager {
	public void saveGroupe(Groupe g);
	public Groupe getGroupe(int id);
	public List<Groupe> getGroups();
	public Groupe modifierGroupe(int element_id, String nomGroupe);
	public void reOrderGroupe(String newOrder);
	public Groupe creerGroupe(String nomGroupe);
	public void enableGroupe(int elementId, boolean b);
}
