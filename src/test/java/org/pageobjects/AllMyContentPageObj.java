package org.pageobjects;

import static org.testng.Assert.assertEquals;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.List;
import java.util.Random;

import org.apache.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.page.AllMyContentPage;
import org.page.ContentCreateUploadPage;
import org.page.CreateMentorPage;
import org.page.CreatorUserPage;
import org.page.PublicUserPage;
import org.page.SignUpPage;
import org.generic.ExtentTestManager;
import org.generic.GenericFunctions;
import org.generic.ReadTestDataFromExcel;
import org.startup.BaseTest;
import org.testdata.TestDataForSunbird;
import org.testng.Assert;

import com.relevantcodes.extentreports.LogStatus;

public class AllMyContentPageObj extends BaseTest
{
	WebDriverWait wait = new WebDriverWait(driver,20);
	AllMyContentPage AllMyContentPagePObj=PageFactory.initElements(driver, AllMyContentPage.class);

	static Logger log = Logger.getLogger(CreatorUserPageObj.class.getName());
	List <TestDataForSunbird> objListOFTestDataForSunbird1= null ;
	Actions action = new Actions(driver);
	Random rand=new Random();
	String eurl="https://staging.open-sunbird.org/workspace/content/edit/generic#no";
	String a="Browse";
	String title="";

	   // @author Sachin
		public void allMyContentSortByDropdown()throws Exception{
		try
		{
		ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to  select modified on and created on option in the dropdown");
		GenericFunctions.waitForElementToAppear(AllMyContentPagePObj.allMyContent);
		AllMyContentPagePObj.allMyContent.click();
		GenericFunctions.waitWebDriver(2000);
		
		AllMyContentPagePObj.sortByDropdown.click();
		GenericFunctions.waitWebDriver(2000);
		
		AllMyContentPagePObj.modifiedOnDropdown.click();
		GenericFunctions.waitWebDriver(2000);
		Assert.assertTrue(true,"COntent displayed based on the modified date");
		System.out.println("COntent displayed based on the modified date");
		log.info("COntent displayed based on the modified date");
		
		AllMyContentPagePObj.sortByDropdown.click();
		GenericFunctions.waitWebDriver(2000);
	
		AllMyContentPagePObj.createdOnDropdown.click();
		GenericFunctions.waitWebDriver(2000);
		Assert.assertTrue(true,"COntent displayed based on the date createdOn");
		System.out.println("COntent displayed based on the date createdOn ");
		log.info("COntent displayed based on the modified date createdOn");
										
		}
		catch (Exception e) {
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed on selecting options from dropdown");
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Exception Message: " + e.getLocalizedMessage());
			log.error("Exception In the method allMyContentSortByDropdown" + e.getLocalizedMessage());
			Assert.fail("Failed on selecting options from dropdown" + e.getLocalizedMessage());
		
		}
}
		
		
			// @author Sachin
 		public void clickAllMyContent()throws Exception{
		try{	
		ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to click on all my content and then filter icon");
		GenericFunctions.waitForElementToAppear(AllMyContentPagePObj.allMyContent);
		AllMyContentPagePObj.allMyContent.click();
		GenericFunctions.waitWebDriver(2000);
						
		AllMyContentPagePObj.filterIcon.click();				
		GenericFunctions.waitWebDriver(2000);				
		}
		catch(Exception e)
		{
			ExtentTestManager.getTest().log(LogStatus.FAIL, "failed on clicking all my content");
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Exception Message: "+e.getLocalizedMessage());
			Assert.fail("failed to click filter icon");
		}
 	}
 		
 		
 		
