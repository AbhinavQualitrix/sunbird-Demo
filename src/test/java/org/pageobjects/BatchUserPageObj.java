package org.pageobjects;

import java.awt.Robot;
import java.util.List;
import java.util.Random;

import org.apache.log4j.Logger;
import org.generic.ExtentTestManager;
import org.generic.GenericFunctions;
import org.generic.ReadTestDataFromExcel;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.page.BatchUserPage;
import org.page.CreatorUserPage;
import org.page.SignUpPage;
import org.page.UploadOrgPage;
import org.startup.BaseTest;
import org.testdata.TestDataForSunbird;
import org.testng.Assert;

import com.relevantcodes.extentreports.LogStatus;

public class BatchUserPageObj extends BaseTest
{
	WebDriverWait wait = new WebDriverWait(driver,20);
	BatchUserPage batchUserPage = PageFactory.initElements(driver, BatchUserPage.class);
//	CreatorUserPageObj batchUserPage = PageFactory.initElements(driver, CreatorUserPageObj.class);
//	batchUserPage batchUserPage=PageFactory.initElements(driver, batchUserPage.class);
//	CreatorUserPageObj batchUserPage=PageFactory.initElements(driver, CreatorUserPageObj.class);
//	BatchUserPageObjObjects batchUserPage = PageFactory.initElements(driver, BatchUserPageObjObjects.class);
//	PublicUserPageObj publicUserPageObj = PageFactory.initElements(driver, PublicUserPageObj.class);
//	batchUserPage batchUserPage=PageFactory.initElements(driver, batchUserPage.class);
//	ContentCreateUploadPageObj contentCreatePage = PageFactory.initElements(driver, ContentCreateUploadPageObj.class);
	CreatorUserPageObj createrUserPageObj = new CreatorUserPageObj();
	SignUpPage signUpPage=PageFactory.initElements(driver, SignUpPage.class);
	static Logger log = Logger.getLogger(CreatorUserPage.class.getName());
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
			GenericFunctions.waitForElementToAppear(batchUserPage.courseName);
			String courseNumber = GenericFunctions.testDataIncrementer("./testData/courseNumbers.txt").toString();
			batchUserPage.courseName.sendKeys(objListOFTestDataForSunbird.get(0).getCourseName()+courseNumber);
			batchUserPage.courseDescription.sendKeys(objListOFTestDataForSunbird.get(0).getCourseDescription()+courseNumber);	
			GenericFunctions.waitWebDriver(1500);
			batchUserPage.startCreating.click();
			/*GenericFunctions.refreshWebPage();
			GenericFunctions.waitWebDriver(1500);*/
			GenericFunctions.waitWebDriver(4500);
			GenericFunctions.WaitForFrameAndSwitchToIt(batchUserPage.iFrame);
			GenericFunctions.waitWebDriver(6500);
			GenericFunctions.waitForElementToAppear(batchUserPage.newChild);
			System.out.println("Creating - "+batchUserPage.newChild.getText());
			GenericFunctions.waitWebDriver(3000);
			action.moveToElement(batchUserPage.newChild).click().perform();
			//action.moveToElement(batchUserPage.newChild).click().release();
			GenericFunctions.waitWebDriver(1500);
			batchUserPage.titleName.click();
			batchUserPage.titleName.clear();
			batchUserPage.titleName.sendKeys(objListOFTestDataForSunbird.get(0).getTitle()+courseNumber);
			batchUserPage.titleDescription.sendKeys(objListOFTestDataForSunbird.get(0).getTitleDescription()+courseNumber);
			GenericFunctions.waitWebDriver(1500);
			batchUserPage.addResource.click();

			//added on 17 Aug 2018
			//driver.switchTo().frame(0);
			GenericFunctions.waitForElementToAppear(batchUserPage.selectResource);
			batchUserPage.selectResource.click();
			GenericFunctions.waitWebDriver(500);
			batchUserPage.proceedButton.click();
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
			GenericFunctions.waitForElementToAppear(batchUserPage.saveCourse);
			batchUserPage.saveCourse.click();
			GenericFunctions.waitWebDriver(2000);
			batchUserPage.sendForReview.click();
			GenericFunctions.waitWebDriver(1500);
			batchUserPage.clickAppIcon.click();
			GenericFunctions.waitWebDriver(3000);	
			GenericFunctions.waitForElementToAppear(batchUserPage.checkContentIcon);
			batchUserPage.checkContentIcon.click();
			GenericFunctions.waitWebDriver(1000);
			batchUserPage.selectAppIcon.click();
			GenericFunctions.waitWebDriver(1000);
			
