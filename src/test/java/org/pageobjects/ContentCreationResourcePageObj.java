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
import org.generic.ExtentTestManager;
import org.generic.GenericFunctions;
import org.generic.ReadTestDataFromExcel;
//import org.generic.SoftAssert;
import org.page.ContentCreationResourcePage;
import org.page.CreateMentorPage;
import org.page.CreatorUserPage;
import org.page.PublicUserPage;
import org.page.SignUpPage;
import org.page.UploadOrgPage;
import org.startup.BaseTest;
import org.testdata.TestDataForSunbird;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;


import com.relevantcodes.extentreports.LogStatus;

public class ContentCreationResourcePageObj extends BaseTest
{
	WebDriverWait wait = new WebDriverWait(driver,20);
	CreatorUserPage createUserPage=PageFactory.initElements(driver, CreatorUserPage.class);
	PublicUserPage publicUserPage = PageFactory.initElements(driver, PublicUserPage.class);
	CreateMentorPage createMentorPage=PageFactory.initElements(driver, CreateMentorPage.class);
	UploadOrgPage orgUploadPage=PageFactory.initElements(driver, UploadOrgPage.class);
	SignUpPage signUpPage=PageFactory.initElements(driver, SignUpPage.class);
	ContentCreationResourcePage contentResourcePage =PageFactory.initElements(driver,ContentCreationResourcePage.class);
	static Logger log = Logger.getLogger(CreatorUserPageObj.class.getName());
	List <TestDataForSunbird> objListOFTestDataForSunbird1= null ;
	Actions action = new Actions(driver);
	Random rand=new Random();
	public Robot r;

	/*public ContentCreationResourcePageObj() throws AWTException
	{
		Robot r = new Robot();

	}*/
	public void verifyProfileIconAndWorkspace()
	{
		try
		{
			ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to validate the features under Profile Icon");
			GenericFunctions.waitForElementToAppear(createUserPage.headerDropdown);
			createUserPage.headerDropdown.click();
			GenericFunctions.waitForElementToAppear(contentResourcePage.profileIconWorkspace);
			if(contentResourcePage.profileIconWorkspace.isDisplayed()&&contentResourcePage.profileIconActivity.isDisplayed()
					&&contentResourcePage.profileIconLogout.isDisplayed()&&contentResourcePage.profileIconProfile.isDisplayed())
			{
				Assert.assertTrue(true);
				System.out.println(contentResourcePage.profileIconProfile);
				System.out.println(contentResourcePage.profileIconWorkspace);
				System.out.println(contentResourcePage.profileIconActivity);
				System.out.println(contentResourcePage.profileIconLogout);
				ExtentTestManager.getTest().log(LogStatus.INFO, "Profile ,Workspace, My Activity and Logout features are verified on clicking Profile Icon");
				System.out.println("Test case 72 is passed");
			}
			else
			{
				System.out.println("Could not verify elements");
				log.info("Could not verify elements");
			}
		}
		catch(Exception e)
		{
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed on validating the features under Profile Icon");
			ExtentTestManager.getTest().log(LogStatus.FAIL,"Exception Message: "+e.getLocalizedMessage());
			System.out.println("Failed on validating the features under Profile Icon");
			Assert.fail("Failed on validating the features under Profile Icon");
		}	



	}

	public void verifyWorkspaceAndFeatures()
	{
		try
		{

			ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to validate all the features/Options under Workspace");
			System.out.println("Continuation of Test case 73");
			GenericFunctions.waitWebDriver(2000);
			contentResourcePage.profileIconWorkspace.click();
			GenericFunctions.waitWebDriver(500);
			String eUrl="https://staging.open-sunbird.org/workspace/content/create";
			String aUrl=driver.getCurrentUrl();

			if(createUserPage.createBook.isDisplayed()&&createUserPage.createCourse.isDisplayed()&&createUserPage.createResource.isDisplayed()
					&&createUserPage.createLesson.isDisplayed()&&createUserPage.createCollection.isDisplayed()&&createUserPage.createUploadContent.isDisplayed())
			{
				Assert.assertEquals(aUrl, eUrl, "Failed on validating Url");
				Assert.assertTrue(true);
				System.out.println("Book"+"\n"+"Course"+"\n"+"Resource"+"\n"+"Collection"+"\n"+"Lesson plan"+"\n"+"Upload Content"+"\n"+" Elements are present under CREATE Bucket in Workspace");
				GenericFunctions.waitWebDriver(2000);
				contentResourcePage.allMyActivity.click();
				GenericFunctions.waitForElementToAppear(contentResourcePage.showFilters);
				if(contentResourcePage.showFilters.isDisplayed())
				{
					GenericFunctions.waitWebDriver(1500);
					contentResourcePage.showFilters.click();
					GenericFunctions.waitWebDriver(500);
					if(contentResourcePage.filterApplyButton.isDisplayed()&&contentResourcePage.filterResetButton.isDisplayed())
					{
						contentResourcePage.sortByIcon.click();
						GenericFunctions.waitWebDriver(1000);
						Assert.assertTrue(true);
						System.out.println("Filters"+"\n"+"APPLY BUTTON"+"\n"+"RESET BUTTON"+"\n"+"Sort By"+"\n"+"Features and buttons are displayed successfully under All My Content Bucket");
						System.out.println("Test 73 is passed");
					}

				}
				else
				{
					System.out.println(contentResourcePage.showFilters+" element is not displayed under All My Content bucket");
				}

			}
			else
			{
				System.out.println("Elements under Workspace are not displaying and failed to verify elements");
			}

		}
		catch(Exception e)
		{
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed on navigating to Workspace and verifying elements");
			ExtentTestManager.getTest().log(LogStatus.FAIL,"Exception Message: "+e.getLocalizedMessage());
			System.out.println("Failed on navigating to Workspace and verifying elements");
			Assert.fail("Failed on navigating to Workspace and verifying elements");
		}
	}

	public String navigateToLibraryAndSearchContent(String inputToSearch)
	{
		String search="";
		try 
		{
			ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to navigate to Library and search "+inputToSearch); 
			objListOFTestDataForSunbird1 = ReadTestDataFromExcel.getTestDataForSunbird("testdatasheetcourse");
			//createUserPage.dropDown.click();
			GenericFunctions.waitForElementToAppear(createUserPage.headerLibrary);
			createUserPage.headerLibrary.click();
			GenericFunctions.waitForElementToAppear(createUserPage.searchInput);
			createUserPage.searchInput.click();
			if(inputToSearch.contains("resource"))
			{
				search=objListOFTestDataForSunbird1.get(6).getCourseName();
				createUserPage.searchInput.sendKeys(search);
			}
			else if(inputToSearch.contains("book"))
			{
				search=objListOFTestDataForSunbird1.get(2).getCourseName();
				createUserPage.searchInput.sendKeys(search);
			}
			else if(inputToSearch.contains("collection"))
			{
				search=objListOFTestDataForSunbird1.get(5).getCourseName();
				createUserPage.searchInput.sendKeys(search);
			}
			//+"_"+GenericFunctions.readFromNotepad(".//TestData//contentNumbers.txt"));
			System.out.println(inputToSearch);//+"_"+GenericFunctions.readFromNotepad(".//TestData//contentNumbers.txt"));
			createUserPage.searchIcon.click();
			GenericFunctions.waitWebDriver(2500);
			GenericFunctions.waitForElementToAppear(createUserPage.getCourseName);
			createUserPage.getCourseName.click();
		}
		catch(Exception e)
		{
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed to navigate to Library and search content");
			ExtentTestManager.getTest().log(LogStatus.FAIL,"Exception Message: "+e.getLocalizedMessage());
			Assert.fail("Could not Navigate to library and search the content, Exception"+e.getLocalizedMessage());

		}
		return inputToSearch;
	}

	public void copyContentAndValidate(String contentType)
	{
		String searchedBookName="";
		try
		{
			ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to search content in Library and copy it");
			if(contentType.equalsIgnoreCase("course"))
			{
				GenericFunctions.waitForElementToAppear(contentResourcePage.searchedClickedCourseResource);
				searchedBookName=contentResourcePage.searchedClickedCourseResource.getText();
				GenericFunctions.waitForElementToAppear(contentResourcePage.courseCopyIcon);
				contentResourcePage.courseCopyIcon.click();
			}
			else 
			{
				GenericFunctions.waitForElementToAppear(contentResourcePage.searchedClickedContent);
				searchedBookName=contentResourcePage.searchedClickedContent.getText();
				GenericFunctions.waitForElementToAppear(contentResourcePage.libContentCopyIcon);
				contentResourcePage.libContentCopyIcon.click();
			}
			GenericFunctions.waitWebDriver(2000);
			GenericFunctions.WaitForFrameAndSwitchToIt(createUserPage.iFrame);
			GenericFunctions.waitWebDriver(6500);
			GenericFunctions.waitForElementToAppear(contentResourcePage.copiedContentName);
			String aBookname=contentResourcePage.copiedContentName.getText();
			System.out.println(aBookname);
			if(aBookname.contains(searchedBookName))
			{
				ExtentTestManager.getTest().log(LogStatus.INFO, "Content is copied sucessfully");
				System.out.println(aBookname+" Content copied succesfully");
				GenericFunctions.waitWebDriver(2001);
				Assert.assertTrue(true);
			}
			else
			{
				ExtentTestManager.getTest().log(LogStatus.ERROR, "Could not copy Content");
				System.out.println("Could not copy Content");
			}
			createUserPage.editorCloseIcon.click();
			GenericFunctions.waitForElementToAppear(createUserPage.getCourseName);
			//createUserPage.getCourseName.click();
			String draftCopiedCN=createUserPage.getCourseName.getText();
			//GenericFunctions.waitForElementToAppear(contentResourcePage.draftCopiedContentName);
			//String draftCopiedCN=contentResourcePage.draftCopiedContentName.getText();
			if(aBookname.contains(draftCopiedCN))
			{
				ExtentTestManager.getTest().log(LogStatus.INFO, contentResourcePage.draftCopiedContentName.getText()+"Content is found in Draft");
				System.out.println(draftCopiedCN+" is the content present in the drafts");
				GenericFunctions.waitWebDriver(2001);
				//createUserPage.editorCloseIcon.click();
				Assert.assertTrue(true);
			}

		}
		catch(Exception e)
		{
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed to copy content and validate it");
			ExtentTestManager.getTest().log(LogStatus.FAIL,"Exception Message: "+e.getLocalizedMessage());
			Assert.fail("Failed to copy content and validate it"+e.getLocalizedMessage());

		}
	}

	public void valdiateContentEditor()

