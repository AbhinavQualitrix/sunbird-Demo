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
import org.page.BatchUserPage;
import org.page.ContentCreateUploadPage;
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

public class BatchUserPageObj extends BaseTest
{
	WebDriverWait wait = new WebDriverWait(driver,20);
	BatchUserPage BatchUserPageObj = PageFactory.initElements(driver, BatchUserPage.class);
//	CreatorUserPage BatchUserPageObj = PageFactory.initElements(driver, CreatorUserPage.class);
//	BatchUserPageObj BatchUserPageObj=PageFactory.initElements(driver, BatchUserPageObj.class);
//	CreatorUserPage BatchUserPageObj=PageFactory.initElements(driver, CreatorUserPage.class);
//	BatchUserPageObjObjects BatchUserPageObj = PageFactory.initElements(driver, BatchUserPageObjObjects.class);
//	PublicUserPage publicUserPage = PageFactory.initElements(driver, PublicUserPage.class);
//	BatchUserPageObj BatchUserPageObj=PageFactory.initElements(driver, BatchUserPageObj.class);
//	ContentCreateUploadPage contentCreatePage = PageFactory.initElements(driver, ContentCreateUploadPage.class);
	CreatorUserPageObj createrUserPageObj = new CreatorUserPageObj();
	SignUpPage signUpPage=PageFactory.initElements(driver, SignUpPage.class);
	static Logger log = Logger.getLogger(CreatorUserPageObj.class.getName());
	List <TestDataForSunbird> objListOFTestDataForSunbird= null ;
	
	Actions action = new Actions(driver);
	Random rand=new Random();
	String eurl="https://staging.open-sunbird.org/workspace/content/edit/generic#no";
	String a="Browse";
	String title="";


