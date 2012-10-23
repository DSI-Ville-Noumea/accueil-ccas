package accueilccas.web.editors;

import java.beans.PropertyEditorSupport;

import accueilccas.bean.User;
import accueilccas.services.UserManager;


public class UserProperty extends PropertyEditorSupport {
	
	private UserManager userManager;
	private User util;
	
	@Override
	public User getValue() {
		return util;
	}

	@Override
	public void setAsText(String id) throws IllegalArgumentException {
		try {
			util = userManager.getUserById(Integer.parseInt(id));
		} catch (Exception e) {
			e.printStackTrace();
		}
		setValue(util);
	}

	public String getAsText() {
		if(util!=null)
			return String.valueOf(util.getId());
		else
			return "";
	}

	public UserManager getUserManager() {
		return userManager;
	}

	public void setUserManager(UserManager userManager) {
		this.userManager = userManager;
	}
	
	

}
