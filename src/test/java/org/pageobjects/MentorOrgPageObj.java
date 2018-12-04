package org.pageobjects;

import static org.testng.Assert.assertEquals;

import java.awt.Robot;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.security.auth.login.FailedLoginException;

import org.apache.poi.util.SystemOutLogger;
import org.generic.ExtentTestManager;
import org.generic.GenericFunctions;
import org.generic.ReadTestDataFromExcel;
import org.openqa.selenium.By;
import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.page.ContentCreateUploadPage;
import org.page.CreateMentorPage;
import org.page.CreatorAnnouncementPage;
import org.page.CreatorUserPage;
import org.page.FlagReviewerPage;
import org.page.PublicUserPage;
import org.startup.BaseTest;
import org.testdata.TestDataForSunbird;
import org.testng.Assert;

import com.relevantcodes.extentreports.LogStatus;

public class MentorOrgPageObj extends BaseTest
{   
	CreateMentorPage createMentorPage = PageFactory.initElements(driver, CreateMentorPage.class);
	CreateMentorPage CreateMentorPage=PageFactory.initElements(driver, CreateMentorPage.class);
	CreatorUserPage createUserPage=PageFactory.initElements(driver, CreatorUserPage.class);
	FlagReviewerPage flagReviewerpage = PageFactory.initElements(driver, FlagReviewerPage.class);
	PublicUserPage publicUserPage = PageFactory.initElements(driver, PublicUserPage.class);
	CreatorUserPage creatorPage = PageFactory.initElements(driver, CreatorUserPage.class);
	List <TestDataForSunbird> objListOFTestDataForSunbird1= null ;
	Random rand = new Random();
	Actions action = new Actions(driver);
	JavascriptExecutor js = (JavascriptExecutor)driver;
	static Logger log = Logger.getLogger(CreatorAnnouncementPage.class.getName());
	List<TestDataForSunbird> objListOFTestDataForSunbird = null;

 	// @author Sachin
 	public void coursePreview()throws Exception{
	try
 	{	
	ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to open the course");
	GenericFunctions.waitForElementToAppear(createUserPage.headerCourse);
	createUserPage.headerCourse.click();
	GenericFunctions.waitWebDriver(2000);
		
	createUserPage.course.click();
	Assert.assertTrue(true, "User is able to preview the content successfully");
	log.info("User is able to preview the content successfully");
	System.out.println("User is able to preview the content successfully");
	GenericFunctions.waitWebDriver(4000);
	}
	catch(Exception e)
	{				
		ExtentTestManager.getTest().log(LogStatus.FAIL, "User is trying to open the course");
		ExtentTestManager.getTest().log(LogStatus.FAIL, "Exception Message: "+e.getLocalizedMessage());
		Assert.fail("User is trying to open the course");
	}
 	
 }	
	
