
/**

* Created by Qualitrix Technologies Pvt Ltd.

* @author: Abhinav kumar singh

* Date: 07/16/2018

* Purpose: Check for Authentic and Unauthentic users.

*/package org.sunbird.testscripts;

import org.testng.annotations.Test;
import java.util.List;

import org.openqa.selenium.support.PageFactory;
import org.sunbird.generic.GenericFunctions;
import org.sunbird.generic.ReadTestDataFromExcel;
import org.sunbird.page.CreateMentorPage;
import org.sunbird.page.CreatorUserPage;
import org.sunbird.pageobjects.CreateMentorPageObj;
import org.sunbird.pageobjects.CreatorUserPageObj;
import org.sunbird.pageobjects.SignUpPageObj;
import org.sunbird.startup.BaseTest;
import org.sunbird.testdata.TestDataForSunbird;
import org.testng.annotations.Test;

public class CheckForAuthenticUserInMentor extends BaseTest {
	CreateMentorPage createMentorPage=PageFactory.initElements(driver, CreateMentorPage.class);
	CreatorUserPage createUserPage=PageFactory.initElements(driver, CreatorUserPage.class);
	String courseName;
	String startDate;
	String endDate;
	
	
	@Test
	public void checkForAuthenticUserInMentor() throws Exception
	{
		
		//Step1: Login as Creator
		
		SignUpPageObj creatorLogin = new SignUpPageObj();
		creatorLogin.userLogin(ADMIN);

		
		//Step2: Navigate to profile and search for authentic user
		
		CreatorUserPageObj cretorUserPageObj =new CreatorUserPageObj();
		List <TestDataForSunbird> objListOFTestDataForSunbird1=null;
		objListOFTestDataForSunbird1 = ReadTestDataFromExcel.getTestDataForSunbird("testdatasheetcourse");
		cretorUserPageObj.navigateToProfileAndSearch(objListOFTestDataForSunbird1.get(9).getCourseDescription());
		GenericFunctions.waitWebDriver(1000);
		
		CreateMentorPageObj createMentorPageObj = new CreateMentorPageObj();
		createMentorPageObj.checkForAuthenticUserAndEdit();
		

		//Step3: Navigate to profile and search for Unauthentic user
		GenericFunctions.refreshWebPage();
		GenericFunctions.waitWebDriver(1000);
		cretorUserPageObj.navigateToProfileAndSearch(objListOFTestDataForSunbird1.get(9).getTitle());
		GenericFunctions.waitWebDriver(1000);
		createMentorPageObj.checkForUnauthenticUserAndEdit();

		
		//Step4: Logout as mentor
		
		GenericFunctions.waitWebDriver(1000);
		creatorLogin.userLogout();
		
		

	}

}