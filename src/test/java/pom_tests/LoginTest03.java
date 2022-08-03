package pom_tests;

import driver.DriverFactory;
import models.pages.LoginPageMod02;
import models.pages.LoginPageMod03;
import org.openqa.selenium.WebDriver;

public class LoginTest03 {

    public static void main(String[] args) {

        // Get a chrome session
        WebDriver driver = DriverFactory.getChromeDriver();

        try {
            // Navigate to target page
            driver.get("https://the-internet.herokuapp.com/login");

            LoginPageMod03 loginPage = new LoginPageMod03(driver);
            loginPage.loginFormComp().inputUsername("abc");
            loginPage.loginFormComp().inputPassword("def");
            loginPage.loginFormComp().clickLoginBtn();
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Quit browser
        driver.quit();
    }
}
