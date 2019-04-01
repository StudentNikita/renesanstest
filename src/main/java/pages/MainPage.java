package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;



public class MainPage extends BasePage {

    @FindBy(xpath = "//div[@class = 'service__links']//a[@href ='/contributions/']")
    WebElement contributionCalculator;

    public void clickOnContributionCalculator(){
        click(contributionCalculator);
    }
}
