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


import java.util.Date;
import java.util.List;

import accueilccas.bean.Accueil;
import accueilccas.dao.AccueilDAO;
import accueilccas.services.AccueilManager;

public class AccueilManagerImpl implements AccueilManager {

	public AccueilDAO accueildao;
	
	public Accueil getAccueil(int id) {
		return accueildao.getAccueil(id);
	}

	public void saveAccueil(Accueil accueil) {
		accueildao.saveAccueil(accueil);
		
	}

	public AccueilDAO getAccueildao() {
		return accueildao;
	}

	public void setAccueildao(AccueilDAO accueildao) {
		this.accueildao = accueildao;
	}

	public List<Accueil> getDossiersDuJour(Date jour) {
		return accueildao.getDossiersDuJour(jour);
	}

	public int[] nbDossierSaisisByHours(Date jour,int type) {
		return accueildao.nbDossierSaisisByHours(jour,type);
	}

}
