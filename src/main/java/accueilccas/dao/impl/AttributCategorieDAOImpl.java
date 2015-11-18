package accueilccas.dao.impl;

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

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import accueilccas.bean.AttributCategorie;
import accueilccas.dao.AttributCategorieDAO;

public class AttributCategorieDAOImpl extends HibernateDaoSupport implements AttributCategorieDAO {

	public AttributCategorie getAttribut(int id) {
		return (AttributCategorie) getHibernateTemplate().get(AttributCategorie.class, id);
	}

	public void saveAttribut(AttributCategorie attribut) {
		getHibernateTemplate().saveOrUpdate(attribut);
	}

	@SuppressWarnings("unchecked")
	public List<AttributCategorie> getAttributsByCategorieId(int id) {
		logger.debug("recuperation des attributs pour la categorie" + id);
		List<AttributCategorie> liste = (List<AttributCategorie>)getHibernateTemplate().find("from AttributCategorie where categorie.id="+id);
		logger.debug("recuperation des attributs pour la categorie " + liste);
		return liste;
	}

	@SuppressWarnings("unchecked")
	public int getPositionMaxAttributCategorie(int id) {
		List<AttributCategorie> liste = (List<AttributCategorie>)getHibernateTemplate().find("from AttributCategorie where categorie.id="+id);		
		return (int)liste.size();
	}

	public void reOrderAttributCategorie(int[] orderInt) {
		logger.debug("Reorganisation des attributs" ); 
		int p=1;
		for(int i=0;i<orderInt.length;i++)
		{
			AttributCategorie t = getAttribut(orderInt[i]);
			t.setPositionAttribut(p++);
			saveAttribut(t);
		}
		
	}

}
