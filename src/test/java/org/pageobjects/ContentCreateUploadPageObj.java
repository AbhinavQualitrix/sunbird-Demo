package org.pageobjects;
import static org.testng.Assert.assertEquals;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.List;
import java.util.Random;
import org.apache.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.generic.ExtentTestManager;
import org.generic.GenericFunctions;
import org.generic.ReadTestDataFromExcel;
import org.page.ContentCreateUploadPage;
import org.page.CreateMentorPage;
import org.page.CreatorUserPage;
import org.page.PublicUserPage;
import org.page.SignUpPage;
import org.page.TopicTreePage;
import org.page.SignUpPage;
import org.startup.BaseTest;
import org.testdata.TestDataForSunbird;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import com.relevantcodes.extentreports.LogStatus;

public class ContentCreateUploadPageObj extends BaseTest
{
	WebDriverWait wait = new WebDriverWait(driver,20);
	CreatorUserPage createUserPage=PageFactory.initElements(driver, CreatorUserPage.class);
	PublicUserPage publicUserPage = PageFactory.initElements(driver, PublicUserPage.class);
	CreateMentorPage createMentorPage=PageFactory.initElements(driver, CreateMentorPage.class);
	ContentCreateUploadPage contentCreatePage = PageFactory.initElements(driver, ContentCreateUploadPage.class);
	CreatorUserPageObj createrUserPageObj = new CreatorUserPageObj();
	TopicTreePage topicslist = PageFactory.initElements(driver, TopicTreePage.class);
	SignUpPage signUpPage=PageFactory.initElements(driver, SignUpPage.class);
	static Logger log = Logger.getLogger(CreatorUserPageObj.class.getName());
	List <TestDataForSunbird> objListOFTestDataForSunbird1= null ;
	Actions action = new Actions(driver);
	Random rand=new Random();
	String eurl="https://staging.open-sunbird.org/workspace/content/edit/generic#no";
	String a="Browse";
	String title="";

	public void verifyUploadContentPopupDisplay()
	{
		try 
		{  
		objListOFTestDataForSunbird1 = ReadTestDataFromExcel.getTestDataForSunbird("testdatasheetcourse");
		ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to verify the upload content popup display");
		GenericFunctions.WaitForFrameAndSwitchToIt(createUserPage.iFrame);
		GenericFunctions.waitWebDriver(7500);
		if( contentCreatePage.uploadContentText.isDisplayed())
		{
			String Evalue = contentCreatePage.uploadContentText.getText();			
			Assert.assertEquals("Upload Content", Evalue);
		}
		if(contentCreatePage.uploadButtonPop.isDisplayed())
		{
			String Evalue = contentCreatePage.uploadButtonPop.getText();	
			Assert.assertEquals("Upload", Evalue);	
		}
		if(contentCreatePage.closeEditor.isDisplayed())
		{
			String Evalue = contentCreatePage.closeEditor.getText();	
			Assert.assertEquals("Close Editor", Evalue);	
		}


		/*GenericFunctions.WaitForFrameAndSwitchToIt(createUserPage.iFrame);
			GenericFunctions.waitWebDriver(7500);*/

		WebElement browse = contentCreatePage.browseButton;
		System.out.println(browse.getText());
		if(browse.isDisplayed()&&createUserPage.enterUrl.isDisplayed())
		{

			String aurl=driver.getCurrentUrl();
			System.out.println(aurl);
			Assert.assertEquals(aurl, eurl,"The given url is not matching with the expected");
			Assert.assertTrue(true);
		}
		createUserPage.enterUrl.sendKeys(UPLOAD_YOUTUBE);
		GenericFunctions.waitForElementToAppear(contentCreatePage.uploadButtonPop);
		contentCreatePage.uploadButtonPop.click();
		GenericFunctions.waitWebDriver(5000);
		System.out.println(objListOFTestDataForSunbird1.get(10).getCourseName());
		}
		catch(Exception e)
		{
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed to verify upload content popup");
			ExtentTestManager.getTest().log(LogStatus.FAIL,"Exception Message: "+e.getLocalizedMessage());
			Assert.fail("Could not verify the upload content popup, Exception"+e.getLocalizedMessage());
		}
	}
	public void verifyFileUpload()
	{
		try {
			ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to  verify the upload content");

			contentCreatePage.saveuploadcontent.click();
			GenericFunctions.waitWebDriver(5000);
			createUserPage.closeButton.click();
			GenericFunctions.waitWebDriver(5000);

			contentCreatePage.uploadContent.click();
			GenericFunctions.waitWebDriver(5000);
			createUserPage.enterUrl.sendKeys(UPLOAD_YOUTUBE);
			GenericFunctions.waitWebDriver(5000);

			createUserPage.UploadButton.click();

			GenericFunctions.waitWebDriver(5000);
			contentCreatePage.saveuploadcontent.click();
			GenericFunctions.waitWebDriver(5000);
			if(createUserPage.closeButton.isDisplayed()){
				createUserPage.closeButton.click();
			}
			createUserPage.closeButton.click();
			GenericFunctions.waitWebDriver(2000);

		}catch(Exception e) {

		
		ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed to verify the upload content");
		ExtentTestManager.getTest().log(LogStatus.FAIL,"Exception Message: "+e.getLocalizedMessage());
		Assert.fail("Could not verify the upload content popup, Exception"+e.getLocalizedMessage());
	}	

	}

