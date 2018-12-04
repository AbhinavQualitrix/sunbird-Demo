package org.testscript;

import java.util.List;

import org.generic.ReadTestDataFromExcel;
import org.pageobjects.CreateMentorPageObj;
import org.pageobjects.CreatorUserPageObj;
import org.pageobjects.FlagReviewerPageObj;
import org.pageobjects.MentorOrgPageObj;
import org.pageobjects.SignUpPageObj;
import org.startup.BaseTest;
import org.testdata.TestDataForSunbird;
import org.testng.annotations.Test;

public class TC_290 extends BaseTest {
  @Test
  public void TC_290_openBatchCreation() throws Exception{
	  
	  // Login as Mentor
      SignUpPageObj mentorLogin = new SignUpPageObj();
      mentorLogin.userLogin(MENTOR);

      // Click on Workspace
      CreatorUserPageObj CreatorUserPageObj = new CreatorUserPageObj();
      CreatorUserPageObj.navigateToWorkspace(COURSE);
      
      // Create course
      MentorOrgPageObj MentorOrgPageObj = new MentorOrgPageObj();
		List <TestDataForSunbird> objListOFTestDataForSunbird= null ;
		objListOFTestDataForSunbird = ReadTestDataFromExcel.getTestDataForSunbird("testdatasheetcourse");
		MentorOrgPageObj.createCourse(objListOFTestDataForSunbird);
		
	  // Save and send course for review
		MentorOrgPageObj.saveAndSendCourseForReview(objListOFTestDataForSunbird);
		
	  // Logout 
		MentorOrgPageObj.userLogout();
		
	  // Login back as Reviewer to Publish the course
	    mentorLogin.userLogin(REVIEWER);
		
	  // Publish the course
		MentorOrgPageObj.publishCourse();
		
	  // Logout
		MentorOrgPageObj.userLogout();
		
	  // Login as Course mentor
		 mentorLogin.userLogin(MENTOR);
		 
	  // Search for course created and create batch
		 MentorOrgPageObj.navigateToCourseSearchAndCreateBatch();
		 
	  // Now as course mentor search for the created course on Course page
	  // 7. Click on create batch--> Select open batch
		 
		 MentorOrgPageObj.createOpenBatch();
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
  }
}
