import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class StackOverflow {

    static WebDriver driver = new ChromeDriver();

    @BeforeAll public static void setIp() {
        driver.manage().window().maximize();
        driver.get("http://stackoverflow.com");
    }
    @Test

    public void findElementOnPage() {
        driver.findElement(By.className("s-topbar--menu-btn")); // topbar - przycisk menu topbar
    }

    @Test
    public void findSearch() {
        driver.findElement(By.className("s-input__search"));
        driver.findElement(By.name("q"));
        driver.findElement(By.linkText("Log in"));
        driver.findElement(By.partialLinkText("Join the community"));
        /// wyciąganie listy webelementów:

        List<WebElement> search = driver.findElements(By.name("q")); // zadeklarowanie listy webelementów
        System.out.println(search.size());
    }

}
