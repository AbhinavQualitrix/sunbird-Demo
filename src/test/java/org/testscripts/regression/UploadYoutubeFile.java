/**
* Created by Qualitrix Technologies Pvt Ltd.

* @author: Richa Prakash
* Date: 28/08/2018
* Purpose:  Verify that the uploaded content pop up is displaying 
* when clicking on the upload content 
*/

package org.testscripts.regression;

import org.pageobjects.ContentCreateUploadPageObj;
import org.pageobjects.CreatorUserPageObj;
import org.pageobjects.SignUpPageObj;
import org.startup.BaseTest;
import org.testng.annotations.Test;

public class UploadYoutubeFile extends BaseTest
{
	//Files from RIcha yet to update
	@Test
	public void library_copyContent() throws Exception
	{
	 SignUpPageObj signupobj = new SignUpPageObj();
	 CreatorUserPageObj createuserpageobj = new CreatorUserPageObj();
	 ContentCreateUploadPageObj contentcreateuploadpageobj = new ContentCreateUploadPageObj(); 
	 
	 
	 // Step no.1:Login as a content creator
	 signupobj.userLogin(CREATOR);
	 
     //Step no.2:Click on Workspace
	 createuserpageobj.navigateToWorkspace(UPLOADCONTENT);
	 
	 //Step no.3:Enter URL and click on upload content
	 contentcreateuploadpageobj.verifyUploadContentPopupDisplay();
	 
	 //Step no.4:Save and Send Upload Content For Review
	 contentcreateuploadpageobj.saveAndSendUploadContentForReview();
	 
	 //Step no.5:Logout as Creator
	 signupobj.userLogout();
	 

	}
}



