package accueilccas.dao.impl;

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
