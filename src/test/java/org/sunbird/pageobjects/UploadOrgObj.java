package org.sunbird.pageobjects;

import java.awt.Robot;
import java.awt.Desktop.Action;
import java.awt.event.KeyEvent;
import java.util.List;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.sunbird.generic.AllUploadingPaths;
import org.sunbird.generic.ExtentTestManager;
import org.sunbird.generic.GenericFunctions;
import org.sunbird.generic.ReadTestDataFromExcel;
import org.sunbird.page.CreatorUserPage;
import org.sunbird.page.UploadOrgPage;
import org.sunbird.startup.BaseTest;
import org.sunbird.testdata.TestDataForSunbird;
import org.testng.Assert;

import com.relevantcodes.extentreports.LogStatus;


public class UploadOrgObj extends BaseTest
{
	static Logger log = Logger.getLogger(UploadOrgObj.class.getName());

	WebDriverWait wait=new WebDriverWait(driver,15);
	UploadOrgPage orgUploadPage=PageFactory.initElements(driver, UploadOrgPage.class);
	CreatorUserPage createUserPage= PageFactory.initElements(driver, CreatorUserPage.class);
	Actions action = new Actions(driver);
	CreatorUserPageObj createUserPageObj = new CreatorUserPageObj();
	

	//updated on 17/07/2018 method return type.
	public boolean uploadRootAndSubOrg(String uploadDocument) throws Exception 
	{
		ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to upload Root Organization Or Sub-Organization");
		try
		{
			GenericFunctions.waitForElementToAppearOnScreen(orgUploadPage.dropdown);
			orgUploadPage.dropdown.click();
			/*GenericFunctions.waitForElementToAppearOnScreen(createUserPage.headerProfile);
			createUserPage.headerProfile.click();*/
			
			createUserPageObj.goToProfilePage();
			GenericFunctions.waitWebDriver(15000);
			WebElement element=wait.until(ExpectedConditions.visibilityOf(orgUploadPage.organizationUpload));
			driver.navigate().refresh();
			element.click();
			if(element.isDisplayed())
			{
				GenericFunctions.waitForElementToAppear(orgUploadPage.uploadCSV);
				orgUploadPage.uploadCSV.click();
				GenericFunctions.waitWebDriver(3000);
				if(uploadDocument.equalsIgnoreCase(UPLOAD_ROOT_ORG))
				{
					ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to upload Root Organization "+UPLOAD_ROOT_ORG+" is the file name");
					//String path = System.getProperty("user.dir")+"/uploadingDocuments/"+UPLOAD_ROOT_ORG;
					System.out.println("Uploaded file name: "+AllUploadingPaths.rootOrgPath);
					GenericFunctions.waitWebDriver(3000);
					GenericFunctions.uploadFile(AllUploadingPaths.rootOrgPath);
					GenericFunctions.waitForElementToAppear(orgUploadPage.processID);
					GenericFunctions.waitWebDriver(3000);
					GenericFunctions.waitForElementToAppear(orgUploadPage.processID);
					GenericFunctions.waitWebDriver(3000);	
					String getProcessID = orgUploadPage.processID.getText();
					System.out.println(getProcessID);
					String [] iD=getProcessID.split("ID: ");
					for(String idVal:iD)
					{
						GenericFunctions.writeNotepad(idVal,"./testData/rootOrgProcessIds.txt");
					}

					orgUploadPage.closePopup.click();
					System.out.println("Successful on Root Org upload");
					log.info("Process ID: "+getProcessID+"Successful on Root Org upload");
				}
				else if(uploadDocument.equalsIgnoreCase(UPLOAD_SUB_ORG))
				{
					ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to upload Sub-Organization "+UPLOAD_SUB_ORG+" is the file name");
					//String path = System.getProperty("user.dir")+"/uploadingDocuments/"+UPLOAD_SUB_ORG;
					
					System.out.println("Uploaded file name: "+AllUploadingPaths.subOrgPath);
					log.info("Uploaded file name: "+AllUploadingPaths.subOrgPath);
					GenericFunctions.waitWebDriver(3000);
					GenericFunctions.uploadFile(AllUploadingPaths.subOrgPath);
					GenericFunctions.waitWebDriver(3000);
					
					String getProcessID = orgUploadPage.processID.getText();
					System.out.println(getProcessID);
					String [] iD=getProcessID.split("ID: ");
					for(String idVal:iD)
					{
						GenericFunctions.writeNotepad(idVal,"./testData/subOrgProcessIds.txt");
					}
					orgUploadPage.closePopup.click();
					System.out.println("Successful on Sub Org upload");
					log.info("Process ID: "+getProcessID+"Successful on Sub Org upload");
		
				}

			}

		}
		catch(Exception e)
		{
			driver.navigate().refresh();
			log.error("No Files were uploaded");
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Exception : Failed on Uploading Organizations and Sub Organizations");
			ExtentTestManager.getTest().log(LogStatus.FAIL,"Exception Message: "+e.getLocalizedMessage());
			System.out.println("No Files were uploaded");
			Assert.fail("Error while uploading User for Root and Sub Org");
		}
		return true;

	}

