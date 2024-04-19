package tests;

import config.AppiumConfig;
import helpers.AddressGenerator;
import helpers.EmailGenerator;
import helpers.NameAndLastNameGenerator;
import helpers.PhoneNumberGenerator;
import models.Contact;
import org.testng.annotations.Test;
import screens.ContactListScreen;
import screens.SplashScreen;

public class AddNewContactTest extends AppiumConfig {
    @Test
    public void addNewContact() {
        new SplashScreen(driver).switchToAuthScreen()
                .fillEmailField("test1411@mail.com")
                .fillPasswordField("Aa123456$")
                .clickByLoginButton();

        Contact contact = new Contact(NameAndLastNameGenerator.generateName(),
                NameAndLastNameGenerator.generateLastName(),
                PhoneNumberGenerator.generatePhoneNumber(),
                EmailGenerator.generateEmail(5,5,3),
                AddressGenerator.generateAddress(),
                "Descr");

//        new ContactListScreen(driver).openNewContactForm().fillForm(contact)
//                .createContact()
//                .isContactAdded();

    }

}
