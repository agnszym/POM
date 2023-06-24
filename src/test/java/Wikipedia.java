import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Wikipedia {
    static WebDriver driver = new ChromeDriver();

    @BeforeAll
    public static void setUp() {
        driver.manage().window().maximize();
        driver.get("https://https://pl.wikipedia.org/");
    }
    @Test
    public void findElementsOnPage() {
        driver.findElement(By.cssSelector("#mw-logo")); // wyszukiwanie po id mw-logo
        driver.findElement(By.xpath("//img[@alt = 'Wikipedia']")); // wyszukanie po obrazku
        driver.findElement(By.cssSelector("a[title = 'Wikipedia:Strona główna/Wczoraj']"));
        driver.findElement(By.xpath("//a[@title = 'Wikipedia:Strona główna/Wczoraj']"));
        driver.findElement(By.cssSelector("input[name = 'search']"));
        driver.findElement(By.xpath("//input[@aria-label = 'Przeszukaj Wikipedię']"));

    }
    @AfterAll
    public static void closeBrowser() {
        driver.quit();
    }

}
