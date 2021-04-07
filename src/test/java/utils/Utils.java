package utils;

public class Utils {

    public static String detectOS(){

        if(System.getProperty("os.name").contains("Windows") ||System.getProperty("os.name").equals("Windows 10")){
            return "drivers/chromedriver.exe";
        }else {
            return "drivers/chromedriver";
        }
    }
}
