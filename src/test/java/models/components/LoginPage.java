package models.components;

import org.openqa.selenium.WebDriver;

public abstract class LoginPage {

    protected WebDriver driver;

    public void login() {
        System.out.println(username());
        System.out.println(password());
        System.out.println(loginBtn());
    }

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void verifyLoginSuccess() {
        System.out.println("Verifying Dashboard display");
    }

    public abstract String username();

    public abstract String password();

    public abstract String loginBtn();
}
