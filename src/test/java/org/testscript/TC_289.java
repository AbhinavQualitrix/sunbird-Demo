package org.testscript;

import org.pageobjects.CreatorUserPageObj;
import org.pageobjects.MentorOrgPageObj;
import org.pageobjects.SignUpPageObj;
import org.startup.BaseTest;
import org.testng.annotations.Test;

@Test
public class TC_289 extends BaseTest{
	public void TC_289_Mentor() throws Exception{
		
	// Login as mentor
	SignUpPageObj creator = new SignUpPageObj();
	creator.userLogin(CREATOR);
	
	// Preview any course
	
	//CreatorUserPageObj creatorUserPageObj = new CreatorUserPageObj();
	MentorOrgPageObj MentorOrgPageObj = new MentorOrgPageObj();
	
	MentorOrgPageObj.coursePreview();
	
	}

}
