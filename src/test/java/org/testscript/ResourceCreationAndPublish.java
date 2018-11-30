package org.testscript;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import java.util.List;

import org.generic.GenericFunctions;
import org.generic.ReadTestDataFromExcel;
import org.pageobjects.ContentCreationResourcePageObj;
import org.pageobjects.CreatorUserPageObj;
import org.pageobjects.SignUpPageObj;
import org.testdata.TestDataForSunbird;
import org.startup.BaseTest;
import org.testng.annotations.Test;

public class ResourceCreationAndPublish extends BaseTest
{
	@Test
	public void creatorResourceAndVerify() throws Exception
	{
		List <TestDataForSunbird> objListOFTestDataForSunbird= null ;
		objListOFTestDataForSunbird = ReadTestDataFromExcel.getTestDataForSunbird("testdatasheetcourse");
		SignUpPageObj creatorLogin = new SignUpPageObj();
		CreatorUserPageObj creatorUserPageObj = new CreatorUserPageObj();
		ContentCreationResourcePageObj contentReourcePageObj= new ContentCreationResourcePageObj();


		//Step1: Login as Creator
		creatorLogin.userLogin(CREATOR);

		//Step2: Navigate to WorkSpace
		creatorUserPageObj.navigateToWorkspace(RESOURCE);

		//Step3: Create new Resource
		//creatorUserPageObj.createResource(objListOFTestDataForSunbird);
		//Enter a unique resource name
		contentReourcePageObj.resourceName();

		//Add Question Set, Plugins, Audio, Video
		contentReourcePageObj.addQuestionsPluginAudioVideo();	
		
		//Step4: Save and send resource for review
		contentReourcePageObj.sendResourceForReview();

		//Step5: Check for course in review submissions 
		creatorUserPageObj.reviewInSubmissions(RESOURCE,objListOFTestDataForSunbird);

		GenericFunctions.waitWebDriver(3000);

		//Step6: Logout as Creator
		creatorLogin.userLogout();

		//Step7: Login as Reviewer
		creatorLogin.userLogin(REVIEWER);

		//Step8: Search the course which was submitted for review
		GenericFunctions.waitWebDriver(2000);
		creatorUserPageObj.searchInUpForReview(RESOURCE,objListOFTestDataForSunbird);

		//Step 9:publish the resource and search it
		creatorUserPageObj.resourcePublishAndSearch(objListOFTestDataForSunbird);

		//Step 10: Logout as Reviewer
		creatorLogin.userLogout();		

	}



}
