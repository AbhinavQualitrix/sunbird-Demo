package org.testscript;

import org.pageobjects.BatchUserPageObj;
import org.pageobjects.SignUpPageObj;
import org.startup.BaseTest;
import org.testng.annotations.Test;

public class TC_295 extends BaseTest{
	@Test
	public void TC_295_rootOrg() throws Exception {
		
		  // Login as Mentor
	      SignUpPageObj mentorLogin = new SignUpPageObj();
	      mentorLogin.userLogin(MENTOR);
		
	      // Create Invite Only Batch
	      BatchUserPageObj BatchUserPageObj = new BatchUserPageObj();
	      BatchUserPageObj.createInviteBatch();
		
		  


	      
	}
}
