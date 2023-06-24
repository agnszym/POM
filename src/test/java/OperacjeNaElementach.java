import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class OperacjeNaElementach {

    static WebDriver driver = new ChromeDriver(); // trzeba zadeklarować statycznego webdrivera przed wszystkimi elementami, wtedy dotyczy całej klasy
    private String username = "fakesoftie";
    private String password = "passwordfake1$";
    private String wrongPassword = "wrongpassword1$";

    @BeforeAll
    public static void setUp() { // trzeba zrobić static
        driver.manage().window().maximize(); // driver ma zarządzić oknem - powiększyć je na maksymalny rozmiar
        driver.get("http://serwer169007.lh.pl/autoinstalator/serwer169007.lh.pl/wordpress10772/"); // driver.navigate().to(adres strony)
    }

    @Test
    public void loginSuccess() throws InterruptedException { // wyjątek przerwania
        driver.findElement(By.linkText("Moje konto")).click();
        driver.findElement(By.cssSelector("#username")).sendKeys("fakesoftie");
        driver.findElement(By.cssSelector("#password")).sendKeys("passwordfake1$");
        driver.findElement(By.cssSelector(".woocommerce-form-login__submit")).click();
        Thread.sleep(3000); // wprowadzamy gdy nie wiemy czy potrzeba nam czasu, webdriver nic przez ten czas nie wykonuje
        Assertions.assertTrue(driver.findElement(By.xpath("//a[contains(text() , 'Kokpit')]")).isDisplayed()
                && driver.findElement(By.xpath("//a[text() = 'Wyloguj się']")).isDisplayed()); // połączenie dwóch warunków

    }

    @Test
    public void loginFailed() {
        driver.findElement(By.linkText("Moje konto")).click();
        driver.findElement(By.cssSelector("#username")).sendKeys(username);
        driver.findElement(By.cssSelector("#password")).sendKeys(wrongPassword);
        driver.findElement(By.cssSelector(".woocommerce-form-login__submit")).click();
        // za pomocą sout: System.out.println(driver.findElement(By.cssSelector(".woocommerce-error")).getText());
        Assertions.assertTrue(driver.findElement(By.xpath("//strong[contains(text() , 'Błąd:')]")).isDisplayed());
    //można też to zrobić za pomocą printf - zobaczyć w filmie
    }

    @AfterEach // sprawdzamy czy użytkownik jest zalogowany i zawsze jak jest to go wylogowujemy
    public void logout() {
        driver.findElement(By.linkText("Moje konto")).click();
        if (driver.findElements(By.xpath("//a[text() = 'Wyloguj się']")).size() != 0) {
            driver.findElement(By.xpath("//a[text() = 'Wyloguj się']")).click();
        }

    }
    @AfterAll
    public static void closeBrowser() {


    }





}
