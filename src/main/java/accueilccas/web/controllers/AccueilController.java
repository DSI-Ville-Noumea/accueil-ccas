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


import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.validation.BindException;
import org.springframework.validation.Errors;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;
import org.springframework.web.servlet.view.RedirectView;

import accueilccas.bean.Accueil;
import accueilccas.bean.AttributCategorie;
import accueilccas.bean.TypePublic;
import accueilccas.bean.TypeReception;
import accueilccas.bean.User;
import accueilccas.services.AccueilManager;
import accueilccas.services.CategorieManager;
import accueilccas.services.GroupeManager;
import accueilccas.services.TypePublicManager;
import accueilccas.services.TypeReceptionManager;
import accueilccas.services.UserManager;
import accueilccas.web.editors.AttributCategorieProperty;
import accueilccas.web.editors.TypePublicProperty;
import accueilccas.web.editors.TypeReceptionProperty;
import accueilccas.web.editors.UserProperty;

@SuppressWarnings("deprecation")
public class AccueilController extends SimpleFormController {

	private AccueilManager accueilManager;
	private CategorieManager categorieManager;
	private TypePublicManager typepublicManager;
	private TypeReceptionManager typereceptionManager;
	private GroupeManager groupeManager;
	private UserManager userManager;
	private TypePublicProperty typePublicProperty;
	private TypeReceptionProperty  typeReceptionProperty;
	private AttributCategorieProperty attributCategorieProperty;
	private UserProperty userProperty;
	
	protected ModelAndView onSubmit(HttpServletRequest request, HttpServletResponse response, Object command, BindException errors) throws Exception {
		Accueil formulaire = (Accueil) command;
				formulaire.setDateAccueil(new Date());
				
		request.getSession().setAttribute("selectedUser", formulaire.getUser());
		
		//pour la couleur, on recharge l'utilisateur en session.
		if(request.getRemoteUser()!=null)
		{
			int pos = request.getRemoteUser().lastIndexOf("\\");
			String username = request.getRemoteUser().substring(pos + 1, request.getRemoteUser().length());
			request.getSession().setAttribute("loggedUser", userManager.getUserByLogin(username));
		}
				
		//on sauvegarde la fiche
		accueilManager.saveAccueil(formulaire);
		
		//on renvoi la vue
		return new ModelAndView(new RedirectView(getSuccessView()));
	}

	protected Object formBackingObject(HttpServletRequest request) throws Exception {
		
			Accueil accueil = new Accueil();
			User temp=null;
			String username=""; 
			
			if(request.getSession().getAttribute("selectedUser")!=null)
			{
				temp=(User)request.getSession().getAttribute("selectedUser");
			}
			else if(request.getRemoteUser()!=null)
			{
				int pos = request.getRemoteUser().lastIndexOf("\\");
				username = request.getRemoteUser().substring(pos + 1, request.getRemoteUser().length());
				temp  = userManager.getUserByLogin(username);
				request.getSession().setAttribute("loggedUser", temp);
				request.getSession().setAttribute("selectedUser", temp);
				logger.debug("L'utilisateur " + temp.getLogin() + " se connect avec les droit d'admin a " +temp.isAdmin());
			}
			
		accueil.setUser(temp);
		accueil.setDateAccueil(new Date());
		return accueil;
	}

	protected void initBinder(HttpServletRequest request,ServletRequestDataBinder binder) throws Exception {
		binder.registerCustomEditor(TypePublic.class, "typePublic", typePublicProperty);
		binder.registerCustomEditor(TypeReception.class, "typeReception", typeReceptionProperty);
		binder.registerCustomEditor(AttributCategorie.class, "typeReponse", attributCategorieProperty);
		binder.registerCustomEditor(User.class, "user", userProperty);
	}

	@SuppressWarnings("rawtypes")
	protected Map referenceData(HttpServletRequest request, Object command,Errors errors) throws Exception {
		Map<String,Object> model = new HashMap<String, Object>();
				model.put("groupes", groupeManager.getGroups());
				model.put("users", userManager.getUsers());
				model.put("typeReception",typereceptionManager.getListeTypeReception());
				model.put("typePublic", typepublicManager.getListeTypePublic());
		return model;
	}

	public CategorieManager getCategorieManager() {
		return categorieManager;
	}

	public void setCategorieManager(CategorieManager categorieManager) {
		this.categorieManager = categorieManager;
	}

	public TypePublicProperty getTypePublicProperty() {
		return typePublicProperty;
	}

	public void setTypePublicProperty(TypePublicProperty typePublicProperty) {
		this.typePublicProperty = typePublicProperty;
	}

	public TypeReceptionProperty getTypeReceptionProperty() {
		return typeReceptionProperty;
	}

	public void setTypeReceptionProperty(TypeReceptionProperty typeReceptionProperty) {
		this.typeReceptionProperty = typeReceptionProperty;
	}

	public AttributCategorieProperty getAttributCategorieProperty() {
		return attributCategorieProperty;
	}

	public void setAttributCategorieProperty(AttributCategorieProperty attributCategorieProperty) {
		this.attributCategorieProperty = attributCategorieProperty;
	}

	public UserProperty getUserProperty() {
		return userProperty;
	}

	public void setUserProperty(UserProperty userProperty) {
		this.userProperty = userProperty;
	}

	public UserManager getUserManager() {
		return userManager;
	}

	public void setUserManager(UserManager userManager) {
		this.userManager = userManager;
	}

	public GroupeManager getGroupeManager() {
		return groupeManager;
	}

	public void setGroupeManager(GroupeManager groupeManager) {
		this.groupeManager = groupeManager;
	}


	public TypePublicManager getTypepublicManager() {
		return typepublicManager;
	}

	public void setTypepublicManager(TypePublicManager typepublicManager) {
		this.typepublicManager = typepublicManager;
	}

	public TypeReceptionManager getTypereceptionManager() {
		return typereceptionManager;
	}

	public void setTypereceptionManager(TypeReceptionManager typereceptionManager) {
		this.typereceptionManager = typereceptionManager;
	}

	public AccueilManager getAccueilManager() {
		return accueilManager;
	}

	public void setAccueilManager(AccueilManager accueilManager) {
		this.accueilManager = accueilManager;
	}

	
}
