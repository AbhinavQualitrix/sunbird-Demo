/**

* Created by Qualitrix Technologies Pvt Ltd.

* @author: Abhinav kumar singh

* Date: 06/27/2018

* Purpose: Resend and edit the Announcement and verify as reviewer.

*/
package org.testscripts;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.List;

import org.generic.GenericFunctions;
import org.generic.ReadTestDataFromExcel;
import org.openqa.selenium.support.PageFactory;
import org.page.CreatorAnnouncementPage;
import org.pageobjects.CreatorAnnouncementPageObj;
import org.pageobjects.SignUpPageObj;
import org.startup.BaseTest;
import org.testdata.TestDataForSunbird;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ResendAnnouncementAndVerifyAsReciever extends BaseTest{
	String announcementnameReview;
	String announcementName;
	boolean checkForElement=false;
	boolean checkForResendButton=false;
	String editTitle;
	String edittedTitle;
	int count=7;
	List <TestDataForSunbird> objListOFTestDataForSunbird= null;
	@Test
	public void resendAnnouncementAndVerifyAsReciever() throws InterruptedException, Exception
	{
		//Step1.Login as creator.
		
		SignUpPageObj creatorLogin = new SignUpPageObj();
		creatorLogin.userLogin(CREATOR);
		
		//Step2.Click on Announcement Dashboard.
		
		CreatorAnnouncementPageObj creatorAnnouncementPageObj =new CreatorAnnouncementPageObj();
		creatorAnnouncementPageObj.navigateToAnnouncementInDropDownMenu();
		
		//Step3.Click on resend.
		
		CreatorAnnouncementPage createAnnouncementPage = PageFactory.initElements(driver,CreatorAnnouncementPage.class);
		GenericFunctions generic = new GenericFunctions();
		checkForResendButton = generic.isElementPresent(createAnnouncementPage.resendAnnouncementButton);
		if (checkForResendButton==true) {
			announcementName = createAnnouncementPage.resendAnnouncementName.getText();
			System.out.println(announcementName);
			createAnnouncementPage.resendAnnouncementButton.click();
		} else{
			createAnnouncementPage.nextarrowOnHomePage.click();
			GenericFunctions.waitWebDriver(1000);
			announcementName = createAnnouncementPage.resendAnnouncementName.getText();
			System.out.println(announcementName);
			createAnnouncementPage.resendAnnouncementButton.click();
		}
		GenericFunctions.waitWebDriver(1500);
		
		
		//Step4.Edit the details.
		
		Robot robot = new Robot();
		objListOFTestDataForSunbird = ReadTestDataFromExcel.getTestDataForSunbird("testdatasheetcourse");
		GenericFunctions.waitWebDriver(1500);
		createAnnouncementPage.enterTitle.click();
		createAnnouncementPage.enterTitle.clear();
		String announcementNumber = GenericFunctions.readFromNotepad("./TestData/announcementNumbers.txt").toString().toUpperCase();
		editTitle = objListOFTestDataForSunbird.get(7).getCourseName() + announcementNumber;
		GenericFunctions.waitWebDriver(2000);
		createAnnouncementPage.editRecipients.click();
		GenericFunctions.waitWebDriver(2000);
		
		//Step6.Select location.
		
		createAnnouncementPage.searchForLocation.click();
		GenericFunctions.waitWebDriver(2000);
		
		
		//Step7.Click on confirm recipients.
		
		createAnnouncementPage.confirmRecipients.click();
		GenericFunctions.waitWebDriver(1000);
		createAnnouncementPage.previewAnnouncement.click();
		GenericFunctions.waitWebDriver(1000);
		createAnnouncementPage.sendAnnouncement.click();
		createAnnouncementPage.announcementcreatedConfirmation.click();
		
		
		
		//Step8.Logout as Creator
		
		GenericFunctions.waitWebDriver(2000);
		GenericFunctions.refreshWebPage();
		GenericFunctions.waitWebDriver(1000);
		creatorLogin.userLogout();
				
				
		//Step9: Login as Reviewer
				
		GenericFunctions.waitWebDriver(1500);
		creatorLogin.userLogin(REVIEWER);
		
		
		//Step10: Review the Announcement.use Assert
						

		GenericFunctions.waitWebDriver(1000);
		createAnnouncementPage.seeAllAnnouncement.click();
		GenericFunctions.waitWebDriver(1500);
		announcementnameReview = createAnnouncementPage.reviewAnnouncementN.getText();
		System.out.println(announcementnameReview);
		AssertJUnit.assertEquals(editTitle, announcementnameReview);
		createAnnouncementPage.reviewAnnouncementN.click();
		System.out.println("Edited Announcement is  available");
		
		//Step11. Logout as Creator
		
		GenericFunctions.waitWebDriver(2500);
		creatorLogin.userLogout();
	}

}
