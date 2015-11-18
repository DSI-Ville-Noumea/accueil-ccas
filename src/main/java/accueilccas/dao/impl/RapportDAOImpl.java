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
