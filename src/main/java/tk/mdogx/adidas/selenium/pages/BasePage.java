package tk.mdogx.adidas.selenium.pages;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class BasePage {

    private final WebDriver driver;

    protected BasePage(WebDriver driver) {
        this.driver = driver;
    }

    protected void checkPageTitle(String pageTitle) {
        Assert.assertEquals(driver.getTitle(), pageTitle, "Page title doesn't match");
    }


}
