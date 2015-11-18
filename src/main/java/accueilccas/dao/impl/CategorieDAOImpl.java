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

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import accueilccas.bean.AttributCategorie;
import accueilccas.bean.Categorie;
import accueilccas.dao.CategorieDAO;

public class CategorieDAOImpl extends HibernateDaoSupport implements CategorieDAO {
	
	public Categorie getCategorie(int id) {
		return (Categorie) getHibernateTemplate().get(Categorie.class, id);
	}

	@SuppressWarnings("unchecked")
	public List<Categorie> getListCategorie() {
		DetachedCriteria crit = DetachedCriteria.forClass(Categorie.class);
        crit.addOrder(Order.asc("positionCategorie"));
        return getHibernateTemplate().findByCriteria(crit);
	}

	public void saveCategorie(Categorie categorie) {
		getHibernateTemplate().saveOrUpdate(categorie);
	}

	public AttributCategorie getAttributById(int id) {
		return (AttributCategorie)getHibernateTemplate().load(AttributCategorie.class, id);
	}

	public void reOrderCategorie(int[] orderInt) {
		logger.debug("Reorganisation des catégories" ); 
		int p=1;
		for(int i=0;i<orderInt.length;i++)
		{
			Categorie t = getCategorie(orderInt[i]);
			
			t.setPositionCategorie(p++);
			saveCategorie(t);
		}
		
	}

}
