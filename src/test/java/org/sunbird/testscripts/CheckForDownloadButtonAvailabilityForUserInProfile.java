/**

* Created by Qualitrix Technologies Pvt Ltd.

* @author: Abhinav kumar singh

* Date: 07/06/2018

* Purpose: Check for download button availability for a non org user.

*/
package org.sunbird.testscripts;

import org.testng.annotations.Test;
import java.util.List;

import org.openqa.selenium.support.PageFactory;
import org.sunbird.generic.GenericFunctions;
import org.sunbird.generic.ReadTestDataFromExcel;
import org.sunbird.page.CreateMentorPage;
import org.sunbird.page.CreatorUserPage;
import org.sunbird.pageobjects.CreatorUserPageObj;
import org.sunbird.pageobjects.SignUpPageObj;
import org.sunbird.startup.BaseTest;
import org.sunbird.testdata.TestDataForSunbird;
import org.testng.annotations.Test;

public class CheckForDownloadButtonAvailabilityForUserInProfile extends BaseTest {
	
	CreatorUserPage createUserPage1=PageFactory.initElements(driver, CreatorUserPage.class);

	@Test
	public void checkForDownloadButtonAvailabilityForUserInProfile() throws Exception
	{
		SignUpPageObj creatorLogin = new SignUpPageObj();
		CreatorUserPageObj cretorUserPageObj =new CreatorUserPageObj();
		List <TestDataForSunbird> objListOFTestDataForSunbird1=null;
		objListOFTestDataForSunbird1 = ReadTestDataFromExcel.getTestDataForSunbird("testdatasheetcourse");
		GenericFunctions generic = new GenericFunctions();
		CreateMentorPage createMentorPage=PageFactory.initElements(driver, CreateMentorPage.class);
		
		//Step1: Login as Creator
		creatorLogin.userLogin(ADMIN);

		//Step2: Navigate to profile and search for user and download button shouldn't be available
		cretorUserPageObj.navigateToProfileAndSearch(objListOFTestDataForSunbird1.get(8).getCourseName());
		generic.isElementPresent(createMentorPage.downloadButton);
		System.out.println("Download button was not available");
		
		//Step3: Logout as mentor
		creatorLogin.userLogout();

	}
}
