package driver;

import org.apache.commons.exec.OS;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class DriverFactory {

    public static WebDriver getChromeDriver(){
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

        // Interval time: 500 mili seconds
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));

        return driver;
    }
}
