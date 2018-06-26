package tk.mdogx.adidas.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class SamplePage extends BasePage {

    private final WebDriver driver;

    private final String pageTitle = "Sample Page | ONLINE STORE";
    private final String commentPostedTextId = "comment-body";

    private final By commentTextLocator = By.id("comment");
    private final By nameTextLocator = By.id("author");
    private final By emailTextLocator = By.id("email");
    private final By postCommentButtonLocator = By.id("submit");
    private final By commentPostedLocator = By.xpath("//div[@class='comment_container group']");
    private final By commentPostedAuthorLocator = By.xpath("//cite[@class='fn']");
    private final By commentPostedTextLocator = By.xpath("//div[@class='" + commentPostedTextId + "']");


    private final String name = "Maksim";
    private final String email = "test@test.com";
    private final String emailWrong = "test.test.com";

    public SamplePage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        checkPageTitle(pageTitle);
    }

    public SamplePage sendNewComment(String text) {
        driver.findElement(commentTextLocator).clear();
        driver.findElement(commentTextLocator).sendKeys(text);
        driver.findElement(nameTextLocator).sendKeys(name);
        driver.findElement(emailTextLocator).sendKeys(email);
        driver.findElement(postCommentButtonLocator).click();
        return new SamplePage(driver);
    }

    public void checkPostedComment(String text) {
        System.out.println("//*[contains(text(), '" + text + "')]");
        System.out.println(driver.findElements(By.xpath("//*[contains(text(), '" + text + "')]")).size());
        Assert.assertTrue(driver.findElements(By.xpath("//*[contains(text(), '" + text + "')]")).size() == 1, "New comment not found");
    }

    public SamplePage sendNewCommentWithWrongEmail(String text) {
        driver.findElement(commentTextLocator).sendKeys(text);
        driver.findElement(nameTextLocator).sendKeys(name);
        driver.findElement(emailTextLocator).sendKeys(emailWrong);
        driver.findElement(postCommentButtonLocator).click();
        return this;
    }

    public SamplePage checkErrorMessage(String title, String message) {
        checkPageTitle(title);
        new ErrorPage(driver)
                .checkErrorMessage(message)
                .returnBack();
        return this;
    }
}
