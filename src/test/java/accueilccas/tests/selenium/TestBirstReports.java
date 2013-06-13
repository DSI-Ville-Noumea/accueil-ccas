/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package accueilccas.tests.selenium;

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
        //WebElement statsPage = driver.
        //driver.findElement(By.partialLinkText("Stat générales")).click();
        //driver.findElement(By.partialLinkText("Stat générales")).;
        //driver.findElement(By.xpath("//*[@id=\"menu\"]/ul/li[3]/a")).click();
        //driver.get("http://salad74:XXX@accueil.ccas.site-mairie.noumea.nc");
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
        //driver.getPageSource().c
        //assertEquals("The page title should equal [Accueil] at the start of the test.", "Accueil", driver.getPageSource().con);
        //driver.navigate().refresh();
        assertEquals("Le rapport devrait avoir pour titre \"Nombre de demandes par jour et heure\"", true, driver.getPageSource().contains("Nombre de demandes par jour et heure"));
        assertEquals("Problème de locale : le navigateur doit être en français, format de date DD/MM/YYYY", false, driver.getPageSource().contains("is invalid with the type \"date\""));
        

    }
    
    
    
    
}
