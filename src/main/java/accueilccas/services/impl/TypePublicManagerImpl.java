package accueilccas.services.impl;

import java.util.List;

import accueilccas.bean.TypePublic;
import accueilccas.dao.TypePublicDAO;
import accueilccas.services.TypePublicManager;

public class TypePublicManagerImpl implements TypePublicManager {

	private TypePublicDAO typepublicdao;
	
	
	public List<TypePublic> getListeTypePublic() {
		return typepublicdao.getListTypePublic();
	}

	public TypePublic getTypePublicById(int id) {
		return typepublicdao.getTypePublic(id);
	}

	public TypePublicDAO getTypepublicdao() {
		return typepublicdao;
	}

	public void setTypepublicdao(TypePublicDAO typepublicdao) {
		this.typepublicdao = typepublicdao;
	}

	public void saveTypePublic(TypePublic type) {
		typepublicdao.saveTypePublic(type);
		
	}

	public void reOrderPublic(String newOrder) {
			
		String order[]= newOrder.split("-");
		int[] orderInt = new int[order.length];
		
		for(int i=0;i<order.length;i++){
			orderInt[i]=Integer.parseInt(order[i]);
			}
		
		typepublicdao.reOrderPublic(orderInt);
		
	}

	public TypePublic modifierTypePublic(int elementId, String libellePub) {
		TypePublic modPub = new TypePublic();
		
		modPub = typepublicdao.getTypePublic(elementId);
		modPub.setLibelleTypePublic(libellePub);
		typepublicdao.saveTypePublic(modPub);		
		return modPub;
	}

	public TypePublic creerTypePublic(String libelleTypePublic) {
		TypePublic newPub = new TypePublic();
		
		newPub.setLibelleTypePublic(libelleTypePublic);
		newPub.setPositionTypePublic(getListeTypePublic().size());
		newPub.setEnabled(true);
		typepublicdao.saveTypePublic(newPub);		
		return newPub;
	}

	public void enablePublic(int elementId, boolean b) {
		
		TypePublic modPub = typepublicdao.getTypePublic(elementId);
		modPub.setEnabled(b);
		typepublicdao.saveTypePublic(modPub);
	}

}
