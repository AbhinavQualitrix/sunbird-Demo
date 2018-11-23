/**

* Created by Qualitrix Technologies Pvt Ltd.

* @author: Abhinav kumar singh

* Date: 06/29/2018

* Purpose: create Announcement with attachment and verify it as reviewer.

*/
package org.testscripts;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.List;

import org.generic.GenericFunctions;
import org.generic.ReadTestDataFromExcel;
import org.openqa.selenium.support.PageFactory;
import org.page.CreatorAnnouncementPage;
import org.pageobjects.CreatorAnnouncementPageObj;
import org.pageobjects.SignUpPageObj;
import org.startup.BaseTest;
import org.testdata.TestDataForSunbird;

public class CreateAnnouncementWithAttachment extends BaseTest {
	String announcementnameReview;
	String announcementName;
	List <TestDataForSunbird> objListOFTestDataForSunbird= null;
	@Test
	public void createAnnouncementWithAttachment() throws Exception
	{
		//Step1: Login as Creator
		SignUpPageObj creatorLogin = new SignUpPageObj();
		creatorLogin.userLogin(CREATOR);
		
		//Step2: Navigate to Announcement Dashboard in Dropdown
		CreatorAnnouncementPageObj creatorAnnouncementPageObj =new CreatorAnnouncementPageObj();
		creatorAnnouncementPageObj.navigateToAnnouncementInDropDownMenu();
		
		//Step3:Create Announcement using description & Url and upload attachment
		creatorAnnouncementPageObj.CreateAnnouncementUsingAttachment();
		objListOFTestDataForSunbird = ReadTestDataFromExcel.getTestDataForSunbird("testdatasheetcourse");
		GenericFunctions.waitWebDriver(1500);
		String announcementNumber = GenericFunctions.readFromNotepad("./TestData/announcementNumbers.txt").toString().toUpperCase();
		announcementName = objListOFTestDataForSunbird.get(7).getCourseName() + announcementNumber;
		
		// Step4: Logout as Creator
		GenericFunctions.waitWebDriver(1000);
		GenericFunctions.refreshWebPage();
		creatorLogin.userLogout();

				
		// Step5: Login as Reviewer
		GenericFunctions.waitWebDriver(1500);
		creatorLogin.userLogin(REVIEWER);
		
		//Step6:check for the announcement with attachment.
		CreatorAnnouncementPage createAnnouncementPage = PageFactory.initElements(driver,CreatorAnnouncementPage.class);
		GenericFunctions.waitWebDriver(1000);
		createAnnouncementPage.seeAllAnnouncement.click();
		GenericFunctions.waitWebDriver(1500);
		announcementnameReview = createAnnouncementPage.reviewAnnouncementN.getText();
		AssertJUnit.assertEquals(announcementName, announcementnameReview);
		createAnnouncementPage.reviewAnnouncementN.click();
		
		//Step7: view the content
		createAnnouncementPage.view.click();
		GenericFunctions.waitWebDriver(2000);
		System.out.println("Created Announcement is available with the attachment");
		
		//Step8: logout as Creator
		GenericFunctions.waitWebDriver(2500);
		creatorLogin.userLogout();
	}

}
