package accueilccas.web.editors;

/*
 * #%L
 * Accueil CCAS
 * %%
 * Copyright (C) 2012 - 2015 Mairie de Nouméa
 * %%
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public
 * License along with this program.  If not, see
 * <http://www.gnu.org/licenses/gpl-3.0.html>.
 * #L%
 */


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
