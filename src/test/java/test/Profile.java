package test;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.EditProfilePage;
import pages.LoginPage;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Profile extends TestLifeCycle{

    @Test(description = "Modificar correctamente datos de perfil de usuario")
    public void updateProfileSuccessful(){

        LoginPage loginPage = new LoginPage(driver);
        loginPage.tryLogin("xabras123@hotmail.com", "12752223");
        String webURLToTestForTest = "https://www.3djuegos.com/comunidad.php?zona=preferencias_mi_perfil";
        By succesfullText = By.xpath("//form[@name=\"pref\"]//p[1]");
        String textToCompare = "Los datos de tu perfil han sido guardados";
        driver.get(webURLToTestForTest);
        EditProfilePage editProfilePage = new EditProfilePage(driver);
        String hobbieText = "Mi hobby preferido es... " + new Date() + "\n";
        List<Integer> checkboxesToSelect = new ArrayList<Integer>();
        checkboxesToSelect.add(0);
        checkboxesToSelect.add(1);
        editProfilePage.updateProfile( checkboxesToSelect, 1, 2, hobbieText);
        System.out.println(driver.findElement(succesfullText).getText());
        Assert.assertTrue(driver.findElement(succesfullText).getText().toLowerCase().contains(textToCompare.toLowerCase()), "Test donde una vez hecho login, el usuario peuda editar sus preferencias de perfil");

    }
}
