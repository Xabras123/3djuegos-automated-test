package test;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.EditProfilePage;
import pages.LoginPage;
import utils.Screenshot;
import utils.Utils;
import utils.WebDriverController;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

public class Login extends TestLifeCycle{


    @Test(description = "Login con credenciales incorrectas")
    public void testFalureLogin(){

        By falureText =  By.xpath("//div[@class=\"s18 b\"]");
        String textToCompare = "incorrecta";
        LoginPage loginPage = new LoginPage(driver);
        loginPage.tryLogin("xabras123@hotmail.com", "82751483");
        WebElement loginFalureText = driver.findElement(falureText);
        System.out.println(loginFalureText.getText().toLowerCase() + " " + textToCompare);
        Assert.assertTrue(loginFalureText.getText().toLowerCase().contains(textToCompare), "Test donde se quiere probar que dado un usuario y password incorrectos, la pagina no permita hacer login");

    }


    @Test(description = "Login con credenciales correctas")
    public void testSuccessLogin(){

        String textToCompare = "xabras123";
        By successText = By.xpath("//a[@class=\"xXx s14 cF mar_t2 dib b\"]");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.tryLogin("xabras123@hotmail.com", "8627124123");
        WebElement loginFalureText = driver.findElement(successText);
        Screenshot screenshot = new Screenshot(driver);
        screenshot.takeScreenshot("Succesful login");
        Assert.assertTrue(loginFalureText.getText().toLowerCase().contains(textToCompare), "Test donde se quiere probar que dado un usuario y password incorrectos, la pagina permita hacer login");


    }







}