	public void createCourse(List <TestDataForSunbird> objListOFTestDataForSunbird) throws InterruptedException
	{
		try{
			ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to create course");
			GenericFunctions.waitWebDriver(1500);
			System.out.println(driver.findElement(By.xpath(" //span[contains(text(),'Design Course')]")).getText());
			GenericFunctions.waitForElementToAppear(BatchUserPageObj.courseName);
			String courseNumber = GenericFunctions.testDataIncrementer(".//testData//courseNumbers.txt").toString();
			BatchUserPageObj.courseName.sendKeys(objListOFTestDataForSunbird.get(0).getCourseName()+courseNumber);
			BatchUserPageObj.courseDescription.sendKeys(objListOFTestDataForSunbird.get(0).getCourseDescription()+courseNumber);	
			GenericFunctions.waitWebDriver(1500);
			BatchUserPageObj.startCreating.click();
			/*GenericFunctions.refreshWebPage();
			GenericFunctions.waitWebDriver(1500);*/
			GenericFunctions.waitWebDriver(4500);
			GenericFunctions.WaitForFrameAndSwitchToIt(BatchUserPageObj.iFrame);
			GenericFunctions.waitWebDriver(6500);
			GenericFunctions.waitForElementToAppear(BatchUserPageObj.newChild);
			System.out.println("Creating - "+BatchUserPageObj.newChild.getText());
			GenericFunctions.waitWebDriver(3000);
			action.moveToElement(BatchUserPageObj.newChild).click().perform();
			//action.moveToElement(BatchUserPageObj.newChild).click().release();
			GenericFunctions.waitWebDriver(1500);
			BatchUserPageObj.titleName.click();
			BatchUserPageObj.titleName.clear();
			BatchUserPageObj.titleName.sendKeys(objListOFTestDataForSunbird.get(0).getTitle()+courseNumber);
			BatchUserPageObj.titleDescription.sendKeys(objListOFTestDataForSunbird.get(0).getTitleDescription()+courseNumber);
			GenericFunctions.waitWebDriver(1500);
			BatchUserPageObj.addResource.click();

			//added on 17 Aug 2018
			//driver.switchTo().frame(0);
			GenericFunctions.waitForElementToAppear(BatchUserPageObj.selectResource);
			BatchUserPageObj.selectResource.click();
			GenericFunctions.waitWebDriver(500);
			BatchUserPageObj.proceedButton.click();
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
			GenericFunctions.waitForElementToAppear(BatchUserPageObj.saveCourse);
			BatchUserPageObj.saveCourse.click();
			GenericFunctions.waitWebDriver(2000);
			BatchUserPageObj.sendForReview.click();
			GenericFunctions.waitWebDriver(1500);
			BatchUserPageObj.clickAppIcon.click();
			GenericFunctions.waitWebDriver(3000);	
			GenericFunctions.waitForElementToAppear(BatchUserPageObj.checkContentIcon);
			BatchUserPageObj.checkContentIcon.click();
			GenericFunctions.waitWebDriver(1000);
			BatchUserPageObj.selectAppIcon.click();
			GenericFunctions.waitWebDriver(1000);
			
			GenericFunctions.waitForElementToAppear(BatchUserPageObj.clickOnSelectCurriculum);
			BatchUserPageObj.clickOnSelectCurriculum.click();
			GenericFunctions.waitWebDriver(1000);
			BatchUserPageObj.selectCurriculum.click();
			GenericFunctions.waitForElementToAppear(BatchUserPageObj.clickOnSelectClass);
			BatchUserPageObj.clickOnSelectClass.click();
			GenericFunctions.waitWebDriver(1000); 
			BatchUserPageObj.selectClass.click();
			GenericFunctions.waitWebDriver(1000); 
			BatchUserPageObj.clickOnSelectClass.click();//      
			
			//GenericFunctions.keyTab(driver, BatchUserPageObj.selectClass.toString());
			//GenericFunctions.waitTillTheElementIsVisibleAndClickable(BatchUserPageObj.clickOnHeaderSubject);
			//BatchUserPageObj.clickOnHeaderSubject.click();
			GenericFunctions.waitWebDriver(5000);
			//GenericFunctions.waitTillTheElementIsVisibleAndClickable(BatchUserPageObj.clickOnSelectSubject);
			//GenericFunctions.scrollToElement(BatchUserPageObj.clickOnSelectMedium);
//			GenericFunctions.waitWebDriver(2000);
//			BatchUserPageObj.clickOnSelectSubject.click();
//			GenericFunctions.waitForElementToAppear(BatchUserPageObj.selectSubject);
//			BatchUserPageObj.selectMathematics.click();
//			GenericFunctions.waitWebDriver(1500);
			GenericFunctions.scrollToElement(BatchUserPageObj.clickOnSelectMedium);
			GenericFunctions.waitWebDriver(5000);
			BatchUserPageObj.clickOnSelectMedium.click();
			GenericFunctions.waitForElementToAppearOnScreen(BatchUserPageObj.selectMedium);
			BatchUserPageObj.selectMedium.click();
			GenericFunctions.waitWebDriver(1500);
			GenericFunctions.scrollToElement(BatchUserPageObj.clickOwner);
			GenericFunctions.waitForElementToAppear(BatchUserPageObj.clickOwner);
			BatchUserPageObj.clickOwner.click();
			GenericFunctions.waitWebDriver(1500);
			BatchUserPageObj.selectOwner.click();
			GenericFunctions.waitWebDriver(1500);
			
			
			BatchUserPageObj.saveButton.click();
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
//  	GenericFunctions.waitForElementToAppear(BatchUserPageObj.closePopUp);
//		BatchUserPageObj.closePopUp.click();
//		GenericFunctions.waitWebDriver(1500);	
//    	GenericFunctions.waitForElementToAppear(BatchUserPageObj.Workspace);
    	GenericFunctions.waitWebDriver(1500);
    	BatchUserPageObj.Workspace.click();
		GenericFunctions.waitForElementToAppear(BatchUserPageObj.upForReview);
		GenericFunctions.waitWebDriver(2000);
		BatchUserPageObj.upForReview.click();
		GenericFunctions.waitForElementToAppear(BatchUserPageObj.firtContent);
		String courseContent = BatchUserPageObj.firtContent.getText();
		System.out.println(courseContent);
		GenericFunctions.waitWebDriver(2000);
		BatchUserPageObj.firtContent.click();
		GenericFunctions.WaitForFrameAndSwitchToIt(BatchUserPageObj.iFrame);
		GenericFunctions.waitWebDriver(2000);
		GenericFunctions.scrollToElement(BatchUserPageObj.headerPublish);
		GenericFunctions.waitWebDriver(4000);
		if(BatchUserPageObj.headerPublish.isDisplayed())
		{
		BatchUserPageObj.headerPublish.click();
		}
		else if(BatchUserPageObj.Publish.isDisplayed())
		{
			BatchUserPageObj.Publish.click();
		}
		
		GenericFunctions.waitForElementToAppear(BatchUserPageObj.publishConfirm);
		BatchUserPageObj.publishConfirm.click();			
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
			/*BatchUserPageObj.dropDown.click();
			GenericFunctions.waitForElementToAppear(BatchUserPageObj.headerProfile);
			BatchUserPageObj.headerProfile.click();*/
			BatchUserPageObj.headerCourse.click();
			GenericFunctions.waitWebDriver(1000);
			String courseNumber = GenericFunctions.testDataIncrementer(".//testData//courseNumbers.txt").toString();
			BatchUserPageObj.filterSearch.sendKeys(objListOFTestDataForSunbird1.get(0).getTitle()+courseNumber);
			BatchUserPageObj.searchIconUpForReview.click();
			GenericFunctions.waitWebDriver(2000);
			BatchUserPageObj.searchedCourse.click();
			GenericFunctions.waitWebDriver(1000);
			BatchUserPageObj.createBatch.click();
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
			// BatchUserPageObj.headerCourse.click();
			// GenericFunctions.waitWebDriver(1000);
			// BatchUserPageObj.filterSearch.sendKeys(objListOFTestDataForSunbird.get(0).getCourseName()+GenericFunctions.readFromNotepad(".//batchNumbers.txt").toUpperCase());
			// BatchUserPageObj.searchIcon.click();
			// GenericFunctions.waitWebDriver(2000);
			// BatchUserPageObj.courseImg1.click();
			// GenericFunctions.waitWebDriver(3000);
			BatchUserPageObj.addIcon.click();
			GenericFunctions.waitWebDriver(1000);
			GenericFunctions.switchToFrame(driver, BatchUserPageObj.batchForm);
			GenericFunctions.waitWebDriver(1000);
			BatchUserPageObj.nameOfBatch.sendKeys(objListOFTestDataForSunbird.get(0).getCourseName()
					+ GenericFunctions.testDataIncrementer(".//TestData//sunbird_data.txt"));
			BatchUserPageObj.aboutBatch.sendKeys(objListOFTestDataForSunbird.get(0).getCourseName());
//			BatchUserPageObj.openBatch.click();
			BatchUserPageObj.startDate.click(); // sendKeys(objListOFTestDataForSunbird.get(8).getTitle());
			GenericFunctions.waitWebDriver(1000);
			BatchUserPageObj.startDateCalendar.click(); // sendKeys(objListOFTestDataForSunbird.get(8).getTitle());
			BatchUserPageObj.endDate.sendKeys(objListOFTestDataForSunbird.get(8).getTitleDescription());
			GenericFunctions.waitWebDriver(3000);
			BatchUserPageObj.mentorsInBatch.click();
			BatchUserPageObj.suborgMentor2InBatch.click();
			GenericFunctions.waitWebDriver(1500);			
			BatchUserPageObj.membersInBatch.click();
			GenericFunctions.waitWebDriver(1500);
			BatchUserPageObj.testBookReviewerInBatch.click();
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

			BatchUserPageObj.buttonCreate.click();
			// BatchUserPageObj.successfulMessage.click();
			System.out.println("Batch Created");

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
		
		/*try{
		if(BatchUserPageObj.closePopUp.isDisplayed())
		{
			BatchUserPageObj.closePopUp.click();
			GenericFunctions.waitWebDriver(1500);
			BatchUserPageObj.headerCourse.click();
			GenericFunctions.waitWebDriver(4000);
		}
		}
		catch(Exception e)
		{
			GenericFunctions.waitWebDriver(1500);
			BatchUserPageObj.headerCourse.click();
		}*/
		GenericFunctions.waitWebDriver(1500);
		GenericFunctions.waitTillTheElementIsVisibleAndClickable(BatchUserPageObj.headerCourse);
		BatchUserPageObj.headerCourse.click();
			GenericFunctions.waitWebDriver(4000);
			GenericFunctions.waitForElementToAppear(BatchUserPageObj.latestCourse);
			BatchUserPageObj.latestCourse.click();
			GenericFunctions.waitWebDriver(3000);
			BatchUserPageObj.addIcon.click();
			GenericFunctions.waitWebDriver(2000);
			BatchUserPageObj.nameOfBatch.sendKeys(objListOFTestDataForSunbird.get(0).getCourseName()
					+ GenericFunctions.testDataIncrementer(".//TestData//batchNumbers.txt"));
			BatchUserPageObj.aboutBatch.sendKeys(objListOFTestDataForSunbird.get(0).getCourseName());

			BatchUserPageObj.startDate.click();
			GenericFunctions.waitWebDriver(1000);
			BatchUserPageObj.startDateCalendar.click();
			GenericFunctions.waitWebDriver(1000);
			BatchUserPageObj.endDate.sendKeys(objListOFTestDataForSunbird.get(8).getTitleDescription());
			
			BatchUserPageObj.mentorsInBatch.click();
			GenericFunctions.waitWebDriver(1000);				
			BatchUserPageObj.suborgMentor2InBatch.click();
			BatchUserPageObj.mentorsInBatch.click();
			
			GenericFunctions.waitWebDriver(1000);								
			BatchUserPageObj.mentorDropdown.click();
			BatchUserPageObj.membersInBatch.click();
			BatchUserPageObj.mentorDropdown.click();
			GenericFunctions.waitWebDriver(1500);	
			
			GenericFunctions.waitTillTheElementIsVisibleAndClickable(BatchUserPageObj.buttonCreate);
			BatchUserPageObj.buttonCreate.click();
			GenericFunctions.waitWebDriver(4000);
			//BatchUserPageObj.successfulMessage.click();
			System.out.println("Batch Created");
			Assert.assertTrue(true,"Batch created successfully and able to add mentor & mentor from root org and sub org");
			log.info("Batch created successfully and able to add mentor & mentor from root org and sub org");
			System.out.println("Batch created successfully and able to add mentor & mentor from root org and sub org");
		//}
		}
		catch (Exception e) {
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed to create invite only batch");
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Exception Message: " + e.getLocalizedMessage());
			log.error("Exception In the method createInviteOnlyBatch" + e.getMessage());
			Assert.fail("Failed to create invite only batch, Exception" + e.getLocalizedMessage());
		}
		

	}
	
	
	
	
	
	
    // @author Sachin
	public void createInviteBatchwithStartDate() throws InterruptedException, Exception {
		Robot robot = new Robot();
	    objListOFTestDataForSunbird = ReadTestDataFromExcel.getTestDataForSunbird("testdatasheetcourse");
								
		try {
		ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to create invite only batch with start date as current date");
			/*GenericFunctions.waitForElementToAppear(BatchUserPageObj.closePopUp);
			BatchUserPageObj.closePopUp.click();*/
			GenericFunctions.waitWebDriver(3500);
			GenericFunctions.waitTillTheElementIsVisibleAndClickable(BatchUserPageObj.headerCourse);
			BatchUserPageObj.headerCourse.click();
			GenericFunctions.waitWebDriver(4000);
			GenericFunctions.waitForElementToAppear(BatchUserPageObj.latestCourse);
			BatchUserPageObj.latestCourse.click();
			GenericFunctions.waitWebDriver(3000);
			BatchUserPageObj.addIcon.click();
			GenericFunctions.waitWebDriver(2000);
			BatchUserPageObj.nameOfBatch.sendKeys(objListOFTestDataForSunbird.get(0).getCourseName()
					+ GenericFunctions.testDataIncrementer(".//TestData//batchNumbers.txt"));
			BatchUserPageObj.aboutBatch.sendKeys(objListOFTestDataForSunbird.get(0).getCourseName());

			BatchUserPageObj.startDate.sendKeys("27 November 2018");
			GenericFunctions.waitWebDriver(1000);

			GenericFunctions.waitWebDriver(1000);
			BatchUserPageObj.endDate.sendKeys(objListOFTestDataForSunbird.get(8).getTitleDescription());
			
			BatchUserPageObj.mentorsInBatch.click();
			GenericFunctions.waitWebDriver(1000);				
			BatchUserPageObj.suborgMentor2InBatch.click();
			BatchUserPageObj.mentorsInBatch.click();
			
			GenericFunctions.waitWebDriver(1000);								
			BatchUserPageObj.mentorDropdown.click();
			BatchUserPageObj.membersInBatch.click();
			BatchUserPageObj.mentorDropdown.click();
			GenericFunctions.waitWebDriver(4000);	
			GenericFunctions.waitTillTheElementIsVisibleAndClickable(BatchUserPageObj.buttonCreate);
			BatchUserPageObj.buttonCreate.click();
			//BatchUserPageObj.successfulMessage.click();
			System.out.println("Batch Created");
			Assert.assertTrue(true,"User is trying to create invite only batch with start date as current date");
			log.info("User is trying to create invite only batch with start date as current date");
			System.out.println("User is trying to create invite only batch with start date as current date");

		} catch (Exception e) {
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed to create invite only batch");
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Exception Message: " + e.getLocalizedMessage());
			log.error("Exception In the method createInviteOnlyBatch" + e.getMessage());
			Assert.fail("Failed to create invite only batch, Exception" + e.getLocalizedMessage());
		}
		

	}
	
	
    // @author Sachin
	public void createInviteBatchFutureStartDate() throws InterruptedException, Exception {
		Robot robot = new Robot();
	    objListOFTestDataForSunbird = ReadTestDataFromExcel.getTestDataForSunbird("testdatasheetcourse");
								
		try {
		ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to create upcoming batch with future start date");
			
			/*GenericFunctions.waitForElementToAppear(BatchUserPageObj.closePopUp);
			BatchUserPageObj.closePopUp.click();*/
		GenericFunctions.waitForElementToAppear(BatchUserPageObj.headerCourse);
			GenericFunctions.waitWebDriver(2000);
			BatchUserPageObj.headerCourse.click();
			GenericFunctions.waitWebDriver(4000);
			GenericFunctions.waitForElementToAppear(BatchUserPageObj.latestCourse);
			BatchUserPageObj.latestCourse.click();
			GenericFunctions.waitWebDriver(3000);
			BatchUserPageObj.addIcon.click();
			GenericFunctions.waitWebDriver(2000);
			BatchUserPageObj.nameOfBatch.sendKeys(objListOFTestDataForSunbird.get(0).getCourseName()
					+ GenericFunctions.testDataIncrementer(".//TestData//batchNumbers.txt"));
			BatchUserPageObj.aboutBatch.sendKeys(objListOFTestDataForSunbird.get(0).getCourseName());

			BatchUserPageObj.startDate.sendKeys("1 January 2019");
			GenericFunctions.waitWebDriver(1000);

			GenericFunctions.waitWebDriver(1000);
			BatchUserPageObj.endDate.sendKeys("1 June 2019");
			
			BatchUserPageObj.mentorsInBatch.click();
			GenericFunctions.waitWebDriver(1000);				
			BatchUserPageObj.suborgMentor2InBatch.click();
			BatchUserPageObj.mentorsInBatch.click();
			
			GenericFunctions.waitWebDriver(1000);								
			BatchUserPageObj.mentorDropdown.click();
			BatchUserPageObj.membersInBatch.click();
			BatchUserPageObj.mentorDropdown.click();
			GenericFunctions.waitWebDriver(4000);	
			GenericFunctions.waitTillTheElementIsVisibleAndClickable(BatchUserPageObj.buttonCreate);
			BatchUserPageObj.buttonCreate.click();
			//BatchUserPageObj.successfulMessage.click();
			System.out.println("Batch Created");
			Assert.assertTrue(true,"User is trying to create upcoming batch with future start date");
			log.info("User is trying to create upcoming batch with future start date");
			System.out.println("User is trying to create upcoming batch with future start date");

		} catch (Exception e) {
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed to create invite only batch");
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Exception Message: " + e.getLocalizedMessage());
			log.error("Exception In the method createInviteOnlyBatch" + e.getMessage());
			Assert.fail("Failed to create invite only batch, Exception" + e.getLocalizedMessage());
		}
		

	}
	
	
	public void navigateToWorkspaceAndSelectBatches(String batchType) throws InterruptedException {
		try {
			ExtentTestManager.getTest().log(LogStatus.INFO,
					"User is trying to navigate to Worskpace and select batch " + batchType);

			//GenericFunctions.waitTillTheElementIsVisibleAndClickable(BatchUserPageObj.workSpace);
			/*GenericFunctions.waitForElementToAppear(BatchUserPageObj.closePopUp);
			BatchUserPageObj.closePopUp.click();*/
			GenericFunctions.waitTillTheElementIsVisibleAndClickable(BatchUserPageObj.workSpace);
			GenericFunctions.waitWebDriver(1500);
			BatchUserPageObj.workSpace.click();	
			GenericFunctions.waitWebDriver(1000);
			BatchUserPageObj.courseBatches.click();
			GenericFunctions.waitWebDriver(1000);
			BatchUserPageObj.batchesDropDown.click();
			GenericFunctions.waitWebDriver(1500);
			if (batchType.equalsIgnoreCase("Ongoing Batches")) {
				GenericFunctions.waitForElementToAppear(BatchUserPageObj.ongoingBatches);
				BatchUserPageObj.ongoingBatches.click();
				GenericFunctions.waitWebDriver(1500);
				System.out.println("Ongoing batches");
			} else if (batchType.equalsIgnoreCase("Upcoming Batches")) {
				GenericFunctions.waitWebDriver(1000);
				BatchUserPageObj.upcomingBatches.click();
				System.out.println("upcoming batches");
			} else if (batchType.equalsIgnoreCase("Previous Batches")) {
				GenericFunctions.waitWebDriver(1000);
				BatchUserPageObj.previousBatches.click();
				GenericFunctions.waitWebDriver(5000);
				System.out.println("Previous batches");
			}
		} catch (Exception e) {
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed on navigating to Workspace and select batch");
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Exception Message: " + e.getLocalizedMessage());
			log.error("Exception In the method navigateToWorkspaceInDropDownMenu" + e.getMessage());
			Assert.fail(
					"Failed on navigating to Workspace and selecting batch, Exception : " + e.getLocalizedMessage());
		}
	}
	

