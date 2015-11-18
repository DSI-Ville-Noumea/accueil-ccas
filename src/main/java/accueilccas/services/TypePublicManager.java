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

import accueilccas.bean.TypePublic;

public interface TypePublicManager {

	
	public TypePublic getTypePublicById(int id);
	public List<TypePublic> getListeTypePublic();
	public void saveTypePublic(TypePublic type);
	public void reOrderPublic(String newOrder);
	public TypePublic modifierTypePublic(int elementId, String libelleRec);
	public TypePublic creerTypePublic(String libelleTypePublic);
	public void enablePublic(int elementId, boolean b);
}
