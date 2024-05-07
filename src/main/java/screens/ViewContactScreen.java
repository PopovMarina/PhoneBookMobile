package screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import models.Contact;
import org.openqa.selenium.support.FindBy;

public class ViewContactScreen extends BaseScreen {

    @FindBy(id = "com.sheygam.contactapp:id/nameTxt")
    MobileElement nameText;

    @FindBy(id = "com.sheygam.contactapp:id/lastNameTxt")
    MobileElement lastnameText;

    @FindBy(id = "com.sheygam.contactapp:id/emailTxt")
    MobileElement emailText;

    @FindBy(id = "com.sheygam.contactapp:id/phoneTxt")
    MobileElement phoneText;
    @FindBy(id = "com.sheygam.contactapp:id/addressTxt")
    MobileElement addressText;
    @FindBy(id = "com.sheygam.contactapp:id/descTxt")
    MobileElement descText;

    public ViewContactScreen(AppiumDriver<MobileElement> driver) {
        super(driver);
    }

    public Contact viewContactObject() {
        Contact contact = new Contact(nameText.getText(),
                lastnameText.getText(),
                emailText.getText(),
                phoneText.getText(),
                addressText.getText(),
                descText.getText());
        return contact;

    }
}