	public void navigateToLibraryAndSearchContent(List<TestDataForSunbird> objListOFTestDataForSunbird12)
	{
		try	
		{
			
			ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to navigate to library and search for the content");	

			objListOFTestDataForSunbird1 = ReadTestDataFromExcel.getTestDataForSunbird("testdatasheetcourse");
			//createUserPage.dropDown.click();
			GenericFunctions.waitForElementToAppear(createUserPage.headerLibrary);
			GenericFunctions.waitWebDriver(1200);
			createUserPage.headerLibrary.click();
			GenericFunctions.waitWebDriver(1000);
			createUserPage.searchInput.click();
			createUserPage.searchInput.sendKeys(objListOFTestDataForSunbird1.get(4).getCourseName()+"_"+GenericFunctions.readFromNotepad(".//TestData//contentNumbers.txt"));
			System.out.println(objListOFTestDataForSunbird1.get(4).getCourseName()+"_"+GenericFunctions.readFromNotepad(".//TestData//contentNumbers.txt"));
			createUserPage.searchIcon.click();

			//GenericFunctions.waitForElementToAppear(contentCreatePage.searchContentName);

			GenericFunctions.waitForElementToAppear(contentCreatePage.serachedContent);
			contentCreatePage.serachedContent.click();
			GenericFunctions.waitWebDriver(1200);
			GenericFunctions.scrollToElement(contentCreatePage.homeNavigation);
			GenericFunctions.waitWebDriver(1200);
			GenericFunctions.waitForElementToAppear(contentCreatePage.searchContentName);
			if(contentCreatePage.searchContentName.isDisplayed())
			{
				String Evalue = contentCreatePage.searchContentName.getText();
				Assert.assertEquals(" Automation Content_CN0049_WEBM", Evalue);

			}
			GenericFunctions.waitForElementToAppear(contentCreatePage.copy);		
			contentCreatePage.copy.click();			
			GenericFunctions.waitWebDriver(5000);		
			Assert.assertTrue(true);
		}
		catch(Exception e)
		{
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed to navigate to library and search for the content");
			ExtentTestManager.getTest().log(LogStatus.FAIL,"Exception Message: "+e.getLocalizedMessage());
			Assert.fail("Could not Navigate to library and search the content, Exception"+e.getLocalizedMessage());

		}

	}
	public void reviewUploadContent()
	{
		try {
			ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to go to up for review and verify the upload");

			objListOFTestDataForSunbird1=ReadTestDataFromExcel.getTestDataForSunbird("testdatasheetcourse");
			createUserPage.workSpace.click();
			createUserPage.upForReview.click();



		}catch(Exception e)
		{
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed to verify the upload content for the user");
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Exception Message: "+e.getLocalizedMessage());
			Assert.fail("Could not go to the up for review and verify the upload content"+e.getLocalizedMessage());

		}
	}
	/*public void navigateToLibraryAndSearchContent()
	{
		try 
		{
			ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to navigate to library and search for the content"); 
			List <TestDataForSunbird> objListOFTestDataForSunbird1=null;
			objListOFTestDataForSunbird1 = ReadTestDataFromExcel.getTestDataForSunbird("testdatasheetcourse");
			//createUserPage.dropDown.click();
			GenericFunctions.waitForElementToAppear(createUserPage.headerLibrary);
			createUserPage.headerLibrary.click();
			GenericFunctions.waitWebDriver(1000);
			createUserPage.searchInput.click();
			createUserPage.searchInput.sendKeys(objListOFTestDataForSunbird1.get(2).getCourseName());//+"_"+GenericFunctions.readFromNotepad(".//TestData//contentNumbers.txt"));
			System.out.println(objListOFTestDataForSunbird1.get(2).getCourseName());//+"_"+GenericFunctions.readFromNotepad(".//TestData//contentNumbers.txt"));
			createUserPage.searchIcon.click();
			GenericFunctions.waitForElementToAppear(createUserPage.searchedContent);
			createUserPage.searchedContent.click();
			GenericFunctions.waitWebDriver(5000);
			contentCreatePage.copy.click();
			GenericFunctions.waitWebDriver(5000);		
			Assert.assertTrue(true);

		}catch(Exception e)
		{
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed to verify the upload content for the user");
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Exception Message: "+e.getLocalizedMessage());
			Assert.fail("Could not go to the up for review and verify the upload content, Exception Message:Exception\"+e.getLocalizedMessage()");

		}
	}*/


