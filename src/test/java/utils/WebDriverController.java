package utils;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;

public class WebDriverController {

    WebDriver driver;

    public WebDriverController(WebDriver driver) {
        this.driver = driver;
    }

    public  void setWindowsSizeToFullscreen(){

        this.driver.manage().window().setSize(new Dimension(1348, 768));
    }

    public  void setWindowsSizeToMaximum(){
        this.driver.manage().window().maximize();
    }

    public void setWindowsSize(int x, int y){
        this.driver.manage().window().setSize(new Dimension(x, y));

    }
}
