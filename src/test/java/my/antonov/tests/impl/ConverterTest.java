package my.antonov.tests.impl;

import my.antonov.tests.AbstractTesting;
import my.antonov.web.pages.ConverterPage;
import my.antonov.web.pages.PersonPage;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Parameter;

import java.io.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by alex on 23.09.2016.
 */
@Features("Testing basic math operations")
@RunWith(value = Parameterized.class)
public abstract class ConverterTest extends AbstractTesting {

    private final static String CSV_DATA_PATH = "converter.csv";

    @Parameter("convert from")
    protected String fromCurrency;

    @Parameter("convert to")
    protected String toCurrency;

    @Parameter("input value")
    protected String inputValue;

    @Parameter("result")
    protected String result;

    protected ConverterPage converterPage;

    public ConverterTest(String fromCurrency, String toCurrency,
                         String inputValue) {
        this.fromCurrency = fromCurrency;
        this.toCurrency = toCurrency;
        this.inputValue = inputValue;
    }

    public static Collection loadTestData(String operation) throws IOException {
        return getTestData(CSV_DATA_PATH, operation);
    }


    private static Collection<String[]> getTestData(String fileName, String fromCurrency)
            throws IOException {
        List<String[]> records = new ArrayList<String[]>();
        String record;
        try (

                InputStream stream = Thread.currentThread().getContextClassLoader().getResourceAsStream(CSV_DATA_PATH);
                InputStreamReader reader = new InputStreamReader(stream);
                BufferedReader br = new BufferedReader(reader);
        ) {
            while ((record = br.readLine()) != null) {
                String fields[] = record.split(";");
                if(fromCurrency.equals(fields[0]))
                    records.add(fields);
            }
            br.close();
            return records;
        } catch (IOException e) {
            throw  e;
        }


    }

    @Before
    public void navigateToConverter() {
        converterPage = new PersonPage(getDriver()).getConverterPage();
    }

    public abstract void testConvert();
}