	public void saveAndSendUploadContentForReview()throws Exception{

		try
		{
			ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to save and send u for review");

			objListOFTestDataForSunbird1=ReadTestDataFromExcel.getTestDataForSunbird("testdatatestcoursename");

			GenericFunctions.waitWebDriver(1500);
			createUserPage.sendForReview.click();
			GenericFunctions.waitWebDriver(1500);
			createUserPage.clickAppIcon.click();
			GenericFunctions.waitWebDriver(3000);

			/*
				createUserPage.uploadAndUseButton.click();
				GenericFunctions.waitWebDriver(2000);
				createUserPage.yesRadioButton.click();
				GenericFunctions.waitWebDriver(1500);
				createUserPage.chooseFileButton.click();
				GenericFunctions.waitWebDriver(1500);
				String path = System.getProperty("user.dir")+"\\UploadingDocuments\\Upload Document Contents\\"+SEARCH_CONTENT_IMAGE;
				System.out.println("Uploaded image : "+path);
				//log.info("Uploaded file name: "+path);
				GenericFunctions.waitWebDriver(3000);
				GenericFunctions.uploadFile(path);
				GenericFunctions.waitWebDriver(2500);
				createUserPage.uploadAndUseButtonRight.click();
				GenericFunctions.waitWebDriver(1800);
			 */

			GenericFunctions.waitForElementToAppear(createUserPage.searchUploadImage);
			GenericFunctions.waitWebDriver(1000);
			createUserPage.searchUploadImage.sendKeys(SEARCH_CONTENT_IMAGE);
			GenericFunctions.waitWebDriver(2500);
			createUserPage.clickImageSearch.click();
			GenericFunctions.waitWebDriver(1000);
			createUserPage.checkContentIcon.click();
			GenericFunctions.waitWebDriver(2500);
			createUserPage.selectAppIcon.click();
			GenericFunctions.waitWebDriver(1000);
			GenericFunctions.waitWebDriver(2000);

			GenericFunctions.waitForElementToAppear(createUserPage.clickOnSelectCurriculum);
			createUserPage.clickOnSelectCurriculum.click();
			GenericFunctions.waitWebDriver(1000);
			createUserPage.selectCurriculum.click();
			GenericFunctions.waitForElementToAppear(createUserPage.clickOnSelectClass);
			GenericFunctions.waitWebDriver(1000);
			createUserPage.clickOnSelectClass.click();
			GenericFunctions.waitWebDriver(1000);
			createUserPage.selectClass.click();
			//GenericFunctions.keyTab(driver, createUserPage.selectClass.toString());
			//GenericFunctions.waitTillTheElementIsVisibleAndClickable(createUserPage.clickOnHeaderSubject);
			//createUserPage.clickOnHeaderSubject.click();
			GenericFunctions.waitWebDriver(3000);
			GenericFunctions.scrollToElement(createUserPage.clickOnSelectSubject);
			GenericFunctions.waitTillTheElementIsVisibleAndClickable(createUserPage.clickOnSelectSubject);
			createUserPage.clickOnSelectSubject.click();
			GenericFunctions.scrollToElement(createUserPage.clickOnSelectMedium);
			GenericFunctions.waitForElementToAppear(createUserPage.clickOnSelectMedium);
			createUserPage.clickOnSelectMedium.click();
			GenericFunctions.waitForElementToAppearOnScreen(createUserPage.selectMedium);
			GenericFunctions.waitWebDriver(1000);
			createUserPage.selectMedium.click();
			GenericFunctions.waitWebDriver(5000);
			//			contentCreatePage.selectTopic.click();
			//			GenericFunctions.waitForElementToAppear(createUserPage.searchConcept);

			//			createUserPage.searchConcept.sendKeys(objListOFTestDataForSunbird.get(10).getCourseName());			System.out.println(objListOFTestDataForSunbird.get(10).getCourseName());
			//
			//			GenericFunctions.waitWebDriver(5000);
			//			contentCreatePage.selectFunction.click();
			//			GenericFunctions.waitWebDriver(5000);
			//			createUserPage.conceptDoneButton.click();
			//			GenericFunctions.waitWebDriver(5000);
			//			createUserPage.clickOnSelectSubject.click();
			//			GenericFunctions.waitForElementToAppear(createUserPage.selectSubject);
			//			createUserPage.selectSubject.click();
			action.moveToElement(contentCreatePage.owner).click().perform();			
			GenericFunctions.scrollToElement(contentCreatePage.owner);
			contentCreatePage.owner.click();
			GenericFunctions.waitWebDriver(1500);
			contentCreatePage.ownership.click();
			GenericFunctions.waitForElementToAppear(createUserPage.saveButton);
			createUserPage.saveButton.click();
			GenericFunctions.waitWebDriver(5000);

		}
		catch(Exception e)
		{
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed on saving and sending course for review");
			ExtentTestManager.getTest().log(LogStatus.FAIL,"Exception Message: "+e.getLocalizedMessage());
			System.out.println("Failed to save and course for review");
			Assert.fail("Failed on saving and sending course for review, Exception"+e.getLocalizedMessage());

		}

	}

