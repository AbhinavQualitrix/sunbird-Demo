package org.sunbird.testscripts;

import org.testng.annotations.Test;
import org.sunbird.generic.GenericFunctions;
import org.sunbird.pageobjects.FlagReviewerPageObj;
import org.sunbird.pageobjects.SignUpPageObj;
import org.sunbird.startup.BaseTest;
import org.testng.annotations.Test;

public class AcceptAsflagReviewer extends BaseTest
{
	@Test
	public void acceptAsflagReviewer() throws Exception
	{
		//Login as Public user
		SignUpPageObj signUpPageObj = new SignUpPageObj();
		FlagReviewerPageObj flagReviewer = new FlagReviewerPageObj();
		
		//Login as Public user
		signUpPageObj.userLogin(PUBLICUSER1);
		
		//Search a course and Flag it
		flagReviewer.courseSearchAndFlagIt();
		
		//Logout as Public user
		signUpPageObj.userLogout();
		
		//Login as FlagReviewer
		signUpPageObj.userLogin(FLAGREVIEWER);
		
		//Navigate to workspace, click Flagged and accept the flagged course
		flagReviewer.acceptDiscardFlag(ACCEPT);
		
		GenericFunctions.refreshWebPage();
		GenericFunctions.waitWebDriver(2000);
		
		//Logout as Flag reviewer
		signUpPageObj.userLogout();
	}

}
