package accueilccas.web.decorators;



import org.displaytag.decorator.TableDecorator;

import accueilccas.bean.Rapport;

public class RapportsTableDecorator extends TableDecorator {

	public String getUrl()
	{
		Rapport monObjet = (Rapport)this.getCurrentRowObject();
	
		String url=monObjet.getUrl();
		String img = "<img src='img/rapport.png'/>";
		StringBuffer temp = new StringBuffer();
		
		
		temp.append("<a href='").append(url).append("' target='_blank'/>").append(img).append("</a>");
		
		return temp.toString();
	}
	
	public String getId(){
		return null;
	}
	
	
}