	public void uploadContent_Pdf_MP4_WEBMHP5()
	{
		try {
			ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to upload MP4");
			objListOFTestDataForSunbird1=ReadTestDataFromExcel.getTestDataForSunbird("testdatasheetcoursename");
			GenericFunctions.WaitForFrameAndSwitchToIt(createUserPage.iFrame);
			GenericFunctions.waitForElementToAppear(contentCreatePage.browseButton);
			GenericFunctions.waitWebDriver(5000);
			contentCreatePage.browseButton.click();

			GenericFunctions.waitWebDriver(5000);


		}catch(Exception e)
		{
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed To upload MP4");
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Exception Message: "+e.getLocalizedMessage());
			Assert.fail("Failed to upload MP4, Exception"+e.getLocalizedMessage());
		}

	}
	public void verifyThatEditDetailsPageIsDisplayed()
	{
		try {
			
			ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to get edit Detail Page is Displaying and Continuation of the test case number 129");
			//List<TestDataForSunbird>objListOFTestDatForSunbird=null;
			objListOFTestDataForSunbird1=ReadTestDataFromExcel.getTestDataForSunbird("testdatasheetcourse");
			String upload =GenericFunctions.testDataIncrementer("./testData/uploadNumbers.txt");
			GenericFunctions.waitWebDriver(5000);
			GenericFunctions.WaitForFrameAndSwitchToIt(createUserPage.iFrame);
			GenericFunctions.waitWebDriver(7500);
			GenericFunctions.waitForElementToAppear(createUserPage.enterUrl);
			createUserPage.enterUrl.sendKeys(UPLOAD_YOUTUBE);    
			GenericFunctions.waitForElementToAppear(contentCreatePage.uploadButtonPop);
			contentCreatePage.uploadButtonPop.click();
			GenericFunctions.waitWebDriver(5000);							
			contentCreatePage.editDetailsLink.click();
			GenericFunctions.waitWebDriver(5000);

			if(contentCreatePage.editDetailsHeading.isDisplayed())
			{
				String Evalue = contentCreatePage.editDetailsHeading.getText();
				Assert.assertEquals("Edit Details", Evalue);

			}
			if(contentCreatePage.appIcon.isDisplayed())
			{
				String Evalue = contentCreatePage.appIcon.getText();
				Assert.assertEquals("App Icon", Evalue);
			}
			if(contentCreatePage.cancelButton.isDisplayed())
			{
				String Evalue = contentCreatePage.cancelButton.getText();
				Assert.assertEquals("Cancel", Evalue);	
			}
			if(createUserPage.saveButton.isDisplayed())
			{

				String Evalue = createUserPage.saveButton.getText();
				Assert.assertEquals("Save", Evalue);
			}


			System.out.println("The Edit details page is displaying");
			GenericFunctions.waitWebDriver(5000);


			contentCreatePage.checkAppIcon.click();


			ExtentTestManager.getTest().log(LogStatus.INFO, "Continuation with the next scenario");
			ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to see the board,medium,class,subject in the topic page.");
			/*
					GenericFunctions.waitWebDriver(2000);
					createUserPage.uploadAndUseButton.click();
					GenericFunctions.waitWebDriver(2000);
					createUserPage.yesRadioButton.click();
					GenericFunctions.waitWebDriver(1500);
					createUserPage.chooseFileButton.click();
					GenericFunctions.waitWebDriver(1500);
					String path = System.getProperty("user.dir")+"\\UploadingDocuments\\Upload Document Contents\\"+SEARCH_COURSE_IMAGE;
					System.out.println("Uploaded image : "+path);
					//log.info("Uploaded file name: "+path);
					GenericFunctions.waitWebDriver(3000);
					GenericFunctions.uploadFile(path);
					GenericFunctions.waitWebDriver(2500);
					createUserPage.uploadAndUseButtonRight.click();
			 */

			GenericFunctions.waitForElementToAppear(createUserPage.searchUploadImage);
			GenericFunctions.waitWebDriver(1000);
			createUserPage.searchUploadImage.sendKeys(SEARCH_COURSE_IMAGE);
			GenericFunctions.waitWebDriver(1200);
			createUserPage.clickImageSearch.click();
			GenericFunctions.waitWebDriver(5000);
			contentCreatePage.checkContentIcon.click();

			GenericFunctions.waitForElementToAppear(createUserPage.selectAppIcon);
			contentCreatePage.selectAppIcon.click();

			GenericFunctions.waitWebDriver(2500);
			GenericFunctions.waitForElementToAppear(contentCreatePage.uploadContentName);
			contentCreatePage.uploadContentName.clear();
			GenericFunctions.waitWebDriver(2500);
			contentCreatePage.uploadContentName.sendKeys(objListOFTestDataForSunbird1.get(0).getCourseDescription()+upload);







			GenericFunctions.waitForElementToAppear(createUserPage.clickOnSelectCurriculum);
			GenericFunctions.waitWebDriver(5000);

			createUserPage.clickOnSelectCurriculum.click();

			GenericFunctions.waitForElementToAppear(createUserPage.selectCurriculum);			
			GenericFunctions.waitWebDriver(2000);
			createUserPage.selectCurriculum.click();

			GenericFunctions.waitForElementToAppear(createUserPage.clickOnSelectClass);
			createUserPage.clickOnSelectClass.click();
			GenericFunctions.waitWebDriver(1000);
			createUserPage.selectClass.click();
			GenericFunctions.keyTab(driver, createUserPage.selectClass.toString());
			//GenericFunctions.waitTillTheElementIsVisibleAndClickable(createUserPage.clickOnHeaderSubject);
			//createUserPage.clickOnHeaderSubject.click();
			GenericFunctions.waitWebDriver(1200);

			GenericFunctions.scrollToElement(createUserPage.clickOnSelectMedium);
			GenericFunctions.waitForElementToAppear(createUserPage.clickOnSelectMedium);
			GenericFunctions.waitTillTheElementIsVisibleAndClickable(createUserPage.clickOnSelectSubject);
			createUserPage.clickOnSelectSubject.click();
			GenericFunctions.waitForElementToAppear(createUserPage.selectSubject);
			createUserPage.selectSubject.click();
			GenericFunctions.waitWebDriver(1200);

			createUserPage.clickOnSelectMedium.click();
			GenericFunctions.waitForElementToAppearOnScreen(createUserPage.selectMedium);
			GenericFunctions.waitWebDriver(1200);
			createUserPage.selectMedium.click();
			GenericFunctions.waitWebDriver(1200);
			GenericFunctions.waitForElementToAppearOnScreen(contentCreatePage.selectTopicPopup);
			contentCreatePage.selectTopicPopup.click();
			GenericFunctions.waitWebDriver(3000);   
			GenericFunctions.waitForElementToAppearOnScreen(contentCreatePage.selectPolynomials);
			contentCreatePage.selectPolynomials.click();
			GenericFunctions.waitForElementToAppearOnScreen(topicslist.doneButton);
			topicslist.doneButton.click();
			GenericFunctions.waitWebDriver(3000);
			GenericFunctions.scrollToElement(contentCreatePage.owner);
			GenericFunctions.waitForElementToAppear(contentCreatePage.owner);
			contentCreatePage.owner.click();
			GenericFunctions.waitForElementToAppear(contentCreatePage.ownership);		
			contentCreatePage.ownership.click();


			/*	contentCreatePage.selectConcept.click();					
			GenericFunctions.waitWebDriver(1500);
			contentCreatePage.searchConcept1.sendKeys(objListOFTestDataForSunbird1.get(6).getTitle());
			GenericFunctions.waitWebDriver(1500);
			createUserPage.conceptChooseAll.click();
			GenericFunctions.waitWebDriver(1500);
			createUserPage.doneButton.click();
			GenericFunctions.waitWebDriver(1500);
			contentCreatePage.selectTopic.click();
			GenericFunctions.waitWebDriver(1500);
			contentCreatePage.doneButton1.click();

			GenericFunctions.waitWebDriver(1500);*/
			createUserPage.saveButton.click();
			GenericFunctions.waitWebDriver(1500);
			createUserPage.closeButton.click();
			/*	createUserPage.closeButton.click();
				//GenericFunctions.switchToFrame(contentCreatePage.closeEditor.iFrame);
				GenericFunctions.waitForElementToAppear(createUserPage.editorCloseIcon);
				GenericFunctions.waitWebDriver(5000);


				createUserPage.limitedSharingArrow.click();
				GenericFunctions.waitWebDriver(5000);
				createUserPage.clickLimitedSharing.click();
				GenericFunctions.waitWebDriver(5000);
				GenericFunctions.waitForElementToAppear(contentCreatePage.clickonLimitedPublishing);
				contentCreatePage.clickonLimitedPublishing.click();
				GenericFunctions.waitWebDriver(5000);

				contentCreatePage.clickOnShare.click();
				GenericFunctions.waitWebDriver(5000);
				GenericFunctions.waitForElementToAppear(contentCreatePage.linkdata);

				GenericFunctions.waitWebDriver(5000);
				GenericFunctions.uploadFile(A_HOME_URL);
			 */
			GenericFunctions.waitWebDriver(1500);
			GenericFunctions.waitForElementToAppear(createUserPage.sendForReview);
			createUserPage.sendForReview.click();
			GenericFunctions.waitWebDriver(5000);
			createUserPage.saveButton.click();
			GenericFunctions.waitWebDriver(2500);
			//				
			//				String url1=contentCreatePage.linkdata.getText();
			//				GenericFunctions.waitWebDriver(5000);
			//				System.out.println(url1);
			//				
			//				contentCreatePage.closeShareLink.click();
			//				GenericFunctions.waitWebDriver(5000);
			//			
			//				

			//				driver=new ChromeDriver();
			//				Thread.sleep(5000);
			//				driver.get(url1);
			//			    GenericFunctions.waitWebDriver(5000);
			//				






			//				createUserPage.editorCloseIcon.click();
			//				GenericFunctions.waitWebDriver(5000);

			//GenericFunctions.waitWebDriver(5000);




		}catch(Exception e)
		{
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Could not display the edit details page");
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Exception Message:"+e.getLocalizedMessage());
			Assert.fail("Could not display the edit details page, Exception"+e.getLocalizedMessage());
		}
	}

