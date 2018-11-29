/**
* Created by Qualitrix Technologies Pvt Ltd.

* @author: Richa Prakash
* Date: 03/09/2018
* Purpose:  Verify that the edit details pop up is displaying 
* when clicking on the upload content 
*/

package org.testscripts;

import org.testng.annotations.Test;
import org.pageobjects.ContentCreateUploadPageObj;
import org.pageobjects.CreatorUserPageObj;
import org.pageobjects.SignUpPageObj;
import org.startup.BaseTest;
import org.testng.annotations.Test;

public class EditAndVerifyTopicTree extends BaseTest

{
	@Test
	public void editAndVerifyTopicTree() throws Exception
	{
	 SignUpPageObj signupobj = new SignUpPageObj();
	 CreatorUserPageObj createuserpageobj = new CreatorUserPageObj();
	 ContentCreateUploadPageObj contentcreateuploadpageobj = new ContentCreateUploadPageObj(); 
	 
	 
	 // Step no.1:Login as a content creator
	 signupobj.userLogin(CREATOR);
	 
     //Step no.2:Click on Workspace
	 createuserpageobj.navigateToWorkspace(UPLOADCONTENT);
	 
	 //Step no.3 click on edit details popuop
	 contentcreateuploadpageobj.verifyThatEditDetailsPageIsDisplayed();
	 
	//Step no.4 :Logout as reviewer
	signupobj.userLogout();
	
	 
	 
	 

	 
	 
	}
	 
	 
	 
	
	

}