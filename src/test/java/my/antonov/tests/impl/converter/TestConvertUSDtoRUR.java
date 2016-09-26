package my.antonov.tests.impl.converter;

import my.antonov.tests.impl.ConverterTest;
import org.junit.Test;
import org.junit.runners.Parameterized;
import ru.yandex.qatools.allure.annotations.Description;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Stories;

import java.io.IOException;
import java.util.Collection;

import static org.junit.Assert.*;
/**
 * Created by alex on 26.09.2016.
 */
public class TestConvertUSDtoRUR extends ConverterTest {

    public TestConvertUSDtoRUR(String fromCurrency, String toCurrency, String inputValue) {
        super(fromCurrency, toCurrency, inputValue);
    }

    @Parameterized.Parameters(name = "From {0} to {1} value {2}")
    public static Collection getTestData() throws IOException {
        return loadTestData("USD");
    }


    @Features("Test converting")
    @Stories("USD to RUR")
    @Description("Test converting from USD to RUR")
    @Test
    public void testConvert() {

        float buyValue;
        float result;
        float acceptResult;

        converterPage.selectFromCurrency(fromCurrency);
        converterPage.selectToCurrency(toCurrency);

        buyValue = Float.parseFloat(converterPage.getBuyValue().replace(",", "."));

        converterPage.setInputSumValue(inputValue);
        converterPage.submitConvert();

        result = Float.parseFloat(this.result = converterPage.getResultValue().replace(",", ".").replaceAll(" ", ""));
        acceptResult = buyValue * Float.parseFloat(inputValue);

        assertTrue(Math.abs(result - acceptResult) < 0.01f);
    }
}
