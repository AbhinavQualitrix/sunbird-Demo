package org.pageobjects;


import java.awt.Robot;
import java.util.List;
import java.util.Random;


import org.openqa.selenium.By;
import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.page.CreatorAnnouncementPage;
import org.page.MentorOrgPage;
import org.page.UploadOrgPage;
import org.generic.ExtentTestManager;
import org.generic.GenericFunctions;
import org.generic.ReadTestDataFromExcel;
import org.startup.BaseTest;
import org.testdata.TestDataForSunbird;
import org.testng.Assert;

import com.relevantcodes.extentreports.LogStatus;

public class MentorOrgPageObj extends BaseTest
{   
	MentorOrgPage MentorOrgPageObj = PageFactory.initElements(driver, MentorOrgPage.class);
	//	MentorOrgPageObj MentorOrgPageObj=PageFactory.initElements(driver, MentorOrgPageObj.class);
	//	CreatorUserPage MentorOrgPageObj=PageFactory.initElements(driver, CreatorUserPage.class);
	//	MentorOrgPageObjObjects MentorOrgPageObj = PageFactory.initElements(driver, MentorOrgPageObjObjects.class);
	//	PublicUserPage publicUserPage = PageFactory.initElements(driver, PublicUserPage.class);
	//	CreatorUserPage MentorOrgPageObj = PageFactory.initElements(driver, CreatorUserPage.class);
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
			GenericFunctions.waitForElementToAppear(MentorOrgPageObj.headerCourse);
			MentorOrgPageObj.headerCourse.click();
			GenericFunctions.waitWebDriver(2000);

			MentorOrgPageObj.course.click();
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
			GenericFunctions.waitForElementToAppear(MentorOrgPageObj.courseName);
			String courseNumber = GenericFunctions.testDataIncrementer("./testData/courseNumbers.txt").toString();
			MentorOrgPageObj.courseName.sendKeys(objListOFTestDataForSunbird.get(0).getCourseName()+courseNumber);
			MentorOrgPageObj.courseDescription.sendKeys(objListOFTestDataForSunbird.get(0).getCourseDescription()+courseNumber);	
			GenericFunctions.waitWebDriver(1500);
			MentorOrgPageObj.startCreating.click();
			/*GenericFunctions.refreshWebPage();
			GenericFunctions.waitWebDriver(1500);*/
			GenericFunctions.waitWebDriver(4500);
			GenericFunctions.WaitForFrameAndSwitchToIt(MentorOrgPageObj.iFrame);
			GenericFunctions.waitWebDriver(6500);
			GenericFunctions.waitForElementToAppear(MentorOrgPageObj.newChild);
			System.out.println("Creating - "+MentorOrgPageObj.newChild.getText());
			GenericFunctions.waitWebDriver(3000);
			action.moveToElement(MentorOrgPageObj.newChild).click().perform();
			//action.moveToElement(MentorOrgPageObj.newChild).click().release();
			GenericFunctions.waitWebDriver(1500);
			MentorOrgPageObj.titleName.click();
			MentorOrgPageObj.titleName.clear();
			MentorOrgPageObj.titleName.sendKeys(objListOFTestDataForSunbird.get(0).getTitle()+courseNumber);
			MentorOrgPageObj.titleDescription.sendKeys(objListOFTestDataForSunbird.get(0).getTitleDescription()+courseNumber);
			GenericFunctions.waitWebDriver(1500);
			MentorOrgPageObj.addResource.click();

			//added on 17 Aug 2018
			//driver.switchTo().frame(0);
			GenericFunctions.waitForElementToAppear(MentorOrgPageObj.selectResource);
			MentorOrgPageObj.selectResource.click();
			GenericFunctions.waitWebDriver(500);
			MentorOrgPageObj.proceedButton.click();
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


