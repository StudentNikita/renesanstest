package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class ContributionPage extends BasePage {

    @FindBy(xpath = "//h2[@class = 'calculator-block__title block-title']")
    WebElement pageTitle;

    @FindBy(xpath = "//div[@class = 'calculator__currency-content']/label")
    List<WebElement> currency;

    @FindBy(xpath = "//input[@name ='amount']")
    WebElement contributionSum;

    @FindBy(xpath = "//select[@class='calculator__slide-input js-slide-value']")
    WebElement monthButton;

    @FindBy(xpath = "//input[@name ='replenish']")
    WebElement everyMounthAddition;

    @FindBy(xpath = "//span[contains(text(), 'Ежемесячная капитализация')]/../../span")
    WebElement checkboxCapitalization;

    @FindBy(xpath = "//span[contains(text(), 'Частичное снятие')]/../../span")
    WebElement checkboxCashOff;

    @FindBy(xpath = "//span[@class='js-calc-rate']")
    WebElement rate; //ставка

    @FindBy(xpath = "//span[@class='js-calc-earned']")
    WebElement accured; //начислено

    @FindBy(xpath = "//span[@class='js-calc-replenish']")
    WebElement replenishment; //пополнение

    @FindBy(xpath = "//span[@class='js-calc-result']")
    WebElement toWithdraw; //снятие


    public void selectCurrency(String currencyWeNeed){
        for (WebElement item: currency){
            if(item.getText().equalsIgnoreCase(currencyWeNeed)){
                new WebDriverWait(driver,10)
                        .until(ExpectedConditions.elementToBeClickable(item)).click();
                return;
            }
        }
        Assert.fail("Не найдена валюта - " + currencyWeNeed);
    }


    public void selectNumberOfMounths(String numberOfMounths){
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(false);", checkboxCapitalization);
        Select select = new Select(monthButton);
        select.selectByVisibleText(numberOfMounths);

    }

    public void chooseCheckBoxCapitalization (boolean onOff){
      if (isElementPresent(checkboxCapitalization)){
        if (onOff == true || !checkboxCapitalization.isSelected()){
            new WebDriverWait(driver,10)
                    .until(ExpectedConditions.elementToBeClickable(checkboxCapitalization)).click();
            return;
        } else if (onOff == false || checkboxCapitalization.isSelected()){
            new WebDriverWait(driver,10)
                    .until(ExpectedConditions.elementToBeClickable(checkboxCapitalization)).click();
            return;
        }
    }
    }

    public void chooseCheckBoxCashOff (boolean onOff) {
        if (isElementPresent(checkboxCashOff)) {
            if (onOff == true || !checkboxCashOff.isSelected()) {
                new WebDriverWait(driver, 11)
                        .until(ExpectedConditions.elementToBeClickable(checkboxCashOff)).click();
                return;
            } else if (onOff == false || checkboxCashOff.isSelected()) {
                new WebDriverWait(driver, 10)
                        .until(ExpectedConditions.elementToBeClickable(checkboxCashOff)).click();
                return;
            }
        }
    }

    public void fillFieldContributionSum (String contributSum){

        if (!driver.findElement(By.xpath("//div[@class='jq-checkbox calculator__check checked']//div[@class='jq-checkbox__div']")).isSelected()){
            click(driver.findElement(By.xpath("//div[@class='jq-checkbox calculator__check checked']//div[@class='jq-checkbox__div']")));
        }

        new WebDriverWait(driver,10)
                .until(ExpectedConditions.elementToBeClickable(contributionSum)).click();
        do fillfield(contributionSum, contributSum);
        while (contributionSum.getText().equals(contributSum));
    }

    public void fillFieldEveryMounthAddition (String numberOfMonths){
        new WebDriverWait(driver,10)
                .until(ExpectedConditions.elementToBeClickable(everyMounthAddition)).click();
        do fillfield(everyMounthAddition, numberOfMonths);
        while (everyMounthAddition.getText().equals(numberOfMonths));
    }

    public String getPageTitle(){
        return pageTitle.getText();
    }

    public String getRate(){

        return rate.getText();
    }

    public String getAccured(){
        return accured.getText();
    }

    public String getReplenishment(){
        return replenishment.getText();
    }

    public String getToWithdraw(){
        return toWithdraw.getText();
    }


}
