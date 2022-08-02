package api_learning;

import driver.DriverFactory;
import org.openqa.selenium.*;
import support.ui.SelectEx;
import url.Urls;

public class JSExecutor implements Urls {

    public static void main(String[] args) {

        // Get a chrome session
        WebDriver driver = DriverFactory.getChromeDriver();

        try {
            // Navigate to target page
            driver.get(baseUrl.concat(floatingMenuUrlSlug));

            // Scroll to bottom
            JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
            javascriptExecutor.executeScript("window.scrollTo(0, document.body.scrollHeight)");

            Thread.sleep(2000);

            // Scroll to top
            javascriptExecutor.executeScript("window.scrollTo(document.body.scrollHeight, 0)");

            Thread.sleep(2000);
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Quit browser
        driver.quit();
    }
}
