package models.pages;

import models.components.LoginFormComponent;
import org.openqa.selenium.WebDriver;

// Page Object model type 1
public class LoginPageMod03 {

    private final WebDriver driver;

    public LoginPageMod03(WebDriver driver) {
        this.driver = driver;
    }

    public LoginFormComponent loginFormComp(){
        return new LoginFormComponent(driver);
    }
}
