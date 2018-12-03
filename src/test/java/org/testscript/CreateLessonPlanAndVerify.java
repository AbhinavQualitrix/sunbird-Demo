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

	public class CreateLessonPlanAndVerify extends BaseTest {
		
		@Test
		public void createLessonAndVerify() throws Exception
		{
			List <TestDataForSunbird> objListOFTestDataForSunbird= null ;
			objListOFTestDataForSunbird = ReadTestDataFromExcel.getTestDataForSunbird("testdatasheetcourse");
			SignUpPageObj creatorLogin = new SignUpPageObj();
			CreateMentorPageObj createMentorPageObj = new CreateMentorPageObj();
			CreatorUserPageObj creatorUserPageObj = new CreatorUserPageObj();
			//Step1: Login as Creator
			
			creatorLogin.userLogin(CREATOR);
			
			//Step2: Navigate to WorkSpace
			
			creatorUserPageObj.navigateToWorkspace(LESSONPLAN);
			
			//Step3: Create new Lesson plan
		     creatorUserPageObj.createLessonPlan();
			
			//Step4: Save and send resource for review
			
			creatorUserPageObj.saveAndSendForReviewLesson();
			GenericFunctions.refreshWebPage();
				
			//Step5: Check for course in review submissions 
			creatorUserPageObj.reviewInSubmissions(LESSONPLAN,objListOFTestDataForSunbird);
			
			GenericFunctions.waitWebDriver(3000);

			//Step6: Logout as Creator
			creatorLogin.userLogout();
			
			//Step7: Login as Reviewer
			creatorLogin.userLogin(REVIEWER);
			
			//Step8: Search the course which was submitted for review
			creatorUserPageObj.goToWorkspace("lessonplan");
			
			//Step 10: Logout as Reviewer
			creatorLogin.userLogout();		
			
			//Step11: Login as Public User
			creatorLogin.userLogin(PUBLICUSER1);

			//Step12: Search the course with Name
			GenericFunctions.waitWebDriver(2000);
			
			createMentorPageObj.navigateToLibraryAndSearchForLessonPlan();

			//Step 13: Logout as Reviewer
			creatorLogin.userLogout();		
			
		}

	}


