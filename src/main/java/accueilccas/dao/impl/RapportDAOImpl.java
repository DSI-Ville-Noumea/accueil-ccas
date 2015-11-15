package accueilccas.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import accueilccas.bean.Rapport;
import accueilccas.dao.RapportDAO;

public class RapportDAOImpl extends HibernateDaoSupport implements RapportDAO {

	/* (non-Javadoc)
	 * @see accueilccas.dao.impl.RapportDAO#getRapportById(int)
	 */
	public Rapport getRapportById(long id){		
		return (Rapport)getHibernateTemplate().get(Rapport.class, id);
	}
	
	/* (non-Javadoc)
	 * @see accueilccas.dao.impl.RapportDAO#saveRapport(accueilccas.bean.Rapport)
	 */
	public void saveRapport(Rapport r)
	{
		getHibernateTemplate().saveOrUpdate(r);
	}
	
	public void deleteRapport(Rapport r){
		getHibernateTemplate().delete(r);
	}
	/* (non-Javadoc)
	 * @see accueilccas.dao.impl.RapportDAO#getListeRapports()
	 */
	@SuppressWarnings("unchecked")
	public List<Rapport> getListeRapports()
	{
			logger.debug("recuperation de la liste de rapports");
			return getHibernateTemplate().loadAll(Rapport.class);
	}	
}
