package org.pageobjects;

import static org.testng.Assert.assertEquals;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.List;
import java.util.Random;

import org.apache.log4j.Logger;
import org.generic.ExtentTestManager;
import org.generic.GenericFunctions;
import org.generic.ReadTestDataFromExcel;
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
//import org.page.SignUpObjects;
import org.startup.BaseTest;
import org.testdata.TestDataForSunbird;
import org.testng.Assert;

import com.relevantcodes.extentreports.LogStatus;

public class AllMyContentPageObj extends BaseTest
{
	WebDriverWait wait = new WebDriverWait(driver,20);
	AllMyContentPage allMyContentPagePObj=PageFactory.initElements(driver, AllMyContentPage.class);

	static Logger log = Logger.getLogger(CreatorUserPage.class.getName());
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
			GenericFunctions.waitForElementToAppear(allMyContentPagePObj.allMyContent);
			allMyContentPagePObj.allMyContent.click();
			GenericFunctions.waitWebDriver(2000);

			allMyContentPagePObj.sortByDropdown.click();
			GenericFunctions.waitWebDriver(2000);

			allMyContentPagePObj.modifiedOnDropdown.click();
			GenericFunctions.waitWebDriver(2000);
			Assert.assertTrue(true,"COntent displayed based on the modified date");
			System.out.println("COntent displayed based on the modified date");
			log.info("COntent displayed based on the modified date");

			allMyContentPagePObj.sortByDropdown.click();
			GenericFunctions.waitWebDriver(2000);

			allMyContentPagePObj.createdOnDropdown.click();
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
			GenericFunctions.waitForElementToAppear(allMyContentPagePObj.allMyContent);
			allMyContentPagePObj.allMyContent.click();
			GenericFunctions.waitWebDriver(2000);

			allMyContentPagePObj.filterIcon.click();				
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
			GenericFunctions.waitForElementToAppear(allMyContentPagePObj.selectStatus);
			allMyContentPagePObj.selectStatus.click();
			if(statusContent.equalsIgnoreCase("DRAFT")){
				allMyContentPagePObj.draftSelect.click();
				GenericFunctions.waitWebDriver(2000);
			}
			else if(statusContent.equalsIgnoreCase("FLAGDRAFT")){
				allMyContentPagePObj.flagDraftSelect.click();
				GenericFunctions.waitWebDriver(2000);
			}
			else if(statusContent.equalsIgnoreCase("REVIEW")){
				allMyContentPagePObj.reviewSelect.click();
				GenericFunctions.waitWebDriver(2000);
			}
			else if(statusContent.equalsIgnoreCase("PROCESSING")){
				allMyContentPagePObj.processingSelect.click();
				GenericFunctions.waitWebDriver(2000);
			}
			else if(statusContent.equalsIgnoreCase("LIVE")){
				allMyContentPagePObj.liveSelect.click();
				GenericFunctions.waitWebDriver(2000);
			}
			else if(statusContent.equalsIgnoreCase("UNLISTED")){
				allMyContentPagePObj.unlistedSelect.click();
				GenericFunctions.waitWebDriver(2000);
			}
			else if(statusContent.equalsIgnoreCase("FLAGREVIEW")){
				allMyContentPagePObj.flagReviewSelect.click();
				GenericFunctions.waitWebDriver(2000);
			} 
			allMyContentPagePObj.applyButton.click();
			GenericFunctions.waitWebDriver(2000);

			allMyContentPagePObj.filterIcon.click();
			GenericFunctions.waitWebDriver(2000);

			try{
				if(driver.findElement(By.xpath("(//div[contains(@class,'UpReviewHeader')])[1]")).isDisplayed() ){
					String contentType = allMyContentPagePObj.firstDraft.getText();
					allMyContentPagePObj.deleteButton.click();					
					GenericFunctions.waitWebDriver(2000);		

					allMyContentPagePObj.confirmYesToPopup.click();
					GenericFunctions.waitWebDriver(2000);
					Assert.assertTrue(true,"Content got deleted successfully");
					System.out.println("Content got deleted successfully");
					log.info("Content got deleted successfully");

					allMyContentPagePObj.searchContent.click();
					allMyContentPagePObj.searchContent.sendKeys(contentType);
					Assert.assertTrue(true,"Deleted content is not available in search result");
					System.out.println("Deleted content is not available in search result");
					log.info("Deleted content is not available in search result");
					GenericFunctions.waitWebDriver(4000);

					allMyContentPagePObj.filterIcon.click();
					GenericFunctions.waitWebDriver(2000);

					allMyContentPagePObj.resetFilter.click();

				}
			}

