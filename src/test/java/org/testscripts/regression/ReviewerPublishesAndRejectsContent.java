package org.testscripts.regression;

import org.pageobjects.ContentCreateUploadPageObj;
import org.pageobjects.CreatorUserPageObj;
import org.pageobjects.SignUpPageObj;
import org.startup.BaseTest;
import org.testng.annotations.Test;

public class ReviewerPublishesAndRejectsContent extends BaseTest{
	//TC140_TC_143
	@Test
	public void workspace_showfilter() throws Exception
	{
	SignUpPageObj signUpPageObj = new SignUpPageObj();
	CreatorUserPageObj createUserPageObj = new CreatorUserPageObj();
	ContentCreateUploadPageObj contentCreateUploadPageObj = new ContentCreateUploadPageObj(); 

	//Step no.1 :Login as reviewer
	signUpPageObj.userLogin(REVIEWER);
	
	//Step no.2 :Navigate to workspace and up for review
	contentCreateUploadPageObj.navigateToUpForReview1();
	
	//Step no.3 :Loggout
	signUpPageObj.userLogout();
	
	//Step no. 3 :Login as creator 
	signUpPageObj.userLogin(CREATOR);
	
	//Step no.4 :Navigate to workspace and verify the content published or not
	contentCreateUploadPageObj.publishedContent();
	
	
	

}

}