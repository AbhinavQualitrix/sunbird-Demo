package org.testscripts.regression;

import org.testng.annotations.Test;
import org.pageobjects.ContentCreationResourcePageObj;
import org.pageobjects.CreatorUserPageObj;
import org.pageobjects.SignUpPageObj;
import org.startup.BaseTest;
import org.testng.annotations.Test;

public class CreateResource_PublishAndDeleteFromLimitedPublising extends BaseTest
{
	@Test//(retryAnalyzer=BaseTest.class)
	public void characterVerifyInPreviewKeyboard() throws Exception
	{
		SignUpPageObj userLogin = new SignUpPageObj();
		CreatorUserPageObj creatorUserPageObj = new CreatorUserPageObj();
		ContentCreationResourcePageObj contentReourcePageObj= new ContentCreationResourcePageObj();
		
		//Login as Content creator
		userLogin.userLogin(CREATOR);

		//Navigate to workspace to create Resource
		creatorUserPageObj.navigateToWorkspace(RESOURCE);
		
		//Enter a unique resource name
		contentReourcePageObj.resourceName();
		
		//Add Question Set, Plugins, Audio, Video
		contentReourcePageObj.addQuestionsPluginAudioVideo();	
		
		//Click on Edit details and enter all details in the metadata page
		contentReourcePageObj.editResourceDetails();
		
		//Click on limited sharing,Share and validate link, copied link via Share Icon
		contentReourcePageObj.verifyLimitedSharing();
		
		//Navigate to workspace and click on Limited Publishing
		contentReourcePageObj.goToWorkspaceAndClick("limited publishing");
		
		//Delete contents from limited publishing
		contentReourcePageObj.deleteFromLimitedPublishing();
		
		//Logout as Creator
		userLogin.userLogout();
	}

}
