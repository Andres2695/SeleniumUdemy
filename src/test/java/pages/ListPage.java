package pages;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import org.openqa.selenium.WebElement;

public class ListPage extends basePages {
    private String searchField = "//body/form[1]/input[1]";
    private String searchResult = "name";

    public ListPage(){
        super(driver);
    }

    public void navegateToListPage(){
        navigateTo("https://andreidbr.github.io/JS30/06AjaxTypeAhead/index.html");
    }
    public void enterSearchCriteria(String state) throws    InterruptedException{
        try{
        Thread.sleep(600);
        write(searchField, state);

        }catch(NoSuchElementException e){
            System.out.println("The webElement search  Field could't be found.");
            e.printStackTrace();
        }
    }

    public List<String> getAllSearchResult(){
        //SE CREA UNA LISTA CON WEBELEMENTS LLAMADA "list"
        List<WebElement> list = brigMeAllElements(searchResult);
        //SE CREA UNA LISTA DE TIPO STRING BASIA .. LLAMADA "stringFromList"
        List<String> stringFromList= new ArrayList<String>();
        //SE CREA UN SICLO QUE VA A RRECORRER TODOS LOS ELEMENTOS "e" DE LA LISTA DE TIPO WEBELEMENT 
        for(WebElement e:list){
            //VA A AGREGAR CADA ELEMENTO DE LA LISTA DE WEBELEMENT A LA LISTA DE TIPO STRIN "stringFromList"
            stringFromList.add(e.getText());
        }
        //RETORNA LA LISTA DE TIPO STRING CON TODOS LOS VALORES DE LA LISTA DE TIPO WEBELEMENT 
        return stringFromList;
    }
    
}