	public void allUploadsContent()
	{
		try {
			
			ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to verify the saved upload content in all upload section.");
			GenericFunctions.waitWebDriver(3000);
			//			Alert alert = driver.switchTo().alert();
			//			alert.accept();		

			GenericFunctions.waitWebDriver(5000);

			if(createUserPage.reviewCourseName.isDisplayed())
			{
				String eupload=	createUserPage.reviewCourseName.getText();
				Assert.assertEquals("CourseA Description ", eupload);
			}


			GenericFunctions.waitWebDriver(5000);
			GenericFunctions.waitTillTheElementIsVisibleAndClickable(createUserPage.reviewCourseName);
			createUserPage.reviewCourseName.click();
			GenericFunctions.waitWebDriver(5000);

			System.out.println(createUserPage.reviewCourseName);






		}catch(Exception e) 
		{
			ExtentTestManager.getTest().log(LogStatus.FAIL, "The upload content is not in all uploads after saving");
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Exception Message:"+e.getLocalizedMessage());
			Assert.fail("The upload content is not in all uploads after saving, Exception"+e.getLocalizedMessage());
		}
	}


	public void reviewSubmissionPage()
	{
		try {
			
			ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to see the upload content in review submision page.");

			objListOFTestDataForSunbird1=ReadTestDataFromExcel.getTestDataForSunbird("testdatasheetcourse");
			GenericFunctions.waitWebDriver(5000);
			GenericFunctions.waitForElementToAppear(contentCreatePage.reviewSubmission);
			contentCreatePage.reviewSubmission.click();
			GenericFunctions.waitWebDriver(5000);

			if(contentCreatePage.reviewCardView.isDisplayed())
			{
				String Evalue =contentCreatePage.reviewCardView.getText();
				Assert.assertEquals("CourseA Description", Evalue);
			}
			GenericFunctions.waitWebDriver(5000);
			contentCreatePage.homeNavigation.click();
			GenericFunctions.waitWebDriver(5000);
			


		}catch(Exception e)
		{
			ExtentTestManager.getTest().log(LogStatus.FAIL, "The upload content is not displaying in the review submision page");
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Exception Message:"+e.getLocalizedMessage());
			Assert.fail("The upload content is not displaying in the review submision page, Exception"+e.getLocalizedMessage());


		}


	}
	public void navigateToUpForReview()
	{
		try {
			
			ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to navigate to up for review page");

			objListOFTestDataForSunbird1=ReadTestDataFromExcel.getTestDataForSunbird("testdatasheetcourse");

			GenericFunctions.waitForElementToAppear(contentCreatePage.workspace);
			contentCreatePage.workspace.click();
			GenericFunctions.waitWebDriver(5000);
			contentCreatePage.upforreview.click();
			GenericFunctions.waitForElementToAppear(contentCreatePage.searchBox);
			contentCreatePage.searchBox.sendKeys(objListOFTestDataForSunbird1.get(0).getCourseDescription());

			if(contentCreatePage.contentupload.isDisplayed())
			{
				String Evalue=contentCreatePage.contentupload.getText();
				Assert.assertEquals("CourseA Description", Evalue);

			}
			contentCreatePage.contentupload.isDisplayed();
			GenericFunctions.waitWebDriver(5000);
			String uploadcontent=contentCreatePage.contentupload.getText();

			GenericFunctions.waitWebDriver(5000);


		}catch(Exception e)
		{
			ExtentTestManager.getTest().log(LogStatus.FAIL, "User is failed to navigate to up for review page");
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Exception Message:"+e.getLocalizedMessage());
			Assert.fail("User is failed to navigate to up for review page, Exception"+e.getLocalizedMessage());



		}

	}


