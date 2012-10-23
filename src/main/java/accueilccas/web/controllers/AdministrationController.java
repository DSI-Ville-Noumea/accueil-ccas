package accueilccas.web.controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import accueilccas.bean.Categorie;
import accueilccas.bean.User;
import accueilccas.services.AttributCategorieManager;
import accueilccas.services.CategorieManager;
import accueilccas.services.GroupeManager;
import accueilccas.services.TypePublicManager;
import accueilccas.services.TypeReceptionManager;
import accueilccas.services.UserManager;

public class AdministrationController extends MultiActionController{

	private TypeReceptionManager receptionManager;
	private TypePublicManager publicManager;
	private CategorieManager categorieManager;
	private AttributCategorieManager attributCategorieManager;
	private UserManager userManager;
	private GroupeManager groupeManager;
	
	
	@SuppressWarnings("unused")
	public ModelAndView handleRequest(HttpServletRequest req,HttpServletResponse res) throws Exception {
		List<Categorie> categories = new ArrayList<Categorie>();
		Map<String,Object> modele = new HashMap<String, Object>();
		
		modele.put("receptions", receptionManager.getListeTypeReception());
		modele.put("public", publicManager.getListeTypePublic());
		modele.put("groupes", groupeManager.getGroups());
		modele.put("reponses", categorieManager.getCategories());
		
		req.getSession().setAttribute("loggedUser", userManager.getUserById(((User)req.getSession().getAttribute("loggedUser")).getId()));
		
		return new ModelAndView("admin","modele",modele);
		
	}
		
	public TypePublicManager getPublicManager() {
		return publicManager;
	}

	public void setPublicManager(TypePublicManager publicManager) {
		this.publicManager = publicManager;
	}

	public TypeReceptionManager getReceptionManager() {
		return receptionManager;
	}

	public void setReceptionManager(TypeReceptionManager receptionManager) {
		this.receptionManager = receptionManager;
	}

	public CategorieManager getCategorieManager() {
		return categorieManager;
	}

	public void setCategorieManager(CategorieManager categorieManager) {
		this.categorieManager = categorieManager;
	}
	
	public AttributCategorieManager getAttributCategorieManager() {
		return attributCategorieManager;
	}

	public void setAttributCategorieManager(AttributCategorieManager attributCategorieManager) {
		this.attributCategorieManager = attributCategorieManager;
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

}