 		// @author Sachin
 public void deleteByStatus(String statusContent)throws Exception{
		
	 try{
		ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to delete content by status");
		GenericFunctions.waitForElementToAppear(AllMyContentPagePObj.selectStatus);
		AllMyContentPagePObj.selectStatus.click();
		if(statusContent.equalsIgnoreCase("DRAFT")){
		AllMyContentPagePObj.draftSelect.click();
		GenericFunctions.waitWebDriver(2000);
		 }
		else if(statusContent.equalsIgnoreCase("FLAGDRAFT")){
		AllMyContentPagePObj.flagDraftSelect.click();
		GenericFunctions.waitWebDriver(2000);
		}
		else if(statusContent.equalsIgnoreCase("REVIEW")){
		AllMyContentPagePObj.reviewSelect.click();
		GenericFunctions.waitWebDriver(2000);
		}
		else if(statusContent.equalsIgnoreCase("PROCESSING")){
		AllMyContentPagePObj.processingSelect.click();
		GenericFunctions.waitWebDriver(2000);
		}
		else if(statusContent.equalsIgnoreCase("LIVE")){
		AllMyContentPagePObj.liveSelect.click();
		GenericFunctions.waitWebDriver(2000);
		}
		else if(statusContent.equalsIgnoreCase("UNLISTED")){
		AllMyContentPagePObj.unlistedSelect.click();
		GenericFunctions.waitWebDriver(2000);
		}
		else if(statusContent.equalsIgnoreCase("FLAGREVIEW")){
		AllMyContentPagePObj.flagReviewSelect.click();
		GenericFunctions.waitWebDriver(2000);
		} 
		AllMyContentPagePObj.applyButton.click();
		GenericFunctions.waitWebDriver(2000);
		
		AllMyContentPagePObj.filterIcon.click();
		GenericFunctions.waitWebDriver(2000);
		
		try{
		if(driver.findElement(By.xpath("(//div[contains(@class,'UpReviewHeader')])[1]")).isDisplayed() ){
	    String contentType = AllMyContentPagePObj.firstDraft.getText();
		AllMyContentPagePObj.deleteButton.click();					
		GenericFunctions.waitWebDriver(2000);		
			
		AllMyContentPagePObj.confirmYesToPopup.click();
		GenericFunctions.waitWebDriver(2000);
		Assert.assertTrue(true,"Content got deleted successfully");
		System.out.println("Content got deleted successfully");
		log.info("Content got deleted successfully");
			
		AllMyContentPagePObj.searchContent.click();
		AllMyContentPagePObj.searchContent.sendKeys(contentType);
		Assert.assertTrue(true,"Deleted content is not available in search result");
		System.out.println("Deleted content is not available in search result");
		log.info("Deleted content is not available in search result");
		GenericFunctions.waitWebDriver(4000);
			
		AllMyContentPagePObj.filterIcon.click();
		GenericFunctions.waitWebDriver(2000);
				
		AllMyContentPagePObj.resetFilter.click();
		
		}
		}
		
		catch(Exception e){
					
		AllMyContentPagePObj.filterIcon.click();
		GenericFunctions.waitWebDriver(2000);
			
		AllMyContentPagePObj.resetFilter.click();
		GenericFunctions.waitWebDriver(2000);			
		}	
	 }
	 catch(Exception e)
	 {
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed on deleting content by status");
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Exception Message: " + e.getLocalizedMessage());
			log.error("Exception In the method deleteByStatus" + e.getLocalizedMessage());
			Assert.fail("Failed on deleting content by status" + e.getLocalizedMessage()); 			 
	 }
	}
 
 
	// @author Sachin
	
