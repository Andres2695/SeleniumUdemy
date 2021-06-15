package steps;

import java.util.List;

import cucumber.api.java.en.*;
//import io.cucumber.java.en.*;
import pages.ListPage;

public class ListSteps {
    ListPage list = new ListPage();

    @Given("^I navigate to the list page$")

    public void navegateToList(){
        list.navegateToListPage();
    }

    @When("^I search (.+) in the list$")
    public void searchTheList(String state)throws InterruptedException {
        list.enterSearchCriteria(state);
    }

    @Then("^I cand find (.+) in the list$")
    public void findTextInTheList(String city){
        List<String> lista = list.getAllSearchResult();
        boolean textIsThere = lista.contains(city);

        if(textIsThere){
            System.out.println("The text is on the list : PASSED");
        }else{
            System.out.println("The text is not on the list : FAILED");
        }
    }
}
