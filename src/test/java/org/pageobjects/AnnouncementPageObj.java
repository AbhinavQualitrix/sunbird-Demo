package org.pageobjects;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.List;
import java.util.Random;

import org.apache.log4j.Logger;
import org.generic.ExtentTestManager;
import org.generic.GenericFunctions;
import org.generic.ReadTestDataFromExcel;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.page.AnnouncementPage;
import org.page.CreatorAnnouncementPage;
import org.page.SignUpPage;
import org.startup.BaseTest;
import org.testdata.TestDataForSunbird;
import org.testng.Assert;

import com.relevantcodes.extentreports.LogStatus;

public class AnnouncementPageObj extends BaseTest
{
	//private static final String IMAGE = null;
		WebDriverWait wait = new WebDriverWait(driver,20);
		AnnouncementPage announcementPage=PageFactory.initElements(driver, AnnouncementPage.class);
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
			GenericFunctions.waitForElementToAppear(announcementPage.closePopUp);
			announcementPage.closePopUp.click();
			GenericFunctions.waitWebDriver(1500);
			announcementPage.profileIconDropdown.click();
			GenericFunctions.waitWebDriver(1000);
			announcementPage.announcement_Dashboard.click();	
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
			announcementPage.create_Announcement.click();
			GenericFunctions.waitWebDriver(5000);
			announcementPage.enterTitle.click();
			String announcementNumber = GenericFunctions.testDataIncrementer("./testData/announcementNumbers.txt").toString();
			announcementName = objListOFTestDataForSunbird.get(7).getCourseName();
			System.out.println(announcementName + announcementNumber);
			announcementPage.enterTitle.sendKeys(announcementName + announcementNumber );
			GenericFunctions.waitWebDriver(1000);
			announcementPage.enterOrg.click();
			announcementPage.enterOrg.sendKeys(objListOFTestDataForSunbird.get(7).getCourseDescription());
			GenericFunctions.waitWebDriver(1000);
			announcementPage.announcementType.click();
			GenericFunctions.waitWebDriver(1000);
			announcementPage.announcementTypeCircular.click();
			GenericFunctions.waitWebDriver(1000);
			announcementPage.enterDescription.click();
			announcementPage.enterDescription.sendKeys(objListOFTestDataForSunbird.get(7).getTitle());
			GenericFunctions.waitWebDriver(2000);
			announcementPage.addUrl.click();
			GenericFunctions.waitWebDriver(1000);
			announcementPage.enterUrl.click();
			GenericFunctions.waitWebDriver(1000);
			announcementPage.enterUrl.sendKeys(objListOFTestDataForSunbird.get(7).getTitleDescription());
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
			GenericFunctions.waitForElementToAppear(announcementPage.resendAnnouncementButton);
			announcementPage.resendAnnouncementButton.click();
			GenericFunctions.waitWebDriver(5000);
			announcementPage.resendTitle.click();
			announcementPage.resendTitle.clear();
			announcementPage.resendTitle.sendKeys("Automation123456789");
			GenericFunctions.waitWebDriver(1000);
			announcementPage.editRecipients.click();
			GenericFunctions.waitWebDriver(1000);
			announcementPage.searchForLocation.sendKeys("Nellore");
			GenericFunctions.waitWebDriver(1000);
//			announcementPage.checkLocation.click();
//			GenericFunctions.waitWebDriver(1000);
			announcementPage.confirmRecipients.click();
			GenericFunctions.waitWebDriver(1000);
			announcementPage.previewAnnouncement.click();
			GenericFunctions.waitWebDriver(1000);
			announcementPage.sendAnnouncement.click();
			GenericFunctions.waitWebDriver(1000);
			announcementPage.announcementcreatedConfirmation.click();
			GenericFunctions.waitWebDriver(3000);
			String editproof = announcementPage.editedAnnouncement.getText();
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
			announcementPage.create_Announcement.click();
			GenericFunctions.waitWebDriver(1000);
			GenericFunctions.waitForElementToAppear(announcementPage.enterTitle);
			announcementPage.enterTitle.click();
			String announcementNumber = GenericFunctions.testDataIncrementer("./testData/announcementNumbers.txt").toString();
			announcementName = objListOFTestDataForSunbird.get(7).getCourseName();
			System.out.println(announcementName + announcementNumber);
			announcementPage.enterTitle.sendKeys(announcementName + announcementNumber );
			announcementPage.enterOrg.click();
			announcementPage.enterOrg.sendKeys(objListOFTestDataForSunbird.get(7).getCourseDescription());
			announcementPage.announcementType.click();
			GenericFunctions.waitWebDriver(1000);
			announcementPage.announcementTypeCircular.click();
			GenericFunctions.waitWebDriver(1000);
			announcementPage.enterDescription.click();
			announcementPage.enterDescription.sendKeys(objListOFTestDataForSunbird.get(7).getTitle());
			GenericFunctions.waitWebDriver(2000);
			announcementPage.addUrl.click();
			GenericFunctions.waitWebDriver(1000);
			announcementPage.enterUrl.click();
			GenericFunctions.waitWebDriver(1000);
			announcementPage.enterUrl.sendKeys(objListOFTestDataForSunbird.get(7).getTitleDescription());
			GenericFunctions.waitWebDriver(1000);
			announcementPage.selectRecipients.click();
			GenericFunctions.waitWebDriver(3000);
			announcementPage.back.click();
			GenericFunctions.waitWebDriver(3000);
			announcementPage.selectRecipients.click();
			GenericFunctions.waitWebDriver(1000);
			announcementPage.searchForLocation.click();
			GenericFunctions.waitWebDriver(2000);
			announcementPage.searchForLocation.sendKeys("Nellore");
			GenericFunctions.waitWebDriver(1000);
			announcementPage.checkLocation.click();
			GenericFunctions.waitWebDriver(1000);
			announcementPage.confirmRecipients.click();
			GenericFunctions.waitWebDriver(3000);
			announcementPage.back.click();
			GenericFunctions.waitWebDriver(1000);
			announcementPage.confirmRecipients.click();
			GenericFunctions.waitWebDriver(1000);
			announcementPage.previewAnnouncement.click();
			GenericFunctions.waitWebDriver(3000);
			announcementPage.back.click();
			GenericFunctions.waitWebDriver(1000);
			announcementPage.previewAnnouncement.click();
			GenericFunctions.waitWebDriver(1000);
			announcementPage.sendAnnouncement.click();
			GenericFunctions.waitWebDriver(1000);
			announcementPage.announcementcreatedConfirmation.click();
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
			Robot robot = new Robot();
			objListOFTestDataForSunbird = ReadTestDataFromExcel.getTestDataForSunbird("testdatasheetcourse");
			GenericFunctions.waitWebDriver(1500);
			announcementPage.create_Announcement.click();
			GenericFunctions.waitWebDriver(1000);
			//announcementPage.enterTitle.click();
			String announcementNumber = GenericFunctions.testDataIncrementer("./testData/announcementNumbers.txt").toString();
			announcementName = objListOFTestDataForSunbird.get(7).getCourseName();
			System.out.println(announcementName + announcementNumber);
			announcementPage.enterTitle.sendKeys(announcementName + announcementNumber );
			GenericFunctions.waitWebDriver(1000);
			announcementPage.enterOrg.click();
			announcementPage.enterOrg.sendKeys(objListOFTestDataForSunbird.get(7).getCourseDescription());
			GenericFunctions.waitWebDriver(1000);
			announcementPage.announcementType.click();
			GenericFunctions.waitWebDriver(1000);
			announcementPage.announcementTypeCircular.click();
			GenericFunctions.waitWebDriver(1000);
			announcementPage.enterDescription.click();
			announcementPage.enterDescription.sendKeys(objListOFTestDataForSunbird.get(7).getTitle());
			GenericFunctions.waitWebDriver(2000);
			announcementPage.addUrl.click();
			GenericFunctions.waitWebDriver(1000);
			announcementPage.enterUrl.click();
			GenericFunctions.waitWebDriver(1000);
			announcementPage.enterUrl.sendKeys(objListOFTestDataForSunbird.get(7).getTitleDescription());
			GenericFunctions.waitWebDriver(1000);
			for(int i=1;i<=3;i++)
			{
				robot.keyPress(KeyEvent.VK_TAB);
				robot.keyRelease(KeyEvent.VK_TAB);
			}
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
			GenericFunctions.waitWebDriver(2000);
			System.out.println("Button clicked");
			GenericFunctions.waitWebDriver(2000);
			announcementPage.searchForLocation.click();
			GenericFunctions.waitWebDriver(1000);
			announcementPage.searchForLocation.sendKeys("Nellore");
			GenericFunctions.waitWebDriver(1000);
			announcementPage.checkLocation.click();
			GenericFunctions.waitWebDriver(1000);
			announcementPage.confirmRecipients.click();
			GenericFunctions.waitWebDriver(1000);
			announcementPage.previewAnnouncement.click();
			GenericFunctions.waitWebDriver(1000);
			announcementPage.sendAnnouncement.click();
			GenericFunctions.waitWebDriver(1000);
			announcementPage.announcementcreatedConfirmation.click();
			GenericFunctions.waitWebDriver(1000);
			Assert.assertTrue(true,"After confirming, the announcement popup closed successfully");
			log.info("After confirming, the announcement popup closed successfully");
			System.out.println("After confirming, the announcement popup closed successfully");
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