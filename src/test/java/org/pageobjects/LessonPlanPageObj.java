package org.pageobjects;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.awt.Robot;
import java.awt.Window;
import java.awt.event.KeyEvent;
import java.lang.reflect.GenericSignatureFormatError;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.apache.log4j.Logger;
import org.generic.ExtentTestManager;
import org.generic.GenericFunctions;
import org.generic.GetExcelFileData;
import org.generic.ReadTestDataFromExcel;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.page.CreatorUserPage;
import org.page.FlagReviewerPage;
import org.page.LessonPlanPage;
import org.page.PublicUserPage;
import org.page.UploadOrgPage;
import org.startup.BaseTest;
import org.testdata.TestDataForSunbird;
import org.testng.Assert;

import com.relevantcodes.extentreports.LogStatus;


public class LessonPlanPageObj extends BaseTest

{
			WebDriverWait wait = new WebDriverWait(driver,20);
			LessonPlanPage lessonPlanPageObj=PageFactory.initElements(driver, LessonPlanPage.class);
			static Logger log = Logger.getLogger(LessonPlanPageObj.class.getName());
			List <TestDataForSunbird> objListOFTestDataForSunbird= null ;
			GenericFunctions genereicFunction = new GenericFunctions();
			Actions action = new Actions(driver);
			Random rand = new Random();
			JavascriptExecutor js = (JavascriptExecutor)driver;

			// @author Sachin for the below method search in library :
			public void searchInLibrary()throws Exception
			{
				try
				{	
				ExtentTestManager.getTest().log(LogStatus.INFO, "To search Lesson Plan in Library and copy it");
				
	//				GenericFunctions.waitForElementToAppear(createUserPage.closePopUp);	
	//				createUserPage.closePopUp.click();
	//				GenericFunctions.waitWebDriver(2000);
					GenericFunctions.refreshWebPage();
					GenericFunctions.waitForElementToAppear(lessonPlanPageObj.headerLibrary);	
					lessonPlanPageObj.headerLibrary.click();
					GenericFunctions.waitWebDriver(4000);
					GenericFunctions.waitForElementToAppear(lessonPlanPageObj.mainSearch);				
					lessonPlanPageObj.mainSearch.sendKeys("Lesson Plan");
					GenericFunctions.waitWebDriver(2000);
					GenericFunctions.waitForElementToAppear(lessonPlanPageObj.mainSearchIcon);		
					lessonPlanPageObj.mainSearchIcon.click();
					GenericFunctions.waitWebDriver(2000);
					GenericFunctions.waitForElementToAppear(lessonPlanPageObj.lessonPlan);				
					lessonPlanPageObj.lessonPlan.click();
					GenericFunctions.waitWebDriver(2000);
					GenericFunctions.waitForElementToAppear(lessonPlanPageObj.copyLessonPlan);				
					lessonPlanPageObj.copyLessonPlan.click();
					GenericFunctions.waitWebDriver(4000);
					Assert.assertTrue(true);
					System.out.println("Lesson Plan Copied");
					if(lessonPlanPageObj.copyLessonPlan.isDisplayed())
					{
						lessonPlanPageObj.copyLessonPlan.click();
						GenericFunctions.waitWebDriver(2000);
						Assert.assertTrue(true," Lesson Plan Copied Successfully");
						System.out.println("Lesson Plan Copied Successfully");
						log.info(" Lesson Plan Copied Successfully");
					}
					else
					{
						System.out.println("Lesson Plan Could not be copied");
						log.info("Lesson Plan Could not be copied");
					}
					
					GenericFunctions.waitForElementToAppear(lessonPlanPageObj.editDetails);	
					
					if(lessonPlanPageObj.editDetails.isDisplayed())
					{
						Assert.assertTrue(true,"On copy icon click user is redirected to collection editor with newly copied content in edit mode successfully");
						System.out.println("On copy icon click user is redirected to collection editor with newly copied content in edit mode successfully");
						log.info("On copy icon click user is redirected to collection editor with newly copied content in edit mode successfully");
					}
					
				else
					{
						System.out.println("Either User is NOT REDIRECTED properly or NOT in EDIT mode");
						log.info("Either User is NOT REDIRECTED properly or NOT in EDIT mode");
					}
					

		           }
				catch(Exception e)
				{
				ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed on searching LessonPlan in library and copying it");
				ExtentTestManager.getTest().log(LogStatus.FAIL, "Exception Message: " + e.getLocalizedMessage());
				log.error("Exception In the method searchInLibrary" + e.getLocalizedMessage());
				Assert.fail("Failed on searching LessonPlan in library and copying it, Exception : " + e.getLocalizedMessage());	
				}

		   }
			
			
			
			
			// @author Sachin : click on workspace 
			public void clickWorkspace()throws Exception{
				try
				{	
				GenericFunctions.refreshWebPage();
				ExtentTestManager.getTest().log(LogStatus.INFO, "To verify navigating to workspace");
	//			GenericFunctions.waitForElementToAppear(lessonPlanPageObj.closePopUp);
	//			lessonPlanPageObj.closePopUp.click();
				GenericFunctions.waitWebDriver(2000);
				GenericFunctions.waitForElementToAppear(lessonPlanPageObj.workSpace);
				lessonPlanPageObj.workSpace.click();
				GenericFunctions.waitWebDriver(2000);
					
				}
				catch (Exception e) 
				{
					ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed on navigating to workspace");
					ExtentTestManager.getTest().log(LogStatus.FAIL, "Exception Message: " + e.getLocalizedMessage());
					log.error("Exception In the method searchInLibrary" + e.getLocalizedMessage());
					Assert.fail("Failed on navigating to workspace, Exception : " + e.getLocalizedMessage());
				}
			}
			
			
			
