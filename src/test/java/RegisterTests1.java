import org.example.RegisterPage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RegisterTests1 {
    private WebDriver driver;
    private RegisterPage registerPage;

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
    private String addressOne = "Nasr City";
    private String addressTwo = "New Cairo";
    private String state = "Ontario";
    private String city = "Toronto";
    private String zipCode = "11835";
    private String mobileNumber = "01111111111";


    private By homePageImg = By.xpath("//img[@src=\"/static/images/home/logo.png\"]");
    private By signUpTitle = By.xpath("//div[@class=\"signup-form\"]//h2");
    private By accountInfoTitle = By.xpath("//b[text()=\"Enter Account Information\"]");
    private By infoEmail = By.id("email");
    private By loggedInAsUserTitle = By.xpath("//i[@class=\"fa fa-user\"]");
    private By accountCreatedTitle = By.xpath("//h2[@data-qa=\"account-created\"]");
    private By accountDeletedTitle = By.xpath("//h2[@data-qa=\"account-deleted\"]");


    @BeforeMethod
    public void setup(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        registerPage = new RegisterPage(driver);
        registerPage.navigateToURL(automationExerciseURL);
    }

    @Test
    public void validateRegister(){
        Assert.assertTrue(driver.findElement(homePageImg).isDisplayed());
        registerPage.clickOnSignPageButton();
        Assert.assertTrue(driver.findElement(signUpTitle).isDisplayed());
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
        registerPage.clickOnDeleteAccountButton();
        Assert.assertTrue(driver.findElement(accountDeletedTitle).isDisplayed());


    }

   @AfterMethod
   public void tearDown(){
        driver.quit();}
}



