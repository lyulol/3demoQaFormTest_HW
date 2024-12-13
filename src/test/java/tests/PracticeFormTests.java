package tests;

import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$;

public class PracticeFormTests extends TestBase {

    RegistrationPage registrationPage = new RegistrationPage();

    @Test
    void fillAllFieldsFormTest() {
        registrationPage.openPage()
                .removeBanners()
                .fillTextField(registrationPage.firstNameInput, "Myname")
                .fillTextField(registrationPage.lastNameInput, "Mylastname")
                .fillTextField(registrationPage.userEmailInput, "someemail@gmail.com")
                .setGender("Female")
                .fillTextField(registrationPage.userNumberInput, "9032223344")
                .setDateOfBirth("02", "April", "2000")
                .setSubject("Phy")
                .setHobbies("Sports")
                .uploadPictures("cat.jpg")
                .fillTextField(registrationPage.currentAddressInput, "Noname str.")
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
                .fillTextField(registrationPage.firstNameInput, "Myname")
                .fillTextField(registrationPage.lastNameInput, "Mylastname")
                .setGender("Female")
                .fillTextField(registrationPage.userNumberInput, "9032223344")
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
                .fillTextField(registrationPage.firstNameInput, "Myname")
                .fillTextField(registrationPage.lastNameInput, "Mylastname")
                .setGender("Female")
                .fillTextField(registrationPage.userNumberInput, "90322233")
                .setDateOfBirth("02", "April", "2000")
                .submitForm();

        registrationPage.verifyNoSubmittedDialogAppears();
    }

}
