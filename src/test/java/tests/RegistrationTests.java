package tests;

import config.AppiumConfig;
import helpers.EmailGenerator;
import helpers.PasswordStringGenerator;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.annotations.Test;
import screens.AuthenticationScreen;
import screens.BaseScreen;
import screens.ContactListScreen;
import screens.SplashScreen;

import java.util.List;

public class RegistrationTests extends AppiumConfig {

    @Test
    public void registrationNewUserTest() throws InterruptedException {
        ContactListScreen contactListScreen = new SplashScreen(driver)
                .switchToAuthScreen()
                .fillEmailField(EmailGenerator.generateEmail(5,5,3))
                .fillPasswordField(PasswordStringGenerator.generateString())
                .clickByRegistrationButton();

        Assert.assertTrue(contactListScreen.isContactListPresent());
    }


    @Test
public void registrationWrongEmailNegative() throws InterruptedException {
        AuthenticationScreen authenticationScreen = new SplashScreen(driver)
                .switchToAuthScreen()
                .fillEmailField("hggffmauk.com")
                .fillPasswordField("Aa12345$")
                .clickByRegistrationButton();

        List<MobileElement> list =
                driver.findElements(By.id("android:id/alertTitle"));
        if(list.size() > 0){
            driver.findElement(By.id("android:id/button1")).click();
        }

       Assert.assertTrue(authenticationScreen.isItAuthenticationScreen());

    }

}
