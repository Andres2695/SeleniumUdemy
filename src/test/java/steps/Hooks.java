package steps;

import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.OutputType;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import pages.basePages;

public class Hooks extends basePages {
    
    public Hooks(){
        super(driver);
    }

    @After 
    public void tearDown(Scenario scenario){
        if(scenario.isFailed()){
            scenario.write("ESTO FALLO");
            final byte[] screanshot = ((TakesScreenshot) driver)
                .getScreenshotAs(OutputType.BYTES);
            scenario.embed(screanshot, "img/png");
        }
    }
}
