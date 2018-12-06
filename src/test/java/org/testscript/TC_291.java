package org.testscript;

import org.pageobjects.MentorOrgPageObj;
import org.pageobjects.SignUpPageObj;
import org.startup.BaseTest;
import org.testng.annotations.Test;

public class TC_291 extends BaseTest{
	@Test
	public void TC_291_rootOrg() throws Exception {
		
		  // Login as Mentor
	      SignUpPageObj mentorLogin = new SignUpPageObj();
	      mentorLogin.userLogin(MENTOR);
		
	      // Create Invite Only Batch
		//CreateMentorPageObj CreateMentorPageObj = new CreateMentorPageObj();
	      MentorOrgPageObj MentorOrgPageObj = new MentorOrgPageObj();
	      MentorOrgPageObj.createInviteBatch();
		
		
	}
}
