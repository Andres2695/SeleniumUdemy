package steps;

import org.junit.Assert;

//import io.cucumber.java.en.Given;

//import io.cucumber.java.en.Then;
import cucumber.api.java.en.*;
import pages.GridPage;

public class GridTestSteps {
    GridPage grid= new GridPage();

    @Given("^I navigate to static table$")
        public void navigateToGridPage() {
            grid.navigateToGrid();
        }
        @Then("^I can return the value i wanted$")

            public void returnValue(){
            String value = grid.getValueFromGrid(3,2);
            //COMPROBAR QUE SE ENCUENTRA EXACTAMENTE LO MISMO EN EL WEBDRIVER
            Assert.assertEquals("r: 2, c: 1", value);
        }
        //COMPROBAR QUE UN ELEMENTO SI SE MUESTRE ... en este caso no se deberia de mostrar
        @Then("^I can validate the table is displayed$")
        public void theTableIsHere(){
            Assert.assertTrue("El elemento esta siendo mostrado",grid.cellStatus());
        }
    }


