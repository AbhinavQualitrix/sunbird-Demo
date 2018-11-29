/**
 * Created by Qualitrix Technologies Pvt Ltd.
 * @author: Richa Prakash
 * Date: 17/09/2018
 * Purpose:  Verify that the upload content is displaying in limited sharing bucket share pop up is displayed to the user with shareable link 
  User can access the content via share link with valid user credentials
 */

package org.testscripts;

import org.pageobjects.ContentCreateUploadPageObj;
import org.pageobjects.CreatorUserPageObj;
import org.pageobjects.SignUpPageObj;
import org.startup.BaseTest;
import org.testng.annotations.Test;

public class Creator_TC134 extends BaseTest {

	@Test

	public void workspace_LimitedPublishing() throws Exception{
		SignUpPageObj signupobj = new SignUpPageObj();
		CreatorUserPageObj createuserpageobj = new CreatorUserPageObj();
		ContentCreateUploadPageObj contentcreateuploadpageobj = new ContentCreateUploadPageObj(); 

		// Step no.1:Login as a content creator
		signupobj.userLogin(CREATOR);

		//Step no.2:Click on Workspace
		createuserpageobj.navigateToWorkspace(UPLOADCONTENT);
		
		//Steps no.3:Enter Details in edit details page
		contentcreateuploadpageobj.verifyThatEditDetailsPageIsDisplayed();
		
		
		
		
		
		
		








	}





}
