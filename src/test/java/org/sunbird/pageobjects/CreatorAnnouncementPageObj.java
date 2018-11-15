package org.sunbird.pageobjects;


import java.awt.Robot;
import java.util.List;
import java.util.Random;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.sunbird.generic.AllUploadingPaths;
import org.sunbird.generic.ExtentTestManager;
import org.sunbird.generic.GenericExlMethods;
import org.sunbird.generic.GenericFunctions;
import org.sunbird.generic.ReadTestDataFromExcel;
import org.sunbird.page.CreatorAnnouncementPage;
import org.sunbird.page.CreatorUserPage;
import org.sunbird.page.PublicUserPage;
import org.sunbird.page.SignUpPage;
import org.sunbird.startup.BaseTest;
import org.sunbird.testdata.TestDataForSunbird;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentReporter;
import com.relevantcodes.extentreports.LogStatus;

import net.bytebuddy.description.type.TypeDescription.Generic;


public class CreatorAnnouncementPageObj extends BaseTest{

	WebDriverWait wait = new WebDriverWait(driver,20);
	CreatorUserPage createUserPage=PageFactory.initElements(driver, CreatorUserPage.class);
	CreatorAnnouncementPage createAnnouncementPage=PageFactory.initElements(driver, CreatorAnnouncementPage.class);
	PublicUserPage publicUserPage = PageFactory.initElements(driver, PublicUserPage.class);
	SignUpPage signUpPage=PageFactory.initElements(driver, SignUpPage.class);
	static Logger log = Logger.getLogger(CreatorAnnouncementPage.class.getName());
	Actions action = new Actions(driver);
	Random rand=new Random();
	String announcementName;
	List <TestDataForSunbird> objListOFTestDataForSunbird= null;

	

	public void navigateToAnnouncementInDropDownMenu() throws InterruptedException
	{
		try{
			String expectedDashboardUrl="https://staging.open-sunbird.org/announcement/outbox/1";
			ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to navigate to announcement dashboard in drop down menu");
			GenericFunctions.waitForElementToAppear(createUserPage.profileIconDropdown);
			GenericFunctions.waitWebDriver(1500);
			createUserPage.profileIconDropdown.click();
			GenericFunctions.waitWebDriver(1000);
			createAnnouncementPage.announcement_Dashboard.click();	
			GenericFunctions.waitForElementToAppear(createAnnouncementPage.create_Announcement);
			if(createAnnouncementPage.create_Announcement.isDisplayed())
			{
				GenericFunctions.waitWebDriver(1000);
				Assert.assertEquals(driver.getCurrentUrl(), expectedDashboardUrl);
				Assert.assertTrue(true);
				ExtentTestManager.getTest().log(LogStatus.PASS, "Announcement dashboard is sucessfully visible to user");
			}
		}
		catch(Exception e)
		{
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed on navigating announcement in drop down menu");
			ExtentTestManager.getTest().log(LogStatus.FAIL,"Exception Message: "+e.getLocalizedMessage());
			log.error("Exception In the method navigateToAnnouncementInDropDownMenu"+e.getMessage());
			Assert.fail("Failed on navigating to announcement dashboard in drop down menu, Exception : "+e.getLocalizedMessage());

		}
	}