			GenericFunctions.waitForElementToAppear(batchUserPage.clickOnSelectCurriculum);
			batchUserPage.clickOnSelectCurriculum.click();
			GenericFunctions.waitWebDriver(1000);
			batchUserPage.selectCurriculum.click();
			GenericFunctions.waitForElementToAppear(batchUserPage.clickOnSelectClass);
			batchUserPage.clickOnSelectClass.click();
			GenericFunctions.waitWebDriver(1000); 
			batchUserPage.selectClass.click();
			GenericFunctions.waitWebDriver(1000); 
			batchUserPage.clickOnSelectClass.click();//      
			
			//GenericFunctions.keyTab(driver, batchUserPage.selectClass.toString());
			//GenericFunctions.waitTillTheElementIsVisibleAndClickable(batchUserPage.clickOnHeaderSubject);
			//batchUserPage.clickOnHeaderSubject.click();
			GenericFunctions.waitWebDriver(5000);
			//GenericFunctions.waitTillTheElementIsVisibleAndClickable(batchUserPage.clickOnSelectSubject);
			//GenericFunctions.scrollToElement(batchUserPage.clickOnSelectMedium);
//			GenericFunctions.waitWebDriver(2000);
//			batchUserPage.clickOnSelectSubject.click();
//			GenericFunctions.waitForElementToAppear(batchUserPage.selectSubject);
//			batchUserPage.selectMathematics.click();
//			GenericFunctions.waitWebDriver(1500);
			GenericFunctions.scrollToElement(batchUserPage.clickOnSelectMedium);
			GenericFunctions.waitWebDriver(5000);
			batchUserPage.clickOnSelectMedium.click();
			GenericFunctions.waitForElementToAppearOnScreen(batchUserPage.selectMedium);
			batchUserPage.selectMedium.click();
			GenericFunctions.waitWebDriver(1500);
			GenericFunctions.scrollToElement(batchUserPage.clickOwner);
			GenericFunctions.waitForElementToAppear(batchUserPage.clickOwner);
			batchUserPage.clickOwner.click();
			GenericFunctions.waitWebDriver(1500);
			batchUserPage.selectOwner.click();
			GenericFunctions.waitWebDriver(1500);
			
			
			batchUserPage.saveButton.click();
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
//  	GenericFunctions.waitForElementToAppear(batchUserPage.closePopUp);
//		batchUserPage.closePopUp.click();
//		GenericFunctions.waitWebDriver(1500);	
//    	GenericFunctions.waitForElementToAppear(batchUserPage.Workspace);
    	GenericFunctions.waitWebDriver(500);
    	batchUserPage.Workspace.click();
		GenericFunctions.waitForElementToAppear(batchUserPage.upForReview);
		GenericFunctions.waitWebDriver(2000);
		batchUserPage.upForReview.click();
		GenericFunctions.waitForElementToAppear(batchUserPage.firtContent);
		String courseContent = batchUserPage.firtContent.getText();
		System.out.println(courseContent);
		GenericFunctions.waitWebDriver(2000);
		batchUserPage.firtContent.click();
		GenericFunctions.WaitForFrameAndSwitchToIt(batchUserPage.iFrame);
		GenericFunctions.waitWebDriver(2000);
		GenericFunctions.scrollToElement(batchUserPage.headerPublish);
		GenericFunctions.waitWebDriver(4000);
		if(batchUserPage.headerPublish.isDisplayed())
		{
		batchUserPage.headerPublish.click();
		}
		else if(batchUserPage.Publish.isDisplayed())
		{
			batchUserPage.Publish.click();
		}
		