	{
		try
		{
			objListOFTestDataForSunbird1= ReadTestDataFromExcel.getTestDataForSunbird("testdatasheetcourse");
			ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to validate content editor");
			GenericFunctions.waitWebDriver(1500);
			GenericFunctions.waitForElementToAppear(createUserPage.bookName);
			String resourceNumber = GenericFunctions.testDataIncrementer(".//TestData//resourceNumbers.txt").toString();
			createUserPage.bookName.sendKeys(objListOFTestDataForSunbird1.get(6).getCourseName()+resourceNumber);
			GenericFunctions.waitWebDriver(2000);
			createUserPage.startCreating.click();
			GenericFunctions.waitWebDriver(7000);			
			GenericFunctions.WaitForFrameAndSwitchToIt(createUserPage.iFrame);
			GenericFunctions.waitWebDriver(4500);
			GenericFunctions.waitForElementToAppear(contentResourcePage.addSlide);
			if(createUserPage.saveCourse.isDisplayed()&&createUserPage.sendForReview.isDisplayed())
			{
				ExtentTestManager.getTest().log(LogStatus.INFO, "User is sucessfully navigated to Content editor and validated");
				System.out.println("User is sucessfully navigated to Content editor and validated");
				GenericFunctions.waitWebDriver(2500);
				/*createUserPage.editorCloseIcon.click();
				driver.switchTo().alert().accept();*/
				Assert.assertTrue(true);
			}
			else
			{
				ExtentTestManager.getTest().log(LogStatus.ERROR, "User failed to navigate to Content editor");
				System.out.println("User failed to navigate to Content editor");
			}
		}
		catch(Exception e)
		{
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed to create resource and validate content editor");
			ExtentTestManager.getTest().log(LogStatus.FAIL,"Exception Message: "+e.getLocalizedMessage());
			Assert.fail("Failed to create resource and  validate content editor"+e.getLocalizedMessage());

		}
	}

	public void verifyResourcePluginsAndContents()
	{
		try
		{
			objListOFTestDataForSunbird1= ReadTestDataFromExcel.getTestDataForSunbird("testdatasheetcourse");
			ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to verify the contents and plugins for creating resource");
			ExtentTestManager.getTest().log(LogStatus.INFO, "Continuation with Test case 76");
			GenericFunctions.waitWebDriver(500);
			//Adding the contents and plugins present on Top bar

			//Adding Slide
			addSlides(1);

			//Add Text
			addText();

			//Adding shapes


			//Adding Image
			addImage();


			//Adding hotspot
			contentResourcePage.addHotspot.click();
			GenericFunctions.waitWebDriver(300);

			//Adding scribblepad
			contentResourcePage.addScribblepad.click();
			GenericFunctions.waitWebDriver(500);

			//Adding Question Set
			createQuestion();
			GenericFunctions.waitWebDriver(500);

			//Adding Math Plugin
			addMathPlugin();

			//Adding multiple Slides
			contentResourcePage.addSlide.click();
			GenericFunctions.waitWebDriver(500);
			contentResourcePage.addSlide.click();

			//Click on save button for saving the resource
			createUserPage.saveCourse.click();

		}
		catch(Exception e)
		{
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed to validate contents and plugins for creating resources");
			ExtentTestManager.getTest().log(LogStatus.FAIL,"Exception Message: "+e.getLocalizedMessage());
			System.out.println("Failed to validate contents and plugins for creating resources "+e.getLocalizedMessage());
			Assert.fail("Failed to validate contents and plugins for creating resources"+e.getLocalizedMessage());
		}
	}

	public void addShapes()
	{
		GenericFunctions.waitForElementToAppear(contentResourcePage.addShapes);
		contentResourcePage.addShapes.click();
		GenericFunctions.waitWebDriver(500);
		contentResourcePage.addTriangleShape.click();
		GenericFunctions.waitWebDriver(3000);
	}

	public void addText()
	{
		//Adding text
		GenericFunctions.waitForElementToAppear(contentResourcePage.addText);
		contentResourcePage.addText.click();
		contentResourcePage.addTextTextArea.sendKeys(objListOFTestDataForSunbird1.get(10).getCourseName());
		GenericFunctions.waitWebDriver(500);
		contentResourcePage.addTextDoneButton.click();
		GenericFunctions.waitWebDriver(500);
	}

	public void addImage()
	{
		//Adding Image
		GenericFunctions.waitForElementToAppear(contentResourcePage.addImage);
		contentResourcePage.addImage.click();
		GenericFunctions.waitForElementToAppear(createUserPage.searchUploadImage);
		createUserPage.searchUploadImage.sendKeys(SEARCH_RESOURCE_IMAGE);
		createUserPage.clickImageSearch.click();
		GenericFunctions.waitTillTheElementIsVisibleAndClickable(contentResourcePage.checkContentIcon);
		contentResourcePage.checkContentIcon.click();
		GenericFunctions.waitWebDriver(2000);
		createUserPage.selectAppIcon.click();
		GenericFunctions.waitWebDriver(500);
	}

	public void addSlides_Image_Text(int noOfSlides,int testCaseName)
	{
		try
		{
			//objListOFTestDataForSunbird1= ReadTestDataFromExcel.getTestDataForSunbird("testdatasheetcourse");
			ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to add slides to the Resource");
			GenericFunctions.waitForElementToAppear(contentResourcePage.addSlide);
			for(int i=1;i<=noOfSlides;i++)
			{
				contentResourcePage.addSlide.click();
				if(i<=1)
				{
					addText();
				}
				else if(i==2 && i<=noOfSlides)
				{
					addImage();
				} 
				else if(i==3 && i<=noOfSlides)
				{
					addAudio();
				}
				else if(i==4 && i<=noOfSlides)
				{
					addVideo();
				}
				else if(i>4)
				{
					addShapes();
				}
			}	
			GenericFunctions.waitWebDriver(1000);
			contentResourcePage.propertiesSection.click();
			GenericFunctions.captureScreenshotOnValidation();
			ExtentTestManager.getTest().log(LogStatus.INFO, "User is able to view property section-completed Test case "+"testCaseName");
			contentResourcePage.clickNextSlide.click();

		}
		catch(Exception e)
		{
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed to add slides to resource");
			ExtentTestManager.getTest().log(LogStatus.FAIL,"Exception Message: "+e.getLocalizedMessage());
			System.out.println("Failed to add slides to resource "+e.getLocalizedMessage());
			Assert.fail("Failed to add slides to resource "+e.getLocalizedMessage());
		}
	}

	public void addSlides(int slidesToAdd)
	{
		try
		{
			ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to add "+slidesToAdd+ " slides to the Resource");
			GenericFunctions.waitForElementToAppear(contentResourcePage.addSlide);
			for(int i=1;i<=slidesToAdd;i++)
			{
				contentResourcePage.addSlide.click();
				if(i<=1)
				{
					addText();
				}
				else if(i==2 && i<=slidesToAdd)
				{
					addImage();
				} 
				else if(i==3 && i<=slidesToAdd)
				{
					addAudio();
				}
				else if(i==4 && i<=slidesToAdd)
				{
					addVideo();
				}
				else if(i>4)
				{
					addShapes();
				}
				GenericFunctions.waitWebDriver(500);
			}	
			contentResourcePage.clickNextSlide.click();
		}
		catch(Exception e)
		{
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed to add slides to resource");
			ExtentTestManager.getTest().log(LogStatus.FAIL,"Exception Message: "+e.getLocalizedMessage());
			System.out.println("Failed to add slides to resource "+e.getLocalizedMessage());
		}
	}
	public void previewSlides_AndFromBegining()
	{
		try
		{
			ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to preview the slides added to the content");
			int slidesToAdd=10;
			addSlides(slidesToAdd);
			GenericFunctions.waitForElementToAppear(contentResourcePage.previewIcon);
			contentResourcePage.previewIcon.click();
			GenericFunctions.waitForElementToAppear(contentResourcePage.previewPopup);
			if(contentResourcePage.previewPopup.isDisplayed())
			{
				GenericFunctions.WaitForFrameAndSwitchToIt(contentResourcePage.previewPopupFrame);
				GenericFunctions.waitForElementToAppear(contentResourcePage.previewNextBtn);
				for(int i=1;i<=slidesToAdd+3;i++)
				{
					contentResourcePage.previewNextBtn.click();
					GenericFunctions.waitWebDriver(500);
				}
				GenericFunctions.waitWebDriver(1500);
				if(contentResourcePage.contentPreiviewCompleteScreen.isDisplayed()&&contentResourcePage.previewPopupReplayBtn.isDisplayed())
				{
					//contentResourcePage.contentPreiviewCompleteScreen.getText();
					Assert.assertTrue(true);
					ExtentTestManager.getTest().log(LogStatus.INFO, "User completed previewing of all the slides(10) from Begining - Completed Test case 120 and 121");

					GenericFunctions.captureScreenshotOnValidation();
				}

			}
			GenericFunctions.waitWebDriver(2000);
			GenericFunctions.refreshWebPage();
			GenericFunctions.waitForElementToAppear(createUserPage.editorCloseIcon);
			createUserPage.editorCloseIcon.click();
		}
		catch(Exception e)
		{
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed to preview the slides of the content");
			ExtentTestManager.getTest().log(LogStatus.FAIL,"Exception Message: "+e.getLocalizedMessage());
			System.out.println("Failed to preview the slides of the content "+e.getLocalizedMessage());
			Assert.fail("Failed to preview the slides of the content "+e.getLocalizedMessage());
		}
		//GenericFunctions.WaitForFrameAndSwitchToIt(contentResourcePage.previewPopupFrame);

	}

	public void addMathPlugin()
	{
		//Adding Math plugin
		GenericFunctions.waitForElementToAppear(contentResourcePage.addMathText);
		contentResourcePage.addMathText.click();
		GenericFunctions.waitForElementToAppearOnScreen(contentResourcePage.selectMathText);
		contentResourcePage.selectMathText.click();
		contentResourcePage.selectedMathTextAdd.click();
		GenericFunctions.waitWebDriver(500);
		GenericFunctions.waitForElementToAppear(createUserPage.saveCourse);
		/*createUserPage.saveCourse.click();
		createUserPage.closeContentPopup.click();*/
	}

	public void addAudio()
	{
		//Adding Audio
		GenericFunctions.waitForElementToAppear(contentResourcePage.addAudio);
		contentResourcePage.addAudio.click();
		/*
		GenericFunctions.waitForElementToAppearOnScreen(contentResourcePage.selectMyAudio);
		contentResourcePage.selectMyAudio.click();
		 */
		GenericFunctions.waitForElementToAppearOnScreen(contentResourcePage.clickAllAudio);
		GenericFunctions.waitWebDriver(500);
		contentResourcePage.clickAllAudio.click();
		GenericFunctions.waitForElementToAppear(contentResourcePage.selectAudio_AllAudio);
		GenericFunctions.waitWebDriver(500);
		contentResourcePage.selectAudio_AllAudio.click();
		GenericFunctions.waitWebDriver(600);
		createUserPage.selectAppIcon.click();
		GenericFunctions.waitWebDriver(500);
	}

	public void addVideo()
	{
		GenericFunctions.waitForElementToAppear(contentResourcePage.addVideo);
		contentResourcePage.addVideo.click();
		GenericFunctions.waitForElementToAppear(contentResourcePage.pasteVideoUrl);
		contentResourcePage.pasteVideoUrl.sendKeys(VIDEO_UPLOAD);
		GenericFunctions.waitForElementToAppear(contentResourcePage.goButton);
		contentResourcePage.goButton.click();
		GenericFunctions.waitTillTheElementIsVisibleAndClickable(contentResourcePage.addToLessonBtn);
		GenericFunctions.waitWebDriver(3500);
		contentResourcePage.addToLessonBtn.click();
		GenericFunctions.waitWebDriver(1500);

	}

