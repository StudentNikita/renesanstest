import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import steps.BaseSteps;
import steps.ContributionSteps;
import steps.MainSteps;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class RenesansTest extends BaseSteps {

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                { "Доллары США", "50000", "9 месяцев", "1000", true, false, "0.75%", "301,42", "8 000", "58 301,42" },
                { "Рубли", "2000000", "6 месяцев","30000", true, true, "6.25%", "65 132,87", "150 000", "2 215 132,87" }
        });
    }

    @Parameterized.Parameter // валюта
    public  String currency;

    @Parameterized.Parameter(1) // сумма вклада
    public  String contributionsum;

    @Parameterized.Parameter(2) // срок вклада
    public  String termOfDeposit;

    @Parameterized.Parameter(3) //ежемесячное пополнение
    public  String everyMonthAdd;

    @Parameterized.Parameter(4) //чекбокс Ежемесячная капитализация
    public  boolean capitalizationCheckBox;

    @Parameterized.Parameter(5) //чекбокс Частичное снятие
    public  boolean cashOfCheckbox;

    @Parameterized.Parameter(6) //ставка
    public  String  rate;

    @Parameterized.Parameter(7) //начислено
    public  String accured;

    @Parameterized.Parameter(8) //пополнение
    public  String replenishment;

    @Parameterized.Parameter(9) //к снятию
    public  String widraw;




    @Test
    @DisplayName("Калькулятор для вкладов")
    public void Test() throws InterruptedException {
        MainSteps mainSteps = new MainSteps();
        ContributionSteps contributionSteps = new ContributionSteps();

        mainSteps.stepClickOnContributionCalculator();

        contributionSteps.stepCheckTheTitle("Рассчитайте доходность по вкладу");
        contributionSteps.stepSelectCurrency(currency);
        contributionSteps.stepInputContributionSum(contributionsum);
        contributionSteps.stepSelectNumberOfMounths(termOfDeposit);
        contributionSteps.stepInputEveryMounthAddition(everyMonthAdd);
        contributionSteps.stepEveryMonthCapitalizationCheckbox(capitalizationCheckBox);
        contributionSteps.stepCashOffCheckbox(cashOfCheckbox);
        Thread.sleep(3000);
        contributionSteps.stepCheckTheRate(rate);
        contributionSteps.stepCheckTheAccured(accured);
        contributionSteps.stepCheckTheReplenishment(replenishment, termOfDeposit);
        contributionSteps.stepCheckTheWithdraw(widraw, termOfDeposit);


    }

}
