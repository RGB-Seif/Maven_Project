package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Stack;

public class RegisterPage {
    //driver
    private WebDriver driver;

    //Constructor
    public RegisterPage(WebDriver driver) {
        this.driver = driver;
    }


    //Elements
    private By signupPageButton = By.xpath("//a[@href=\"/login\"]");
    private By registerName = By.xpath(" //input[@data-qa=\"signup-name\"]");
    private By registerMail = By.xpath("//input[@data-qa=\"signup-email\"]");
    private By submitSignupButton = By.xpath("//button[@data-qa=\"signup-button\"]");
    private By genderMale = By.xpath(" //input[@id=\"id_gender1\"]");
    private By infoName = By.id("name");
    private By registerPassword = By.id("password");
    private By infoDay = By.id("days");
    private By birthDay = By.xpath("//select[@id=\"days\"]//option[@value=\"26\"]");
    private By infoMonth = By.id("months");
    private By birthMonth = By.xpath("//select[@id=\"months\"]//option[@value=\"10\"]");
    private By infoYear = By.id("years");
    private By birthYear = By.xpath("//option[@value=\"1998\"]");
    private By newsLetterCheckBox = By.id("newsletter");
    private By offersCheckBox = By.id("optin");
    private By firstNameField = By.id("first_name");
    private By lastNameField = By.id("last_name");
    private By companyField = By.id("company");
    private By addressOneField = By.id("address1");
    private By adressTwoField = By.id("address2");
    private By countryField = By.id("country");
    private By canadaSlot = By.xpath("//option[@value=\"Canada\"]");
    private By stateField = By.id("state");
    private By cityField = By.id("city");
    private By zipCodeField = By.id("zipcode");
    private By mobileNumberField = By.id("mobile_number");
    private By creatAccountButton = By.xpath("//button[@data-qa=\"create-account\"]");
    private By deleteAccountButton = By.xpath("//a[@href=\"/delete_account\"]");
    private By continueButton = By.xpath("//a[@data-qa=\"continue-button\"]");


    //Methods
    public void navigateToURL(String URL) {
        driver.get(URL);
    }

    public void clickOnSignPageButton() {
        driver.findElement(signupPageButton).click();
    }

    private void fillName(String name) {
        driver.findElement(registerName).sendKeys(name);
    }

    private void fillRegisterEmail(String email) {
        driver.findElement(registerMail).sendKeys(email);
    }

    public void fillLoginData(String name, String email) {
        fillName(name);
        fillRegisterEmail(email);
    }
    public void clickOnSignUpButton() {
        driver.findElement(submitSignupButton).click();
    }

    public void clickOnMale() {
        driver.findElement(genderMale).click();
    }

    public void clearInfoName() {
        driver.findElement(infoName).clear();
    }
    public void fillInfoName(String name) {
        driver.findElement(infoName).sendKeys(name);
    }

    private void fillPassword(String password) {
        driver.findElement(registerPassword).sendKeys(password);
    }
    public void fillInfoData(String name, String password) {
        clearInfoName();
        fillInfoName(name);
        fillPassword(password);
    }

    public void fillDay() {
        driver.findElement(infoDay).click();
        driver.findElement(birthDay).click();
    }

    public void fillMonth() {
        driver.findElement(infoMonth).click();
        driver.findElement(birthMonth).click();
    }

    public void fillYear() {
        driver.findElement(infoYear).click();
        driver.findElement(birthYear).click();
    }
    public void fillBirthDate (){
        fillDay();
        fillMonth();
        fillYear();
    }

    public void clickOnNewsletterCheckBox() {
        driver.findElement(newsLetterCheckBox).click();
    }

    public void clickOnReceiveOffersCheckBox() {
        driver.findElement(offersCheckBox).click();
    }

    public void fillFirstName(String firstN) {
        driver.findElement(firstNameField).sendKeys(firstN);
    }

    public void fillLastName(String lastN) {
        driver.findElement(lastNameField).sendKeys(lastN);
    }

    public void fillCompany(String company) {

        driver.findElement(companyField).sendKeys(company);
    }

    public void fillAddress(String addressOne) {
        driver.findElement(addressOneField).sendKeys(addressOne);
    }

    public void fillAddressTwo(String addressTwo) {
        driver.findElement(adressTwoField).sendKeys(addressTwo);
    }
    public void fillAddressData(String firstN, String lastN,
                                String company, String addressOne, String addressTwo) {
        fillFirstName(firstN);
        fillLastName(lastN);
        fillCompany(company);
        fillAddress(addressOne);
        fillAddressTwo(addressTwo);
    }
    public void chooseCountry() {
        driver.findElement(countryField).click();
        driver.findElement(canadaSlot).click();
    }

    public void fillState(String state) {
        driver.findElement(stateField).sendKeys(state);
    }

    public void fillCity(String city) {
        driver.findElement(cityField).sendKeys(city);
    }

    public void fillZipCode(String zipCode) {
        driver.findElement(zipCodeField).sendKeys(zipCode);
    }

    public void fillMobileNumber(String mobileNumber) {
        driver.findElement(mobileNumberField).sendKeys(mobileNumber);
    }

    public void fillRemainingInfo (String state, String city,
    String zipCode, String mobileNumber){
        fillState(state);
        fillCity(city);
        fillZipCode(zipCode);
        fillMobileNumber(mobileNumber);
    }

    public void clickOnCreateAccountButton (){
        driver.findElement(creatAccountButton).click();
    }
    public void clickOnContinueButton (){
        driver.findElement(continueButton).click();
    }
    public void clickOnDeleteAccountButton (){
        driver.findElement(deleteAccountButton).click();
    }

}