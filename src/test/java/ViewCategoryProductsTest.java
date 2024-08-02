import org.example.ViewCategoryProducts;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ViewCategoryProductsTest {
    private WebDriver driver;

    private ViewCategoryProducts viewCategoryProducts;

    private String automationExerciseURL = "https://automationexercise.com/";
    private By categories = By.xpath("//div[@class=\"panel-group category-products\"]");
    private By titleText = By.xpath("//h2[@class=\"title text-center\"]");


    @BeforeMethod
    public void setup(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        viewCategoryProducts = new ViewCategoryProducts(driver);
        viewCategoryProducts.navigateToURL(automationExerciseURL);
    }

    @Test
    public void ViewCategory(){
        Assert.assertTrue(driver.findElement(categories).isDisplayed());
        viewCategoryProducts.clickOnWomenButton();
        viewCategoryProducts.clickOnDressButton();
        Assert.assertTrue(driver.getCurrentUrl().contains("automationexercise.com/category_products/1"));
        Assert.assertEquals(driver.findElement(titleText).getText(), "WOMEN - DRESS PRODUCTS");
        viewCategoryProducts.clickOnMenButton();
        viewCategoryProducts.clickOnJeansButton();
        Assert.assertTrue(driver.getCurrentUrl().contains("automationexercise.com/category_products/6"));

    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }


}

