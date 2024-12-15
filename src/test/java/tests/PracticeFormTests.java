package tests;

import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

public class PracticeFormTests extends TestBase {

    RegistrationPage registrationPage = new RegistrationPage();

    @Test
    void fillAllFieldsFormTest() {
        registrationPage.openPage()
                .removeBanners()
                .setFirstName("Myname")
                .setLastName("Mylastname")
                .setEmail("someemail@gmail.com")
                .setGender("Female")
                .setMobileNumber("9032223344")
                .setDateOfBirth("02", "April", "2000")
                .setSubject("Phy")
                .setHobbies("Sports")
                .uploadPictures("cat.jpg")
                .setCurrentAddress("Noname str.")
                .setStateAndCity("Rajasthan", "Jaipur")
                .submitForm();

        registrationPage.verifySubmittedDialogAppears()
                .verifyResults("Student Name", "Myname Mylastname")
                .verifyResults("Student Email", "someemail@gmail.com")
                .verifyResults("Gender", "Female")
                .verifyResults("Mobile", "9032223344")
                .verifyResults("Date of Birth", "02 April,2000")
                .verifyResults("Subjects", "Physics")
                .verifyResults("Hobbies", "Sports")
                .verifyResults("Picture", "cat.jpg")
                .verifyResults("Address", "Noname str.")
                .verifyResults("State and City", "Rajasthan Jaipur");
    }

    @Test
    void fillOnlyRequiredFieldsFormTest() {
        registrationPage.openPage()
                .removeBanners()
                .setFirstName("Myname")
                .setLastName("Mylastname")
                .setGender("Female")
                .setMobileNumber("9032223344")
                .setDateOfBirth("02", "April", "2000")
                .submitForm();

        registrationPage.verifySubmittedDialogAppears()
                .verifyResults("Student Name", "Myname Mylastname")
                .verifyResults("Gender", "Female")
                .verifyResults("Mobile", "9032223344")
                .verifyResults("Date of Birth", "02 April,2000");
    }

    @Test
    void negativeFillFormTest() {
        registrationPage.openPage()
                .removeBanners()
                .setFirstName("Myname")
                .setLastName("Mylastname")
                .setGender("Female")
                .setMobileNumber("90322233")
                .setDateOfBirth("02", "April", "2000")
                .submitForm();

        registrationPage.verifyNoSubmittedDialogAppears();
    }
}
