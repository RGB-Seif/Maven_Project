package org.example;

import dev.failsafe.internal.util.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.security.PublicKey;
import java.time.Duration;

public class OrderPage {

    private WebDriver driver;
    private WebDriverWait wait;

    public OrderPage(WebDriver driver) {
        this.driver = driver;
    }





    private String company = "Amit";
    private String country = "canada";
    private String addressOne = "Nasr City";
    private String addressTwo = "New Cairo";
    private String state = "Ontario";
    private String city = "Toronto";
    private String zipCode = "11835";
    private String mobileNumber = "01111111111";
    private String fullName ="User X";



    private By addToCartButton1 = By.xpath("//div[@class=\"features_items\"]//div[@class=\"productinfo text-center\"]//a[@data-product-id=\"1\"]");
    private By addToCartButton2 = By.xpath("//div[@class=\"features_items\"]//div[@class=\"productinfo text-center\"]//a[@data-product-id=\"2\"]");
    private By addToCartButton3 = By.xpath("//div[@class=\"features_items\"]//div[@class=\"productinfo text-center\"]//a[@data-product-id=\"3\"]");
    private By continueShoppingButton = By.xpath("//button[@class=\"btn btn-success close-modal btn-block\"]");
    private By cartButton = By.xpath("//ul[@class=\"nav navbar-nav\"]//a[@href=\"/view_cart\"]");
    private By proceedToCheckoutButton = By.xpath("//a[@class=\"btn btn-default check_out\"]");
    private By checkoutRegisterButton = By.xpath("//p[@class=\"text-center\"]//a[@href=\"/login\"]");
    private By commentTextArea = By.xpath("//textarea[@class=\"form-control\"]");
    private By addressBox = By.xpath("//ul[@id=\"address_delivery\"]");
    private By placeOrderButton = By.xpath("//a[@href=\"/payment\"]");
    private By nameOnCardField = By.xpath("//input[@name=\"name_on_card\"]");
    private By cardNumberField = By.xpath("//input[@name=\"card_number\"]");
    private By cvcField = By.xpath("//input[@name=\"cvc\"]");
    private By expirationMonthField = By.xpath("//input[@name=\"expiry_month\"]");
    private By expirationYearField = By.xpath("//input[@name=\"expiry_year\"]");
    private By payOrderButton = By.xpath("//button[@id=\"submit\"]");
    private By recommendedItem = By.xpath("//div[@class=\"recommended_items\"]//a[@data-product-id=\"1\"]");
    private By recommendedItemsTitle = By.xpath("//div[@class=\"recommended_items\"]//h2[@class=\"title text-center\"]");
    private By viewCartButton = By.xpath("//div[@class=\"modal-content\"]//a[@href=\"/view_cart\"]");




    public void navigateToURL(String URL) {
        driver.get(URL);
    }

    public void addProduct1ToCart() {
        driver.findElement(addToCartButton1).click();
    }

    public void addProduct2ToCart() {
        driver.findElement(addToCartButton2).click();
    }

    public void addProduct3ToCart() {
        driver.findElement(addToCartButton3).click();
    }
    public void clickContinueShoppingButton() {
        driver.findElement(continueShoppingButton).click();
    }

    public void addProductsToCart() {
        addProduct1ToCart();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        clickContinueShoppingButton();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        addProduct2ToCart();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        clickContinueShoppingButton();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        addProduct3ToCart();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        clickContinueShoppingButton();
    }

    public void clickCartButton() {
        driver.findElement(cartButton).click();
    }

    public void clickProceedToCheckout() {
        driver.findElement(proceedToCheckoutButton).click();
    }

    public void clickCheckoutRegisterButton() {
        driver.findElement(checkoutRegisterButton).click();
    }
   /* public void assertAddressDetails() {
        Assert.isTrue(driver.findElement(addressBox).getText().contains(fullName), "Name check failed");
        Assert.isTrue(driver.findElement(addressBox).getText().contains(company), "company check failed");
        Assert.isTrue(driver.findElement(addressBox).getText().contains(addressOne), "Address one check failed");
        Assert.isTrue(driver.findElement(addressBox).getText().contains(addressTwo), "Address two check failed");
        Assert.isTrue(driver.findElement(addressBox).getText().contains(state), "State check failed");
        Assert.isTrue(driver.findElement(addressBox).getText().contains(city), "City check failed");
        Assert.isTrue(driver.findElement(addressBox).getText().contains(country), "Country check failed");
        Assert.isTrue(driver.findElement(addressBox).getText().contains(zipCode), "Zipcode check failed");
        Assert.isTrue(driver.findElement(addressBox).getText().contains(mobileNumber), "Mobile Number check failed");
    }*/
    public void fillCommentField(String comment) {
        driver.findElement(commentTextArea).sendKeys(comment);
    }
    public void clickPlaceOrderButton() {
        driver.findElement(placeOrderButton).click();
    }

    public void fillDescriptionAndPlaceOrder(String comment) {
        fillCommentField(comment);
        clickPlaceOrderButton();
    }

    private void fillNameOnCardField(String nameOnCard) {
        driver.findElement(nameOnCardField).sendKeys(nameOnCard);
    }
    private void fillCardNumberField(String cardNumber) {
        driver.findElement(cardNumberField).sendKeys(cardNumber);
    }
    private void fillCvcField(String cvc) {
        driver.findElement(cvcField).sendKeys(cvc);
    }
    private void fillExpMonthField(String expMonth) {
        driver.findElement(expirationMonthField).sendKeys(expMonth);
    }
    private void fillExpYearField(String expYear) {
        driver.findElement(expirationYearField).sendKeys(expYear);
    }

    public void fillPaymentDetails(String nameOnCard, String cardNumber,
                                   String cvc, String expMonth, String expYear) {
        fillNameOnCardField(nameOnCard);
        fillCardNumberField(cardNumber);
        fillCvcField(cvc);
        fillExpMonthField(expMonth);
        fillExpYearField(expYear);
    }

    public void clickPayAndConfirmButton() {
        driver.findElement(payOrderButton).click();
    }

    public void scrollToElement() {
        WebElement recommendedTitle = driver.findElement(recommendedItemsTitle);
        new Actions(driver)
                .scrollToElement(recommendedTitle)
                .perform();
    }

    public void addRecommendedItemToCart() {
        driver.findElement(recommendedItem).click();
    }

    public void clickOnViewCart() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        driver.findElement(viewCartButton).click();
    }

}
