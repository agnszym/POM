import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class DropDownEx1 {

    static WebDriver driver = new ChromeDriver();

    @BeforeAll

    public static void setUp() {
        driver.manage().window().maximize();
        driver.get("https://pl-pl.facebook.com/");
        //driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    }

    @Test

    public void GetOptions() throws InterruptedException {
        driver.findElement(By.cssSelector("button[data-testid = 'cookie-policy-manage-dialog-accept-button']")).click();
        driver.findElement(By.cssSelector("a[data-testid = 'open-registration-form-button']")).click();
        // ---Select - znalezienie listy rozwijanej

        // Wait Explicit:

        Wait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("month")));

        //Thread.sleep(3000);

        Select select = new Select(driver.findElement(By.id("month")));
        // Opcje zwracają listy elementów
        List<WebElement> monthList = select.getOptions();
        for (int i = 0; i < monthList.size(); i++) {
            System.out.println(monthList.get(i).getText());
        }
    }
}