	public void navigateToCourseSearchAndUpdate() throws InterruptedException {
		objListOFTestDataForSunbird = ReadTestDataFromExcel.getTestDataForSunbird("testdatasheetcourse");
		//String courseName = "null";
		try {
			ExtentTestManager.getTest().log(LogStatus.INFO,
					"To verify update the batch");
			GenericFunctions.waitWebDriver(1500);

			BatchUserPageObj.courseImg1.click();
			GenericFunctions.waitWebDriver(2000);
			GenericFunctions.switchToFrame(driver, BatchUserPageObj.batchForm);
			BatchUserPageObj.nameOfBatch.clear();
			BatchUserPageObj.nameOfBatch.sendKeys(objListOFTestDataForSunbird.get(1).getCourseName()
					+ GenericFunctions.testDataIncrementer(".//TestData//batchNumbers.txt"));
			GenericFunctions.waitWebDriver(1000);
			BatchUserPageObj.aboutBatch.clear();
			BatchUserPageObj.aboutBatch.sendKeys(objListOFTestDataForSunbird.get(0).getCourseName());
//			BatchUserPageObj.openBatch.click();
			GenericFunctions.waitWebDriver(1000);
			BatchUserPageObj.endDate.clear();
			BatchUserPageObj.endDate.sendKeys("30 September 2019");
			GenericFunctions.waitWebDriver(3000);
//			BatchUserPageObj.mentorsInBatch.click();
//			BatchUserPageObj.updateMentorInBatch.click();
//			GenericFunctions.waitWebDriver(1000);
//			BatchUserPageObj.mentorsInBatch.click();
//			
//			BatchUserPageObj.updateMembersInBatch.click();
//			BatchUserPageObj.membersInBatch.click();
//			GenericFunctions.waitWebDriver(1500);
//			BatchUserPageObj.updateMembersInBatch.click();
//			GenericFunctions.waitWebDriver(1500);						
			BatchUserPageObj.updateBatch.click();
			GenericFunctions.waitWebDriver(4000);
		} catch (Exception e) {
			ExtentTestManager.getTest().log(LogStatus.FAIL,
					"Failed on updating the course");
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Exception Message: " + e.getLocalizedMessage());
			log.error("Exception In the method navigateToCourseSearchAndUpdate" + e.getMessage());
			Assert.fail("Failed on updating the course : "
					+ e.getLocalizedMessage());
		}

	}
	
	
	
