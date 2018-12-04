package org.testscript;

import org.pageobjects.LessonPlanPageObj;
import org.pageobjects.PublicUserPageObj;
import org.pageobjects.SignUpPageObj;
import org.startup.BaseTest;
import org.testng.annotations.Test;

public class TC_205 extends BaseTest {
	@Test
	public void TC_205_lessonPlan() throws Exception {

		// Login as Creator
		SignUpPageObj login = new SignUpPageObj();
		login.userLogin(CREATOR);

		// Click on workspace
		 LessonPlanPageObj LessonPlanPageObj = new LessonPlanPageObj();
		 LessonPlanPageObj.clickWorkspace();
		  
		// Fill details and click start creating
		 LessonPlanPageObj.createLessonPlanpopUp();
		
		// Create ChildNode and click on proceed
		 LessonPlanPageObj.createChildNode();
		
		// Save Lesson plan and send for review
		 LessonPlanPageObj.saveLessonPlanAndSendForReview();				
	}    
}