	public void addQuestionsPluginAudioVideo()
	{
		try
		{
			objListOFTestDataForSunbird1= ReadTestDataFromExcel.getTestDataForSunbird("testdatasheetcourse");
			ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to add Question set, Audio, Video and plugins to the resource");
			GenericFunctions.waitForElementToAppear(contentResourcePage.addQuestionSet);

			//Add Question set from existing list
			contentResourcePage.addQuestionSet.click();
			GenericFunctions.waitWebDriver(500);	
			//GenericFunctions.WaitForFrameAndSwitchToIt(createUserPage.iFrame);
			GenericFunctions.waitForElementToAppear(contentResourcePage.pickQuestion);
			contentResourcePage.pickQuestionCheckBox.click();
			GenericFunctions.waitWebDriver(1500);
			GenericFunctions.waitTillTheElementIsVisibleAndClickable(contentResourcePage.pickQueNextButton);
			contentResourcePage.pickQueNextButton.click();
			GenericFunctions.waitWebDriver(1500);
			GenericFunctions.waitForElementToAppear(contentResourcePage.questionSetTitle);
			contentResourcePage.questionSetTitle.sendKeys(objListOFTestDataForSunbird1.get(11).getCourseDescription());
			GenericFunctions.waitWebDriver(500);
			contentResourcePage.questionSetAddButton.click();
			GenericFunctions.waitWebDriver(1500);

			//Add plugins
			addMathPlugin();

			//Add Audio
			addAudio();

			//Add Video
			addVideo();

			GenericFunctions.waitForElementToAppear(createUserPage.saveCourse);
			createUserPage.saveCourse.click();
			GenericFunctions.waitForElementToAppear(createUserPage.closeContentPopup);
			createUserPage.closeContentPopup.click();
		}

		catch(Exception e)
		{
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed to add Question set, Audio, Video and plugins to the resource");
			ExtentTestManager.getTest().log(LogStatus.FAIL,"Exception Message: "+e.getLocalizedMessage());
			System.out.println("Failed to add Question set, Audio, Video and plugins to the resource "+e.getLocalizedMessage());
			Assert.fail("Failed to add Question set, Audio, Video and plugins to the resource "+e.getLocalizedMessage());
		}

	}

	public String verifyLimitedSharing(String contentType) throws Exception
	{
		String contentName="";
		try
		{
			ExtentTestManager.getTest().log(LogStatus.INFO, "User is verify the Limited sharing and share the content via the Share Icon");	
			Robot r = new Robot();
			GenericFunctions.waitWebDriver(1400);
			GenericFunctions.waitForElementToAppear(contentResourcePage.limitedSharingIcon);
			if(contentResourcePage.limitedSharingIcon.isDisplayed())//&&contentResourcePage.deleteIconLP.isDisplayed())
			{
				contentResourcePage.limitedSharingIcon.click();
				GenericFunctions.waitWebDriver(500);
				contentResourcePage.clickLimitedSharing.click();
				GenericFunctions.waitWebDriver(1500);
				GenericFunctions.waitForElementToAppear(createUserPage.getCourseName);
				contentResourcePage.limitedPublishing.click();
				GenericFunctions.waitForElementToAppear(createUserPage.getCourseName);
				GenericFunctions.waitWebDriver(500);
				GenericFunctions.waitForElementToAppear(contentResourcePage.contentShareIcon);
				GenericFunctions.waitForElementToAppear(contentResourcePage.deleteIconLP);
				if(contentResourcePage.contentShareIcon.isDisplayed()&&contentResourcePage.deleteIconLP.isDisplayed())
					contentResourcePage.contentShareIcon.click();
				GenericFunctions.waitWebDriver(600);
				//contentResourcePage.contentShareIcon.click();
				GenericFunctions.waitWebDriver(500);
				contentResourcePage.copyLinkBtn.click();
				if(contentResourcePage.copiedMessage.isDisplayed())
				{
					action.moveToElement(contentResourcePage.linkDataField).build().perform();
					action.contextClick(contentResourcePage.linkDataField).build().perform();
					GenericFunctions.waitWebDriver(1100);
					r.keyPress(KeyEvent.VK_DOWN);
					GenericFunctions.waitWebDriver(500);
					r.keyPress(KeyEvent.VK_DOWN);
					GenericFunctions.waitWebDriver(500);
					r.keyPress(KeyEvent.VK_ENTER);

					r.keyRelease(KeyEvent.VK_DOWN);
					r.keyRelease(KeyEvent.VK_DOWN);
					r.keyRelease(KeyEvent.VK_ENTER);

					GenericFunctions.waitWebDriver(2500);
					ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
					driver.switchTo().window(tabs2.get(1));//.get("https://staging.open-sunbird.org/resources/play/content/do_21259328104976384013190/Unlisted");

					if(contentType.equalsIgnoreCase("resource"))
					{
						GenericFunctions.waitForElementToAppear(contentResourcePage.resourceNameNewWindow);
						while(contentResourcePage.resourceNameNewWindow.isDisplayed())
						{
							ExtentTestManager.getTest().log(LogStatus.INFO, "The copied link is accessible to the user");
							Assert.assertTrue(true);
							driver.switchTo().window(tabs2.get(0));
							break;
						}
					}	
					else if(contentType.equalsIgnoreCase("collection"))
					{
						GenericFunctions.waitForElementToAppear(contentResourcePage.searchedClickedContent);
						while(contentResourcePage.searchedClickedContent.isDisplayed())
						{
							contentName=contentResourcePage.searchedClickedContent.getText();
							ExtentTestManager.getTest().log(LogStatus.INFO, "The copied link is accessible to the user");
							Assert.assertTrue(true);
							driver.switchTo().window(tabs2.get(0));
							break;
						}
						GenericFunctions.waitForElementToAppear(contentResourcePage.contentCloseIcon);
						contentResourcePage.contentCloseIcon.click();
					}

					/*while(contentResourcePage.resourceNameNewWindow.isDisplayed())
					{
							ExtentTestManager.getTest().log(LogStatus.INFO, "The copied link is accessible to the user");
							Assert.assertTrue(true);
							driver.switchTo().window(tabs2.get(0));
							break;
					}*/
					else
					{
						System.out.println("Could not switch to new Tab");
						ExtentTestManager.getTest().log(LogStatus.INFO, "Could not switch to new Tab");
					}
				}
				else
				{
					System.out.println("Could not copy the link");
					ExtentTestManager.getTest().log(LogStatus.INFO, "Could not copy the link");
				}
			}
			/*else if(contentType.equalsIgnoreCase("collection"))
				{

					GenericFunctions.waitForElementToAppear(contentResourcePage.deleteIconLP);
					contentResourcePage.deleteIconLP.click();
					GenericFunctions.waitWebDriver(2000);
					contentResourcePage.deletePopupYesBtn.click();
					GenericFunctions.waitWebDriver(2000);
					GenericFunctions.captureScreenshotOnValidation();
				}*/
			//ExtentTestManager.getTest().log(LogStatus.PASS,"Capture the Share popup"+log.addScreenCaptureFromPath());
			else 
			{
				System.out.println("Could not find Share and Delete icon");
				ExtentTestManager.getTest().log(LogStatus.INFO, "Could not find Share and Delete icon");
			}
			return contentName;
		}
		catch(Exception e)
		{
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed to verify Limited Share and Share resource via Share icon feature");
			ExtentTestManager.getTest().log(LogStatus.FAIL,"Exception Message: "+e.getLocalizedMessage());
			System.out.println("Failed to verify Limited Share and Share resource via Share icon feature "+e.getLocalizedMessage());
			Assert.fail("Failed to verify Limited Share and Share resource via Share icon feature "+e.getLocalizedMessage());
		}
		return contentName;
	}

	public void deleteFromLimitedPublishing()
	{
		try
		{
			ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to delete the content from Limited publishing bucket");	
			GenericFunctions.refreshWebPage();
			GenericFunctions.waitWebDriver(2000);
			GenericFunctions.waitForElementToAppear(ContentCreationResourcePage.deleteIconLP);
			ContentCreationResourcePage.deleteIconLP.click();
			GenericFunctions.waitForElementToAppear(ContentCreationResourcePage.deletePopupYesBtn);
			ContentCreationResourcePage.deletePopupYesBtn.click();
			GenericFunctions.waitWebDriver(2000);
			GenericFunctions.captureScreenshotOnValidation();
			Assert.assertTrue(true);
			ExtentTestManager.getTest().log(LogStatus.INFO, "content deleted succesfully from the limited publishing bucket");
		}
		catch(Exception e)
		{
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed to delete the content from Limited publishing bucket");
			ExtentTestManager.getTest().log(LogStatus.FAIL,"Exception Message: "+e.getLocalizedMessage());
			System.out.println("Failed to delete the content from Limited publishing bucket "+e.getLocalizedMessage());
			Assert.fail("Failed to delete the content from Limited publishing bucket "+e.getLocalizedMessage());
		}
	}
	public void editResourceDetails()
	{
		try
		{
			ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to edit details of Resource to verify Edit Details");	
			//GenericFunctions.WaitForFrameAndSwitchToIt(createUserPage.iFrame);
			System.out.println(contentResourcePage.editorEditDetails.getText());
			GenericFunctions.waitForElementToAppear(contentResourcePage.editorEditDetails);
			contentResourcePage.editorEditDetails.click();
			GenericFunctions.waitForElementToAppear(createUserPage.clickOnSelectCurriculum);
			createUserPage.clickOnSelectCurriculum.click();
			GenericFunctions.waitForElementToAppear(createUserPage.selectCurriculum);
			createUserPage.selectCurriculum.click();
			GenericFunctions.waitWebDriver(1000);
			createUserPage.clickOnSelectClass.click();
			GenericFunctions.waitForElementToAppear(createUserPage.selectClass);
			createUserPage.selectClass.click();
			GenericFunctions.waitWebDriver(1000);
			GenericFunctions.scrollToElement(createUserPage.clickOnSelectSubject);
			createUserPage.clickOnSelectSubject.click();
			GenericFunctions.waitForElementToAppear(contentResourcePage.selectSubject);
			contentResourcePage.selectSubject.click();
			GenericFunctions.waitWebDriver(1000);
			createUserPage.clickOnSelectMedium.click();
			GenericFunctions.waitForElementToAppear(contentResourcePage.selectMedium);
			contentResourcePage.selectMedium.click();
			GenericFunctions.waitForElementToAppear(contentResourcePage.clickTopics);
			contentResourcePage.clickTopics.click();
			//GenericFunctions.WaitForFrameAndSwitchToIt(createUserPage.iFrame);
			GenericFunctions.waitWebDriver(2700);
			GenericFunctions.waitForElementToAppear(contentResourcePage.selectTopic);
			GenericFunctions.waitWebDriver(1000);
			contentResourcePage.selectTopic.click();
			GenericFunctions.waitWebDriver(2000);
			contentResourcePage.topicsDoneBtn.click();
			GenericFunctions.waitForElementToAppear(createUserPage.saveButton);
			createUserPage.saveButton.click();
			GenericFunctions.waitForElementToAppear(createUserPage.closeContentPopup);
			createUserPage.closeContentPopup.click();

		}
		catch(Exception e)
		{
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed to edit details of the Resource in the Edit Details popup");
			ExtentTestManager.getTest().log(LogStatus.FAIL,"Exception Message: "+e.getLocalizedMessage());
			System.out.println("Failed to edit details of the Resource in the Edit Details popup "+e.getLocalizedMessage());
			Assert.fail("Failed to edit details of the Resource in the Edit Details popup "+e.getLocalizedMessage());
		}
	}