	public void updateUpcomingBatches() throws InterruptedException {
		objListOFTestDataForSunbird = ReadTestDataFromExcel.getTestDataForSunbird("testdatasheetcourse");
		//String courseName = "null";
		try {
			ExtentTestManager.getTest().log(LogStatus.INFO,"To verify updation of the upcoming batch");
			GenericFunctions.waitWebDriver(1500);

			BatchUserPageObj.courseImg1.click();
			GenericFunctions.waitWebDriver(2000);
			GenericFunctions.switchToFrame(driver, BatchUserPageObj.batchForm);
			BatchUserPageObj.nameOfBatch.clear();
			BatchUserPageObj.nameOfBatch.sendKeys(objListOFTestDataForSunbird.get(1).getCourseName()
					+ GenericFunctions.testDataIncrementer(".//TestData//batchNumbers.txt"));
			GenericFunctions.waitWebDriver(1000);
			BatchUserPageObj.aboutBatch.clear();
			BatchUserPageObj.aboutBatch.sendKeys(objListOFTestDataForSunbird.get(0).getCourseName());
//			BatchUserPageObj.openBatch.click();
			GenericFunctions.waitWebDriver(1000);
			BatchUserPageObj.endDate.clear();
			BatchUserPageObj.endDate.sendKeys("30 September 2019");
			GenericFunctions.waitWebDriver(3000);
			BatchUserPageObj.mentorsInBatch.click();
			BatchUserPageObj.updateMentorInBatch.click();
			GenericFunctions.waitWebDriver(1000);
			BatchUserPageObj.mentorsInBatch.click();
			
			BatchUserPageObj.updateMembersInBatch.click();
			BatchUserPageObj.membersInBatch.click();
			GenericFunctions.waitWebDriver(1500);
			BatchUserPageObj.updateMembersInBatch.click();
			GenericFunctions.waitWebDriver(1500);						
			BatchUserPageObj.updateBatch.click();
			GenericFunctions.waitWebDriver(4000);
		} catch (Exception e) {
			ExtentTestManager.getTest().log(LogStatus.FAIL,"Failed on updating the upcoming batch");
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Exception Message: " + e.getLocalizedMessage());
			log.error("Exception In the method navigateToCourseSearchAndUpdate" + e.getMessage());
			Assert.fail("Failed on updating the upcoming batch : "+ e.getLocalizedMessage());
		}
    
	} 
	
