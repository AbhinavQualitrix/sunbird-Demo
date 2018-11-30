package org.testscript;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import java.util.List;
import org.generic.GenericFunctions;
import org.generic.ReadTestDataFromExcel;
import org.pageobjects.CreateMentorPageObj;
import org.pageobjects.CreatorUserPageObj;
import org.pageobjects.SignUpPageObj;
import org.startup.BaseTest;
import org.testdata.TestDataForSunbird;
import org.testng.annotations.Test;

public class CreateCourseAndVerify extends BaseTest {
	
	@Test
	public void creatorCourseAndVerify() throws Exception
	{
		List <TestDataForSunbird> objListOFTestDataForSunbird= null ;
		objListOFTestDataForSunbird = ReadTestDataFromExcel.getTestDataForSunbird("testdatasheetcourse");
		
		CreateMentorPageObj createMentorPageObj = new CreateMentorPageObj();
		
		//Step1: Login as Creator
		
		SignUpPageObj creatorLogin = new SignUpPageObj();
		CreatorUserPageObj creatorUserPageObj = new CreatorUserPageObj();
		
		
		creatorLogin.userLogin(CREATOR);
		
		//Step2: Navigate to WorkSpace
		creatorUserPageObj.navigateToWorkspace(COURSE);
		
		//Step3: Create new Course
		creatorUserPageObj.createCourse(objListOFTestDataForSunbird);
		
		//Step4: Save and send course for review
		
		creatorUserPageObj.saveAndSendCourseForReview(objListOFTestDataForSunbird);
		
		GenericFunctions.refreshWebPage();
			
		//Step5: Check for course in review submissions 
		creatorUserPageObj.reviewInSubmissions(COURSE,objListOFTestDataForSunbird);
		
		GenericFunctions.waitWebDriver(3000);

		//Step6: Logout as Creator
		creatorLogin.userLogout();
		
		//Step7: Login as Reviewer
		creatorLogin.userLogin(REVIEWER);
		
		//Step8: Search the course which was submitted for review
		GenericFunctions.waitWebDriver(2000);
		creatorUserPageObj.searchInUpForReview(COURSE,objListOFTestDataForSunbird);
		
		//Step 9:publish the resource and search it
		creatorUserPageObj.resourcePublishAndSearch(objListOFTestDataForSunbird);
		
		//Step 10: Logout as Reviewer
		creatorLogin.userLogout();		
		
		//Step11: Login as Public User
		creatorLogin.userLogin(PUBLICUSER1);
	
		//Step12: Search the course with Name
		GenericFunctions.waitWebDriver(2000);
		
		createMentorPageObj.navigateToCourseAndSearchForOpenBatch();

		//Step 13: Logout as Reviewer
		creatorLogin.userLogout();		
		
	}

}