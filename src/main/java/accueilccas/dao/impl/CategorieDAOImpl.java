package accueilccas.dao.impl;

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
