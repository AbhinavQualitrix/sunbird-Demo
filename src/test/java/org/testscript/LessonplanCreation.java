/**
* Created by Qualitrix Technologies Pvt Ltd.
* @author: Ajith Manjunath
* Date: 06/14/2018
* Purpose: Create a New Lesson plan and validate it
*/

package org.testscript;

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
		GenericFunctions genericFunctions = new GenericFunctions();
		
		//Step1: Login as Creator
		SignUpPageObj signupObj = new SignUpPageObj();
		
		
		signupObj.userLogin(CREATOR);

		//Step 2 and 3: Go to workspace , create a lesson plan
		CreatorUserPageObj creatorUserPageObj = new CreatorUserPageObj();
		
		
		creatorUserPageObj.createLessonPlan();
		
		//Step 3a : Save and send lesson plan for review
		creatorUserPageObj.saveAndSendForReviewLesson();
		
		//Step 3b : Create A lesson plan again
		creatorUserPageObj.createLessonPlan();
		
		
		//Step 4: Submit the lesson plan for Review
		creatorUserPageObj.saveAndSendForReviewLesson();
		
		//Logout as Creator
		signupObj.userLogout();
		
		//Step 5:Logout as Reviewer
		signupObj.userLogin(REVIEWER);
		
		//Step 6,7 and 8:Go to Workspace, Publish and 
		creatorUserPageObj.goToWorkspace("lessonplan");
		
		GenericFunctions.waitWebDriver(2000);
		
		//Step 9 : Reject the lesson plan from the existing list
		creatorUserPageObj.rejectTheContent("LESSONA");
	
		//Logout as Reviewer
		signupObj.userLogout();
		
		//Logout as Creator
		signupObj.userLogin(CREATOR);
		
		//Navigate to Workspace and access All My Content
		genericFunctions.navigateToWorkspaceFeatures(ALL_MY_CONTENT);
		
		//Delete the contents which have created
		creatorUserPageObj.deleteCreatedItems();
		
		//Logout as Content Creator
		signupObj.userLogout();
		
		
	}


}
