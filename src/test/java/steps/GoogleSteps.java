package steps;

import org.junit.Assert;
import cucumber.api.java.en.*;
import pages.GooglePage;

public class GoogleSteps{
   GooglePage google = new GooglePage();

    @Given("^Navego a Google$")
    public void navigateToGoogle(){
        google.navigateToGoogle();
    }

    @When("^Busco algo$")
    public void searchToGoogle() {
        google.enterSearchCriteria("Colombia");
    }

    @And("^clickeo en el boton de buscar$")
    public void clickOnTheBottonSearch(){
        google.clickGoogleSearch();
    }

    @Then("^Obtengo resultados$")
    public void validateResults(){
        Assert.assertEquals("Texto que esperamos", google.firstResult());
    }
}