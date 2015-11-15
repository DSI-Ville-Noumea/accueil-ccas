package accueilccas.services.impl;


import java.util.List;

import accueilccas.bean.TypeReception;
import accueilccas.dao.TypeReceptionDAO;
import accueilccas.services.TypeReceptionManager;

public class TypeReceptionManagerImpl implements TypeReceptionManager {

	private TypeReceptionDAO typereceptiondao;
	
	public List<TypeReception> getListeTypeReception() {
		return typereceptiondao.getListTypeReception();
	}

	public TypeReception getTypeReceptionById(int id) {
		return typereceptiondao.getTypeReception(id);
	}

	public void saveTypeReception(TypeReception type) {
		typereceptiondao.saveTypeReception(type);
		
	}

	public TypeReceptionDAO getTypereceptiondao() {
		return typereceptiondao;
	}

	public void setTypereceptiondao(TypeReceptionDAO typereceptiondao) {
		this.typereceptiondao = typereceptiondao;
	}

	public void reOrder(String newOrder) {
		String[] order = newOrder.split("-");
		int[] orderInt = new int[order.length];
		
		for(int i=0;i<order.length;i++)
			orderInt[i]=Integer.parseInt(order[i]);
		
		typereceptiondao.reOrderTypeReception(orderInt);
		
	}
	
	public TypeReception modifierTypeReception(int elementId, String libelleRec) {
		
		TypeReception modRec = new TypeReception();
		modRec = typereceptiondao.getTypeReception(elementId);
		modRec.setLibelleTypeReception(libelleRec);
		typereceptiondao.saveTypeReception(modRec);		
		return modRec;
	}

	
	public TypeReception creerTypeReception(String lib) {
		TypeReception newRec = new TypeReception();
		
		newRec.setLibelleTypeReception(lib);
		newRec.setPositionTypeReception(getListeTypeReception().size());
		newRec.setEnabled(true);
		typereceptiondao.saveTypeReception(newRec);		
		return newRec;
	}

	public void enableReception(int elementId, boolean b) {
			
		TypeReception	modRec = typereceptiondao.getTypeReception(elementId);
		modRec.setEnabled(b);
		typereceptiondao.saveTypeReception(modRec);
		System.out.println("ici test");
	
	}

}
