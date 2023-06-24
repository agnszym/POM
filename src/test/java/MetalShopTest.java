import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.List;

public class MetalShopTest {

    static WebDriver driver = new ChromeDriver();

    @BeforeAll

    public static void setUp() {
        driver.manage().window().maximize();
        driver.get("http://serwer169007.lh.pl/autoinstalator/serwer169007.lh.pl/wordpress10772/");
    }

    @Test

    public void findElementsAttachment() {
    List<WebElement> attachmentList = driver.findElements(By.className("attachment-woocommerce_thumbnail"));
        System.out.println(attachmentList.size());
    }
    @Test

    public void findImages() {
        List<WebElement> imagesList = driver.findElements(By.tagName("img")); // lista webelementów która wyszukuje wszystkie elementy z tagiem img
        System.out.println(imagesList.size());
    }

    @Test

    public void isElementOnPage() {
        driver.findElement(By.className("search-field"));
        List<WebElement> searchList = driver.findElements(By.className("search-field"));
        Assertions.assertEquals(1, searchList.size()); // 1 jest rozmiarem listy (czy ma 1 element)
    }

    @Test
    public void findElementsOnPage() {
        driver.findElement(By.xpath("//a[text() = 'Moje konto']")).click();
        driver.findElement(By.cssSelector(".woocommerce-breadcrumb > a"));
        driver.findElement(By.xpath("//a[text() = 'Strona główna'][last()]"));
        driver.findElement(By.cssSelector(".entry-title"));
        driver.findElement(By.cssSelector("#username"));
        driver.findElements(By.cssSelector("button[name = 'login']"));
        driver.findElement(By.cssSelector(".woocommerce-LostPassword > a"));
        driver.findElement(By.xpath("//a[text() = 'Nie pamiętasz hasła?']"));

        driver.findElement(By.cssSelector(".site-title > a"));
        driver.findElement(By.xpath("//a[text() = 'Softie Metal Shop']"));

        driver.findElement(By.xpath("//a[contains(text), 'Metal Shop')]")); // wyszukiwanie w tagu a elementu zawierającego tekst "metal shop"
        driver.findElement(By.cssSelector(".amount"));
    }

    @AfterAll

    public static void closeBrowser() {
        driver.quit();
    }

}
