/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package accueilccas.tests.selenium;

import java.io.IOException;
import java.util.List;
import static junit.framework.Assert.assertEquals;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 *
 * @author salad74
 */
public class TestAccueilLogin extends CommonCCASTest{

//    private static String baseUrl;
//    private static WebDriver driver;
//    private static ScreenshotHelper screenshotHelper;
//    private static int numScreen = 0;
//
//    @BeforeClass
//    public static void setUp() {
//        DesiredCapabilities capabilities = DesiredCapabilities.firefox();
//        capabilities.setCapability(CapabilityType.TAKES_SCREENSHOT,true);
//        driver = new FirefoxDriver(capabilities);
//        
//        baseUrl = "http://salad74:bart&omer666@accueil.ccas.site-mairie.noumea.nc/";
//        driver.get(baseUrl);
//        screenshotHelper = new TestAccueilCCASLogin.ScreenshotHelper();
//    }
//
//    @AfterClass
//    public static void tearDown() {
//        //List<JavaScriptErrorListener> jsErrors = JavaScriptErrorListener.readErrors(driver);
//        /*
//         * System.out.println("###start displaying errors");
//        for(int i = 0; i < jsErrors.size(); i++) {
//            System.out.println(jsErrors.get(i).toString());
//            System.out.println(jsErrors.get(i).toString());
//            System.out.println(jsErrors.get(i).toString());
//        }
//        System.out.println("###start displaying errors");
//        * */
//        driver.close();
//        driver.quit();
//    }
//    
//    public static void saveScreenshot() {
//        try{
//            screenshotHelper.saveScreenshot("ccas_" + numScreen + ".png");
//            numScreen++;
//        }
//        catch(IOException ex){
//            System.err.println(ex.getMessage());
//        }
//        
//    }
//
//    private static class ScreenshotHelper {
//        public void saveScreenshot(String screenshotFileName) throws IOException {
//            File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
//            FileUtils.copyFile(screenshot, new File(screenshotFileName));
//        }
//        
//    }
//    
//    
///////////////////////////////////////////////////////////////
//   // TEST methods
    @Test
    public void testTypeDeReceptionLabel(){
        List<WebElement> typeReceptions = driver.findElements(By.name("typeReception"));
        System.out.println("Types de reception : <" + typeReceptions.size()+ ">");
        
        for (WebElement recep : typeReceptions){
            System.out.println(recep.toString());
        }
        typeReceptions.get(0).click();
        saveScreenshot();
        typeReceptions.get(1).click();
        saveScreenshot();
    }
    
    @Test
    public void titleTest() throws IOException {
        assertEquals("The page title should equal [Accueil] at the start of the test.", "Accueil", driver.getTitle());
    }

}
