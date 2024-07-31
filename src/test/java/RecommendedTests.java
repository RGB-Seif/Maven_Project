import org.example.RecommendedPage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.time.Duration;

public class RecommendedTests {

    private WebDriver driver;
    private RecommendedPage recommendedPage;
    private String automationExerciseURL = "https://automationexercise.com/";
    private JavascriptExecutor js;

    private WebDriverWait wait;
    private By addToCartButton = By.xpath("//div[@class=\"recommended_items\"]//a[@class=\"btn btn-default add-to-cart\"]");
    private By viewCartButton = By.xpath("//p[@class=\"text-center\"]//a[@href=\"/view_cart\"]");

    @BeforeMethod
    public void setup(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        recommendedPage = new RecommendedPage(driver);
        recommendedPage.navigateToURL(automationExerciseURL);
        js = (JavascriptExecutor) driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(50));

    }

    @Test
    public void verifyRecommendedIsVisible(){

        recommendedPage.scrollToWebElement();
        recommendedPage.verifyRecommendedAreVisible();
        WebElement waitTillProductVisible = driver.findElement(addToCartButton);
        WebElement waitTillViewCartVisible = driver.findElement(viewCartButton);
        wait.until(ExpectedConditions.visibilityOf(waitTillProductVisible));
        recommendedPage.addToCart();
        wait.until(ExpectedConditions.visibilityOf(waitTillViewCartVisible));
        recommendedPage.viewCart();
        recommendedPage.verifyProductInCart();
    }
    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