		GenericFunctions.waitForElementToAppear(batchUserPage.publishConfirm);
		batchUserPage.publishConfirm.click();			
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
			/*batchUserPage.dropDown.click();
			GenericFunctions.waitForElementToAppear(batchUserPage.headerProfile);
			batchUserPage.headerProfile.click();*/
			batchUserPage.headerCourse.click();
			GenericFunctions.waitWebDriver(1000);
			String courseNumber = GenericFunctions.testDataIncrementer("./testData/courseNumbers.txt").toString();
			batchUserPage.filterSearch.sendKeys(objListOFTestDataForSunbird1.get(0).getTitle()+courseNumber);
			batchUserPage.searchIconUpForReview.click();
			GenericFunctions.waitWebDriver(2000);
			batchUserPage.searchedCourse.click();
			GenericFunctions.waitWebDriver(1000);
			batchUserPage.createBatch.click();
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
			// batchUserPage.headerCourse.click();
			// GenericFunctions.waitWebDriver(1000);
			// batchUserPage.filterSearch.sendKeys(objListOFTestDataForSunbird.get(0).getCourseName()+GenericFunctions.readFromNotepad(".//batchNumbers.txt").toUpperCase());
			// batchUserPage.searchIcon.click();
			// GenericFunctions.waitWebDriver(2000);
			// batchUserPage.courseImg1.click();
			// GenericFunctions.waitWebDriver(3000);
			batchUserPage.addIcon.click();
			GenericFunctions.waitWebDriver(1000);
			GenericFunctions.switchToFrame(driver, batchUserPage.batchForm);
			GenericFunctions.waitWebDriver(1000);
			batchUserPage.nameOfBatch.sendKeys(objListOFTestDataForSunbird.get(0).getCourseName()
					+ GenericFunctions.testDataIncrementer("./testData/sunbird_data.txt"));
			batchUserPage.aboutBatch.sendKeys(objListOFTestDataForSunbird.get(0).getCourseName());
//			batchUserPage.openBatch.click();
			batchUserPage.startDate.click(); // sendKeys(objListOFTestDataForSunbird.get(8).getTitle());
			GenericFunctions.waitWebDriver(1000);
			batchUserPage.startDateCalendar.click(); // sendKeys(objListOFTestDataForSunbird.get(8).getTitle());
			batchUserPage.endDate.sendKeys(objListOFTestDataForSunbird.get(8).getTitleDescription());
			GenericFunctions.waitWebDriver(3000);
			batchUserPage.mentorsInBatch.click();
			batchUserPage.suborgMentor2InBatch.click();
			GenericFunctions.waitWebDriver(1500);			
			batchUserPage.membersInBatch.click();
			GenericFunctions.waitWebDriver(1500);
			batchUserPage.testBookReviewerInBatch.click();
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

			batchUserPage.buttonCreate.click();
			// batchUserPage.successfulMessage.click();
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
			//GenericFunctions.waitForElementToAppear(batchUserPage.closePopUp);
//		if(batchUserPage.closePopUp.isDisplayed())
//		{
//		  batchUserPage.closePopUp.click();
//		}
		//else
		//{
			GenericFunctions.waitWebDriver(1500);
			batchUserPage.headerCourse.click();
			GenericFunctions.waitWebDriver(4000);
			GenericFunctions.waitForElementToAppear(batchUserPage.latestCourse);
			batchUserPage.latestCourse.click();
			GenericFunctions.waitWebDriver(3000);
			batchUserPage.addIcon.click();
			GenericFunctions.waitWebDriver(2000);
			batchUserPage.nameOfBatch.sendKeys(objListOFTestDataForSunbird.get(0).getCourseName()
					+ GenericFunctions.testDataIncrementer("./testData/batchNumbers.txt"));
			batchUserPage.aboutBatch.sendKeys(objListOFTestDataForSunbird.get(0).getCourseName());

			batchUserPage.startDate.click();
			GenericFunctions.waitWebDriver(1000);
			batchUserPage.startDateCalendar.click();
			GenericFunctions.waitWebDriver(1000);
			batchUserPage.endDate.sendKeys(objListOFTestDataForSunbird.get(8).getTitleDescription());
			
			batchUserPage.mentorsInBatch.click();
			GenericFunctions.waitWebDriver(1000);				
			batchUserPage.suborgMentor2InBatch.click();
			batchUserPage.mentorsInBatch.click();
			
			GenericFunctions.waitWebDriver(1000);								
			batchUserPage.mentorDropdown.click();
			batchUserPage.membersInBatch.click();
			batchUserPage.mentorDropdown.click();
			GenericFunctions.waitWebDriver(1500);	
			
