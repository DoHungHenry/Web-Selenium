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

            // Locate iframe
            By iframeSel = By.cssSelector("[id$='ifr']");
            WebElement iframeElem = driver.findElement(iframeSel);

            // Switch to iframe
            driver.switchTo().frame(iframeElem);

            // Locate element inside iframe
            WebElement editorInputElem = driver.findElement(By.id("tinymce"));
            editorInputElem.click();
            editorInputElem.clear();
            editorInputElem.sendKeys("new text");
            Thread.sleep(1000);

            // If we want to handle element outside of iframe, we need to switch back to outside of iframe first
            driver.switchTo().defaultContent();
            driver.findElement(By.linkText("Elemental Selenium")).click();
            Thread.sleep(1000);

            // Interaction

            Thread.sleep(2000);
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Quit browser
        driver.quit();
    }
}
