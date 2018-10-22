package org.sunbird.testscripts;

import org.testng.annotations.Test;
import java.util.List;

import org.sunbird.generic.ReadTestDataFromExcel;
import org.sunbird.pageobjects.CreatorUserPageObj;
import org.sunbird.pageobjects.SignUpPageObj;
import org.sunbird.startup.BaseTest;
import org.sunbird.testdata.TestDataForSunbird;
import org.testng.annotations.Test;

public class SendTheCourseForReview extends BaseTest
{
	@Test
	public void sendTheCourseForReview() throws Exception
	{
		List <TestDataForSunbird> objListOFTestDataForSunbird= null ;
		objListOFTestDataForSunbird = ReadTestDataFromExcel.getTestDataForSunbird("testdatasheetcourse");
		
		SignUpPageObj signupObj = new SignUpPageObj();
		CreatorUserPageObj creatorUserPageObj = new CreatorUserPageObj();
		 
		//Step 1:Login as content creator
		signupObj.userLogin(CREATOR);
		
		//Step 2:create a course
		creatorUserPageObj.createResource(objListOFTestDataForSunbird);
		
		//Step 3:Submit the course for review 
		creatorUserPageObj.saveAndSendCourseForReview(objListOFTestDataForSunbird);
	}

}