	public void clickOnSortBy()
	{
		try {
			ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to sort by updated date");

			objListOFTestDataForSunbird1=ReadTestDataFromExcel.getTestDataForSunbird("testdatasheetcourse");

			GenericFunctions.waitWebDriver(5000);

			contentCreatePage.profileIcon.click();
			GenericFunctions.waitWebDriver(5000);
			GenericFunctions.waitForElementToAppear(contentCreatePage.workspace);
			contentCreatePage.workspace.click();
			GenericFunctions.waitWebDriver(5000);
			contentCreatePage.upforreview.click();
			GenericFunctions.waitWebDriver(5000);
			GenericFunctions.waitForElementToAppear(contentCreatePage.searchBox);
			contentCreatePage.searchBox.sendKeys("CourseA DescriptionC053");
			GenericFunctions.waitWebDriver(5000);
			contentCreatePage.sortBy.click();
			GenericFunctions.waitWebDriver(5000);
			contentCreatePage.updatedOn.click();
			GenericFunctions.waitWebDriver(5000);
			String updatedoncontent=contentCreatePage.date.getText();
			GenericFunctions.waitWebDriver(5000);
			contentCreatePage.date.isDisplayed();		
			System.out.println(updatedoncontent);
			GenericFunctions.waitWebDriver(5000);
			contentCreatePage.sortBy.click();
			GenericFunctions.waitWebDriver(5000);
			contentCreatePage.createdOn.click();
			GenericFunctions.waitWebDriver(5000);
			String updatedoncontent1=contentCreatePage.date.getText();
			GenericFunctions.waitWebDriver(5000);
			contentCreatePage.date.isDisplayed();		
			System.out.println(updatedoncontent);
			contentCreatePage.sortBy.click();
			GenericFunctions.waitWebDriver(5000);
			contentCreatePage.nameaz.click();
			String updatedoncontent2=contentCreatePage.date.getText();
			GenericFunctions.waitWebDriver(5000);
			contentCreatePage.date.isDisplayed();		
			System.out.println(updatedoncontent);




		}catch(Exception e) {
			ExtentTestManager.getTest().log(LogStatus.FAIL, "The upload content is not sort");
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Exception Message:"+e.getLocalizedMessage());
			Assert.fail("The upload content is not sort, Exception"+e.getLocalizedMessage());
		}
	}


