package accueilccas.bean.stat;

import java.io.Serializable;
import java.util.Date;
import java.util.Map;

import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

import accueilccas.dao.AccueilDAO;
import de.laures.cewolf.DatasetProduceException;
import de.laures.cewolf.DatasetProducer;
import de.laures.cewolf.tooltips.CategoryToolTipGenerator;

@SuppressWarnings("serial")
public class AccueilDataSetProducer implements CategoryToolTipGenerator,  DatasetProducer, Serializable{

	private AccueilDAO accueilDao;
	private int type;
	private int[] res;
	
	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public String getProducerId() {
		return "nbDossiers";
	}

	public AccueilDAO getAccueilDao() {
		return accueilDao;
	}

	public void setAccueilDao(AccueilDAO accueilDao) {
		this.accueilDao = accueilDao;
	}

	@SuppressWarnings("rawtypes")
	public boolean hasExpired(Map arg0, Date since) {
		return (System.currentTimeMillis() - since.getTime())  > 5000;
	}

	@SuppressWarnings("rawtypes")
	public Object produceDataset(Map arg0) throws DatasetProduceException {
		
		DefaultCategoryDataset dataset = new DefaultCategoryDataset(){
			
			
			
			protected void finalize() throws Throwable {
				super.finalize();
			}
        };
        
        	res = accueilDao.nbDossierSaisisByHours(new Date(), type);
        	 
             for (int i = 0; i < res.length; i++) {
            	 dataset.addValue(new Integer(res[i]), "dossiers", new Integer(i));
             }
        return dataset;
	}
    

	public String generateToolTip(CategoryDataset ds, int series, int series2) {
	
		return String.valueOf( res[series2]  );
	}

	
}
