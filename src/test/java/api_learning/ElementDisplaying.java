package api_learning;

import driver.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ElementDisplaying {

    public static void main(String[] args) {

        // Get a chrome session
        WebDriver driver = DriverFactory.getChromeDriver();

        Exception e = null;

        try {
            // Navigate to target page
            driver.get("https://the-internet.herokuapp.com/login");

            // Define Selector value
            By usernameSel = By.id("username_");

            // Find Element: if element is not located NoSuchElementException thrown
            WebElement usernameElem = driver.findElement(usernameSel);

        } catch (NoSuchElementException noSuchElementException) {
            e = noSuchElementException;
        }

        // Quit browser
        driver.quit();
    }
}
