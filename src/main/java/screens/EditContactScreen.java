package screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import models.Contact;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class EditContactScreen extends BaseScreen{

    public EditContactScreen(AppiumDriver<MobileElement> driver) {
        super(driver);
    }
    @FindBy(id = "com.sheygam.contactapp:id/inputName")
    MobileElement inputNameEditField;
    @FindBy(id = "com.sheygam.contactapp:id/inputLastName")
    MobileElement inputLastNameEditField;
    @FindBy(id = "com.sheygam.contactapp:id/inputEmail")
    MobileElement inputEmailEditField;
    @FindBy(id = "com.sheygam.contactapp:id/inputPhone")
    MobileElement inputPhoneEditField;
    @FindBy(id = "com.sheygam.contactapp:id/inputAddress")
    MobileElement inputAddressEditField;
    @FindBy(id = "com.sheygam.contactapp:id/inputDesc")
    MobileElement inputDescrEditField;
    @FindBy(id = "com.sheygam.contactapp:id/updateBtn")
    MobileElement updateButton;
    @FindBy(id = "com.sheygam.contactapp:id/createBtn")
    MobileElement createButton;
    @FindBy(xpath = "//*[@resource-id='com.sheygam.contactapp:id/rowPhone']")
    List<MobileElement> rowPhone;


//    public EditContactScreen fillFormEditContact(Contact contact)
//    {
//    //waitForAnElement(createButton);
//    inputNameEditField.sendKeys(contact.getName());
//    driver.hideKeyboard();
//    inputLastNameEditField.sendKeys("Petrov");
//    driver.hideKeyboard();
//    inputEmailEditField.sendKeys(contact.getEmail());
//    driver.hideKeyboard();
//    inputPhoneEditField.sendKeys(contact.getPhone());
//    driver.hideKeyboard();
//    inputAddressEditField.sendKeys(contact.getAddress());
//    driver.hideKeyboard();
//    inputDescrEditField.sendKeys(contact.getDescription());
//    return this;
//    }
//
//
//    public ContactListScreen updateSaveContact() {//возвращает КонтактЛист как результат работы метода
//        updateButton.click();
//        return new ContactListScreen(driver);
//    }

//    public int sum(int x, int y) {
//        int res = x + y;
//        return res;
//    }

    public ContactListScreen submitChanges() {
        updateButton.click();
        return new ContactListScreen(driver);
    }
    public EditContactScreen editEmailField(String email) {
        waitForAnElement(updateButton);
        inputEmailEditField.clear();
        inputEmailEditField.sendKeys(email);
        return this;
    }

}
