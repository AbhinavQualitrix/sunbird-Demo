/**
 * Created by Qualitrix Technologies Pvt Ltd.
 * @author: Richa Prakash
 * Date: 20/09/2018
 * Purpose:  Verify that the uploaded content pop up is displaying 
 * when clicking on the upload content 
 */


package org.testscripts;
import org.testng.annotations.Test;
import org.pageobjects.ContentCreateUploadPageObj;
import org.pageobjects.CreatorUserPageObj;
import org.pageobjects.SignUpPageObj;
import org.startup.BaseTest;
import org.testng.annotations.Test;

public class VerifyTheSorting extends BaseTest {

	@Test

	public void  verifyTheSorting() throws Exception {
		SignUpPageObj signupobj = new SignUpPageObj();
		ContentCreateUploadPageObj contentcreateuploadpageobj = new ContentCreateUploadPageObj(); 

		//Step no.1 :Login as reviewer
		signupobj.userLogin(REVIEWER);
		

		//Step no.2 :Navigate to workspace		
		contentcreateuploadpageobj.navigateToUpForReview();
		
		//step no.3:Click on sort By
		contentcreateuploadpageobj.clickOnSortBy();
		
		//Step no.4 :Logout as reviewer
		signupobj.userLogout();
		
		




	}


}
