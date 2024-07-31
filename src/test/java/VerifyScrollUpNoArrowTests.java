
import org.example.HomePage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class VerifyScrollUpNoArrowTests {
    private WebDriver driver;
    private JavascriptExecutor js;
    private HomePage homePage;


    private String automationExerciseURL = "https://automationexercise.com/";
    private By subscriptionTitle  = By.xpath("//h2[text() = \"Subscription\"]");
    private By orangeHomeButton = By.xpath("//a[@href=\"/\" and @style=\"color: orange;\"]");
    private By carouselTitle = By.xpath("//div[@id=\"slider-carousel\"]//div[@class=\"carousel-inner\"]");


    @BeforeMethod
    public void setup(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        homePage = new HomePage(driver);
        js = (JavascriptExecutor) driver;
        homePage.navigateToURL(automationExerciseURL);
    }

    @Test
    public void validateScroll(){
        Assert.assertTrue(driver.findElement(orangeHomeButton).isEnabled());
        js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(7));
        Assert.assertTrue(driver.findElement(subscriptionTitle).isDisplayed());
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        Assert.assertTrue(driver.findElement(carouselTitle).getText()
                .contains("Full-Fledged practice website for Automation Engineers"));
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

}
