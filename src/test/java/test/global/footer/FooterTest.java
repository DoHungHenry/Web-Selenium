package test.global.footer;

import driver.DriverFactory;
import models.components.global.footer.CustomerServiceColumnComponent;
import models.components.global.footer.FooterColumnComponent;
import models.components.global.footer.InformationColumnComponent;
import models.pages.HomePage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import url.Urls;

public class FooterTest {

//    public static void main(String[] args) {
//        WebDriver driver = DriverFactory.getChromeDriver();
//
//        try {
//            testFooterHomePage(driver);
//            testFooterCategoryPage(driver);
//            testFooterRegisterPage(driver);
//            testFooterLoginPage(driver);
//        } catch (Exception e){
//            e.printStackTrace();
//        }
//
//        driver.quit();
//    }

    @Test(priority = 4)
    public void testFooterHomePage() {
        WebDriver driver = DriverFactory.getChromeDriver();
        driver.get(Urls.demoBaseUrl);
        try {
            HomePage homePage = new HomePage(driver);
            InformationColumnComponent informationColumnComp =
                    homePage.footerComp().informationColumnComp();

            CustomerServiceColumnComponent customerServiceColumnComp =
                    homePage.footerComp().customerServiceColumnComp();

            testFooterColumn(informationColumnComp);
            testFooterColumn(customerServiceColumnComp);
        } catch (Exception ignored){
            ignored.printStackTrace();
        }

        driver.quit();
    }

    @Test(priority = 3)
    public void testFooterCategoryPage() {
    }

    @Test(priority = 2)
    public void testFooterRegisterPage() {
        throw new RuntimeException("Make this test method failed to prevent testFooterLoginPage method being performed");
    }

    @Test(priority = 1, dependsOnMethods = {"testFooterRegisterPage"})
    public void testFooterLoginPage() {
    }

    private void testFooterColumn(FooterColumnComponent footerColumnComponent){
        System.out.println(footerColumnComponent.headerElem().getText());
        footerColumnComponent.linksElem().forEach(link -> {
            System.out.println(link.getText());
            System.out.println(link.getAttribute("href"));
        });
    }
}
