/**
* Created by Qualitrix Technologies Pvt Ltd.
* @author: Ajith Manjunath
* Date: 05/15/2018
* Purpose: Verify Elements in Admin dashboard
*/

package org.sunbird.testscripts;

import org.testng.annotations.Test;
import org.sunbird.pageobjects.SignUpPageObj;
import org.sunbird.pageobjects.UploadOrgObj;
import org.sunbird.startup.BaseTest;
import org.testng.annotations.Test;

public class VerifyElementsInAdminDashboard extends BaseTest
{
	@Test(priority=7)
	public void verifyElementsInAdminDashboard() throws Exception
	{
		SignUpPageObj adminLogin = new SignUpPageObj();
		UploadOrgObj adminUpload= new UploadOrgObj();

		//Step 1: Login as Admin
		adminLogin.userLogin(ADMIN);

		//Step 2,3,4 and 5 : Go to Profile page
		//Verify Admin DashBoard
		adminUpload.adminDashboard();
		
		//Logout as Admin
		adminLogin.userLogout();

	}


}
