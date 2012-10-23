package accueilccas.web.controllers;

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
