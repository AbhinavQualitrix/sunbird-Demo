/**
 * Created by Qualitrix Technologies Pvt Ltd.
 * @author: Ajith Manjunath
 * Date: 06/11/2018
 * Purpose: Create a New Course and validate it
 */


package org.testscripts;

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

public class CourseCreation extends BaseTest
{
	//MT done
	@Test(priority=1, groups={"Creator Group"})
	public void courseCreation() throws Exception
	{
		List <TestDataForSunbird> objListOFTestDataForSunbird= null ;
		objListOFTestDataForSunbird = ReadTestDataFromExcel.getTestDataForSunbird("testdatasheetcourse");

		GenericFunctions genereicFunctions = new GenericFunctions();
		SignUpPageObj creatorLogin = new SignUpPageObj();
		CreatorUserPageObj creatorUserPageObj = new CreatorUserPageObj();

		//Step1: Login as Creator
		creatorLogin.userLogin(CREATOR);
		
		//Step2: Navigate to WorkSpace
		creatorUserPageObj.navigateToWorkspace(COURSE);

		//Step3: Create new Course
		creatorUserPageObj.createCourse(objListOFTestDataForSunbird);

		//Step4: Save and Send for Review
		creatorUserPageObj.saveAndSendCourseForReview(objListOFTestDataForSunbird);

		//Step5: Check for course in review submissions 
		creatorUserPageObj.reviewInSubmissions(COURSE,objListOFTestDataForSunbird);

		//Step6: Logout as Creator
		creatorLogin.userLogout();

		
		//Step7: Login as Reviewer
		creatorLogin.userLogin(REVIEWER);


		
		//Step8: Search the course which was submitted for review
		creatorUserPageObj.searchInUpForReview(COURSE,objListOFTestDataForSunbird);

		//Publish the Course
		creatorUserPageObj.publishAndSearch(COURSE,objListOFTestDataForSunbird);

		//Reject the course
		creatorUserPageObj.rejectTheContent("COURSEAC");

		//Step9: Logout as Reviewer
		creatorLogin.userLogout();

		//Step 10: Login as Creator
		creatorLogin.userLogin(CREATOR);

		//Step11: Navigate to WorkSpace-All my content
		genereicFunctions.navigateToWorkspaceFeatures(ALL_MY_CONTENT);
		
		//Step 12: Delete the Created item
		creatorUserPageObj.deleteCreatedItems();

		//Step 13: Logout as Creator
		creatorLogin.userLogout();
		 
	}




}
