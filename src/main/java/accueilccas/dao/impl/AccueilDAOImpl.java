package accueilccas.dao.impl;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Expression;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import accueilccas.bean.Accueil;
import accueilccas.dao.AccueilDAO;

public class AccueilDAOImpl extends HibernateDaoSupport implements AccueilDAO {

	public void saveAccueil(Accueil accueil) {
		logger.debug("Enregistrement de l'accueil " + accueil);
		getHibernateTemplate().save(accueil);
	}

	public Accueil getAccueil(int id) {
		return (Accueil) getHibernateTemplate().load(Accueil.class, id);
	}

	@SuppressWarnings("unchecked")
	public List<Accueil> getDossiersDuJour(Date jour) {

		Calendar debut = Calendar.getInstance(Locale.FRANCE);
		Calendar fin = Calendar.getInstance(Locale.FRANCE);

		debut.setTime(jour);
		debut.set(Calendar.HOUR_OF_DAY, 0);
		debut.set(Calendar.MINUTE, 0);
		debut.set(Calendar.SECOND, 0);

		fin.setTime(jour);
		fin.set(Calendar.HOUR_OF_DAY, 23);
		fin.set(Calendar.MINUTE, 59);
		fin.set(Calendar.SECOND, 59);

		logger.debug("Recuperation des dossiers saisis entre "
				+ new SimpleDateFormat("dd/MM/yyyy HH:mm").format(debut
						.getTime())
				+ " et "
				+ new SimpleDateFormat("dd/MM/yyyy HH:mm")
						.format(fin.getTime()));

		DetachedCriteria criterias = DetachedCriteria.forClass(Accueil.class);
		criterias.add(Expression.between("dateAccueil", debut.getTime(), fin
				.getTime()));

		return getHibernateTemplate().findByCriteria(criterias);

	}

	public int[] nbDossierSaisisByHours(Date jour, int type) {
		List<Accueil> listes = getDossiersDuJour(jour);
		int[] recapeHeure = new int[24];
		int heure = 0;
		Accueil temp = null;
		SimpleDateFormat format = new SimpleDateFormat("HH");

		for (int i = 0; i < listes.size(); i++) {
			temp = listes.get(i);
			if (temp.getTypeReception().getIdTypeReception() == type) {
				heure = Integer.parseInt(format.format(temp.getDateAccueil()));
				recapeHeure[heure]++;
			}
		}
		return recapeHeure;
	}

}
