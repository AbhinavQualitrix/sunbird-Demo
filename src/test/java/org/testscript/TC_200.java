package org.testscript;

import org.pageobjects.LessonPlanPageObj;
import org.pageobjects.SignUpPageObj;
import org.startup.BaseTest;
import org.testng.annotations.Test;

public class TC_200 extends BaseTest {

	@Test
	public void TC_200_memberSearchInBatch() throws Exception {

		
		// Step 1: Login with valid creator credential
		SignUpPageObj UserLogin = new SignUpPageObj();
		LessonPlanPageObj lessonPlanPageObj = new LessonPlanPageObj();
		
		UserLogin.userLogin(CREATOR);

		// Step 2: 
		
		lessonPlanPageObj.searchInLibrary();
		

	}
}
