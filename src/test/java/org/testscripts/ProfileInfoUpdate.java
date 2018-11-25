/**
* Created by Qualitrix Technologies Pvt Ltd.
* @author: Ajith Manjunath
* Date: 05/23/2018
* Purpose: To verify Profile - all information update
*/

package org.testscripts;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.pageobjects.PublicUserPageObj;
import org.pageobjects.SignUpPageObj;
import org.startup.BaseTest;
import org.testng.annotations.Test;

public class ProfileInfoUpdate extends BaseTest
{
	@Test
	public void profileInfoUpdate() throws Exception
	{
		SignUpPageObj userLogin = new SignUpPageObj();
		PublicUserPageObj publicUser = new PublicUserPageObj();
		
		
		//Step 1 : Login as any user	
		userLogin.userLogin(PUBLICUSER1);
		 
		//Step 2: Profile - all information update	
		publicUser.profileInformationUpdate();
		
		//Step 3: Logout as Public user
		userLogin.userLogout();
		
	}
	
}
