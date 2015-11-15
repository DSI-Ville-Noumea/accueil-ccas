package accueilccas.dao.impl;

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
