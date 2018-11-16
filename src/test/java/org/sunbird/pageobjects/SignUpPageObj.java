package org.sunbird.pageobjects;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;

import org.openqa.selenium.support.PageFactory;
import org.sunbird.generic.ExtentTestManager;
import org.sunbird.generic.GenericFunctions;
import org.sunbird.generic.ReadTestDataFromExcel;
import org.sunbird.page.SignUpPage;
import org.sunbird.page.UploadOrgPage;
import org.sunbird.startup.BaseTest;
import org.sunbird.testdata.TestDataForSunbird;
import org.testng.Assert;

import com.relevantcodes.extentreports.LogStatus;
/**
* Created by Qualitrix Technologies Pvt Ltd.
* Purpose: Class file to segregate complete functional methods related to user sign up and its feature
*/
public class SignUpPageObj extends BaseTest
{ 
	static Logger log = Logger.getLogger(SignUpPageObj.class.getName());

	

	/**
	* Purpose: userLogin() method is used for user logging
	*/
	public void userLogin(String userRole) throws InterruptedException
    {
		  GenericFunctions.waitWebDriver(3000);
          UploadOrgPage orgUploadPage=PageFactory.initElements(driver, UploadOrgPage.class);
          List <TestDataForSunbird> objListOFTestDataForSunbird=null;
          objListOFTestDataForSunbird = ReadTestDataFromExcel.getTestDataForSunbird("testdatasheetcredentials");
          try{
        	    ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to Log In");
                orgUploadPage.loginButton.click();
                if(userRole.equalsIgnoreCase(ADMIN)){   
                      orgUploadPage.username.sendKeys(objListOFTestDataForSunbird.get(3).getUsername());
                      orgUploadPage.password.sendKeys(objListOFTestDataForSunbird.get(3).getPassword());
                      System.out.println("Logged in as "+userRole+" with UN:"+objListOFTestDataForSunbird.get(3).getUsername()+" and PW:"+
                                  objListOFTestDataForSunbird.get(3).getPassword());
                      log.info("Logged in as"+userRole+"with UN:"+objListOFTestDataForSunbird.get(3).getUsername()+" and PW:"+
                                  objListOFTestDataForSunbird.get(3).getPassword());
                }
                else if(userRole.equalsIgnoreCase(CREATOR)){
                      orgUploadPage.username.sendKeys(objListOFTestDataForSunbird.get(0).getUsername());
                      orgUploadPage.password.sendKeys(objListOFTestDataForSunbird.get(0).getPassword());
                      System.out.println("Logged in as "+userRole+" with UN:"+objListOFTestDataForSunbird.get(0).getUsername()+" and PW:"+
                              objListOFTestDataForSunbird.get(0).getPassword());
                log.info("UN"+objListOFTestDataForSunbird.get(0).getUsername()+"/nPW"+objListOFTestDataForSunbird.get(0).getPassword());
                }
                else if(userRole.equalsIgnoreCase(REVIEWER)){
                      orgUploadPage.username.sendKeys(objListOFTestDataForSunbird.get(1).getUsername());
                      orgUploadPage.password.sendKeys(objListOFTestDataForSunbird.get(1).getPassword());
                      System.out.println("Logged in as "+userRole+" with UN:"+objListOFTestDataForSunbird.get(1).getUsername()+" and PW:"+
                              objListOFTestDataForSunbird.get(1).getPassword());
                log.info("UN"+objListOFTestDataForSunbird.get(1).getUsername()+"/nPW"+objListOFTestDataForSunbird.get(1).getPassword());
                }
                else if(userRole.equalsIgnoreCase(MENTOR)){
                      orgUploadPage.username.sendKeys(objListOFTestDataForSunbird.get(2).getUsername());
                      orgUploadPage.password.sendKeys(objListOFTestDataForSunbird.get(2).getPassword());
                      System.out.println("Logged in as "+userRole+" with UN:"+objListOFTestDataForSunbird.get(2).getUsername()+" and PW:"+
                              objListOFTestDataForSunbird.get(2).getPassword());
                log.info("UN"+objListOFTestDataForSunbird.get(2).getUsername()+"/nPW"+objListOFTestDataForSunbird.get(2).getPassword());
                }
                else if(userRole.equalsIgnoreCase(PUBLICUSER1)){
                      orgUploadPage.username.sendKeys(objListOFTestDataForSunbird.get(4).getUsername());
                      orgUploadPage.password.sendKeys(objListOFTestDataForSunbird.get(4).getPassword());
                      System.out.println("Logged in as "+userRole+" with UN:"+objListOFTestDataForSunbird.get(4).getUsername()+" and PW:"+
                              objListOFTestDataForSunbird.get(4).getPassword());
                log.info("UN"+objListOFTestDataForSunbird.get(4).getUsername()+"/nPW"+objListOFTestDataForSunbird.get(4).getPassword());
                }
                else if(userRole.equalsIgnoreCase(PUBLICUSER2))
                {
                      orgUploadPage.username.sendKeys(objListOFTestDataForSunbird.get(5).getUsername());
                      orgUploadPage.password.sendKeys(objListOFTestDataForSunbird.get(5).getPassword());
                      System.out.println("Logged in as "+userRole+" with UN:"+objListOFTestDataForSunbird.get(5).getUsername()+" and PW:"+
                              objListOFTestDataForSunbird.get(5).getPassword());
                log.info("UN"+objListOFTestDataForSunbird.get(5).getUsername()+"/nPW"+objListOFTestDataForSunbird.get(5).getPassword());
                }
                else if(userRole.equalsIgnoreCase(BOOKCREATOR))
                {
                      orgUploadPage.username.sendKeys(objListOFTestDataForSunbird.get(6).getUsername());
                      orgUploadPage.password.sendKeys(objListOFTestDataForSunbird.get(6).getPassword());
                      System.out.println("Logged in as "+userRole+" with UN:"+objListOFTestDataForSunbird.get(6).getUsername()+" and PW:"+
                              objListOFTestDataForSunbird.get(6).getPassword());
                log.info("UN"+objListOFTestDataForSunbird.get(6).getUsername()+"/nPW"+objListOFTestDataForSunbird.get(6).getPassword());
                }
                else if(userRole.equalsIgnoreCase(BOOKREVIEWER))
                {
                	 orgUploadPage.username.sendKeys(objListOFTestDataForSunbird.get(7).getUsername());
                     orgUploadPage.password.sendKeys(objListOFTestDataForSunbird.get(7).getPassword());
                     System.out.println("Logged in as "+userRole+" with UN:"+objListOFTestDataForSunbird.get(7).getUsername()+" and PW:"+
                             objListOFTestDataForSunbird.get(7).getPassword());
               log.info("UN"+objListOFTestDataForSunbird.get(7).getUsername()+"/nPW"+objListOFTestDataForSunbird.get(7).getPassword());
                }
                else if(userRole.equalsIgnoreCase(FLAGREVIEWER))
                {
                	 orgUploadPage.username.sendKeys(objListOFTestDataForSunbird.get(8).getUsername());
                     orgUploadPage.password.sendKeys(objListOFTestDataForSunbird.get(8).getPassword());
                     System.out.println("Logged in as "+userRole+" with UN:"+objListOFTestDataForSunbird.get(8).getUsername()+" and PW:"+
                             objListOFTestDataForSunbird.get(8).getPassword());
               log.info("UN"+objListOFTestDataForSunbird.get(8).getUsername()+"/nPW"+objListOFTestDataForSunbird.get(8).getPassword());
                }
                else if(userRole.equalsIgnoreCase(PUBLICUSER3))
                {
                	 orgUploadPage.username.sendKeys(objListOFTestDataForSunbird.get(9).getUsername());
                     orgUploadPage.password.sendKeys(objListOFTestDataForSunbird.get(9).getPassword());
                     System.out.println("Logged in as "+userRole+" with UN:"+objListOFTestDataForSunbird.get(9).getUsername()+" and PW:"+
                             objListOFTestDataForSunbird.get(9).getPassword());
               log.info("UN"+objListOFTestDataForSunbird.get(9).getUsername()+"/nPW"+objListOFTestDataForSunbird.get(9).getPassword());
                }
                else{
                      log.error("User info not found");
                }
                orgUploadPage.clickLogin1.click();
          }
          catch(Exception e)
          {
        	ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed on logging In");
  			ExtentTestManager.getTest().log(LogStatus.FAIL,"Exception Message: "+e.getLocalizedMessage());
  			log.error("Exception In the method userLogin"+e.getLocalizedMessage());
  			Assert.fail("Failed on logging In, Exception : "+e.getLocalizedMessage());
          }
    }

	/**
	* Purpose: userLogout() method is used for user logout
	*/
	public void userLogout()throws Exception{
		try{
			ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to Log out");
			GenericFunctions.waitWebDriver(4000);
			UploadOrgPage orgUploadPage=PageFactory.initElements(driver, UploadOrgPage.class);
			GenericFunctions.waitForElementToAppear(orgUploadPage.dropdown);
			orgUploadPage.dropdown.click();
			GenericFunctions.waitTillTheElementIsVisibleAndClickable(orgUploadPage.logout);
			orgUploadPage.logout.click();
			GenericFunctions.waitWebDriver(1500);
			System.out.println("User Logout");
			
		}
		catch(Exception e){
			
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed on logging out");
			ExtentTestManager.getTest().log(LogStatus.FAIL,"Exception Message: "+e.getLocalizedMessage());
			log.error("Exception In the method userLogout"+e.getLocalizedMessage());
			Assert.fail("Failed on logging out, Exception : "+e.getLocalizedMessage());
		}

	}
}