	public void createQuestion()
	{
		try
		{
			objListOFTestDataForSunbird1= ReadTestDataFromExcel.getTestDataForSunbird("testdatasheetcourse");
			ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to Create new Question set");
			GenericFunctions.waitForElementToAppear(contentResourcePage.addQuestionSet);
			contentResourcePage.addQuestionSet.click();
			GenericFunctions.waitForElementToAppear(contentResourcePage.pickQuestion);
			contentResourcePage.createQuestion.click();
			GenericFunctions.waitForElementToAppear(contentResourcePage.questionTemplateSelect);
			contentResourcePage.questionTemplateSelect.click();
			GenericFunctions.waitWebDriver(3500);
			//GenericFunctions.WaitForFrameAndSwitchToIt(createUserPage.iFrame);
			GenericFunctions.WaitForFrameAndSwitchToIt(contentResourcePage.enterQuestionIframe);
			contentResourcePage.enterTheQuestion.click();
			contentResourcePage.enterTheQuestion.sendKeys(objListOFTestDataForSunbird1.get(10).getCourseDescription());

			//Added here - change here
			//driver.switchTo().defaultContent();

			GenericFunctions.waitWebDriver(500);
			action.moveToElement(contentResourcePage.setAnswer0).sendKeys("OPTION 1").build().perform();

			//action.sendKeys("OPTION 1").build().perform();



			//GenericFunctions.WaitForFrameAndSwitchToIt(contentResourcePage.createQuestionFrame1);
			/*GenericFunctions.waitWebDriver(500);
			GenericFunctions.scrollToElement(contentResourcePage.setAnswer0);
			contentResourcePage.setAnswer0.click();
			contentResourcePage.setAnswer0.sendKeys(objListOFTestDataForSunbird1.get(10).getTitle());
			 */
			GenericFunctions.waitWebDriver(500);
			contentResourcePage.markAsRight.click();
			GenericFunctions.waitWebDriver(500);
			contentResourcePage.setAnswer1.click();
			contentResourcePage.setAnswer1.sendKeys(objListOFTestDataForSunbird1.get(10).getTitleDescription());
			GenericFunctions.waitWebDriver(500);
			contentResourcePage.createQueNext.click();
			GenericFunctions.waitForElementToAppear(createUserPage.clickOnSelectMedium);
			createUserPage.clickOnSelectMedium.click();
			GenericFunctions.waitWebDriver(500);
			createUserPage.selectMedium.click();
			contentResourcePage.clickLevel.click();
			GenericFunctions.waitWebDriver(500);
			contentResourcePage.selectLevel.click();
			contentResourcePage.clickGrade.click();
			GenericFunctions.waitWebDriver(500);
			contentResourcePage.selectGrade.click();
			contentResourcePage.clickSubject.click();
			GenericFunctions.waitWebDriver(500);
			contentResourcePage.selectSubject.click();
			contentResourcePage.clickBoard.click();
			GenericFunctions.waitWebDriver(500);
			contentResourcePage.selectBoard.click();
			GenericFunctions.scrollToElement(contentResourcePage.questionMaxScore);
			contentResourcePage.questionMaxScore.sendKeys(objListOFTestDataForSunbird1.get(11).getCourseDescription());
			GenericFunctions.waitWebDriver(500);

			//Concepts code in Add Question set
			contentResourcePage.clickConcepts.click();
			GenericFunctions.waitWebDriver(1500);
			GenericFunctions.waitForElementToAppear(createUserPage.searchConcept);
			contentResourcePage.searchConcepts.sendKeys(objListOFTestDataForSunbird1.get(6).getTitle());
			GenericFunctions.waitWebDriver(2000);
			contentResourcePage.conceptChooseAll.click();
			GenericFunctions.waitWebDriver(500);
			contentResourcePage.conceptDoneButton.click();
			GenericFunctions.waitWebDriver(2000);
			contentResourcePage.QueSubmitButton.click();
			GenericFunctions.waitForElementToAppear(contentResourcePage.pickQuestion);
			contentResourcePage.pickQuestionCheckBox.click();
			GenericFunctions.waitWebDriver(500);
			contentResourcePage.pickQueNextButton.click();
			GenericFunctions.waitForElementToAppear(contentResourcePage.questionSetTitle);
			contentResourcePage.questionSetTitle.sendKeys(objListOFTestDataForSunbird1.get(11).getCourseDescription());
			GenericFunctions.waitWebDriver(500);
			contentResourcePage.questionSetAddButton.click();
		}
		catch(Exception e)
		{
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed to create new question set for resource");
			ExtentTestManager.getTest().log(LogStatus.FAIL,"Exception Message: "+e.getLocalizedMessage());
			System.out.println("Failed to create new question set for resource "+e.getLocalizedMessage());
			Assert.fail("Failed to create new question set for resource "+e.getLocalizedMessage());
		}

	}


	public void validateUpForReivew()
	{
		try
		{
			//objListOFTestDataForSunbird1= ReadTestDataFromExcel.getTestDataForSunbird("testdatasheetcourse");
			ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to verify and search contents in the Up for Review Bucket");

			//Test casse 92
			GenericFunctions.waitForElementToAppear(createUserPage.closeIcon);
			createUserPage.closeIcon.click();
			GenericFunctions.waitWebDriver(1000);
			GenericFunctions.waitForElementToAppear(contentResourcePage.upForReview);
			contentResourcePage.upForReview.click();
			GenericFunctions.waitForElementToAppear(createUserPage.searchedContentForPublish);
			String latestContent=createUserPage.searchedContentForPublish.getText();
			ExtentTestManager.getTest().log(LogStatus.INFO, latestContent+" is the Latest content is displayed in the top of List");

			//Test case 93 
			createUserPage.upForReview.click();
			createUserPage.searchForReview.sendKeys(latestContent);
			GenericFunctions.waitForElementToAppear(createUserPage.searchedContentForPublish);
			GenericFunctions.waitWebDriver(3000);
			if(createUserPage.searchedContentForPublish.isDisplayed())
			{
				Assert.assertTrue(true);
				ExtentTestManager.getTest().log(LogStatus.INFO, "User is getting the results upon searching for the content");

			}

			//Test Case 94
			GenericFunctions.waitWebDriver(2900);
			createUserPage.searchForReview.click();
			createUserPage.searchForReview.clear();
			//createUserPage.searchForReview.sendKeys(latestContent);
			String [] otherChannelContent={"KS","Checking Bugs"};
			createUserPage.searchForReview.sendKeys(otherChannelContent[rand.nextInt(otherChannelContent.length)]);
			GenericFunctions.waitWebDriver(3000);
			GenericFunctions.waitForElementToAppear(contentResourcePage.noResultText);
			if(contentResourcePage.noResultText.isDisplayed())
			{
				Assert.assertTrue(true);
				ExtentTestManager.getTest().log(LogStatus.INFO, "User is not getting the results for searching different Org contents");
			}
		}
		catch(Exception e)
		{
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed to verify and search contents in the Up for Review Bucket");
			ExtentTestManager.getTest().log(LogStatus.FAIL,"Exception Message: "+e.getLocalizedMessage());
			System.out.println("Failed to verify and search contents in the Up for Review Bucket "+e.getLocalizedMessage());
			Assert.fail("Failed to verify and search contents in the Up for Review Bucket "+e.getLocalizedMessage());
		}

	}


	public void contentFilterApply_Reset()
	{
		try
		{
			ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to apply filters and validate contents");
			contentResourcePage.upForReview.click();
			GenericFunctions.waitForElementToAppear(contentResourcePage.showFilters);
			contentResourcePage.showFilters.click();

			//Board
			GenericFunctions.waitForElementToAppear(createUserPage.clickFilterBoard);
			createUserPage.clickFilterBoard.click();
			GenericFunctions.waitWebDriver(1000);
			contentResourcePage.selectFilterBoard.click();
			GenericFunctions.waitWebDriver(1000);
			//Grade(class)
			//GenericFunctions.waitForElementToAppear(createUserPage.clickBookGrade);
			createUserPage.clickBookGrade.get(0).click();
			GenericFunctions.waitWebDriver(1000);
			contentResourcePage.selectFilterGrade.click();
			//Subject
			GenericFunctions.waitForElementToAppear(createUserPage.clickFilterSubject);
			createUserPage.clickFilterSubject.click();
			GenericFunctions.waitWebDriver(1000);
			contentResourcePage.selectFilterSubject.click();
			//Medium
			GenericFunctions.waitForElementToAppear(createUserPage.clickFilterMedium);
			createUserPage.clickFilterMedium.click();
			GenericFunctions.waitWebDriver(1000);
			String MediumText=contentResourcePage.selectFilterMedium.getText();
			contentResourcePage.selectFilterMedium.click();
			//Content type
			GenericFunctions.waitForElementToAppear(createUserPage.clickContentType);
			createUserPage.clickContentType.click();
			GenericFunctions.waitWebDriver(1000);
			contentResourcePage.selectCotentType.click();
			GenericFunctions.waitWebDriver(500);
			contentResourcePage.filterApplyButton.click();
			contentResourcePage.showFilters.click();
			GenericFunctions.waitForElementToAppear(createUserPage.searchedContentForPublish);
			GenericFunctions.waitWebDriver(500);
			createUserPage.searchedContentForPublish.click();
			GenericFunctions.waitWebDriver(1000);
			GenericFunctions.waitForElementToAppear(contentResourcePage.verifyFilterMedium);
			GenericFunctions.scrollToElement(contentResourcePage.verifyFilterMedium);
			String compMediumText=contentResourcePage.verifyFilterMedium.getText();
			GenericFunctions.waitWebDriver(1000);
			if(MediumText.equalsIgnoreCase(compMediumText))
			{
				Assert.assertTrue(true);
				ExtentTestManager.getTest().log(LogStatus.INFO, "Results are satisfying the given search filter criteria, and filters are same in the content");
			}
			GenericFunctions.scrollToElement(createUserPage.headerLibrary);
			GenericFunctions.waitForElementToAppear(contentResourcePage.contentCloseIcon);
			GenericFunctions.scrollToElement(contentResourcePage.contentCloseIcon);
			contentResourcePage.contentCloseIcon.click();

			//Test case 96-b
			GenericFunctions.waitForElementToAppear(contentResourcePage.showFilters);
			contentResourcePage.showFilters.click();
			GenericFunctions.waitWebDriver(1000);
			contentResourcePage.filterResetButton.click();
			GenericFunctions.waitWebDriver(500);
			contentResourcePage.showFilters.click();
			GenericFunctions.waitForElementToAppear(createUserPage.searchedContentForPublish);
			String loadedTopContent=createUserPage.searchedContentForPublish.getText();
			GenericFunctions.waitWebDriver(1000);
			ExtentTestManager.getTest().log(LogStatus.INFO, "On Resetting all the filters contents are loaded sucessfully, "+loadedTopContent+" is the latest content at the Top of the list");
			ExtentTestManager.getTest().log(LogStatus.INFO, "Completed Test cases 92, 93, 94, 96 a & b");
		}
		catch(Exception e)
		{
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed to create new question set for resource");
			ExtentTestManager.getTest().log(LogStatus.FAIL,"Exception Message: "+e.getLocalizedMessage());
			System.out.println("Failed to create new question set for resource "+e.getLocalizedMessage());
			Assert.fail("Failed to create new question set for resource "+e.getLocalizedMessage());
		}
	}

