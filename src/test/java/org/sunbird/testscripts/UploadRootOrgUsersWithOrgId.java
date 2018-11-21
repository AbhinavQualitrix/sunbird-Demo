/**
* Created by Qualitrix Technologies Pvt Ltd.
* @author: Ajith Manjunath
* Date: 05/10/2018
* Purpose: Upload user for root org with org id
*/

package org.sunbird.testscripts;

import org.testng.annotations.Test;
import org.sunbird.generic.GenericFunctions;
import org.sunbird.pageobjects.SignUpPageObj;
import org.sunbird.pageobjects.UploadOrgObj;
import org.sunbird.startup.BaseTest;
import org.testng.annotations.Test;

public class UploadRootOrgUsersWithOrgId extends BaseTest
{
	@Test(priority=2, groups={"Admin group"})
	public void uploadRootOrgUsers() throws Exception
	{
		SignUpPageObj adminLogin = new SignUpPageObj();
		UploadOrgObj adminUpload= new UploadOrgObj();
		
		//Step1: Admin Login
		adminLogin.userLogin(ADMIN);
		
		//Handle the popup 
		adminUpload.handlePopupOnLogin();
		
		//Step2,3,4 and 5:Go to profile, and Upload users With Root Org ID
		adminUpload.uploadRootAndSubOrgUserWithOrgId(UPLOAD_USERS_ROOT_ORG);
		
		GenericFunctions.waitWebDriver(2000);
		
		//Logout as Admin
		adminLogin.userLogout();
	}
}

