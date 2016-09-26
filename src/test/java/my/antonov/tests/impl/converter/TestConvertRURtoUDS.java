package my.antonov.tests.impl.converter;

import my.antonov.tests.impl.ConverterTest;
import org.junit.Test;
import org.junit.runners.Parameterized;
import ru.yandex.qatools.allure.annotations.Description;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Stories;

import java.io.IOException;
import java.util.Collection;

import static org.junit.Assert.assertTrue;

/**
 * Created by alex on 26.09.2016.
 */
public class TestConvertRURtoUDS extends ConverterTest {

    public TestConvertRURtoUDS(String fromCurrency, String toCurrency, String inputValue) {
        super(fromCurrency, toCurrency, inputValue);
    }

    @Parameterized.Parameters(name = "From {0} to {1} value {2}")
    public static Collection getTestData() throws IOException {
        return loadTestData("RUR");
    }


    @Features("Test converting")
    @Stories("RUR to USD")
    @Description("Test converting from RUR to USD")
    @Test
    public void testConvert() {

        float soldValue;
        float result;
        float acceptResult;

        converterPage.selectFromCurrency(fromCurrency);
        converterPage.selectToCurrency(toCurrency);

        soldValue = Float.parseFloat(converterPage.getSoldValue().replace(",", "."));

        converterPage.setInputSumValue(inputValue);
        converterPage.submitConvert();

        result = Float.parseFloat(this.result = converterPage.getResultValue().replace(",", ".").replaceAll(" ", ""));
        acceptResult = Float.parseFloat(inputValue) / soldValue;

        assertTrue(Math.abs(result - acceptResult) < 0.01f);
    }
}