			public void createLessonPlanpopUp() throws Exception{
				
				try{
					ExtentTestManager.getTest().log(LogStatus.INFO, "To verify navigating to workspace");
					lessonPlanPageObj.LessonPlan.click();
					GenericFunctions.waitWebDriver(2000);
					
					String LessonPlanTitle = "TestAutomationqwerty";
					lessonPlanPageObj.LessonPlanNamePlaceHolder.click();
					lessonPlanPageObj.LessonPlanNamePlaceHolder.sendKeys(LessonPlanTitle);				
					GenericFunctions.waitWebDriver(1000);					
					lessonPlanPageObj.startCreatingButton.click();
					GenericFunctions.waitWebDriver(2000);
				    }
				  catch(Exception e)
				    {
						ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed on navigating to workspace");
						ExtentTestManager.getTest().log(LogStatus.FAIL, "Exception Message: " + e.getLocalizedMessage());
						log.error("Exception In the method searchInLibrary" + e.getLocalizedMessage());
						Assert.fail("Failed on navigating to workspace, Exception : " + e.getLocalizedMessage()); 
				    }
			}
			
			
			
			// @author Sachin fill all the details and click on start creating :
			public void createChildNodes()throws Exception{
					 try{
						ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to create 3 child nodes");
						driver.switchTo().frame(0);
						// Creating 1st child node
						GenericFunctions.waitForElementToAppearOnScreen(lessonPlanPageObj.newChildButton);
						lessonPlanPageObj.newChildButton.click();
						GenericFunctions.waitWebDriver(2000);
						
						lessonPlanPageObj.childUnitTitle.click();
						lessonPlanPageObj.childUnitTitle.clear();
						GenericFunctions.waitWebDriver(1000);
						
						lessonPlanPageObj.childUnitTitle.sendKeys("AutomationTitle1");
						GenericFunctions.waitWebDriver(2000);
						
						lessonPlanPageObj.descriptionPlaceHolder.sendKeys("Description1");
						GenericFunctions.waitWebDriver(2000);
						
						lessonPlanPageObj.addNotesPlaceHolder.click();
						lessonPlanPageObj.addNotesPlaceHolder.sendKeys("Notes1");
						
						lessonPlanPageObj.addResource.click();
						GenericFunctions.waitWebDriver(1000);
						
						lessonPlanPageObj.latestResourceCheckbox.click();
						GenericFunctions.waitWebDriver(1000);
						
						if(lessonPlanPageObj.proceedButton.isDisplayed())
						{
							lessonPlanPageObj.proceedButton.click();
							GenericFunctions.waitWebDriver(2000);
							Assert.assertTrue(true,"User is able to create the first child node successfully");
							System.out.println("User is able to create the first child node successfully");
							log.info(" User is trying to able the first child node successfully");
						
						}
						else
						{
							System.out.println("User could not create the first child node");
							log.info("User could not create the first child node");	
						}
						
						
						// Creating 2nd child node					
						
						lessonPlanPageObj.newChildButton.click();
						GenericFunctions.waitWebDriver(2000);
						
						lessonPlanPageObj.childUnitTitle.click();
						lessonPlanPageObj.childUnitTitle.clear();
						GenericFunctions.waitWebDriver(1000);
						
						lessonPlanPageObj.childUnitTitle.sendKeys("AutomationTitle2");
						GenericFunctions.waitWebDriver(2000);
						
						lessonPlanPageObj.descriptionPlaceHolder.click();
						lessonPlanPageObj.descriptionPlaceHolder.sendKeys("Description2");
						GenericFunctions.waitWebDriver(2000);
						
						lessonPlanPageObj.addNotesPlaceHolder.click();
						lessonPlanPageObj.addNotesPlaceHolder.sendKeys("Notes2");
						
						lessonPlanPageObj.addResource.click();
						GenericFunctions.waitWebDriver(1000);
						
						lessonPlanPageObj.latestResourceCheckbox.click();
						GenericFunctions.waitWebDriver(1000);
						
						if(lessonPlanPageObj.proceedButton.isDisplayed())
						{
							lessonPlanPageObj.proceedButton.click();
							GenericFunctions.waitWebDriver(2000);
							Assert.assertTrue(true,"User is able to create the second child node successfully");
							System.out.println("User is able to create the second child node successfully");
							log.info("User is able to create the second child node successfully");
						
						}
						else
						{
							System.out.println("User could not create the second child node");
							log.info("User could not create the second child node");	
						}
						
						
						// Creating 3d child node					
						
						lessonPlanPageObj.newChildButton.click();
						GenericFunctions.waitWebDriver(2000);
						
						lessonPlanPageObj.childUnitTitle.click();
						lessonPlanPageObj.childUnitTitle.clear();
						GenericFunctions.waitWebDriver(1000);
						
						lessonPlanPageObj.childUnitTitle.sendKeys("AutomationTitle3");
						GenericFunctions.waitWebDriver(2000);
						
						lessonPlanPageObj.descriptionPlaceHolder.click();
						lessonPlanPageObj.descriptionPlaceHolder.sendKeys("Description3");
						GenericFunctions.waitWebDriver(2000);
						
						lessonPlanPageObj.addNotesPlaceHolder.click();
						lessonPlanPageObj.addNotesPlaceHolder.sendKeys("Notes3");
						
						lessonPlanPageObj.addResource.click();
						GenericFunctions.waitWebDriver(1000);
						
						lessonPlanPageObj.latestResourceCheckbox.click();
						GenericFunctions.waitWebDriver(1000);
						
						if(lessonPlanPageObj.proceedButton.isDisplayed())
						{
							lessonPlanPageObj.proceedButton.click();
							GenericFunctions.waitWebDriver(2000);
							Assert.assertTrue(true,"User is able to create the third child node successfully");
							System.out.println("User is able to create the third child node successfully");
							log.info("User is able to create the third child node successfully");
						
						}
						else
						{
							System.out.println("User could not create the third child node");
							log.info("User could not create the third child node");	
						}	
						
					   }
					 catch(Exception e)
					 {
						ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed on creating 3 child nodes");
						ExtentTestManager.getTest().log(LogStatus.FAIL, "Exception Message: " + e.getLocalizedMessage());
						log.error("Exception In the method createChildNodes" + e.getLocalizedMessage());
						Assert.fail("FFailed on creating 3 child nodes, Exception : " + e.getLocalizedMessage());
					 }
	       }
			
			
			