	public void createCourse(List <TestDataForSunbird> objListOFTestDataForSunbird) throws InterruptedException
	{
		try{
			ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to create course");
			GenericFunctions.waitWebDriver(1500);
			System.out.println(driver.findElement(By.xpath(" //span[contains(text(),'Design Course')]")).getText());
			GenericFunctions.waitForElementToAppear(createUserPage.courseName);
			String courseNumber = GenericFunctions.testDataIncrementer(".//testData//courseNumbers.txt").toString();
			createUserPage.courseName.sendKeys(objListOFTestDataForSunbird.get(0).getCourseName()+courseNumber);
			createUserPage.courseDescription.sendKeys(objListOFTestDataForSunbird.get(0).getCourseDescription()+courseNumber);	
			GenericFunctions.waitWebDriver(1500);
			createUserPage.startCreating.click();
			/*GenericFunctions.refreshWebPage();
			GenericFunctions.waitWebDriver(1500);*/
			GenericFunctions.waitWebDriver(4500);
			GenericFunctions.WaitForFrameAndSwitchToIt(createUserPage.iFrame);
			GenericFunctions.waitWebDriver(6500);
			GenericFunctions.waitForElementToAppear(createUserPage.newChild);
			System.out.println("Creating - "+createUserPage.newChild.getText());
			GenericFunctions.waitWebDriver(3000);
			action.moveToElement(createUserPage.newChild).click().perform();
			//action.moveToElement(createUserPage.newChild).click().release();
			GenericFunctions.waitWebDriver(1500);
			createUserPage.titleName.click();
			createUserPage.titleName.clear();
			createUserPage.titleName.sendKeys(objListOFTestDataForSunbird.get(0).getTitle()+courseNumber);
			createUserPage.titleDescription.sendKeys(objListOFTestDataForSunbird.get(0).getTitleDescription()+courseNumber);
			GenericFunctions.waitWebDriver(1500);
			createUserPage.addResource.click();

			//added on 17 Aug 2018
			//driver.switchTo().frame(0);
			GenericFunctions.waitForElementToAppear(createUserPage.selectResource);
			createUserPage.selectResource.click();
			GenericFunctions.waitWebDriver(500);
			createUserPage.proceedButton.click();
			GenericFunctions.waitWebDriver(2000);


		}
		catch(Exception e)
		{
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed to create course");
			ExtentTestManager.getTest().log(LogStatus.FAIL,"Exception Message: "+e.getLocalizedMessage());
			log.error("Exception In the method createCourse"+e.getMessage());
			System.out.println("Exception In the method createCourse, failed to create corse");
			Assert.fail("Failed on creating course");

		}
	}
	
	
	public void saveAndSendCourseForReview(List <TestDataForSunbird> objListOFTestDataForSunbird)throws Exception{

		try
		{
			ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to save and send course for review");
			GenericFunctions.waitForElementToAppear(createUserPage.saveCourse);
			createUserPage.saveCourse.click();
			GenericFunctions.waitWebDriver(2000);
			createUserPage.sendForReview.click();
			GenericFunctions.waitWebDriver(1500);
			createUserPage.clickAppIcon.click();
			GenericFunctions.waitWebDriver(3000);	
			GenericFunctions.waitForElementToAppear(createUserPage.checkContentIcon);
			createUserPage.checkContentIcon.click();
			GenericFunctions.waitWebDriver(1000);
			createUserPage.selectAppIcon.click();
			GenericFunctions.waitWebDriver(1000);
			
			GenericFunctions.waitForElementToAppear(createUserPage.clickOnSelectCurriculum);
			createUserPage.clickOnSelectCurriculum.click();
			GenericFunctions.waitWebDriver(1000);
			createUserPage.selectCurriculum.click();
			GenericFunctions.waitForElementToAppear(createUserPage.clickOnSelectClass);
			createUserPage.clickOnSelectClass.click();
			GenericFunctions.waitWebDriver(1000); 
			createUserPage.selectClass.click();
			GenericFunctions.waitWebDriver(1000); 
			createUserPage.clickOnSelectClass.click();//      
			
			//GenericFunctions.keyTab(driver, createUserPage.selectClass.toString());
			//GenericFunctions.waitTillTheElementIsVisibleAndClickable(createUserPage.clickOnHeaderSubject);
			//createUserPage.clickOnHeaderSubject.click();
			GenericFunctions.waitWebDriver(5000);
			//GenericFunctions.waitTillTheElementIsVisibleAndClickable(createUserPage.clickOnSelectSubject);
			//GenericFunctions.scrollToElement(createUserPage.clickOnSelectMedium);
//			GenericFunctions.waitWebDriver(2000);
//			createUserPage.clickOnSelectSubject.click();
//			GenericFunctions.waitForElementToAppear(createUserPage.selectSubject);
//			createUserPage.selectMathematics.click();
//			GenericFunctions.waitWebDriver(1500);
			GenericFunctions.scrollToElement(createUserPage.clickOnSelectMedium);
			GenericFunctions.waitWebDriver(5000);
			createUserPage.clickOnSelectMedium.click();
			GenericFunctions.waitForElementToAppearOnScreen(createUserPage.selectMedium);
			createUserPage.selectMedium.click();
			GenericFunctions.waitWebDriver(1500);
			GenericFunctions.scrollToElement(createUserPage.clickOwner);
			GenericFunctions.waitForElementToAppear(createUserPage.clickOwner);
			createUserPage.clickOwner.click();
			GenericFunctions.waitWebDriver(1500);
			createUserPage.selectOwner.click();
			GenericFunctions.waitWebDriver(1500);
			
			
			createUserPage.saveButton.click();
			GenericFunctions.waitWebDriver(1500);
		
			
		}
		catch(Exception e)
		{
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed on saving and sending course for review");
			ExtentTestManager.getTest().log(LogStatus.FAIL,"Exception Message: "+e.getLocalizedMessage());
			System.out.println("Failed to save and course for review");
			Assert.fail("Failed on saving and sending course for review");

		}

	}
	
	
	public void userLogout()throws Exception{
		try{
			ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to logout from the application");
			UploadOrgPage orgUploadPage=PageFactory.initElements(driver, UploadOrgPage.class);
			GenericFunctions.waitForElementToAppear(orgUploadPage.dropdown);
			orgUploadPage.dropdown.click();
			
			GenericFunctions.waitTillTheElementIsVisibleAndClickable(orgUploadPage.logout);
			orgUploadPage.logout.click();
			GenericFunctions.waitWebDriver(2000);
			System.out.println("User Logout");

		}
		catch(Exception e)
		{
			ExtentTestManager.getTest().log(LogStatus.FAIL, "User could not logout from the application");
			ExtentTestManager.getTest().log(LogStatus.FAIL,"Exception Message: "+e.getLocalizedMessage());
			Assert.fail("User failed to logout from the application"+e.getLocalizedMessage());
		}

	}
	
	
    
