/**
* Created by Qualitrix Technologies Pvt Ltd.
* @author: Richa Prakash
* Date: 19/09/2018
* Purpose:  Verify that the upload content is showing in the up for review
*/


package org.testscripts;
import org.pageobjects.ContentCreateUploadPageObj;
import org.pageobjects.CreatorUserPageObj;
import org.pageobjects.SignUpPageObj;
import org.startup.BaseTest;
import org.testng.annotations.Test;

public class Creator_TC136_TC137 extends BaseTest {

	@Test
	public  void workspace_reviewsubmission() throws Exception {
		SignUpPageObj signupobj = new SignUpPageObj();
		CreatorUserPageObj createuserpageobj = new CreatorUserPageObj();
		ContentCreateUploadPageObj contentcreateuploadpageobj = new ContentCreateUploadPageObj(); 


		// Step no.1:Login as a content creator
		signupobj.userLogin(CREATOR);

		//Step no.2:Click on Workspace
		createuserpageobj.navigateToWorkspace(UPLOADCONTENT);

		//Step no.3:Enter URL and click on upload content
		contentcreateuploadpageobj.verifyThatEditDetailsPageIsDisplayed();

		
		//Steps no.4:Check the in review submission page
		contentcreateuploadpageobj.reviewSubmissionPage();

		
	    //Step no. 5:Logout as a content reviewer
		signupobj.userLogout();
		
		//Step no.6 :Login as reviewer
		signupobj.userLogin(REVIEWER);
		
		//Step no.7 :Navigate to worksapce		
		contentcreateuploadpageobj.navigateToUpForReview();
		
		
		
		
		



	}
}
