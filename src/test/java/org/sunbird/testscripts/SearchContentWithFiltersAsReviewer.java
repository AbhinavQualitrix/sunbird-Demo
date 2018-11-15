package org.sunbird.testscripts;

import org.testng.annotations.Test;
import org.sunbird.pageobjects.CreatorUserPageObj;
import org.sunbird.pageobjects.SignUpPageObj;
import org.sunbird.startup.BaseTest;
import org.testng.annotations.Test;

public class SearchContentWithFiltersAsReviewer extends BaseTest
{
	@Test
	public void searchContentWithFiltersAsReviewer() throws Exception
	{
		CreatorUserPageObj creatorUserPageObj = new CreatorUserPageObj();
		SignUpPageObj signupObj = new SignUpPageObj();
		
		
		//Step1: Login as Creator
		signupObj.userLogin(CREATOR);

		//Step2:Go to workspace , create a book,submit for reviwe
		creatorUserPageObj.createLessonPlan();
		
		//Step3:Save and send for Review
		//creatorUserPageObj.saveAndPublishLesson();
		
		//Step4:Logout as Creator
		signupObj.userLogout();
		
		//Step5:Login as content creator
		signupObj.userLogin(REVIEWER);
		
		//Step6:Navigate to workspace and apply filter and search the content type-Lesson plan
		creatorUserPageObj.searchWithFilters();
		
		//Step7:Logout as Creator
		signupObj.userLogout();
	}

}
