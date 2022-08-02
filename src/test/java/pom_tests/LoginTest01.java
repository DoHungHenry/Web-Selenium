package pom_tests;

import driver.DriverFactory;
import models.pages.LoginPageMod01;
import org.openqa.selenium.WebDriver;

public class LoginTest01 {

    public static void main(String[] args) {

        // Get a chrome session
        WebDriver driver = DriverFactory.getChromeDriver();

        try {
            // Navigate to target page
            driver.get("https://the-internet.herokuapp.com/login");

            LoginPageMod01 loginPage = new LoginPageMod01(driver);
            loginPage.username().sendKeys("abc");
            loginPage.password().sendKeys("def");
            loginPage.loginBtn().click();
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Quit browser
        driver.quit();
    }
}
