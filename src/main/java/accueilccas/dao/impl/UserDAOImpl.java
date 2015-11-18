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
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import accueilccas.bean.User;
import accueilccas.dao.UserDAO;

public class UserDAOImpl extends HibernateDaoSupport implements UserDAO {

	
	public User getUserById(int id) {
		return (User)getHibernateTemplate().get(User.class, id);
	}

	public User getUserByLogin(String login) {
		DetachedCriteria crit = DetachedCriteria.forClass(User.class);
        crit.add(Restrictions.eq("login", login));
		User u = (User)getHibernateTemplate().findByCriteria(crit).get(0);
		logger.debug("recuperation de l'utilisateur " + u);
		return u;
	}

	@SuppressWarnings("unchecked")
	public List<User> getUsers() {
		DetachedCriteria crit = DetachedCriteria.forClass(User.class);
        crit.addOrder(Order.asc("login"));
        return getHibernateTemplate().findByCriteria(crit);
	}

	public void saveUser(User u) {
		getHibernateTemplate().saveOrUpdate(u);

	}

}
