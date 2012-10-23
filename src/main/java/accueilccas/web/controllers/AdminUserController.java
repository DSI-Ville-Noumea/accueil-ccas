package accueilccas.web.controllers;

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

