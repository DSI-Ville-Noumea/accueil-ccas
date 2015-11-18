package accueilccas.services;

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

import accueilccas.bean.AttributCategorie;
import accueilccas.bean.Categorie;

public interface CategorieManager {

	public List<Categorie> getCategories();
	public Categorie getCategorieById(int id);
	public void saveCategorie(Categorie c);
	public AttributCategorie getAttributById(int id);
	public void reOrderCategorie(String newOrder);
	public Categorie ajouterCategorie(int idGroupe, String libCat);
	public Categorie modifierCategorie(int elementId, String libelleCat);
	public void enableCategorie(int elementId, boolean b);
}