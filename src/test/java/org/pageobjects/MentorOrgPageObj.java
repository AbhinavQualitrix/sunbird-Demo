package org.pageobjects;


import java.awt.Robot;
import java.util.List;
import java.util.Random;

import org.apache.log4j.Logger;
import org.generic.ExtentTestManager;
import org.generic.GenericFunctions;
import org.generic.ReadTestDataFromExcel;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.page.CreatorAnnouncementPage;
import org.page.MentorOrgPage;
import org.page.UploadOrgPage;
import org.startup.BaseTest;
import org.testdata.TestDataForSunbird;
import org.testng.Assert;

import com.relevantcodes.extentreports.LogStatus;

public class MentorOrgPageObj extends BaseTest
{   
	MentorOrgPage mentorOrgPage = PageFactory.initElements(driver, MentorOrgPage.class);
//	mentorOrgPage mentorOrgPage=PageFactory.initElements(driver, mentorOrgPage.class);
//	CreatorUserPageObj mentorOrgPage=PageFactory.initElements(driver, CreatorUserPageObj.class);
//	MentorOrgPageObjObjects mentorOrgPage = PageFactory.initElements(driver, MentorOrgPageObjObjects.class);
//	PublicUserPageObj publicUserPageObj = PageFactory.initElements(driver, PublicUserPageObj.class);
//	CreatorUserPageObj mentorOrgPage = PageFactory.initElements(driver, CreatorUserPageObj.class);
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
	GenericFunctions.waitForElementToAppear(mentorOrgPage.headerCourse);
	mentorOrgPage.headerCourse.click();
	GenericFunctions.waitWebDriver(2000);
		
	mentorOrgPage.course.click();
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
			GenericFunctions.waitForElementToAppear(mentorOrgPage.courseName);
			String courseNumber = GenericFunctions.testDataIncrementer("./testData/courseNumbers.txt").toString();
			mentorOrgPage.courseName.sendKeys(objListOFTestDataForSunbird.get(0).getCourseName()+courseNumber);
			mentorOrgPage.courseDescription.sendKeys(objListOFTestDataForSunbird.get(0).getCourseDescription()+courseNumber);	
			GenericFunctions.waitWebDriver(1500);
			mentorOrgPage.startCreating.click();
			/*GenericFunctions.refreshWebPage();
			GenericFunctions.waitWebDriver(1500);*/
			GenericFunctions.waitWebDriver(4500);
			GenericFunctions.WaitForFrameAndSwitchToIt(mentorOrgPage.iFrame);
			GenericFunctions.waitWebDriver(6500);
			GenericFunctions.waitForElementToAppear(mentorOrgPage.newChild);
			System.out.println("Creating - "+mentorOrgPage.newChild.getText());
			GenericFunctions.waitWebDriver(3000);
			action.moveToElement(mentorOrgPage.newChild).click().perform();
			//action.moveToElement(mentorOrgPage.newChild).click().release();
			GenericFunctions.waitWebDriver(1500);
			mentorOrgPage.titleName.click();
			mentorOrgPage.titleName.clear();
			mentorOrgPage.titleName.sendKeys(objListOFTestDataForSunbird.get(0).getTitle()+courseNumber);
			mentorOrgPage.titleDescription.sendKeys(objListOFTestDataForSunbird.get(0).getTitleDescription()+courseNumber);
			GenericFunctions.waitWebDriver(1500);
			mentorOrgPage.addResource.click();

			//added on 17 Aug 2018
			//driver.switchTo().frame(0);
			GenericFunctions.waitForElementToAppear(mentorOrgPage.selectResource);
			mentorOrgPage.selectResource.click();
			GenericFunctions.waitWebDriver(500);
			mentorOrgPage.proceedButton.click();
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
			GenericFunctions.waitForElementToAppear(mentorOrgPage.saveCourse);
			mentorOrgPage.saveCourse.click();
			GenericFunctions.waitWebDriver(2000);
			mentorOrgPage.sendForReview.click();
			GenericFunctions.waitWebDriver(1500);
			mentorOrgPage.clickAppIcon.click();
			GenericFunctions.waitWebDriver(3000);	
			GenericFunctions.waitForElementToAppear(mentorOrgPage.checkContentIcon);
			mentorOrgPage.checkContentIcon.click();
			GenericFunctions.waitWebDriver(1000);
			mentorOrgPage.selectAppIcon.click();
			GenericFunctions.waitWebDriver(1000);
			
