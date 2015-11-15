package accueilccas.web.controllers;

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
