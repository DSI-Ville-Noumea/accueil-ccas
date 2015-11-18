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

import accueilccas.bean.TypePublic;
import accueilccas.dao.TypePublicDAO;

public class TypePublicDAOImpl extends HibernateDaoSupport implements TypePublicDAO {

	@SuppressWarnings("unchecked")
	public List<TypePublic> getListTypePublic() {
		
		DetachedCriteria crit = DetachedCriteria.forClass(TypePublic.class);
        crit.addOrder(Order.asc("positionTypePublic"));
        return getHibernateTemplate().findByCriteria(crit);
		
	}

	public TypePublic getTypePublic(int id) {
		return (TypePublic) getHibernateTemplate().get(TypePublic.class, id);
	}

	public void saveTypePublic(TypePublic typePublic) {
		getHibernateTemplate().saveOrUpdate(typePublic);
	}

	public void reOrderPublic(int[] orderInt) {
		int p=1;
		for(int i=0;i<orderInt.length;i++)
		{
			TypePublic t = getTypePublic(orderInt[i]);
			t.setPositionTypePublic(p++);
			saveTypePublic(t);
		}
		
	}

}
