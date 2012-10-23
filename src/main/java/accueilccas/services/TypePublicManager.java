package accueilccas.services;

import java.util.List;

import accueilccas.bean.TypePublic;

public interface TypePublicManager {

	
	public TypePublic getTypePublicById(int id);
	public List<TypePublic> getListeTypePublic();
	public void saveTypePublic(TypePublic type);
	public void reOrderPublic(String newOrder);
	public TypePublic modifierTypePublic(int elementId, String libelleRec);
	public TypePublic creerTypePublic(String libelleTypePublic);
	public void enablePublic(int elementId, boolean b);
}