	public void CreateAnnouncement() throws InterruptedException, Exception
	{

		try{
			ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to create an announcement");
			objListOFTestDataForSunbird = ReadTestDataFromExcel.getTestDataForSunbird("testdatasheetcourse");
			GenericFunctions.waitForElementToAppear(createAnnouncementPage.create_Announcement);
			createAnnouncementPage.create_Announcement.click();
			GenericFunctions.waitWebDriver(1000);
			GenericFunctions.waitForElementToAppear(createAnnouncementPage.enterTitle);
			createAnnouncementPage.enterTitle.click();
			String announcementNumber = GenericFunctions.testDataIncrementer("./TestData/announcementNumbers.txt").toString();
			announcementName = objListOFTestDataForSunbird.get(7).getCourseName();
			System.out.println(announcementName + announcementNumber);
			createAnnouncementPage.enterTitle.sendKeys(announcementName + announcementNumber );
			createAnnouncementPage.enterOrg.click();
			createAnnouncementPage.enterOrg.sendKeys(objListOFTestDataForSunbird.get(7).getCourseDescription());
			createAnnouncementPage.announcementType.click();
			GenericFunctions.waitWebDriver(1000);
			createAnnouncementPage.announcementTypeOrder.click();
			GenericFunctions.waitWebDriver(1000);
			createAnnouncementPage.enterDescription.click();
			createAnnouncementPage.enterDescription.sendKeys(objListOFTestDataForSunbird.get(7).getTitle());
			GenericFunctions.waitWebDriver(2000);
			createAnnouncementPage.addUrl.click();
			GenericFunctions.waitWebDriver(1000);
			createAnnouncementPage.enterUrl.click();
			GenericFunctions.waitWebDriver(1000);
			createAnnouncementPage.enterUrl.sendKeys(objListOFTestDataForSunbird.get(7).getTitleDescription());
			GenericFunctions.waitWebDriver(2000);
			
	
			
			action.moveToElement(createAnnouncementPage.selectRecipient).click().build().perform();
			
			GenericFunctions.waitWebDriver(3000);
			
			createAnnouncementPage.checkLocation.get(0).click();
			createAnnouncementPage.checkLocation.get(1).click();
			
			//action.moveToElement(createAnnouncementPage.checkLocation).click().build().perform();
			GenericFunctions.waitWebDriver(1000);
			createAnnouncementPage.confirmRecipients.click();
			GenericFunctions.waitForElementToAppear(createAnnouncementPage.previewAnnouncement);
			createAnnouncementPage.previewAnnouncement.click();
			GenericFunctions.waitForElementToAppear(createAnnouncementPage.sendAnnouncement);
			GenericFunctions.waitWebDriver(1000);
			createAnnouncementPage.sendAnnouncement.click();
			GenericFunctions.waitForElementToAppear(createAnnouncementPage.announcementcreatedConfirmation);
			createAnnouncementPage.announcementcreatedConfirmation.click();
		}
		catch(Exception e)
		{
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed on creating an announcement");
			ExtentTestManager.getTest().log(LogStatus.FAIL,"Exception Message: "+e.getLocalizedMessage());
			log.error("Exception In the method CreateAnnouncement"+e.getMessage());
			Assert.fail("Failed to create an announcement, Exception : "+e.getLocalizedMessage());
		}
	}

