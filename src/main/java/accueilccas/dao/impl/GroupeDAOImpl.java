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

import accueilccas.bean.Groupe;
import accueilccas.dao.GroupeDAO;

public class GroupeDAOImpl extends HibernateDaoSupport implements GroupeDAO {

	public Groupe getGroupe(int id) {
		//return (Groupe) getHibernateTemplate().load(Groupe.class, id);
		return (Groupe) getHibernateTemplate().get(Groupe.class, id);
		
	}

	@SuppressWarnings("unchecked")
	public List<Groupe> getGroups() {
		DetachedCriteria crit = DetachedCriteria.forClass(Groupe.class);
        crit.addOrder(Order.asc("position"));
        return getHibernateTemplate().findByCriteria(crit);
	}

	public void saveGroupe(Groupe g) {
		getHibernateTemplate().save(g);
	}

	public void reOrderGroupe(int[] orderInt) {
		logger.debug("Reorganisation des groupes" ); 
		int p=1;
		for(int i=0;i<orderInt.length;i++)
		{
			Groupe t = getGroupe(orderInt[i]);
			t.setPosition(p++);
			saveGroupe(t);
		}
		
	}

}
