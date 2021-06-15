package pages;

import java.util.List;

//import javax.swing.Action;

//import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
//import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


public class basePages {

    protected static WebDriver driver;
    private static WebDriverWait wait;
    private static Actions action;

    static{
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\handr\\Downloads\\chromedriver.exe");

        ChromeOptions chromeOptions = new ChromeOptions();
        driver= new ChromeDriver(chromeOptions);
        wait = new WebDriverWait(driver,10);
    }

    public basePages(WebDriver driver){
        basePages.driver=driver;
        wait = new WebDriverWait(driver,10);
        //FORMA PAGEFACTORYPAGE
       // PageFactory.initElements(driver, page: this);

    }
//NAVEGAR HACIA LA PAGINA QUE SE REQUIETRE
    public static void navigateTo(String url){
        driver.get(url);
    }

    //CERRAR EL BROWSER

    public static void closeBrowser(){
        driver.quit();
    }
//BUSCAR UN WEB ELEMENT 
    private WebElement Find(String locator){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
    }
//DARLE CLICK SOBRE UN WEBELEMENT
    public void clickElement(String locator){
        Find(locator).click();
    }
//ENVIARLE UN TEXTO A UNA BARRA DE TEXTO
    public void write (String locator, String textToWrite){
        Find(locator).clear();
        Find(locator).sendKeys(textToWrite);
    }
   //SELECCIONAR ALGO DE UNA CAJA DE OPCIONES SEGUN SU VALOR
    public void selectFromDropdownByValue(String locator, String valueToSelect){
        Select dropdown = new Select(Find(locator));

        dropdown.selectByValue(valueToSelect);
    }
    //SELECCIONAR ALGO DE UNA CAJA DE OPCIONES SEGUN SU INDEX
    public void selectFromDropdownByIndex(String locator, int valueToSelect){
        Select dropdown = new Select(Find(locator));

        dropdown.selectByIndex(valueToSelect);
    }
    //DEVUELVE UN STRING DE UNA TABLA
    public String getValueFromTable(String locator, int row,int column){
        String cellIneed = locator+"/table/tbody/tr["+row+"]/td["+column+"]";
        return Find(cellIneed).getText();
    }

    //PASAR EL CLICK POR ENCIMA DE UN WEB ELEMENT
    public void hoverOverElement(String locator){
        action.moveToElement(Find(locator));
    }

    public void doubleClick(String locator){
        action.doubleClick(Find(locator));
    }
    //CLICK DERECHO SOBRE UN WEB ELEMENT
    public void rightClick(String locator){
        action.contextClick(Find(locator));
    }

    public void switchToiFrame(int iFrameIndex){
        driver.switchTo().frame(iFrameIndex);
    }
    //VOVLER AL PADRE (ALERTA)
    public void swithcToParentFrame(){
        driver.switchTo().parentFrame();
    }
    //QUITAR ALERTAS DEL DOM
    public void dissmissAlert(){
        try{
        driver.switchTo().alert().dismiss();
        }catch(NoAlertPresentException e){
            e.printStackTrace();
        }

    }
    public String textFromElement(String locator){
        return Find(locator).getText();
    }
    //TRUE O FALSE DE SI ALGO ESTA SIENDO MOSTRADO EN EL HTML 
    public boolean elementIsDisplayes(String locator){
        return Find(locator).isDisplayed();
    }

    //COMPROBAR SI UN ELEMENTO ES SELECCIONADO DE UN DROPBOX

    public boolean elementIsSelected(String locator){
        return Find(locator).isSelected();
    }

    //COMPROBAR QUE EXISTA UN ELEMENTO EN UNA LISTA

    public List<WebElement> brigMeAllElements(String locator){
        return driver.findElements(By.className(locator));
    }
}
