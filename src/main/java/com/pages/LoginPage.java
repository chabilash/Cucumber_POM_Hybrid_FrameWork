package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

	
	private WebDriver driver;
	
//	@FindBy(xpath = "//span[text()='My Account']")
//	@CacheLookup
//	private WebElement myAccount;
	
	// By Locators
	private By myAccount           = By.xpath("//span[text()='My Account']");
	private By login               = By.xpath("//ul[@class='dropdown-menu dropdown-menu-right']//li[2]/a");
	private By emailId             = By.id("input-email");
	private By password            = By.id("input-password");
	private By btnLogin            = By.xpath("//input[@type='submit']");
	private By forgottenPwdLink    = By.linkText("Forgotten Password111");
	
	//Constructor
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}
	
	//Page actions : form of methods
	public String getHomePageTitle() {
		return driver.getTitle();
	}
	
	public String getAccountPageTitle() {
		return driver.getTitle();
	}
	
	public boolean isForgottenPasswordLinkExists() {
		return driver.findElement(forgottenPwdLink).isDisplayed();
	}
	
	public void enterEmail(String userName) {
		driver.findElement(emailId).sendKeys(userName);
	}
	
	public void enterPassword(String pwd) {
		driver.findElement(password).sendKeys(pwd);
	}
	
	public void clickOnLoginButton() {
		driver.findElement(btnLogin).click();
	}
	
	public void clickOnMyAccountInHomePage() {
		driver.findElement(myAccount).click();
	}
	
	public void clickOnLoginInHomePage() {
		driver.findElement(login).click();
	}
	
	public AccountsPage doEnterCredsAndLogin(String email,String pwd) {
		
		driver.findElement(emailId).sendKeys(email);
		driver.findElement(password).sendKeys(pwd);
		driver.findElement(btnLogin).click();
		System.out.println("Login with email : "+email+ " and password : "+pwd+" is successful");
		return new AccountsPage(driver);
	}


}
