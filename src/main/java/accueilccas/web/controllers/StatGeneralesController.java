package accueilccas.web.controllers;

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


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import accueilccas.bean.User;
import accueilccas.services.RapportManager;
import accueilccas.services.UserManager;

public class StatGeneralesController implements Controller {

	private RapportManager rapportManager;
	private UserManager userManager;


	public ModelAndView handleRequest(HttpServletRequest req,HttpServletResponse res) throws Exception {
		req.getSession().setAttribute("loggedUser", userManager.getUserById(((User)req.getSession().getAttribute("loggedUser")).getId()));

		
		return new ModelAndView("statgen","rapports",rapportManager.getListeRapports());
	}

	public UserManager getUserManager() {
		return userManager;
	}

	public void setUserManager(UserManager userManager) {
		this.userManager = userManager;
	}

	
	
	public RapportManager getRapportManager() {
		return rapportManager;
	}

	public void setRapportManager(RapportManager rapportManager) {
		this.rapportManager = rapportManager;
	}

}
