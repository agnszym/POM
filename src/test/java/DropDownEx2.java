import com.github.javafaker.Faker;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

public class DropDownEx2 {
    static WebDriver driver = new ChromeDriver();
    Faker faker = new Faker(); // nowa instancja klasy Faker

    private String userPassword = "userpasswordtestersoftie1$";
    private String confirmPassword = "userpasswordtestersoftie1$";

    @BeforeAll

    public static void setUp() {
        driver.manage().window().maximize();
        driver.get("http://serwer169007.lh.pl/autoinstalator/serwer169007.lh.pl/wordpress10772/");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @Test

    public void successRegister() throws InterruptedException {

        String username = faker.pokemon().name();
        String email = username + faker.name().username() + "@op.pl";
        System.out.println(email);

        //--przejście do zakładki register
        driver.findElement(By.linkText("register")).click();
        // driver.findElement(By.linkText("register")).click();
        //--uzupełnienie loginu
        driver.findElement(By.cssSelector("#user_login")).sendKeys(username);
        //--uzupełnienie maila
        driver.findElement(By.cssSelector("#user_email")).sendKeys(email);
        //--uzupełnienie hasła
        driver.findElement(By.cssSelector("#user_pass")).sendKeys(userPassword);
        //--potwierdzenie hasła
        driver.findElement(By.cssSelector("#user_confirm_password")).sendKeys(userPassword);
        //--założenie konta
        driver.findElement(By.cssSelector(".ur-submit-button")).click();

        Assertions.assertEquals("User successfully registered.", driver.findElement(By.cssSelector(".user-registration-message ul")).getText());
    }
}