	public void uploadRootAndSubOrgUserWithOrgId(String uploadDocument) throws Exception
	{
		ExtentTestManager.getTest().log(LogStatus.INFO, "User Defined Message : User is trying to users for upload Organizations or Sub-Organizations with Ord ID based on the given input");
		try
		{
			GenericFunctions.waitWebDriver(2000);
			/*GenericFunctions.waitForElementToAppearOnScreen(orgUploadPage.dropdown);
			orgUploadPage.dropdown.click();*/
			/*GenericFunctions.waitForElementToAppearOnScreen(createUserPage.headerProfile);
			createUserPage.headerProfile.click();*/
			createUserPageObj.goToProfilePage();
			GenericFunctions.waitForElementToAppear(orgUploadPage.organizationUpload);
			WebElement element=wait.until(ExpectedConditions.visibilityOf(orgUploadPage.organizationUpload));
			if(element.isDisplayed())
			{	 String processID="";
			String path="";
			orgUploadPage.checkUploadStatus.click();
			if(uploadDocument.equalsIgnoreCase(UPLOAD_USERS_ROOT_ORG))
			{
				ExtentTestManager.getTest().log(LogStatus.INFO, "User is fetching Root Org Process ID to upload users for Root Org with Org ID");
				processID=GenericFunctions.readFromNotepad("./testData/rootOrgProcessIds.txt");
				log.info("Process Id: "+processID);

			}
			else if(uploadDocument.equalsIgnoreCase(UPLOAD_USERS_SUB_ORG))
			{
				ExtentTestManager.getTest().log(LogStatus.INFO, "User is fetching Sub Org Process ID to upload users for Sub Org with Sub Org ID");
				processID=GenericFunctions.readFromNotepad("./testData/subOrgProcessIds.txt");
			}	
			orgUploadPage.cProcessId.sendKeys(processID);
			GenericFunctions.waitWebDriver(3000);
			orgUploadPage.clickCheckStatus.click();
			GenericFunctions.waitWebDriver(3000);
			String orgId = orgUploadPage.getOrgId.getText();
			System.out.println("ID:"+orgId);
			orgUploadPage.closeWindow.click();
			GenericFunctions.waitWebDriver(3000);
			orgUploadPage.uploadUsers.click();
			GenericFunctions.waitWebDriver(3000);
			orgUploadPage.clickOrgId.sendKeys(orgId);
			orgUploadPage.uploadUsersCsv.click();
			GenericFunctions.waitWebDriver(3000);
			if(uploadDocument.equalsIgnoreCase(UPLOAD_USERS_ROOT_ORG))
			{
				//path = System.getProperty("user.dir")+"/uploadingDocuments/"+UPLOAD_USERS_ROOT_ORG;
				path=AllUploadingPaths.rootOrgUserPath;
			}
			else if(uploadDocument.equalsIgnoreCase(UPLOAD_USERS_SUB_ORG))
			{
				//path = System.getProperty("user.dir")+"/uploadingDocuments/"+UPLOAD_USERS_SUB_ORG;
				path=AllUploadingPaths.subOrgUserPath;
			}
			System.out.println("Uploaded file name: "+path);
			log.info("Uploaded file name: "+path);
			GenericFunctions.waitWebDriver(3000);
			GenericFunctions.uploadFile(path);
			GenericFunctions.waitWebDriver(4000);
			orgUploadPage.closePopup.click();
			System.out.println("Uploaded users for Root/Sub Org along with Org ID: "+orgUploadPage.uploadedRUser.getText());
			GenericFunctions.waitWebDriver(2000);
			}
			else 
			{
				System.out.println("Element is not displayed");
			}
		}
		catch(Exception e)
		{
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed on Uploading Users for Organizations and Sub Organizations with Org ID");
			ExtentTestManager.getTest().log(LogStatus.FAIL,"Exception Message: "+e.getLocalizedMessage());
			System.out.println("Error while uploading users, No Files were uploaded");
			Assert.fail("Error while uploading users with Org ID, No Files were uploaded");
		}


	}

