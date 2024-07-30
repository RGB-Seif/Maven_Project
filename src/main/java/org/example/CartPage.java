package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class CartPage {
    //driver
    private WebDriver driver;

    //Constructor
    public CartPage (WebDriver driver){this.driver =driver ;}


    //Elements
    private By productsButton = By.xpath("//a[@href=\"/products\"]");
    private By searchBar = By.xpath("//input[@name=\"search\"]");
    private By searchButton = By.xpath("//button[@id=\"submit_search\"]");
    private By productOneCartButton = By.xpath("//div[@class=\"productinfo text-center\"]//a[@data-product-id=\"33\"]");
    private By productTwoCartButton = By.xpath("//div[@class=\"productinfo text-center\"]//a[@data-product-id=\"35\"]");
    private By productThreeCartButton = By.xpath("//div[@class=\"productinfo text-center\"]//a[@data-product-id=\"37\"]");
    private By continueShoppingButton = By.xpath("//button[@class=\"btn btn-success close-modal btn-block\"]");
    private By cartButton = By.xpath("//ul[@class=\"nav navbar-nav\"]//a[@href=\"/view_cart\"]");






    //Methods
    public void navigateToURL(String URL){
        driver.get(URL);
    }

    public void clickOnProductsButton (){
        driver.findElement(productsButton).click();
    }

    public void fillSearchBar (String productName){
        driver.findElement(searchBar).sendKeys(productName);
    }

    public void clickOnSearchButton (){
        driver.findElement(searchButton).click();
    }

    public void addProductOne () {
        driver.findElement(productOneCartButton).click();
    }
    public void addProductTwo () {
        driver.findElement(productTwoCartButton).click();
    }
    public void addProductThree () {
        driver.findElement(productThreeCartButton).click();
    }
    public void clickOnContinueShopping () {
        driver.findElement(continueShoppingButton).click();
    }

    public void addProductsToCart (){
        addProductOne();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        clickOnContinueShopping();
        addProductTwo();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        clickOnContinueShopping();
        addProductThree();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        clickOnContinueShopping();
    }

    public void clickCartButton (){
        driver.findElement(cartButton).click();
    }

    public void assertCartList () {
    }


}
