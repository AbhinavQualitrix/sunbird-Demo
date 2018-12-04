package org.pageobjects;

import java.util.List;
import java.util.Random;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.generic.ExtentTestManager;
import org.generic.GenericFunctions;
import org.generic.ReadTestDataFromExcel;
import org.page.ContentCreationLessonPlanPage;
import org.page.CreateMentorPage;
import org.page.CreatorUserPage;
import org.page.PublicUserPage;
import org.page.SignUpPage;
import org.startup.BaseTest;
import org.testdata.TestDataForSunbird;
import org.testng.Assert;

import com.relevantcodes.extentreports.LogStatus;

public class ContentCreationLessonPlanPageObj extends BaseTest
{
	WebDriverWait wait = new WebDriverWait(driver,20);
	CreatorUserPageObj abc = new CreatorUserPageObj(); 
	CreatorUserPage createUserPage=PageFactory.initElements(driver, CreatorUserPage.class);
	PublicUserPage publicUserPage = PageFactory.initElements(driver, PublicUserPage.class);
	CreateMentorPage createMentorPage=PageFactory.initElements(driver, CreateMentorPage.class);
	SignUpPage signUpPage=PageFactory.initElements(driver, SignUpPage.class);
	ContentCreationLessonPlanPage contentCreationPage= PageFactory.initElements(driver, ContentCreationLessonPlanPage.class);
	static Logger log = Logger.getLogger(CreatorUserPageObj.class.getName());
	List <TestDataForSunbird> objListOFTestDataForSunbird1= null ;
	Actions action = new Actions(driver);
	Random rand=new Random();
	CreatorUserPageObj createUserPageObj = new CreatorUserPageObj();
	JavascriptExecutor executor = (JavascriptExecutor)driver;

	public void verifyCreateBookPopup()
	{
		try
		{
			objListOFTestDataForSunbird1 = ReadTestDataFromExcel.getTestDataForSunbird("testdatasheetcourse");
			ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to validate Content Editor");
			GenericFunctions.waitWebDriver(1500);
			GenericFunctions.waitForElementToAppear(createUserPage.bookName);
			String bookNumber = GenericFunctions.testDataIncrementer(".//TestData//bookNumbers.txt").toString();
			createUserPage.bookName.sendKeys("Book to Validate Content Editor"+bookNumber);			
			GenericFunctions.waitWebDriver(1000);
			GenericFunctions.waitForElementToAppear(createUserPage.startCreating);
			createUserPage.startCreating.click();
			GenericFunctions.waitWebDriver(2000);
			GenericFunctions.WaitForFrameAndSwitchToIt(createUserPage.iFrame);
			GenericFunctions.waitWebDriver(6500);
			GenericFunctions.waitForElementToAppear(createUserPage.editorCloseIcon);
			createUserPage.editorCloseIcon.click();
		}
		catch(Exception e)
		{
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed to create a book and navigate to Content Editor");
			ExtentTestManager.getTest().log(LogStatus.FAIL,"Exception Message: "+e.getLocalizedMessage());
			Assert.fail("Could not create a Book and Navigaet to Content Editor, Exception"+e.getLocalizedMessage());
		}
	}

