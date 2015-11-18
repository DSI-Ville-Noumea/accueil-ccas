/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package accueilccas.tests.selenium;

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


import java.util.logging.Level;
import java.util.logging.Logger;
import static junit.framework.Assert.assertEquals;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

/**
 *
 * @author salad74
 */
public class TestBirstReports extends CommonCCASTest{
    
    @Test
    public void testNombreDeDemandesParJourEtHeure(){
        driver.get(conf.getString("url"));
        // click on stats generales
        driver.findElement(By.partialLinkText("générales")).click();
        
        // next , click on first item
        
        WebElement web = driver.findElement(By.xpath("//*[@id=\"columnA_columnless\"]/center/table/tbody/tr[1]/td[4]/a[2]"));
        //web.get
        //web.click();
        web.sendKeys(Keys.CONTROL + "t");
        driver.get(web.getAttribute("href"));

        //driver.switchTo().window("_blank");
        
        WebElement sd = driver.findElement(By.name("startDate"));
        sd.sendKeys("01/01/2013");
        WebElement ed = driver.findElement(By.name("endDate"));
        ed.sendKeys("31/12/2013");
//        try {
//            Thread.sleep(1000);
//        } catch (InterruptedException ex) {
//            Logger.getLogger(TestBirstReports.class.getName()).log(Level.SEVERE, null, ex);
//        }
        saveScreenshot();
        
        // tester que la page n'est pas sur une session expirée : [The viewing session is not available or has expired.]
                             try {
            Thread.sleep(2000);
        } catch (InterruptedException ex) {
            Logger.getLogger(TestBirstReports.class.getName()).log(Level.SEVERE, null, ex);
        } 
        driver.findElement(By.xpath("//*[@id=\"parameterDialogokButton\"]/input")).click();
        
                     try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            Logger.getLogger(TestBirstReports.class.getName()).log(Level.SEVERE, null, ex);
        }   
        saveScreenshot();
        //assertEquals("The page title should equal [Accueil] at the start of the test.", "Accueil", driver.getPageSource().con);
        //driver.navigate().refresh();
        
        assertEquals("Le rapport devrait avoir pour titre \"Nombre de demandes par jour et heure\"", true, driver.getPageSource().contains("Nombre de demandes par jour et heure"));
        assertEquals("Problème de locale : le navigateur doit être en français, format de date DD/MM/YYYY", false, driver.getPageSource().contains("is invalid with the type \"date\""));
        

    }
    
    
    
    
}
