import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import static java.time.Duration.*;

public class Waits {
    static WebDriver driver = new ChromeDriver();

    @BeforeAll
    public static void setUp() {
        driver.manage().window().maximize();
        driver.get("http://the-internet.herokuapp.com/dynamic_loading/2");
    }

    @Test

    public void checkText() {
        driver.manage().window().maximize();
        driver.get("http://the-internet.herokuapp.com/dynamic_loading/2");
        driver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//button[text() = 'Start']")).click();
        // --- po 6 sekundach powinien się wyświetlić element z selektorem "#finish
        Assertions.assertEquals("Hello World!", driver.findElement(By.cssSelector("#finish")).getText());
    }

    @Test

    public void checkText1() {
        driver.manage().window().maximize();
        driver.get("http://the-internet.herokuapp.com/dynamic_loading/2");
        driver.findElement(By.xpath("//button[text() = 'Start']")).click();
        Wait wait = new WebDriverWait(driver, 6);
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("#finish")));

        // --- po 6 sekundach powinien się wyświetlić element z selektorem "#finish
        Assertions.assertEquals("Hello World!", driver.findElement(By.cssSelector("#finish")).getText());
    }
}
