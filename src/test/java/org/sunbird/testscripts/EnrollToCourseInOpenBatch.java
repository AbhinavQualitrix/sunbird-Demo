/**

* Created by Qualitrix Technologies Pvt Ltd.

* @author: Abhinav kumar singh

* Date: 07/19/2018

* Purpose: Create open batch for a course created by you ,public user should enroll to it.

*/

package org.sunbird.testscripts;

import org.testng.annotations.Test;
import org.sunbird.generic.GenericFunctions;
import org.sunbird.pageobjects.CreateMentorPageObj;
import org.sunbird.pageobjects.SignUpPageObj;
import org.sunbird.startup.BaseTest;
import org.testng.annotations.Test;

public class EnrollToCourseInOpenBatch extends BaseTest
{
	@Test
	public void enrollToCourseInOpenBatch() throws Exception
	{
		SignUpPageObj userLogin = new SignUpPageObj();
		CreateMentorPageObj createMentorPageObj=new CreateMentorPageObj();
		
		//Step1: Login as Mentor
		userLogin.userLogin(MENTOR);
		
		//Step2: Search for a course created by same mentor
		createMentorPageObj.navigateToCourseAndSearchForOpenBatch();
		
		//Step3:create an open batch
		createMentorPageObj.createOpenBatch();
		GenericFunctions.waitWebDriver(2500);
		
		//Step4 Logout as Mentor
		GenericFunctions.waitWebDriver(4000);
		GenericFunctions.waitWebDriver(1000);
		userLogin.userLogout();	
		GenericFunctions.waitWebDriver(3000);
		
		//Step5:Login as Public user	
		userLogin.userLogin(PUBLICUSER1);
				
		//Step6:Search for the course
		createMentorPageObj.navigateToCourseAndSearchForOpenBatch();
		
		//Step7:Enroll for the open batch
		GenericFunctions.waitWebDriver(4000);
		createMentorPageObj.enrollForOpenBatchN();
		
		//Step8:Logout as public user
		GenericFunctions.waitWebDriver(4000);
		//GenericFunctions.refreshWebPage();
		GenericFunctions.waitWebDriver(1000);
		userLogin.userLogout();	
		GenericFunctions.waitWebDriver(3000);
		
	}
	
	
}
