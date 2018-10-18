package org.sunbird.page;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.sunbird.startup.BaseTest;
/**
* Created by Qualitrix Technologies Pvt Ltd.
* Purpose: To capture and maintain all webelements related to SignUpPage
*/
public class SignUpPage extends BaseTest {
	WebDriver driver;
	
	@FindBy(xpath="//div/button[.='SIGN UP']")
	public WebElement signUpButton;
	
	@FindBy(name="userName")
	public WebElement username;
	
	@FindBy(name="password")
	public WebElement password;
	
	@FindBy(name="firstName")
	public WebElement firstName;
	
	@FindBy(xpath="//div/input[@placeholder='Last Name']")
	public WebElement lastName;
	
	@FindBy(name="phone")
	public WebElement phone;
	
	@FindBy(name="email")
	public WebElement email;
	
	@FindBy(xpath="//div[.='SIGN UP']")
	public WebElement signup; 
	
	@FindBy(xpath="//i[@class='dropdown icon']")
	public WebElement language;
	
	@FindBy(xpath="//div[.='English']")
	public WebElement languageEnglish;
	

}

