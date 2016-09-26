package my.antonov.web.pages;

import my.antonov.web.AbstractPage;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.yandex.qatools.allure.annotations.Step;

/**
 * Created by alex on 23.09.2016.
 */
public class ConverterPage extends AbstractPage {

    @FindBy(xpath = ".//div[@class='filter-block-line-right input']/form/input")
    @CacheLookup
    private WebElement inputSum;

    @FindBy(xpath = ".//select[@name='converterFrom']")
    @CacheLookup
    private WebElement fromCurrency;

    @FindBy(xpath = ".//select[@name='converterTo']")
    @CacheLookup
    private WebElement toCurrency;

    @FindBy(xpath = ".//div[@class='current-table']/table/tbody/tr/td[3]/span")
    @CacheLookup
    private WebElement buyValue;

    @FindBy(xpath = ".//div[@class='current-table']/table/tbody/tr/td[4]/span")
    @CacheLookup
    private WebElement soldValue;

    @FindBy(xpath = ".//div[@class='converter-result']/h4/span[1]")
    @CacheLookup
    private WebElement resultValue;

    public ConverterPage(WebDriver driver) {
        super(driver);

        if(!driver.getCurrentUrl().endsWith("/converter/")) {
            throw new IllegalStateException("This is not the converter page");
        }
        PageFactory.initElements(driver, this);
    }

    public String getBuyValue() {
        return buyValue.getText();
    }

    public String getSoldValue() {
        return soldValue.getText();
    }

    @Step("Set input value: {0}")
    public void setInputSumValue(String value) {
        inputSum.clear();
        inputSum.sendKeys(value);
    }

    @Step("Select converting from: {0}")
    public void selectFromCurrency(String from) {
        WebElement select = fromCurrency.findElement(By.xpath(".."));
        select.click();
        select.findElement(By.xpath(".//div/div/span[text()='" + from + "']")).click();
    }

    @Step("Select converting to: {0}")
    public void selectToCurrency(String to) {
        WebElement select = toCurrency.findElement(By.xpath(".."));
        select.click();
        select.findElement(By.xpath(".//div/div/span[text()='" + to + "']")).click();
    }

    public String getResultValue() {
        return resultValue.getText();
    }

    @Step("Submiting to convert")
    public void submitConvert() {
        inputSum.submit();
        WebDriverWait wait = new WebDriverWait(getDriver(), 60);// 1 minute
        wait.until(ExpectedConditions.visibilityOf(resultValue));
    }
}
