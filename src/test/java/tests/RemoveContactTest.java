package tests;

import config.AppiumConfig;
import helpers.AddressGenerator;
import helpers.EmailGenerator;
import helpers.NameAndLastNameGenerator;
import helpers.PhoneNumberGenerator;
import io.appium.java_client.MobileElement;
import models.Contact;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.annotations.Test;
import screens.ContactListScreen;
import screens.SplashScreen;

public class RemoveContactTest extends AppiumConfig {

    @Test
    public void removeContact() {
        ContactListScreen contactListScreen = new SplashScreen(driver)
                .switchToAuthScreen()
                .fillEmailField("poikhaf770@mail.rud")
                .fillPasswordField("Aa1234567$")
                .clickByLoginButton();

        Contact contact = new Contact(NameAndLastNameGenerator.generateName(),
                NameAndLastNameGenerator.generateLastName(),
                EmailGenerator.generateEmail(5,5,3),
                PhoneNumberGenerator.generatePhoneNumber(),
                AddressGenerator.generateAddress(),
                "Descr");

        contactListScreen.openNewContactForm().fillForm(contact).createContact();
        Assert.assertTrue(contactListScreen.removeAContact().isContactRemoved());


    }

    @Test
    public void removeAllContacts() {
        ContactListScreen contactListScreen = new SplashScreen(driver)
                .switchToAuthScreen()
                .fillEmailField("poikhaf770@mail.rud")
                .fillPasswordField("Aa1234567$")
                .clickByLoginButton();

        Assert.assertTrue(contactListScreen.removeAllContacts().isNoContactsMessage());

    }

}

//дз - реализовать сдвиг влево - редактирование
//Вынести эту штуку в БефореТест
//ContactListScreen contactListScreen = new SplashScreen(driver)
//        .switchToAuthScreen()
//        .fillEmailField("poikhaf770@mail.rud")
//        .fillPasswordField("Aa1234567$")
//        .clickByLoginButton();