	public void validateContentEditor()
	{
		try
		{
			//Work from here
		}
		catch(Exception e)
		{
			
		}
	}
	public void navigateToLibraryAndSearchContent()
	{
		try	
		{
			ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to navigate to library and search for the content");	
			objListOFTestDataForSunbird1 = ReadTestDataFromExcel.getTestDataForSunbird("testdatasheetcourse");
			//createUserPage.dropDown.click();
			GenericFunctions.waitForElementToAppear(createUserPage.headerLibrary);
			createUserPage.headerLibrary.click();
			GenericFunctions.waitWebDriver(1000);
			createUserPage.searchInput.click();
			createUserPage.searchInput.sendKeys(objListOFTestDataForSunbird1.get(2).getCourseName());//+"_"+GenericFunctions.readFromNotepad(".//TestData//contentNumbers.txt"));
			System.out.println(objListOFTestDataForSunbird1.get(2).getCourseName());//+"_"+GenericFunctions.readFromNotepad(".//TestData//contentNumbers.txt"));
			createUserPage.searchIconUpForReview.click();
			GenericFunctions.waitForElementToAppear(createUserPage.getCourseName);
			String searchedBookName = createUserPage.getCourseName.getText();
			createUserPage.getCourseName.click();
			GenericFunctions.waitForElementToAppear(contentCreationPage.copyIcon);
			contentCreationPage.copyIcon.click();
			GenericFunctions.waitWebDriver(2000);
			GenericFunctions.WaitForFrameAndSwitchToIt(createUserPage.iFrame);
			GenericFunctions.waitWebDriver(6500);
			String aBookname=contentCreationPage.copiedContentName.getText();
			System.out.println(aBookname);
			if(aBookname.contains(searchedBookName))
			{
				System.out.println(aBookname+" Content copied succesfully");
				Assert.assertTrue(true);
			}
		}
		catch(Exception e)
		{
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed to verify book option to the user");
			ExtentTestManager.getTest().log(LogStatus.FAIL,"Exception Message: "+e.getLocalizedMessage());
			Assert.fail("Could not Navigate to library and search the content, Exception"+e.getLocalizedMessage());

		}
	}
	//TC_233
	public void upForReviewer()
	{
		try{

			ExtentTestManager.getTest().log(LogStatus.INFO, "User trying to navigate to reviwer page");
			objListOFTestDataForSunbird1 = ReadTestDataFromExcel.getTestDataForSunbird("testdatasheetcourse");
			createUserPageObj.goToProfilePage();
			GenericFunctions.waitForElementToAppear(createUserPage.workSpace);
			createUserPage.workSpace.click();
			contentCreationPage.upForReviewButton.click();
			boolean elementStatus=contentCreationPage.latestContent.isDisplayed();
			if(elementStatus==true)
			{
				System.out.println(contentCreationPage.latestContent.getText()+" is the latest content found in the Up For Review bucket");
				Assert.assertTrue(true, contentCreationPage.latestContent+" Could not find latest content");
			}

		}
		catch(Exception e)
		{
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed to verify book option to the user");
			ExtentTestManager.getTest().log(LogStatus.FAIL,"Exception Message: "+e.getLocalizedMessage());
			Assert.fail("Could not Navigate to up for Review page and could not display latest content, Exception"+e.getLocalizedMessage());

		}

	}

	//TC_234
	public void searchFunctionInUpForReview()
	{
		try
		{
			ExtentTestManager.getTest().log(LogStatus.INFO, "User trying to navigate to reviwer page");
			objListOFTestDataForSunbird1 = ReadTestDataFromExcel.getTestDataForSunbird("testdatasheetcourse");

		}
		catch(Exception e)
		{
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed to search the content in up for Review Bucket");
			ExtentTestManager.getTest().log(LogStatus.FAIL,"Exception Message: "+e.getLocalizedMessage());
			Assert.fail("Could not able to search the content, Exception"+e.getLocalizedMessage());
		}

	}
	//TC_238
	public void rejectInUpForReview()
	{
		try{

			ExtentTestManager.getTest().log(LogStatus.INFO, "User trying to navigate to reviwer page");
			objListOFTestDataForSunbird1 = ReadTestDataFromExcel.getTestDataForSunbird("testdatasheetcourse");
			createUserPageObj.goToProfilePage();
			GenericFunctions.waitForElementToAppear(createUserPage.workSpace);
			createUserPage.workSpace.click();
			contentCreationPage.upForReviewButton.click();

		}
		catch(Exception e)
		{
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed to verify book option to the user");
			ExtentTestManager.getTest().log(LogStatus.FAIL,"Exception Message: "+e.getLocalizedMessage());
			Assert.fail("Could not Navigate to up for Review page and could not display latest content, Exception"+e.getLocalizedMessage());

		}

	}

