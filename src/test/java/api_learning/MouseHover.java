package api_learning;

import driver.DriverFactory;
import jdk.dynalink.linker.LinkerServices;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import url.Urls;

import java.util.List;

public class MouseHover implements Urls {

    public static void main(String[] args) {
        // Get a chrome session
        WebDriver driver = DriverFactory.getChromeDriver();

        try {
            // Navigate to target page
            driver.get(baseUrl.concat(hoverUrlSlug));

            List<WebElement> figcaptionNamesElem = driver.findElements(By.cssSelector(".figcaption h5"));
            List<WebElement> figcaptionHrefsElem = driver.findElements(By.cssSelector(".figcaption a"));


        } catch (Exception e) {
            e.printStackTrace();
        }

        // Quit browser
        driver.quit();
    }
}
