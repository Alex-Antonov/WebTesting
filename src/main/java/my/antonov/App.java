package my.antonov;

import com.sun.org.apache.xpath.internal.SourceTree;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.stqa.selenium.factory.WebDriverFactory;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * Created by alex on 17.09.2016.
 */
public class App {

    public static void main(String[] args) {
//        // Create a new instance of the Firefox driver
//        // Notice that the remainder of the code relies on the interface,
//        // not the implementation.
//        DesiredCapabilities capabilities = DesiredCapabilities.firefox();
//        //capabilities.setCapability("marionette", true);
//        capabilities.setCapability("javascript", true);
//        WebDriver driver = new FirefoxDriver(capabilities);
//        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//        // And now use this to visit Google
//        driver.navigate().to("http://www.sberbank.ru/ru/person");
//        // Alternatively the same thing can be done like this
//        // driver.navigate().to("http://www.google.com");
//
//        // Find the text input element by its name
////        WebElement element = driver.findElement(By.name("q"));
////
////        // Enter something to search for
////        element.sendKeys("Cheese!");
////
////        // Now submit the form. WebDriver will find the form for us from the element
////        element.submit();
//
//        // Check the title of the page
//        System.out.println("Page title is: " + driver.getTitle());
//
//        // Google's search is rendered dynamically with JavaScript.
//        // Wait for the page to load, timeout after 10 seconds
////        (new WebDriverWait(driver, 10)).until(new ExpectedCondition<Boolean>() {
////            public Boolean apply(WebDriver d) {
////                return d.getTitle().toLowerCase().startsWith("cheese!");
////            }
////        });
//
//        // Should see: "cheese! - Google Search"
//        System.out.println("Page title is: " + driver.getTitle());
//        System.out.println("Page url: " + driver.getCurrentUrl());
//
//        //Close the browser
//        driver.quit();
    }
}
