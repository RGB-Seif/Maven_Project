import org.example.*;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.SuiteRunner;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class VerifyCartAfterLoginTests {
    private WebDriver driver;
    private JavascriptExecutor js;
    private CartPage cartPage;
    private LoginPage loginPage;


    private String URL = "https://automationexercise.com/";
    private String productName = "jeans";
    private String email = "userx@gmail.com";
    private String password = "abcd123456";


    private By allProductsTitle  = By.xpath("//h2[@class=\"title text-center\"]");
    private By searchedProductsTitle = By.xpath("//h2[@class=\"title text-center\"]");
    private By cartTable = By.xpath("//tbody");




    @BeforeMethod
    public void setup(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        cartPage = new CartPage(driver);
        loginPage = new LoginPage(driver);
        js = (JavascriptExecutor) driver;
        cartPage.navigateToURL(URL);
    }

    @Test
    public void verifyCartAfterLogin(){
        cartPage.clickOnProductsButton();
        Assert.assertTrue(driver.getCurrentUrl().contains("https://automationexercise.com/products"));
        Assert.assertTrue(driver.findElement(allProductsTitle).getText().equalsIgnoreCase("All Products"));
        cartPage.fillSearchBar(productName);cartPage.clickOnSearchButton();
        Assert.assertTrue(driver.findElement(searchedProductsTitle).getText().equalsIgnoreCase("Searched Products"));
        cartPage.addProductsToCart();loginPage.clickOnLoginPageButton();
        loginPage.fillLoginData(email, password);loginPage.clickLoginButton();
        cartPage.clickCartButton();
        Assert.assertFalse(driver.findElements(cartTable).isEmpty());

    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

}