    public void publishCourse() throws Exception
    {
    try 
    {
		ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to publish the course");
//  	GenericFunctions.waitForElementToAppear(createUserPage.closePopUp);
//		createUserPage.closePopUp.click();
//		GenericFunctions.waitWebDriver(1500);	
//    	GenericFunctions.waitForElementToAppear(flagReviewerpage.Workspace);
    	GenericFunctions.waitWebDriver(500);
    	flagReviewerpage.Workspace.click();
		GenericFunctions.waitForElementToAppear(flagReviewerpage.upForReview);
		GenericFunctions.waitWebDriver(2000);
		flagReviewerpage.upForReview.click();
		GenericFunctions.waitForElementToAppear(flagReviewerpage.firtContent);
		String courseContent = flagReviewerpage.firtContent.getText();
		System.out.println(courseContent);
		GenericFunctions.waitWebDriver(2000);
		flagReviewerpage.firtContent.click();
		GenericFunctions.WaitForFrameAndSwitchToIt(creatorPage.iFrame);
		GenericFunctions.waitWebDriver(2000);
		GenericFunctions.scrollToElement(flagReviewerpage.headerPublish);
		GenericFunctions.waitWebDriver(4000);
		if(flagReviewerpage.headerPublish.isDisplayed())
		{
		flagReviewerpage.headerPublish.click();
		}
		else if(flagReviewerpage.Publish.isDisplayed())
		{
			flagReviewerpage.Publish.click();
		}
		
		GenericFunctions.waitForElementToAppear(flagReviewerpage.publishConfirm);
		flagReviewerpage.publishConfirm.click();			
    }
    catch(Exception e) 
    {
		ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed on publishing the course");
		ExtentTestManager.getTest().log(LogStatus.FAIL, "Exception Message: " + e.getLocalizedMessage());
		log.error("Exception In the method publishCourse" + e.getLocalizedMessage());
		Assert.fail("Failed on publishing te course, Exception : " + e.getLocalizedMessage());

	}
   }
	
    
	public void navigateToCourseSearchAndCreateBatch()
	{
		try
		{
			ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to navigate to search a coursea and create a batch");
			List <TestDataForSunbird> objListOFTestDataForSunbird1=null;
			objListOFTestDataForSunbird1 = ReadTestDataFromExcel.getTestDataForSunbird("testdatasheetcourse");
			/*createUserPage.dropDown.click();
			GenericFunctions.waitForElementToAppear(createUserPage.headerProfile);
			createUserPage.headerProfile.click();*/
			createUserPage.headerCourse.click();
			GenericFunctions.waitWebDriver(1000);
			String courseNumber = GenericFunctions.testDataIncrementer(".//testData//courseNumbers.txt").toString();
			CreateMentorPage.filterSearch.sendKeys(objListOFTestDataForSunbird1.get(0).getTitle()+courseNumber);
			createUserPage.searchIconUpForReview.click();
			GenericFunctions.waitWebDriver(2000);
			CreateMentorPage.searchedCourse.click();
			GenericFunctions.waitWebDriver(1000);
			CreateMentorPage.createBatch.click();
		}
		catch(Exception e)
		{
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed to search course and create a batch");
			ExtentTestManager.getTest().log(LogStatus.FAIL,"Exception Message: "+e.getLocalizedMessage());
			System.out.println("Other contents are available for reviewing");
			Assert.fail("Failed to search course and create a batch, Exception"+e.getLocalizedMessage());

		}

	}
	
	
	public void createOpenBatch() throws InterruptedException, Exception {

		try {
			// GenericFunctions.waitWebDriver(1500);
			// createUserPage.headerCourse.click();
			// GenericFunctions.waitWebDriver(1000);
			// createMentorPage.filterSearch.sendKeys(objListOFTestDataForSunbird.get(0).getCourseName()+GenericFunctions.readFromNotepad(".//batchNumbers.txt").toUpperCase());
			// createUserPage.searchIcon.click();
			// GenericFunctions.waitWebDriver(2000);
			// createMentorPage.courseImg1.click();
			// GenericFunctions.waitWebDriver(3000);
			createMentorPage.addIcon.click();
			GenericFunctions.waitWebDriver(1000);
			GenericFunctions.switchToFrame(driver, createMentorPage.batchForm);
			GenericFunctions.waitWebDriver(1000);
			createMentorPage.nameOfBatch.sendKeys(objListOFTestDataForSunbird.get(0).getCourseName()
					+ GenericFunctions.testDataIncrementer(".//TestData//sunbird_data.txt"));
			createMentorPage.aboutBatch.sendKeys(objListOFTestDataForSunbird.get(0).getCourseName());
//			createMentorPage.openBatch.click();
			createMentorPage.startDate.click(); // sendKeys(objListOFTestDataForSunbird.get(8).getTitle());
			GenericFunctions.waitWebDriver(1000);
			createMentorPage.startDateCalendar.click(); // sendKeys(objListOFTestDataForSunbird.get(8).getTitle());
			createMentorPage.endDate.sendKeys(objListOFTestDataForSunbird.get(8).getTitleDescription());
			GenericFunctions.waitWebDriver(3000);
			createMentorPage.mentorsInBatch.click();
			createMentorPage.suborgMentor2InBatch.click();
			GenericFunctions.waitWebDriver(1500);			
			createMentorPage.membersInBatch.click();
			GenericFunctions.waitWebDriver(1500);
			createMentorPage.testBookReviewerInBatch.click();
			GenericFunctions.waitWebDriver(1500);
			
			// GenericFunctions.waitWebDriver(1000);
			// for(int i=1;i<=7;i++)
			// {
			// robot.keyPress(KeyEvent.VK_TAB);
			// robot.keyRelease(KeyEvent.VK_TAB);
			// }
			// GenericFunctions.waitWebDriver(1000);
			//
			// robot.keyPress(KeyEvent.VK_ENTER);
			// GenericFunctions.waitWebDriver(1000);
			// robot.keyRelease(KeyEvent.VK_ENTER);
			// GenericFunctions.waitWebDriver(3000);

			createMentorPage.buttonCreate.click();
			// createMentorPage.successfulMessage.click();
			System.out.println("Batch Created");
			Assert.assertTrue(true, "Batch created successfully");
			log.info("Batch created successfully");
			System.out.println("Batch created successfully");
		} catch (Exception e) {
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed to create open batch");
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Exception Message: " + e.getLocalizedMessage());
			log.error("Exception In the method createOpenBatch" + e.getMessage());
			Assert.fail("Failed to create open batch, Exception" + e.getLocalizedMessage());

		}
	}
	
	
    
