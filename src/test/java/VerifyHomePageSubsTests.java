import org.example.VerifyHomePageSubs;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class VerifyHomePageSubsTests {
    private WebDriver driver;
    private JavascriptExecutor js;

    private VerifyHomePageSubs verifyHomePageSubs;

    private String automationExerciseURL = "https://automationexercise.com/";
    private String email = "islam@gmail.com";
    private By SubscriptionTitle  = By.xpath("//h2[text() = \"Subscription\"]");
    private By SubscribtionAlert = By.xpath("//div[@class=\"alert-success alert\"]");


    @BeforeMethod
    public void setup(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        verifyHomePageSubs = new VerifyHomePageSubs(driver);
        js = (JavascriptExecutor) driver;

        verifyHomePageSubs.navigateToURL(automationExerciseURL);
    }

    @Test
    public void verifySubs(){
        Assert.assertTrue(driver.getCurrentUrl().contains("https://automationexercise.com/"));
        js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
        Assert.assertTrue(driver.findElement(SubscriptionTitle).isDisplayed());
        verifyHomePageSubs.fillEmail(email);
        verifyHomePageSubs.clickArrowButton();
        Assert.assertEquals(driver.findElement(SubscribtionAlert).getText(), "You have been successfully subscribed!");

    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }


}

