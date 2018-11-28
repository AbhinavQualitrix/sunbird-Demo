package org.testscripts;

import org.testng.annotations.Test;
import java.util.List;

import org.generic.ReadTestDataFromExcel;
import org.pageobjects.CreatorUserPageObj;
import org.pageobjects.SignUpPageObj;
import org.startup.BaseTest;
import org.testdata.TestDataForSunbird;
import org.testng.annotations.Test;

public class SendTheCourseForReview extends BaseTest
{
	//MT done
	@Test
	public void sendTheCourseForReview() throws Exception
	{
		List <TestDataForSunbird> objListOFTestDataForSunbird= null ;
		objListOFTestDataForSunbird = ReadTestDataFromExcel.getTestDataForSunbird("testdatasheetcourse");
		
		SignUpPageObj signupObj = new SignUpPageObj();
		CreatorUserPageObj creatorUserPageObj = new CreatorUserPageObj();
		 
		//Step 1 :Login as content creator
		signupObj.userLogin(CREATOR);
		
		
		//Navigate 
		creatorUserPageObj.navigateToWorkspace(COURSE);
		
		//Doubt here
		//Step 2 :create a Course
		creatorUserPageObj.createCourse(objListOFTestDataForSunbird);
		
		//Step 3:Submit the course for review 
		creatorUserPageObj.saveAndSendCourseForReview(objListOFTestDataForSunbird);
		
		//Step 4 :Logout as Content Creator
		signupObj.userLogout();
	}

}
