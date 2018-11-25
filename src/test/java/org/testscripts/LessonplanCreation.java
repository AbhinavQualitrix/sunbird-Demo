/**
* Created by Qualitrix Technologies Pvt Ltd.
* @author: Ajith Manjunath
* Date: 06/14/2018
* Purpose: Create a New Lesson plan and validate it
*/

package org.testscripts;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.generic.GenericFunctions;
import org.pageobjects.CreatorUserPageObj;
import org.pageobjects.SignUpPageObj;
import org.startup.BaseTest;
import org.testng.annotations.Test;

public class LessonplanCreation extends BaseTest
{
	@Test(priority=3, groups={"Creator Group"})
	public void lessonplanCreation() throws Exception
	{
		//Step1: Login as Creator
		SignUpPageObj signupObj = new SignUpPageObj();
		signupObj.userLogin(CREATOR);

		//Step 2 : Go to workspace , create a lesson plan
		CreatorUserPageObj creatorUserPageObj = new CreatorUserPageObj();
		creatorUserPageObj.createLessonPlan();
		
		//Step 3: Submit the lesson plan for Review
		//creatorUserPageObj.saveAndPublishLesson();
		
		//Step 4: Logout as Creator
		signupObj.userLogout();
		
		//Step 5:Logout as Reviewer
		signupObj.userLogin(REVIEWER);
		
		//Step 6:Go to Workspace, Publish and 
		creatorUserPageObj.goToWorkspace("lessonplan");
		GenericFunctions.waitWebDriver(2000);
		
		//Step 7: reject the lesson plan from the existing list
		creatorUserPageObj.rejectTheContent("LESSONA");
	
		//Step 8: Logout as Reviewer
		signupObj.userLogout();
		
		//Step 9: Login as Creator
		signupObj.userLogin(CREATOR);

		//Step 10: Navigate to WorkSpace
		creatorUserPageObj.navigateToWorkspace(PUBLISHED);

		//Step 11: Delete the Created item
		creatorUserPageObj.deleteCreatedItems();

		//Step 12: Logout as Creator
		signupObj.userLogout();

	}


}
