/**
* Created by Qualitrix Technologies Pvt Ltd.
* @author: Ajith Manjunath
* Date: 05/07/2018
* Purpose: Upload root org
*/


package org.testscripts;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.generic.GenericFunctions;
import org.pageobjects.SignUpPageObj;
import org.pageobjects.UploadOrgObj;
import org.startup.BaseTest;
import org.testng.annotations.Test;

public class UploadRootOrg extends BaseTest {

	@Test(priority=1, groups={"Admin group"})
	public void uploadRootOrg() throws Exception 	
	{		
		//Step1: Admin Login
		SignUpPageObj adminLogin = new SignUpPageObj();
		UploadOrgObj adminUpload= new UploadOrgObj();
		adminLogin.userLogin(ADMIN);
	
			
		//Step2 and 3: Upload Root Org		
		boolean actualValue= adminUpload.uploadRootAndSubOrg(UPLOAD_ROOT_ORG);
		
		
		//Wait for 2 seconds
		GenericFunctions.waitWebDriver(2000);
		
		//Logout as Admin
		adminLogin.userLogout();
	}

}
