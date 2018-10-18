/**
* Created by Qualitrix Technologies Pvt Ltd.
* @author: Ajith Manjunath
* Date: 05/23/2018
* Purpose: Search for Orgs
*/

package org.sunbird.testscripts;

import org.testng.annotations.Test;
import org.sunbird.pageobjects.PublicUserPageObj;
import org.sunbird.pageobjects.SignUpPageObj;
import org.sunbird.startup.BaseTest;
import org.testng.annotations.Test;

public class SearchOrgsAsMentor extends BaseTest
{
	@Test
	public void searchOrgsAsMentor() throws Exception
	{
		
		SignUpPageObj userLogin = new SignUpPageObj();
		PublicUserPageObj publicUser = new PublicUserPageObj();
		
		//Step 1 :Login as any user(MENTOR)
		userLogin.userLogin(MENTOR);

		//Step 2:Search for a particular Organization	
		publicUser.searchOrgs();
		
		//Logout as Public user
		userLogin.userLogout();

	}

}