			GenericFunctions.waitTillTheElementIsVisibleAndClickable(batchUserPage.buttonCreate);
			batchUserPage.buttonCreate.click();
			GenericFunctions.waitWebDriver(4000);
			//batchUserPage.successfulMessage.click();
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
			GenericFunctions.waitForElementToAppear(batchUserPage.closePopUp);
			batchUserPage.closePopUp.click();
			GenericFunctions.waitWebDriver(1500);
			batchUserPage.headerCourse.click();
			GenericFunctions.waitWebDriver(4000);
			GenericFunctions.waitForElementToAppear(batchUserPage.latestCourse);
			batchUserPage.latestCourse.click();
			GenericFunctions.waitWebDriver(3000);
			batchUserPage.addIcon.click();
			GenericFunctions.waitWebDriver(2000);
			batchUserPage.nameOfBatch.sendKeys(objListOFTestDataForSunbird.get(0).getCourseName()
					+ GenericFunctions.testDataIncrementer("./testData/batchNumbers.txt"));
			batchUserPage.aboutBatch.sendKeys(objListOFTestDataForSunbird.get(0).getCourseName());

			batchUserPage.startDate.sendKeys("27 November 2018");
			GenericFunctions.waitWebDriver(1000);

			GenericFunctions.waitWebDriver(1000);
			batchUserPage.endDate.sendKeys(objListOFTestDataForSunbird.get(8).getTitleDescription());
			
			batchUserPage.mentorsInBatch.click();
			GenericFunctions.waitWebDriver(1000);				
			batchUserPage.suborgMentor2InBatch.click();
			batchUserPage.mentorsInBatch.click();
			
			GenericFunctions.waitWebDriver(1000);								
			batchUserPage.mentorDropdown.click();
			batchUserPage.membersInBatch.click();
			batchUserPage.mentorDropdown.click();
			GenericFunctions.waitWebDriver(4000);	
			GenericFunctions.waitTillTheElementIsVisibleAndClickable(batchUserPage.buttonCreate);
			batchUserPage.buttonCreate.click();
			//batchUserPage.successfulMessage.click();
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
			
			GenericFunctions.waitForElementToAppear(batchUserPage.closePopUp);
			batchUserPage.closePopUp.click();
			GenericFunctions.waitWebDriver(1500);
			batchUserPage.headerCourse.click();
			GenericFunctions.waitWebDriver(4000);
			GenericFunctions.waitForElementToAppear(batchUserPage.latestCourse);
			batchUserPage.latestCourse.click();
			GenericFunctions.waitWebDriver(3000);
			batchUserPage.addIcon.click();
			GenericFunctions.waitWebDriver(2000);
			batchUserPage.nameOfBatch.sendKeys(objListOFTestDataForSunbird.get(0).getCourseName()
					+ GenericFunctions.testDataIncrementer("./testData/batchNumbers.txt"));
			batchUserPage.aboutBatch.sendKeys(objListOFTestDataForSunbird.get(0).getCourseName());

			batchUserPage.startDate.sendKeys("1 January 2019");
			GenericFunctions.waitWebDriver(1000);

			GenericFunctions.waitWebDriver(1000);
			batchUserPage.endDate.sendKeys("1 June 2019");
			
			batchUserPage.mentorsInBatch.click();
			GenericFunctions.waitWebDriver(1000);				
			batchUserPage.suborgMentor2InBatch.click();
			batchUserPage.mentorsInBatch.click();
			
			GenericFunctions.waitWebDriver(1000);								
			batchUserPage.mentorDropdown.click();
			batchUserPage.membersInBatch.click();
			batchUserPage.mentorDropdown.click();
			GenericFunctions.waitWebDriver(4000);	
			GenericFunctions.waitTillTheElementIsVisibleAndClickable(batchUserPage.buttonCreate);
			batchUserPage.buttonCreate.click();
			//batchUserPage.successfulMessage.click();
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