	public void sendResourceForReview()
	{
		try
		{
			objListOFTestDataForSunbird1= ReadTestDataFromExcel.getTestDataForSunbird("testdatasheetcourse");
			ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to send resource for review");
			GenericFunctions.waitForElementToAppear(createUserPage.sendForReview);
			createUserPage.sendForReview.click();
			GenericFunctions.waitForElementToAppear(createUserPage.clickAppIcon);
			createUserPage.clickAppIcon.click();
			GenericFunctions.waitWebDriver(3000);
			createUserPage.searchUploadImage.sendKeys(SEARCH_RESOURCE_IMAGE);
			createUserPage.clickImageSearch.click();
			GenericFunctions.waitTillTheElementIsVisibleAndClickable(createUserPage.contentResourceIcon);
			createUserPage.contentResourceIcon.click();
			GenericFunctions.waitWebDriver(2000);
			createUserPage.selectAppIcon.click();
			GenericFunctions.waitWebDriver(500);
			createUserPage.clickOnSelectCurriculum.click();
			GenericFunctions.waitForElementToAppear(createUserPage.selectCurriculum);
			createUserPage.selectCurriculum.click();
			createUserPage.clickOnSelectClass.click();
			GenericFunctions.waitForElementToAppear(createUserPage.selectClass);
			GenericFunctions.scrollToElement(createUserPage.clickOnSelectSubject);
			createUserPage.clickOnSelectSubject.click();
			GenericFunctions.waitForElementToAppear(createUserPage.selectSubject);
			createUserPage.selectSubject.click();
			createUserPage.clickOnSelectMedium.click();
			GenericFunctions.waitForElementToAppear(createUserPage.selectMedium);
			createUserPage.selectMedium.click();
			GenericFunctions.scrollToElement(createUserPage.selectConcept);
			createUserPage.selectConcept.click();
			GenericFunctions.waitForElementToAppear(createUserPage.searchConcept);
			createUserPage.searchConcept.sendKeys(objListOFTestDataForSunbird1.get(6).getTitle());
			GenericFunctions.waitWebDriver(500);
			createUserPage.conceptChooseAll.click();
			createUserPage.conceptDoneButton.click();
			GenericFunctions.waitWebDriver(1500);
			createUserPage.saveButton.click();
		}
		catch(Exception e)
		{
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed to send resource for review");
			ExtentTestManager.getTest().log(LogStatus.FAIL,"Exception Message: "+e.getLocalizedMessage());
			System.out.println("Failed to send resource for review"+e.getLocalizedMessage());
			Assert.fail("Failed to send resource for review"+e.getLocalizedMessage());
		}

	}


	public void resourceName()
	{
		try
		{
			objListOFTestDataForSunbird1= ReadTestDataFromExcel.getTestDataForSunbird("testdatasheetcourse");
			ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying create new resource by giving an Unique Resource name");
			GenericFunctions.waitWebDriver(1500);
			GenericFunctions.waitForElementToAppear(createUserPage.bookName);
			String resourceNumber = GenericFunctions.testDataIncrementer(".//TestData//resourceNumbers.txt").toString();
			createUserPage.bookName.sendKeys(objListOFTestDataForSunbird1.get(6).getCourseName()+resourceNumber);
			GenericFunctions.waitWebDriver(2000);
			createUserPage.startCreating.click();
			GenericFunctions.waitWebDriver(7000);			
			GenericFunctions.WaitForFrameAndSwitchToIt(createUserPage.iFrame);
			GenericFunctions.waitWebDriver(4500);
		}
		catch(Exception e)
		{
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed on entering unique resource name");
			ExtentTestManager.getTest().log(LogStatus.FAIL,"Exception Message: "+e.getLocalizedMessage());
			System.out.println("Failed on entering unique resource name"+e.getLocalizedMessage());
			Assert.fail("Failed on entering unique resource name"+e.getLocalizedMessage());
		}

	}

	public void uploadVideoFiles()
	{
		try
		{
			objListOFTestDataForSunbird1= ReadTestDataFromExcel.getTestDataForSunbird("testdatasheetcourse");
			ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to upload Video files");

			//Add Video files to Resource
			addVideo();

			GenericFunctions.waitForElementToAppear(createUserPage.saveCourse);
			createUserPage.saveCourse.click();
			GenericFunctions.waitWebDriver(600);
			createUserPage.closeContentPopup.click();
			GenericFunctions.waitForElementToAppear(contentResourcePage.previewIcon);
			contentResourcePage.previewIcon.click();
			//GenericFunctions.WaitForFrameAndSwitchToIt(createUserPage.iFrame);
			GenericFunctions.waitForElementToAppear(contentResourcePage.previewPopup);
			GenericFunctions.waitWebDriver(1600);
			Boolean confirmPopup = contentResourcePage.previewPopup.isDisplayed();
			while(confirmPopup==true)
			{
				GenericFunctions.WaitForFrameAndSwitchToIt(createUserPage.iFrame);
				GenericFunctions.waitForElementToAppear(contentResourcePage.confirmContent);
				String aVideoUrl=contentResourcePage.confirmContent.getAttribute("src");
				if(aVideoUrl.equalsIgnoreCase(VIDEO_UPLOAD))
				{
					ExtentTestManager.getTest().log(LogStatus.INFO, "The content creator is able to preview and save the uploaded video file");
					Assert.assertTrue(true);
				}
				else
				{
					ExtentTestManager.getTest().log(LogStatus.INFO, "Could not verify the video in the preview popup");
					System.out.println("Could not verify the video in the preview");
				}

				GenericFunctions.refreshWebPage();
				//contentResourcePage.randomClickElement.click();
				//driver.switchTo().defaultContent();
				//GenericFunctions.WaitForFrameAndSwitchToIt(createUserPage.iFrame);

			}
		}
		catch(Exception e)
		{
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed to upload video files");
			ExtentTestManager.getTest().log(LogStatus.FAIL,"Exception Message: "+e.getLocalizedMessage());
			System.out.println("Failed to upload video files"+e.getLocalizedMessage());
			Assert.fail("Failed to upload video files"+e.getLocalizedMessage());
		}
	}

	public void addActivityPlugins()
	{
		try
		{
			objListOFTestDataForSunbird1= ReadTestDataFromExcel.getTestDataForSunbird("testdatasheetcourse");
			ExtentTestManager.getTest().log(LogStatus.INFO, "Continuation with Test case 80");
			ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to upload Video files");
			GenericFunctions.waitForElementToAppear(contentResourcePage.addActivity);
			contentResourcePage.addActivity.click();
			GenericFunctions.waitForElementToAppear(contentResourcePage.searchActivity);
			contentResourcePage.searchActivity.click();
			contentResourcePage.searchActivity.sendKeys(objListOFTestDataForSunbird1.get(11).getTitle());
			GenericFunctions.waitWebDriver(650);
			contentResourcePage.clickCategory.click();
			GenericFunctions.waitWebDriver(500);
			contentResourcePage.selectCategory.click();
			GenericFunctions.waitForElementToAppear(contentResourcePage.selectActivity);
			contentResourcePage.addActivityBtn.click();
			GenericFunctions.waitForElementToAppear(contentResourcePage.clickAddedActivity);
			contentResourcePage.clickAddedActivity.click();
			GenericFunctions.waitForElementToAppear(contentResourcePage.addActivityPopupBtn);
			GenericFunctions.waitWebDriver(2500);
			contentResourcePage.addActivityPopupBtn.click();

			GenericFunctions.waitForElementToAppear(createUserPage.saveCourse);
			createUserPage.saveCourse.click();
			GenericFunctions.waitWebDriver(600);
			createUserPage.closeContentPopup.click();
			//createUserPage.editorCloseIcon.click();

			GenericFunctions.waitForElementToAppear(contentResourcePage.previewIcon);
			contentResourcePage.previewIcon.click();
			//GenericFunctions.WaitForFrameAndSwitchToIt(createUserPage.iFrame);
			GenericFunctions.waitForElementToAppear(contentResourcePage.previewPopup);
			GenericFunctions.waitWebDriver(1600);
			Boolean confirmPopup = contentResourcePage.previewPopup.isDisplayed();
			while(confirmPopup==true)
			{
				ExtentTestManager.getTest().log(LogStatus.INFO, "User is able to preview the added activity/plugins");
				Assert.assertTrue(true);
				break;
			}

			driver.switchTo().defaultContent();
			GenericFunctions.refreshWebPage();
			GenericFunctions.waitForElementToAppear(createUserPage.editorCloseIcon);
			createUserPage.editorCloseIcon.click();

		}

		catch(Exception e)
		{
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed to upload video files");
			ExtentTestManager.getTest().log(LogStatus.FAIL,"Exception Message: "+e.getLocalizedMessage());
			System.out.println("Failed to upload video files"+e.getLocalizedMessage());
			Assert.fail("Failed to upload video files"+e.getLocalizedMessage());
		}
	}

	public void applyFiltersForQuestionSet()
	{
		try
		{
			objListOFTestDataForSunbird1= ReadTestDataFromExcel.getTestDataForSunbird("testdatasheetcourse");
			ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to apply filter for Question Set");
			GenericFunctions.waitForElementToAppear(contentResourcePage.addQuestionSet);
			contentResourcePage.addQuestionSet.click();
			GenericFunctions.waitForElementToAppear(contentResourcePage.questionSetSearchBar);
			contentResourcePage.questionSetSearchBar.click();
			contentResourcePage.questionSetSearchBar.sendKeys(objListOFTestDataForSunbird1.get(11).getTitleDescription());
			GenericFunctions.waitWebDriver(1000);
			contentResourcePage.AdvancedFilter.click();
			GenericFunctions.waitWebDriver(1500);
			contentResourcePage.AFClickLanguage.click();
			GenericFunctions.waitWebDriver(1000);
			contentResourcePage.AFSelectLanguage.click();
			GenericFunctions.waitForElementToAppear(contentResourcePage.AFClickDifficulty);
			contentResourcePage.AFClickDifficulty.click();
			GenericFunctions.waitWebDriver(1000);
			contentResourcePage.selectLevel.click();
			GenericFunctions.waitForElementToAppear(contentResourcePage.AFClickQuestionType);
			contentResourcePage.AFClickQuestionType.click();
			GenericFunctions.waitWebDriver(1000);
			contentResourcePage.AFSelectQuestionType.click();
			GenericFunctions.waitForElementToAppear(contentResourcePage.AFClickGradeLevel);
			contentResourcePage.AFClickGradeLevel.click();
			GenericFunctions.waitWebDriver(1000);
			contentResourcePage.AFSelectGradeLevel.click();
			GenericFunctions.waitWebDriver(1500);
			contentResourcePage.SearchIcon.click();
			//GenericFunctions.WaitForFrameAndSwitchToIt(createUserPage.iFrame);

			GenericFunctions.waitForElementToAppear(contentResourcePage.pickQuestion);
			GenericFunctions.waitWebDriver(3500);

			action.moveToElement(contentResourcePage.pickQuestionCheckBox).click().build().perform();

			GenericFunctions.waitForElementToAppear(contentResourcePage.pickQueNextButton);
			contentResourcePage.pickQueNextButton.click();
			GenericFunctions.waitForElementToAppear(contentResourcePage.questionSetTitle);
			contentResourcePage.questionSetTitle.sendKeys(objListOFTestDataForSunbird1.get(11).getCourseDescription());
			GenericFunctions.waitWebDriver(500);
			contentResourcePage.questionSetAddButton.click();
			GenericFunctions.waitForElementToAppear(createUserPage.saveCourse);
			createUserPage.saveCourse.click();
			GenericFunctions.waitWebDriver(600);
			createUserPage.closeContentPopup.click();
			//User is able to preview the added question sets
		}

		catch(Exception e)
		{
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed to apply Filters for Question Set");
			ExtentTestManager.getTest().log(LogStatus.FAIL,"Exception Message: "+e.getLocalizedMessage());
			System.out.println("Failed to apply Filters for Question Set "+e.getLocalizedMessage());
			Assert.fail("Failed to apply Filters for Question Set "+e.getLocalizedMessage());
		}

	}

