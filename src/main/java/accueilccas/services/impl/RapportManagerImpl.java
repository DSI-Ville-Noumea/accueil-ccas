package accueilccas.services.impl;

import java.util.List;

import accueilccas.bean.Rapport;
import accueilccas.dao.RapportDAO;
import accueilccas.services.RapportManager;

public class RapportManagerImpl implements RapportManager {

	private RapportDAO rapportdao;
	
	public RapportDAO getRapportdao() {
		return rapportdao;
	}

	public void setRapportdao(RapportDAO rapportdao) {
		this.rapportdao = rapportdao;
	}

	public List<Rapport> getListeRapports() {
		return rapportdao.getListeRapports();
	}

	public Rapport getRapportById(int id) {
		return rapportdao.getRapportById(id);
	}

	public void saveRapport(Rapport r) {
		rapportdao.saveRapport(r);

	}
	public void deleteRapport(Rapport r){
		rapportdao.deleteRapport(r);
	}


}
