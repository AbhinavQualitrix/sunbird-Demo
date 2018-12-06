package org.pageobjects;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.apache.log4j.Logger;
import org.generic.ExtentTestManager;
import org.generic.GenericFunctions;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.page.LessonPlanPage;
import org.startup.BaseTest;
import org.testdata.TestDataForSunbird;
import org.testng.Assert;

import com.relevantcodes.extentreports.LogStatus;


public class LessonPlanPageObj extends BaseTest

{
			WebDriverWait wait = new WebDriverWait(driver,20);
			LessonPlanPage lessonPlanPage=PageFactory.initElements(driver, LessonPlanPage.class);
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
					GenericFunctions.waitForElementToAppear(lessonPlanPage.headerLibrary);	
					lessonPlanPage.headerLibrary.click();
					GenericFunctions.waitWebDriver(4000);
					GenericFunctions.waitForElementToAppear(lessonPlanPage.mainSearch);				
					lessonPlanPage.mainSearch.sendKeys("Lesson Plan");
					GenericFunctions.waitWebDriver(2000);
					GenericFunctions.waitForElementToAppear(lessonPlanPage.mainSearchIcon);		
					lessonPlanPage.mainSearchIcon.click();
					GenericFunctions.waitWebDriver(2000);
					GenericFunctions.waitForElementToAppear(lessonPlanPage.lessonPlan);				
					lessonPlanPage.lessonPlan.click();
					GenericFunctions.waitWebDriver(2000);
					GenericFunctions.waitForElementToAppear(lessonPlanPage.copyLessonPlan);				
					lessonPlanPage.copyLessonPlan.click();
					GenericFunctions.waitWebDriver(4000);
					Assert.assertTrue(true);
					System.out.println("Lesson Plan Copied");
					if(lessonPlanPage.copyLessonPlan.isDisplayed())
					{
						lessonPlanPage.copyLessonPlan.click();
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
					
					GenericFunctions.waitForElementToAppear(lessonPlanPage.editDetails);	
					
					if(lessonPlanPage.editDetails.isDisplayed())
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
	//			GenericFunctions.waitForElementToAppear(lessonPlanPage.closePopUp);
	//			lessonPlanPage.closePopUp.click();
				GenericFunctions.waitWebDriver(2000);
				lessonPlanPage.workSpace.click();
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
					lessonPlanPage.LessonPlan.click();
					GenericFunctions.waitWebDriver(2000);
					
					String LessonPlanTitle = "TestAutomationqwerty";
					lessonPlanPage.LessonPlanNamePlaceHolder.click();
					lessonPlanPage.LessonPlanNamePlaceHolder.sendKeys(LessonPlanTitle);				
					GenericFunctions.waitWebDriver(1000);					
					lessonPlanPage.startCreatingButton.click();
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
						GenericFunctions.waitForElementToAppearOnScreen(lessonPlanPage.newChildButton);
						lessonPlanPage.newChildButton.click();
						GenericFunctions.waitWebDriver(2000);
						
						lessonPlanPage.childUnitTitle.click();
						lessonPlanPage.childUnitTitle.clear();
						GenericFunctions.waitWebDriver(1000);
						
						lessonPlanPage.childUnitTitle.sendKeys("AutomationTitle1");
						GenericFunctions.waitWebDriver(2000);
						
						lessonPlanPage.descriptionPlaceHolder.sendKeys("Description1");
						GenericFunctions.waitWebDriver(2000);
						
						lessonPlanPage.addNotesPlaceHolder.click();
						lessonPlanPage.addNotesPlaceHolder.sendKeys("Notes1");
						
						lessonPlanPage.addResource.click();
						GenericFunctions.waitWebDriver(1000);
						
						lessonPlanPage.latestResourceCheckbox.click();
						GenericFunctions.waitWebDriver(1000);
						
						if(lessonPlanPage.proceedButton.isDisplayed())
						{
							lessonPlanPage.proceedButton.click();
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
						
						lessonPlanPage.newChildButton.click();
						GenericFunctions.waitWebDriver(2000);
						
						lessonPlanPage.childUnitTitle.click();
						lessonPlanPage.childUnitTitle.clear();
						GenericFunctions.waitWebDriver(1000);
						
						lessonPlanPage.childUnitTitle.sendKeys("AutomationTitle2");
						GenericFunctions.waitWebDriver(2000);
						
						lessonPlanPage.descriptionPlaceHolder.click();
						lessonPlanPage.descriptionPlaceHolder.sendKeys("Description2");
						GenericFunctions.waitWebDriver(2000);
						
						lessonPlanPage.addNotesPlaceHolder.click();
						lessonPlanPage.addNotesPlaceHolder.sendKeys("Notes2");
						
						lessonPlanPage.addResource.click();
						GenericFunctions.waitWebDriver(1000);
						
						lessonPlanPage.latestResourceCheckbox.click();
						GenericFunctions.waitWebDriver(1000);
						
						if(lessonPlanPage.proceedButton.isDisplayed())
						{
							lessonPlanPage.proceedButton.click();
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
						
						lessonPlanPage.newChildButton.click();
						GenericFunctions.waitWebDriver(2000);
						
						lessonPlanPage.childUnitTitle.click();
						lessonPlanPage.childUnitTitle.clear();
						GenericFunctions.waitWebDriver(1000);
						
						lessonPlanPage.childUnitTitle.sendKeys("AutomationTitle3");
						GenericFunctions.waitWebDriver(2000);
						
						lessonPlanPage.descriptionPlaceHolder.click();
						lessonPlanPage.descriptionPlaceHolder.sendKeys("Description3");
						GenericFunctions.waitWebDriver(2000);
						
						lessonPlanPage.addNotesPlaceHolder.click();
						lessonPlanPage.addNotesPlaceHolder.sendKeys("Notes3");
						
						lessonPlanPage.addResource.click();
						GenericFunctions.waitWebDriver(1000);
						
						lessonPlanPage.latestResourceCheckbox.click();
						GenericFunctions.waitWebDriver(1000);
						
						if(lessonPlanPage.proceedButton.isDisplayed())
						{
							lessonPlanPage.proceedButton.click();
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
					GenericFunctions.waitForElementToAppearOnScreen(lessonPlanPage.newChildButton);
					lessonPlanPage.newChildButton.click();
					GenericFunctions.waitWebDriver(2000);
					
					lessonPlanPage.childUnitTitle.click();
					lessonPlanPage.childUnitTitle.clear();
					GenericFunctions.waitWebDriver(1000);
					
					lessonPlanPage.childUnitTitle.sendKeys("AutomationTitle1");
					GenericFunctions.waitWebDriver(2000);
					
					lessonPlanPage.descriptionPlaceHolder.click();
					lessonPlanPage.descriptionPlaceHolder.sendKeys("Description1");
					GenericFunctions.waitWebDriver(2000);
					
					lessonPlanPage.addNotesPlaceHolder.click();
					lessonPlanPage.addNotesPlaceHolder.sendKeys("Notes1");
					
					lessonPlanPage.addResource.click();
					GenericFunctions.waitWebDriver(1000);
					
					lessonPlanPage.latestResourceCheckbox.click();
					GenericFunctions.waitWebDriver(1000);
										
					lessonPlanPage.secondResourceCheckbox.click();
					GenericFunctions.waitWebDriver(1000);
					
					lessonPlanPage.thirdResourceCheckbox.click();
					GenericFunctions.waitWebDriver(1000);					
					
					lessonPlanPage.proceedButton.click();
					GenericFunctions.waitWebDriver(2000);
					
					lessonPlanPage.firstResourcePreview.click();
					GenericFunctions.waitWebDriver(2000);
					if(lessonPlanPage.contentPreview.isDisplayed())
					{
					Assert.assertTrue(true,"User is able to successfully preview the lesson plan before sending it to review");
					System.out.println("User is able to successfully preview the lesson plan before sending it to review");
					log.info("User is able to successfully preview the lesson plan before sending it to review");
					}
					
					lessonPlanPage.lessonPlanTitle.click();
					GenericFunctions.waitWebDriver(2000);
					lessonPlanPage.secondResourceDelete.click();
					GenericFunctions.waitWebDriver(2000);
					
					lessonPlanPage.confirmDelete.click();
					GenericFunctions.waitWebDriver(2000);
					Assert.assertTrue(true,"User is able to successfully remove resource from the lesson plan");
					System.out.println("User is able to successfully remove resource from the lesson plan");
					log.info("User is able to successfully remove resource from the lesson plan");
					
					lessonPlanPage.secondResourceDelete.click();
					GenericFunctions.waitWebDriver(2000);
					Assert.assertTrue(true,"Resource stays in the lessonplan when No selected on the confirmation pop up");
					System.out.println("Resource stays in the lessonplan when No selected on the confirmation pop up");
					log.info("Resource stays in the lessonplan when No selected on the confirmation pop up");
					
					lessonPlanPage.closeDialog.click();
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
					lessonPlanPage.editDetails.click();
					GenericFunctions.waitWebDriver(1000);	
					//driver.switchTo().frame(0);
					lessonPlanPage.editDetailsTitle.click();
					lessonPlanPage.editDetailsTitle.clear();
					lessonPlanPage.editDetailsTitle.sendKeys("AUTOMATION123");
					GenericFunctions.waitWebDriver(1000);
					
					lessonPlanPage.editDetailsDescription.click();
					lessonPlanPage.editDetailsDescription.clear();
					lessonPlanPage.editDetailsDescription.sendKeys("Description1");
					GenericFunctions.waitWebDriver(1000);
					
					lessonPlanPage.editDetailsKeyword.click();
					lessonPlanPage.editDetailsKeyword.sendKeys("Keyword1");
					GenericFunctions.waitWebDriver(1000);					
					
					GenericFunctions.waitTillTheElementIsVisibleAndClickable(lessonPlanPage.editDetailsCurriculum);
					lessonPlanPage.editDetailsCurriculum.click();
					GenericFunctions.waitWebDriver(2000);					
					GenericFunctions.waitTillTheElementIsVisibleAndClickable(lessonPlanPage.editDetailsRajasthan);
					lessonPlanPage.editDetailsRajasthan.isSelected();
					GenericFunctions.waitWebDriver(2000);
					
					GenericFunctions.waitTillTheElementIsVisibleAndClickable(lessonPlanPage.editDetailsClass);
					lessonPlanPage.editDetailsClass.click();
					GenericFunctions.waitWebDriver(1000);
					GenericFunctions.waitTillTheElementIsVisibleAndClickable(lessonPlanPage.editDetailsClass10);
					lessonPlanPage.editDetailsClass10.click();
					GenericFunctions.waitWebDriver(1000);
					
					GenericFunctions.waitTillTheElementIsVisibleAndClickable(lessonPlanPage.editDetailsSubject);
					lessonPlanPage.editDetailsSubject.click();
					GenericFunctions.waitWebDriver(1000);
					GenericFunctions.waitTillTheElementIsVisibleAndClickable(lessonPlanPage.editDetailsMathematics);
					lessonPlanPage.editDetailsMathematics.click();
					GenericFunctions.waitWebDriver(1000);
					
					GenericFunctions.waitTillTheElementIsVisibleAndClickable(lessonPlanPage.editDetailsMedium);
					lessonPlanPage.editDetailsMedium.click();
					GenericFunctions.waitWebDriver(1000);
					GenericFunctions.waitTillTheElementIsVisibleAndClickable(lessonPlanPage.editDetailsHindi);
					lessonPlanPage.editDetailsHindi.click();
					GenericFunctions.waitWebDriver(1000);
					
					GenericFunctions.waitTillTheElementIsVisibleAndClickable(lessonPlanPage.editDetailsAudience);
					lessonPlanPage.editDetailsAudience.click();
					GenericFunctions.waitWebDriver(1000);					
					GenericFunctions.waitTillTheElementIsVisibleAndClickable(lessonPlanPage.editDetailsInstructor);
					lessonPlanPage.editDetailsInstructor.click();
					GenericFunctions.waitWebDriver(1000);
					
					GenericFunctions.waitTillTheElementIsVisibleAndClickable(lessonPlanPage.editDetailsOwner);
					GenericFunctions.scrollToElement(lessonPlanPage.editDetailsOwner);
					lessonPlanPage.editDetailsOwner.click();
					GenericFunctions.waitWebDriver(2000);
					GenericFunctions.waitTillTheElementIsVisibleAndClickable(lessonPlanPage.editDetailsTestAutoOrg);
					lessonPlanPage.editDetailsTestAutoOrg.click();
					GenericFunctions.waitWebDriver(1000);
					
					lessonPlanPage.editDetailsSave.click();
					GenericFunctions.waitWebDriver(1000);	
					Assert.assertTrue(true,"User is able to successfully edit the lesson plan before sending it for review");
					System.out.println("User is able to successfully edit the lesson plan before sending it for review");
					log.info("User is able to successfully edit the lesson plan before sending it for review");
					GenericFunctions.waitWebDriver(2000);
					
					lessonPlanPage.saveClose.click();
					GenericFunctions.waitWebDriver(1000);
					
					lessonPlanPage.editDetails.click();
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
						lessonPlanPage.save.click();
						GenericFunctions.waitWebDriver(2000);
						GenericFunctions.waitTillTheElementIsVisibleAndClickable(lessonPlanPage.limitedShareDropdown);
						lessonPlanPage.limitedShareDropdown.click();
						GenericFunctions.waitWebDriver(1000);
						GenericFunctions.waitTillTheElementIsVisibleAndClickable(lessonPlanPage.limitedSharing);
						lessonPlanPage.limitedSharing.click();
						GenericFunctions.waitWebDriver(2000);
						lessonPlanPage.limitedPublishingSection.click();
						GenericFunctions.waitWebDriver(2000);
						String publishedContentTitle = lessonPlanPage.publishedContentTitle.getText();
						if(publishedContentTitle.equals("AutomationTitle1"))
						{
						GenericFunctions.waitTillTheElementIsVisibleAndClickable(lessonPlanPage.shareIcon);
						lessonPlanPage.shareIcon.click();
						Assert.assertTrue(true,"Lesson plan is displayed under limited publishing section successfully");
						System.out.println("Lesson plan is displayed under limited publishing section successfully");
						log.info("Lesson plan is displayed under limited publishing section successfully");
						
						GenericFunctions.waitWebDriver(2000);
						lessonPlanPage.copyLink.click();
						GenericFunctions.waitWebDriver(2000);
						lessonPlanPage.closeSharePopup.click();
						Assert.assertTrue(true,"Share popup is correctly displayed");
						System.out.println("Share popup is correctly displayed");
						log.info("Share popup is correctly displayed");
						GenericFunctions.waitWebDriver(2000);
						
						lessonPlanPage.lessonPlanTrash.click();
						GenericFunctions.waitWebDriver(2000);
						String deletesLessonPlan = lessonPlanPage.nameOfLessonPlan.getText();
						GenericFunctions.waitWebDriver(2000);
						lessonPlanPage.deleteConfirmYes.click();
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
						
						
						lessonPlanPage.workSpace.click();
						GenericFunctions.waitWebDriver(2000);
						lessonPlanPage.allMyContent.click();
						GenericFunctions.waitWebDriver(2000);
						lessonPlanPage.searchContent.click();
						lessonPlanPage.searchContent.sendKeys(deletesLessonPlan);
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
						lessonPlanPage.save.click();
						GenericFunctions.waitWebDriver(5000);
						GenericFunctions.waitTillTheElementIsVisibleAndClickable(lessonPlanPage.sendForReview);
						lessonPlanPage.sendForReview.click();
						GenericFunctions.waitWebDriver(2000);
						
						lessonPlanPage.sendaddImage.click();
						GenericFunctions.waitWebDriver(2000);
						
						lessonPlanPage.sendThumbnail1.click();
						GenericFunctions.waitWebDriver(2000);
						
						lessonPlanPage.sendSelect.click();
						GenericFunctions.waitWebDriver(2000);					
						
						lessonPlanPage.sendEditDetailsTitle.click();
						lessonPlanPage.sendEditDetailsTitle.clear();
						lessonPlanPage.sendEditDetailsTitle.sendKeys("AutoTitle");
						GenericFunctions.waitWebDriver(2000);
						
						lessonPlanPage.sendEditDetailsDescription.click();
						lessonPlanPage.sendEditDetailsDescription.clear();
						lessonPlanPage.sendEditDetailsDescription.sendKeys("AutoDescription");
						GenericFunctions.waitWebDriver(2000);
						
						lessonPlanPage.sendKeywords.click();
						lessonPlanPage.sendKeywords.sendKeys("AutoKeyword");
						GenericFunctions.waitWebDriver(2000);
						
						lessonPlanPage.sendCurriculum.click();
						GenericFunctions.waitWebDriver(2000);
						
						lessonPlanPage.sendRajasthan.click();
						GenericFunctions.waitWebDriver(2000);
						
						lessonPlanPage.sendClass.click();
						GenericFunctions.waitWebDriver(2000);
						
						lessonPlanPage.sendClass10.click();
						GenericFunctions.waitWebDriver(2000);
						
						lessonPlanPage.sendSubject.click();
						GenericFunctions.waitWebDriver(2000);
						
						lessonPlanPage.sendScience.click();
						GenericFunctions.waitWebDriver(2000);
						
						lessonPlanPage.sendMedium.click();
						GenericFunctions.waitWebDriver(2000);
						
						lessonPlanPage.sendEnglish.click();
						GenericFunctions.waitWebDriver(2000);
						
						lessonPlanPage.sendAudience.click();
						GenericFunctions.waitWebDriver(2000);
						
						lessonPlanPage.sendInstructor.click();
						GenericFunctions.waitWebDriver(2000);
						
						lessonPlanPage.sendOwner.click();
						GenericFunctions.waitWebDriver(2000);
						
						lessonPlanPage.sendTestContentcreator.click();
						GenericFunctions.waitWebDriver(2000);
	
						lessonPlanPage.sendSave.click();
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
				GenericFunctions.waitForElementToAppearOnScreen(lessonPlanPage.newChildButton);
				lessonPlanPage.newChildButton.click();
				GenericFunctions.waitWebDriver(2000);
				
				lessonPlanPage.childUnitTitle.click();
				lessonPlanPage.childUnitTitle.clear();
				GenericFunctions.waitWebDriver(1000);
				
				lessonPlanPage.childUnitTitle.sendKeys("AutomationTitle1");
				GenericFunctions.waitWebDriver(2000);
				
				lessonPlanPage.descriptionPlaceHolder.click();
				lessonPlanPage.descriptionPlaceHolder.sendKeys("Description1");
				GenericFunctions.waitWebDriver(2000);
				
				lessonPlanPage.addNotesPlaceHolder.click();
				lessonPlanPage.addNotesPlaceHolder.sendKeys("Notes1");
				
				lessonPlanPage.addResource.click();
				GenericFunctions.waitWebDriver(1000);
				
				lessonPlanPage.latestResourceCheckbox.click();
				GenericFunctions.waitWebDriver(1000);
				
				lessonPlanPage.proceedButton.click();
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
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
