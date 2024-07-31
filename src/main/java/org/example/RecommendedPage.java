package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class RecommendedPage {
    private WebDriver driver;

    //Constructor
    public RecommendedPage (WebDriver driver){this.driver =driver ;}

    //js

    private By recommendedItemText = By.xpath("//div[@class=\"recommended_items\"]");
    private By addToCartButton = By.xpath("//div[@class=\"carousel slide\"]//a[@data-product-id=\"1\"]");
    private By viewCartButton = By.xpath("//p[@class=\"text-center\"]//a[@href=\"/view_cart\"]");
    private By productInCart = By.xpath("//tr[@id=\"product-1\"]");


    public void navigateToURL(String URL) {
        driver.get(URL);
    }
    public void verifyRecommendedAreVisible() {driver.findElement(recommendedItemText).isEnabled();}
    public void addToCart (){driver.findElement(addToCartButton).click();}
    public void viewCart (){driver.findElement(viewCartButton).click();}
    public void verifyProductInCart (){driver.findElement(productInCart).isEnabled();}

    public void scrollToWebElement(){
        WebElement iframe = driver.findElement(recommendedItemText);
        new Actions(driver)
                .scrollToElement(iframe)
                .perform();


    }


}
