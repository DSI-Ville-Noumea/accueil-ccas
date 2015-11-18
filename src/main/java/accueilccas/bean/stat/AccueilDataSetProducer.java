package accueilccas.bean.stat;

/*
 * #%L
 * Accueil CCAS
 * %%
 * Copyright (C) 2012 - 2015 Mairie de Nouméa
 * %%
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public
 * License along with this program.  If not, see
 * <http://www.gnu.org/licenses/gpl-3.0.html>.
 * #L%
 */


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