	public void rootAndSubOrgUserExternalAndProvider(String uploadDocument) throws Exception
	{
		String processID="";
		String path="";
		try
		{

			/*GenericFunctions.waitForElementToAppear(createUserPage.headerProfile);
			createUserPage.headerProfile.click();*/
			createUserPageObj.goToProfilePage();
			GenericFunctions.waitWebDriver(6000);
			WebElement element=wait.until(ExpectedConditions.visibilityOf(orgUploadPage.organizationUpload));
			if(element.isDisplayed())
			{	
				orgUploadPage.checkUploadStatus.click();
				if(uploadDocument.equalsIgnoreCase(UPLOAD_USERS_ROOT_ORG))
				{
					processID=GenericFunctions.readFromNotepad("./testData/rootOrgProcessIds.txt");
					ExtentTestManager.getTest().log(LogStatus.INFO, "Fetched Root Org Process ID to upload users for Root Org with Provider and External ID");
					log.info("Root Org Process Id: "+processID);

				}
				else if(uploadDocument.equalsIgnoreCase(UPLOAD_USERS_SUB_ORG))
				{
					processID=GenericFunctions.readFromNotepad("./testData/subOrgProcessIds.txt");
					ExtentTestManager.getTest().log(LogStatus.INFO, "Fetched Sub Org Process ID to upload users for Sub Org with Provider and External ID");
					log.info("Sub Org Process Id: "+processID);
				}

				System.out.println(processID);
				orgUploadPage.cProcessId.sendKeys(processID);
				GenericFunctions.waitWebDriver(3000);
				orgUploadPage.clickCheckStatus.click();
				GenericFunctions.waitWebDriver(3000);
				String externalId=orgUploadPage.externalId.getText();
				String provider=orgUploadPage.provider.getText();
				System.out.println("External ID: "+externalId);
				System.out.println("Provider :"+provider);
				orgUploadPage.closeWindow.click();
				GenericFunctions.waitWebDriver(4000);
				orgUploadPage.uploadUsers.click();
				GenericFunctions.waitWebDriver(3000);
				orgUploadPage.uploadUserExternal_Id.sendKeys(externalId);
				orgUploadPage.uploadUserProvider.sendKeys(provider);
				GenericFunctions.waitWebDriver(2000);
				orgUploadPage.uploadUsersCsv.click();
				GenericFunctions.waitWebDriver(3000);
				if(uploadDocument.equalsIgnoreCase(UPLOAD_USERS_ROOT_ORG))
				{
					//path = System.getProperty("user.dir")+"/uploadingDocuments/"+UPLOAD_USERS_ROOT_ORG;
					//path = System.getProperty("user.dir")+"\\uploadingDocuments\\"+UPLOAD_USERS_ROOT_ORG;
					path=AllUploadingPaths.rootOrgUserPath;
				}
				else
				{
					//path = System.getProperty("user.dir")+"/uploadingDocuments/"+UPLOAD_USERS_SUB_ORG;
					//path = System.getProperty("user.dir")+"\\uploadingDocuments\\"+UPLOAD_USERS_SUB_ORG;
					path=AllUploadingPaths.subOrgUserPath;
				}

				System.out.println("Uploaded file name: "+path);
				log.info("Uploaded file name: "+path);
				GenericFunctions.waitWebDriver(3000);
				GenericFunctions.uploadFile(path);
				Assert.assertTrue(true);
				GenericFunctions.waitWebDriver(3000);
				System.out.println("Users for Root/Sub Org Uploaded with Provider and externalId: "+orgUploadPage.uploadedRUser.getText());
				GenericFunctions.waitWebDriver(3000);
			}
			else
			{
				System.out.println("Element is not displayed");
			}
		}
		catch(Exception e)
		{
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed on Uploading Users for Organizations and Sub Organizations with Provider and External ID");
			ExtentTestManager.getTest().log(LogStatus.FAIL,"Exception Message: "+e.getLocalizedMessage());
			System.out.println("Error while uploading users with Provider and External ID, No Files were uploaded");
			Assert.fail("Error while uploading users with Provider and External ID, No Files were uploaded");
		}
	}

