package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    private WebDriver driver;

    @FindBy(how= How.NAME, using="login_email")
    private WebElement usernameField;
    @FindBy(how= How.NAME, using="login_password")
    private WebElement passwordField;
    @FindBy(how= How.ID, using="login_boton_enviar")
    private WebElement loginButton;

    public LoginPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
        //this.usernameField = By.name("login_email");
        //this.passwordField = By.name("login_password");
        //this.loginButton = By.id("login_boton_enviar");
    }

    public void tryLogin(String username, String password){
        usernameField.sendKeys(username);
        passwordField.sendKeys(password);
        loginButton.click();
    }
}