	//tc 240

	public void navigateToUpForReview()
	{
		try
		{

			ExtentTestManager.getTest().log(LogStatus.INFO, "User trying to navigate to reviwer page");
			objListOFTestDataForSunbird1 = ReadTestDataFromExcel.getTestDataForSunbird("testdatasheetcourse");
			createUserPageObj.goToProfilePage();
			GenericFunctions.waitForElementToAppear(createUserPage.workSpace);
			createUserPage.workSpace.click();
			
			GenericFunctions.waitForElementToAppear(createUserPage.upForReview);
			createUserPage.upForReview.click();
			//contentCreationPage.upForReviewButton.click();

		}
		catch(Exception e)
		{
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed to verify book option to the user");
			ExtentTestManager.getTest().log(LogStatus.FAIL,"Exception Message: "+e.getLocalizedMessage());
			Assert.fail("Could not Navigate to up for Review page and could not display latest content, Exception"+e.getLocalizedMessage());

		}
	}


	public void rejectTheContent()
	{
		try
		{

			ExtentTestManager.getTest().log(LogStatus.INFO, "User trying to navigate to reviwer page");
			objListOFTestDataForSunbird1 = ReadTestDataFromExcel.getTestDataForSunbird("testdatasheetcourse");
			GenericFunctions.waitWebDriver(2000);
			GenericFunctions.waitForElementToAppear(createUserPage.searchForReview);
			createUserPage.searchForReview.click();
			createUserPage.searchForReview.sendKeys(objListOFTestDataForSunbird1.get(2).getCourseName());
			/*GenericFunctions.waitForElementToAppear(contentCreationPage.latestContent);
			contentCreationPage.latestContent.click();*/
			
			GenericFunctions.waitForElementToAppear(createUserPage.searchedContentForPublish);
			GenericFunctions.waitWebDriver(3000);
			action.click(createUserPage.searchedContentForPublish).build().perform();
			//createUserPage.searchedContentForPublish.click();
			GenericFunctions.waitWebDriver(6000);
			GenericFunctions.WaitForFrameAndSwitchToIt(createUserPage.iFrame);
			GenericFunctions.waitWebDriver(6000);
			GenericFunctions.waitForElementToAppear(contentCreationPage.requestChanges);
			GenericFunctions.waitWebDriver(2000);
			contentCreationPage.requestChanges.click();
			//contentCreationPage.commentTextArea.sendKeys("Test data");
			GenericFunctions.waitWebDriver(3000);
			createUserPage.rejectReason1.click();
			createUserPage.rejectReason2.click();
			createUserPage.rejectReason3.click();
			String rejectReason = (REVIEW_COMMENTS[new Random().nextInt(REVIEW_COMMENTS.length)]);
			createUserPage.reviewComments.click();
			createUserPage.reviewComments.sendKeys(rejectReason);
			GenericFunctions.waitWebDriver(2000);
			/*WebElement html = driver.findElement(By.tagName("html"));
			html.sendKeys(Keys.chord(Keys.CONTROL, Keys.SUBTRACT));*/
			executor.executeScript("document.body.style.zoom = '0.8'");
			GenericFunctions.waitWebDriver(2000);
			action.moveToElement(createUserPage.requestChangesButton1).build().perform();
			//createUserPage.requestChangesButton.click();
			GenericFunctions.waitWebDriver(2000);
			GenericFunctions.waitForElementToAppear(contentCreationPage.upForReviewButton);
		}
		catch(Exception e)
		{
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed to verify book option to the user");
			ExtentTestManager.getTest().log(LogStatus.FAIL,"Exception Message: "+e.getLocalizedMessage());
			Assert.fail("Could not Navigate to up for Review page and could not display latest content, Exception"+e.getLocalizedMessage());
		}

	}

