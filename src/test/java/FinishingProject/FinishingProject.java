package FinishingProject;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
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

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)

public class FinishingProject {
    static WebDriver driver = new ChromeDriver();
    Faker faker = new Faker();
    private String userLogin = faker.dog().name();
    private String userEmail = userLogin + faker.dog().name() + "softie@poczta.onet.eu";
    private String userPassword = "fakesoftie0420231$";
    private String nameAndSurname = faker.artist().name();
    private String messageSubject = "This is an exemplary title";
    private String messageText = "This is an exemplary message";
    private String itemToReturn = "Silver coin";
    private int couponNumber = 123459876;

    WebElement mainPage = driver.findElement(By.cssSelector(".beta > a"));
    WebElement contactPage = driver.findElement(By.cssSelector("#menu-item-132 > a"));
    WebElement shoppingCart = driver.findElement(By.xpath("//a[@class='cart-contents']"));
    WebElement shoppingPage = driver.findElement(By.cssSelector("#menu-item-124 > a"));
    WebElement selectRandomProduct = driver.findElement(By.xpath("//a[@href='http://serwer169007.lh.pl/autoinstalator/serwer169007.lh.pl/wordpress10772/produkt/srebrna-sztabka-500g/']"));
    WebElement goToChart= driver.findElement(By.xpath("//a[@href='http://serwer169007.lh.pl/autoinstalator/serwer169007.lh.pl/wordpress10772/koszyk/']"));
    WebElement checkShoppingChart = driver.findElement(By.cssSelector(".cart-contents"));
    WebElement myAccount = driver.findElement(By.linkText("Moje konto"));
    WebElement returnItem = driver.findElement(By.cssSelector("#menu-item-145"));


    @BeforeAll

    public static void setUp() {
        driver.manage().window().maximize();
        driver.get("http://serwer169007.lh.pl/autoinstalator/serwer169007.lh.pl/wordpress10772/");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }


    //---Ex1
    @Test
    @Order(2)

    public void lackOfLogin() {
        myAccount.click();
        driver.findElement(By.cssSelector("#password")).sendKeys(userPassword);
        driver.findElement(By.xpath("//button[@name = 'login']")).click();

        String errorText = driver.findElement(By.cssSelector(".woocommerce-error")).getText();
        Assertions.assertEquals("Błąd: Nazwa użytkownika jest wymagana.", errorText);
    }

    //---Ex2
    @Test
    @Order(3)

    public void lackOfPassword() {
        myAccount.click();
        driver.findElement(By.cssSelector("#username")).sendKeys(userLogin);
        driver.findElement(By.xpath("//button[@name = 'login']")).click();

        String errorText1 = driver.findElement(By.cssSelector(".woocommerce-error")).getText();
        Assertions.assertEquals("Błąd: pole hasła jest puste.", errorText1);
    }

    //---Ex3
    @Test
    @Order(1)

