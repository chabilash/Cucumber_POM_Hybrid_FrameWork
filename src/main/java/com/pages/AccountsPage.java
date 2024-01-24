package com.pages;

import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AccountsPage {
	
	private WebDriver driver;
	
	private By accountSections = By.xpath("//div[@id='content']/h2");
	
	public AccountsPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public String getAccountPageTitle() {
		return driver.getTitle();
	}
	
	public int getAccountsSectionCount() {
		return driver.findElements(accountSections).size();
	}
	
	public List<String> getAccountsSectionList() {
		List<String> accountHeaders = new ArrayList<>();
		List<WebElement> accHeaderList = driver.findElements(accountSections);
		for(WebElement e : accHeaderList ) {
			String text = e.getText();
			System.out.println(text);
			accountHeaders.add(text);
		}
		return accountHeaders;
	}
	

}
