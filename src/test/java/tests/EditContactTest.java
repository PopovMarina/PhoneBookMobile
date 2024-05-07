package tests;

import config.AppiumConfig;
import helpers.AddressGenerator;
import helpers.EmailGenerator;
import helpers.NameAndLastNameGenerator;
import helpers.PhoneNumberGenerator;
import models.Contact;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import screens.ContactListScreen;
import screens.EditContactScreen;
import screens.SplashScreen;

public class EditContactTest extends AppiumConfig {

/*    чтобы не писать каждый раз данные юзера и пароль для входа -
      можно создать БефорТест и вызывать его перед всеми тестами:
@BeforeTest
    public void precondition(){
        new SplashScreen(driver)
                .switchToAuthScreen()
                .fillEmailField("mymegamail@mail.com")
                .fillPasswordField("MyPassword123!")
                .clickByLoginButton();
*/

//    @Test
//    public void editContact() {
//        ContactListScreen contactListScreen = new SplashScreen(driver)
//                .switchToAuthScreen()
//                .fillEmailField("poikhaf770@mail.rud")
//                .fillPasswordField("Aa1234567$")
//                .clickByLoginButton();
//
//        Contact contact = new Contact(NameAndLastNameGenerator.generateName(),
//                NameAndLastNameGenerator.generateLastName(),
//                EmailGenerator.generateEmail(5,5,3),
//                PhoneNumberGenerator.generatePhoneNumber(),
//                AddressGenerator.generateAddress(),
//                "desc");
//
//        contactListScreen.openNewContactForm().fillForm(contact).createContact();
//
//        Assert.assertTrue(contactListScreen.editContact().fillFormEditContact(contact)
//                .updateSaveContact().isContactUpdated());
//
//    }

    @Test
    public void editContactMailPositive() {
        String text = "updateMail@mail.com";
        new SplashScreen(driver)
                .switchToAuthScreen()
                .fillEmailField("poikhaf770@mail.rud")
                .fillPasswordField("Aa1234567$")
                .clickByLoginButton();

        Assert.assertTrue(new ContactListScreen(driver).editOneContact()
                .editEmailField(text)
                .submitChanges()
                .isContactContainsText(text));
    }


    @Test
    public void editAnyContactYouWant() {
     //   String text = EmailGenerator.generateEmail(5,5,3);
        new SplashScreen(driver).switchToAuthScreen()
                .fillEmailField("poikhaf770@mail.rud")
                .fillPasswordField("Aa1234567$")
                .clickByLoginButton();


    Contact contact = new Contact(
            NameAndLastNameGenerator.generateName(),
            NameAndLastNameGenerator.generateLastName(),
            EmailGenerator.generateEmail(3,3,3),
            PhoneNumberGenerator.generatePhoneNumber(),
            AddressGenerator.generateAddress(),
            "Description"
    );
  Assert.assertTrue(new ContactListScreen(driver)
          .openNewContactForm()
          .fillForm(contact)
          .createContact()
          .isContactAddedScroll(contact));
    }
}
