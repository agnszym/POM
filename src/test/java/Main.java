import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
public class Main {

    static WebDriver driver = new ChromeDriver(); // stworzony obiekt ChromeDriver

    @BeforeAll // wykonuje sie przed wszystkimi testami

    public static void setUp() { // dajemy to co się powtarza w każdym teście
        driver.manage().window().maximize(); // maksymalizuj okno przeglądarki
        driver.get("https://pl.wikipedia.org/"); // przejdź do URL wikipedii
    }

    @Test
    public void checkIsTitleCorrect() {
        Assertions.assertEquals("Wikipedia, wolna encyklopedia", driver.getTitle());
        System.out.println("Tytuł strony: " + driver.getTitle()); // wydrukuj na konsoli tytuł strony
    }

    @Test
    public void checkTextOnPage () {
        Assertions.assertTrue(driver.getPageSource().contains("Stowarzyszenie Wikimedia Polska"));
    }

    @Test
    public void checkRefreshUrl() {
        driver.navigate().refresh();
        Assertions.assertEquals("https://pl.wikipedia.org/", driver.getCurrentUrl());
    }

    @AfterAll
    public static void closeBrowser() {
        driver.quit();
    }
}
