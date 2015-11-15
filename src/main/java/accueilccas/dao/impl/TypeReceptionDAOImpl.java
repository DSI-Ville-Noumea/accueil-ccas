package accueilccas.dao.impl;

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