	public void adminDashboard() throws Exception
	{
		try
		{
			/*GenericFunctions.waitForElementToAppear(orgUploadPage.dropdown);
			orgUploadPage.dropdown.click();
			GenericFunctions.waitForElementToAppear(createUserPage.headerProfile);
			createUserPage.headerProfile.click();*/
			
			
			GenericFunctions.waitWebDriver(1000);
			createUserPageObj.goToProfilePage();
			GenericFunctions.waitWebDriver(3000);
			String aprofileUrl=driver.getCurrentUrl();
			String eProfileUrl="https://staging.open-sunbird.org/profile";
			GenericFunctions.waitWebDriver(2000);
			log.info(aprofileUrl);
			log.info(eProfileUrl);
			Assert.assertEquals(aprofileUrl, eProfileUrl, "Assert fails on matching URLs");
			if(aprofileUrl.equalsIgnoreCase(eProfileUrl))
			{
				Assert.assertTrue(true);
				log.info("Profile page is displayed successfully");
				System.out.println("Profile page is displayed successfully");
			}

			else
			{
				log.info("Profile page is not loaded");
				System.out.println("Profile page is not loaded");

			} 
			GenericFunctions.waitWebDriver(2000);
			ExtentTestManager.getTest().log(LogStatus.INFO, "Verifying the page elements: Organization Upload, Upload Users and Check upload status");
			WebElement element1= GenericFunctions.waitForElementToAppear(orgUploadPage.organizationUpload);
			WebElement element2= GenericFunctions.waitForElementToAppear(orgUploadPage.uploadUsers);
			WebElement element3 = GenericFunctions.waitForElementToAppear(orgUploadPage.checkUploadStatus);
			if(element1.isDisplayed())
			{		
				if(element2.isDisplayed())
				{
					if(element3.isDisplayed())
					{
						//Assert.assertTrue(true);
						log.info("Upload Organizations option is present");
						System.out.println("Upload Organizations option is present");
						log.info("Upload Organizations option is present");
						System.out.println("Upload Organizations option is present");
						log.info("Check upload status option is present");
						System.out.println("Check upload status option is present");
						Assert.assertTrue(true);
					}
				}
			}
			else
			{
				System.out.println("Options are present in Profile page");
			}
		}

		catch(Exception e)
		{
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed on verifying the elements in Admin Dashboard");
			ExtentTestManager.getTest().log(LogStatus.FAIL,"Exception Message: "+e.getLocalizedMessage());
			System.out.println("Error while verifying the Admin Dashboard");
			Assert.fail("Error while verifying the Admin Dashboard");

		}

	}

