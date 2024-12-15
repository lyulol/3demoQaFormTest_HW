package pages.components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class ResultComponent {

    public SelenideElement successSubmittingDialog = $(".modal-dialog"),
                    successTitleForm = $("#example-modal-sizes-title-lg"),
                    resultsTable = $(".table-responsive");

    public void verifySuccessfullDialogAppears(){
        successSubmittingDialog.should(appear);
        successTitleForm.shouldHave(text("Thanks for submitting the form"));
    }

    public void verifyNoDialogAppears(){
        successSubmittingDialog.shouldNot(appear);
    }

    public void verifyTableResults(String key, String value){
        resultsTable.$(byText(key)).sibling(0).shouldHave(text(value));
    }

}