	public void fillInTheBlankQuestion()
	{
		try
		{
			//Select select = new Select(contentResourcePage.selectKeyboard);
			objListOFTestDataForSunbird1= ReadTestDataFromExcel.getTestDataForSunbird("testdatasheetcourse");
			ExtentTestManager.getTest().log(LogStatus.INFO, "To verify user is able to create-Fill in the blanks question type");
			GenericFunctions.waitForElementToAppear(contentResourcePage.addQuestionSet);
			contentResourcePage.addQuestionSet.click();
			GenericFunctions.waitForElementToAppear(contentResourcePage.createQuestion);
			contentResourcePage.createQuestion.click();
			GenericFunctions.waitWebDriver(2600);
			contentResourcePage.fibQuestionTemplate.click();
			GenericFunctions.waitWebDriver(2600);
			//GenericFunctions.waitForElementToAppear(contentResourcePage.enterTheQuestion);
			GenericFunctions.WaitForFrameAndSwitchToIt(contentResourcePage.enterQuestionIframe);
			contentResourcePage.enterTheQuestion.click();
			contentResourcePage.enterTheQuestion.sendKeys(objListOFTestDataForSunbird1.get(12).getCourseName());
			GenericFunctions.waitWebDriver(1600);
			//GenericFunctions.WaitForFrameAndSwitchToIt(contentResourcePage.createQuestionFrame1);
			//GenericFunctions.scrollToElement(contentResourcePage.selectKeyboard);
			driver.switchTo().parentFrame();
			GenericFunctions.waitWebDriver(3600);
			action.moveToElement(contentResourcePage.selectKeyboard).build().perform();
			action.click(contentResourcePage.selectKeyboard).build().perform();
			//contentResourcePage.selectKeyboard.click();

			/*//To verify Keyboard Type English And Device
			keyboardType_English_Device();
			 */
			/*//To verify Keyboard type-CUSTOM
			selectCustomKBType("default");*/


		}
		catch(Exception e)
		{
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed to verify create-Fill in the blanks question type");
			ExtentTestManager.getTest().log(LogStatus.FAIL,"Exception Message: "+e.getLocalizedMessage());
			System.out.println("Failed to verify create-Fill in the blanks question type "+e.getLocalizedMessage());
			Assert.fail("Failed to verify create-Fill in the blanks question type "+e.getLocalizedMessage());
		}
		ExtentTestManager.getTest().log(LogStatus.INFO,"Completion of Test case 82 of Creator");
	}

	public void keyboardType_English_Device()
	{

		//To VERIFY THE KEYBOARD TYPE - ENGLISH
		GenericFunctions.waitWebDriver(1600);
		contentResourcePage.keyboardTypeEnglish.click();
		GenericFunctions.waitWebDriver(1200);
		contentResourcePage.previewRefreshIcon.click();
		GenericFunctions.WaitForFrameAndSwitchToIt(contentResourcePage.previewFrameArea);
		GenericFunctions.waitForElementToAppear(contentResourcePage.previewAnsFiled1);
		GenericFunctions.waitWebDriver(1200);
		contentResourcePage.previewAnsFiled1.click();
		GenericFunctions.waitWebDriver(2000);
		if(contentResourcePage.previewKeyboard.isDisplayed()&&contentResourcePage.keyboardLetterA.isDisplayed())
		{
			Assert.assertTrue(true);
			ExtentTestManager.getTest().log(LogStatus.INFO,"Keyboard is displayed on previewing the question and Keyboard type as 'English'");
			System.out.println("Keyboard is displayed on previewing the question and Keyboard type as 'English'");
		}
		else 
		{
			System.out.println("Keyboard is not displayed on Previewing the Question");
		}

		//TO VERIFY KEYBOARD TYPE-DEVICE
		driver.switchTo().parentFrame();
		GenericFunctions.waitWebDriver(1200);
		action.moveToElement(contentResourcePage.selectKeyboard).build().perform();
		action.click(contentResourcePage.selectKeyboard).build().perform();
		GenericFunctions.waitWebDriver(600);
		contentResourcePage.keyboardTypeDevice.click();
		GenericFunctions.waitWebDriver(1200);
		contentResourcePage.previewRefreshIcon.click();
		GenericFunctions.WaitForFrameAndSwitchToIt(contentResourcePage.previewFrameArea);
		GenericFunctions.waitWebDriver(1200);
		GenericFunctions.waitForElementToAppear(contentResourcePage.previewAnsFiled1);
		GenericFunctions.waitWebDriver(1200);
		contentResourcePage.previewAnsFiled1.click();
		contentResourcePage.previewAnsFiled1.sendKeys("Test 1");
		Assert.assertTrue(true);
		ExtentTestManager.getTest().log(LogStatus.INFO,"Keyboard is not displayed while previewing the quesiton and Keyboard type as 'Device'");

	}


	public void selectCustomKBType(String addKeysType)
	{
		int inputCharArrSize=0;
		char[] inputKeyCharArr=null;
		char[] prevKBElementsCharArr=null;
		driver.switchTo().parentFrame();
		GenericFunctions.waitWebDriver(1200);
		action.moveToElement(contentResourcePage.selectKeyboard).build().perform();
		action.click(contentResourcePage.selectKeyboard).build().perform();
		GenericFunctions.waitWebDriver(600);
		contentResourcePage.keyboardTypeCustom.click();

		GenericFunctions.waitWebDriver(650);
		if(addKeysType.equalsIgnoreCase("language"))
		{
			contentResourcePage.addKeysTB.sendKeys(objListOFTestDataForSunbird1.get(12).getTitle());
		}
		else if(addKeysType.equalsIgnoreCase("default"))
		{
			contentResourcePage.addKeysTB.clear();
			contentResourcePage.addKeysTB.sendKeys(objListOFTestDataForSunbird1.get(12).getTitle());

		}
		else if(addKeysType.equalsIgnoreCase("characters"))
		{
			contentResourcePage.addKeysTB.clear();
			inputKeyCharArr = objListOFTestDataForSunbird1.get(12).getTitleDescription().toCharArray();
			inputCharArrSize = inputKeyCharArr.length;
			contentResourcePage.addKeysTB.sendKeys(objListOFTestDataForSunbird1.get(12).getTitleDescription());

		}
		else if(addKeysType.equalsIgnoreCase("alphabets"))
		{
			contentResourcePage.addKeysTB.clear();
			contentResourcePage.addKeysTB.sendKeys(objListOFTestDataForSunbird1.get(12).getCourseDescription());
		}
		else if(addKeysType.equalsIgnoreCase("special chracters"))
		{
			contentResourcePage.addKeysTB.clear();
			contentResourcePage.addKeysTB.sendKeys(objListOFTestDataForSunbird1.get(13).getCourseName());
		}
		GenericFunctions.waitWebDriver(1200);
		contentResourcePage.previewRefreshIcon.click();
		GenericFunctions.WaitForFrameAndSwitchToIt(contentResourcePage.previewFrameArea);
		GenericFunctions.waitWebDriver(1200); 	
		GenericFunctions.waitForElementToAppear(contentResourcePage.previewAnsFiled1);
		GenericFunctions.waitWebDriver(1300);
		contentResourcePage.previewAnsFiled1.click();
		GenericFunctions.waitWebDriver(1000);
		if(contentResourcePage.previewKeyboard.isDisplayed()&&contentResourcePage.keyboardLetterA.isDisplayed())
		{
			Assert.assertTrue(true);
			ExtentTestManager.getTest().log(LogStatus.INFO,"Custom Keyboard is displayed with only the entered keywords while previewing the question");
			System.out.println("Custom Keyboard is displayed with only the entered keywords while previewing the question");
		}
		/*if(addKeysType.contains("characters"))
		{

				//contentResourcePage.previewKBCharCount.getText();
				//driver.findElement(By.xpath("//sui-multi-select[@formcontrolname='language']")).click();
				//driver.findElement(By.tagName("sui-multi-select")).click();
			}
		}*/
		if(addKeysType.contains("characters"))
		{
			//for(int i=0;i<contentResourcePage.previewKBCharCount.size();i++)
			//{
			int i=0;
			for(WebElement kBChar:contentResourcePage.previewKBCharCount)
			{
				//WebElement kBChar:

				prevKBElementsCharArr = contentResourcePage.previewKBCharCount.get(i).getText().toCharArray();
				// =kBChar.getText(i);
				//prevKBElementsCharArr[i] = prevKBElements.toCharArray();
				i++;
				System.out.println(prevKBElementsCharArr[i]);
			}
			int prevKBCharArrSize = prevKBElementsCharArr.length-7;
			System.out.println((prevKBCharArrSize));
			if(prevKBCharArrSize==inputCharArrSize)
			{
				boolean compareVal=Arrays.equals(inputKeyCharArr,prevKBElementsCharArr);
				while(compareVal==true)
				{
					Assert.assertTrue(true);
					ExtentTestManager.getTest().log(LogStatus.INFO,"Number of characters displayed in the keyboard preview is same as the number of characters while creating the keyboard");
					ExtentTestManager.getTest().log(LogStatus.INFO,"Characters entered while creating the keyboards are same in the Custom keyboard while previewing");
					break;
				}
			}
		}

		GenericFunctions.waitWebDriver(1100);
		//driver.switchTo().parentFrame();
		GenericFunctions.waitWebDriver(1000);
		//contentResourcePage.createQueNext.click();
	}

