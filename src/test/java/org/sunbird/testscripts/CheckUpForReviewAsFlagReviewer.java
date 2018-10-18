package org.sunbird.testscripts;

import org.testng.annotations.Test;
import org.sunbird.pageobjects.FlagReviewerPageObj;
import org.sunbird.pageobjects.SignUpPageObj;
import org.sunbird.startup.BaseTest;
import org.testng.annotations.Test;

public class CheckUpForReviewAsFlagReviewer extends BaseTest 
{
	@Test(priority=1)
	public void checkUpForReviewAsFlagReviewer() throws Exception
	{
		//Login as creator
		SignUpPageObj creatorObj = new SignUpPageObj();	
		creatorObj.userLogin(FLAGREVIEWER);
		
		//Search for a course and content flag them
		FlagReviewerPageObj flagReviewer = new FlagReviewerPageObj();
		flagReviewer.flagged_UpforReview();
	}

}