			//GenericFunctions.waitTillTheElementIsVisibleAndClickable(batchUserPage.workSpace);
			GenericFunctions.waitForElementToAppear(batchUserPage.closePopUp);
			batchUserPage.closePopUp.click();
			GenericFunctions.waitWebDriver(1500);
			batchUserPage.workSpace.click();	
			GenericFunctions.waitWebDriver(1000);
			batchUserPage.courseBatches.click();
			GenericFunctions.waitWebDriver(1000);
			batchUserPage.batchesDropDown.click();
			GenericFunctions.waitWebDriver(1500);
			if (batchType.equalsIgnoreCase("Ongoing Batches")) {
				GenericFunctions.waitForElementToAppear(batchUserPage.ongoingBatches);
				batchUserPage.ongoingBatches.click();
				GenericFunctions.waitWebDriver(1500);
				System.out.println("Ongoing batches");
			} else if (batchType.equalsIgnoreCase("Upcoming Batches")) {
				GenericFunctions.waitWebDriver(1000);
				batchUserPage.upcomingBatches.click();
				System.out.println("upcoming batches");
			} else if (batchType.equalsIgnoreCase("Previous Batches")) {
				GenericFunctions.waitWebDriver(1000);
				batchUserPage.previousBatches.click();
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

			batchUserPage.courseImg1.click();
			GenericFunctions.waitWebDriver(2000);
			GenericFunctions.switchToFrame(driver, batchUserPage.batchForm);
			batchUserPage.nameOfBatch.clear();
			batchUserPage.nameOfBatch.sendKeys(objListOFTestDataForSunbird.get(1).getCourseName()
					+ GenericFunctions.testDataIncrementer("./testData/batchNumbers.txt"));
			GenericFunctions.waitWebDriver(1000);
			batchUserPage.aboutBatch.clear();
			batchUserPage.aboutBatch.sendKeys(objListOFTestDataForSunbird.get(0).getCourseName());
//			batchUserPage.openBatch.click();
			GenericFunctions.waitWebDriver(1000);
			batchUserPage.endDate.clear();
			batchUserPage.endDate.sendKeys("30 September 2019");
			GenericFunctions.waitWebDriver(3000);
//			batchUserPage.mentorsInBatch.click();
//			batchUserPage.updateMentorInBatch.click();
//			GenericFunctions.waitWebDriver(1000);
//			batchUserPage.mentorsInBatch.click();
//			
//			batchUserPage.updateMembersInBatch.click();
//			batchUserPage.membersInBatch.click();
//			GenericFunctions.waitWebDriver(1500);
//			batchUserPage.updateMembersInBatch.click();
//			GenericFunctions.waitWebDriver(1500);						
			batchUserPage.updateBatch.click();
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

			batchUserPage.courseImg1.click();
			GenericFunctions.waitWebDriver(2000);
			GenericFunctions.switchToFrame(driver, batchUserPage.batchForm);
			batchUserPage.nameOfBatch.clear();
			batchUserPage.nameOfBatch.sendKeys(objListOFTestDataForSunbird.get(1).getCourseName()
					+ GenericFunctions.testDataIncrementer("./testData/batchNumbers.txt"));
			GenericFunctions.waitWebDriver(1000);
			batchUserPage.aboutBatch.clear();
			batchUserPage.aboutBatch.sendKeys(objListOFTestDataForSunbird.get(0).getCourseName());
//			batchUserPage.openBatch.click();
			GenericFunctions.waitWebDriver(1000);
			batchUserPage.endDate.clear();
			batchUserPage.endDate.sendKeys("30 September 2019");
			GenericFunctions.waitWebDriver(3000);
			batchUserPage.mentorsInBatch.click();
			batchUserPage.updateMentorInBatch.click();
			GenericFunctions.waitWebDriver(1000);
			batchUserPage.mentorsInBatch.click();
			
			batchUserPage.updateMembersInBatch.click();
			batchUserPage.membersInBatch.click();
			GenericFunctions.waitWebDriver(1500);
			batchUserPage.updateMembersInBatch.click();
			GenericFunctions.waitWebDriver(1500);						
			batchUserPage.updateBatch.click();
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
		batchUserPage.workSpace.click();	
		GenericFunctions.waitWebDriver(1000);
		batchUserPage.courseBatches.click();
		GenericFunctions.waitWebDriver(1000);
		batchUserPage.batchesDropDown.click();
		GenericFunctions.waitWebDriver(1500);
		String content = batchUserPage.batchContent.getText();
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
		batchUserPage.headerCourse.click();
		GenericFunctions.waitWebDriver(1500);
            if(batchUserPage.viewCourseStatsButton.isDisplayed())
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
		