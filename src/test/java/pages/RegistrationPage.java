package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

import pages.components.CalendarComponent;
import pages.components.ResultComponent;

public class RegistrationPage {

    public SelenideElement practiceFormLocator = $(".practice-form-wrapper"),
                            firstNameInput = $("#firstName"),
                            lastNameInput = $("#lastName"),
                            userEmailInput = $("#userEmail"),
                            genderRadioButtons = $("#genterWrapper"),
                            userNumberInput = $("#userNumber"),
                            calendarInput = $("#dateOfBirthInput"),
                            subjectsInput = $("#subjectsInput"),
                            hobbiesCheckboxes = $("#hobbiesWrapper"),
                            uploadPictureLocator = $("#uploadPicture"),
                            currentAddressInput = $("#currentAddress"),
                            stateInput = $("#state"),
                            cityInput = $("#city"),
                            submitButton = $("#submit");

    CalendarComponent calendarComponent = new CalendarComponent();
    ResultComponent resultComponent = new ResultComponent();

    public RegistrationPage openPage() {
        open("/automation-practice-form");
        practiceFormLocator.shouldHave(text("Student Registration Form"));

        return this;
    }

    public RegistrationPage removeBanners() {
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");

        return this;
    }

    public RegistrationPage fillTextField(SelenideElement selector, String value) {
        $(selector).setValue(value);

        return this;
    }

    public RegistrationPage setGender(String value) {
        genderRadioButtons.$(byText(value)).click();

        return this;
    }

    public RegistrationPage setDateOfBirth(String day, String month, String year) {
        calendarInput.click();
        calendarComponent.setDate(day, month, year);

        return this;
    }

    public RegistrationPage setSubject(String value) {
        subjectsInput.setValue(value).pressEnter();

        return this;
    }

    public RegistrationPage setHobbies(String value) {
        hobbiesCheckboxes.$(byText(value)).click();

        return this;
    }

    public RegistrationPage uploadPictures(String path) {
        uploadPictureLocator.uploadFromClasspath(path);

        return this;
    }

    public RegistrationPage setStateAndCity(String state, String city) {
        stateInput.click();
        stateInput.$(byText(state)).click();
        cityInput.click();
        cityInput.$(byText(city)).click();

        return this;
    }

    public void submitForm() {
        submitButton.click();
    }

    public RegistrationPage verifySubmittedDialogAppears() {
        resultComponent.verifySuccessfullDialogAppears();

        return this;
    }

    public RegistrationPage verifyNoSubmittedDialogAppears() {
        resultComponent.verifyNoDialogAppears();

        return this;
    }

    public RegistrationPage verifyResults(String key, String value) {
        resultComponent.verifyTableResults(key, value);

        return this;
    }

}
