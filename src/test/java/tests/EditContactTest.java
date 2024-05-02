package tests;

import config.AppiumConfig;
import helpers.AddressGenerator;
import helpers.EmailGenerator;
import helpers.NameAndLastNameGenerator;
import helpers.PhoneNumberGenerator;
import models.Contact;
import org.testng.Assert;
import org.testng.annotations.Test;
import screens.ContactListScreen;
import screens.EditContactScreen;
import screens.SplashScreen;

public class EditContactTest extends AppiumConfig {

    @Test
    public void editContact() {
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
                "desc");

        contactListScreen.openNewContactForm().fillForm(contact).createContact();

        Assert.assertTrue(contactListScreen.editContact().fillFormEditContact(contact)
                .updateSaveContact().isContactUpdated());

    }
}
