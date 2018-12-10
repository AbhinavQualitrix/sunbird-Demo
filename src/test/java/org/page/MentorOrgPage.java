package org.page;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MentorOrgPage 
{
	WebDriver driver;

	public  MentorOrgPage(WebDriver driver)
	{ 
		this.driver=driver; 
	}
	// @author Sachin
	// Web Element headerCourse
	@FindBy(xpath="(//a[contains(.,'Courses')])[2]")
	public WebElement headerCourse;	
	
	// @author Sachin
	// Web Element course 
	@FindBy(xpath = "(//div[contains(@class,'sub-header')])[1]")
	public WebElement course;
	
	// @author Sachin
	// Web Element courseName 
	@FindBy(xpath="//input[@placeholder='Name']")
	public WebElement courseName;
	
	@FindBy(xpath="//input[@placeholder='Description']")
	public WebElement courseDescription;
	
	@FindBy(xpath="//button[contains(text(),'START CREATING')]")
	public WebElement startCreating;
	
	@FindBy(tagName="iframe")
	public WebElement iFrame;
	
	@FindBy(xpath="//button[@class='ui basic button text-transform-none'][2]//a[2]")
	public WebElement newChild;
	
	@FindBy(xpath="//label[.='Title']/following-sibling::div//following-sibling::input")
	public WebElement titleName;
	
	@FindBy(xpath="//textarea[@placeholder='Brief description about the course unit']")
	public WebElement titleDescription;
	
	@FindBy(xpath="//button[contains(.,'ADD RESOURCE')]")
	public WebElement addResource;
	
	@FindBy(xpath="(//img[contains(@class,'resourceMetaImage ')])[1]")
	public WebElement selectResource;
	
	@FindBy(xpath="//div[@class=' ui clearing segment']/..//button[contains(text(),'PROCEED')]")
	public WebElement proceedButton;
	
	@FindBy(xpath="//span[.='Save']")
	public WebElement saveCourse;
	
	@FindBy(xpath="//div[@class='ui button text-part popup-item']")
	public WebElement sendForReview;
	
	@FindBy(xpath="//div[@class='ui appIconSelector']")
	public WebElement clickAppIcon;
	
	@FindBy(xpath="//div[@class='ui image']//img[@class='asset_thumbnail']")
	public WebElement checkContentIcon;
	
	@FindBy(xpath="//button[.='Select']")
	public WebElement selectAppIcon;
	
	@FindBy(xpath="(//input[contains(@class,'search')])[1]")
	public WebElement clickOnSelectCurriculum;
	
	@FindBy(xpath="//div[@class='item selected']")
	public WebElement selectCurriculum;
	
	@FindBy(xpath="(//input[contains(@class,'search')])[2]")         // 
	public WebElement clickOnSelectClass;
	
	@FindBy(xpath="//*[@id='gradeLevel']/div[1]/div[2]/div[2]")
	public WebElement selectClass;
	
	@FindBy(xpath="//div[@class='column'][contains(.,'Edit Details')]")
	public WebElement EditDetails;
	
	
	
	@FindBy(xpath="(//i[contains(@class,'dropdown icon')])[11]")
	public WebElement clickOnSelectMedium;
	
	@FindBy(xpath="(//div[contains(.,'English')])[21]")
	public WebElement selectMedium;
	
	@FindBy(xpath="(//input[contains(@class,'search')])[6]")
	public WebElement clickOwner;
	
	@FindBy(xpath="(//div[contains(@class,'item')])[24]")
	public WebElement selectOwner;
	
	@FindBy(xpath="//button[.='Save']")
	public WebElement saveButton;
	
	@FindBy(xpath = "(//div[contains(@class,'avatar-content')])[2]")
	public WebElement dropdown;
	
	@FindBy(xpath = "(//a[@class='item'][contains(.,'Logout')])[3]")
	public WebElement logout;
	
	@FindBy(xpath="(//input[@name='filter_search'])[2]")
	public WebElement filterSearch;
	
	@FindBy(xpath = "//i[@class='circular search link icon']")
	public WebElement searchIconUpForReview;
	
	@FindBy(xpath = "(//div[contains(@class,'meta')])[1]")
	public WebElement searchedCourse;
	
	@FindBy(xpath="//a[text() = 'Create Batch']")
	public WebElement createBatch;
	
	@FindBy(xpath="//i[@class='add icon']")
	public WebElement addIcon;
	
	@FindBy(xpath="//input[contains(@formcontrolname,'name')]")
	public WebElement nameOfBatch;
	
	@FindBy(xpath="//input[@formcontrolname='description']")
	public WebElement aboutBatch;
	
	@FindBy(xpath="//input[@formcontrolname='startDate']")
	public WebElement startDate;
	
	//Added on 31 july 2018
	@FindBy(xpath="//input[@formcontrolname='startDate']/../../../../../../../../../../../../sui-popup/div/sui-datepicker/sui-calendar-date-view/table/tbody/tr/td[@class='link']")
	public WebElement startDateCalendar;
	
	@FindBy(xpath="//input[@formcontrolname='endDate']")
	public WebElement endDate;
	
	@FindBy(xpath="(//i[contains(@class,'dropdown icon')])[4]")
	public WebElement mentorsInBatch;
	
	@FindBy(xpath="(//div[contains(@class,'item')])[6]")
	public WebElement suborgMentor2InBatch;
	
	@FindBy(xpath="(//div[contains(@class,'item')])[12]")
	public WebElement membersInBatch;
	
	@FindBy(xpath="//div[@class='item'][contains(.,'Test BookReviewer (te***************@qualitrix.com)')]")
	public WebElement testBookReviewerInBatch;
	
	@FindBy(xpath="//button[@class='ui primary button']")
	public WebElement buttonCreate;
	
	@FindBy(xpath = "//i[contains(@class,'close icon')]")
	public WebElement closePopUp;
	
	@FindBy(xpath="(//div[contains(@class,'meta course')])[1]")
	public WebElement latestCourse;
	
	@FindBy(xpath="(//i[@class='dropdown icon'])[5]")
	public WebElement mentorDropdown;
	
	@FindBy(xpath="(//a[@class='item'][contains(.,'Workspace')])[2]")
	public WebElement workSpace;
	
	@FindBy(xpath="//*[@id='main-nav']/div[2]/app-main-menu/div/a[4]")
	public WebElement Workspace;
	
	@FindBy(xpath = "//div[@class='publicmenusection ui secondary vertical menu']//a[7]")
	public WebElement upForReview;
	
	@FindBy(xpath="//*[@class='UpForReviewListHover cursor-pointer']")
	public WebElement firtContent;
	
	@FindBy(xpath = "//span[contains(.,'Publish')]")
	public WebElement headerPublish;
	
	@FindBy(xpath="//*[@class='ui right floated primary button mouse-pointer']")
	public WebElement Publish;
	
	@FindBy(xpath="//*[@id='review-footer']/div/button[2]")
	public WebElement publishConfirm;
	
	@FindBy(xpath="//label[contains(text(),'NAME OF BATCH')]")
	public WebElement batchForm;
	
	
}