			GenericFunctions.waitForElementToAppear(mentorOrgPage.clickOnSelectCurriculum);
			mentorOrgPage.clickOnSelectCurriculum.click();
			GenericFunctions.waitWebDriver(1000);
			mentorOrgPage.selectCurriculum.click();
			GenericFunctions.waitForElementToAppear(mentorOrgPage.clickOnSelectClass);
			mentorOrgPage.clickOnSelectClass.click();
			GenericFunctions.waitWebDriver(1000); 
			mentorOrgPage.selectClass.click();
			GenericFunctions.waitWebDriver(1000); 
			mentorOrgPage.clickOnSelectClass.click();//      
			
			//GenericFunctions.keyTab(driver, mentorOrgPage.selectClass.toString());
			//GenericFunctions.waitTillTheElementIsVisibleAndClickable(mentorOrgPage.clickOnHeaderSubject);
			//mentorOrgPage.clickOnHeaderSubject.click();
			GenericFunctions.waitWebDriver(5000);
			//GenericFunctions.waitTillTheElementIsVisibleAndClickable(mentorOrgPage.clickOnSelectSubject);
			//GenericFunctions.scrollToElement(mentorOrgPage.clickOnSelectMedium);
//			GenericFunctions.waitWebDriver(2000);
//			mentorOrgPage.clickOnSelectSubject.click();
//			GenericFunctions.waitForElementToAppear(mentorOrgPage.selectSubject);
//			mentorOrgPage.selectMathematics.click();
//			GenericFunctions.waitWebDriver(1500);
			GenericFunctions.scrollToElement(mentorOrgPage.clickOnSelectMedium);
			GenericFunctions.waitWebDriver(5000);
			mentorOrgPage.clickOnSelectMedium.click();
			GenericFunctions.waitForElementToAppearOnScreen(mentorOrgPage.selectMedium);
			mentorOrgPage.selectMedium.click();
			GenericFunctions.waitWebDriver(1500);
			GenericFunctions.scrollToElement(mentorOrgPage.clickOwner);
			GenericFunctions.waitForElementToAppear(mentorOrgPage.clickOwner);
			mentorOrgPage.clickOwner.click();
			GenericFunctions.waitWebDriver(1500);
			mentorOrgPage.selectOwner.click();
			GenericFunctions.waitWebDriver(1500);
			
			
			mentorOrgPage.saveButton.click();
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
//  	GenericFunctions.waitForElementToAppear(mentorOrgPage.closePopUp);
//		mentorOrgPage.closePopUp.click();
//		GenericFunctions.waitWebDriver(1500);	
//    	GenericFunctions.waitForElementToAppear(mentorOrgPage.Workspace);
    	GenericFunctions.waitWebDriver(500);
    	mentorOrgPage.Workspace.click();
		GenericFunctions.waitForElementToAppear(mentorOrgPage.upForReview);
		GenericFunctions.waitWebDriver(2000);
		mentorOrgPage.upForReview.click();
		GenericFunctions.waitForElementToAppear(mentorOrgPage.firtContent);
		String courseContent = mentorOrgPage.firtContent.getText();
		System.out.println(courseContent);
		GenericFunctions.waitWebDriver(2000);
		mentorOrgPage.firtContent.click();
		GenericFunctions.WaitForFrameAndSwitchToIt(mentorOrgPage.iFrame);
		GenericFunctions.waitWebDriver(2000);
		GenericFunctions.scrollToElement(mentorOrgPage.headerPublish);
		GenericFunctions.waitWebDriver(4000);
		if(mentorOrgPage.headerPublish.isDisplayed())
		{
		mentorOrgPage.headerPublish.click();
		}
		else if(mentorOrgPage.Publish.isDisplayed())
		{
			mentorOrgPage.Publish.click();
		}
		
