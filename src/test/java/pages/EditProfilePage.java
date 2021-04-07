package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.util.ArrayList;
import java.util.List;

public class EditProfilePage {

    private WebDriver driver;
    private By preferedPlatformCheckboxes;
    private By preferedGameGenre1Dropdown;
    private By preferedGameGenre2Dropdown;
    private By otherHobbiesField;
    private By saveChangesButton;

    public EditProfilePage(WebDriver driver){
        this.driver = driver;
        //this.preferedPlatform1Checkbox = By.xpath("//input[@id=\"plataforma40\"]");
        this.preferedPlatformCheckboxes = By.xpath("//input[@type=\"checkbox\" and starts-with(@id,\"plataform\")]");
        //this.preferedGameGenre1Dropdown = By.xpath("//option[@value=\"6\"]");
        this.preferedGameGenre1Dropdown = By.xpath("//select[@id=\"pref_jugandor_de_0\"]");
        this.preferedGameGenre2Dropdown = By.xpath("//select[@id=\"pref_jugandor_de_1\"]");
        this.otherHobbiesField = By.name("pref_otros");
        this.saveChangesButton = By.xpath("//a[@class=\"boton b_s14 mar_r10\"]");

    }

    public void updateProfile(List<Integer> checkboxesToSelect, int preferedGameGenre1Index, int preferedGameGenre2Index, String otherHobbies){
        //driver.findElement(preferedPlatform2Checkbox).click();
        selectDropdownElement(preferedGameGenre1Index, preferedGameGenre1Dropdown);
        selectDropdownElement(preferedGameGenre2Index, preferedGameGenre2Dropdown);
        //driver.findElement(preferedGameGenre1Dropdown).sendKeys(preferedGameGenre1Index);
        //driver.findElement(preferedGameGenre2Dropdown).sendKeys(preferedGameGenre2Index);
        System.out.println(driver.findElements(preferedPlatformCheckboxes));
        selectCheckboxElements(checkboxesToSelect);
        driver.findElement(otherHobbiesField).sendKeys(otherHobbies);
        driver.findElement(saveChangesButton).click();
    }

    private void selectDropdownElement(int index, By elementsDropdown){

        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement dropDrownItems = wait.until(ExpectedConditions.presenceOfElementLocated(elementsDropdown));
        Select selectedItem = new Select(dropDrownItems);
        selectedItem.selectByIndex(index);

    }

    private void selectCheckboxElements(List<Integer> checkboxesToSelect){


        List<WebElement> checkboxes = driver.findElements(this.preferedPlatformCheckboxes);
        List<Integer> validCheckboxesToSelect = new ArrayList<Integer>();
        for(int checkboxToSelect : checkboxesToSelect){

            if(checkboxToSelect < checkboxes.size() - 1){
                validCheckboxesToSelect.add(checkboxToSelect);
            }
        }

        for(int validCheckboxToSelect : validCheckboxesToSelect) {

            checkboxes.get(validCheckboxToSelect).click();
        }

    }


}
