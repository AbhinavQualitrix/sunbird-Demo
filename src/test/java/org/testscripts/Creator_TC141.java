
package org.testscripts;
import org.pageobjects.ContentCreateUploadPageObj;
import org.pageobjects.CreatorUserPageObj;
import org.pageobjects.SignUpPageObj;
import org.startup.BaseTest;
import org.testng.annotations.Test;

public class Creator_TC141 extends BaseTest{
@Test
	
	public void workspace_showfilter() throws Exception{
	SignUpPageObj signupobj = new SignUpPageObj();
	CreatorUserPageObj createuserpageobj = new CreatorUserPageObj();
	ContentCreateUploadPageObj contentcreateuploadpageobj = new ContentCreateUploadPageObj(); 

	//Step no.1 :Login as reviewer
	signupobj.userLogin(REVIEWER);
	
	//Step no.2:Navigate to workspace and request the changes
	contentcreateuploadpageobj.requestChanges();
	
	//Step no. :Logout as reviewer
	signupobj.userLogout();
	
	//Step np.:Login as creator	
	signupobj.userLogin(CREATOR);
	
	//Step no.:Navigate to workspace then navigate to all uploads 
	contentcreateuploadpageobj.alluploads();
	
	
	
	
	
}
}