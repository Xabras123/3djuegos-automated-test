package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.LoginPage;
import utils.Screenshot;
import utils.Utils;
import utils.WebDriverController;

import java.util.concurrent.TimeUnit;

public class TestLifeCycle {

    protected WebDriver driver;
    protected String webURLToTest;
    protected WebDriverController webDriverController;

    @BeforeMethod
    public void setUp(){


        webURLToTest =  "https://www.3djuegos.com/foros/index.php?zona=iniciar_sesion";
        DesiredCapabilities caps = new DesiredCapabilities();
        String deviceOS = Utils.detectOS();
        System.setProperty("webdriver.chrome.driver", deviceOS);
        ChromeOptions chromeOptions = new ChromeOptions();
        //chromeOptions.addArguments("--headless");
        driver = new ChromeDriver(chromeOptions);
        WebDriverWait wait = new WebDriverWait(driver,20);
        //driver.manage().window().maximize();
        //driver.manage().window().setSize(new Dimension(1348, 768));
        //driver.manage().window().setPosition(new Point(10,20));
        webDriverController = new WebDriverController(driver);
        webDriverController.setWindowsSizeToMaximum();
        driver.get(webURLToTest);
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        wait.until(ExpectedConditions.elementToBeClickable(By.id("didomi-notice-agree-button"))).click();

    }


    @AfterMethod
    public void tearDown(ITestResult testResult){

        if(!testResult.isSuccess()){
            Screenshot screenshot = new Screenshot(driver);
            screenshot.takeScreenshot("Error ocurred");
        }
        driver.close();
    }
}