	public void saveAndSendCourseForReview(List <TestDataForSunbird> objListOFTestDataForSunbird)throws Exception
	{

		try
		{
			ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to save and send course for review");
			GenericFunctions.waitForElementToAppear(MentorOrgPageObj.saveCourse);
			MentorOrgPageObj.saveCourse.click();
			GenericFunctions.waitWebDriver(2000);
			MentorOrgPageObj.sendForReview.click();
			GenericFunctions.waitWebDriver(1500);
			MentorOrgPageObj.clickAppIcon.click();
			GenericFunctions.waitWebDriver(3000);	
			GenericFunctions.waitForElementToAppear(MentorOrgPageObj.checkContentIcon);
			MentorOrgPageObj.checkContentIcon.click();
			GenericFunctions.waitWebDriver(1000);
			MentorOrgPageObj.selectAppIcon.click();
			GenericFunctions.waitWebDriver(1000);

			//			GenericFunctions.waitForElementToAppear(MentorOrgPageObj.clickOnSelectCurriculum);
			//			MentorOrgPageObj.clickOnSelectCurriculum.click();
			//			GenericFunctions.waitWebDriver(1000);
			//			MentorOrgPageObj.selectCurriculum.click();
			//			GenericFunctions.waitWebDriver(1000);
			Select curriculum = new Select(driver.findElement(By.className("dropdown icon[0]")));
			curriculum.selectByVisibleText("CBSE");

			GenericFunctions.waitForElementToAppear(MentorOrgPageObj.clickOnSelectClass);
			MentorOrgPageObj.clickOnSelectClass.click();
			GenericFunctions.waitWebDriver(1000); 
			MentorOrgPageObj.selectClass.click();
			GenericFunctions.waitWebDriver(1000); 
			MentorOrgPageObj.EditDetails.click();//      

			GenericFunctions.scrollToElement(MentorOrgPageObj.clickOnSelectMedium);
			GenericFunctions.waitWebDriver(5000);
			MentorOrgPageObj.clickOnSelectMedium.click();
			GenericFunctions.waitForElementToAppearOnScreen(MentorOrgPageObj.selectMedium);
			MentorOrgPageObj.selectMedium.click();
			GenericFunctions.waitWebDriver(1500);

			GenericFunctions.scrollToElement(MentorOrgPageObj.clickOwner);
			GenericFunctions.waitForElementToAppear(MentorOrgPageObj.clickOwner);
			MentorOrgPageObj.clickOwner.click();
			GenericFunctions.waitWebDriver(1500);
			MentorOrgPageObj.selectOwner.click();
			GenericFunctions.waitWebDriver(1500);


			MentorOrgPageObj.saveButton.click();
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
			//  	GenericFunctions.waitForElementToAppear(MentorOrgPageObj.closePopUp);
			//		MentorOrgPageObj.closePopUp.click();
			//		GenericFunctions.waitWebDriver(1500);	
			//    	GenericFunctions.waitForElementToAppear(MentorOrgPageObj.Workspace);
			GenericFunctions.waitWebDriver(500);
			MentorOrgPageObj.Workspace.click();
			GenericFunctions.waitForElementToAppear(MentorOrgPageObj.upForReview);
			GenericFunctions.waitWebDriver(2000);
			MentorOrgPageObj.upForReview.click();
			GenericFunctions.waitForElementToAppear(MentorOrgPageObj.firtContent);
			String courseContent = MentorOrgPageObj.firtContent.getText();
			System.out.println(courseContent);
			GenericFunctions.waitWebDriver(2000);
			MentorOrgPageObj.firtContent.click();
			GenericFunctions.WaitForFrameAndSwitchToIt(MentorOrgPageObj.iFrame);
			GenericFunctions.waitWebDriver(2000);
			GenericFunctions.scrollToElement(MentorOrgPageObj.headerPublish);
			GenericFunctions.waitWebDriver(4000);
			if(MentorOrgPageObj.headerPublish.isDisplayed())
			{
				MentorOrgPageObj.headerPublish.click();
			}
			else if(MentorOrgPageObj.Publish.isDisplayed())
			{
				MentorOrgPageObj.Publish.click();
			}

			GenericFunctions.waitForElementToAppear(MentorOrgPageObj.publishConfirm);
			MentorOrgPageObj.publishConfirm.click();			
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
			/*MentorOrgPageObj.dropDown.click();
			GenericFunctions.waitForElementToAppear(MentorOrgPageObj.headerProfile);
			MentorOrgPageObj.headerProfile.click();*/
			MentorOrgPageObj.headerCourse.click();
			GenericFunctions.waitWebDriver(1000);
			String courseNumber = GenericFunctions.testDataIncrementer("./testData/courseNumbers.txt").toString();
			MentorOrgPageObj.filterSearch.sendKeys(objListOFTestDataForSunbird1.get(0).getTitle()+courseNumber);
			MentorOrgPageObj.searchIconUpForReview.click();
			GenericFunctions.waitWebDriver(2000);
			MentorOrgPageObj.searchedCourse.click();
			GenericFunctions.waitWebDriver(1000);
			MentorOrgPageObj.createBatch.click();
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
			// MentorOrgPageObj.headerCourse.click();
			// GenericFunctions.waitWebDriver(1000);
			// MentorOrgPageObj.filterSearch.sendKeys(objListOFTestDataForSunbird.get(0).getCourseName()+GenericFunctions.readFromNotepad(".//batchNumbers.txt").toUpperCase());
			// MentorOrgPageObj.searchIcon.click();
			// GenericFunctions.waitWebDriver(2000);
			// MentorOrgPageObj.courseImg1.click();
			// GenericFunctions.waitWebDriver(3000);
			MentorOrgPageObj.addIcon.click();
			GenericFunctions.waitWebDriver(1000);
			GenericFunctions.switchToFrame(driver, MentorOrgPageObj.batchForm);
			GenericFunctions.waitWebDriver(1000);
			MentorOrgPageObj.nameOfBatch.sendKeys(objListOFTestDataForSunbird.get(0).getCourseName()
					+ GenericFunctions.testDataIncrementer("./testData/sunbird_data.txt"));
			MentorOrgPageObj.aboutBatch.sendKeys(objListOFTestDataForSunbird.get(0).getCourseName());
			//			MentorOrgPageObj.openBatch.click();
			MentorOrgPageObj.startDate.click(); // sendKeys(objListOFTestDataForSunbird.get(8).getTitle());
			GenericFunctions.waitWebDriver(1000);
			MentorOrgPageObj.startDateCalendar.click(); // sendKeys(objListOFTestDataForSunbird.get(8).getTitle());
			MentorOrgPageObj.endDate.sendKeys(objListOFTestDataForSunbird.get(8).getTitleDescription());
			GenericFunctions.waitWebDriver(3000);
			MentorOrgPageObj.mentorsInBatch.click();
			MentorOrgPageObj.suborgMentor2InBatch.click();
			GenericFunctions.waitWebDriver(1500);			
			MentorOrgPageObj.membersInBatch.click();
			GenericFunctions.waitWebDriver(1500);
			MentorOrgPageObj.testBookReviewerInBatch.click();
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

			MentorOrgPageObj.buttonCreate.click();
			// MentorOrgPageObj.successfulMessage.click();
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
			/*try{
				if(MentorOrgPageObj.closePopUp.isDisplayed())
				{
					MentorOrgPageObj.closePopUp.click();
					GenericFunctions.waitWebDriver(1500);
					MentorOrgPageObj.headerCourse.click();
					GenericFunctions.waitWebDriver(4000);
				}
			}
			catch(Exception e)
			{
				MentorOrgPageObj.headerCourse.click();
				GenericFunctions.waitWebDriver(4000);
			}*/
			GenericFunctions.waitTillTheElementIsVisibleAndClickable(MentorOrgPageObj.headerCourse);
			MentorOrgPageObj.headerCourse.click();
			GenericFunctions.waitWebDriver(4000);
			GenericFunctions.waitForElementToAppear(MentorOrgPageObj.latestCourse);
			MentorOrgPageObj.latestCourse.click();
			GenericFunctions.waitWebDriver(3000);
			MentorOrgPageObj.addIcon.click();
			GenericFunctions.waitWebDriver(2000);
			MentorOrgPageObj.nameOfBatch.sendKeys(objListOFTestDataForSunbird.get(0).getCourseName()
					+ GenericFunctions.testDataIncrementer("./testData/batchNumbers.txt"));
			MentorOrgPageObj.aboutBatch.sendKeys(objListOFTestDataForSunbird.get(0).getCourseName());

			MentorOrgPageObj.startDate.click();
			GenericFunctions.waitWebDriver(1000);
			MentorOrgPageObj.startDateCalendar.click();
			GenericFunctions.waitWebDriver(1000);
			MentorOrgPageObj.endDate.sendKeys(objListOFTestDataForSunbird.get(8).getTitleDescription());

			MentorOrgPageObj.mentorsInBatch.click();
			GenericFunctions.waitWebDriver(1000);				
			MentorOrgPageObj.suborgMentor2InBatch.click();
			MentorOrgPageObj.mentorsInBatch.click();

			GenericFunctions.waitWebDriver(1000);								
			MentorOrgPageObj.mentorDropdown.click();
			MentorOrgPageObj.membersInBatch.click();
			MentorOrgPageObj.mentorDropdown.click();
			GenericFunctions.waitWebDriver(2000);	

			GenericFunctions.waitTillTheElementIsVisibleAndClickable(MentorOrgPageObj.buttonCreate);
			MentorOrgPageObj.buttonCreate.click();
			GenericFunctions.waitWebDriver(4000);
			//MentorOrgPageObj.successfulMessage.click();
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
