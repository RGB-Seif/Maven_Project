import org.example.LoginPage;
import org.example.OrderPage;
import org.example.RegisterPage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginBeforeCheckoutTests {
    private WebDriver driver;
    private OrderPage orderPage;
    private LoginPage loginPage;
    private RegisterPage registerPage;
    private JavascriptExecutor js;


    private String automationExerciseURL = "https://automationexercise.com/";
    private String email = "usery@gmail.com";
    private String password = "abcd123456";
    private String nameOnCard= "user x";
    private String cardNumber = "12345678987654321";
    private String cvc = "456";
    private String expMonth = "10";
    private String expYear = "26";
    private String comment = "Please send the items as advertised and same colors. thank you";

    private By homePageImg = By.xpath("//img[@src=\"/static/images/home/logo.png\"]");
    private By accountDeletedTitle = By.xpath("//h2[@data-qa=\"account-deleted\"]");
    private By successMessage = By.xpath("//div[@id=\"success_message\"]//div[@class=\"alert-success alert\"]");
    private By orangeCartButton = By.xpath("//ul[@class=\"nav navbar-nav\"]//a[@href=\"/view_cart\" and @style= \"color: orange;\"]");
    private By addressBox = By.xpath("//ul[@id=\"address_delivery\"]");


    @BeforeMethod
    public void setup(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        orderPage = new OrderPage(driver);
        loginPage = new LoginPage(driver);
        registerPage = new RegisterPage(driver);
        js = (JavascriptExecutor) driver;
        orderPage.navigateToURL(automationExerciseURL);
    }

    @Test
    public void validateRegisterWhileOrdering(){
        Assert.assertTrue(driver.findElement(homePageImg).isDisplayed());
        loginPage.clickOnLoginPageButton();
        loginPage.fillLoginData(email, password);
        loginPage.clickLoginButton();
        orderPage.addProductsToCart();
        orderPage.clickCartButton();
        Assert.assertTrue(driver.findElement(orangeCartButton).isDisplayed());
        orderPage.clickProceedToCheckout();
        orderPage.fillDescriptionAndPlaceOrder(comment);
        orderPage.fillPaymentDetails(nameOnCard, cardNumber, cvc, expMonth, expYear);
        orderPage.clickPayAndConfirmButton();
        Assert.assertTrue(driver.findElement(successMessage).getText().contains("Your order has been placed successfully") );
        registerPage.clickOnDeleteAccountButton();
        Assert.assertTrue(driver.findElement(accountDeletedTitle).isDisplayed());
        registerPage.clickOnContinueAfterDelete();

    }

    @AfterMethod
    public void tearDown(){
        driver.quit();}
}



