import org.example.LoginPage;
import org.example.RegisterPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTests {
    private WebDriver driver;

    private LoginPage loginPage;
    private RegisterPage registerPage;

    private String automationExerciseURL = "https://automationexercise.com/";
    private String email = "userx@gmail.com";
    private String password = "abcd123456";

    private By logoutButton = By.xpath("//a[@href=\"/logout\"]");

    @BeforeMethod
    public void setup(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        loginPage = new LoginPage(driver);
        registerPage = new RegisterPage(driver);
        loginPage.navigateToURL(automationExerciseURL);
    }

    @Test
    public void validateLogin(){
        loginPage.clickOnLoginPageButton();
        loginPage.fillLoginData(email,password);
        loginPage.clickLoginButton();
        Assert.assertTrue(driver.findElement(logoutButton).isEnabled());
        registerPage.clickOnDeleteAccountButton();
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }


}