	public void showFilter(){
		{
			try {
				
				ExtentTestManager.getTest().log(LogStatus.INFO, "The upload content is filtering with based on curriculum,grades,medium,subjects,content types,");
				objListOFTestDataForSunbird1=ReadTestDataFromExcel.getTestDataForSunbird("testdatasheetcourse");
				GenericFunctions.waitWebDriver(5000);			
				GenericFunctions.waitForElementToAppear(contentCreatePage.workspace);
				contentCreatePage.workspace.click();
				GenericFunctions.waitWebDriver(5000);
				contentCreatePage.upforreview.click();
				GenericFunctions.waitWebDriver(5000);
				contentCreatePage.showfilter.click();
				GenericFunctions.waitWebDriver(1200);
				/*contentCreatePage.selectBoard.click();
				GenericFunctions.waitWebDriver(1200);
				contentCreatePage.selectRajasthan.click();
				GenericFunctions.waitWebDriver(1200);
				contentCreatePage.gradeLevel.click();
				GenericFunctions.waitWebDriver(1200);
				contentCreatePage.selectClass9.click();
				GenericFunctions.waitWebDriver(1200);*/
				contentCreatePage.selectSubject.click();
				GenericFunctions.waitWebDriver(1200);
				contentCreatePage.selectMathematics.click();
				GenericFunctions.waitWebDriver(1200);
				contentCreatePage.selectMedium.click();
				GenericFunctions.waitWebDriver(1200);
				contentCreatePage.selectHindi.click();
				GenericFunctions.waitWebDriver(1200);
				contentCreatePage.selectContentType.click();
				GenericFunctions.waitWebDriver(1200);
				contentCreatePage.selectCollection.click();
				GenericFunctions.waitWebDriver(1200);
				GenericFunctions.waitForElementToAppear(contentCreatePage.clickOnApplyButton);
				contentCreatePage.clickOnApplyButton.click();
				GenericFunctions.waitWebDriver(5000);

				if(contentCreatePage.contentName.isDisplayed())
				{
					String Evalue =contentCreatePage.contentName.getText();
					Assert.assertEquals("Automation Collection_CL0043", Evalue);

				}
				GenericFunctions.waitWebDriver(5000);


			}
			catch(Exception e)
			{
				ExtentTestManager.getTest().log(LogStatus.FAIL, "The upload content is not filtering with based on curriculum,grades,medium,subjects,content types,");
				ExtentTestManager.getTest().log(LogStatus.FAIL, "Exception Message:"+e.getLocalizedMessage());
				Assert.fail("The upload content is not filtering with based on curriculum,grades,medium,subjects,content types,, Exception"+e.getLocalizedMessage());
			}
		}
	}

	public void navigateToUpForReviewN()
	{
		try {
			ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to see the upload content in up for review page");
			objListOFTestDataForSunbird1=ReadTestDataFromExcel.getTestDataForSunbird("testdatasheetcourse");
			GenericFunctions.waitForElementToAppear(contentCreatePage.workspace);
			contentCreatePage.workspace.click();
			GenericFunctions.waitWebDriver(5000);
			contentCreatePage.upforreview.click();
			GenericFunctions.waitWebDriver(5000);
			GenericFunctions.waitForElementToAppear(contentCreatePage.searchForReview);
			contentCreatePage.searchForReview.click();
			GenericFunctions.waitWebDriver(5000);
			GenericFunctions.waitForElementToAppear(contentCreatePage.searchForReview);
			GenericFunctions.waitWebDriver(5000);
			contentCreatePage.searchForReview.sendKeys(objListOFTestDataForSunbird1.get(0).getCourseDescription());

			GenericFunctions.waitWebDriver(5000);
			contentCreatePage.contentupload.click();
			GenericFunctions.waitWebDriver(5000);

			//GenericFunctions.scrollToElement(contentCreatePage.publishButton);

			//GenericFunctions.waitForElementToAppear(contentCreatePage.publishButton);
			//	action.moveToElement(contentCreatePage.publishButton).build().perform();

			Thread.sleep(5000);	
			contentCreatePage.publishButton.click();
			GenericFunctions.waitWebDriver(5000);
			for(int i=0;i<createUserPage.checkbox.size();i++){
				createUserPage.checkbox.get(i).click();
			}
			GenericFunctions.waitForElementToAppear(contentCreatePage.publishButton1);
			contentCreatePage.publishButton1.click();

			//			GenericFunctions.waitWebDriver(1200);
			//			GenericFunctions.waitForElementToAppear(contentCreatePage.profileIcon);
			//			contentCreatePage.profileIcon.click();
			//			GenericFunctions.waitForElementToAppear(contentCreatePage.logoutButton);
			//			contentCreatePage.logoutButton.click();

			GenericFunctions.waitWebDriver(3000);


		}catch(Exception e)
		{
			ExtentTestManager.getTest().log(LogStatus.FAIL, "The upload content is not displaying in the review submision page");
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Exception Message:"+e.getLocalizedMessage());
			Assert.fail("The upload content is not displaying in the review submision page, Exception"+e.getLocalizedMessage());
		}

	}

