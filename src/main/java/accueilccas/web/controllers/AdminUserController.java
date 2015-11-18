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


import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;
import org.springframework.web.servlet.view.RedirectView;

import accueilccas.bean.User;
import accueilccas.services.UserManager;
import accueilccas.web.editors.UserProperty;


@SuppressWarnings("deprecation")
public class AdminUserController extends SimpleFormController {

	//private User User;
	private UserProperty userProperty;
	private UserManager userManager;


	protected Object formBackingObject(HttpServletRequest request)throws Exception {
		User u = new User();
		List<User> users = userManager.getUsers();
		request.setAttribute("listeUtilisateurs", users);
		if(request.getParameter("id") != null)
		{
			int id = Integer.parseInt(request.getParameter("id"));	
			u = userManager.getUserById(id);
		}
		return u;
	}

	protected ModelAndView onSubmit(HttpServletRequest request, HttpServletResponse response, Object command, BindException errors) throws Exception {
		User utili = (User)command ;
		if(request.getParameter("login")!= ""){
			if(request.getParameter("visible") ==null){
				utili.setVisible(false);
			}
			if(request.getParameter("admin") ==null){
				utili.setAdmin(false);
			}
			userManager.saveUser(utili);
		}
		return new ModelAndView(new RedirectView(getSuccessView()));
	}

	public void setUserManager(UserManager userManager) {
		this.userManager = userManager;
	}

	public UserManager getUserManager() {
		return userManager;
	}

	public UserProperty getUserProperty() {
		return userProperty;
	}

	public void setUserProperty(UserProperty userProperty) {
		this.userProperty = userProperty;
	}
}