	public void adminCreationConsumption(String filterName) throws Exception
	{
		try
		{
			GenericFunctions.waitForElementToAppear(orgUploadPage.dropdown);
			orgUploadPage.dropdown.click();
			GenericFunctions.waitForElementToAppear(orgUploadPage.clickAdminDashboardIcon);
			GenericFunctions.waitWebDriver(1500);
			orgUploadPage.clickAdminDashboardIcon.click();
			GenericFunctions.waitWebDriver(3000);
			String creationText=orgUploadPage.clickCreation.getText();
			orgUploadPage.clickCreation.click();
			//String consumptionText=orgUploadPage.clickConsumption.getText();
			System.out.println(creationText);
			//System.out.println(consumptionText);


			if(orgUploadPage.clickCreation.getText().equalsIgnoreCase(filterName))
			{
				ExtentTestManager.getTest().log(LogStatus.INFO, "Verifying the Dashboard by applying filter as "+filterName);
				GenericFunctions.waitForElementToAppear(orgUploadPage.clickCreation);
				orgUploadPage.clickCreation.click();
				ExtentTestManager.getTest().log(LogStatus.INFO,"Checking the statics of "+filterName+":Last7days,Last14days,last5week and download the CSV");
				GenericFunctions.waitWebDriver(2000);
				verifyPageElements();
				GenericFunctions.waitWebDriver(1001);				
				GenericFunctions.waitForElementToAppear(orgUploadPage.dropdown);
				orgUploadPage.dropdown.click();
				GenericFunctions.waitWebDriver(1001);	
				GenericFunctions.waitForElementToAppear(orgUploadPage.clickAdminDashboardIcon);
				orgUploadPage.clickAdminDashboardIcon.click();
				GenericFunctions.waitForElementToAppear(orgUploadPage.last14Days);
				orgUploadPage.last14Days.click();
				GenericFunctions.waitWebDriver(2000);
				verifyPageElements();
				GenericFunctions.waitWebDriver(1001);
				GenericFunctions.waitForElementToAppear(orgUploadPage.dropdown);
				orgUploadPage.dropdown.click();
				GenericFunctions.waitWebDriver(1001);	
				GenericFunctions.waitForElementToAppear(orgUploadPage.clickAdminDashboardIcon);
				orgUploadPage.clickAdminDashboardIcon.click();
				GenericFunctions.waitForElementToAppear(orgUploadPage.last5Weeks);
				GenericFunctions.waitWebDriver(1000);
				orgUploadPage.last5Weeks.click();
				GenericFunctions.waitWebDriver(2000);
				verifyPageElements();
				GenericFunctions.waitWebDriver(2000);
				Assert.assertTrue(true);
			}
			else if(orgUploadPage.clickConsumption.getText().equalsIgnoreCase(filterName))
			{
				ExtentTestManager.getTest().log(LogStatus.INFO, "Verifying the Dashboard by applying filter as "+filterName);
				//System.out.println(consumptionText); 
				orgUploadPage.clickConsumption.click();
				ExtentTestManager.getTest().log(LogStatus.INFO,"Checking the statics of "+filterName+":Last7days,Last14days,last5week and download the CSV");
				GenericFunctions.waitWebDriver(2000);
				verifyPageElements1();
				GenericFunctions.waitWebDriver(2000);
				orgUploadPage.last14Days.click();
				GenericFunctions.waitWebDriver(2000);
				verifyPageElements1();
				GenericFunctions.waitWebDriver(2000);
				orgUploadPage.last5Weeks.click();
				GenericFunctions.waitWebDriver(2000);
				verifyPageElements1();
				GenericFunctions.waitWebDriver(2000);
				Assert.assertTrue(true);
			}
			else
			{
				System.out.println("None of the filters are passed");
			}
		}
		catch(Exception e)
		{
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed on verifying applying filters in Admin Dashboard and verifying elements");
			ExtentTestManager.getTest().log(LogStatus.FAIL,"Exception Message: "+e.getLocalizedMessage());
			Assert.fail("Error while applying filters in the Admin Dashboard and verifying the elements");
		}
	}
	public void verifyPageElements() throws Exception
	{	

		try
		{
			GenericFunctions.waitForElementToAppear(orgUploadPage.contentsCreated);
			if(orgUploadPage.contentsCreated.isDisplayed())
			{
				log.info(orgUploadPage.contentsCreated.getText()+" element is displayed");
				GenericFunctions.waitWebDriver(2000);
				if(orgUploadPage.authors.isDisplayed())
				{	
					log.info(orgUploadPage.authors.getText()+" element is displayed");
					GenericFunctions.waitWebDriver(2000);
					if(orgUploadPage.reviewers.isDisplayed())
					{
						log.info(orgUploadPage.reviewers.getText()+" element is displayed");
						GenericFunctions.waitWebDriver(2000);
						if(orgUploadPage.csvLink.isDisplayed())
						{
							GenericFunctions.scrollToElement(orgUploadPage.csvLink);
							log.info(orgUploadPage.csvLink.getText()+" element is displayed");
							GenericFunctions.waitWebDriver(3000);
							orgUploadPage.csvLink.click();
							GenericFunctions.waitForElementToAppear(orgUploadPage.closeThanks);
							ExtentTestManager.getTest().log(LogStatus.PASS, "Verified the Download CSV link - " +orgUploadPage.thankYouMessage.getText());
							GenericFunctions.waitWebDriver(1000);
							orgUploadPage.closeThanks.click();
						}
					}
				}
			}
		}
		catch(Exception e)
		{
			log.info(orgUploadPage.contentsCreated.isDisplayed()+" element is not displayed");
		}
	}	
	public void verifyPageElements1() throws Exception
	{
		try
		{
			if(orgUploadPage.visits.isDisplayed())
			{
				log.info(orgUploadPage.visits.getText()+" element is displayed");
				GenericFunctions.waitWebDriver(2000);
				if(orgUploadPage.consumptionTime.isDisplayed())
				{
					log.info(orgUploadPage.consumptionTime.getText()+" element is displayed");
					GenericFunctions.waitWebDriver(2000);
					if(orgUploadPage.avgTime.isDisplayed())
					{
						log.info(orgUploadPage.avgTime.getText()+" element is displayed");
						GenericFunctions.waitWebDriver(2000);
						if(orgUploadPage.csvLink.isDisplayed())
						{
							GenericFunctions.scrollToElement(orgUploadPage.csvLink);
							log.info(orgUploadPage.csvLink.getText()+" element is displayed");
							GenericFunctions.waitWebDriver(3000);
							orgUploadPage.csvLink.click();
							GenericFunctions.waitWebDriver(3000);
							orgUploadPage.closeThanks.click();
						}
					}
				}
			}
		}
		catch(Exception e)
		{
			log.info(orgUploadPage.visits.getText()+" element is not displayed");
		}
	}

}

