/**
* Created by Qualitrix Technologies Pvt Ltd.
* @author: Ajith Manjunath
* Date: 06/21/2018
* Purpose: Create a New Resource and validate it
*/

package org.sunbird.testscripts;

import org.testng.annotations.Test;
import java.util.List;

import org.sunbird.generic.GenericFunctions;
import org.sunbird.generic.ReadTestDataFromExcel;
import org.sunbird.pageobjects.CreatorUserPageObj;
import org.sunbird.pageobjects.SignUpPageObj;
import org.sunbird.startup.BaseTest;
import org.sunbird.testdata.TestDataForSunbird;
import org.testng.annotations.Test;

public class ResourceCreation extends BaseTest {
	
	@Test(priority=11, groups={"Creator Group"})
	public void resourceCreation() throws Exception
	{
		List <TestDataForSunbird> objListOFTestDataForSunbird= null ;
		objListOFTestDataForSunbird = ReadTestDataFromExcel.getTestDataForSunbird("testdatasheetcourse");
		SignUpPageObj creatorLogin = new SignUpPageObj();
		CreatorUserPageObj creatorUserPageObj = new CreatorUserPageObj();
		
		//Step1: Login as Creator
		creatorLogin.userLogin(CREATOR);
		
		//Step2: Navigate to WorkSpace
		creatorUserPageObj.navigateToWorkspace(RESOURCE);
		
		//Step3: Create new Resource
		creatorUserPageObj.resourceName();
		
		//Step4: Add Audio for the resource.
		creatorUserPageObj.addAudio();
		creatorUserPageObj.sendResourceForReview();
		
		//Wait for 2 seconds and refresh the web page
		GenericFunctions.waitWebDriver(2000);
		GenericFunctions.refreshWebPage();
			
		//Step5: Check for course in review submissions 
		creatorUserPageObj.reviewInSubmissions(RESOURCE,objListOFTestDataForSunbird);
		GenericFunctions.waitWebDriver(3000);

		//Step6: Logout as Creator
		creatorLogin.userLogout();
		
		//Step7: Login as Reviewer
		creatorLogin.userLogin(REVIEWER);
		
		//Step8: Search the course which was submitted for review
		GenericFunctions.waitWebDriver(2000);
		String resourceToReject = creatorUserPageObj.searchInUpForReview(RESOURCE,objListOFTestDataForSunbird);
		System.out.println(resourceToReject);
		
		//Step 9:publish the resource and search it
		creatorUserPageObj.resourcePublishAndSearch(objListOFTestDataForSunbird);
		
		//Step 10:Reject the course, which is already have been reviewed
		creatorUserPageObj.rejectTheResource();
		
		//Step 11: Logout as Reviewer
		creatorLogin.userLogout();		
		
	}

}