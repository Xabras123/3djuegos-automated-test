package utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

public class Screenshot {

    private WebDriver driver;



    public Screenshot(WebDriver driver) {
        this.driver = driver;
    }

    public String takeScreenshot(String pageName){

        File myScreenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        String fileName = pageName + System.currentTimeMillis() + ".png";



        try {

            String dirName = "test-screenshots";
            FileUtils.copyFile(myScreenshot, new File(dirName + "/" + fileName));
            return fileName;

        } catch (IOException e) {
            e.printStackTrace();
            return "";
        }

    }
}
