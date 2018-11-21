/**
 * Created by Qualitrix Technologies Pvt Ltd.
 * @author: Ajith Manjunath
 * Date: 06/20/2018
 * Purpose: Upload content type-HTML and validate it
 */

package org.sunbird.testscripts;

import org.testng.annotations.Test;
import org.sunbird.generic.GenericFunctions;
import org.sunbird.pageobjects.CreatorUserPageObj;
import org.sunbird.pageobjects.SignUpPageObj;
import org.sunbird.startup.BaseTest;
import org.testng.annotations.Test;

public class UploadHtmlContent  extends BaseTest 
{
	@Test(priority=8, groups={"Creator Group"})
	public void uploadHtmlContent() throws Exception
	{
		SignUpPageObj signupObj = new SignUpPageObj();
		CreatorUserPageObj creatorUserPageObj = new CreatorUserPageObj();
		GenericFunctions genereicFunctions = new GenericFunctions();

		//Step 1:Login as content creator
		signupObj.userLogin(CREATOR);

		//Handle the popup 
		creatorUserPageObj.handlePopupOnLogin();
		
		//Step 2,3 and 4:Navigate to workspace and upload content type-HTML
		creatorUserPageObj.uploadContentMp4(HTML);
		
		creatorUserPageObj.uploadContentMp4(HTML);

		//Logout as creator
		signupObj.userLogout();

		//Step 5:Login as Reviewer
		signupObj.userLogin(REVIEWER);

		//Step 6 and 7:Go to workspace and publish the content-HTML
		creatorUserPageObj.goToWorkspace("html");

		GenericFunctions.waitWebDriver(2000);

		//Step 8 reject the upload type -HTML	
		creatorUserPageObj.rejectTheUploads(HTML);

		//Logout as Reviewer
		signupObj.userLogout();

		//Step7=9: Login as Creator
		signupObj.userLogin(CREATOR);

		//Step10: Navigate to WorkSpace-All my content
		genereicFunctions.navigateToWorkspaceFeatures(ALL_MY_CONTENT);

		//Step11: Delete the Created item
		creatorUserPageObj.deleteCreatedItems();

		//Step12: Logout as Creator
		signupObj.userLogout();
	}

}
