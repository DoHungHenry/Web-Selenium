package api_learning;

import driver.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LinkTestInteraction {

    public static void main(String[] args) {

        // Get a chrome session
        WebDriver driver = DriverFactory.getChromeDriver();

        try {
            // Navigate to target page
            driver.get("https://the-internet.herokuapp.com/login");

            // Define Selector value
            By linkTextSel = By.linkText("Elemental Selenium");
            // By linkTextSel = By.partialLinkText("Elemental"); // this ok


            // Find Element: if element is not located NoSuchElementException thrown
            WebElement linkTextElem = driver.findElement(linkTextSel);

            // Interaction
            linkTextElem.click();

            Thread.sleep(2000);
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Quit browser
        driver.quit();
    }
}