	public void verifyReviewerIsRedirectedPage()
	{
		ExtentTestManager.getTest().log(LogStatus.INFO, "User trying to navigate to reviwer page");
		objListOFTestDataForSunbird1 = ReadTestDataFromExcel.getTestDataForSunbird("testdatasheetcourse");

		String actual= driver.getCurrentUrl();
		String expected="https://staging.open-sunbird.org/workspace/content/upForReview/1";
		try
		{
			Assert.assertEquals(actual, expected);
			Assert.assertTrue(true);
			System.out.println("Only Textbooks are available");
			GenericFunctions.waitWebDriver(2000);
		}
		catch(Exception e)
		{
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed to verify book option to the user");
			ExtentTestManager.getTest().log(LogStatus.FAIL,"Exception Message: "+e.getLocalizedMessage());
			Assert.fail("Could not Navigate to up for Review page and could not display latest content, Exception"+e.getLocalizedMessage());

		}
	}
	
	
	//TC237

	public String searchInUpForReview(String source,List <TestDataForSunbird> objListOFTestDataForSunbird) throws Exception
	{
		String courseNumber = "",searchCourseName="";
		try
		{	
			ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to "
					+ " in Up For Review bucket for "+source);
			createUserPageObj.goToProfilePage();
			GenericFunctions.waitForElementToAppear(createUserPage.workSpace);
			createUserPage.workSpace.click();
			createUserPage.upForReview.click();
			if(source.equalsIgnoreCase(COURSE)){
				courseNumber = GenericFunctions.readFromNotepad(".//TestData//courseNumbers.txt").toString();
				createUserPage.searchForReview.click();
				createUserPage.searchForReview.sendKeys(objListOFTestDataForSunbird.get(0).getCourseName()+courseNumber);
				createUserPage.searchIconUpForReview.click();
				searchCourseName = objListOFTestDataForSunbird.get(0).getCourseName()+courseNumber;
				GenericFunctions.waitWebDriver(3000);			
			}
			else if(source.equalsIgnoreCase(BOOK)){
				courseNumber = GenericFunctions.readFromNotepad(".//TestData//bookNumbers.txt").toString();
				createUserPage.searchForReview.click();
				createUserPage.searchForReview.sendKeys(objListOFTestDataForSunbird.get(2).getCourseName()+courseNumber);
				createUserPage.searchIconUpForReview.click();
				searchCourseName = objListOFTestDataForSunbird.get(2).getCourseName()+courseNumber;
				GenericFunctions.waitWebDriver(3000);			
			}
			//Added on 10 july 2018
			else if(source.equalsIgnoreCase(RESOURCE))
			{
				courseNumber = GenericFunctions.readFromNotepad(".//TestData//resourceNumbers.txt").toString();
				createUserPage.searchForReview.click();
				createUserPage.searchForReview.sendKeys(objListOFTestDataForSunbird.get(6).getCourseName()+courseNumber);
				createUserPage.searchIconUpForReview.click();
				searchCourseName = objListOFTestDataForSunbird.get(6).getCourseName()+courseNumber;
				GenericFunctions.waitWebDriver(3000);
			}
			//--------------------------

			assertFoundInUpForReview(searchCourseName);
			GenericFunctions.waitWebDriver(3000);

		}
		catch(Exception e)
		{
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed on searching in Up for review");
			ExtentTestManager.getTest().log(LogStatus.FAIL,"Exception Message: "+e.getLocalizedMessage());
			System.out.println(e.getLocalizedMessage());
			log.error("Exception In the method searchCourse"+e.getMessage());
			Assert.fail("Failed to search in Up for review bucket");
		}
		return searchCourseName;

	}

	private void assertFoundInUpForReview(String searchCourseName) {
		// TODO Auto-generated method stub
		
	}

	
	
}
