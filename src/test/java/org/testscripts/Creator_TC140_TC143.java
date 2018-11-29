package org.testscripts;

import org.pageobjects.ContentCreateUploadPageObj;
import org.pageobjects.CreatorUserPageObj;
import org.pageobjects.SignUpPageObj;
import org.startup.BaseTest;
import org.testng.annotations.Test;

public class Creator_TC140_TC143 extends BaseTest{
@Test
	
	public void workspace_showfilter() throws Exception{
	SignUpPageObj signupobj = new SignUpPageObj();
	CreatorUserPageObj createuserpageobj = new CreatorUserPageObj();
	ContentCreateUploadPageObj contentcreateuploadpageobj = new ContentCreateUploadPageObj(); 

	//Step no.1 :Login as reviewer
	signupobj.userLogin(REVIEWER);
	
	//Step no.2 :Navigate to workspace and up for review
	contentcreateuploadpageobj.navigateToUpForReview1();
	
	signupobj.userLogout();
	
	//Step no. 3 :Login as creator 
	signupobj.userLogin(CREATOR);
	
	//Step no.4 :Navigate to workspace and verify the content published or not
	contentcreateuploadpageobj.publishedContent();
	
	
	

}

}