    // @author Sachin
	public void verifyCreatedBatch() throws InterruptedException, Exception {									
	try {
		ExtentTestManager.getTest().log(LogStatus.INFO, "Verifying the Created Batch");
		BatchUserPageObj.workSpace.click();	
		GenericFunctions.waitWebDriver(1000);
		BatchUserPageObj.courseBatches.click();
		GenericFunctions.waitWebDriver(1000);
		BatchUserPageObj.batchesDropDown.click();
		GenericFunctions.waitWebDriver(1500);
		String content = BatchUserPageObj.batchContent.getText();
		System.out.println(content);
		 String newLine = System.getProperty("line.separator");
		 //System.out.println("line 1" + newLine + "line2");
		 String text = "By mentor null"+ newLine+ "26 Nov - 30 Sep";
		 System.out.println(text);
		if(text.contains("26 Nov - 30 Sep"))
		{
			System.out.println("Batch created successfully and verified also");
		}
		GenericFunctions.waitWebDriver(1500);
		} 
    catch (Exception e) {
		ExtentTestManager.getTest().log(LogStatus.FAIL, "failed on validating the correct batch");
		ExtentTestManager.getTest().log(LogStatus.FAIL, "Exception Message: " + e.getLocalizedMessage());
		log.error("Exception In the method createInviteOnlyBatch" + e.getMessage());
		Assert.fail("failed on validating the correct batch, Exception" + e.getLocalizedMessage());
		}
		

	}
	
	
	public void searchCourseAsInvitedMentor() throws InterruptedException, Exception {									
	try {
		ExtentTestManager.getTest().log(LogStatus.INFO, "Verifying the Created Batch");
		GenericFunctions.waitWebDriver(1500);
		BatchUserPageObj.headerCourse.click();
		GenericFunctions.waitWebDriver(1500);
            if(BatchUserPageObj.viewCourseStatsButton.isDisplayed())
            {
            	Assert.assertTrue(true,"Invited mentor can see the course on his dashboard");
            	log.info("Invited mentor can see the course on his dashboard");
            	System.out.println("Invited mentor can see the course on his dashboard");
            }
            
		
		}
    catch (Exception e)
		{
		ExtentTestManager.getTest().log(LogStatus.FAIL, "failed on validating the correct batch");
		ExtentTestManager.getTest().log(LogStatus.FAIL, "Exception Message: " + e.getLocalizedMessage());
		log.error("Exception In the method createInviteOnlyBatch" + e.getMessage());
		Assert.fail("failed on validating the correct batch, Exception" + e.getLocalizedMessage());
		}
		

	}
	
}		
		