/**
* Created by Qualitrix Technologies Pvt Ltd.
* @author: Ajith Manjunath
* Date: 06/18/2018
* Purpose:  Upload the Content type - Mp4 and validate it
*/

package org.sunbird.testscripts;

import org.testng.annotations.Test;
import org.sunbird.generic.GenericFunctions;
import org.sunbird.pageobjects.CreatorUserPageObj;
import org.sunbird.pageobjects.SignUpPageObj;
import org.sunbird.startup.BaseTest;
import org.testng.annotations.Test;

public class UploadMp4Content extends BaseTest
{
	@Test(priority=4, groups={"Creator Group"})
	public void uploadMp4Content() throws Exception
	{
		SignUpPageObj signupObj = new SignUpPageObj();
		CreatorUserPageObj creatorUserPageObj = new CreatorUserPageObj();
		
		//Step 1:Login as content creator
		signupObj.userLogin(CREATOR);
		
		//Step 2,3 and 4:Navigate to workspace and upload content-MP4 and send the content for review
		creatorUserPageObj.uploadContentMp4(MP4);
		creatorUserPageObj.uploadContentMp4(MP4);
		
		//Logout as creator
		signupObj.userLogout();
		
		//Step 5:Login as Reviewer
		signupObj.userLogin(REVIEWER);
		
		//Step 6, 7:Go to workspace and publish content Mp4
		creatorUserPageObj.goToWorkspace("mp4");
		
		GenericFunctions.waitWebDriver(2000);
		
		//Reject the upload type-MP4 which is already existing in the list
		creatorUserPageObj.rejectTheUploads("mp4");
		
		//Logout as Reviewer
		signupObj.userLogout();
		
		//Step 8: Login as Creator
		signupObj.userLogin(CREATOR);

		//Step 9: Navigate to WorkSpace
		creatorUserPageObj.navigateToWorkspace(PUBLISHED);

		//Step 10: Delete the Created item
		creatorUserPageObj.deleteCreatedItems();

		//Step 11: Logout as Creator
		signupObj.userLogout();

	}
}
