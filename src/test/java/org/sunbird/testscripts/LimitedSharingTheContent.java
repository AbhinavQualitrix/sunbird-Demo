/**
* Created by Qualitrix Technologies Pvt Ltd.
* @author: Ajith Manjunath
* Date: 06/25/2018
* Purpose: Content Limited Sharing
*/

package org.sunbird.testscripts;

import org.testng.annotations.Test;
import java.util.List;

import org.sunbird.generic.ReadTestDataFromExcel;
import org.sunbird.pageobjects.CreatorUserPageObj;
import org.sunbird.pageobjects.SignUpPageObj;
import org.sunbird.startup.BaseTest;
import org.sunbird.testdata.TestDataForSunbird;
import org.testng.annotations.Test;

public class LimitedSharingTheContent extends BaseTest
{
	@Test(priority=14, groups={"Creator Group"})
	public void limitedSharingTheContent() throws Exception
	{
		List <TestDataForSunbird> objListOFTestDataForSunbird= null ;
		objListOFTestDataForSunbird = ReadTestDataFromExcel.getTestDataForSunbird("testdatasheetcourse");
		
		SignUpPageObj signupObj = new SignUpPageObj();
		CreatorUserPageObj creatorUserPageObj = new CreatorUserPageObj();
		
		//Step 1:Login as Content creator
		signupObj.userLogin(BOOKCREATOR);
		
		//Step 2:Navigate to workspace and create all the content types
		creatorUserPageObj.navigateToWorkspace(BOOK);
		
		//Step 3:Create content type -BOOK
		creatorUserPageObj.createBook(objListOFTestDataForSunbird);
		
		//Step 4:Send BOOK for Limited Sharing
		creatorUserPageObj.limitedSharing("Book");
		
		//Step 5: Creator Logout
		signupObj.userLogout();
		
		//Step 6:Login as Content creator
		signupObj.userLogin(CREATOR);
		
		//Step 7:Navigate to workspace to Create a course 
		creatorUserPageObj.navigateToWorkspace(COURSE);
		
		//Step 8:create content type-COURSE
		creatorUserPageObj.createCourse(objListOFTestDataForSunbird);
		
		//Step 9:Send COURSE for Limited Sharing
		creatorUserPageObj.limitedSharing("course");
		
		//Step 10:Navigate to workspace to Create a LESSON PLAN
		//AND
		//Step 11:Create content type-Lesson plan
		creatorUserPageObj.createLessonPlan();
		
		//Step 12:Send the LESSON PLAN for Limited sharing
		creatorUserPageObj.limitedSharing("lesson plan");
		
		//Step 13:Navigate to workspace to create a Resource
		creatorUserPageObj.navigateToWorkspace(RESOURCE);
		
		//Step 14:Create content type-Resource
		creatorUserPageObj.createResource(objListOFTestDataForSunbird);
		
		//Step 15:Send the RESOURCE for Limited sharing
		creatorUserPageObj.limitedSharing("resource");
		
		//Step 16:Navigate to workspace to Upload Content-
		creatorUserPageObj.navigateToWorkspace(UPLOADCONTENT);
		
		//Step 17:Create content type-EPUB
		creatorUserPageObj.uploadContentLimitedSharing(EPUB);
		
		//Step 18:Send the EPUB content for Limited sharing
		creatorUserPageObj.limitedSharing("upload");
		
		//Step 19: Creator Logout
		signupObj.userLogout();
		
	}

}