	public void fillAllMandatory()
	{
		try
		{
			//Select select = new Select(contentResourcePage.selectKeyboard);
			objListOFTestDataForSunbird1= ReadTestDataFromExcel.getTestDataForSunbird("testdatasheetcourse");
			ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to fill all the mandatory fields for submitting");
			GenericFunctions.waitForElementToAppear(contentResourcePage.clickMedium);
			contentResourcePage.clickMedium.click();
			GenericFunctions.waitWebDriver(1300);
			contentResourcePage.selectMedium.click();
			GenericFunctions.waitWebDriver(1300);
			contentResourcePage.clickLevel.click();
			GenericFunctions.waitForElementToAppear(contentResourcePage.selectLevel);
			contentResourcePage.selectLevel.click();
			GenericFunctions.waitWebDriver(1300);
			contentResourcePage.clickGrade.click();
			GenericFunctions.waitForElementToAppear(contentResourcePage.selectGrade);
			contentResourcePage.selectGrade.click();
			GenericFunctions.waitWebDriver(1300);
			contentResourcePage.clickSubject.click();
			GenericFunctions.waitForElementToAppear(contentResourcePage.selectSubject);
			contentResourcePage.selectSubject.click();
			GenericFunctions.waitWebDriver(1000);
			contentResourcePage.clickBoard.click();
			GenericFunctions.waitForElementToAppear(contentResourcePage.selectBoard);
			contentResourcePage.selectBoard.click();
			GenericFunctions.waitWebDriver(700);
			contentResourcePage.questionMaxScore.sendKeys(objListOFTestDataForSunbird1.get(11).getCourseDescription());
			contentResourcePage.clickConcepts.click();
			GenericFunctions.waitWebDriver(1500);
			GenericFunctions.waitForElementToAppear(createUserPage.searchConcept);
			contentResourcePage.searchConcepts.sendKeys(objListOFTestDataForSunbird1.get(6).getTitle());
			GenericFunctions.waitWebDriver(2000);
			contentResourcePage.conceptChooseAll.click();
			GenericFunctions.waitWebDriver(500);
			contentResourcePage.conceptDoneButton.click();
			GenericFunctions.waitWebDriver(2000);
			contentResourcePage.QueSubmitButton.click();
			GenericFunctions.waitForElementToAppear(contentResourcePage.pickQuestion);
			if(contentResourcePage.pickQuestion.isDisplayed())
			{
				Assert.assertTrue(true);
				ExtentTestManager.getTest().log(LogStatus.INFO,"Keyboard is displayed with only the entered keywords while previewing the quesiton and Keyboard type as 'Custom'");

			}


		}
		catch(Exception e)
		{
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed to fill the mandatory fields");
			ExtentTestManager.getTest().log(LogStatus.FAIL,"Exception Message: "+e.getLocalizedMessage());
			System.out.println("Failed to fill the mandatory fields "+e.getLocalizedMessage());
			Assert.fail("Failed to fill the mandatory fields "+e.getLocalizedMessage());
		}

	}

	public void searchConsumeCourse()	
	{

	}

	public void verifyCloseContentEditor()
	{
		try
		{
			//objListOFTestDataForSunbird1= ReadTestDataFromExcel.getTestDataForSunbird("testdatasheetcourse");
			ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to verify that content editor can be closed");
			GenericFunctions.waitForElementToAppear(createUserPage.editorCloseIcon);
			createUserPage.editorCloseIcon.click();
			GenericFunctions.waitWebDriver(1500);
			String validationMsg=driver.switchTo().alert().getText();
			driver.switchTo().alert().dismiss();
			GenericFunctions.waitForElementToAppear(createUserPage.saveCourse);
			createUserPage.saveCourse.click();
			GenericFunctions.waitForElementToAppear(createUserPage.closeContentPopup);
			createUserPage.closeContentPopup.click();
			GenericFunctions.waitForElementToAppear(createUserPage.editorCloseIcon);
			createUserPage.editorCloseIcon.click();
			Assert.assertTrue(true);
			ExtentTestManager.getTest().log(LogStatus.INFO, "validated the message before saving the content, "+validationMsg+" is the Message, completed Test case 123");
		}
		catch(Exception e)
		{
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed to verify and close content editor");
			ExtentTestManager.getTest().log(LogStatus.FAIL,"Exception Message: "+e.getLocalizedMessage());
			System.out.println("Failed to verify and close content editor "+e.getLocalizedMessage());
			Assert.fail("Failed to verify and close content editor "+e.getLocalizedMessage());
		}
	}

	public void goToWorkspaceAndClick(String clickOn)
	{
		try
		{
			ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to Navigate to "+clickOn +" from workspace");
			GenericFunctions.waitForElementToAppear(createUserPage.headerProfile);
			createUserPage.headerProfile.click();
			GenericFunctions.waitForElementToAppear(createUserPage.workSpace);
			createUserPage.workSpace.click();
			GenericFunctions.waitWebDriver(1000);
			if(clickOn.equalsIgnoreCase("Up For Review"))
			{
				contentResourcePage.upForReview.click();
			}	
			else if(clickOn.equalsIgnoreCase("Drafts"))
			{
				contentResourcePage.drafts.click();
			}	
			else if(clickOn.equalsIgnoreCase("Published"))
			{
				contentResourcePage.published.click();
			}
			else if(clickOn.equalsIgnoreCase("Limited Publishing"))
			{
				contentResourcePage.limitedPublishing.click();	
			}	
			else if(clickOn.equalsIgnoreCase("Review Submissions"))
			{
				contentResourcePage.reviewSubmissions.click();	
			}
			else if(clickOn.equalsIgnoreCase("All my content"))
			{
				contentResourcePage.allMyActivity.click();
			}
			else
			{
				GenericFunctions.waitWebDriver(2000);
				System.out.println("Could not navigate to "+clickOn);
			}
		}
		catch(Exception e)
		{
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed to navigate to "+clickOn +" from workspace");
			ExtentTestManager.getTest().log(LogStatus.FAIL,"Exception Message: "+e.getLocalizedMessage());
			System.out.println("Failed to navigate to "+clickOn +" from workspace "+e.getLocalizedMessage());
			Assert.fail("Failed to navigate to "+clickOn +" from workspace"+e.getLocalizedMessage());
		}

	}

	public void verifyMyActivity_OnProfile()
	{
		try
		{
			ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to verify My Activity");
			GenericFunctions.waitForElementToAppear(orgUploadPage.dropdown);
			orgUploadPage.dropdown.click();
			GenericFunctions.waitForElementToAppear(contentResourcePage.profileIconActivity);
			contentResourcePage.profileIconActivity.click();
			String eUrl="https://staging.open-sunbird.org/myActivity";
			String aUrl=driver.getCurrentUrl();
			GenericFunctions.waitWebDriver(2000);
			Assert.assertEquals(aUrl, eUrl, "User is not able to verify My activity dashboard");
			ExtentTestManager.getTest().log(LogStatus.INFO, "User is able to view the course dashboard on click of my activity option.");
		}
		catch(Exception e)
		{
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed to navigate to  from workspace");
			ExtentTestManager.getTest().log(LogStatus.FAIL,"Exception Message: "+e.getLocalizedMessage());
			System.out.println("Failed to navigate to from workspace "+e.getLocalizedMessage());
			Assert.fail("Failed to navigate to from workspace"+e.getLocalizedMessage());
		}
	}

	public void verifyEditDetails_OfMetadataPage()//List<String> metapageDetails)
	{
		try
		{
			ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to verify Edit details metadata page");
			GenericFunctions.waitForElementToAppear(contentResourcePage.editorEditDetails);
			contentResourcePage.editorEditDetails.click();
			GenericFunctions.waitForElementToAppear(contentResourcePage.editDetailsCollectionTitle);
			contentResourcePage.editDetailsCollectionTitle.clear();
			contentResourcePage.editDetailsCollectionTitle.sendKeys(objListOFTestDataForSunbird1.get(5).getCourseName()+"_"+GenericFunctions.testDataIncrementer(".//TestData//collectionNumbers.txt")+"_Edited");
			String aCollectionTitle=contentResourcePage.editDetailsCollectionTitle.getText();
			GenericFunctions.waitForElementToAppear(createUserPage.saveButton);
			createUserPage.saveButton.click();
			GenericFunctions.waitWebDriver(2000);
			GenericFunctions.waitForElementToAppear(createUserPage.closeContentPopup);
			createUserPage.closeContentPopup.click();
			GenericFunctions.waitWebDriver(2000);
			GenericFunctions.waitForElementToAppear(contentResourcePage.editorEditDetails);
			contentResourcePage.editorEditDetails.click();
			GenericFunctions.waitForElementToAppear(contentResourcePage.editDetailsCollectionTitle);
			String eCollectionTitle=contentResourcePage.editDetailsCollectionTitle.getText();
			Assert.assertEquals(aCollectionTitle, eCollectionTitle);
			Assert.assertTrue(true);
			ExtentTestManager.getTest().log(LogStatus.INFO, "On clicking second time on Edit Details link user is able to verify previously added data is saved");
			GenericFunctions.waitWebDriver(2000);
			contentResourcePage.editDetailsClose.click();
			GenericFunctions.waitWebDriver(2000);
			GenericFunctions.waitForElementToAppear(createUserPage.saveCourse);
			createUserPage.saveCourse.click();
			GenericFunctions.waitWebDriver(1501);

			/*
			GenericFunctions.waitForElementToAppear(contentResourcePage.limitedSharingIcon);
			contentResourcePage.limitedSharingIcon.click();
			GenericFunctions.waitWebDriver(1500);
			contentResourcePage.clickLimitedSharing.click();
			 */

			//createUserPage.editorCloseIcon.click();


			/*for(int i=0;i<=metapageDetails.size();i++)
			{
				String data=metapageDetails.get(i);
				System.out.println(data);

			}*/

		}
		catch(Exception e)
		{
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed to verify Edit details form");
			ExtentTestManager.getTest().log(LogStatus.FAIL,"Exception Message: "+e.getLocalizedMessage());
			System.out.println("Failed to verify Edit details form"+e.getLocalizedMessage());
			Assert.fail("Failed to verify Edit details form"+e.getLocalizedMessage());
		}
	}

	public String createNewCollection()
	{
		String collectionName="";
		//List<String> metadataPageDetails = new ArrayList<String>();
		try
		{

			ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to create new collection");
			objListOFTestDataForSunbird1 = ReadTestDataFromExcel.getTestDataForSunbird("testdatasheetcourse");

			//Give the collection Name
			GenericFunctions.waitForElementToAppear(createUserPage.courseName);
			GenericFunctions.waitWebDriver(4000);
			collectionName = objListOFTestDataForSunbird1.get(5).getCourseName()+"_"+GenericFunctions.testDataIncrementer(".//TestData//collectionNumbers.txt");
			//createUserPage.courseName.sendKeys(collectionName);
			//Give the Collection Description
			//GenericFunctions.waitForElementToAppear(createUserPage.courseDescription);
			//createUserPage.courseDescription.sendKeys(objListOFTestDataForSunbird1.get(5).getCourseDescription());
			GenericFunctions.waitForElementToAppear(createUserPage.startCreating);
			createUserPage.startCreating.click();
			GenericFunctions.WaitForFrameAndSwitchToIt(createUserPage.iFrame);
			GenericFunctions.waitWebDriver(7500);
			GenericFunctions.waitForElementToAppear(createUserPage.newChild);
			action.moveToElement(createUserPage.newChild).click().perform();

			GenericFunctions.waitForElementToAppear(createUserPage.collectionKeywords);
			createUserPage.collectionKeywords.sendKeys(objListOFTestDataForSunbird1.get(5).getTitle());


			GenericFunctions.waitForElementToAppear(contentResourcePage.untitledCollection);
			contentResourcePage.untitledCollection.clear();
			contentResourcePage.untitledCollection.sendKeys(collectionName);
			GenericFunctions.waitWebDriver(1000);
			contentResourcePage.untitledCollectionDesc.clear();
			contentResourcePage.untitledCollectionDesc.sendKeys(objListOFTestDataForSunbird1.get(5).getCourseDescription());

			GenericFunctions.waitForElementToAppear(createUserPage.addResource);
			createUserPage.addResource.click();
			GenericFunctions.waitForElementToAppear(createUserPage.findSelectActivities);
			GenericFunctions.waitWebDriver(1500);
			GenericFunctions.waitForElementToAppear(createUserPage.selectResource);
			createUserPage.selectResource.click();
			GenericFunctions.waitForElementToAppear(createUserPage.proceedButton);
			createUserPage.proceedButton.click();
			GenericFunctions.waitWebDriver(500);
		}
		catch(Exception e)
		{
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed to create new collection");
			ExtentTestManager.getTest().log(LogStatus.FAIL,"Exception Message: "+e.getLocalizedMessage());
			System.out.println("Failed on creating collection");
			Assert.fail("Failed to create new collection");
		}
		return collectionName;
	}

