package api_learning;

import driver.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import url.Urls;

public class Iframe implements Urls {

    public static void main(String[] args) {

        // Get a chrome session
        WebDriver driver = DriverFactory.getChromeDriver();

        try {
            // Navigate to target page
            driver.get(baseUrl.concat(iframeUrlSlug));

            // Define Selector value
            By iframeSel = By.cssSelector("#tinymce p");

            // Find Element: if element is not located NoSuchElementException thrown
            driver.findElement(iframeSel).sendKeys("abcd");

            // Interaction

            Thread.sleep(2000);
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Quit browser
        driver.quit();
    }
}
