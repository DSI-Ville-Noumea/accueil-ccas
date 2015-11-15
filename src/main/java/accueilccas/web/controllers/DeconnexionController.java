package accueilccas.web.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class DeconnexionController implements Controller {

	public ModelAndView handleRequest(HttpServletRequest req,HttpServletResponse resp) throws Exception {
		req.getSession().invalidate();
		return new ModelAndView("deco");
	}

	
}
