package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AddressDetailsInCheckoutPage {

    private WebDriver driver;

    //Constructor
    public AddressDetailsInCheckoutPage(WebDriver driver) {
        this.driver = driver;
    }

    private By signUpSignInButton = By.xpath("//a[@href=\"/login\"]");
    private By gender =By.xpath("//input[@id=\"id_gender1\"]");
    private By nameField = By.xpath("//input[@data-qa=\"signup-name\"]");
    private By emailField = By.xpath("//input[@data-qa=\"signup-email\"]");
    private By signUpBottun = By.xpath("//button[@data-qa=\"signup-button\"]");
    private By passowrd =By.xpath("//input[@type=\"password\"]");
    private By daysButton =By.xpath("//select[@id=\"days\"]//option[@value=\"11\"]");
    private By monthButton = By.xpath("//select [@data-qa=\"months\"]");
    private By monthSelect = By.xpath("//select[@data-qa=\"months\"]//option[@value=\"3\"]");
    private By year =By.xpath("//option[@value=\"2001\"]");
    private By companyName = By.xpath("//input[@data-qa=\"company\"]");
    private By firstNameField = By.xpath("//input[@data-qa=\"first_name\"]");
    private By lastName = By.xpath("//input[@data-qa=\"last_name\"]");
    private By adress =By.xpath("//input[@data-qa=\"address\"]");
    private By countryButton = By.xpath("//select[@id=\"country\"]");
    private By countrySleect = By.xpath("//option[@value=\"Canada\"]");
    private By state =By.xpath("//input[@data-qa=\"state\"]");
    private By cityFlield = By.xpath("//input[@data-qa=\"city\"]");
    private By zipField =By.xpath("//input[@data-qa=\"zipcode\"]");
    private By mobileNumField =By.xpath("//input[@data-qa=\"mobile_number\"]");
    private By submetButton =By.xpath("//button[@data-qa=\"create-account\"]");
    private By accountIsCreated = By.xpath("//h2[@class=\"title text-center\"][@style=\"color: green;\"]");
    private By continueButton = By.xpath("data-qa=\"continue-button\"");
    private By accountCreatedTitel = By.xpath("//h2[@class=\"title text-center\"]//b[text()='Account Created!']");
    private By userNameInTop = By.xpath("//i[@class=\"fa fa-user\"]");
    private By addToCartButton = By.xpath("data-product-id=\"1\"");]
    private By continueShoppingButton = By.xpath("//button[@class=\"btn btn-success close-modal btn-block\"]");
    private By cartButton = By.xpath("href=\"/view_cart\"");
    private By cartIsDisplayed = By.xpath("//section[@id=\"cart_items\"]");
    private By proceedToCheckOut = By.xpath("class=\"btn btn-default check_out\"");




}