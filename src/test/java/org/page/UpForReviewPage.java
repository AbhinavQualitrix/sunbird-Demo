package org.page;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UpForReviewPage 
{
	WebDriver driver;

	public  UpForReviewPage(WebDriver driver)
	{ 
		this.driver=driver; 
	}
	// @author sachin
	// Web Element upForReview
	@FindBy(xpath="//a[contains(text(),'Up For Review')]")
	public WebElement upForReview;

	// @author sachin
	// Web Element searchContent
	@FindBy(xpath="//input[@placeholder='Search content']")
	public WebElement searchContent;
	
	// @author Sachin
	// Web Element  closePopUp 
	@FindBy(xpath = "//i[contains(@class,'close icon')]")
	public WebElement closePopUp;
	
	// @author sachin
	// Web Element sortBy
	@FindBy(xpath = "//*[@id='sortByDropDown']/sui-select/i")
	public WebElement sortBy;
	
	// @author sachin
	// Web Element updatedOn
	@FindBy(xpath = "//*[@id='sortByDropDown']/sui-select/div[3]/sui-select-option[1]")
	public WebElement updatedOn;
	
	// @author sachin
	// Web Element createdOn
	@FindBy(xpath = "//*[@id='sortByDropDown']/sui-select/div[2]/sui-select-option[2]/span[2]")
	public WebElement createdOn;
	
	// @author sachin
	// Web Element nameAtoZ
	@FindBy(xpath = "//*[@id='sortByDropDown']/sui-select/div[2]/sui-select-option[3]/span[2]")
	public WebElement nameAtoZ;
	
	// @author sachin
	//Adding elements for test case 14
	// Web Element filterIcon
	@FindBy(xpath="//span[@class='browse item cursor-pointer']")
	public WebElement filterIcon;
	
	// @author sachin
	// Web Element clickFilterBoard
	@FindBy(xpath="(//i[@class='dropdown icon'])[5]")
	public WebElement clickFilterBoard;
	
	// @Author Sachin
	// Web Element selectRajasthanBoard
	@FindBy(xpath = "//span[contains(.,'State (Rajasthan)')]")
	public WebElement selectRajasthanBoard;
	
	// @Author Sachin
	// Web Element clickFilterClass
	@FindBy(xpath = "(//i[@class='dropdown icon'])[6]")
	public WebElement clickFilterClass;
	
	// @Author Sachin
	// Web Element selectClass9
	@FindBy(xpath = "//sui-select-option[contains(.,'Class 9')]")
	public WebElement selectClass9;
	
	// @Author Sachin
	// Web Element clickFilterSubject
	@FindBy(xpath="(//sui-multi-select[contains(@zeroselectiontext,'Select')])[3]")
	public WebElement clickFilterSubject;
	
	//@author sachin
	// Web Element selectMathematics
	@FindBy(xpath="//span[contains(.,'Mathematics')]")
	public WebElement selectMathematics;
	
	//@author sachin
	// Web Element clickFilterMedium
	@FindBy(xpath="(//div[contains(.,'Select Medium')])[13]")
	public WebElement clickFilterMedium;
	
	//@author sachin
	// Web Element selectFilterMedium
	@FindBy(xpath="//span[contains(.,'English')]")
	public WebElement selectFilterMedium;
	
	//@author sachin
	// Web Element clickContentType
	@FindBy(xpath="//*[@id='contentType']/i")
	public WebElement clickContentType;
	
	//@author sachin
	// Web Element selectContentType
	@FindBy(xpath="//sui-multi-select[@id='contentType']//span[.='LessonPlan']")
	public WebElement selectContentType;
	
	//@author sachin
	// Web Element applyButton
	@FindBy(xpath="//a[.='APPLY']")
	public WebElement applyButton;
	
	//@author sachin
	// Web Element firtContent
	@FindBy(xpath="//*[@class='UpForReviewListHover cursor-pointer']")
	public WebElement firtContent;
	
	//@author sachin
	// Web Element headerPublish
	@FindBy(xpath = "//span[contains(.,'Publish')]")
	public WebElement headerPublish;
	
	//@author sachin
	// Web Element Publish
	@FindBy(xpath="//*[@class='ui right floated primary button mouse-pointer']")
	public WebElement Publish;
	
	//@author sachin
	// Web Element publishConfirm
	@FindBy(xpath="//*[@id='review-footer']/div/button[2]")
	public WebElement publishConfirm;
		
	@FindBy(xpath="//*[@id='main-nav']/div[2]/app-main-menu/div/a[4]")
	public WebElement Workspace;
	
	@FindBy(tagName="iframe")
	public WebElement iFrame;
	
	@FindBy(tagName="(//div[contains(@class,'UpReviewHeader')])[1]")
	public WebElement ContentName;
	
	@FindBy(tagName="//td[@class='UpForReviewStatusOrange'][contains(.,'Review')]")
	public WebElement Review;
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
