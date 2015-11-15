package accueilccas.web.decorators;



import org.displaytag.decorator.TableDecorator;

import accueilccas.bean.User;

public class UtilisateurTableDecorator extends TableDecorator {

	public String getId()
	{
		User monObjet = (User)this.getCurrentRowObject();
		int id=monObjet.getId();
		StringBuffer modif = new StringBuffer("<a href='");
		modif.append("adminuser.do?id=").append(id).append("'/>Modifier</a>");
		return modif.toString();
	}
}
