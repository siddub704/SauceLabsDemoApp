package com.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BaseClass {

	public static WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		super(driver);
	}
	
	public static WebDriver getDriver() {
		return driver;
	}

	@FindBy(id="user-name")
	private WebElement usernametxtfld;
	
	@FindBy(id="password")
	private WebElement passwordtxtfld;
	
	@FindBy(id="login-button")
	private WebElement loginbtn;
	
	@FindBy(className ="title")
	private WebElement products;
	
	@FindBy(css = ".error-message-container>h3")
	private WebElement error_message;

	public void setUsernametxtfld(String username) {
		usernametxtfld.sendKeys(username);
	}

	public void setPasswordtxtfld(String password) {
		passwordtxtfld.sendKeys(password);
	}

	public void setLoginbtn() {
		loginbtn.click();
	}
	
	public boolean ValidateSuccessfulLogin() {
		boolean status = products.isDisplayed();
		return status;
	}
	

	public String ValidateErrorMessage() {
		String error = error_message.getText();
		return error;
	}
	
}
