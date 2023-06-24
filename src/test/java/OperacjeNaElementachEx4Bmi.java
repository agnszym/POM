import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class OperacjeNaElementachEx4Bmi {

    static WebDriver driver = new ChromeDriver();


    @BeforeAll
    public static void setUp() {
        driver.manage().window().maximize();
        driver.get("https://bmi-online.pl/");
    }
    @Test

    public void calculateBmi() {
        // ------ radio Button - lista płci
        List<WebElement> radioList = driver.findElements(By.cssSelector(".radio-btn"));
        /// radioList.get(0).click(); // klikamy w płeć o indeksie 0 - kobieta
        if (radioList.get(1).isSelected()) {
            radioList.get(0).click();
        }

        // ------- uzupełnienie pól
        driver.findElement(By.cssSelector("input[name = 'weight']")).sendKeys("55");
        driver.findElement(By.cssSelector("input[name = 'height']")).sendKeys("170");

        ///-----click - przejścia do podsumowania, czyli obliczenie BMI
        driver.findElement(By.xpath("//span[text() = 'Przejdź do serwisu']")).click();
        driver.findElement(By.xpath("//span[text() = 'Oblicz']")).click();
        // -- sprawdzamy czy na konsoli wyswietli sie wskaźnik BMI
        System.out.println(driver.findElement(By.cssSelector(".result-value")).getText());

        //-- dodajemy asercję sprawdzającą czy otrzymana wartość jest zgodna
        Assertions.assertEquals("19.03", driver.findElement(By.cssSelector(".result-value")).getText());
    }

}
