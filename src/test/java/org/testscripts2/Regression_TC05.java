/**

* Created by Qualitrix Technologies Pvt Ltd.

* @author: Abhinav kumar singh

* Date: 08/03/2018

* Purpose: Create Lesson plan as creator and publish as reviewer and consume as Public user.

*/
package org.testscripts2;

import org.testng.annotations.Test;
import java.util.List;

import org.generic.GenericFunctions;
import org.generic.ReadTestDataFromExcel;
import org.pageobjects.CreateMentorPageObj;
import org.pageobjects.CreatorUserPageObj;
import org.pageobjects.SignUpPageObj;
import org.startup.BaseTest;
import org.testdata.TestDataForSunbird;
import org.testng.annotations.Test;

public class Regression_TC05 extends BaseTest {
	
	@Test
	public void createLessonAndVerify_TC_12_13_14() throws Exception
	{
		List <TestDataForSunbird> objListOFTestDataForSunbird= null ;
		objListOFTestDataForSunbird = ReadTestDataFromExcel.getTestDataForSunbird("testdatasheetcourse");
		SignUpPageObj creatorLogin = new SignUpPageObj();
		CreatorUserPageObj creatorUserPageObj = new CreatorUserPageObj();
		CreateMentorPageObj createMentorPageObj = new CreateMentorPageObj();
		
		//Step1: Login as Creator
		creatorLogin.userLogin(CREATOR);
		
		//Step2: Navigate to WorkSpace		
		creatorUserPageObj.navigateToWorkspace(LESSONPLAN);
		
		//Step3: Create new Course
		creatorUserPageObj.createLessonPlan();
		
		//Step4: Save and send lesson plan for review
		creatorUserPageObj.saveAndSendForReviewLesson();
		
		//creatorUserPageObj.saveAndSendNewLessonPlanForReview();
		GenericFunctions.refreshWebPage();
			
		//Step5: Check for course in review submissions 
		creatorUserPageObj.reviewInSubmissions(LESSONPLAN,objListOFTestDataForSunbird);
		GenericFunctions.waitWebDriver(3000);

		//Step6: Logout as Creator
		creatorLogin.userLogout();
		
		//Step7: Login as Reviewer
		creatorLogin.userLogin(REVIEWER);
		
		//Step8: Go to Workspace and publish the lesson plan
		GenericFunctions.waitWebDriver(2000);
		creatorUserPageObj.goToWorkspace("lesson plan");
		
		
		//creatorUserPageObj.searchInUpForReview(LESSONPLAN,objListOFTestDataForSunbird);
		//creatorUserPageObj.LessonPlanPublishAndSearch(objListOFTestDataForSunbird);
		
		//Step 9:publish the lesson plan and search it
		
		
		//Step 10: Logout as Reviewer
		creatorLogin.userLogout();		
		
		//Step11: Login as Public User
		creatorLogin.userLogin(PUBLICUSER1);

		//Step12: Search the course with Name
		GenericFunctions.waitWebDriver(2000);
		createMentorPageObj.navigateToLibraryAndSearchForLessonPlan();

		//Step 13: Logout as Reviewer
		creatorLogin.userLogout();		
		
	}

}