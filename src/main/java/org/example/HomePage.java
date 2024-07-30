package org.example;

import dev.failsafe.internal.util.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class HomePage {
        //driver
        private WebDriver driver;

        //Constructor
        public HomePage (WebDriver driver){this.driver =driver ;}


        //Elements
        private By subscriptionTitle  = By.xpath("//h2[text() = \"Subscription\"]");
        private By scrollUpButton = By.xpath("//a[@id=\"scrollUp\"]");

        //Methods
        public void navigateToURL(String URL){
                driver.get(URL);
        };


        public void clickOnScrollUpArrow() {
                driver.findElement(scrollUpButton).click();
        }


}

