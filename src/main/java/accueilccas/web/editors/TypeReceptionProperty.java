package accueilccas.web.editors;

import java.beans.PropertyEditorSupport;

import accueilccas.bean.TypeReception;
import accueilccas.services.TypeReceptionManager;

public class TypeReceptionProperty extends PropertyEditorSupport {
	
	private TypeReceptionManager typeReceptionManager;
	private TypeReception util;
	
	public TypeReception getValue() {
		return util;
		
	}

	public void setAsText(String id) throws IllegalArgumentException {
		TypeReception type = null;
		try {
			type = typeReceptionManager.getTypeReceptionById(Integer.parseInt(id));
		} 
		catch (NumberFormatException e) {
			//e.printStackTrace();
		}
		setValue(type);
	}

	public String getAsText() {
		if(util!=null)
			return String.valueOf(util.getIdTypeReception());
		else
			return "";
	}
	
	
	public void setValue(Object arg0) {
		util = (TypeReception)arg0;
	}

	public TypeReceptionManager getTypeReceptionManager() {
		return typeReceptionManager;
	}

	public void setTypeReceptionManager(TypeReceptionManager typeReceptionManager) {
		this.typeReceptionManager = typeReceptionManager;
	}



}
