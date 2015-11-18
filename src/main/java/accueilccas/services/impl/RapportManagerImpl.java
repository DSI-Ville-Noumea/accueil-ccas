package accueilccas.services.impl;

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

import accueilccas.bean.Rapport;
import accueilccas.dao.RapportDAO;
import accueilccas.services.RapportManager;

public class RapportManagerImpl implements RapportManager {

	private RapportDAO rapportdao;
	
	public RapportDAO getRapportdao() {
		return rapportdao;
	}

	public void setRapportdao(RapportDAO rapportdao) {
		this.rapportdao = rapportdao;
	}

	public List<Rapport> getListeRapports() {
		return rapportdao.getListeRapports();
	}

	public Rapport getRapportById(int id) {
		return rapportdao.getRapportById(id);
	}

	public void saveRapport(Rapport r) {
		rapportdao.saveRapport(r);

	}
	public void deleteRapport(Rapport r){
		rapportdao.deleteRapport(r);
	}


}
