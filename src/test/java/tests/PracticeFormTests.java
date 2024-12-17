package tests;

import org.junit.jupiter.api.Test;
import pages.RegistrationPage;
import utils.TestData;

public class PracticeFormTests extends TestBase {

    RegistrationPage registrationPage = new RegistrationPage();
    TestData testData = new TestData();

    @Test
    void fillAllFieldsFormTest() {
        registrationPage.openPage()
                .removeBanners()
                .setFirstName(testData.firstName)
                .setLastName(testData.lastName)
                .setEmail(testData.email)
                .setGender(testData.gender)
                .setMobileNumber(testData.mobileNumber)
                .setDateOfBirth(testData.dayOfBirth, testData.monthOfBirth, testData.yearOfBirth)
                .setSubject(testData.subject)
                .setHobbies(testData.hobby)
                .uploadPicture(testData.picture)
                .setCurrentAddress(testData.address)
                .setStateAndCity(testData.state, testData.city)
                .submitForm();

        registrationPage.verifySubmittedDialogAppears()
                .verifyResults("Student Name", testData.firstName + " " + testData.lastName)
                .verifyResults("Student Email", testData.email)
                .verifyResults("Gender", testData.gender)
                .verifyResults("Mobile", testData.mobileNumber)
                .verifyResults("Date of Birth", testData.dayOfBirth + " " + testData.monthOfBirth + "," + testData.yearOfBirth)
                .verifyResults("Subjects", testData.subject)
                .verifyResults("Hobbies", testData.hobby)
                .verifyResults("Picture", testData.picture)
                .verifyResults("Address", testData.address)
                .verifyResults("State and City", testData.state + " " + testData.city);
    }

    @Test
    void fillOnlyRequiredFieldsFormTest() {
        registrationPage.openPage()
                .removeBanners()
                .setFirstName(testData.firstName)
                .setLastName(testData.lastName)
                .setGender(testData.gender)
                .setMobileNumber(testData.mobileNumber)
                .setDateOfBirth(testData.dayOfBirth, testData.monthOfBirth, testData.yearOfBirth)
                .submitForm();

        registrationPage.verifySubmittedDialogAppears()
                .verifyResults("Student Name", testData.firstName + " " + testData.lastName)
                .verifyResults("Gender", testData.gender)
                .verifyResults("Mobile", testData.mobileNumber)
                .verifyResults("Date of Birth", testData.dayOfBirth + " " + testData.monthOfBirth + "," + testData.yearOfBirth);
    }

    @Test
    void negativeFillFormTest() {
        registrationPage.openPage()
                .removeBanners()
                .setFirstName(testData.firstName)
                .setLastName(testData.lastName)
                .setGender(testData.gender)
                .setMobileNumber(" ")
                .setDateOfBirth(testData.dayOfBirth, testData.monthOfBirth, testData.yearOfBirth)
                .submitForm();

        registrationPage.verifyNoSubmittedDialogAppears();
    }
}
