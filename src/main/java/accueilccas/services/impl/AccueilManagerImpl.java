package accueilccas.services.impl;

import java.util.Date;
import java.util.List;

import accueilccas.bean.Accueil;
import accueilccas.dao.AccueilDAO;
import accueilccas.services.AccueilManager;

public class AccueilManagerImpl implements AccueilManager {

	public AccueilDAO accueildao;
	
	public Accueil getAccueil(int id) {
		return accueildao.getAccueil(id);
	}

	public void saveAccueil(Accueil accueil) {
		accueildao.saveAccueil(accueil);
		
	}

	public AccueilDAO getAccueildao() {
		return accueildao;
	}

	public void setAccueildao(AccueilDAO accueildao) {
		this.accueildao = accueildao;
	}

	public List<Accueil> getDossiersDuJour(Date jour) {
		return accueildao.getDossiersDuJour(jour);
	}

	public int[] nbDossierSaisisByHours(Date jour,int type) {
		return accueildao.nbDossierSaisisByHours(jour,type);
	}

}
