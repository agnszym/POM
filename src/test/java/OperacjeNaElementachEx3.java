import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;


public class OperacjeNaElementachEx3 {
    static WebDriver driver = new ChromeDriver();

    @BeforeAll
    public static void setUp() {
        driver.manage().window().maximize();
        driver.get("https://www.w3schools.com/html/html_tables.asp");
    }
    @Test
    public void tabelaTest() {
        // -1-
        List<WebElement> rowsTable = driver.findElements(By.cssSelector("#customers tr")); // tabelka i wszyscy potomkowie zawierający tag tr - tu szukamy
        Assertions.assertEquals(7, rowsTable.size());
        // -2-
        String companyName = driver.findElement(By.xpath("//table[@id='customers']//tr[7]//td[2]")).getText(); // sprawdzenie czy w tym miejscu znajduje się to co w zadaniu
        Assertions.assertEquals("Giovanni Rovelli", companyName);
        // -3-
        String country = driver.findElement(By.xpath("//table[@id='customers']//tr[td[text() = 'Centro comercial Moctezuma']]//td[3]")).getText(); // wyszukanie wiersza w kolumnie który ma określoną wartość
        Assertions.assertEquals("Mexico", country);
        // -4-
        String country1 = driver.findElement(By.xpath("//table[@id='customers']//tr[td[text() = 'Laughing Bacchus Winecellars']]//td[3]")).getText(); //td[3] - wskazuje na kolumnę 3
        Assertions.assertEquals("Canada", country1); // sprawdzenie czy w kolumnie wskazanej przez country1 jest "Canada"
    }
}
