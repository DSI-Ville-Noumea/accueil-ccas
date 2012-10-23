package accueilccas.bean;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

@SuppressWarnings("serial")
public class Accueil implements Serializable {

	
	
	private int idAccueil;
	private Date dateAccueil;
	private String commentaireAccueil;
	private User user;
	private TypeReception typeReception;
	private TypePublic typePublic;
	private AttributCategorie typeReponse;
		
	// Getters / Setters
	public int getIdAccueil() {
		return idAccueil;
	}

	public void setIdAccueil(int idAccueil) {
		this.idAccueil = idAccueil;
	}

	public Date getDateAccueil() {
		return dateAccueil;
	}
	
	public void setDateAccueil(Date dateAccueil) {
		this.dateAccueil = dateAccueil;
	}

	public String getCommentaireAccueil() {
		return commentaireAccueil;
	}

	public void setCommentaireAccueil(String commentaireAccueil) {
		this.commentaireAccueil = commentaireAccueil;
	}
	
	public TypeReception getTypeReception() {
		return typeReception;
	}
	
	public void setTypeReception(TypeReception typeReception) {
		this.typeReception = typeReception;
	}

	public TypePublic getTypePublic() {
		return typePublic;
	}

	public void setTypePublic(TypePublic typePublic) {
		this.typePublic = typePublic;
	}

	public AttributCategorie getTypeReponse() {
		return typeReponse;
	}

	public void setTypeReponse(AttributCategorie typeReponse) {
		this.typeReponse = typeReponse;
	}

	// Constructeur(s)
	public Accueil () {
		
	}
	
	// Méthodes
	public String toString () {
		return "objet=[Accueil]; id=["+ idAccueil +"], date=["
		+ new SimpleDateFormat("dd/MM/yyyy").format(dateAccueil) +"], commentaire=["
		+ commentaireAccueil +"], login=["
		+ user +"], public=["
		+ typePublic +"], reception=["
		+ typeReception +"], reponse=["
		+ typeReponse +"]";
	}
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
