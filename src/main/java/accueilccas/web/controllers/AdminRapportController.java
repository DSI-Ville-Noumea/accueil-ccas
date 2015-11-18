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

import accueilccas.bean.Rapport;
import accueilccas.services.RapportManager;

@SuppressWarnings("deprecation")
public class AdminRapportController extends SimpleFormController{

	private RapportManager rapportManager;

	protected Object formBackingObject(HttpServletRequest request)throws Exception {
		logger.debug("FORM Admin Rapport");
		Rapport rappi = new Rapport();
		List<Rapport> rapports = rapportManager.getListeRapports();
		request.setAttribute("listeRapports", rapports);
		if(request.getParameter("id") != null){
			String temp = request.getParameter("id");
			int id = Integer.parseInt(temp);	
			rappi = rapportManager.getRapportById(id);
		}
		return rappi;
	}

	protected ModelAndView onSubmit(HttpServletRequest request, HttpServletResponse response, Object command, BindException errors) throws Exception {
		Rapport rapport = (Rapport) command ;
		if(request.getParameter("titre") != ""){
			if(request.getParameter("cre")!=null){

				rapportManager.saveRapport(rapport);
			}

			else if(request.getParameter("sup")!=null){
				System.out.println();
				rapportManager.deleteRapport(rapport);
			}
		}
		return new ModelAndView(new RedirectView(getSuccessView()));
	}

	public RapportManager getRapportManager() {
		return rapportManager;
	}

	public void setRapportManager(RapportManager rapportManager) {
		this.rapportManager = rapportManager;
	}

}
