package org.sunbird.testscripts;

import org.testng.annotations.Test;
import java.util.List;

import org.sunbird.generic.GenericFunctions;
import org.sunbird.generic.ReadTestDataFromExcel;
import org.sunbird.pageobjects.CreatorUserPageObj;
import org.sunbird.pageobjects.FlagReviewerPageObj;
import org.sunbird.pageobjects.SignUpPageObj;
import org.sunbird.startup.BaseTest;
import org.sunbird.testdata.TestDataForSunbird;
import org.testng.annotations.Test;

public class ChangeTheContentAfterFlagged extends BaseTest
{
	@Test
	public void changeTheContentAfterFlagged() throws Exception
	{
		List <TestDataForSunbird> objListOFTestDataForSunbird= null ;
		objListOFTestDataForSunbird = ReadTestDataFromExcel.getTestDataForSunbird("testdatasheetcourse");
		
		SignUpPageObj signUpPageObj = new SignUpPageObj();
		FlagReviewerPageObj flagReviewer = new FlagReviewerPageObj();
		CreatorUserPageObj creatorUserPageObj = new CreatorUserPageObj();
		
		//Login as content creator
		signUpPageObj.userLogin(CREATOR);
		
		//Navigate to workspace	
		creatorUserPageObj.navigateToWorkspace(RESOURCE);
		
		//Create new Course
		creatorUserPageObj.createResource(objListOFTestDataForSunbird);
		
		//Save and send resource for review
		creatorUserPageObj.saveAndSendResouceForReview();
		GenericFunctions.waitWebDriver(2000);
		GenericFunctions.refreshWebPage();
		
		// Check for course in review submissions 
		creatorUserPageObj.reviewInSubmissions(RESOURCE,objListOFTestDataForSunbird);
		
		GenericFunctions.waitWebDriver(3000);
		
		//Logout as Creator
		signUpPageObj.userLogout();
		
		
		//Login as Reviewer
		signUpPageObj.userLogin(REVIEWER);
		
		//Search the course which was submitted for review
		GenericFunctions.waitWebDriver(2000);
		String resourceToSearch=creatorUserPageObj.searchInUpForReview(RESOURCE,objListOFTestDataForSunbird);
		
		//publish the resource and search it
		creatorUserPageObj.resourcePublishAndSearch(objListOFTestDataForSunbird);
		
		//creatorUserPageObj.resourcePublishAndSearch(objListOFTestDataForSunbird);
		
		//logout as Reviewer
		signUpPageObj.userLogout();	
		
		
		//String resourceToSearch ="Automation ResourceR0024";
		//Now Login As Public user
		signUpPageObj.userLogin(PUBLICUSER1);
		
		//Search the resource and flag it
		flagReviewer.searchAndFlagResource(resourceToSearch);
		
		//Logout as public user
		signUpPageObj.userLogout();
		
		
		//Login as Flag reviewer
		signUpPageObj.userLogin(FLAGREVIEWER);
		
		//Open the content - Accept the flag
		flagReviewer.acceptDiscardBlue(ACCEPT);
		GenericFunctions.waitWebDriver(2000);
		GenericFunctions.refreshWebPage();
		
		//Logout as Flag reviewer
		signUpPageObj.userLogout();
		
		//Login as Content creator
		signUpPageObj.userLogin(CREATOR);
		
		//Go to the Drafts,open the content, 
		//Edit the content and again submit for review 
		flagReviewer.editAndSubmitContent();
		GenericFunctions.waitWebDriver(3000);
		GenericFunctions.refreshWebPage();
		GenericFunctions.waitWebDriver(3000);	
		
		//Logout as Content Creator
		signUpPageObj.userLogout();
		
		//Login as Flag reviewer
		signUpPageObj.userLogin(FLAGREVIEWER);
		
		//Publish the content
		flagReviewer.publishRequestChanges(PUBLISH);
		
		//Logout as FlagReviewer
		signUpPageObj.userLogout();
		
	}
}