			// @author Sachin Lesson Plan with three resources  :
			public void lessonPlanWithThreeResources()throws Exception{
		
					try{
					ExtentTestManager.getTest().log(LogStatus.INFO, "To verify creating a lesson plan with three resources");
					// Creating 1st child node
					driver.switchTo().frame(0);
					GenericFunctions.waitForElementToAppearOnScreen(lessonPlanPageObj.newChildButton);
					lessonPlanPageObj.newChildButton.click();
					GenericFunctions.waitWebDriver(2000);
					
					lessonPlanPageObj.childUnitTitle.click();
					lessonPlanPageObj.childUnitTitle.clear();
					GenericFunctions.waitWebDriver(1000);
					
					lessonPlanPageObj.childUnitTitle.sendKeys("AutomationTitle1");
					GenericFunctions.waitWebDriver(2000);
					
					lessonPlanPageObj.descriptionPlaceHolder.click();
					lessonPlanPageObj.descriptionPlaceHolder.sendKeys("Description1");
					GenericFunctions.waitWebDriver(2000);
					
					lessonPlanPageObj.addNotesPlaceHolder.click();
					lessonPlanPageObj.addNotesPlaceHolder.sendKeys("Notes1");
					
					lessonPlanPageObj.addResource.click();
					GenericFunctions.waitWebDriver(1000);
					
					lessonPlanPageObj.latestResourceCheckbox.click();
					GenericFunctions.waitWebDriver(1000);
										
					lessonPlanPageObj.secondResourceCheckbox.click();
					GenericFunctions.waitWebDriver(1000);
					
					lessonPlanPageObj.thirdResourceCheckbox.click();
					GenericFunctions.waitWebDriver(1000);					
					
					lessonPlanPageObj.proceedButton.click();
					GenericFunctions.waitWebDriver(2000);
					
					lessonPlanPageObj.firstResourcePreview.click();
					GenericFunctions.waitWebDriver(2000);
					if(lessonPlanPageObj.contentPreview.isDisplayed())
					{
					Assert.assertTrue(true,"User is able to successfully preview the lesson plan before sending it to review");
					System.out.println("User is able to successfully preview the lesson plan before sending it to review");
					log.info("User is able to successfully preview the lesson plan before sending it to review");
					}
					
					lessonPlanPageObj.lessonPlanTitle.click();
					GenericFunctions.waitWebDriver(2000);
					lessonPlanPageObj.secondResourceDelete.click();
					GenericFunctions.waitWebDriver(2000);
					
					lessonPlanPageObj.confirmDelete.click();
					GenericFunctions.waitWebDriver(2000);
					Assert.assertTrue(true,"User is able to successfully remove resource from the lesson plan");
					System.out.println("User is able to successfully remove resource from the lesson plan");
					log.info("User is able to successfully remove resource from the lesson plan");
					
					lessonPlanPageObj.secondResourceDelete.click();
					GenericFunctions.waitWebDriver(2000);
					Assert.assertTrue(true,"Resource stays in the lessonplan when No selected on the confirmation pop up");
					System.out.println("Resource stays in the lessonplan when No selected on the confirmation pop up");
					log.info("Resource stays in the lessonplan when No selected on the confirmation pop up");
					
					lessonPlanPageObj.closeDialog.click();
					GenericFunctions.waitWebDriver(2000);	
				   }
				  catch(Exception e)
				  {
					ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed on creating a lesson plan with three resources");
					ExtentTestManager.getTest().log(LogStatus.FAIL, "Exception Message: " + e.getLocalizedMessage());
					log.error("Exception In the method lessonPlanWithThreeResources" + e.getLocalizedMessage());
					Assert.fail("Failed on creating a lesson plan with three resources, Exception : " + e.getLocalizedMessage());
				  }
	}
			
			
			// @author Sachin Lesson Plan with three resources  :
			public void editDetailsAndSave()throws Exception {
				
			 try {  
				    ExtentTestManager.getTest().log(LogStatus.INFO, "To verify editing the lesson plan details and save");
					lessonPlanPageObj.editDetails.click();
					GenericFunctions.waitWebDriver(1000);	
					//driver.switchTo().frame(0);
					lessonPlanPageObj.editDetailsTitle.click();
					lessonPlanPageObj.editDetailsTitle.clear();
					lessonPlanPageObj.editDetailsTitle.sendKeys("AUTOMATION123");
					GenericFunctions.waitWebDriver(1000);
					
					lessonPlanPageObj.editDetailsDescription.click();
					lessonPlanPageObj.editDetailsDescription.clear();
					lessonPlanPageObj.editDetailsDescription.sendKeys("Description1");
					GenericFunctions.waitWebDriver(1000);
					
					lessonPlanPageObj.editDetailsKeyword.click();
					lessonPlanPageObj.editDetailsKeyword.sendKeys("Keyword1");
					GenericFunctions.waitWebDriver(1000);					
					
					GenericFunctions.waitTillTheElementIsVisibleAndClickable(lessonPlanPageObj.editDetailsCurriculum);
					lessonPlanPageObj.editDetailsCurriculum.click();
					GenericFunctions.waitWebDriver(2000);					
					GenericFunctions.waitTillTheElementIsVisibleAndClickable(lessonPlanPageObj.editDetailsRajasthan);
					lessonPlanPageObj.editDetailsRajasthan.isSelected();
					GenericFunctions.waitWebDriver(2000);
					
					GenericFunctions.waitTillTheElementIsVisibleAndClickable(lessonPlanPageObj.editDetailsClass);
					lessonPlanPageObj.editDetailsClass.click();
					GenericFunctions.waitWebDriver(1000);
					GenericFunctions.waitTillTheElementIsVisibleAndClickable(lessonPlanPageObj.editDetailsClass10);
					lessonPlanPageObj.editDetailsClass10.click();
					GenericFunctions.waitWebDriver(1000);
					
					GenericFunctions.waitTillTheElementIsVisibleAndClickable(lessonPlanPageObj.editDetailsSubject);
					lessonPlanPageObj.editDetailsSubject.click();
					GenericFunctions.waitWebDriver(1000);
					GenericFunctions.waitTillTheElementIsVisibleAndClickable(lessonPlanPageObj.editDetailsMathematics);
					lessonPlanPageObj.editDetailsMathematics.click();
					GenericFunctions.waitWebDriver(1000);
					
					GenericFunctions.waitTillTheElementIsVisibleAndClickable(lessonPlanPageObj.editDetailsMedium);
					lessonPlanPageObj.editDetailsMedium.click();
					GenericFunctions.waitWebDriver(1000);
					GenericFunctions.waitTillTheElementIsVisibleAndClickable(lessonPlanPageObj.editDetailsHindi);
					lessonPlanPageObj.editDetailsHindi.click();
					GenericFunctions.waitWebDriver(1000);
					
					GenericFunctions.waitTillTheElementIsVisibleAndClickable(lessonPlanPageObj.editDetailsAudience);
					lessonPlanPageObj.editDetailsAudience.click();
					GenericFunctions.waitWebDriver(1000);					
					GenericFunctions.waitTillTheElementIsVisibleAndClickable(lessonPlanPageObj.editDetailsInstructor);
					lessonPlanPageObj.editDetailsInstructor.click();
					GenericFunctions.waitWebDriver(1000);
					
					GenericFunctions.waitTillTheElementIsVisibleAndClickable(lessonPlanPageObj.editDetailsOwner);
					GenericFunctions.scrollToElement(lessonPlanPageObj.editDetailsOwner);
					lessonPlanPageObj.editDetailsOwner.click();
					GenericFunctions.waitWebDriver(2000);
					GenericFunctions.waitTillTheElementIsVisibleAndClickable(lessonPlanPageObj.editDetailsTestAutoOrg);
					lessonPlanPageObj.editDetailsTestAutoOrg.click();
					GenericFunctions.waitWebDriver(1000);
					
					lessonPlanPageObj.editDetailsSave.click();
					GenericFunctions.waitWebDriver(1000);	
					Assert.assertTrue(true,"User is able to successfully edit the lesson plan before sending it for review");
					System.out.println("User is able to successfully edit the lesson plan before sending it for review");
					log.info("User is able to successfully edit the lesson plan before sending it for review");
					GenericFunctions.waitWebDriver(2000);
					
					lessonPlanPageObj.saveClose.click();
					GenericFunctions.waitWebDriver(1000);
					
					lessonPlanPageObj.editDetails.click();
					Assert.assertTrue(true,"User is able to see the updated data on clicking EDIT DETAILS for the second time");
					System.out.println("User is able to see the updated data on clicking EDIT DETAILS for the second time");
					log.info("User is able to see the updated data on clicking EDIT DETAILS for the second time");
					GenericFunctions.waitWebDriver(1000);					
				  }  
				 catch(Exception e)
			 
				  {
					 ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed on editng the lesson plan details");
					 ExtentTestManager.getTest().log(LogStatus.FAIL, "Exception Message: " + e.getLocalizedMessage());
					 log.error("Exception In the method editDetailsAndSave" + e.getLocalizedMessage());
					 Assert.fail("Failed on editng the lesson plan details, Exception : " + e.getLocalizedMessage());
				  }
		     
			}
			
			
			
			
			// @author Sachin Lesson Plan with three resources  :
			public void limitedPublishing()throws Exception {
				
				 try {  
					    ExtentTestManager.getTest().log(LogStatus.INFO, "To verify deleting the created lesson plan");
						lessonPlanPageObj.save.click();
						GenericFunctions.waitWebDriver(2000);
						GenericFunctions.waitTillTheElementIsVisibleAndClickable(lessonPlanPageObj.limitedShareDropdown);
						lessonPlanPageObj.limitedShareDropdown.click();
						GenericFunctions.waitWebDriver(1000);
						GenericFunctions.waitTillTheElementIsVisibleAndClickable(lessonPlanPageObj.limitedSharing);
						lessonPlanPageObj.limitedSharing.click();
						GenericFunctions.waitWebDriver(2000);
						lessonPlanPageObj.limitedPublishingSection.click();
						GenericFunctions.waitWebDriver(2000);
						String publishedContentTitle = lessonPlanPageObj.publishedContentTitle.getText();
						if(publishedContentTitle.equals("AutomationTitle1"))
						{
						GenericFunctions.waitTillTheElementIsVisibleAndClickable(lessonPlanPageObj.shareIcon);
						lessonPlanPageObj.shareIcon.click();
						Assert.assertTrue(true,"Lesson plan is displayed under limited publishing section successfully");
						System.out.println("Lesson plan is displayed under limited publishing section successfully");
						log.info("Lesson plan is displayed under limited publishing section successfully");
						
						GenericFunctions.waitWebDriver(2000);
						lessonPlanPageObj.copyLink.click();
						GenericFunctions.waitWebDriver(2000);
						lessonPlanPageObj.closeSharePopup.click();
						Assert.assertTrue(true,"Share popup is correctly displayed");
						System.out.println("Share popup is correctly displayed");
						log.info("Share popup is correctly displayed");
						GenericFunctions.waitWebDriver(2000);
						
						lessonPlanPageObj.lessonPlanTrash.click();
						GenericFunctions.waitWebDriver(2000);
						String deletesLessonPlan = lessonPlanPageObj.nameOfLessonPlan.getText();
						GenericFunctions.waitWebDriver(2000);
						lessonPlanPageObj.deleteConfirmYes.click();
						GenericFunctions.waitWebDriver(2000);
						
						
						((JavascriptExecutor)driver).executeScript("window.open()");
						ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
						driver.switchTo().window(tabs.get(1));					
						driver.get("https://staging.open-sunbird.org/resources/play/collection/do_2126399173546475521525/Unlisted");
						GenericFunctions.waitWebDriver(1000);
						String originalHandle = driver.getWindowHandle();
						
						// To close the new tab
					
						for(String handle : driver.getWindowHandles()) 
						{
							if (!handle.equals(originalHandle)) 
							 {
								driver.switchTo().window(handle);
								driver.close();
							 }
						}
						Assert.assertTrue(true,"Content is accessible from the link shared");
						System.out.println("Content is accessible from the link shared");
						log.info("Content is accessible from the link shared");
						
						
						lessonPlanPageObj.workSpace.click();
						GenericFunctions.waitWebDriver(2000);
						lessonPlanPageObj.allMyContent.click();
						GenericFunctions.waitWebDriver(2000);
						lessonPlanPageObj.searchContent.click();
						lessonPlanPageObj.searchContent.sendKeys(deletesLessonPlan);
						GenericFunctions.waitWebDriver(2000);
						Assert.assertTrue(true,"Content is successfully removed from the AllMyContent Section");
						System.out.println("Content is successfully removed from the AllMyContent Section");
						log.info("Content is successfully removed from the AllMyContent Section");
					  } 
				 }
				 catch(Exception e)
				 
				     {
					 ExtentTestManager.getTest().log(LogStatus.FAIL, "failed To verify deleting the limited published lesson plan");
					 ExtentTestManager.getTest().log(LogStatus.FAIL, "Exception Message: " + e.getLocalizedMessage());
					 log.error("Exception In the method limitedPublishing" + e.getLocalizedMessage());
					 Assert.fail("failed To verify deleting the limited published lesson plan, Exception : " + e.getLocalizedMessage());
					 }
			}
		
			
		
			
			public void saveLessonPlanAndSendForReview()throws Exception{
				
					 try{
						ExtentTestManager.getTest().log(LogStatus.INFO, "To verify saving and sending the Lesson Plan for review");
						lessonPlanPageObj.save.click();
						GenericFunctions.waitWebDriver(5000);
						GenericFunctions.waitTillTheElementIsVisibleAndClickable(lessonPlanPageObj.sendForReview);
						lessonPlanPageObj.sendForReview.click();
						GenericFunctions.waitWebDriver(2000);
						
						lessonPlanPageObj.sendaddImage.click();
						GenericFunctions.waitWebDriver(2000);
						
						lessonPlanPageObj.sendThumbnail1.click();
						GenericFunctions.waitWebDriver(2000);
						
						lessonPlanPageObj.sendSelect.click();
						GenericFunctions.waitWebDriver(2000);					
						
						lessonPlanPageObj.sendEditDetailsTitle.click();
						lessonPlanPageObj.sendEditDetailsTitle.clear();
						lessonPlanPageObj.sendEditDetailsTitle.sendKeys("AutoTitle");
						GenericFunctions.waitWebDriver(2000);
						
						lessonPlanPageObj.sendEditDetailsDescription.click();
						lessonPlanPageObj.sendEditDetailsDescription.clear();
						lessonPlanPageObj.sendEditDetailsDescription.sendKeys("AutoDescription");
						GenericFunctions.waitWebDriver(2000);
						
						lessonPlanPageObj.sendKeywords.click();
						lessonPlanPageObj.sendKeywords.sendKeys("AutoKeyword");
						GenericFunctions.waitWebDriver(2000);
						
						lessonPlanPageObj.sendCurriculum.click();
						GenericFunctions.waitWebDriver(2000);
						
						lessonPlanPageObj.sendRajasthan.click();
						GenericFunctions.waitWebDriver(2000);
						
						lessonPlanPageObj.sendClass.click();
						GenericFunctions.waitWebDriver(2000);
						
						lessonPlanPageObj.sendClass10.click();
						GenericFunctions.waitWebDriver(2000);
						
						lessonPlanPageObj.sendSubject.click();
						GenericFunctions.waitWebDriver(2000);
						
						lessonPlanPageObj.sendScience.click();
						GenericFunctions.waitWebDriver(2000);
						
						lessonPlanPageObj.sendMedium.click();
						GenericFunctions.waitWebDriver(2000);
						
						lessonPlanPageObj.sendEnglish.click();
						GenericFunctions.waitWebDriver(2000);
						
						lessonPlanPageObj.sendAudience.click();
						GenericFunctions.waitWebDriver(2000);
						
						lessonPlanPageObj.sendInstructor.click();
						GenericFunctions.waitWebDriver(2000);
						
						lessonPlanPageObj.sendOwner.click();
						GenericFunctions.waitWebDriver(2000);
						
						lessonPlanPageObj.sendTestContentcreator.click();
						GenericFunctions.waitWebDriver(2000);
	
						lessonPlanPageObj.sendSave.click();
						GenericFunctions.waitWebDriver(2000);
					    }	
					 catch(Exception e)
					 {
						 ExtentTestManager.getTest().log(LogStatus.FAIL, "To verify saving and sending the Lesson Plan for review");
						 ExtentTestManager.getTest().log(LogStatus.FAIL, "Exception Message: " + e.getLocalizedMessage());
						 log.error("Exception In the method saveLessonPlanAndSendForReview" + e.getLocalizedMessage());
						 Assert.fail("To verify saving and sending the Lesson Plan for review, Exception : " + e.getLocalizedMessage());
					 }
			    
			}
			
			
			
