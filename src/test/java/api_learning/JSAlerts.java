package api_learning;

import driver.DriverFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import url.Urls;

import java.time.Duration;

public class JSAlerts implements Urls {

    public final static By jsAlertSel = By.cssSelector("[onclick=\"jsAlert()\"]");
    public final static By jsConfirmSel = By.cssSelector("[onclick=\"jsConfirm()\"]");
    public final static By jsPromptSel = By.cssSelector("[onclick=\"jsPrompt()\"]");
    public final static By resultSel = By.id("result");

    public static void main(String[] args) {

        // Get a chrome session
        WebDriver driver = DriverFactory.getChromeDriver();

        try {
            // Navigate to target page
            driver.get(baseUrl.concat(javascriptAlertUrlSlug));
            WebElement triggerAlertBtnElem;

            Alert alert;
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));

            // JS Alert | click on OK
            triggerAlertBtnElem = driver.findElement(jsAlertSel);
            triggerAlertBtnElem.click();
            alert = wait.until(ExpectedConditions.alertIsPresent());
            System.out.println("Alert content is: " + alert.getText());
            alert.accept();
            System.out.println("Result is: " + driver.findElement(resultSel).getText());

            // JS Confirm | click on Cancel
            triggerAlertBtnElem = driver.findElement(jsConfirmSel);
            triggerAlertBtnElem.click();
            alert = wait.until(ExpectedConditions.alertIsPresent());
            System.out.println("Alert content is: " + alert.getText());
            alert.dismiss();
            System.out.println("Result is: " + driver.findElement(resultSel).getText());

            // JS Prompt
            triggerAlertBtnElem = driver.findElement(jsPromptSel);
            triggerAlertBtnElem.click();
            alert = wait.until(ExpectedConditions.alertIsPresent());
            System.out.println("Alert content is: " + alert.getText());
            alert.sendKeys("I am a JS prompt");
            alert.accept();
            System.out.println("Result is: " + driver.findElement(resultSel).getText());

        } catch (Exception e) {
            e.printStackTrace();
        }

        // Quit browser
        driver.quit();
    }
}
