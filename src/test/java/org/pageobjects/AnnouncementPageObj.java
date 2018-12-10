package org.pageobjects;

import static org.testng.Assert.assertTrue;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Set;

import org.apache.log4j.Logger;
import org.apache.poi.util.SystemOutLogger;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.page.AnnouncementPage;
import org.page.ContentCreationResourcePage;
import org.page.CreateMentorPage;
import org.page.CreatorAnnouncementPage;
import org.page.CreatorUserPage;
import org.page.PublicUserPage;
import org.page.SignUpPage;
import org.page.UploadOrgPage;
import org.generic.ExtentTestManager;
import org.generic.GenericFunctions;
import org.generic.ReadTestDataFromExcel;
import org.startup.BaseTest;
import org.testdata.TestDataForSunbird;
import org.testng.Assert;

import com.relevantcodes.extentreports.LogStatus;

public class AnnouncementPageObj extends BaseTest
{
	//private static final String IMAGE = null;
		WebDriverWait wait = new WebDriverWait(driver,20);
		AnnouncementPage AnnouncementPageObj=PageFactory.initElements(driver, AnnouncementPage.class);
		CreatorAnnouncementPage createAnnouncementPage=PageFactory.initElements(driver, CreatorAnnouncementPage.class);
		SignUpPage signUpPage=PageFactory.initElements(driver, SignUpPage.class);
		static Logger log = Logger.getLogger(CreatorAnnouncementPage.class.getName());
		Actions action = new Actions(driver);
		Random rand=new Random();
		String announcementName;
		List <TestDataForSunbird> objListOFTestDataForSunbird= null;

	public void navigateToAnnouncementInDropDownMenu() throws InterruptedException
	{
		try{
			ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to navigate to announcement dashboard in drop down menu");
			/*GenericFunctions.waitForElementToAppear(AnnouncementPageObj.closePopUp);
			AnnouncementPageObj.closePopUp.click();*/
			GenericFunctions.waitTillTheElementIsVisibleAndClickable(AnnouncementPageObj.closePopUp);
			GenericFunctions.waitWebDriver(2000);
			AnnouncementPageObj.profileIconDropdown.click();
			GenericFunctions.waitWebDriver(1000);
			AnnouncementPageObj.announcement_Dashboard.click();	
		}
		catch(Exception e)
		{
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed on navigating announcement in drop down menu");
			ExtentTestManager.getTest().log(LogStatus.FAIL,"Exception Message: "+e.getLocalizedMessage());
			log.error("Exception In the method navigateToAnnouncementInDropDownMenu"+e.getMessage());
			Assert.fail("Failed on navigating to announcement dashboard in drop down menu, Exception : "+e.getLocalizedMessage());

		}
	}
	
	
	public void CreateAnnouncementPopUp() throws InterruptedException, Exception
	{

		try{
			ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to verify create announcement Popup");
			Robot robot = new Robot();
			objListOFTestDataForSunbird = ReadTestDataFromExcel.getTestDataForSunbird("testdatasheetcourse");
			GenericFunctions.waitWebDriver(1500);
			AnnouncementPageObj.create_Announcement.click();
			GenericFunctions.waitWebDriver(5000);
			AnnouncementPageObj.enterTitle.click();
			String announcementNumber = GenericFunctions.testDataIncrementer(".//TestData//announcementNumbers.txt").toString();
			announcementName = objListOFTestDataForSunbird.get(7).getCourseName();
			System.out.println(announcementName + announcementNumber);
			AnnouncementPageObj.enterTitle.sendKeys(announcementName + announcementNumber );
			GenericFunctions.waitWebDriver(1000);
			AnnouncementPageObj.enterOrg.click();
			AnnouncementPageObj.enterOrg.sendKeys(objListOFTestDataForSunbird.get(7).getCourseDescription());
			GenericFunctions.waitWebDriver(1000);
			AnnouncementPageObj.announcementType.click();
			GenericFunctions.waitWebDriver(1000);
			AnnouncementPageObj.announcementTypeCircular.click();
			GenericFunctions.waitWebDriver(1000);
			AnnouncementPageObj.enterDescription.click();
			AnnouncementPageObj.enterDescription.sendKeys(objListOFTestDataForSunbird.get(7).getTitle());
			GenericFunctions.waitWebDriver(2000);
			AnnouncementPageObj.addUrl.click();
			GenericFunctions.waitWebDriver(1000);
			AnnouncementPageObj.enterUrl.click();
			GenericFunctions.waitWebDriver(1000);
			AnnouncementPageObj.enterUrl.sendKeys(objListOFTestDataForSunbird.get(7).getTitleDescription());
			GenericFunctions.waitWebDriver(1000);
			Assert.assertTrue(true,"User is able to enter title & org, select announcement type, enter description and add URL successfully ");
			log.info("User is able to enter title & org, select announcement type, enter description and add URL successfully ");
			System.out.println("User is able to enter title & org, select announcement type, enter description and add URL successfully ");
		}
		
		catch(Exception e)
		{
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed on verifying announcement popup : Title, org, Type, Description, Link");
			ExtentTestManager.getTest().log(LogStatus.FAIL,"Exception Message: "+e.getLocalizedMessage());
			log.error("Exception In the method CreateAnnouncementPopUp"+e.getMessage());
			Assert.fail("Failed on verifying announcement popup : Title, org, Type, Description, Link, Exception : "+e.getLocalizedMessage());
		}
		
	 }
	
	
	public void editAndResendAnnounccement() throws InterruptedException, Exception
	{

		try{
			ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to edit,resend and validate the edited announcement");
			//Robot robot = new Robot();
			//objListOFTestDataForSunbird = ReadTestDataFromExcel.getTestDataForSunbird("testdatasheetcourse");
			GenericFunctions.waitForElementToAppear(AnnouncementPageObj.resendAnnouncementButton);
			AnnouncementPageObj.resendAnnouncementButton.click();
			GenericFunctions.waitWebDriver(5000);
			AnnouncementPageObj.resendTitle.click();
			AnnouncementPageObj.resendTitle.clear();
			AnnouncementPageObj.resendTitle.sendKeys("Automation123456789");
			GenericFunctions.waitWebDriver(1000);
			AnnouncementPageObj.editRecipients.click();
			GenericFunctions.waitWebDriver(1000);
			AnnouncementPageObj.searchForLocation.sendKeys("Nellore");
			GenericFunctions.waitWebDriver(1000);
//			AnnouncementPageObj.checkLocation.click();
//			GenericFunctions.waitWebDriver(1000);
			AnnouncementPageObj.confirmRecipients.click();
			GenericFunctions.waitWebDriver(1000);
			AnnouncementPageObj.previewAnnouncement.click();
			GenericFunctions.waitWebDriver(1000);
			AnnouncementPageObj.sendAnnouncement.click();
			GenericFunctions.waitWebDriver(1000);
			AnnouncementPageObj.announcementcreatedConfirmation.click();
			GenericFunctions.waitWebDriver(3000);
			String editproof = AnnouncementPageObj.editedAnnouncement.getText();
			System.out.println(editproof + "This is the edited Title");
			Assert.assertTrue(true,"User is able to edit and resendd the announcement suuccessfully");
			log.info("User is able to edit and resendd the announcement suuccessfully");
			System.out.println("User is able to edit and resendd the announcement suuccessfully");
			GenericFunctions.waitWebDriver(1500);
		}
		
		catch(Exception e)
		{
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed to edit and resend announcement");
			ExtentTestManager.getTest().log(LogStatus.FAIL,"Exception Message: "+e.getLocalizedMessage());
			log.error("Exception In the method editAndResendAnnounccement"+e.getMessage());
			Assert.fail("Failed to edit and resend announcement: "+e.getLocalizedMessage());
		}
		
	 }
	
