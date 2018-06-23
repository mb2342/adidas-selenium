package tk.mdogx.adidas.selenium.pages;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class BasePage {
    private final WebDriver driver;
    public String pageTitle;

    protected BasePage(WebDriver driver) {
        this.driver = driver;
        checkTitle();
    }

    private void checkTitle(){
        Assert.assertTrue(driver.getTitle().equalsIgnoreCase(pageTitle),"Page title doesn't match");
    }
}
