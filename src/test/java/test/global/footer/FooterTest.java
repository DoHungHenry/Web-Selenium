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

    @Test
    public void testFooterHomePage(WebDriver driver) {
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

    @Test
    public void testFooterCategoryPage(WebDriver driver) {
    }

    @Test
    public void testFooterRegisterPage(WebDriver driver) {
    }

    @Test
    public void testFooterLoginPage(WebDriver driver) {
    }

    private void testFooterColumn(FooterColumnComponent footerColumnComponent){
        System.out.println(footerColumnComponent.headerElem().getText());
        footerColumnComponent.linksElem().forEach(link -> {
            System.out.println(link.getText());
            System.out.println(link.getAttribute("href"));
        });
    }


}
