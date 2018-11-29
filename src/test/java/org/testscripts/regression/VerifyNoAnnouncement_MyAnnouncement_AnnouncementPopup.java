/**
* Created by Qualitrix Technologies Pvt Ltd.
* @author: Raju S
* Date: 04/10/2018
* Purpose:  
To verify that the user is able to view the AnnouncementDetails
.
*/
package org.testscripts.regression;



import org.testng.annotations.Test;
import org.generic.GenericFunctions;
import org.openqa.selenium.support.PageFactory;
import org.page.AnnouncementCreationsPage;
import org.pageobjects.AnnouncementCreationsPageObj;
import org.pageobjects.SignUpPageObj;
import org.startup.BaseTest;
import org.testng.annotations.Test;

public class VerifyNoAnnouncement_MyAnnouncement_AnnouncementPopup extends BaseTest
{
	//Maintenance - Done 9th Nov
	@Test(priority=1)
	public void VerifyAnnouncementMessage() throws Exception
	{
		SignUpPageObj userLogin = new SignUpPageObj();
		AnnouncementCreationsPageObj announcementCreationsPageObj=new AnnouncementCreationsPageObj();
		
		//Step1: Login as Creator
		userLogin.userLogin(ADMIN);
		
		//Step2: Navigate to Announcement dashboard and verify
		announcementCreationsPageObj.NavigateToAnnouncementDashboard();
		
		//Step 3: Verify Announcement message 
		//announcementCreationsPageObj.verifyAnnouncementMessage();			
		
		//Step 4: Logout 
		userLogin.userLogout();
	}

	@Test(priority=2)
	public void VerifyAnnouncementDetails() throws Exception
	{

		SignUpPageObj userLogin = new SignUpPageObj();
		AnnouncementCreationsPageObj announcementCreationsPageObj=new AnnouncementCreationsPageObj();
		
		//Step 1 : Login as creator
		userLogin.userLogin(CREATOR);
		
		
		//Step 2 : Navigate to announcement dashboard
		announcementCreationsPageObj.NavigateToAnnouncementDashboard();
		
		//Step 3 : Validate view announcement section
		announcementCreationsPageObj.ValidateViewAnnouncementSection();
		
		//Step 4 : Logout as creator
		userLogin.userLogout();
		
	}
	

	@Test(priority=3)
	public void VerifyAnnouncementCreationFields() throws Exception
	{
	
		SignUpPageObj userLogin = new SignUpPageObj();	
		AnnouncementCreationsPageObj announcementCreationsPageObj=new AnnouncementCreationsPageObj();
		AnnouncementCreationsPage announcementcreationspage=PageFactory.initElements(driver,AnnouncementCreationsPage.class);
		
		//Step 1 : Login as creator
		userLogin.userLogin(CREATOR);
		
		//Step 2 : Navigate to Announcement and verify
		announcementCreationsPageObj.NavigateToAnnouncementDashboard();
		
		//Step 3 : Click on create Announcement
		announcementcreationspage.clickCreateAnnoucement.click();
		
		
		//Step 4 : Fetch fields and assert
		GenericFunctions.FetchFieldsAndAssert(announcementcreationspage.announcementTitle,"TITLE");
		
		GenericFunctions.refreshWebPage();
		
		//Step 4 : Logout as creator
		userLogin.userLogout();		
		
	}
	
	
	
}
