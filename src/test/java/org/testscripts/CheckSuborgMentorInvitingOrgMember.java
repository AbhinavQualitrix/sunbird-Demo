/**

 * Created by Qualitrix Technologies Pvt Ltd.

 * @author: Abhinav kumar singh

 * Date: 07/12/2018

 * Purpose: Check for sub org member can't add org member while creating a invite only batch.

 */
package org.testscripts;

import org.testng.annotations.Test;
import java.util.List;
import org.apache.log4j.Logger;
import org.generic.GenericFunctions;
import org.openqa.selenium.support.PageFactory;
import org.page.CreateMentorPage;
import org.page.CreatorAnnouncementPage;
import org.page.CreatorUserPage;
import org.pageobjects.CreateMentorPageObj;
import org.pageobjects.SignUpPageObj;
import org.startup.BaseTest;
import org.testdata.TestDataForSunbird;
import org.testng.annotations.Test;

public class CheckSuborgMentorInvitingOrgMember extends BaseTest 
{
	CreatorUserPage createUserPage=PageFactory.initElements(driver, CreatorUserPage.class);
	List <TestDataForSunbird> objListOFTestDataForSunbird= null;
	CreateMentorPage createMentorPage=PageFactory.initElements(driver, CreateMentorPage.class);
	static Logger log = Logger.getLogger(CreatorAnnouncementPage.class.getName());

	@Test
	public void suborgMentorInvitingOrgMember() throws Exception
	{


		//Step1: Login as sub org member.
		SignUpPageObj creatorLogin = new SignUpPageObj();
		creatorLogin.userLogin(MENTOR);

		//Step2: Navigate to course and search the course created by other user.
		CreateMentorPageObj createMentorPageObj =new CreateMentorPageObj();
		createMentorPageObj.createInviteOnlyBatchForSuborg();
		GenericFunctions.waitWebDriver(1000);
		
		//Step3: Logout as mentor
		GenericFunctions.waitWebDriver(1000);
		creatorLogin.userLogout();





	}
}