import org.example.LoginPage;
import org.example.OrderPage;
import org.example.RegisterPage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class AddToCartFromRecommendedTests {
    private WebDriver driver;
    private OrderPage orderPage;
    private JavascriptExecutor js;
    private WebDriverWait wait;


    private String automationExerciseURL = "https://automationexercise.com/";

    private By homePageImg = By.xpath("//img[@src=\"/static/images/home/logo.png\"]");
    private By recommendedItemsTitle = By.xpath("//div[@class=\"recommended_items\"]//h2[@class=\"title text-center\"]");
    private By cartTable = By.xpath("//table[@class=\"table table-condensed\"]");
    private By recommendedItem = By.xpath("//div[@class=\"recommended_items\"]//a[@data-product-id=\"4\"]");


    @BeforeMethod
    public void setup(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        orderPage = new OrderPage(driver);
        js = (JavascriptExecutor) driver;
        orderPage.navigateToURL(automationExerciseURL);
    }

    @Test
    public void AddToCartFromRecommended(){
        Assert.assertTrue(driver.findElement(homePageImg).isDisplayed());
        orderPage.scrollToElement();
        Assert.assertTrue(driver.findElement(recommendedItemsTitle).isDisplayed());
        WebElement recommendedItem1 = driver.findElement(recommendedItem);
        driver.findElement(recommendedItem).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOf(recommendedItem1));
        orderPage.clickOnViewCart();
        Assert.assertTrue(driver.findElement(cartTable).getText().contains("Stylish Dress"));

    }

    @AfterMethod
    public void tearDown(){
        driver.quit();}
}