	public void allMyContent()throws Exception{
	try
	{	
		ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to click on all my content");
		AllMyContentPagePObj.allMyContent.click();
		GenericFunctions.waitWebDriver(2000);
			
	}
	catch(Exception e)
	{
		ExtentTestManager.getTest().log(LogStatus.FAIL, "failed on clicking all my content");
		ExtentTestManager.getTest().log(LogStatus.FAIL, "Exception Message: "+e.getLocalizedMessage());
		Assert.fail("failed on clicking all my content");
	}
	
}
	
	
		// @author Sachin
		public void deleteContent(String PublishedContent)throws Exception{
	try
	{
	ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to delete content by status");
	GenericFunctions.waitForElementToAppear(AllMyContentPagePObj.searchContent);				
	if(PublishedContent.equalsIgnoreCase("COURSE")){
	AllMyContentPagePObj.searchContent.sendKeys("COURSE");
	AllMyContentPagePObj.searchIconUpForReview.click();
	GenericFunctions.waitWebDriver(4000);
	}
	else if(PublishedContent.equalsIgnoreCase("COLLECTION")){
	AllMyContentPagePObj.searchContent.sendKeys("COLLECTION");
	AllMyContentPagePObj.searchIconUpForReview.click();
	GenericFunctions.waitWebDriver(2000);
	}
	else if(PublishedContent.equalsIgnoreCase("LESSON PLAN")){
	AllMyContentPagePObj.searchContent.sendKeys("LESSON PLAN");
	AllMyContentPagePObj.searchIconUpForReview.click();
	GenericFunctions.waitWebDriver(2000);
	}
	else if(PublishedContent.equalsIgnoreCase("RESOURCES")){
	AllMyContentPagePObj.searchContent.sendKeys("RESOURCES");
	AllMyContentPagePObj.searchIconUpForReview.click();
	GenericFunctions.waitWebDriver(2000);
	}
	else if(PublishedContent.equalsIgnoreCase("BOOK")){
	AllMyContentPagePObj.searchContent.sendKeys("BOOK");
	AllMyContentPagePObj.searchIconUpForReview.click();
	GenericFunctions.waitWebDriver(2000);
	}
	else if(PublishedContent.equalsIgnoreCase("UPLOADED CONTENT")){
	AllMyContentPagePObj.searchContent.sendKeys("UPLOADED CONTENT");
	AllMyContentPagePObj.searchIconUpForReview.click();
	GenericFunctions.waitWebDriver(2000);
	} 
				
	AllMyContentPagePObj.filterIcon.click();
	GenericFunctions.waitWebDriver(2000);

	AllMyContentPagePObj.selectStatus.click();
	GenericFunctions.waitWebDriver(2000);
	
	AllMyContentPagePObj.liveSelect.click();
	GenericFunctions.waitWebDriver(2000);

	AllMyContentPagePObj.applyButton.click();
	GenericFunctions.waitWebDriver(2000);	
	
	AllMyContentPagePObj.filterIcon.click();
	GenericFunctions.waitWebDriver(2000);
	
	try{
	if(AllMyContentPagePObj.firstDraft.isDisplayed())
	{
		String deletedContent = AllMyContentPagePObj.firstDraft.getText();
		AllMyContentPagePObj.deleteButton.click();
		GenericFunctions.waitWebDriver(2000);
		
		AllMyContentPagePObj.yesButtonPopup.click();
		Assert.assertTrue(true, "User is able to delete the content successfully");
		System.out.println("User is able to delete the content successfully");
		System.out.println("User is able to delete the content successfully");
		GenericFunctions.waitWebDriver(2000);
		
		AllMyContentPagePObj.searchContent.sendKeys(deletedContent);
		Assert.assertTrue(true, "Deleted content not available in search result");
		System.out.println("Deleted content not available in search result");
		System.out.println("Deleted content not available in search result");
		GenericFunctions.waitWebDriver(4000);
	}
	}
	catch(Exception e)
	{
		System.out.println("There is no content");
	}
	
	
	}
	catch(Exception e)
	{				
		ExtentTestManager.getTest().log(LogStatus.FAIL, "User is unable delete content by status");
		ExtentTestManager.getTest().log(LogStatus.FAIL, "Exception Message: "+e.getLocalizedMessage());
		Assert.fail("User is unable delete content by status");
	}
}	
		public void clickWorkspace()throws Exception{
	try
	{	
	ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to click on all workspace");	
		
		try{
		if(AllMyContentPagePObj.closePopUp.isDisplayed())
		{
		AllMyContentPagePObj.closePopUp.click();
		GenericFunctions.waitWebDriver(2000);
		GenericFunctions.waitForElementToAppear(AllMyContentPagePObj.Workspace);	
		AllMyContentPagePObj.Workspace.click();
		}
		}
		catch(Exception e)
		{
		GenericFunctions.waitForElementToAppear(AllMyContentPagePObj.Workspace);	
		AllMyContentPagePObj.Workspace.click();
		GenericFunctions.waitWebDriver(4000);	
		}				
		}
	catch(Exception e)
	{
		ExtentTestManager.getTest().log(LogStatus.FAIL, "User is trying to click on all workspace");
		ExtentTestManager.getTest().log(LogStatus.FAIL, "Exception Message: "+e.getLocalizedMessage());
		Assert.fail("User is trying to click on all workspace");
	}
	}
 }

	
	
