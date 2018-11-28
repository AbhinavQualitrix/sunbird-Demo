package org.testscripts2;


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

	public class CreateLessonPlanAndVerify extends BaseTest {
		
		@Test
		public void createLessonAndVerify() throws Exception
		{
			List <TestDataForSunbird> objListOFTestDataForSunbird= null ;
			objListOFTestDataForSunbird = ReadTestDataFromExcel.getTestDataForSunbird("testdatasheetcourse");
			SignUpPageObj creatorLogin = new SignUpPageObj();
			CreatorUserPageObj creatorUserPageObj = new CreatorUserPageObj();
			//Step1: Login as Creator
			
			creatorLogin.userLogin(CREATOR);
			
			//Step2: Navigate to WorkSpace
			
			creatorUserPageObj.navigateToWorkspace(LESSONPLAN);
			
			//Step3: Create new Course
		     creatorUserPageObj.createCourse(objListOFTestDataForSunbird);
			
			//Step4: Save and send resource for review
			
			creatorUserPageObj.saveAndSendResouceForReview();
			GenericFunctions.refreshWebPage();
				
			//Step5: Check for course in review submissions 
			creatorUserPageObj.reviewInSubmissions(LESSONPLAN,objListOFTestDataForSunbird);
			
			GenericFunctions.waitWebDriver(3000);

			//Step6: Logout as Creator
			creatorLogin.userLogout();
			
			//Step7: Login as Reviewer
			creatorLogin.userLogin(REVIEWER);
			
			//Step8: Search the course which was submitted for review
			GenericFunctions.waitWebDriver(2000);
			creatorUserPageObj.searchInUpForReview(LESSONPLAN,objListOFTestDataForSunbird);
			
			
			//Step 9:publish the resource and search it
			//creatorUserPageObj.LessonPlanPublishAndSearch(objListOFTestDataForSunbird);
			
			//Step 10: Logout as Reviewer
			creatorLogin.userLogout();		
			
			//Step11: Login as Public User
			creatorLogin.userLogin(PUBLICUSER1);

			//Step12: Search the course with Name
			GenericFunctions.waitWebDriver(2000);
			CreateMentorPageObj createMentorPageObj = new CreateMentorPageObj();
			//createMentorPageObj.navigateToLibraryAndSearchForLessonPlan();

			//Step 13: Logout as Reviewer
			creatorLogin.userLogout();		
			
		}

	}


