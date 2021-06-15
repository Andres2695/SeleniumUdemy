package pages;

public class GooglePage extends basePages {
private String searchButton = "//body/div[1]/div[3]/form[1]/div[1]/div[1]/div[3]/center[1]/input[1]";
private String searchTextField = "//body/div[1]/div[3]/form[1]/div[1]/div[1]/div[1]/div[1]/div[2]/input[1]";
private String firstResult = "";

    
    public GooglePage(){
        super (driver);
    }
    public void navigateToGoogle(){
        navigateTo("https://www.google.com");
    }

    public void enterSearchCriteria(String criteria){
        write(searchTextField, criteria);
    }
    
    public void clickGoogleSearch(){
        clickElement(searchButton);
    }

    public String firstResult(){
        return textFromElement(firstResult);
    }
}