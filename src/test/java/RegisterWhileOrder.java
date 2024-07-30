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

public class RegisterWhileOrder {
    private WebDriver driver;
    private OrderPage orderPage;
    private RegisterPage registerPage;
    private JavascriptExecutor js;


    private String automationExerciseURL = "https://automationexercise.com/";
    private String name = "User1";
    private String email = "userx@gmail.com";
    private String password = "abcd123456";
    private String day = "26";
    private String month = "10";
    private String year = "1998";
    private String firstN = "User";
    private String lastN = "One";
    private String company = "Amit";
    private String country = "canada";
    private String addressOne = "Nasr City";
    private String addressTwo = "New Cairo";
    private String state = "Ontario";
    private String city = "Toronto";
    private String zipCode = "11835";
    private String mobileNumber = "01111111111";
    private String fullName ="User X";
    private String nameOnCard= "user x";
    private String cardNumber = "12345678987654321";
    private String cvc = "456";
    private String expMonth = "10";
    private String expYear = "26";
    private String comment = "Please send the items as advertised and same colors. thank you";

    private By homePageImg = By.xpath("//img[@src=\"/static/images/home/logo.png\"]");
    private By accountInfoTitle = By.xpath("//b[text()=\"Enter Account Information\"]");
    private By loggedInAsUserTitle = By.xpath("//i[@class=\"fa fa-user\"]");
    private By accountCreatedTitle = By.xpath("//h2[@data-qa=\"account-created\"]");
    private By accountDeletedTitle = By.xpath("//h2[@data-qa=\"account-deleted\"]");
    private By successMessage = By.xpath("//div[@id=\"success_message\"]//div[@class=\"alert-success alert\"]");
    private By orangeCartButton = By.xpath("//ul[@class=\"nav navbar-nav\"]//a[@href=\"/view_cart\" and @style= \"color: orange;\"]");
    private By addressBox = By.xpath("//ul[@id=\"address_delivery\"]");
    private By infoEmail = By.id("email");



    @BeforeMethod
    public void setup(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        orderPage = new OrderPage(driver);
        registerPage = new RegisterPage(driver);
        js = (JavascriptExecutor) driver;
        orderPage.navigateToURL(automationExerciseURL);
    }

    @Test
    public void validateRegisterWhileOrdering(){
        Assert.assertTrue(driver.findElement(homePageImg).isDisplayed());
        js.executeScript("window.scrollBy(0,150)");
        orderPage.addProductsToCart();
        orderPage.clickCartButton();
        Assert.assertTrue(driver.findElement(orangeCartButton).isDisplayed());
        orderPage.clickProceedToCheckout();
        orderPage.clickCheckoutRegisterButton();
        registerPage.fillLoginData(name, email);
        registerPage.clickOnSignUpButton();
        Assert.assertTrue(driver.findElement(accountInfoTitle).isDisplayed());
        registerPage.clickOnMale();
        registerPage.fillInfoData(name,  password);
        Assert.assertTrue(driver.findElement(infoEmail).getAttribute("Value").equals(email));
        registerPage.fillBirthDate();
        registerPage.clickOnNewsletterCheckBox();
        registerPage.clickOnReceiveOffersCheckBox();
        registerPage.fillAddressData(firstN, lastN, company, addressOne, addressTwo);
        registerPage.chooseCountry();
        registerPage.fillRemainingInfo(state, city, zipCode,mobileNumber);
        registerPage.clickOnCreateAccountButton();
        Assert.assertTrue(driver.findElement(accountCreatedTitle).isDisplayed());
        registerPage.clickOnContinueButton();
        Assert.assertTrue(driver.findElement(loggedInAsUserTitle).isDisplayed());
        orderPage.clickCartButton();
        orderPage.clickProceedToCheckout();
        //orderPage.assertAddressDetails();
        orderPage.fillDescriptionAndPlaceOrder(comment);
        orderPage.fillPaymentDetails(nameOnCard, cardNumber, cvc, expMonth, expYear);
        orderPage.clickPayAndConfirmButton();
        Assert.assertTrue(driver.findElement(successMessage).getText().contains("Your order has been placed successfully") );
        registerPage.clickOnDeleteAccountButton();
        Assert.assertTrue(driver.findElement(accountDeletedTitle).isDisplayed());





    }

    @AfterMethod
    public void tearDown(){
        driver.quit();}
}



