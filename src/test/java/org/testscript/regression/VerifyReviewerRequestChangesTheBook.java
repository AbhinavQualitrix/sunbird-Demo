package org.testscript.regression;
import org.testng.annotations.Test;

import java.util.List;

import org.generic.GenericFunctions;
import org.generic.ReadTestDataFromExcel;
import org.pageobjects.ContentCreationLessonPlanPageObj;
import org.pageobjects.CreateMentorPageObj;
import org.pageobjects.CreatorUserPageObj;
import org.pageobjects.SignUpPageObj;
import org.startup.BaseTest;
import org.testdata.TestDataForSunbird;
import org.testng.annotations.Test;

public class VerifyReviewerRequestChangesTheBook  extends BaseTest
{
	//Files yet to update from Richa
	@Test
	public void verifyReviewerRequestChangesTheBook() throws Exception
	{
		
		List <TestDataForSunbird> objListOFTestDataForSunbird= null ;
		objListOFTestDataForSunbird = ReadTestDataFromExcel.getTestDataForSunbird("testdatasheetcourse");
		CreatorUserPageObj creatorUserPageObj = new CreatorUserPageObj();
		SignUpPageObj creatorLogin = new SignUpPageObj();
		ContentCreationLessonPlanPageObj contentLessonPlanObj= new ContentCreationLessonPlanPageObj();
		
		
		
		//1.Login as  reviewer
		creatorLogin.userLogin(REVIEWER);
		
		//2.Navigate to workspace-
		contentLessonPlanObj.navigateToUpForReview();
		
		//3.Go to up for Review
		contentLessonPlanObj.rejectTheContent();
		
	
		//4.User is again redirected back to up for review section
		//contentLessonPlanObj.verifyReviewerIsRedirectedPage();
	}
}