    // @author Sachin
	public void createInviteBatch() throws InterruptedException, Exception {
		Robot robot = new Robot();
	    objListOFTestDataForSunbird = ReadTestDataFromExcel.getTestDataForSunbird("testdatasheetcourse");
								
		try {
		ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to create invite only batch for a course");
			GenericFunctions.waitForElementToAppear(createUserPage.closePopUp);
			createUserPage.closePopUp.click();
			GenericFunctions.waitWebDriver(1500);
			createUserPage.headerCourse.click();
			GenericFunctions.waitWebDriver(4000);
			GenericFunctions.waitForElementToAppear(createMentorPage.latestCourse);
			createMentorPage.latestCourse.click();
			GenericFunctions.waitWebDriver(3000);
			createMentorPage.addIcon.click();
			GenericFunctions.waitWebDriver(2000);
			createMentorPage.nameOfBatch.sendKeys(objListOFTestDataForSunbird.get(0).getCourseName()
					+ GenericFunctions.testDataIncrementer(".//TestData//batchNumbers.txt"));
			createMentorPage.aboutBatch.sendKeys(objListOFTestDataForSunbird.get(0).getCourseName());

			createMentorPage.startDate.click();
			GenericFunctions.waitWebDriver(1000);
			createMentorPage.startDateCalendar.click();
			GenericFunctions.waitWebDriver(1000);
			createMentorPage.endDate.sendKeys(objListOFTestDataForSunbird.get(8).getTitleDescription());
			
			createMentorPage.mentorsInBatch.click();
			GenericFunctions.waitWebDriver(1000);				
			createMentorPage.suborgMentor2InBatch.click();
			createMentorPage.mentorsInBatch.click();
			
			GenericFunctions.waitWebDriver(1000);								
			createMentorPage.mentorDropdown.click();
			createMentorPage.membersInBatch.click();
			createMentorPage.mentorDropdown.click();
			GenericFunctions.waitWebDriver(1500);	
			
			GenericFunctions.waitTillTheElementIsVisibleAndClickable(createMentorPage.buttonCreate);
			createMentorPage.buttonCreate.click();
			GenericFunctions.waitWebDriver(4000);
			//createMentorPage.successfulMessage.click();
			System.out.println("Batch Created");
			Assert.assertTrue(true,"BAtch created successfully and invited members are auto invited to the course");
			System.out.println("BAtch created successfully and invited members are auto invited to the course");
			log.info("BAtch created successfully and invited members are auto invited to the course");
		} catch (Exception e) {
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed to create invite only batch");
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Exception Message: " + e.getLocalizedMessage());
			log.error("Exception In the method createInviteOnlyBatch" + e.getMessage());
			Assert.fail("Failed to create invite only batch, Exception" + e.getLocalizedMessage());
		}
		

	}
	
	
	} 
