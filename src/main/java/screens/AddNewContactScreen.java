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



public AddNewContactScreen fillForm(Contact contact) {
waitForAnElement(createButton);
inputNameField.sendKeys(contact.getName());
driver.hideKeyboard();//скрывает клавиатуру
inputLastnameField.sendKeys(contact.getLastName());
driver.hideKeyboard();
inputEmailField.sendKeys(contact.getEmail());
driver.hideKeyboard();
inputPhoneField.sendKeys(contact.getPhone());
driver.hideKeyboard();
inputAddressField.sendKeys(contact.getAddress());
driver.hideKeyboard();
inputDescField.sendKeys(contact.getDescription());
driver.hideKeyboard();
//createButton.click();
return this;
}

public ContactListScreen createContact() {
createButton.click();
return new ContactListScreen(driver);
}

//public static boolean isContactAdded() {
//    return titleText.isDisplayed();
//}


}
