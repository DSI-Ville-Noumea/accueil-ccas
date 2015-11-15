package accueilccas.services;

import java.util.List;

import accueilccas.bean.TypeReception;

public interface TypeReceptionManager {

	
	public TypeReception getTypeReceptionById(int id);
	public List<TypeReception> getListeTypeReception();
	public void saveTypeReception(TypeReception type);
	public void reOrder(String newOrder);
	public TypeReception modifierTypeReception(int elementId, String libelleRec);
	public TypeReception creerTypeReception(String lib);
	public void enableReception(int elementId, boolean b);
	
}