			// @author Sachin Lesson Plan with three resources  :
			public void createChildNode()throws Exception{
			   try{	
				ExtentTestManager.getTest().log(LogStatus.INFO, "To verify creating a lesson plan");
				// Creating 1st child node
				driver.switchTo().frame(0);
				GenericFunctions.waitForElementToAppearOnScreen(lessonPlanPageObj.newChildButton);
				lessonPlanPageObj.newChildButton.click();
				GenericFunctions.waitWebDriver(2000);
				
				lessonPlanPageObj.childUnitTitle.click();
				lessonPlanPageObj.childUnitTitle.clear();
				GenericFunctions.waitWebDriver(1000);
				
				lessonPlanPageObj.childUnitTitle.sendKeys("AutomationTitle1");
				GenericFunctions.waitWebDriver(2000);
				
				lessonPlanPageObj.descriptionPlaceHolder.click();
				lessonPlanPageObj.descriptionPlaceHolder.sendKeys("Description1");
				GenericFunctions.waitWebDriver(2000);
				
				lessonPlanPageObj.addNotesPlaceHolder.click();
				lessonPlanPageObj.addNotesPlaceHolder.sendKeys("Notes1");
				
				lessonPlanPageObj.addResource.click();
				GenericFunctions.waitWebDriver(1000);
				
				lessonPlanPageObj.latestResourceCheckbox.click();
				GenericFunctions.waitWebDriver(1000);
				
				lessonPlanPageObj.proceedButton.click();
				Assert.assertTrue(true,"User is able to successfully create a child  node");
				System.out.println("User is able to successfully create a child  node");
				log.info("User is able to successfully create a child  node");
				GenericFunctions.waitWebDriver(2000);
			   }
			 catch(Exception e)
			 {
				ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed on creating the childnode");
				ExtentTestManager.getTest().log(LogStatus.FAIL, "Exception Message: " + e.getLocalizedMessage());
				log.error("Exception In the method createChildNode" + e.getLocalizedMessage());
				Assert.fail("Failed on creating the childnode , Exception : " + e.getLocalizedMessage());
			 }
			}
			
			

			    
			
}
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