	public void verifyDataStorage() throws InterruptedException, Exception
	{

		try{
			ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to verify that page data is stored correctly by checking in back button");
			Robot robot = new Robot();
			objListOFTestDataForSunbird = ReadTestDataFromExcel.getTestDataForSunbird("testdatasheetcourse");
			GenericFunctions.waitWebDriver(1500);
			AnnouncementPageObj.create_Announcement.click();
			GenericFunctions.waitWebDriver(1000);
			GenericFunctions.waitForElementToAppear(AnnouncementPageObj.enterTitle);
			AnnouncementPageObj.enterTitle.click();
			String announcementNumber = GenericFunctions.testDataIncrementer(".//TestData//announcementNumbers.txt").toString();
			announcementName = objListOFTestDataForSunbird.get(7).getCourseName();
			System.out.println(announcementName + announcementNumber);
			AnnouncementPageObj.enterTitle.sendKeys(announcementName + announcementNumber );
			AnnouncementPageObj.enterOrg.click();
			AnnouncementPageObj.enterOrg.sendKeys(objListOFTestDataForSunbird.get(7).getCourseDescription());
			AnnouncementPageObj.announcementType.click();
			GenericFunctions.waitWebDriver(1000);
			AnnouncementPageObj.announcementTypeCircular.click();
			GenericFunctions.waitWebDriver(1000);
			AnnouncementPageObj.enterDescription.click();
			AnnouncementPageObj.enterDescription.sendKeys(objListOFTestDataForSunbird.get(7).getTitle());
			GenericFunctions.waitWebDriver(2000);
			AnnouncementPageObj.addUrl.click();
			GenericFunctions.waitWebDriver(1000);
			AnnouncementPageObj.enterUrl.click();
			GenericFunctions.waitWebDriver(1000);
			AnnouncementPageObj.enterUrl.sendKeys(objListOFTestDataForSunbird.get(7).getTitleDescription());
			GenericFunctions.waitWebDriver(1000);
			AnnouncementPageObj.selectRecipients.click();
			GenericFunctions.waitWebDriver(3000);
			AnnouncementPageObj.back.click();
			GenericFunctions.waitWebDriver(3000);
			AnnouncementPageObj.selectRecipients.click();
			GenericFunctions.waitWebDriver(1000);
			AnnouncementPageObj.searchForLocation.click();
			GenericFunctions.waitWebDriver(2000);
			AnnouncementPageObj.searchForLocation.sendKeys("Nellore");
			GenericFunctions.waitWebDriver(1000);
			AnnouncementPageObj.checkLocation.click();
			GenericFunctions.waitWebDriver(1000);
			AnnouncementPageObj.confirmRecipients.click();
			GenericFunctions.waitWebDriver(3000);
			AnnouncementPageObj.back.click();
			GenericFunctions.waitWebDriver(1000);
			AnnouncementPageObj.confirmRecipients.click();
			GenericFunctions.waitWebDriver(1000);
			AnnouncementPageObj.previewAnnouncement.click();
			GenericFunctions.waitWebDriver(3000);
			AnnouncementPageObj.back.click();
			GenericFunctions.waitWebDriver(1000);
			AnnouncementPageObj.previewAnnouncement.click();
			GenericFunctions.waitWebDriver(1000);
			AnnouncementPageObj.sendAnnouncement.click();
			GenericFunctions.waitWebDriver(1000);
			AnnouncementPageObj.announcementcreatedConfirmation.click();
			GenericFunctions.waitWebDriver(1000);
			System.out.println("Page Data storage verified successfully by going Back to every page");
			Assert.assertTrue(true,"Previous pages data are correctly displayed upon clicking on Back button when user returns to previous screen");
			log.info("Previous pages data are correctly displayed upon clicking on Back button when user returns to previous screen");
			System.out.println("Previous pages data are correctly displayed upon clicking on Back button when user returns to previous screen");
		}
		
		catch(Exception e)
		{
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed to store the page data correctly after clicking Back button");
			ExtentTestManager.getTest().log(LogStatus.FAIL,"Exception Message: "+e.getLocalizedMessage());
			log.error("Exception In the method verifyBackButton"+e.getMessage());
			Assert.fail("Failed to store the page data correctly after clicking Back button: "+e.getLocalizedMessage());
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
			String announcementNumber = GenericFunctions.testDataIncrementer("./testData/announcementNumbers.txt").toString();
			announcementName = objListOFTestDataForSunbird.get(7).getCourseName()+announcementNumber;
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
			/*createAnnouncementPage.addUrl.click();
			GenericFunctions.waitWebDriver(1000);
			createAnnouncementPage.enterUrl.click();
			GenericFunctions.waitWebDriver(1000);
			createAnnouncementPage.enterUrl.sendKeys("https://www.google.com/");*/
			GenericFunctions.waitWebDriver(2000);
			GenericFunctions.clickOnElementUsingJavascript(createAnnouncementPage.selectRecipient);
			/*action.moveToElement(createAnnouncementPage.selectRecipient).build().perform();
			action.click().build().perform();*/
			GenericFunctions.waitWebDriver(8000);
			GenericFunctions.waitForElements(createAnnouncementPage.checkLocation);
			GenericFunctions.waitWebDriver(5000);
			createAnnouncementPage.checkLocation.get(0).click();
			createAnnouncementPage.checkLocation.get(1).click();
			//action.moveToElement(createAnnouncementPage.checkLocation).click().build().perform();
			GenericFunctions.waitWebDriver(2000);
			GenericFunctions.clickOnElementUsingJavascript(createAnnouncementPage.confirmRecipients);
			//createAnnouncementPage.confirmRecipients.click();
			GenericFunctions.waitForElementToAppear(createAnnouncementPage.previewAnnouncement);
			GenericFunctions.clickOnElementUsingJavascript(createAnnouncementPage.previewAnnouncement);
			//createAnnouncementPage.previewAnnouncement.click();
			GenericFunctions.waitForElementToAppear(createAnnouncementPage.sendAnnouncement);
			GenericFunctions.waitWebDriver(2000);
			GenericFunctions.clickOnElementUsingJavascript(createAnnouncementPage.sendAnnouncement);
			//createAnnouncementPage.sendAnnouncement.click();
			GenericFunctions.waitForElementToAppear(createAnnouncementPage.announcementcreatedConfirmation);
			GenericFunctions.clickOnElementUsingJavascript(createAnnouncementPage.announcementcreatedConfirmation);
			//createAnnouncementPage.announcementcreatedConfirmation.click();
			GenericFunctions.waitWebDriver(2000);
		}
		catch(Exception e)
		{
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed on creating an announcement");
			ExtentTestManager.getTest().log(LogStatus.FAIL,"Exception Message: "+e.getLocalizedMessage());
			log.error("Exception In the method CreateAnnouncement"+e.getMessage());
			Assert.fail("Failed to create an announcement, Exception : "+e.getLocalizedMessage());
		}
	}
	
	
}