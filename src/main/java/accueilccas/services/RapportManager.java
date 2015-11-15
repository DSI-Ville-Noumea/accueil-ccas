package accueilccas.services;

import java.util.List;

import accueilccas.bean.Rapport;

public interface RapportManager {

	public Rapport getRapportById(int id);

	public void saveRapport(Rapport r);

	public List<Rapport> getListeRapports();
	
	public void deleteRapport(Rapport r);


}