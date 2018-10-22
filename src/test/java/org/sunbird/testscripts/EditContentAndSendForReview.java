/**
* Created by Qualitrix Technologies Pvt Ltd.
* @author: Ajith Manjunath
* Date: 06/22/2018
* Purpose: Edit and save a Reject content and send for review
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

public class EditContentAndSendForReview extends BaseTest
{
	@Test(priority=13, groups={"Creator Group"})
	public void editContentAndSendForReview() throws Exception
	{
		List <TestDataForSunbird> objListOFTestDataForSunbird= null ;
		objListOFTestDataForSunbird = ReadTestDataFromExcel.getTestDataForSunbird("testdatasheetcourse");

		SignUpPageObj signupObj = new SignUpPageObj();
		CreatorUserPageObj creatorUserPageObj = new CreatorUserPageObj();
		
		//Step 1:Login as content creator
		signupObj.userLogin(CREATOR);

		//Step 2:Navigate to WorkSpace
		creatorUserPageObj.navigateToWorkspace(COURSE);

		//Step 3:Create new Course
		creatorUserPageObj.createCourse(objListOFTestDataForSunbird);
		GenericFunctions.waitWebDriver(2000);
		
		//Step 4:Save and Send for Review
		creatorUserPageObj.saveAndSendCourseForReview(objListOFTestDataForSunbird);
		GenericFunctions.waitWebDriver(2000);
		GenericFunctions.refreshWebPage();
		
		//Step 5:Check for course in review submissions 
		creatorUserPageObj.reviewInSubmissions(COURSE,objListOFTestDataForSunbird);
		GenericFunctions.waitWebDriver(3000);
		
		//Step 6: Logout as Creator
		signupObj.userLogout();
		
		//Step 7:Login as Reviewer
		signupObj.userLogin(REVIEWER);
		
		//Step 8:Reject the Content -Course 	
		creatorUserPageObj.rejectTheContent(COURSE);
		GenericFunctions.waitWebDriver(2000);
		
		//Step 9: Logout as Reviewer again 
		signupObj.userLogout();
		
		//Step 10:Login As Creator
		signupObj.userLogin(CREATOR);
		
		//Step 11:Go to Drafts, Edit and Re submit the content for review
		creatorUserPageObj.editAndSubmitContent();
		//wait for 2 sec
		GenericFunctions.waitWebDriver(2000);
		
		//Step 12: Logout as Creator after Resubmitting the content for Review
		signupObj.userLogout();
		
		//Step 13:Login as Reviewer , 
		signupObj.userLogin(REVIEWER);
		
		//Step 14:Navigation to Up for review and then publish the content
		creatorUserPageObj.searchInUpForReview(COURSE, objListOFTestDataForSunbird);
		GenericFunctions.waitWebDriver(2000);
		
		//Step 15:Go to up for review and publish the content
		creatorUserPageObj.publishAndSearch(COURSE,objListOFTestDataForSunbird);
		//wait for 2 sec
		GenericFunctions.waitWebDriver(2000);
		
		//Step 16: Logout as Reviewer
		signupObj.userLogout();
		
		//Step 17: Login as Creator
		signupObj.userLogin(CREATOR);

		//Step 18: Navigate to WorkSpace
		creatorUserPageObj.navigateToWorkspace(PUBLISHED);

		//Step 19: Delete the Created item
		creatorUserPageObj.deleteCreatedItems();

		//Step 20: Logout as Creator
		signupObj.userLogout();
	}

}
