
package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class VerifyHomePageSubs {
    //driver
    private WebDriver driver;

    //Constructor
    public VerifyHomePageSubs(WebDriver driver) {
        this.driver = driver;
    }


    //Elements
    private By EmailTextField = By.xpath("//input[@type=\"email\"]");
    private By ArrowButton = By.xpath("//button[@type=\"submit\"]");


    //Methods
    public void navigateToURL(String URL) {
        driver.get(URL);
    }


    public void fillEmail(String email) {
        driver.findElement(EmailTextField).sendKeys(email);
    }

    public void clickArrowButton() {
        driver.findElement(ArrowButton).click();

    }
}
