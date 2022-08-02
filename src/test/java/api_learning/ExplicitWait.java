package api_learning;

import driver.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import support.ui.SelectEx;
import url.Urls;

import java.time.Duration;

public class ExplicitWait implements Urls {

    public static void main(String[] args) {

        // Get a chrome session
        WebDriver driver = DriverFactory.getChromeDriver();

        try {
            // Navigate to target page
            driver.get(baseUrl.concat(loginUrlSlug));

            // Locator & Elems
            By xSel = By.cssSelector("#teo");

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
//            wait.until(ExpectedConditions.visibilityOfElementLocated(xSel));

            wait.until(ExpectedConditions.visibilityOf(driver.findElement(xSel)));


        } catch (Exception e) {
            e.printStackTrace();
        }

        // Quit browser
        driver.quit();
    }
}
