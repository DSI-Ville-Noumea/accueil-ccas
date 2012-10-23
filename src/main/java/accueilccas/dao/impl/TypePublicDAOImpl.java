package accueilccas.dao.impl;

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
