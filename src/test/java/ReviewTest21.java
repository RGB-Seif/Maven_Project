import org.example.ReviewPage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ReviewTest21 {
    private WebDriver driver;

    private JavascriptExecutor js;

    private ReviewPage reviewPage;

    private String automationExerciseURL = "https://automationexercise.com/";
    private String email = "ragab.seif98@gmail.com";
    private String name = "Seif Ragab";
    private String review = "Very good product";

    private By successAlert = By.xpath("//div[@class=\"alert-success alert\"]//span[\"Thank you for your review.\"]");
    private By writeYourReview = By.xpath("//a[@href=\"#reviews\"]");
    private By allProductsTitle = By.xpath("//h2[@class=\"title text-center\"]");

    @BeforeMethod
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        reviewPage = new ReviewPage(driver);
        js = (JavascriptExecutor) driver;
        reviewPage.navigateToURL(automationExerciseURL);
    }
    @Test
    public void validateOrderReview() {
        reviewPage.clickOnProductsButton();
        //js.executeScript("window.scrollBy(0,2000)");
        Assert.assertTrue(driver.findElement(allProductsTitle).isDisplayed());
        js.executeScript("window.scrollBy(0,500)");
        reviewPage.clickOnViewProductButton();
        js.executeScript("window.scrollBy(0,600)");
        Assert.assertTrue(driver.findElement(writeYourReview).isEnabled());
        reviewPage.fillLoginData(email, name, review);
        reviewPage.clickSubmitButton();
        Assert.assertTrue(driver.findElement(successAlert).isDisplayed());
    }


    @AfterMethod
    public void tearDown(){
        driver.quit();
    }



}


