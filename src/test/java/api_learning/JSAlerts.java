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

            // JS Alert | click on OK
            handleAlert(driver, jsAlertSel, true);
            System.out.println("Result is: " + driver.findElement(resultSel).getText());

            // JS Confirm | click on Cancel
            handleAlert(driver, jsConfirmSel, false);
            System.out.println("Result is: " + driver.findElement(resultSel).getText());

            // JS Prompt
            handleAlert(driver, jsPromptSel, "I am ABC");
            System.out.println("Result is: " + driver.findElement(resultSel).getText());

        } catch (Exception e) {
            e.printStackTrace();
        }

        // Quit browser
        driver.quit();
    }

    public static void handleAlert(WebDriver driver, By triggerAlertSel, boolean isAccepting){
        Alert alert = getAlert(driver, triggerAlertSel);
        System.out.println("Alert content is: " + alert.getText());
        if (isAccepting) alert.accept();
        else alert.dismiss();
    }
    public static void handleAlert(WebDriver driver, By triggerAlertSel, String content){
        Alert alert = getAlert(driver, triggerAlertSel);
        System.out.println("Alert content is: " + alert.getText());
        alert.sendKeys(content);
        alert.accept();
    }

    private static Alert getAlert(WebDriver driver, By triggerAlertSel){
        WebElement triggerAlertBtnElem = driver.findElement(triggerAlertSel);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        triggerAlertBtnElem.click();
        return wait.until(ExpectedConditions.alertIsPresent());
    }
}