    public void successfulRegistration() {
        driver.findElement(By.linkText("register")).click();
        driver.findElement(By.cssSelector("#user_login")).sendKeys(userLogin);
        driver.findElement(By.cssSelector("#user_email")).sendKeys(userEmail);
        driver.findElement(By.cssSelector("#user_confirm_password")).sendKeys(userPassword);
        driver.findElement(By.cssSelector("#user_pass")).sendKeys(userPassword);
        driver.findElement(By.cssSelector(".btn")).click();
        Wait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("#ur-submit-message-node")));
        Assertions.assertEquals("User successfully registered.", driver.findElement(By.cssSelector("#ur-submit-message-node")).getText());
    }

    //---Ex4
    @Test
    @Order(4)
    // Presence of the logo
    public void presenceOfLogo() {
        driver.findElement(By.cssSelector(".site-title"));
        String logo = driver.findElement(By.cssSelector(".site-title")).getText();
        Assertions.assertEquals("Softie Metal Shop", logo);
    }

    // Presence of the searching field
    @Test
    @Order(5)

    public void presenceOfSearcher() {
        driver.findElement(By.cssSelector("#woocommerce-product-search-field-0"));
        WebElement search = driver.findElement(By.cssSelector("#woocommerce-product-search-field-0"));
        Assertions.assertTrue(search.isDisplayed());
    }

    //---Ex5
    // Moving from the main page to the contact page
    @Test
    @Order(6)
    public void mainPageToContactPage() {
        contactPage.click();
        WebElement yourMessageField = driver.findElement(By.cssSelector(".wpcf7-form-control"));
        Assertions.assertTrue(yourMessageField.isDisplayed());
    }

    //---Ex6
    // Moving from the login page to the main page
    @Test
    @Order(7)
    public void loginPageToMainPage() {
        myAccount.click();
        driver.findElement(By.cssSelector(".beta > a")).click();
        WebElement mainPageTitle = driver.findElement(By.cssSelector(".woocommerce-products-header__title"));
        Assertions.assertTrue(mainPageTitle.isDisplayed());
    }

    //---Ex7
    // Sending message from contact form
    @Test
    @Order(8)
    public void sendingMessage() {
        contactPage.click();
        driver.findElement(By.cssSelector(".wpcf7-form-control")).sendKeys(nameAndSurname);
        driver.findElement(By.cssSelector(".wpcf7-email")).sendKeys(userEmail);
        driver.findElement(By.cssSelector("input[name = 'your-subject']")).sendKeys(messageSubject);
        driver.findElement(By.cssSelector(".wpcf7-textarea")).sendKeys(messageText);
        driver.findElement(By.cssSelector(".wpcf7-submit")).click();

        WebElement errorMessage = driver.findElement(By.xpath("//div[text() = 'Wystąpił problem z wysłaniem twojej wiadomości. Spróbuj ponownie później.']"));
        Assertions.assertTrue(errorMessage.isDisplayed());
    }

    //---Ex8
    // Checking if the shopping cart is empty
    @Test
    @Order(9)
    public void isTheShoppingCartEmpty() {
        shoppingCart.click();
        WebElement emptyCartText = driver.findElement(By.cssSelector(".cart-empty"));
        Assertions.assertTrue(emptyCartText.isDisplayed());
    }
    // Adding an item to the shopping cart

    @Test
    @Order(10)
    public void addingItemToTheShoppingCart() {
        selectRandomProduct.click();
        driver.findElement(By.cssSelector(".single_add_to_cart_button")).click();
        WebElement addedToChartConfirmed = driver.findElement(By.cssSelector(".woocommerce-message"));
        Assertions.assertTrue(addedToChartConfirmed.isDisplayed());
    }
    //---Ex9
    // Removing item from the shopping cart
    @Test
    @Order(11)
    public void removingItemFromTheShoppingCart() {
        selectRandomProduct.click();
        driver.findElement(By.cssSelector(".single_add_to_cart_button")).click();
        driver.findElement(By.cssSelector(".woocommerce-message > a")).click(); // see the chart
        driver.findElement(By.cssSelector(".remove")).click();

        String removalText = driver.findElement(By.cssSelector(".woocommerce-message")).getText();
        Assertions.assertTrue(removalText.contains("Usunięto"));
    }

    //---***Returning items tests
    @Test
    @Order(12)
    //---Check if "Send" button is disabled before agreement for commercial information
    public void returnAnItem() {
        returnItem.click();
        driver.findElement(By.name("your-name")).sendKeys(nameAndSurname);
        driver.findElement(By.cssSelector(".wpcf7-validates-as-email")).sendKeys(userEmail);
        driver.findElement(By.name("your-subject")).sendKeys(itemToReturn);
        driver.findElement(By.name("your-message")).sendKeys(messageText);
        driver.findElement(By.cssSelector("input[value='Zwrot na konto (przelew)']")).click();
        //driver.findElement(By.name("acceptance-574")).click();
        WebElement sendButton = driver.findElement(By.cssSelector(".has-spinner"));
        Assertions.assertFalse(sendButton.isEnabled());
    }
    @Test
    @Order(13)
    //---Check if all refund checkboxes can be ticked
    // (Chciałam zrobić WebElementy powyżej, gdzie mam wszystkie, ale niestety kod wtedy przestał działać - jaka może być przyczyna?)
    public void returnAnItemRefundOptions() {
        returnItem.click();
        WebElement refundTransferOption = driver.findElement(By.cssSelector("input[value='Zwrot na konto (przelew)']"));
        refundTransferOption.click();
        WebElement refundCardOption = driver.findElement(By.cssSelector("input[value='Zwrot na kartę']"));
        refundCardOption.click();
        WebElement refundDeliveryManOption = driver.findElement(By.cssSelector("input[value='Zwrot gotówki przez kuriera']"));
        refundDeliveryManOption.click();
        WebElement refundInPointsOption = driver.findElement(By.cssSelector("input[value='Punkty do wykorzystana w sklepie']"));
        refundInPointsOption.click();
        Assertions.assertTrue((refundTransferOption.isEnabled()) && (refundCardOption.isEnabled())
                && (refundInPointsOption.isEnabled()) && (refundDeliveryManOption.isEnabled()));
    }

    @Test
    @Order(14)
    //---Check if the coupon box is displayed + if it is possible to use the coupon with random number
    public void couponBoxDisplayed() {
        selectRandomProduct.click();
        driver.findElement(By.cssSelector(".single_add_to_cart_button")).click();
        WebElement orderPage = driver.findElement(By.cssSelector("#menu-item-126"));
        orderPage.click();
        WebElement showCouponBox = driver.findElement(By.cssSelector(".showcoupon"));
        showCouponBox.click();
        WebElement couponBox = driver.findElement(By.name("coupon_code"));
        String couponNumberAsString = Integer.toString(couponNumber);
        couponBox.sendKeys(couponNumberAsString);
        WebElement useTheCoupon = driver.findElement(By.cssSelector("button[value='Wykorzystaj kupon']"));
        useTheCoupon.click();
        WebElement nonexistentCoupon = driver.findElement(By.cssSelector(".woocommerce-error > li"));
        String nonexistenceCouponText = nonexistentCoupon.getText();
        //System.out.println(nonexistenceCouponText);
        Assertions.assertTrue(nonexistenceCouponText.contains(("Kupon"))
                && nonexistenceCouponText.contains("nie istnieje!"));
    }

    @Test
    @Order(15)
    // Display on the page and on the console all possible sorting options
    public void displaySortingOptions() {
        //Display on the page
        WebElement sortingOptions = driver.findElement(By.className("orderby"));
        sortingOptions.click();
        //Display on the console
        Select sortingOption = new Select(sortingOptions);
        List<WebElement> options = sortingOption.getOptions();

        for (int i = 0; i < options.size(); i++) {
            System.out.println(options.get(i).getText());
        }
    }
    @Test
    @Order(16)
    // Add item to the shopping cart and check if the "price" is equal to the "amount"

    //---***---Ex10
    //---***---Ex11

    @AfterAll
    public static void closeBrowser() {
        driver.quit();
    }

    }

