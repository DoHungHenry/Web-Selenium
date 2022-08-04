package test.global.footer;

import driver.DriverFactory;
import models.components.global.footer.InformationColumnComponent;
import models.pages.HomePage;
import org.openqa.selenium.WebDriver;

public class FooterTest {

    public static void main(String[] args) {
        WebDriver driver = DriverFactory.getChromeDriver();

        testFooterHomePage(driver);
        testFooterCategoryPage(driver);
        testFooterRegisterPage(driver);
        testFooterLoginPage(driver);
    }

    private static void testFooterHomePage(WebDriver driver) {
        HomePage homePage = new HomePage(driver);
        InformationColumnComponent informationColumnComp =
                homePage.footerComp().informationColumnComp();
        informationColumnComp.headerElem()
    }

    private static void testFooterCategoryPage(WebDriver driver) {
    }

    private static void testFooterRegisterPage(WebDriver driver) {
    }

    private static void testFooterLoginPage(WebDriver driver) {
    }


}
