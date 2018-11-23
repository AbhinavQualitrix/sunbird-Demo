/**

* Created by Qualitrix Technologies Pvt Ltd.

* @author: Abhinav kumar singh

* Date: 07/05/2018

* Purpose:Navigate to my Activity .

*/
package org.testscripts;

import org.testng.annotations.Test;
import org.generic.GenericFunctions;
import org.pageobjects.CreateMentorPageObj;
import org.pageobjects.SignUpPageObj;
import org.startup.BaseTest;
import org.testng.annotations.Test;


public class NavigateToMyActivityInDropdown extends BaseTest {
	
	@Test
	public void navigateToMyActivityInDropdown() throws Exception
	{
		
		//Step1: Login as Creator
		SignUpPageObj creatorLogin = new SignUpPageObj();
		creatorLogin.userLogin(MENTOR);

		//Step2: Navigate to My activity in Dropdown		
		CreateMentorPageObj createMentorPageObj =new CreateMentorPageObj();
		createMentorPageObj.navigateToMyActivityInDropDownMenu();
		System.out.println("inside My activity");
		
		//Step3: Logout as mentor
		GenericFunctions.waitWebDriver(1000);
		creatorLogin.userLogout();
		
	}
	

}
