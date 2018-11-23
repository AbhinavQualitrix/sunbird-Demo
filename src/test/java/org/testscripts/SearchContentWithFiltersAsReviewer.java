package org.testscripts;

import org.testng.annotations.Test;
import org.pageobjects.CreatorUserPageObj;
import org.pageobjects.SignUpPageObj;
import org.startup.BaseTest;
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

		//Go to workspace , create a book,submit for reviwe
		creatorUserPageObj.createLessonPlan();
		
		//Save and send for Review
		creatorUserPageObj.saveAndSendForReviewLesson();
		
		//Logout as Creator
		signupObj.userLogout();
		
		//Login as content creator
		signupObj.userLogin(REVIEWER);
		
		//Navigate to workspace and apply filter and search the content type-Lesson plan
		creatorUserPageObj.searchWithFilters();
	}

}