			catch(Exception e){

				allMyContentPagePObj.filterIcon.click();
				GenericFunctions.waitWebDriver(2000);

				allMyContentPagePObj.resetFilter.click();
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
			allMyContentPagePObj.allMyContent.click();
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
			GenericFunctions.waitForElementToAppear(allMyContentPagePObj.searchContent);				
			if(PublishedContent.equalsIgnoreCase("COURSE")){
				allMyContentPagePObj.searchContent.sendKeys("COURSE");
				allMyContentPagePObj.searchIconUpForReview.click();
				GenericFunctions.waitWebDriver(4000);
			}
			else if(PublishedContent.equalsIgnoreCase("COLLECTION")){
				allMyContentPagePObj.searchContent.sendKeys("COLLECTION");
				allMyContentPagePObj.searchIconUpForReview.click();
				GenericFunctions.waitWebDriver(2000);
			}
			else if(PublishedContent.equalsIgnoreCase("LESSON PLAN")){
				allMyContentPagePObj.searchContent.sendKeys("LESSON PLAN");
				allMyContentPagePObj.searchIconUpForReview.click();
				GenericFunctions.waitWebDriver(2000);
			}
			else if(PublishedContent.equalsIgnoreCase("RESOURCES")){
				allMyContentPagePObj.searchContent.sendKeys("RESOURCES");
				allMyContentPagePObj.searchIconUpForReview.click();
				GenericFunctions.waitWebDriver(2000);
			}
			else if(PublishedContent.equalsIgnoreCase("BOOK")){
				allMyContentPagePObj.searchContent.sendKeys("BOOK");
				allMyContentPagePObj.searchIconUpForReview.click();
				GenericFunctions.waitWebDriver(2000);
			}
			else if(PublishedContent.equalsIgnoreCase("UPLOADED CONTENT")){
				allMyContentPagePObj.searchContent.sendKeys("UPLOADED CONTENT");
				allMyContentPagePObj.searchIconUpForReview.click();
				GenericFunctions.waitWebDriver(2000);
			} 

			allMyContentPagePObj.filterIcon.click();
			GenericFunctions.waitWebDriver(2000);

			allMyContentPagePObj.selectStatus.click();
			GenericFunctions.waitWebDriver(2000);

			allMyContentPagePObj.liveSelect.click();
			GenericFunctions.waitWebDriver(2000);

			allMyContentPagePObj.applyButton.click();
			GenericFunctions.waitWebDriver(2000);	

			allMyContentPagePObj.filterIcon.click();
			GenericFunctions.waitWebDriver(2000);

			try{
				if(allMyContentPagePObj.firstDraft.isDisplayed())
				{
					String deletedContent = allMyContentPagePObj.firstDraft.getText();
					allMyContentPagePObj.deleteButton.click();
					GenericFunctions.waitWebDriver(2000);

					allMyContentPagePObj.yesButtonPopup.click();
					Assert.assertTrue(true, "User is able to delete the content successfully");
					System.out.println("User is able to delete the content successfully");
					System.out.println("User is able to delete the content successfully");
					GenericFunctions.waitWebDriver(2000);

					allMyContentPagePObj.searchContent.sendKeys(deletedContent);
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
			GenericFunctions.waitForElementToAppear(allMyContentPagePObj.workSpace);
			allMyContentPagePObj.workSpace.click();
			GenericFunctions.waitWebDriver(2000);				
		}
		catch(Exception e)
		{
			ExtentTestManager.getTest().log(LogStatus.FAIL, "User is trying to click on all workspace");
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Exception Message: "+e.getLocalizedMessage());
			Assert.fail("User is trying to click on all workspace");
		}
	}
}



