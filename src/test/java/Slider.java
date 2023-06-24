import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
public class Slider {

    static WebDriver driver = new ChromeDriver();

    @BeforeAll

    public static void setUp() {
        driver.manage().window().maximize();
        driver.get("https://www.zalando.pl/odziez-damska-sukienki-koktajlowe/");
    }
    @Test

    public void dragAndDropTest() {
        driver.findElement(By.cssSelector("button[aria-label = 'filtruj po Cena']")).click();

        Actions actions = new Actions(driver);
        actions.clickAndHold(driver.findElement(By.cssSelector("div[aria-label = 'Najniższa cena']"))).
                moveByOffset(100,0).build().perform();
        System.out.println();
    }
}
