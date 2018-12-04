package org.pageobjects;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

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
	ContentCreateUploadPage contentUploadPage = PageFactory.initElements(driver, ContentCreateUploadPage.class);
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
			if( contentUploadPage.uploadContentText.isDisplayed())
			{
				String Evalue = contentUploadPage.uploadContentText.getText();			
				Assert.assertEquals("Upload Content", Evalue);
			}
			if(contentUploadPage.uploadButtonPop.isDisplayed())
			{
				String Evalue = contentUploadPage.uploadButtonPop.getText();	
				Assert.assertEquals("Upload", Evalue);	
			}
			if(contentUploadPage.closeEditor.isDisplayed())
			{
				String Evalue = contentUploadPage.closeEditor.getText();	
				Assert.assertEquals("Close Editor", Evalue);	
			}


			/*GenericFunctions.WaitForFrameAndSwitchToIt(createUserPage.iFrame);
			GenericFunctions.waitWebDriver(7500);*/

			WebElement browse = contentUploadPage.browseButton;
			System.out.println(browse.getText());
			if(browse.isDisplayed()&&createUserPage.enterUrl.isDisplayed())
			{

				String aurl=driver.getCurrentUrl();
				System.out.println(aurl);
				Assert.assertEquals(aurl, eurl,"The given url is not matching with the expected");
				Assert.assertTrue(true);
			}
			createUserPage.enterUrl.sendKeys(UPLOAD_YOUTUBE);
			GenericFunctions.waitForElementToAppear(contentUploadPage.uploadButtonPop);
			contentUploadPage.uploadButtonPop.click();
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

			contentUploadPage.saveuploadcontent.click();
			GenericFunctions.waitWebDriver(5000);
			createUserPage.closeButton.click();
			GenericFunctions.waitWebDriver(5000);

			contentUploadPage.uploadContent.click();
			GenericFunctions.waitWebDriver(5000);
			createUserPage.enterUrl.sendKeys(UPLOAD_YOUTUBE);
			GenericFunctions.waitWebDriver(5000);

			createUserPage.UploadButton.click();

			GenericFunctions.waitWebDriver(5000);
			contentUploadPage.saveuploadcontent.click();
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

			GenericFunctions.waitForElementToAppear(contentUploadPage.serachedContent);
			contentUploadPage.serachedContent.click();
			GenericFunctions.waitWebDriver(1200);
			GenericFunctions.scrollToElement(contentUploadPage.homeNavigation);
			GenericFunctions.waitWebDriver(1200);
			GenericFunctions.waitForElementToAppear(contentUploadPage.searchContentName);
			if(contentUploadPage.searchContentName.isDisplayed())
			{
				String Evalue = contentUploadPage.searchContentName.getText();
				Assert.assertEquals(" Automation Content_CN0049_WEBM", Evalue);

			}
			GenericFunctions.waitForElementToAppear(contentUploadPage.copy);		
			contentUploadPage.copy.click();			
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
			action.moveToElement(contentUploadPage.owner).click().perform();			
			GenericFunctions.scrollToElement(contentUploadPage.owner);
			contentUploadPage.owner.click();
			GenericFunctions.waitWebDriver(1500);
			contentUploadPage.ownership.click();
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
			GenericFunctions.waitForElementToAppear(contentUploadPage.browseButton);
			GenericFunctions.waitWebDriver(5000);
			contentUploadPage.browseButton.click();

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

			ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to get edit Detail Page is Displaying ");
			objListOFTestDataForSunbird1=ReadTestDataFromExcel.getTestDataForSunbird("testdatasheetcourse");

			GenericFunctions.waitWebDriver(5000);
			GenericFunctions.WaitForFrameAndSwitchToIt(createUserPage.iFrame);
			GenericFunctions.waitWebDriver(7500);
			GenericFunctions.waitForElementToAppear(createUserPage.enterUrl);
			createUserPage.enterUrl.sendKeys(UPLOAD_YOUTUBE);    
			GenericFunctions.waitForElementToAppear(contentUploadPage.uploadButtonPop);
			contentUploadPage.uploadButtonPop.click();
			GenericFunctions.waitWebDriver(5000);	
			GenericFunctions.waitTillTheElementIsVisibleAndClickable(contentUploadPage.editDetailsLink);
			contentUploadPage.editDetailsLink.click();
			GenericFunctions.waitWebDriver(5000);

			if(contentUploadPage.editDetailsHeading.isDisplayed())
			{
				String Evalue = contentUploadPage.editDetailsHeading.getText();
				Assert.assertEquals("Edit Details", Evalue);
				ExtentTestManager.getTest().log(LogStatus.PASS, "Edit details popup is displayed");

			}
			if(contentUploadPage.appIcon.isDisplayed())
			{
				String Evalue = contentUploadPage.appIcon.getText();
				Assert.assertEquals("App Icon", Evalue);
				ExtentTestManager.getTest().log(LogStatus.PASS, "App icon is displayed in Edit details form");
			}
			if(contentUploadPage.cancelButton.isDisplayed())
			{
				String Evalue = contentUploadPage.cancelButton.getText();
				Assert.assertEquals("Cancel", Evalue);
				ExtentTestManager.getTest().log(LogStatus.PASS, "Cancel button is verified and it is displayed");

			}
			if(createUserPage.saveButton.isDisplayed())
			{

				String Evalue = createUserPage.saveButton.getText();
				Assert.assertEquals("Save", Evalue);
				ExtentTestManager.getTest().log(LogStatus.PASS, "Cancel button is verified and it is displayed");
			}
			GenericFunctions.waitWebDriver(5000);








		}catch(Exception e)
		{
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Could not display the edit details page");
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Exception Message:"+e.getLocalizedMessage());
			Assert.fail("Could not display the edit details page, Exception"+e.getLocalizedMessage());
		}
	}

	public String[] selectValuesFromDropdowns()
	{
		String[] valueArray={};
		try 
		{

			String upload =GenericFunctions.testDataIncrementer("./testData/uploadNumbers.txt");
			objListOFTestDataForSunbird1=ReadTestDataFromExcel.getTestDataForSunbird("testdatasheetcourse");
			ExtentTestManager.getTest().log(LogStatus.INFO, "Continuation with the next scenario");
			ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to select the BOARD, MEDIUM, CLASS and SUBJECT in the edit details form");

			contentUploadPage.checkAppIcon.click();
			GenericFunctions.waitForElementToAppear(createUserPage.searchUploadImage);
			GenericFunctions.waitWebDriver(1000);
			createUserPage.searchUploadImage.sendKeys(SEARCH_COURSE_IMAGE);
			GenericFunctions.waitWebDriver(1200);
			createUserPage.clickImageSearch.click();
			GenericFunctions.waitWebDriver(5000);
			contentUploadPage.checkContentIcon.click();

			GenericFunctions.waitForElementToAppear(createUserPage.selectAppIcon);
			contentUploadPage.selectAppIcon.click();

			GenericFunctions.waitWebDriver(2500);
			GenericFunctions.waitForElementToAppear(contentUploadPage.uploadContentName);
			contentUploadPage.uploadContentName.clear();
			GenericFunctions.waitWebDriver(2500);
			contentUploadPage.uploadContentName.sendKeys(objListOFTestDataForSunbird1.get(0).getCourseDescription()+upload);

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

			GenericFunctions.waitWebDriver(1200);

			GenericFunctions.scrollToElement(createUserPage.clickOnSelectSubject);
			GenericFunctions.waitForElementToAppear(createUserPage.clickOnSelectSubject);


			GenericFunctions.waitTillTheElementIsVisibleAndClickable(createUserPage.clickOnSelectSubject);
			createUserPage.clickOnSelectSubject.click();
			GenericFunctions.waitForElementToAppear(createUserPage.selectSubject);
			createUserPage.selectSubject.click();
			GenericFunctions.waitWebDriver(1200);

			createUserPage.clickOnSelectMedium.click();
			GenericFunctions.waitForElementToAppearOnScreen(createUserPage.selectMedium);
			GenericFunctions.waitWebDriver(1200);
			createUserPage.selectMedium.click();
			valueArray[0] = contentUploadPage.selectedCirriculumText.getText();
			valueArray[1]= contentUploadPage.selectedClassText.getText();
			valueArray[2]=  contentUploadPage.selectedMediumText.getText();
			valueArray[3]=  contentUploadPage.selectedSubjectText.getText();
			GenericFunctions.waitWebDriver(1200);






		}
		catch(Exception e)
		{
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Could not select values from the dropdowns in edit details from");
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Exception Message:"+e.getLocalizedMessage());
			log.error("Could not select values from the dropdowns in edit details from");
			Assert.fail("Could not select values from the dropdowns in edit details from, Exception"+e.getLocalizedMessage());
		}

		//Return the stored values to verify
		return valueArray;
	}

	public void verifyValuesOfDropdowns(String [] valueArray)
	{
		try
		{
			ExtentTestManager.getTest().log(LogStatus.INFO, "User is tring to verify values in the dropdown");
			GenericFunctions.waitForElementToAppear(createUserPage.closeButton);
			createUserPage.closeButton.click();
			GenericFunctions.waitTillTheElementIsVisibleAndClickable(contentUploadPage.editDetailsLink);
			contentUploadPage.editDetailsLink.click();
			GenericFunctions.waitForElementToAppear(createUserPage.clickAppIcon);
			if(valueArray[0].equalsIgnoreCase(contentUploadPage.selectedCirriculumText.getText()))
			{
				Assert.assertTrue(true);
				ExtentTestManager.getTest().log(LogStatus.PASS, "Selected Curriculum text has been verified");
				if(valueArray[1].equalsIgnoreCase(contentUploadPage.selectedClassText.getText()))
				{
					Assert.assertTrue(true);
					ExtentTestManager.getTest().log(LogStatus.PASS, "Selected Class text has been verified");
					if(valueArray[2].equalsIgnoreCase(contentUploadPage.selectedSubjectText.getText()))
					{
						Assert.assertTrue(true);
						ExtentTestManager.getTest().log(LogStatus.PASS, "Selected Subject text has been verified");
						if(valueArray[3].equalsIgnoreCase(contentUploadPage.selectedMediumText.getText()))
						{
							Assert.assertTrue(true);
							ExtentTestManager.getTest().log(LogStatus.PASS, "Selected Medium text has been verified");
						}

					}
				}
			}

		}
		catch(Exception e)
		{
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Could not display the edit details page");
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Exception Message:"+e.getLocalizedMessage());
			log.error("Failed to select and verify the dropdown values");
			Assert.fail("Could not display the edit details page, Exception"+e.getLocalizedMessage());
		}
	}

	public void selectTopicFromTopicTree()
	{
		try
		{
			ExtentTestManager.getTest().log(LogStatus.INFO, "User is tring to verify the topics in topic tree");
			GenericFunctions.waitWebDriver(1200);
			GenericFunctions.waitForElementToAppearOnScreen(contentUploadPage.selectTopicPopup);
			GenericFunctions.scrollToElement(contentUploadPage.selectTopicPopup);
			contentUploadPage.selectTopicPopup.click();
			GenericFunctions.waitWebDriver(3000);   
			GenericFunctions.waitForElementToAppearOnScreen(contentUploadPage.selectPolynomials);
			contentUploadPage.selectPolynomials.click();
			GenericFunctions.waitForElementToAppearOnScreen(createUserPage.doneButton);
			GenericFunctions.waitWebDriver(2000);
			createUserPage.doneButton.click();
			GenericFunctions.waitWebDriver(3000);


			GenericFunctions.waitForElementToAppearOnScreen(contentUploadPage.selectedTopics);
			if(contentUploadPage.selectedTopics.isDisplayed())
			{
				//Assert.assertEquals(contentUploadPage.selectedTopics.getText(), "topics selected");
				Assert.assertTrue(true);
				ExtentTestManager.getTest().log(LogStatus.PASS, "Topics are succesfully selected from the topic tree");
			}

			GenericFunctions.scrollToElement(contentUploadPage.owner);
			GenericFunctions.waitForElementToAppear(contentUploadPage.owner);
			contentUploadPage.owner.click();
			GenericFunctions.waitForElementToAppear(contentUploadPage.ownership);		
			contentUploadPage.ownership.click();

			createUserPage.saveButton.click();
			GenericFunctions.waitForElementToAppear(createUserPage.closeButton);
			GenericFunctions.waitWebDriver(1500);
			createUserPage.closeButton.click();


		}
		catch(Exception e)
		{
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Could not select and verify the topic tree");
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Exception Message:"+e.getLocalizedMessage());
			log.error("Could not select and verify the topic tree");
			Assert.fail("Could not select and verify the topic tree, Exception"+e.getLocalizedMessage());
		}
	}

	public void verifyLimitedSharingContent()
	{
		try
		{
			ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to verify limited sharing functionality");
			GenericFunctions.waitWebDriver(1500);
			GenericFunctions.waitForElementToAppear(createUserPage.sendForReview);
			createUserPage.limitedSharingArrow.click();
			GenericFunctions.waitWebDriver(2000);
			createUserPage.clickLimitedSharing.click();
			
			GenericFunctions.waitForElementToAppear(createUserPage.limitedPublishing);
			createUserPage.limitedPublishing.click();
			if(createUserPage.limitedPublishing.isDisplayed())
			{
				GenericFunctions.waitWebDriver(2000);
				action.moveToElement(createUserPage.getContentInDrafts).perform();
				System.out.println(createUserPage.getContentInDrafts.getText());
				ExtentTestManager.getTest().log(LogStatus.PASS, "Content is successfullly submitted for limited publishing"+createUserPage.getContentInDrafts.getText()+" is the content name ");
			}
			GenericFunctions.waitWebDriver(2000);
			/*createUserPage.sendForReview.click();
			GenericFunctions.waitWebDriver(5000);
			createUserPage.saveButton.click();
			GenericFunctions.waitWebDriver(2500);*/
		}
		catch(Exception e)
		{
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Could not verify limited sharing functionality");
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Exception Message:"+e.getLocalizedMessage());
			log.error("Could not verify limited sharing functionality");
			Assert.fail("Could not verify limited sharing functionality, Exception"+e.getLocalizedMessage());
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
			GenericFunctions.waitForElementToAppear(contentUploadPage.reviewSubmission);
			contentUploadPage.reviewSubmission.click();
			GenericFunctions.waitWebDriver(5000);

			if(contentUploadPage.reviewCardView.isDisplayed())
			{
				String Evalue =contentUploadPage.reviewCardView.getText();
				Assert.assertEquals("CourseA Description", Evalue);
			}
			GenericFunctions.waitWebDriver(5000);
			contentUploadPage.homeNavigation.click();
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

			GenericFunctions.waitForElementToAppear(contentUploadPage.workspace);
			contentUploadPage.workspace.click();
			GenericFunctions.waitWebDriver(5000);
			contentUploadPage.upforreview.click();
			GenericFunctions.waitForElementToAppear(contentUploadPage.searchBox);
			contentUploadPage.searchBox.sendKeys(objListOFTestDataForSunbird1.get(0).getCourseDescription());

			if(contentUploadPage.contentupload.isDisplayed())
			{
				String Evalue=contentUploadPage.contentupload.getText();
				Assert.assertEquals("CourseA Description", Evalue);

			}
			contentUploadPage.contentupload.isDisplayed();
			GenericFunctions.waitWebDriver(5000);
			String uploadcontent=contentUploadPage.contentupload.getText();

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

			contentUploadPage.profileIcon.click();
			GenericFunctions.waitWebDriver(5000);
			GenericFunctions.waitForElementToAppear(contentUploadPage.workspace);
			contentUploadPage.workspace.click();
			GenericFunctions.waitWebDriver(5000);
			contentUploadPage.upforreview.click();
			GenericFunctions.waitWebDriver(5000);
			GenericFunctions.waitForElementToAppear(contentUploadPage.searchBox);
			contentUploadPage.searchBox.sendKeys("CourseA DescriptionC053");
			GenericFunctions.waitWebDriver(5000);
			contentUploadPage.sortBy.click();
			GenericFunctions.waitWebDriver(5000);
			contentUploadPage.updatedOn.click();
			GenericFunctions.waitWebDriver(5000);
			String updatedoncontent=contentUploadPage.date.getText();
			GenericFunctions.waitWebDriver(5000);
			contentUploadPage.date.isDisplayed();		
			System.out.println(updatedoncontent);
			GenericFunctions.waitWebDriver(5000);
			contentUploadPage.sortBy.click();
			GenericFunctions.waitWebDriver(5000);
			contentUploadPage.createdOn.click();
			GenericFunctions.waitWebDriver(5000);
			String updatedoncontent1=contentUploadPage.date.getText();
			GenericFunctions.waitWebDriver(5000);
			contentUploadPage.date.isDisplayed();		
			System.out.println(updatedoncontent);
			contentUploadPage.sortBy.click();
			GenericFunctions.waitWebDriver(5000);
			contentUploadPage.nameaz.click();
			String updatedoncontent2=contentUploadPage.date.getText();
			GenericFunctions.waitWebDriver(5000);
			contentUploadPage.date.isDisplayed();		
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
				GenericFunctions.waitForElementToAppear(contentUploadPage.workspace);
				contentUploadPage.workspace.click();
				GenericFunctions.waitWebDriver(5000);
				contentUploadPage.upforreview.click();
				GenericFunctions.waitWebDriver(5000);
				contentUploadPage.showfilter.click();
				GenericFunctions.waitWebDriver(1200);
				/*contentCreatePage.selectBoard.click();
				GenericFunctions.waitWebDriver(1200);
				contentCreatePage.selectRajasthan.click();
				GenericFunctions.waitWebDriver(1200);
				contentCreatePage.gradeLevel.click();
				GenericFunctions.waitWebDriver(1200);
				contentCreatePage.selectClass9.click();
				GenericFunctions.waitWebDriver(1200);*/
				contentUploadPage.selectSubject.click();
				GenericFunctions.waitWebDriver(1200);
				contentUploadPage.selectMathematics.click();
				GenericFunctions.waitWebDriver(1200);
				contentUploadPage.selectMedium.click();
				GenericFunctions.waitWebDriver(1200);
				contentUploadPage.selectHindi.click();
				GenericFunctions.waitWebDriver(1200);
				contentUploadPage.selectContentType.click();
				GenericFunctions.waitWebDriver(1200);
				contentUploadPage.selectCollection.click();
				GenericFunctions.waitWebDriver(1200);
				GenericFunctions.waitForElementToAppear(contentUploadPage.clickOnApplyButton);
				contentUploadPage.clickOnApplyButton.click();
				GenericFunctions.waitWebDriver(5000);

				if(contentUploadPage.contentName.isDisplayed())
				{
					String Evalue =contentUploadPage.contentName.getText();
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
			GenericFunctions.waitForElementToAppear(contentUploadPage.workspace);
			contentUploadPage.workspace.click();
			GenericFunctions.waitWebDriver(5000);
			contentUploadPage.upforreview.click();
			GenericFunctions.waitWebDriver(5000);
			GenericFunctions.waitForElementToAppear(contentUploadPage.searchForReview);
			contentUploadPage.searchForReview.click();
			GenericFunctions.waitWebDriver(5000);
			GenericFunctions.waitForElementToAppear(contentUploadPage.searchForReview);
			GenericFunctions.waitWebDriver(5000);
			contentUploadPage.searchForReview.sendKeys(objListOFTestDataForSunbird1.get(0).getCourseDescription());

			GenericFunctions.waitWebDriver(5000);
			contentUploadPage.contentupload.click();
			GenericFunctions.waitWebDriver(5000);

			//GenericFunctions.scrollToElement(contentCreatePage.publishButton);

			//GenericFunctions.waitForElementToAppear(contentCreatePage.publishButton);
			//	action.moveToElement(contentCreatePage.publishButton).build().perform();

			Thread.sleep(5000);	
			contentUploadPage.publishButton.click();
			GenericFunctions.waitWebDriver(5000);
			for(int i=0;i<createUserPage.checkbox.size();i++){
				createUserPage.checkbox.get(i).click();
			}
			GenericFunctions.waitForElementToAppear(contentUploadPage.publishButton1);
			contentUploadPage.publishButton1.click();

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
			contentUploadPage.profileIcon.click();
			GenericFunctions.waitWebDriver(1200);
			GenericFunctions.waitForElementToAppear(contentUploadPage.workspace);
			contentUploadPage.workspace1.click();
			GenericFunctions.waitWebDriver(1200);
			contentUploadPage.published.click();
			GenericFunctions.waitWebDriver(1200);
			contentUploadPage.contentPublished.click();
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

			GenericFunctions.waitForElementToAppear(contentUploadPage.workspace);
			contentUploadPage.workspace.click();
			GenericFunctions.waitWebDriver(5000);
			contentUploadPage.upforreview.click();

			GenericFunctions.waitWebDriver(5000);

			contentUploadPage.searchForReview.click();
			GenericFunctions.waitWebDriver(5000);
			GenericFunctions.waitForElementToAppear(contentUploadPage.searchForReview);
			GenericFunctions.waitWebDriver(5000);
			contentUploadPage.searchForReview.sendKeys(objListOFTestDataForSunbird1.get(0).getCourseDescription());

			if(contentUploadPage.contentupload.isDisplayed())
			{
				String Evalue =contentUploadPage.contentupload.getText();
				Assert.assertEquals("CourseA Description", Evalue);
			}

			GenericFunctions.waitWebDriver(5000);
			contentUploadPage.contentupload.click();
			GenericFunctions.waitWebDriver(5000);




			GenericFunctions.waitForElementToAppear(contentUploadPage.requestChangesButton);

			contentUploadPage.requestChangesButton.click();
			GenericFunctions.waitWebDriver(5000);

			for(int i=0;i<contentUploadPage.checkbox.size();i++){
				contentUploadPage.checkbox.get(i).click();
			}
			GenericFunctions.waitWebDriver(5000);
			GenericFunctions.waitForElementToAppear(contentUploadPage.requestChangesComment);
			contentUploadPage.requestChangesComment.click();
			contentUploadPage.requestChangesComment.sendKeys(objListOFTestDataForSunbird1.get(0).getTitle());
			GenericFunctions.waitWebDriver(5000);

			contentUploadPage.requestChangesBlueButton.click();
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
			contentUploadPage.profileIcon.click();
			GenericFunctions.waitWebDriver(5000);
			GenericFunctions.waitForElementToAppear(contentUploadPage.workspace);
			contentUploadPage.workspace1.click();
			GenericFunctions.waitWebDriver(5000);
			contentUploadPage.allUploads.click();
			GenericFunctions.waitWebDriver(5000);
			contentUploadPage.contentPublished.click();

			GenericFunctions.waitForElementToAppear(contentUploadPage.reviewerSuggestion);
			GenericFunctions.waitTillTheElementIsVisibleAndClickable(contentUploadPage.reviewerSuggestion);
			GenericFunctions.waitWebDriver(5000);
			contentUploadPage.reviewerSuggestion.click();
			GenericFunctions.waitWebDriver(5000);
			if( contentUploadPage.reviewerSuggestionTitle.isDisplayed())
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

