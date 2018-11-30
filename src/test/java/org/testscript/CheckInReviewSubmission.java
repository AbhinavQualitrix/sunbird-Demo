/**
 * Created by Qualitrix Technologies Pvt Ltd.
 * @author: Ajith Manjunath
 * Date: 06/25/2018
 * Purpose : Content send for Review shown in "Review Submission"
 */

package org.testscript;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import java.util.List;

import org.generic.GenericFunctions;
import org.generic.ReadTestDataFromExcel;
import org.pageobjects.CreatorUserPageObj;
import org.pageobjects.SignUpPageObj;
import org.startup.BaseTest;
import org.testdata.TestDataForSunbird;
import org.testng.annotations.Test;

public class CheckInReviewSubmission extends BaseTest
{
	@Test(priority=15, groups={"Creator Group"})
	public void checkInReviewSubmission() throws Exception
	{
		List <TestDataForSunbird> objListOFTestDataForSunbird= null ;
		objListOFTestDataForSunbird = ReadTestDataFromExcel.getTestDataForSunbird("testdatasheetcourse");
		GenericFunctions genereicFunctions = new GenericFunctions();
		SignUpPageObj signupObj = new SignUpPageObj();
		CreatorUserPageObj creatorUserPageObj = new CreatorUserPageObj();

		//Step 1:Login as Creator
		signupObj.userLogin(CREATOR);

		//Step 2:Navigate to workspace to Create a course
		creatorUserPageObj.navigateToWorkspace(COURSE);

		//Step 3:Create a Course
		creatorUserPageObj.createCourse(objListOFTestDataForSunbird);

		GenericFunctions.waitWebDriver(2000);

		//Step 4:Save and submit the coursed for Review
		creatorUserPageObj.saveAndSendCourseForReview(objListOFTestDataForSunbird);

		GenericFunctions.waitWebDriver(2000);

		GenericFunctions.refreshWebPage();

		//Step 5:Check the course in review submissions
		creatorUserPageObj.reviewInSubmissions(COURSE,objListOFTestDataForSunbird);

		//Step 6:Click the course and check for Non editable layout
		creatorUserPageObj.clickInReviewSubmission();

		GenericFunctions.waitWebDriver(2000);

		//Logout as creator
		signupObj.userLogout();
		
		/*//Step 7: Login as Creator
		signupObj.userLogin(CREATOR);

		//Step 8: Navigate to WorkSpace-All my content
		genereicFunctions.navigateToWorkspaceFeatures(ALL_MY_CONTENT);

		//Step 9: Delete the Created item
		creatorUserPageObj.deleteCreatedItems();

		//Step 10: Logout as Creator
		signupObj.userLogout();*/


	}

}
