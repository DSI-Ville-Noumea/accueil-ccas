package accueilccas.web.editors;

import java.beans.PropertyEditorSupport;

import accueilccas.bean.TypePublic;
import accueilccas.services.TypePublicManager;

public class TypePublicProperty extends PropertyEditorSupport {
	
	private TypePublicManager typepublicManager;
	private TypePublic util;
	
	@Override
	public TypePublic getValue() {
		return util;
	}

	@Override
	public void setAsText(String id) throws IllegalArgumentException {
		TypePublic type = null;
		try {
			type = typepublicManager.getTypePublicById(Integer.parseInt(id));
		} catch (Exception e) {
		}
		setValue(type);
	}

	public String getAsText() {
		if(util!=null)
			return String.valueOf(util.getIdTypePublic());
		else
			return "";
	}
	
	
	@Override
	public void setValue(Object arg0) {
		util = (TypePublic)arg0;
	}

	public TypePublicManager getTypepublicManager() {
		return typepublicManager;
	}

	public void setTypepublicManager(TypePublicManager typepublicManager) {
		this.typepublicManager = typepublicManager;
	}



}
