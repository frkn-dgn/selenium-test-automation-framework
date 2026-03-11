package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utils.ConfigReader;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import utils.ScreenshotUtil;
import org.openqa.selenium.chrome.ChromeOptions;

public class BaseTest {

    public WebDriver driver;

    @BeforeMethod
    public void setup() {

        String browser = ConfigReader.getProperty("browser");

        if(browser.equals("chrome")) {

            WebDriverManager.chromedriver().setup();

            ChromeOptions options = new ChromeOptions();

            options.addArguments("--disable-notifications");
            options.addArguments("--disable-save-password-bubble");
            options.addArguments("--disable-infobars");

            driver = new ChromeDriver(options);
        }

        driver.manage().window().maximize();

        driver.get(ConfigReader.getProperty("url"));
    }

    @AfterMethod
    public void tearDown(ITestResult result) {

        if(result.getStatus() == ITestResult.FAILURE) {

            ScreenshotUtil.takeScreenshot(driver, result.getName());

        }

        driver.quit();
    }
    public void waitForSeconds(int seconds) {

        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}