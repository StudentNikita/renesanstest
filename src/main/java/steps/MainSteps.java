package steps;

import io.qameta.allure.Step;
import pages.MainPage;

public class MainSteps {
    MainPage mainpage = new MainPage();

    @Step("������ �� ����������� �� ������")
    public void stepClickOnContributionCalculator(){
        mainpage.clickOnContributionCalculator();
    }
}
