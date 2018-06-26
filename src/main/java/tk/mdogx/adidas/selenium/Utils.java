package tk.mdogx.adidas.selenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.security.SecureRandom;
import java.util.Properties;

public class Utils {

    private static WebDriver webDriver;

    public final static String BROWSER = getPropertyByKey("browser").toLowerCase();
    public final static String BASEURL = getPropertyByKey("baseUrl").toLowerCase();
    public final static Long TIMEOUT = Long.parseLong(getPropertyByKey("timeout"));

    public static WebDriver getDriver() {
        if (webDriver != null) {
            return webDriver;
        }
        switch (BROWSER) {
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                webDriver = new FirefoxDriver();
                break;
            case "chrome":
                WebDriverManager.chromedriver().setup();
                webDriver = new ChromeDriver();
                break;
        }
        return webDriver;
    }

    public static String getPropertyByKey(String key) {
        // Take properties from file
        Properties prop = new Properties();
        try (FileInputStream fis = new FileInputStream("src\\main\\java\\tk\\mdogx\\adidas\\selenium\\test.properties");
             InputStreamReader isr = new InputStreamReader(fis, "UTF-8")) {
            prop.load(isr);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return prop.getProperty(key);
    }

    public static String getRandomString(int length) {
        final String AB = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        SecureRandom rnd = new SecureRandom();
        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++)
            sb.append(AB.charAt(rnd.nextInt(AB.length())));
        return sb.toString();
    }
}
