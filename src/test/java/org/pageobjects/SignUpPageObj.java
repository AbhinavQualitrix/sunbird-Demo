package org.pageobjects;

import java.util.List;

import org.apache.log4j.Logger;
import org.generic.ExtentTestManager;
import org.generic.GenericFunctions;
import org.generic.ReadTestDataFromExcel;
import org.openqa.selenium.By;

import org.openqa.selenium.support.PageFactory;
import org.page.SignUpPage;
import org.page.UploadOrgPage;
import org.startup.BaseTest;
import org.testdata.TestDataForSunbird;
import org.testng.Assert;

import com.relevantcodes.extentreports.LogStatus;
/**
* Created by Qualitrix Technologies Pvt Ltd.
* Purpose: Class file to segregate complete functional methods related to user sign up and its feature
*/
public class SignUpPageObj extends BaseTest
{ 
	static Logger log = Logger.getLogger(SignUpPageObj.class.getName());

	CreatorUserPageObj createUserPageObj = new CreatorUserPageObj();
	

	/**
	* Purpose: userLogin() method is used for user logging
	*/
	public void userLogin(String userRole) throws InterruptedException
    {
          UploadOrgPage orgUploadPage=PageFactory.initElements(driver, UploadOrgPage.class);
          List <TestDataForSunbird> objListOFTestDataForSunbird=null;
          objListOFTestDataForSunbird = ReadTestDataFromExcel.getTestDataForSunbird("testdatasheetcredentials");
          try{
        	  GenericFunctions.waitForElementToAppear(orgUploadPage.loginButton);
        	    ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to Log in as "+userRole);
                orgUploadPage.loginButton.click();
                if(userRole.equalsIgnoreCase("ADMIN")){   
                      orgUploadPage.username.sendKeys(objListOFTestDataForSunbird.get(5).getUsername());
                      orgUploadPage.password.sendKeys(objListOFTestDataForSunbird.get(5).getPassword());
                      System.out.println("Logged in as "+userRole+" with UN:"+objListOFTestDataForSunbird.get(5).getUsername()+" and PW:"+
                                  objListOFTestDataForSunbird.get(5).getPassword());
                      log.info("Logged in as"+userRole+"with UN:"+objListOFTestDataForSunbird.get(5).getUsername()+" and PW:"+
                                  objListOFTestDataForSunbird.get(5).getPassword());
                }
                else if(userRole.equalsIgnoreCase("CREATOR")){
                      orgUploadPage.username.sendKeys(objListOFTestDataForSunbird.get(0).getUsername());
                      orgUploadPage.password.sendKeys(objListOFTestDataForSunbird.get(0).getPassword());
                log.info("UN"+objListOFTestDataForSunbird.get(0).getUsername()+"/nPW"+objListOFTestDataForSunbird.get(0).getPassword());
                }
                else if(userRole.equalsIgnoreCase("REVIEWER")){
                      orgUploadPage.username.sendKeys(objListOFTestDataForSunbird.get(1).getUsername());
                      orgUploadPage.password.sendKeys(objListOFTestDataForSunbird.get(1).getPassword());
                log.info("UN"+objListOFTestDataForSunbird.get(1).getUsername()+"/nPW"+objListOFTestDataForSunbird.get(1).getPassword());
                }
                else if(userRole.equalsIgnoreCase("MENTOR")){
                      orgUploadPage.username.sendKeys(objListOFTestDataForSunbird.get(2).getUsername());
                      orgUploadPage.password.sendKeys(objListOFTestDataForSunbird.get(2).getPassword());
                log.info("UN"+objListOFTestDataForSunbird.get(2).getUsername()+"/nPW"+objListOFTestDataForSunbird.get(2).getPassword());
                }
                else if(userRole.equalsIgnoreCase("FLAGREVIEWER")){
                      orgUploadPage.username.sendKeys(objListOFTestDataForSunbird.get(8).getUsername());
                      orgUploadPage.password.sendKeys(objListOFTestDataForSunbird.get(8).getPassword());
                log.info("UN"+objListOFTestDataForSunbird.get(8).getUsername()+"/nPW"+objListOFTestDataForSunbird.get(8).getPassword());
                }           
                else if(userRole.equalsIgnoreCase("PUBLICUSER")){
                      orgUploadPage.username.sendKeys(objListOFTestDataForSunbird.get(4).getUsername());
                      orgUploadPage.password.sendKeys(objListOFTestDataForSunbird.get(4).getPassword());
                log.info("UN"+objListOFTestDataForSunbird.get(4).getUsername()+"/nPW"+objListOFTestDataForSunbird.get(4).getPassword());
                }
                else if(userRole.equalsIgnoreCase("PUBLICUSER1"))
                {
                      orgUploadPage.username.sendKeys(objListOFTestDataForSunbird.get(5).getUsername());
                      orgUploadPage.password.sendKeys(objListOFTestDataForSunbird.get(5).getPassword());
                log.info("UN"+objListOFTestDataForSunbird.get(5).getUsername()+"/nPW"+objListOFTestDataForSunbird.get(5).getPassword());
                }
                
                else if(userRole.equalsIgnoreCase("BOOKREVIEWER"))
                {
                      orgUploadPage.username.sendKeys(objListOFTestDataForSunbird.get(10).getUsername());
                      orgUploadPage.password.sendKeys(objListOFTestDataForSunbird.get(10).getPassword());
                log.info("UN"+objListOFTestDataForSunbird.get(10).getUsername()+"/nPW"+objListOFTestDataForSunbird.get(10).getPassword());
                }
                
                else if(userRole.equalsIgnoreCase("AUTOCREATOR"))
                {
                      orgUploadPage.username.sendKeys(objListOFTestDataForSunbird.get(12).getUsername());
                      orgUploadPage.password.sendKeys(objListOFTestDataForSunbird.get(12).getPassword());
                log.info("UN"+objListOFTestDataForSunbird.get(12).getUsername()+"/nPW"+objListOFTestDataForSunbird.get(12).getPassword());
                }
                else if(userRole.equalsIgnoreCase("A_CONTENT_CREATOR"))
                {
                	 orgUploadPage.username.sendKeys(objListOFTestDataForSunbird.get(28).getUsername());
                     orgUploadPage.password.sendKeys(objListOFTestDataForSunbird.get(28).getPassword());
               log.info("UN"+objListOFTestDataForSunbird.get(28).getUsername()+"/nPW"+objListOFTestDataForSunbird.get(28).getPassword());
                }
                else if(userRole.equalsIgnoreCase(BOOKCREATOR))
                {
                	 orgUploadPage.username.sendKeys(objListOFTestDataForSunbird.get(6).getUsername());
                     orgUploadPage.password.sendKeys(objListOFTestDataForSunbird.get(6).getPassword());
               log.info("UN"+objListOFTestDataForSunbird.get(6).getUsername()+"/nPW"+objListOFTestDataForSunbird.get(6).getPassword());
                }
                else if(userRole.equalsIgnoreCase(MENTOR_S))
                {
                      orgUploadPage.username.sendKeys(objListOFTestDataForSunbird.get(24).getUsername());
                      orgUploadPage.password.sendKeys(objListOFTestDataForSunbird.get(24).getPassword());
                log.info("UN"+objListOFTestDataForSunbird.get(24).getUsername()+"/nPW"+objListOFTestDataForSunbird.get(24).getPassword());
                }
                else if(userRole.equalsIgnoreCase(REVIEWER_S))
                {
                      orgUploadPage.username.sendKeys(objListOFTestDataForSunbird.get(25).getUsername());
                      orgUploadPage.password.sendKeys(objListOFTestDataForSunbird.get(25).getPassword());
                log.info("UN"+objListOFTestDataForSunbird.get(25).getUsername()+"/nPW"+objListOFTestDataForSunbird.get(25).getPassword());
                }
                else if(userRole.equalsIgnoreCase(PUBLICUSER_S))
                {
                      orgUploadPage.username.sendKeys(objListOFTestDataForSunbird.get(23).getUsername());
                      orgUploadPage.password.sendKeys(objListOFTestDataForSunbird.get(23).getPassword());
                log.info("UN"+objListOFTestDataForSunbird.get(23).getUsername()+"/nPW"+objListOFTestDataForSunbird.get(23).getPassword());
                }
                else if(userRole.equalsIgnoreCase(MENTORS_S))
                {
                      orgUploadPage.username.sendKeys(objListOFTestDataForSunbird.get(26).getUsername());
                      orgUploadPage.password.sendKeys(objListOFTestDataForSunbird.get(26).getPassword());
                log.info("UN"+objListOFTestDataForSunbird.get(26).getUsername()+"/nPW"+objListOFTestDataForSunbird.get(26).getPassword());
                }
                else if(userRole.equalsIgnoreCase(PUBLICUSERS_S))
                {
                      orgUploadPage.username.sendKeys(objListOFTestDataForSunbird.get(27).getUsername());
                      orgUploadPage.password.sendKeys(objListOFTestDataForSunbird.get(27).getPassword());
                log.info("UN"+objListOFTestDataForSunbird.get(27).getUsername()+"/nPW"+objListOFTestDataForSunbird.get(27).getPassword());
                }
                else if(userRole.equalsIgnoreCase(CREATOR2)){
                    orgUploadPage.username.sendKeys(objListOFTestDataForSunbird.get(9).getUsername());
                    orgUploadPage.password.sendKeys(objListOFTestDataForSunbird.get(9).getPassword());
              log.info("UN"+objListOFTestDataForSunbird.get(9).getUsername()+"/nPW"+objListOFTestDataForSunbird.get(9).getPassword());
              }
                else{
                      log.error("User info not found");
                }
                //orgUploadPage.clickLogin.click();
                orgUploadPage.clickLogin1.click();
                if(userRole.equalsIgnoreCase(PUBLICUSER)&&userRole.equalsIgnoreCase(PUBLICUSER))
                {
                	System.out.println("Public user login");
                	createUserPageObj.handlePopupOnLogin();
                }
                else
                {
                createUserPageObj.tryForWorkSpace();
                }
               // createUserPageObj.IsElementDisplayed();
                //createUserPageObj.handlePopupOnLogin();
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
			GenericFunctions.waitWebDriver(5000);
			UploadOrgPage orgUploadPage=PageFactory.initElements(driver, UploadOrgPage.class);
			GenericFunctions.waitForElementToAppear(orgUploadPage.dropdown);
			orgUploadPage.dropdown.click();
			GenericFunctions.waitTillTheElementIsVisibleAndClickable(orgUploadPage.logout);
			orgUploadPage.logout.click();
			GenericFunctions.waitWebDriver(3500);
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


