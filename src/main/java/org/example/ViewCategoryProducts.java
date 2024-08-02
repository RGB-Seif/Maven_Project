package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ViewCategoryProducts {
    //driver
    private WebDriver driver;

    //Constructor
    public ViewCategoryProducts(WebDriver driver){this.driver =driver ;}


    //Elements
    private By womenButton = By.xpath("//a[@href=\"#Women\"]");
    private By dressButton = By.xpath("//a[@href=\"/category_products/1\"]");
    private By menButton = By.xpath("//a[@href=\"#Men\"]");
    private By jeansButton = By.xpath("//a[@href=\"/category_products/6\"]");


    //Methods
    public void navigateToURL(String URL){
        driver.get(URL);
    }

    public void clickOnWomenButton (){
        driver.findElement(womenButton).click();
    }

    public void clickOnDressButton (){
        driver.findElement(dressButton).click();
    }

    public void clickOnMenButton (){
        driver.findElement(menButton).click();
    }

    public void clickOnJeansButton (){
        driver.findElement(jeansButton).click();
    }




}
