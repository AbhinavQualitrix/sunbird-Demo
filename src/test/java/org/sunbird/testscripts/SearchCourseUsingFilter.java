/**
* Created by Qualitrix Technologies Pvt Ltd.
* @author: Ajith Manjunath
* Date: 05/21/2018
* Purpose: To verify Course search - with filter
*/

package org.sunbird.testscripts;

import org.testng.annotations.Test;
import java.util.List;

import org.sunbird.generic.ReadTestDataFromExcel;
import org.sunbird.pageobjects.PublicUserPageObj;
import org.sunbird.pageobjects.SignUpPageObj;
import org.sunbird.startup.BaseTest;
import org.sunbird.testdata.TestDataForSunbird;
import org.testng.annotations.Test;


public class SearchCourseUsingFilter extends BaseTest
{
	@Test
	public void searchCourseUsingFilter() throws Exception 
	{	

		SignUpPageObj userLogin = new SignUpPageObj();
		PublicUserPageObj publicUser = new PublicUserPageObj();
		
		//Step 1:Login as Public user
		userLogin.userLogin(PUBLICUSER1);
		
		//Step 2 :Course search with filter
		publicUser.courseSearchFilter();
		
		//Step 3:Logout as Public user
		userLogin.userLogout();
	}
	

}
