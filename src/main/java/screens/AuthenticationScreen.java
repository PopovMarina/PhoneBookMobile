package screens;

import config.AppiumConfig;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class AuthenticationScreen extends BaseScreen{

    public AuthenticationScreen(AppiumDriver<MobileElement> driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[@resource-id='com.sheygam.contactapp:id/action_bar']/android.widget.TextView")
    MobileElement titleText;
    @FindBy(id = "com.sheygam.contactapp:id/inputEmail")
    MobileElement inputEmailField;
    @FindBy(id = "com.sheygam.contactapp:id/inputPassword")
    MobileElement inputPasswordField;
    @FindBy(id = "com.sheygam.contactapp:id/regBtn")
    MobileElement registrationButton;
    @FindBy(id = "com.sheygam.contactapp:id/loginBtn")
    MobileElement loginButton;


    //    By.xpath("//*[@resource-id='com.sheygam.contactapp:id/action_bar']" +
    //            "/android.widget.TextView")
    // second by class
    // By.xpath("//*[@resource-id='com.sheygam.contactapp:id/action_bar']/..");
    // one level up
    // By.xpath("//*[@resource-id='com.sheygam.contactapp:id/action_bar']/../..");
    // 2 levels up

    public AuthenticationScreen fillEmailField(String email) {
        waitForAnElement(inputEmailField);
        inputEmailField.sendKeys(email);
        return this;
    }
    public AuthenticationScreen fillPasswordField(String password) {
        inputPasswordField.sendKeys(password);
        return this;
    }
    @SuppressWarnings("unchecked")
    public <T extends BaseScreen> T clickByLoginButton() {
        //метод, который может возвращать 2 сущности, которые наследуются от обшего предка BaseScreen
        //Т - это обобщенный класс(какая-то страница, которая наследуется от BaseScreen
        //это делается для выбора

        loginButton.click();
        List<MobileElement> list = driver
                .findElements(By.xpath("//*[@resource-id='android:id/alertTitle']"));
        if(list.size()>0){
            driver.findElement(By.xpath("//*[@resource-id='android:id/button1']")).click();
            return (T)new AuthenticationScreen(driver);
        }
        return (T)new ContactListScreen(driver);
    }
    public boolean isItAuthenticationScreen(){
        return titleText.isDisplayed();
    }
@SuppressWarnings("unchecked")
    public <T extends BaseScreen> T clickByRegistrationButton() throws InterruptedException {
        registrationButton.click();
        Thread.sleep(3000);

//разница между findElement и findElements:
//        try{
//            WebElement element = driver.findElement(By.id("android:id/alertTitle"));
//            return  (T)new AuthenticationScreen(driver);
//        } catch (Exception e){
//            e.printStackTrace();
//            return (T) new ContactListScreen(driver);
//        }

        List<MobileElement> list = driver.findElements(By.id("android:id/alertTitle"));
        if(list.size() > 0) {
            driver.findElement(By.id("android:id/button1")).click();
            return (T) new AuthenticationScreen(driver);
        }else {return (T) new ContactListScreen(driver);}
    }

}


