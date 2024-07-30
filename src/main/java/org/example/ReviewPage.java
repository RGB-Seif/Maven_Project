package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ReviewPage {

    private WebDriver driver;

    public ReviewPage (WebDriver driver){this.driver =driver ;}

    private By productsButton = By.xpath("//a[@href=\"/products\"]");
    private By viewProductButton = By.xpath("//a[@href=\"/product_details/1\"]");
    private By yourName = By.xpath("//input[@id=\"name\"]");
    private By emailAdress = By.xpath("//input[@id=\"email\"]");
    private By addReviewHere = By.xpath(" //textarea[@id=\"review\"]");
    private By submitButton = By.xpath("//button[@id=\"button-review\"]");


    public void navigateToURL(String URL){
        driver.get(URL);
    }

    public void clickOnProductsButton (){
        driver.findElement(productsButton).click();
    }
    public void clickOnViewProductButton (){
        driver.findElement(viewProductButton).click();
    }

    public void fillName (String name){
        driver.findElement(yourName).sendKeys(name);
    }

    public void fillEmail (String email){
        driver.findElement(emailAdress).sendKeys(email);
    }

    public void fillReview (String review){
        driver.findElement(addReviewHere).sendKeys(review);
    }


    public void fillLoginData (String email,String name, String review){
        fillEmail(email);
        fillName(name);
        fillReview(review);
    }

    public void clickSubmitButton (){
        driver.findElement(submitButton).click();
    }

}
