package accueilccas.services;

import java.util.Date;
import java.util.List;

import accueilccas.bean.Accueil;

public interface AccueilManager {
	public void saveAccueil(Accueil accueil);
	public Accueil getAccueil(int id);
	public List<Accueil> getDossiersDuJour(Date jour);
	public int[] nbDossierSaisisByHours(Date jour,int idTypeReception);
}
