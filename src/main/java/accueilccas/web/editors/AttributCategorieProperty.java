package accueilccas.web.editors;

import java.beans.PropertyEditorSupport;

import accueilccas.bean.AttributCategorie;
import accueilccas.services.CategorieManager;

public class AttributCategorieProperty extends PropertyEditorSupport {
	
	private CategorieManager categorieManager;
	private AttributCategorie util;
	
	@Override
	public AttributCategorie getValue() {
		return util;
	}

	@Override
	public void setAsText(String id) throws IllegalArgumentException {
		AttributCategorie type = null;
		try {
			type = categorieManager.getAttributById(Integer.parseInt(id));
		} catch (Exception e) {
		}
		setValue(type);
	}

	public String getAsText() {
		if(util!=null)
			return String.valueOf(util.getIdAttribut());
		else
			return "";
	}
	
	
	@Override
	public void setValue(Object arg0) {
		util = (AttributCategorie)arg0;
	}

	public CategorieManager getCategorieManager() {
		return categorieManager;
	}

	public void setCategorieManager(CategorieManager categorieManager) {
		this.categorieManager = categorieManager;
	}



}
