import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import tk.mdogx.adidas.selenium.Utils;
import tk.mdogx.adidas.selenium.pages.HomePage;

import java.util.concurrent.TimeUnit;

public class samplePageTest {

    private WebDriver driver;

    @BeforeTest
    public void setup() {
        driver = Utils.getDriver();
        driver.manage().timeouts().implicitlyWait(Utils.TIMEOUT, TimeUnit.SECONDS);
        driver.navigate().to(Utils.BASEURL);
        driver.manage().window().maximize();
    }

    @AfterTest
    public void testDown() {
        driver.quit();
    }

    @Test
    public void addComments() {

        final String text = "There is comment with generated ID: " + Utils.getRandomString(15);
        final String errorPageMessageWrongEmail = "ERROR: please enter a valid email address.";
        final String errorPageTitleWrongEmail = "Comment Submission Failure";

        new HomePage(driver)
                .openSamplePage()
                .sendNewCommentWithWrongEmail(text)
                .checkErrorMessage(errorPageTitleWrongEmail, errorPageMessageWrongEmail)
                .sendNewComment(text)
                .checkPostedComment(text);
    }
}