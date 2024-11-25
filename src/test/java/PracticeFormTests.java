import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$;

public class PracticeFormTests {

    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.pageLoadStrategy = "eager";
    }

    @Test
    void fillStudentRegistrationFormTest() {
        open("/automation-practice-form");
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");

        $("#firstName").setValue("Anastasia");
        $("#lastName").setValue("Lyulol");
        $("#userEmail").setValue("lyulol@gmail.com");
        $("#genterWrapper").$(byText("Female")).click();
        $("#userNumber").setValue("9032223344");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").click();
        $(".react-datepicker__month-select").selectOption("April");
        $(".react-datepicker__year-select").click();
        $(".react-datepicker__year-select").selectOption("1990");
        $(".react-datepicker__day--002").click();
        $("#subjectsInput").setValue("Phy").pressEnter();
        $("#hobbiesWrapper").$(byText("Sports")).click();
        $("#uploadPicture").uploadFromClasspath("cat.jpg");
        $("#currentAddress").setValue("Noname str.");
        $("#react-select-3-input").setValue("Rajasthan").pressEnter();
        $("#react-select-4-input").setValue("Jaipur").pressEnter();
        $("#submit").click();

        $(".table").$(byText("Student Name")).sibling(0).shouldHave(text("Anastasia Lyulol"));
        $(".table").$(byText("Student Email")).sibling(0).shouldHave(text("lyulol@gmail.com"));
        $(".table").$(byText("Gender")).sibling(0).shouldHave(text("Female"));
        $(".table").$(byText("Mobile")).sibling(0).shouldHave(text("9032223344"));
        $(".table").$(byText("Date of Birth")).sibling(0).shouldHave(text("02 April,1990"));
        $(".table").$(byText("Subjects")).sibling(0).shouldHave(text("Physics"));
        $(".table").$(byText("Hobbies")).sibling(0).shouldHave(text("Sports"));
        $(".table").$(byText("Picture")).sibling(0).shouldHave(text("cat.jpg"));
        $(".table").$(byText("Address")).sibling(0).shouldHave(text("Noname str."));
        $(".table").$(byText("State and City")).sibling(0).shouldHave(text("Rajasthan Jaipur"));
    }


}
