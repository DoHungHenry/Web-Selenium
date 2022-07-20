package api_learning;

import driver.DriverFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class FormInteractionMultiMatching {

    public static void main(String[] args) {

        // Get a chrome session
        WebDriver driver = DriverFactory.getChromeDriver();

        try {
            // Navigate to target page
            driver.get("https://the-internet.herokuapp.com/login");

            // Define selector value
            By loginInputFieldsSel = By.tagName("input");

            // Interaction
            List<WebElement> loginInputFieldsElem = driver.findElements(loginInputFieldsSel);
            final int USER_NAME_INDEX = 0;
            final int PASS_WORD_INDEX = 1;

            if (!loginInputFieldsElem.isEmpty()){
                loginInputFieldsElem.get(USER_NAME_INDEX).sendKeys("abc");
                loginInputFieldsElem.get(PASS_WORD_INDEX).sendKeys("abc");
            } else {
//                Alert.fail("Can't find element");
            }


            Thread.sleep(2000);
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Quit browser
        driver.quit();
    }
}
