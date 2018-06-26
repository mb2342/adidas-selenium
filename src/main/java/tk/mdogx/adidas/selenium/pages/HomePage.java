package tk.mdogx.adidas.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {

    private final WebDriver driver;
    private final String pageTitle = "ONLINE STORE | Toolsqa Dummy Test site";
    private final By samplePageLocator = By.id("menu-item-54");


    public HomePage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        checkPageTitle(pageTitle);
    }

    public SamplePage openSamplePage(){
        driver.findElement(samplePageLocator).click();
        return new SamplePage(driver);
    }
}
