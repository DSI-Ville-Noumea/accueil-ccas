package accueilccas.bean;

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
