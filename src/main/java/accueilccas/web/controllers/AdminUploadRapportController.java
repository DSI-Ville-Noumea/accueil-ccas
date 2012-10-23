package accueilccas.web.controllers;

import java.io.File;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.support.ByteArrayMultipartFileEditor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;
import org.springframework.web.servlet.view.RedirectView;

import accueilccas.bean.FileUploadBean;
import accueilccas.bean.Rapport;

@SuppressWarnings("deprecation")
public class AdminUploadRapportController extends SimpleFormController{
	

	private Rapport rapport;
	private String chemin;
	private String urlServeur;
	
	
	protected Object formBackingObject(HttpServletRequest request)throws Exception {
		FileUploadBean fub = new FileUploadBean();
		return fub;
		
	}

	@SuppressWarnings("unused")
	@Override
	protected ModelAndView onSubmit(HttpServletRequest request,HttpServletResponse response, Object command, org.springframework.validation.BindException errors) throws Exception {
		FileUploadBean bean = (FileUploadBean)command;
		MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
		MultipartFile fichier = multipartRequest.getFile("file");
		
		if (fichier == null) {
			System.out.println("Fichier null");
		}
		 String nomDocument = fichier.getOriginalFilename();
		 
		 logger.debug("Chemin fichier " + chemin +"\\" + nomDocument);
		 fichier.transferTo(new File(chemin + "\\" + nomDocument));
		 request.getSession().setAttribute("nomFichier",urlServeur+ nomDocument);
		 return new ModelAndView(new RedirectView("adminrapport.do"));
	}
	
	protected void initBinder(HttpServletRequest request,ServletRequestDataBinder binder) throws Exception {
			 // pour que le flux multipart posté soit directement affecté au champ de type byte[]
			 binder.registerCustomEditor(byte[].class,new ByteArrayMultipartFileEditor());
			 }
	public String getUrlServeur() {
		return urlServeur;
	}

	public void setUrlServeur(String urlServeur) {
		this.urlServeur = urlServeur;
	}

	public String getChemin() {
		return chemin;
	}

	public void setChemin(String chemin) {
		this.chemin = chemin;
	}

	public Rapport getRapport() {
		return rapport;
	}

	public void setRapport(Rapport rapport) {
		this.rapport = rapport;
	}


	}
