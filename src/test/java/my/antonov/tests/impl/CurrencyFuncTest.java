package my.antonov.tests.impl;

import my.antonov.tests.AbstractTesting;
import my.antonov.web.pages.PersonPage;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.allure.annotations.Description;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Stories;

import static org.junit.Assert.*;

/**
 * Created by alex on 22.09.2016.
 */
public class CurrencyFuncTest extends AbstractTesting {


    @Features("Switch to metal tab")
    @Stories("Check web fuctional")
    @Description("Testing switcher from currency to metal")
    @Test
    public void testSwitcherToMetal() {
        PersonPage personPage = new PersonPage(getDriver());
        personPage.clickOnMetalsInPersonalRates();
        assertTrue(personPage.isMetalTabActive());
    }


    @Features("Switch to currency tab")
    @Stories("Check web fuctional")
    @Description("Testing switcher from metal to currency")
    @Test
    public void testSwitcherToCurrency() {
        PersonPage personPage = new PersonPage(getDriver());
        personPage.clickOnCurrencyInPersonalRates();
        assertTrue(personPage.isCurrencyTabActive());
    }
}
