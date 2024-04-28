package screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import models.Contact;
import org.openqa.selenium.support.FindBy;

public class AddNewContactScreen extends BaseScreen{
    public AddNewContactScreen(AppiumDriver<MobileElement> driver) {
        super(driver);
    }
@FindBy(id = "com.sheygam.contactapp:id/inputName")
MobileElement inputNameField;

@FindBy(id = "com.sheygam.contactapp:id/inputLastName")
MobileElement inputLastnameField;

@FindBy(id = "com.sheygam.contactapp:id/inputEmail")
MobileElement inputEmailField;

@FindBy(id = "com.sheygam.contactapp:id/inputPhone")
MobileElement inputPhoneField;
@FindBy(id = "com.sheygam.contactapp:id/inputAddress")
MobileElement inputAddressField;
@FindBy(id = "com.sheygam.contactapp:id/inputDesc")
MobileElement inputDescField;
@FindBy(id = "com.sheygam.contactapp:id/createBtn")
 MobileElement createButton;

@FindBy(xpath = "//*[@resource-id='com.sheygam.contactapp:id/action_bar']/android.widget.TextView")
static MobileElement titleText;


public void fillForm(Contact contact) {
inputNameField.sendKeys(contact.getName());
inputLastnameField.sendKeys(contact.getLastName());
inputEmailField.sendKeys(contact.getEmail());
inputPhoneField.sendKeys(contact.getPhone());
inputAddressField.sendKeys(contact.getAddress());
inputDescField.sendKeys(contact.getDescription());
createButton.click();
}

//public void createContact() {
//createButton.click();
//}

public static boolean isContactAdded() {
    return titleText.isDisplayed();
}


//найти все поля с помощью ФайндБай и создать метод-  fillForm(contact)
//                .createContact()
//                .isContactAdded();

}
