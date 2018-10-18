/**
* Created by Qualitrix Technologies Pvt Ltd.
* @author: Ajith Manjunath
* Date: 05/22/2018
* Purpose: To verify User search
*/

package org.sunbird.testscripts;

import org.testng.annotations.Test;
import org.sunbird.pageobjects.PublicUserPageObj;
import org.sunbird.pageobjects.SignUpPageObj;
import org.sunbird.startup.BaseTest;
import org.testng.annotations.Test;

public class SearchUsers extends BaseTest
{
	@Test
	public void searchUsers() throws Exception
	{
		SignUpPageObj userLogin = new SignUpPageObj();
		PublicUserPageObj publicUser = new PublicUserPageObj();
		
		//Step 1 : Login in as any user(CREATOR)
		userLogin.userLogin(MENTOR);

		//Step 2 : Search for users
		publicUser.userSearch();
		
		//Logout as Public user
		userLogin.userLogout();
	}

}
