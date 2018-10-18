/**

* Created by Qualitrix Technologies Pvt Ltd.

* @author: Abhinav kumar singh

* Date: 06/26/2018

* Purpose: Navigate to announcement Dashboard.

*/
package org.sunbird.testscripts;

import org.testng.annotations.Test;
import org.sunbird.generic.GenericFunctions;
import org.sunbird.pageobjects.CreatorAnnouncementPageObj;
import org.sunbird.pageobjects.SignUpPageObj;
import org.sunbird.startup.BaseTest;
import org.testng.annotations.Test;


public class NavigateToAnnouncementDashboard extends BaseTest {
	
	@Test
	public void navigateToAnnouncementDashboard() throws Exception
	{
		
		//Step1: Login as Creator
		
		SignUpPageObj creatorLogin = new SignUpPageObj();
		creatorLogin.userLogin(CREATOR);
		
		//Step2: Navigate to Announcement Dashboard in Dropdown
		
		CreatorAnnouncementPageObj creatorAnnouncementPageObj =new CreatorAnnouncementPageObj();
		creatorAnnouncementPageObj.navigateToAnnouncementInDropDownMenu();
		GenericFunctions.waitWebDriver(2000);
		
		//Step3: Logout as Creator
		creatorLogin.userLogout();
	}
	

}
