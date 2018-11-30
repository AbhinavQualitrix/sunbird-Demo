package org.testscript;

import org.testng.annotations.Test;
import org.pageobjects.ContentCreateUploadPageObj;
import org.pageobjects.SignUpPageObj;
import org.startup.BaseTest;
import org.testng.annotations.Test;

public class PublishTheContent extends BaseTest{
@Test
	
	public void publishTheContent() throws Exception{
	SignUpPageObj signupobj = new SignUpPageObj();
	ContentCreateUploadPageObj contentcreateuploadpageobj = new ContentCreateUploadPageObj(); 

	//Step no.1 :Login as reviewer
	signupobj.userLogin(REVIEWER);
	
	//Step no.2 :Navigate to workspace and up for review
	contentcreateuploadpageobj.navigateToUpForReviewN();
	
	//Step no.3 :Logout as reviewer
	signupobj.userLogout();
	
	//Step no.4 :Login as creator 
	signupobj.userLogin(CREATOR);
	
	//Step no.5 :Navigate to workspace and verify the content published or not
	contentcreateuploadpageobj.publishedContent();
	
	//Step no.6 :Logout as reviewer
	signupobj.userLogout();
	

}

}