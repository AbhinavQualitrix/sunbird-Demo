package org.testscript;

import org.pageobjects.LessonPlanPageObj;
import org.pageobjects.SignUpPageObj;
import org.startup.BaseTest;
import org.testng.annotations.Test;

public class TC_202 extends BaseTest {
	
	@Test
	public void TC_202_memberSearchInBatch() throws Exception {

		// Login as creator
		SignUpPageObj UserLogin = new SignUpPageObj();
		UserLogin.userLogin(CREATOR);

		// Click on workspace
		LessonPlanPageObj LessonPlanPageObj = new LessonPlanPageObj();
		LessonPlanPageObj.clickWorkspace();
		
		// Fill details and click start creating
		LessonPlanPageObj.createLessonPlanpopUp();
		
		// Create lesson Plan with three resources
		LessonPlanPageObj.lessonPlanWithThreeResources();
	}
}