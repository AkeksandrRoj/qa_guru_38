package pages.cpmponents;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class DropDownsList {
    public void setDropDownList(String value){
        $("#stateCity-wrapper").$(byText(value)).click();
    }
}
