package tests;

import config.AppiumConfig;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import screens.AuthenticationScreen;
import screens.ContactListScreen;
import screens.SplashScreen;

import java.util.List;

public class LoginTest extends AppiumConfig {
    @Test
    public void loginPositive() {
        ContactListScreen contactListScreen = new SplashScreen(driver)
                .switchToAuthScreen()
                .fillEmailField("poikhaf770@mail.rud")
                .fillPasswordField("Aa1234567$")
                .clickByLoginButton();

        AuthenticationScreen authenticationScreen = contactListScreen.logout();
        Assert.assertTrue(authenticationScreen.isItAuthenticationScreen());
    }

    @Test
    public void loginNegative(){
       AuthenticationScreen authenticationScreen = new SplashScreen(driver)
               .switchToAuthScreen()
               .fillEmailField("poikf770@mail.rud")
               .fillPasswordField("Aa1234567$")
               .clickByLoginButton();

       List<MobileElement> list =
               driver.findElements(By.id("android:id/alertTitle"));
       if(list.size() > 0) {
           driver.findElement(By.id("android:id/button1")).click();
       }
       Assert.assertTrue(authenticationScreen.isItAuthenticationScreen());
    }

}
