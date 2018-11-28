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

public class VerifyLibraryCopyContent extends BaseTest
{
	//By Richa - yet to get the updated files 
	@Test
	public void library_copyContent() throws Exception
	{
	 SignUpPageObj signupobj = new SignUpPageObj();
	 CreatorUserPageObj createUserPageObj = new CreatorUserPageObj();
	 ContentCreateUploadPageObj contentCreateUploadPageObj = new ContentCreateUploadPageObj(); 
	 
	 // Step no.1:Login as a content creator
	 signupobj.userLogin(CREATOR);
	 
	 //Step no.2:Go to library
	 contentCreateUploadPageObj.navigateToLibraryAndSearchContent();
	 
	 
	 
	 
	 
	 
	 
	 
	 
	}
}
	 