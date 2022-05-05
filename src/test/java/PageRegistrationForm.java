import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class PageRegistrationForm {

    String[] list = {"joka", "boka", "test@qa.qa", "Male", "7987645382", "July", "2001", "30", "Maths", "Sports",
            "D:/pic.jpg", "12, apt. 3 Lenin st", "NCR", "Delhi"};


    public void openPage(){
        open("https://demoqa.com/automation-practice-form");
    }

    public void fillForm(){


        $("#firstName").setValue(list[0]);
        $("#lastName").setValue(list[1]);

        $("#userEmail").setValue(list[2]);

        //set gender Male
        $(byText(list[3])).click();

        $("#userNumber").setValue(list[4]);

        //set date of brith
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").click();
        $(byText(list[5])).click();
        $(".react-datepicker__year-select").click();
        $(byText(list[6])).click();
        $(byText(list[7])).click();

        //set subject Maths
        $(".subjects-auto-complete__input").click();
        $("#subjectsInput").setValue(list[8]).pressEnter();

        //set hobbies Sports
        $(byText(list[9])).click();

        $("#uploadPicture").sendKeys(list[10]);
        $("#uploadPicture").uploadFile(new File(list[10]));

        $("#currentAddress").setValue(list[11]);

        $("#state").click();
        $(byText(list[12])).click();

        $("#city").click();
        $(byText(list[13])).click();

        $("#submit").click();
    }

    public void checkData(){

        //1st assert

        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        $x("//td[text()='Student Name']").parent().shouldHave(text(list[0] + " " + list[1]));
        $x("//td[text()='Student Email']").parent().shouldHave(text(list[2]));
        $x("//td[text()='Gender']").parent().shouldHave(text(list[3]));
        $x("//td[text()='Mobile']").parent().shouldHave(text(list[4]));
        $x("//td[text()='Date of Birth']").parent().shouldHave(text(list[7] + " " + list[5] + "," + list[6]));
        $x("//td[text()='Subjects']").parent().shouldHave(text(list[8]));
        $x("//td[text()='Hobbies']").parent().shouldHave(text(list[9]));
        $x("//td[text()='Picture']").parent().shouldHave(text("pic.jpg"));
        $x("//td[text()='Address']").parent().shouldHave(text(list[11]));
        $x("//td[text()='State and City']").parent().shouldHave(text(list[12] + " " + list[13]));

        //2nd assert

        $(".modal-content").shouldHave(text(list[0]), text(list[1]), text(list[2]), text(list[3]),
                text(list[4]), text(list[5]), text(list[6]), text(list[7]), text(list[8]), text(list[9]),
                text("pic.jpg"), text(list[11]), text(list[12]), text(list[13]));

    }
}
