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

import accueilccas.bean.TypeReception;
import accueilccas.dao.TypeReceptionDAO;

public class TypeReceptionDAOImpl extends HibernateDaoSupport implements TypeReceptionDAO {

	@SuppressWarnings("unchecked")
	public List<TypeReception> getListTypeReception() {
		DetachedCriteria crit = DetachedCriteria.forClass(TypeReception.class);
        crit.addOrder(Order.asc("positionTypeReception"));
        return getHibernateTemplate().findByCriteria(crit);
		
	}

	public TypeReception getTypeReception(int id) {
		return (TypeReception) getHibernateTemplate().get(TypeReception.class, id);
	}

	public void saveTypeReception(TypeReception typeReception) {
		logger.info("Sauvegarde d'un type de reception :" + typeReception ); 
		getHibernateTemplate().saveOrUpdate(typeReception);
	}

	public void reOrderTypeReception(int[] orderInt) {
		logger.debug("Reorganisation des types de reception" ); 
		int p=1;
		for(int i=0;i<orderInt.length;i++)
		{
			TypeReception t = getTypeReception(orderInt[i]);
			t.setPositionTypeReception(p++);
			saveTypeReception(t);
		}
	}

}
