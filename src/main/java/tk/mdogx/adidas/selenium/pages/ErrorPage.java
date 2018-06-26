package tk.mdogx.adidas.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class ErrorPage extends BasePage {

    private final WebDriver driver;

    private final By errorMessageLocator = By.xpath("/html/body[@id='error-page']/p[2]");
    private final By backButtonLocator = By.xpath("/html/body[@id='error-page']/p[4]/a");


    public ErrorPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public ErrorPage checkErrorMessage(String message) {
        Assert.assertEquals(driver.findElement(errorMessageLocator).getText(), message, "Error message on Error page doesn't match");
        return this;
    }

    public void returnBack() {
        driver.findElement(backButtonLocator).click();
    }
}
