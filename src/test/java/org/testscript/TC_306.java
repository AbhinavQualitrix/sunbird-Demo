package org.testscript;

import org.pageobjects.BatchUserPageObj;
import org.pageobjects.SignUpPageObj;
import org.startup.BaseTest;
import org.testng.annotations.Test;

public class TC_306 extends BaseTest{
	@Test
	public void TC_306_rootOrg() throws Exception {
		
		  // Login as Mentor
	      SignUpPageObj mentorLogin = new SignUpPageObj();
	      mentorLogin.userLogin(MENTOR);
		
	      // Create Invite Only Batch
	      BatchUserPageObj BatchUserPageObj = new BatchUserPageObj();
	      BatchUserPageObj.navigateToWorkspaceAndSelectBatches("Upcoming Batches");
		
		  // Update Upcoming Batch		
	      BatchUserPageObj.navigateToCourseSearchAndUpdate();
		  
	}
}
