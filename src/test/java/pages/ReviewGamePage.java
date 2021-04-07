package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ReviewGamePage {

    private WebDriver driver;
    private By reviewTitleField;
    private By reviewField;
    private By loginButton;

    public ReviewGamePage(WebDriver driver){
        this.driver = driver;
        this.reviewTitleField = By.name("login_email");
        this.reviewField = By.name("login_password");
        this.loginButton = By.id("login_boton_enviar");
    }

    public void tryLogin(String username, String password){
        driver.findElement(reviewTitleField).sendKeys(username);
        driver.findElement(reviewField).sendKeys(password);
        driver.findElement(loginButton).click();
    }
}

