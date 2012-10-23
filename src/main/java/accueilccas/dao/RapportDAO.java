package accueilccas.dao;

import java.util.List;

import accueilccas.bean.Rapport;

public interface RapportDAO {

	public Rapport getRapportById(long id);

	public void saveRapport(Rapport r);
	
	public void deleteRapport(Rapport r);

	public List<Rapport> getListeRapports();

}