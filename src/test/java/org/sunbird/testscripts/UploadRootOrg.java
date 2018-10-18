/**
* Created by Qualitrix Technologies Pvt Ltd.
* @author: Ajith Manjunath
* Date: 05/07/2018
* Purpose: Upload root org
*/


package org.sunbird.testscripts;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.sunbird.generic.GenericFunctions;
import org.sunbird.pageobjects.SignUpPageObj;
import org.sunbird.pageobjects.UploadOrgObj;
import org.sunbird.startup.BaseTest;
import org.testng.annotations.Test;

public class UploadRootOrg extends BaseTest {

	@Test(priority=1)
	public void uploadRootOrg() throws Exception 
	
	{		
		//Step1: Admin Login
		SignUpPageObj adminLogin = new SignUpPageObj();
		adminLogin.userLogin(ADMIN);
			
		//Step2 and 3: Upload Root Org
		UploadOrgObj adminUpload= new UploadOrgObj();
		boolean actualValue= adminUpload.uploadRootAndSubOrg(UPLOAD_ROOT_ORG);
		AssertJUnit.assertEquals(true,actualValue);
		
		//Wait for 2 seconds
		GenericFunctions.waitWebDriver(2000);
		
		//Logout as Admin
		adminLogin.userLogout();
	}

}
