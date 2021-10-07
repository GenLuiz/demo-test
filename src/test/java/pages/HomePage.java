package pages;

import org.openqa.selenium.By;

public class HomePage extends AbstractPage{

    private String searchBarId = "search_query_top";

    private String submitSearchBtnName = "submit_search";

    private String alertWarningClass = "//*[contains(@class, 'alert alert-warning')]";

    private String productOnListXpath = "//*[contains(@class, 'product-name') and contains(@itemprop, 'url')]";

    public void searchFor(String data) {
        findElement(By.id(searchBarId)).sendKeys(data);
        findElement(By.name(submitSearchBtnName)).click();
    }

    public String getAlertWarningMessage(){
        waitForElement(By.xpath(alertWarningClass));
        return findElement(By.xpath(alertWarningClass)).getText();
    }

    public String getProductTitle() {
        waitForElement(By.xpath(productOnListXpath));
        return findElement(By.xpath(productOnListXpath)).getText();
    }
}
