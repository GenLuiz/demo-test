package demotest;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeStep;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pages.HomePage;


public class HomePageSteps {

    private final String homepageURL= "http://automationpractice.com/index.php";
    private WebDriver driver;
    private BrowserFactory browserFactory = new BrowserFactory();
    private HomePage homePage = new HomePage();

    @Before()
    public void openBrowser(){
        driver = browserFactory.getWebDriver();
    }

    @Given("Im in the home page")
    public void navigateToHomePage() {
        driver.navigate().to(homepageURL);
    }

    @When("I search for {string}")
    public void searchForItem(String item) {
        homePage.searchFor(item);
    }

    @Then("I should see no results for {string}")
    public void IshouldntSeeItem(String item) {
        String messsage = homePage.getAlertWarningMessage();
        Assert.assertTrue(messsage.contains("No results were found for your search "+"\""+item+"\""));
    }

    @Then("I should see results for {string}")
    public void IShouldSeeItem(String item){
        Assert.assertEquals(item, homePage.getProductTitle());
    }

    @Given("I close the browser")
    public void closeDriver(){
        browserFactory.closeDriver();
    }

}
