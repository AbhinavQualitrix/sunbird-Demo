/**

* Created by Qualitrix Technologies Pvt Ltd.

* @author: Abhinav kumar singh

* Date: 07/20/2018

* Purpose: Create course as Mentor and try to create open batch for it,public user should consume it,mentor can check the stats.

*/

package org.testscripts;

import org.testng.annotations.Test;
import java.util.List;

import org.generic.GenericFunctions;
import org.generic.ReadTestDataFromExcel;
import org.openqa.selenium.support.PageFactory;
import org.page.CreateMentorPage;
import org.pageobjects.CreateMentorPageObj;
import org.pageobjects.CreatorUserPageObj;
import org.pageobjects.SignUpPageObj;
import org.startup.BaseTest;
import org.testdata.TestDataForSunbird;
import org.testng.annotations.Test;

public class ConsumeOpenCourseByPublicUserAndCheckCourseStatAsMentor extends BaseTest
{
	@Test
	public void consumeOpenCourseByPublicUserAndCheckCourseStatAsMentor() throws Exception
	{
		CreateMentorPage createMentorPage=PageFactory.initElements(driver, CreateMentorPage.class);
		List <TestDataForSunbird> objListOFTestDataForSunbird= null ;
		objListOFTestDataForSunbird = ReadTestDataFromExcel.getTestDataForSunbird("testdatasheetcourse");
		SignUpPageObj userLogin = new SignUpPageObj();
		CreatorUserPageObj creatorUserPageObj = new CreatorUserPageObj();
		CreateMentorPageObj createMentorPageObj=new CreateMentorPageObj();
	
		
		
		//Step1: Login as Mentor
		userLogin.userLogin(MENTOR);
		
		//Step2: Navigate to WorkSpace
		creatorUserPageObj.navigateToWorkspace(COURSE);
		
		//Step3: Create new Course
		creatorUserPageObj.createCourse(objListOFTestDataForSunbird);
		
		//Step4: Save and Send for Review	
		creatorUserPageObj.saveAndSendCourseForReview(objListOFTestDataForSunbird);
		GenericFunctions.refreshWebPage();
		
		//Step5: Check for course in review submissions 
		creatorUserPageObj.reviewInSubmissions(COURSE,objListOFTestDataForSunbird);
	
		//Step6: Logout as Mentor
		userLogin.userLogout();
		
		//Step7: Login as Reviewer
		userLogin.userLogin(REVIEWER);
		
		//Step8: Search the course which was submitted for review
		GenericFunctions.waitWebDriver(2000);
		creatorUserPageObj.searchInUpForReview(COURSE,objListOFTestDataForSunbird);
		
		//Step9:Publish the Course
		
		String courseName=creatorUserPageObj.publishAndSearch(COURSE,objListOFTestDataForSunbird);
		System.out.println(courseName);
		
		//Step10: Logout as Reviewer
		GenericFunctions.refreshWebPage();
		userLogin.userLogout();	
		
		//Step11:Login as Mentor
		userLogin.userLogin(MENTOR);
		
		//Step12:Search the course created by same user
		createMentorPageObj.navigateToCourseAndSearchForOpenBatch(courseName);
		
		//Sttep13:create invite only batch
		createMentorPageObj.createOpenBatch();
		
		//Step14:Logout as Mentor
		userLogin.userLogout();	
		
		//Step15:Login as Public user
		userLogin.userLogin(PUBLICUSER1);
		
		//Step16:Search for the course
		createMentorPageObj.navigateToCourseAndSearchForOpenBatch(courseName);
		
		//Step17:Enroll for the open batch
		createMentorPageObj.enrollForOpenBatchN();
		
		//Step18:Logout as public user
		userLogin.userLogout();	
		
		//Step19:Login as Mentor
		userLogin.userLogin(MENTOR);
		
		//Step20:Search the course and check the stats
		createMentorPageObj.navigateToCourseAndSearchForOpenBatch(courseName);
		createMentorPageObj.viewCourseStats();
		
		//Step21: Logout as mentor
		GenericFunctions.refreshWebPage();
		userLogin.userLogout();
		
		//Step22: Login as Creator
		userLogin.userLogin(CREATOR);

		//Step23: Navigate to WorkSpace
		creatorUserPageObj.navigateToWorkspace(PUBLISHED);

		//Step24: Delete the Created item
		creatorUserPageObj.deleteCreatedItems();

		//Step25: Logout as Creator
		userLogin.userLogout();
		
		
		
		
	}
	
	
}
