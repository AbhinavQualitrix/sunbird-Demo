package org.testscript;

import java.util.List;

import org.generic.ReadTestDataFromExcel;
import org.pageobjects.BatchUserPageObj;
import org.pageobjects.CreatorUserPageObj;
import org.pageobjects.SignUpPageObj;
import org.startup.BaseTest;
import org.testdata.TestDataForSunbird;
import org.testng.annotations.Test;

public class TC_292 extends BaseTest {
  @Test
  public void TC_292_openBatchCreation() throws Exception{
	  
	  // Login as Mentor
      SignUpPageObj mentorLogin = new SignUpPageObj();
      mentorLogin.userLogin(MENTOR);

      // Click on Workspace
      CreatorUserPageObj CreatorUserPageObj = new CreatorUserPageObj();
      CreatorUserPageObj.navigateToWorkspace(COURSE);
      
      // Create course
		List <TestDataForSunbird> objListOFTestDataForSunbird= null ;
		objListOFTestDataForSunbird = ReadTestDataFromExcel.getTestDataForSunbird("testdatasheetcourse");
		BatchUserPageObj BatchUserPageObj = new BatchUserPageObj();
		BatchUserPageObj.createCourse(objListOFTestDataForSunbird);
		
	  // Save and send course for review
		BatchUserPageObj.saveAndSendCourseForReview(objListOFTestDataForSunbird);
		
	  // Logout 
		BatchUserPageObj.userLogout();
		
	  // Login back as Reviewer to Publish the course
	    mentorLogin.userLogin(REVIEWER);
		
	  // Publish the course
		BatchUserPageObj.publishCourse();
		
	  // Logout
		BatchUserPageObj.userLogout();
		
	  // Login as Course mentor
		 mentorLogin.userLogin(MENTOR);
		 
	  // Search for course created and create batch
		 BatchUserPageObj.navigateToCourseSearchAndCreateBatch();
		 
	  // Now as course mentor search for the created course on Course page
	  // 7. Click on create batch--> Select open batch
		 BatchUserPageObj.createOpenBatch();
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
  }
}
