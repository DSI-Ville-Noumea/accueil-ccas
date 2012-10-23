package accueilccas.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import accueilccas.bean.AttributCategorie;
import accueilccas.dao.AttributCategorieDAO;

public class AttributCategorieDAOImpl extends HibernateDaoSupport implements AttributCategorieDAO {

	public AttributCategorie getAttribut(int id) {
		return (AttributCategorie) getHibernateTemplate().get(AttributCategorie.class, id);
	}

	public void saveAttribut(AttributCategorie attribut) {
		getHibernateTemplate().saveOrUpdate(attribut);
	}

	@SuppressWarnings("unchecked")
	public List<AttributCategorie> getAttributsByCategorieId(int id) {
		logger.debug("recuperation des attributs pour la categorie" + id);
		List<AttributCategorie> liste = (List<AttributCategorie>)getHibernateTemplate().find("from AttributCategorie where categorie.id="+id);
		logger.debug("recuperation des attributs pour la categorie " + liste);
		return liste;
	}

	@SuppressWarnings("unchecked")
	public int getPositionMaxAttributCategorie(int id) {
		List<AttributCategorie> liste = (List<AttributCategorie>)getHibernateTemplate().find("from AttributCategorie where categorie.id="+id);		
		return (int)liste.size();
	}

	public void reOrderAttributCategorie(int[] orderInt) {
		logger.debug("Reorganisation des attributs" ); 
		int p=1;
		for(int i=0;i<orderInt.length;i++)
		{
			AttributCategorie t = getAttribut(orderInt[i]);
			t.setPositionAttribut(p++);
			saveAttribut(t);
		}
		
	}

}