	public void CreateAnnouncementUsingAttachment() throws InterruptedException, Exception
	{
		try
		{
			ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to create an announcement using an attachment");
			objListOFTestDataForSunbird = ReadTestDataFromExcel.getTestDataForSunbird("testdatasheetcourse");
			GenericFunctions.waitWebDriver(1000);
			GenericFunctions.waitForElementToAppear(createAnnouncementPage.create_Announcement);		
			createAnnouncementPage.create_Announcement.click();
			GenericFunctions.waitWebDriver(1000);
			GenericFunctions.waitForElementToAppear(createAnnouncementPage.enterTitle);
			createAnnouncementPage.enterTitle.click();
			String announcementNumber = GenericFunctions.testDataIncrementer("./TestData/announcementNumbers.txt").toString();
			announcementName = objListOFTestDataForSunbird.get(7).getCourseName();
			System.out.println(announcementName + announcementNumber);
			createAnnouncementPage.enterTitle.sendKeys(announcementName + announcementNumber );
			createAnnouncementPage.enterOrg.click();
			createAnnouncementPage.enterOrg.sendKeys(objListOFTestDataForSunbird.get(7).getCourseDescription());
			createAnnouncementPage.announcementType.click();
			GenericFunctions.waitWebDriver(1000);
			createAnnouncementPage.announcementTypeOrder.click();
			GenericFunctions.waitWebDriver(1000);
			createAnnouncementPage.enterDescription.click();
			createAnnouncementPage.enterDescription.sendKeys(objListOFTestDataForSunbird.get(7).getTitle());
			GenericFunctions.waitWebDriver(2000);
			createAnnouncementPage.addUrl.click();
			GenericFunctions.waitWebDriver(1000);
			createAnnouncementPage.enterUrl.click();
			GenericFunctions.waitWebDriver(1000);
			createAnnouncementPage.enterUrl.sendKeys(objListOFTestDataForSunbird.get(7).getTitleDescription());
			GenericFunctions.waitWebDriver(4000);
			
			action.moveToElement(createAnnouncementPage.uploadDocument).click().build().perform();
		
			//action.click().build().perform();
			GenericFunctions.waitWebDriver(3000);
			//String path = System.getProperty("user.dir")+"\\uploadingDocuments\\upload Document Contents\\"+IMAGE;
			GenericFunctions.waitWebDriver(3000);
			//String path = System.getProperty("user.dir")+"/UploadingDocuments/Upload Document Contents/"+IMAGE;
			GenericFunctions.uploadFile(AllUploadingPaths.attachmentImagePath);
			GenericFunctions.waitWebDriver(5000);
			
			//GenericFunctions.waitForElementState(createAnnouncementPage.selectRecipient);
			GenericFunctions.waitForElementToAppear(createAnnouncementPage.selectRecipient);
			action.moveToElement(createAnnouncementPage.selectRecipient).click().build().perform();
			
			GenericFunctions.waitWebDriver(3000);
			GenericFunctions.waitForElements(createAnnouncementPage.checkLocation);
			createAnnouncementPage.checkLocation.get(0).click();
			createAnnouncementPage.checkLocation.get(1).click();
			
			//OCT 12
			
			//	createAnnouncementPage.checkLocation.click();
			GenericFunctions.waitForElementToAppear(createAnnouncementPage.confirmRecipients);
			GenericFunctions.waitWebDriver(1000);
			createAnnouncementPage.confirmRecipients.click();
			GenericFunctions.waitWebDriver(1000);
			GenericFunctions.waitForElementToAppear(createAnnouncementPage.previewAnnouncement);
			createAnnouncementPage.previewAnnouncement.click();
			GenericFunctions.waitWebDriver(1000);
			GenericFunctions.waitForElementToAppear(createAnnouncementPage.sendAnnouncement);
			createAnnouncementPage.sendAnnouncement.click();
			GenericFunctions.waitForElementToAppear(createAnnouncementPage.announcementcreatedConfirmation);
			createAnnouncementPage.announcementcreatedConfirmation.click();
			ExtentTestManager.getTest().log(LogStatus.PASS, "An Announcement along with the attachment is created sucessfully");
		}

		catch(Exception e)
		{
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed on creating an announcement using an attachment");
			ExtentTestManager.getTest().log(LogStatus.FAIL,"Exception Message: "+e.getLocalizedMessage());
			log.error("Exception In the method CreateAnnouncement"+e.getMessage());
			Assert.fail("Failed on creating an announcement using an attachment, Exception : "+e.getLocalizedMessage());
		}

	}
	
	public void checkForAnnouncement()
	{
		String announcementnameReview;
		try
		{
			ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to Check for the created announcement in the Home Page");
			GenericFunctions.waitWebDriver(1000);
			GenericFunctions.waitForPageToLoad(createAnnouncementPage.seeAllAnnouncement);
			createAnnouncementPage.seeAllAnnouncement.click();
			GenericFunctions.waitWebDriver(1500);
			GenericFunctions.waitForElementToAppear(createAnnouncementPage.reviewAnnouncementN);
			announcementnameReview = createAnnouncementPage.reviewAnnouncementN.getText();
			System.out.println(announcementnameReview);
			Assert.assertEquals(announcementnameReview, announcementName);
			createAnnouncementPage.reviewAnnouncementN.click();
			GenericFunctions.waitWebDriver(1000);
			createAnnouncementPage.popupCloseIcon.click();
			System.out.println("Created Announcement is available");
		}
		catch(Exception e)
		{
			ExtentTestManager.getTest().log(LogStatus.FAIL, "User failed to find the announcement in the Home Page");
			ExtentTestManager.getTest().log(LogStatus.FAIL,"Exception Message: "+e.getLocalizedMessage());
			log.error("Exception In the method checkForAnnouncement "+e.getMessage());
			Assert.fail("User failed to find the announcement in the Home Page "+e.getLocalizedMessage());
		}
	}
}
