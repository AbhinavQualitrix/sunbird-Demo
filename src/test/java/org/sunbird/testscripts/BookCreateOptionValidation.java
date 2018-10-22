/**
* Created by Qualitrix Technologies Pvt Ltd.
* @author: Ajith Manjunath
* Date: 06/27/2018
* Purpose: Content creator does not book create option
*/


package org.sunbird.testscripts;

import org.testng.annotations.Test;
import org.sunbird.pageobjects.CreatorUserPageObj;
import org.sunbird.pageobjects.SignUpPageObj;
import org.sunbird.startup.BaseTest;
import org.testng.annotations.Test;

public class BookCreateOptionValidation extends BaseTest
{
	@Test(priority=19, groups={"Creator Group"})
	public void bookCreateOptionValidation() throws Exception
	{
		SignUpPageObj signupObj = new SignUpPageObj();
		CreatorUserPageObj creatorUserPageObj = new CreatorUserPageObj();

		//Step 1:Login with content creator credentials.
		signupObj.userLogin(A_CONTENT_CREATOR);

		//Step 2:Go to workspace
		// Click on create
		// Verify book option is not displaying.
		creatorUserPageObj.verifyNoBookOptionPresent();
		
		//Step3: Logout as Content creator
		signupObj.userLogout();
		
		
	}
}
