import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
public class Action {
    static WebDriver driver = new ChromeDriver();

    @BeforeAll

    public static void setUp() {
        driver.manage().window().maximize();
        driver.get("http://serwer169007.lh.pl/autoinstalator/serwer169007.lh.pl/wordpress10772/");
    }


    @Test

    public void checkActions() {
        Actions actions = new Actions(driver);

        actions.moveToElement(driver.findElement(By.cssSelector(".woocommerce-Price-amount"))).build().perform(); // zbuduj i wykonaj czynność
    }
}
