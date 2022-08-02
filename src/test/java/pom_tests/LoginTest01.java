package pom_tests;

import driver.DriverFactory;
import models.pages.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginTest01 {

    public static void main(String[] args) {

        // Get a chrome session
        WebDriver driver = DriverFactory.getChromeDriver();

        try {
            // Navigate to target page
            driver.get("https://the-internet.herokuapp.com/login");

            LoginPage loginPage = new LoginPage(driver);
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
