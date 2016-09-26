package my.antonov.web.pages;



import my.antonov.web.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.concurrent.TimeUnit;

/**
 * Created by alex on 21.09.2016.
 */
public class PersonPage extends AbstractPage {

    //@FindBy(className = "flip-container")
    @FindBy(xpath = ".//div[@data-pid='personalRates']")
    @CacheLookup
    private WebElement flipContainer;

//    @FindBy(xpath = ".//*[@class='tabs'/li[1]/span")
//    @CacheLookup
//    private WebElement currency;
//
//    @FindBy(xpath = ".//*[@class='tabs']/li[2]/span")
//    @CacheLookup
//    private WebElement metals;

    @FindBy(xpath = ".//*[@class='tabs']")
    @CacheLookup
    private WebElement tabs;

    public PersonPage(WebDriver driver) {
        super(driver);

        if(!driver.getCurrentUrl().endsWith("/person")) {
            throw new IllegalStateException("This is not the person page");
        }
        PageFactory.initElements(driver, this);
    }

    @Step("Click on 'metal' tab menu")
    public PersonPage clickOnMetalsInPersonalRates(){
        scrollToElement(flipContainer);
        //metals.click();
        tabs.findElement(By.xpath(".//li[2]/span")).click();
        return this;
    }

    @Step("Check is 'metal' class in active state")
    public boolean isMetalTabActive() {
        return tabs.findElement(By.xpath(".//li[2]")).getAttribute("class").equals("active");
    }

    @Step("Click on 'currency' tab menu")
    public PersonPage clickOnCurrencyInPersonalRates() {
        scrollToElement(flipContainer);
        tabs.findElement(By.xpath(".//li[1]/span")).click();
        //currency.click();
        return this;
    }

    @Step("Check is 'currency' class in active state")
    public boolean isCurrencyTabActive() {
        return tabs.findElement(By.xpath(".//li[1]")).getAttribute("class").equals("active");
    }

    @Step("Go to converter page")
    public ConverterPage getConverterPage() {
        scrollToElement(flipContainer);
        flipContainer.findElement(By.xpath(".//div[2]/div/div/a")).click();
        WebDriverWait wait = new WebDriverWait(getDriver(), 60);// 1 minute
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//div[@class='widget-rates']")));
        return new ConverterPage(getDriver());
    }
}
