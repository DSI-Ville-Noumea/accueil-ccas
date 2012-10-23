package accueilccas.web.decorators;

import accueilccas.bean.Rapport;
import org.displaytag.decorator.TableDecorator;

public class ModifRapportsTableDecorator extends TableDecorator{
	
	public String getId()
	{
		Rapport monObjet = (Rapport)this.getCurrentRowObject();
		long id=monObjet.getId();
		StringBuilder modif = new StringBuilder("<a href='");
		modif.append("adminrapport.do?id=").append(id).append("'/>Modifier</a>");
		return modif.toString();
	}
}
