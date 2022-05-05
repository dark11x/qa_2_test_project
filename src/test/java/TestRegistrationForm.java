import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class TestRegistrationForm {
    PageRegistrationForm pageRegistrationForm = new PageRegistrationForm();

    @BeforeAll
    static void setup() {
        Configuration.startMaximized = true;
    }

    @Test
    void fullFormTest() {
        pageRegistrationForm.openPage();
        pageRegistrationForm.fillForm();
        pageRegistrationForm.checkData();
    }

}