	public List<String> enterMandatory_EditDetailsPage()
	{
		List<String> metadataPageDetails = new ArrayList<String>();
		try
		{
			ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to enter all mandatories in the Edit details page");
			GenericFunctions.waitWebDriver(1000);
			createUserPage.clickAppIcon.click();
			GenericFunctions.waitWebDriver(2000);
			createUserPage.searchUploadImage.sendKeys(SEARCH_COLLECTION_IMAGE);
			createUserPage.clickImageSearch.click();
			GenericFunctions.waitWebDriver(1000);
			createUserPage.checkCollectionIcon.click();
			createUserPage.selectAppIcon.click();
			GenericFunctions.waitForElementToAppear(createUserPage.clickOnSelectCurriculum);
			createUserPage.clickOnSelectCurriculum.click();
			GenericFunctions.waitForElementToAppear(createUserPage.selectCurriculum);
			GenericFunctions.scrollToElement(createUserPage.selectCurriculum);
			//Get text
			String currText=createUserPage.selectCurriculum.getText();
			metadataPageDetails.add(0, currText);

			createUserPage.selectCurriculum.click();

			GenericFunctions.waitForElementToAppear(createUserPage.clickOnSelectClass);
			createUserPage.clickOnSelectClass.click();
			GenericFunctions.waitWebDriver(1002);
			//Get text
			String classText = createUserPage.selectClass.getText();
			metadataPageDetails.add(1, classText);

			createUserPage.selectClass.click();
			GenericFunctions.scrollToElement(createUserPage.clickOnSelectSubject);
			createUserPage.clickOnSelectSubject.click();
			GenericFunctions.waitForElementToAppear(createUserPage.selectSubject);
			//Get text
			String subText = createUserPage.selectSubject.getText();
			metadataPageDetails.add(2, subText);
			createUserPage.selectSubject.click();
			createUserPage.clickOnSelectMedium.click();
			GenericFunctions.waitForElementToAppear(createUserPage.selectMedium);
			//Get text
			String medText=createUserPage.selectMedium.getText();
			metadataPageDetails.add(3, medText);

			createUserPage.selectMedium.click();
			createUserPage.saveButton.click();
			GenericFunctions.waitWebDriver(3000);

		}
		catch(Exception e)
		{
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed to enter details in Metadata page");
			ExtentTestManager.getTest().log(LogStatus.FAIL,"Exception Message: "+e.getLocalizedMessage());
			System.out.println("Failed to enter details in Metadata page");
			Assert.fail("Failed to enter details in Metadata page");
		}
		return metadataPageDetails;
	}

	public void verifyContent_AllMyContent(String contentName)
	{
		try
		{

			ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to verify content in All My Content Bucket");
			GenericFunctions.waitForElementToAppear(contentResourcePage.allMyActivity);
			contentResourcePage.allMyActivity.click();
			GenericFunctions.waitForElementToAppear(createUserPage.searchForReview);
			createUserPage.searchForReview.click();
			createUserPage.searchForReview.sendKeys(contentName);
			createUserPage.searchIcon.click();
			GenericFunctions.waitWebDriver(1000);
			GenericFunctions.waitForPageToLoad(ContentCreationResourcePage.noResultFound);
			if(ContentCreationResourcePage.noResultFound.isDisplayed())
			{
				Assert.assertTrue(true);
				ExtentTestManager.getTest().log(LogStatus.PASS, "Content deleted from Limited publishing is not found in All My Content");
			}

		}
		catch(Exception e)
		{
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed to verify content in All My Content Bucket");
			ExtentTestManager.getTest().log(LogStatus.FAIL,"Exception Message: "+e.getLocalizedMessage());
			System.out.println("Failed to verify content in All My Content Bucket");
			Assert.fail("Failed to verify content in All My Content Bucket"+e);
		}
	}

	public String verifyRemoveRootNote()
	{
		String eMsgText="Sorry, delete is not allowed.";
		String rootNodeText="";
		try
		{
			ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to verify whether root node can be removed from TOC");
			GenericFunctions.waitForElementToAppear(contentResourcePage.rootNodeElement);
			contentResourcePage.rootNodeElement.click();
			GenericFunctions.waitWebDriver(1000);			
			r = new Robot();
			r.keyPress(KeyEvent.VK_DELETE);
			r.keyRelease(KeyEvent.VK_DELETE);
		
			action.moveToElement(contentResourcePage.deleteToaster).build().perform();
			//String msgText=contentResourcePage.getToasterMsg.getText();
			String aMsgText=contentResourcePage.deleteToaster.getText();
			System.out.println(aMsgText);
			GenericFunctions.waitWebDriver(3000);
			Assert.assertEquals(aMsgText,eMsgText);
			ExtentTestManager.getTest().log(LogStatus.PASS, "User cannot delete root node from TOC as Delete is disabled");
			
			
		}
		catch(Exception e)
		{
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed to verify root node is can be removable from TOC");
			ExtentTestManager.getTest().log(LogStatus.FAIL,"Exception Message: "+e.getLocalizedMessage());
			System.out.println("Failed to verify content in All My Content Bucket");
			Assert.fail("Failed to verify content in All My Content Bucket"+e);
		}
		return rootNodeText;
	}
	
	/*	
 	public static void verifyUpdateRootNodeName()
	{
		contentResourcePage.untitledCollection.clear();
		contentResourcePage.untitledCollection.sendKeys(collectionName);
		ContentCreationResourcePage.rootNodeElement.getText();
		System.out.println("Testing");
	}*/

	public void verifyUpdateRootNodeName() 
	{
		GenericFunctions.waitForElementToAppear(ContentCreationResourcePage.rootNodeElement);
		action.moveToElement(ContentCreationResourcePage.rootNodeElement);
		String text = ContentCreationResourcePage.rootNodeElement.getText();
		GenericFunctions.waitForElementToAppear(contentResourcePage.untitledCollection);
		contentResourcePage.untitledCollection.clear();
		contentResourcePage.untitledCollection.sendKeys(text+"_Updated");
		
		
		
	}
	
	
	//Added by Raju 
	public void SearchContentAndValidate(String Contentname)
	{
		
		try
		{
			
		GenericFunctions.waitForElementToAppear(createUserPage.searchForReview);
		ExtentTestManager.getTest().log(LogStatus.INFO, "User is Searching for the content in search field");
				createUserPage.searchForReview.sendKeys(Contentname);
				GenericFunctions.waitWebDriver(6000);
				SoftAssert softAssert = new SoftAssert();
				
				GenericFunctions.waitForElementToAppear(contentResourcePage.VerifySearchedContent);
						String ContentType=contentResourcePage.VerifySearchedContent.getText();
						System.out.println(ContentType);
						
						System.out.println(Contentname);
						switch (Contentname) {
						case "CourseA":
														
								softAssert.assertEquals(ContentType,"Course");
								ExtentTestManager.getTest().log(LogStatus.PASS, "Search Content is displayed Succesfully");
								break;
					
					
												
							
						case "BookA":
						
								softAssert.assertEquals(ContentType,"TextBook");
								ExtentTestManager.getTest().log(LogStatus.PASS, "Search Content is displayed Succesfully");
							break;
					
                           
							
						case "LessonA":
                            softAssert.assertEquals(ContentType,"LessonPlan");
                            ExtentTestManager.getTest().log(LogStatus.PASS, "Search Content is displayed Succesfully");
							break;
							
						case "Automation Content":
                            softAssert.assertEquals(ContentType,"Resource");
                            ExtentTestManager.getTest().log(LogStatus.PASS, "Search Content is displayed Succesfully");
							break;
							
						case "Automation Collection":
                            softAssert.assertEquals(ContentType,"Collection");
                            ExtentTestManager.getTest().log(LogStatus.PASS, "Search Content is displayed Succesfully");
							break;
							
							
						default:
							System.out.println(Contentname);
							ExtentTestManager.getTest().log(LogStatus.FAIL, "Search Content is Not displayed Succesfully");
						}
		}
		catch(Exception e)
		{
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed on validating Searched Content in All my content Page");
			ExtentTestManager.getTest().log(LogStatus.FAIL,"Exception Message: "+e.getLocalizedMessage());
			System.out.println("Failed on validating Searched Content in All my content Page");
			Assert.fail("Failed on validating Searched Content in All my content Page");
			
		}
					
	}
	
	//Added by Raju 
	public void VerifySortByIsExists()
	{
		try
		{
		SoftAssert softAssert = new SoftAssert();
		
		ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to Click on Library Page");
		GenericFunctions.waitForElementToAppear(contentResourcePage.ClickOnLibrary);
			contentResourcePage.ClickOnLibrary.click();
			ExtentTestManager.getTest().log(LogStatus.INFO, "Click on Library Page");
		//softAssert.assertTrue(true);
		
		
		
		ExtentTestManager.getTest().log(LogStatus.INFO, "Validate the SortBy Text & SortyBy Option in Library Page");
		GenericFunctions.waitForElementToAppear(contentResourcePage.VerifySortBy);
		if(contentResourcePage.VerifySortBy.isDisplayed())
		{
			String ActualValue=contentResourcePage.VerifySortBy.getText();
			softAssert.assertEquals(ActualValue,"Sort by:");
			
			//ExtentTestManager.getTest().log(LogStatus.INFO, "Click on SortBy Dropdown in Library Page");
			GenericFunctions.waitForElementToAppear(contentResourcePage.ClickSortByDropDown);
			contentResourcePage.ClickSortByDropDown.click();
			
			//ExtentTestManager.getTest().log(LogStatus.INFO, "Validate Modified option in Dropdown in Library Page");
			String OptionValue1=contentResourcePage.VerifySortByOptionList.getText();
			softAssert.assertEquals(OptionValue1,"Modified On");
			
			//ExtentTestManager.getTest().log(LogStatus.INFO, "Validate CreatedOn option in Dropdown in Library Page");
		String OptionValue2=contentResourcePage.VerifySortByOptionList1.getText();
		softAssert.assertEquals(OptionValue2,"Created On");

		softAssert.assertAll();
		
		ExtentTestManager.getTest().log(LogStatus.PASS,"SortBy Option has been verified in Library Page");
		}
		else
		{
			System.out.println("Could not verify elements");
			log.info("Could not verify elements");
		}
		
		}
		catch(Exception e)
		{
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed on validating SoryBy Options in Library Page");
			ExtentTestManager.getTest().log(LogStatus.FAIL,"Exception Message: "+e.getLocalizedMessage());
			System.out.println("Failed on validating SoryBy Options in Library Page");
			Assert.fail("Failed on validating SoryBy Options in Library Page");
			
		}


	}


}
