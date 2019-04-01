package steps;

import io.qameta.allure.Step;
import org.junit.Assert;
import pages.ContributionPage;

public class ContributionSteps {
    ContributionPage contributionPage = new ContributionPage();

    @Step("������ ���� ��������� - {0}")
    public void stepCheckTheTitle(String expectedTitle){
        Assert.assertEquals(String.format("� ��������� ������ ���� �������� - %s. � �� ����� �������� - %s", expectedTitle, contributionPage.getPageTitle()),
                expectedTitle, contributionPage.getPageTitle());
        System.out.println(String.format("�������� ���������: '%s'", expectedTitle));
    }

    @Step("������ ���� ��������� - {0}")
    public void stepCheckTheAccured(String expectedAccured){
        Assert.assertEquals(String.format("����� ���������� ������ ���� ����� - %s. � �� ����� ����� - %s", expectedAccured, contributionPage.getAccured()),
                expectedAccured, contributionPage.getAccured());
        System.out.println(String.format("��������� - %s", expectedAccured));
    }

    @Step("������ ���� ��������� - {0}")
    public void stepCheckTheRate(String expectedRate){
        Assert.assertEquals(String.format("������ ������ ���� ����� %s. � �� ����� �����  %s", expectedRate, contributionPage.getRate()),
                expectedRate, contributionPage.getRate());
        System.out.println(String.format("������ - %s", expectedRate));
    }

    @Step("������ ���� ��������� - {0}")
    public void stepCheckTheReplenishment(String expectedReplenishment, String numOfMonths){
        Assert.assertEquals(String.format("����� ���������� ������ ���� ����� %s. � �� ����� ����� - %s", expectedReplenishment, contributionPage.getReplenishment()),
                expectedReplenishment, contributionPage.getReplenishment());
        System.out.println(String.format("���������� �� %s - " + expectedReplenishment, numOfMonths ));
    }

    @Step("������ ���� ��������� - {0}")
    public void stepCheckTheWithdraw(String expectedWithdraw, String numOfMonths){
        Assert.assertEquals(String.format("����� ������ ������ ���� ����� %s. � �� ����� ����� - %s", expectedWithdraw, contributionPage.getToWithdraw()),
                expectedWithdraw, contributionPage.getToWithdraw());
        System.out.println(String.format("� ������ ����� %s - " + expectedWithdraw, numOfMonths ));
    }

    @Step("������� '����������� ������������� '������ ����� ��������� - {0}")
    public void stepEveryMonthCapitalizationCheckbox (boolean onOff){
            contributionPage.chooseCheckBoxCapitalization(onOff);
        }

    @Step("������� '��������� ������'������ ����� ��������� - {0}")
    public void stepCashOffCheckbox (boolean onOff){
        contributionPage.chooseCheckBoxCashOff(onOff);
    }

    @Step("�������� ������ - {0}")
    public void stepSelectCurrency (String currency){
        contributionPage.selectCurrency(currency);
    }

    @Step("�������� �� ����� ���������� ������� ������ ����� - {0}")
    public void stepSelectNumberOfMounths (String numOfMonths){
        contributionPage.selectNumberOfMounths(numOfMonths);
    }

    @Step("��������� ����� ������: {0}")
    public void stepInputContributionSum (String contributionSum){
        contributionPage.fillFieldContributionSum(contributionSum);
    }

    @Step("��������� ����������� ����������: {0}")
    public void stepInputEveryMounthAddition (String everyMounthAddition){
        contributionPage.fillFieldEveryMounthAddition(everyMounthAddition);
    }
}