	public void publishedContent()
	{
		try {

			ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to publish the content");

			objListOFTestDataForSunbird1=ReadTestDataFromExcel.getTestDataForSunbird("testdatasheetcourse");
			GenericFunctions.waitWebDriver(1200);
			contentCreatePage.profileIcon.click();
			GenericFunctions.waitWebDriver(1200);
			GenericFunctions.waitForElementToAppear(contentCreatePage.workspace);
			contentCreatePage.workspace1.click();
			GenericFunctions.waitWebDriver(1200);
			contentCreatePage.published.click();
			GenericFunctions.waitWebDriver(1200);
			contentCreatePage.contentPublished.click();
			GenericFunctions.waitWebDriver(5000);





		}
		catch(Exception e)
		{
			ExtentTestManager.getTest().log(LogStatus.FAIL, "The upload content is not displaying in the published section");
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Exception Message:"+e.getLocalizedMessage());
			Assert.fail("The upload content is not displaying in the published section, Exception"+e.getLocalizedMessage());
		}


	}

	public void requestChanges()
	{
		try {
			
			ExtentTestManager.getTest().log(LogStatus.INFO, "User  is trying to send the request changes for all upload content");
			objListOFTestDataForSunbird1=ReadTestDataFromExcel.getTestDataForSunbird("testdatasheetcourse");

			GenericFunctions.waitForElementToAppear(contentCreatePage.workspace);
			contentCreatePage.workspace.click();
			GenericFunctions.waitWebDriver(5000);
			contentCreatePage.upforreview.click();
			
			GenericFunctions.waitWebDriver(5000);

			contentCreatePage.searchForReview.click();
			GenericFunctions.waitWebDriver(5000);
			GenericFunctions.waitForElementToAppear(contentCreatePage.searchForReview);
			GenericFunctions.waitWebDriver(5000);
			contentCreatePage.searchForReview.sendKeys(objListOFTestDataForSunbird1.get(0).getCourseDescription());
			
			if(contentCreatePage.contentupload.isDisplayed())
			{
				String Evalue =contentCreatePage.contentupload.getText();
				Assert.assertEquals("CourseA Description", Evalue);
			}

			GenericFunctions.waitWebDriver(5000);
			contentCreatePage.contentupload.click();
			GenericFunctions.waitWebDriver(5000);

			
	       
			
			GenericFunctions.waitForElementToAppear(contentCreatePage.requestChangesButton);
	
			contentCreatePage.requestChangesButton.click();
			GenericFunctions.waitWebDriver(5000);

			for(int i=0;i<contentCreatePage.checkbox.size();i++){
				contentCreatePage.checkbox.get(i).click();
			}
			GenericFunctions.waitWebDriver(5000);
			GenericFunctions.waitForElementToAppear(contentCreatePage.requestChangesComment);
			contentCreatePage.requestChangesComment.click();
			contentCreatePage.requestChangesComment.sendKeys(objListOFTestDataForSunbird1.get(0).getTitle());
			GenericFunctions.waitWebDriver(5000);

			contentCreatePage.requestChangesBlueButton.click();
			GenericFunctions.waitWebDriver(5000);






		}catch(Exception e)
		{
			ExtentTestManager.getTest().log(LogStatus.FAIL, "The reviewer failed to rejects the uploaded content ");
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Exception Message:"+e.getLocalizedMessage());
			Assert.fail("The reviewer failed to rejects the uploaded content, Exception"+e.getLocalizedMessage());

		}

	}
	public void alluploads()
	{
		try {
			ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to see the upload content in up for review page");

			objListOFTestDataForSunbird1=ReadTestDataFromExcel.getTestDataForSunbird("testdatasheetcourse");
			contentCreatePage.profileIcon.click();
			GenericFunctions.waitWebDriver(5000);
			GenericFunctions.waitForElementToAppear(contentCreatePage.workspace);
			contentCreatePage.workspace1.click();
			GenericFunctions.waitWebDriver(5000);
			contentCreatePage.allUploads.click();
			GenericFunctions.waitWebDriver(5000);
			contentCreatePage.contentPublished.click();

			GenericFunctions.waitForElementToAppear(contentCreatePage.reviewerSuggestion);
			GenericFunctions.waitTillTheElementIsVisibleAndClickable(contentCreatePage.reviewerSuggestion);
			GenericFunctions.waitWebDriver(5000);
			contentCreatePage.reviewerSuggestion.click();
			GenericFunctions.waitWebDriver(5000);
			if( contentCreatePage.reviewerSuggestionTitle.isDisplayed())
			{
				System.out.println("This test case pass");
			}





		}catch(Exception e)
		{
			ExtentTestManager.getTest().log(LogStatus.FAIL, "User is not able to see the upload content in the all uploads section");
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Exception Message:"+e.getLocalizedMessage());
			Assert.fail("User is not able to see the upload content in the all uploads section, Exception"+e.getLocalizedMessage());

		}

	}


}

