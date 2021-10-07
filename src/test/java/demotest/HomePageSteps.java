package demotest;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pages.HomePage;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;


public class HomePageSteps {

    private final String homepageURL= "http://automationpractice.com/index.php";
    private String baseURL= "https://fakerestapi.azurewebsites.net/api/v1/";
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

    @Given("Im able to access {string}")
    public void IShouldSeeEndpoint(String endpoint) {
        endpoint = baseURL+endpoint;

        given().
                get(endpoint).
        then().
                statusCode(200);
    }

}
