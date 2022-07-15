package api_learning;

import org.apache.commons.exec.OS;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class LaunchBrowser {

    public static void main(String[] args) {
        String currentProjectLocation = System.getProperty("user.dir");
        String chromeDriverLocation = "";

        if (OS.isFamilyWindows()){
            chromeDriverLocation = currentProjectLocation + "\\src\\test\\resources\\drivers\\chromedriver.exe";
        }

        if (OS.isFamilyMac()){
            chromeDriverLocation = currentProjectLocation + "/src/test/resources/drivers/chromedriver";
        }

        if (chromeDriverLocation.isEmpty()){
            throw new IllegalArgumentException("Can't detect OS type");
        }

        // At the time chrome is initiated, it will go to find this property to start enr variable
        System.setProperty("webdriver.chrome.driver", chromeDriverLocation);

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--incognito");

        // start chrome with maximum screen
        // chromeOptions.addArguments("--start-maximized");

        WebDriver driver = new ChromeDriver(chromeOptions);

        // start chrome with maximum screen
        driver.manage().window().maximize();

        driver.get("https://learn.sdetpro.com");

        //Debug purpose only
        try {
            Thread.sleep(3000);
        } catch (Exception e){
            e.printStackTrace();
        }

        // driver.close() => close window but not exit session

        // close window & exit session
        driver.quit();
    }
}
