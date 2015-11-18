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


import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import static junit.framework.Assert.assertEquals;
import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.apache.commons.io.FileUtils;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.Augmenter;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

/**
 *
 * @author salad74
 */
public class CommonCCASTest {
    private static String baseUrl;
    protected static WebDriver driver;
    private static ScreenshotHelper screenshotHelper;
    private static int numScreen = 0;
    protected static PropertiesConfiguration conf;
    public static final String SCREENSHOTS_BASE_DIR = "src/site/resources/test/img/";
    
    @BeforeClass
    public static void setUp() throws MalformedURLException{
        DesiredCapabilities capabilities = DesiredCapabilities.firefox();
        capabilities.setCapability(CapabilityType.TAKES_SCREENSHOT,true);
        
        String PROXY = "http://ebreak.site-mairie.noumea.nc:3128";
        Proxy proxy = new Proxy();
        proxy.setHttpProxy(PROXY);
        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability(CapabilityType.PROXY, proxy);
        cap.setCapability(CapabilityType.BROWSER_NAME, "firefox");
        cap.setJavascriptEnabled(true);
        capabilities.setCapability("default_locale", "fr");
        
        driver = new Augmenter().augment(new RemoteWebDriver(new URL("http://172.16.24.131:4444/wd/hub"), cap));
        String msg;
        try {
            //baseUrl = "http://salad74:XXXX@accueil.ccas.site-mairie.noumea.nc/";
            //baseUrl = System.getProperty("url");
            conf = new PropertiesConfiguration("ccas.properties");
            msg=conf.getString("url");
            baseUrl = msg;
            System.out.println("RETRIEVED baseurl : <" + baseUrl + ">");
        Assert.assertNotNull("base url  should not be null !", baseUrl);
        driver.get(baseUrl);

        
        screenshotHelper = new ScreenshotHelper();
        } catch (ConfigurationException ex) {
            Logger.getLogger(CommonCCASTest.class.getName()).log(Level.SEVERE, null, ex);
            msg=ex.getMessage();
        }
        
        
        
    }
    
    @Test
    public void common(){
        assertEquals(true, true);
    }

    @AfterClass
    public static void tearDown() {
        //List<JavaScriptErrorListener> jsErrors = JavaScriptErrorListener.readErrors(driver);
        /*
         * System.out.println("###start displaying errors");
        for(int i = 0; i < jsErrors.size(); i++) {
            System.out.println(jsErrors.get(i).toString());
            System.out.println(jsErrors.get(i).toString());
            System.out.println(jsErrors.get(i).toString());
        }
        System.out.println("###start displaying errors");
        */
        driver.close();
        driver.quit();
    }
    
    public static void saveScreenshot() {
        try{
            screenshotHelper.saveScreenshot(SCREENSHOTS_BASE_DIR + numScreen + ".png");
            numScreen++;
        }
        catch(IOException ex){
            System.err.println(ex.getMessage());
        }
        
    }

    private static class ScreenshotHelper {
        public void saveScreenshot(String screenshotFileName) throws IOException {
            File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(screenshot, new File(screenshotFileName));
        }
        
    }
}
