package models.components;

public class ComponentExploring {

    public void login(LoginPage loginPage){
        loginPage.login();
    }

    public static void main(String[] args) {
        new ComponentExploring().login(new InternalLoginPage());
        new ComponentExploring().login(new ExternalLoginPage());
    }
}