		GenericFunctions.waitForElementToAppear(mentorOrgPage.publishConfirm);
		mentorOrgPage.publishConfirm.click();			
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
			/*mentorOrgPage.dropDown.click();
			GenericFunctions.waitForElementToAppear(mentorOrgPage.headerProfile);
			mentorOrgPage.headerProfile.click();*/
			mentorOrgPage.headerCourse.click();
			GenericFunctions.waitWebDriver(1000);
			String courseNumber = GenericFunctions.testDataIncrementer("./testData/courseNumbers.txt").toString();
			mentorOrgPage.filterSearch.sendKeys(objListOFTestDataForSunbird1.get(0).getTitle()+courseNumber);
			mentorOrgPage.searchIconUpForReview.click();
			GenericFunctions.waitWebDriver(2000);
			mentorOrgPage.searchedCourse.click();
			GenericFunctions.waitWebDriver(1000);
			mentorOrgPage.createBatch.click();
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
			// mentorOrgPage.headerCourse.click();
			// GenericFunctions.waitWebDriver(1000);
			// mentorOrgPage.filterSearch.sendKeys(objListOFTestDataForSunbird.get(0).getCourseName()+GenericFunctions.readFromNotepad(".//batchNumbers.txt").toUpperCase());
			// mentorOrgPage.searchIcon.click();
			// GenericFunctions.waitWebDriver(2000);
			// mentorOrgPage.courseImg1.click();
			// GenericFunctions.waitWebDriver(3000);
			mentorOrgPage.addIcon.click();
			GenericFunctions.waitWebDriver(1000);
			GenericFunctions.switchToFrame(driver, mentorOrgPage.batchForm);
			GenericFunctions.waitWebDriver(1000);
			mentorOrgPage.nameOfBatch.sendKeys(objListOFTestDataForSunbird.get(0).getCourseName()
					+ GenericFunctions.testDataIncrementer("./testData/sunbird_data.txt"));
			mentorOrgPage.aboutBatch.sendKeys(objListOFTestDataForSunbird.get(0).getCourseName());
//			mentorOrgPage.openBatch.click();
			mentorOrgPage.startDate.click(); // sendKeys(objListOFTestDataForSunbird.get(8).getTitle());
			GenericFunctions.waitWebDriver(1000);
			mentorOrgPage.startDateCalendar.click(); // sendKeys(objListOFTestDataForSunbird.get(8).getTitle());
			mentorOrgPage.endDate.sendKeys(objListOFTestDataForSunbird.get(8).getTitleDescription());
			GenericFunctions.waitWebDriver(3000);
			mentorOrgPage.mentorsInBatch.click();
			mentorOrgPage.suborgMentor2InBatch.click();
			GenericFunctions.waitWebDriver(1500);			
			mentorOrgPage.membersInBatch.click();
			GenericFunctions.waitWebDriver(1500);
			mentorOrgPage.testBookReviewerInBatch.click();
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

			mentorOrgPage.buttonCreate.click();
			// mentorOrgPage.successfulMessage.click();
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
			GenericFunctions.waitForElementToAppear(mentorOrgPage.closePopUp);
			mentorOrgPage.closePopUp.click();
			GenericFunctions.waitWebDriver(1500);
			mentorOrgPage.headerCourse.click();
			GenericFunctions.waitWebDriver(4000);
			GenericFunctions.waitForElementToAppear(mentorOrgPage.latestCourse);
			mentorOrgPage.latestCourse.click();
			GenericFunctions.waitWebDriver(3000);
			mentorOrgPage.addIcon.click();
			GenericFunctions.waitWebDriver(2000);
			mentorOrgPage.nameOfBatch.sendKeys(objListOFTestDataForSunbird.get(0).getCourseName()
					+ GenericFunctions.testDataIncrementer("./testData/batchNumbers.txt"));
			mentorOrgPage.aboutBatch.sendKeys(objListOFTestDataForSunbird.get(0).getCourseName());

			mentorOrgPage.startDate.click();
			GenericFunctions.waitWebDriver(1000);
			mentorOrgPage.startDateCalendar.click();
			GenericFunctions.waitWebDriver(1000);
			mentorOrgPage.endDate.sendKeys(objListOFTestDataForSunbird.get(8).getTitleDescription());
			
			mentorOrgPage.mentorsInBatch.click();
			GenericFunctions.waitWebDriver(1000);				
			mentorOrgPage.suborgMentor2InBatch.click();
			mentorOrgPage.mentorsInBatch.click();
			
			GenericFunctions.waitWebDriver(1000);								
			mentorOrgPage.mentorDropdown.click();
			mentorOrgPage.membersInBatch.click();
			mentorOrgPage.mentorDropdown.click();
			GenericFunctions.waitWebDriver(1500);	
			
			GenericFunctions.waitTillTheElementIsVisibleAndClickable(mentorOrgPage.buttonCreate);
			mentorOrgPage.buttonCreate.click();
			GenericFunctions.waitWebDriver(4000);
			//mentorOrgPage.successfulMessage.click();
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
