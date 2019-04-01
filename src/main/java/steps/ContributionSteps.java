package steps;

import io.qameta.allure.Step;
import org.junit.Assert;
import pages.ContributionPage;

public class ContributionSteps {
    ContributionPage contributionPage = new ContributionPage();

    @Step("Должно быть заполнено - {0}")
    public void stepCheckTheTitle(String expectedTitle){
        Assert.assertEquals(String.format("В заголовке должно быть написано - %s. А по факту написано - %s", expectedTitle, contributionPage.getPageTitle()),
                expectedTitle, contributionPage.getPageTitle());
        System.out.println(String.format("Появился заголовок: '%s'", expectedTitle));
    }

    @Step("Должно быть заполнено - {0}")
    public void stepCheckTheAccured(String expectedAccured){
        Assert.assertEquals(String.format("Сумма начислений должна быть равна - %s. А по факту равна - %s", expectedAccured, contributionPage.getAccured()),
                expectedAccured, contributionPage.getAccured());
        System.out.println(String.format("Начислено - %s", expectedAccured));
    }

    @Step("Должно быть заполнено - {0}")
    public void stepCheckTheRate(String expectedRate){
        Assert.assertEquals(String.format("Ставка должна быть равна %s. А по факту равна  %s", expectedRate, contributionPage.getRate()),
                expectedRate, contributionPage.getRate());
        System.out.println(String.format("Ставка - %s", expectedRate));
    }

    @Step("Должно быть заполнено - {0}")
    public void stepCheckTheReplenishment(String expectedReplenishment, String numOfMonths){
        Assert.assertEquals(String.format("Сумма пополнения должна быть равно %s. А по факту равна - %s", expectedReplenishment, contributionPage.getReplenishment()),
                expectedReplenishment, contributionPage.getReplenishment());
        System.out.println(String.format("Пополнение за %s - " + expectedReplenishment, numOfMonths ));
    }

    @Step("Должно быть заполнено - {0}")
    public void stepCheckTheWithdraw(String expectedWithdraw, String numOfMonths){
        Assert.assertEquals(String.format("Сумма снятия должна быть равна %s. А по факту равна - %s", expectedWithdraw, contributionPage.getToWithdraw()),
                expectedWithdraw, contributionPage.getToWithdraw());
        System.out.println(String.format("К снятию через %s - " + expectedWithdraw, numOfMonths ));
    }

    @Step("Чекбокс 'Ежемесячная капитализация 'должен иметь состояние - {0}")
    public void stepEveryMonthCapitalizationCheckbox (boolean onOff){
            contributionPage.chooseCheckBoxCapitalization(onOff);
        }

    @Step("Чекбокс 'Частичное снятие'должен иметь состояние - {0}")
    public void stepCashOffCheckbox (boolean onOff){
        contributionPage.chooseCheckBoxCashOff(onOff);
    }

    @Step("Выбираем валюту - {0}")
    public void stepSelectCurrency (String currency){
        contributionPage.selectCurrency(currency);
    }

    @Step("Выбираем на какое количество месяцев делать вклад - {0}")
    public void stepSelectNumberOfMounths (String numOfMonths){
        contributionPage.selectNumberOfMounths(numOfMonths);
    }

    @Step("Заполняем сумму вклада: {0}")
    public void stepInputContributionSum (String contributionSum){
        contributionPage.fillFieldContributionSum(contributionSum);
    }

    @Step("Заполняем ежемесячное пополнение: {0}")
    public void stepInputEveryMounthAddition (String everyMounthAddition){
        contributionPage.fillFieldEveryMounthAddition(everyMounthAddition);
    }
}
