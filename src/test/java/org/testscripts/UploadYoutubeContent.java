/**
 * Created by Qualitrix Technologies Pvt Ltd.
 * @author: Ajith Manjunath
 * Date: 06/20/2018
 * Purpose:  Upload content type-YOUTUBE and validate it
 */

package org.testscripts;

import org.testng.annotations.Test;
import org.generic.GenericFunctions;
import org.pageobjects.CreatorUserPageObj;
import org.pageobjects.SignUpPageObj;
import org.startup.BaseTest;
import org.testng.annotations.Test;

public class UploadYoutubeContent extends BaseTest
{
	//MT done
	@Test(priority=6, groups={"Creator Group"})
	public void uploadYoutubeContent() throws Exception
	{
		SignUpPageObj signupObj = new SignUpPageObj();
		CreatorUserPageObj creatorUserPageObj = new CreatorUserPageObj();
		GenericFunctions genereicFunctions = new GenericFunctions();

		//Step 1:Login as content creator
		signupObj.userLogin(CREATOR);


		
		//Step 2,3 and 4:Navigate to workspace and upload content from YouTube link
		creatorUserPageObj.uploadContentMp4(YOUTUBE);

		creatorUserPageObj.uploadContentMp4(YOUTUBE);

		//Logout as creator
		signupObj.userLogout();

		//Step 5:Login as Reviewer
		signupObj.userLogin(REVIEWER);

		//Step 6,7:Go to workspace and publish the youtube content
		creatorUserPageObj.goToWorkspace("youtube");

		GenericFunctions.waitWebDriver(2000);

		//Step 8 :reject the upload type -YOUTUBE
		creatorUserPageObj.rejectTheUploads(YOUTUBE);

		//Logout as Reviewer
		signupObj.userLogout();

		/*//Step9: Login as Creator
		signupObj.userLogin(CREATOR);

		//Step10: Navigate to WorkSpace-All my content
		genereicFunctions.navigateToWorkspaceFeatures(ALL_MY_CONTENT);

		//Step11: Delete the Created item
		creatorUserPageObj.deleteCreatedItems();

		//Step12: Logout as Creator
		signupObj.userLogout();*/


	}

}
