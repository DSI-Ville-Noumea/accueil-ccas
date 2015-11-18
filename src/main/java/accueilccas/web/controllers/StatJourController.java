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

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import accueilccas.bean.User;
import accueilccas.bean.stat.AccueilDataSetProducer;
import accueilccas.services.AccueilManager;
import accueilccas.services.UserManager;

public class StatJourController implements Controller {

	private AccueilManager accueilManager;
	private AccueilDataSetProducer datasetTel;
	private AccueilDataSetProducer datasetPhysique;
	private UserManager userManager;
	
	
	public UserManager getUserManager() {
		return userManager;
	}

	public void setUserManager(UserManager userManager) {
		this.userManager = userManager;
	}

	public AccueilManager getAccueilManager() {
		return accueilManager;
	}

	public void setAccueilManager(AccueilManager accueilManager) {
		this.accueilManager = accueilManager;
	}

	public ModelAndView handleRequest(HttpServletRequest req,HttpServletResponse res) throws Exception {
		//recupere automatiquement les dossiers saisis du jour
		
		//permet de récuperer la css de l'utilisateur
		req.getSession().setAttribute("loggedUser", userManager.getUserById(((User)req.getSession().getAttribute("loggedUser")).getId()));
		req.setAttribute("nbDossiersTotal", accueilManager.getDossiersDuJour(new Date()).size());
		req.setAttribute("nbAccueilPhysiquesDS", datasetPhysique);
		req.setAttribute("nbAccueilTelephoniqueDS", datasetTel);
		
		return new ModelAndView("statjour");
	}


	public AccueilDataSetProducer getDatasetTel() {
		return datasetTel;
	}


	public void setDatasetTel(AccueilDataSetProducer datasetTel) {
		this.datasetTel = datasetTel;
	}


	public AccueilDataSetProducer getDatasetPhysique() {
		return datasetPhysique;
	}


	public void setDatasetPhysique(AccueilDataSetProducer datasetPhysique) {
		this.datasetPhysique = datasetPhysique;
	}

}
