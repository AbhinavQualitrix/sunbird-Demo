/**

* Created by Qualitrix Technologies Pvt Ltd.

* @author: Abhinav kumar singh

* Date: 07/16/2018

* Purpose: After creating invite only batch,check invited mentor can update it.

*/
package org.testscripts;

import org.testng.annotations.Test;

import junit.framework.Assert;

import java.util.List;

import org.generic.GenericFunctions;
import org.generic.ReadTestDataFromExcel;
import org.openqa.selenium.support.PageFactory;
import org.page.CreateMentorPage;
import org.page.CreatorUserPage;
import org.pageobjects.CreateMentorPageObj;
import org.pageobjects.SignUpPageObj;
import org.startup.BaseTest;
import org.testdata.TestDataForSunbird;
import org.testng.annotations.Test;

public class UpdateBatchAsInvitedMentor extends BaseTest 
{
	CreatorUserPage createUserPage=PageFactory.initElements(driver, CreatorUserPage.class);
	CreateMentorPage createMentorPage=PageFactory.initElements(driver, CreateMentorPage.class);
	List <TestDataForSunbird> objListOFTestDataForSunbird= null;
	
	
	@Test
	public void updateBatchAsInvitedMember() throws Exception
	{
		
		SignUpPageObj creatorLogin = new SignUpPageObj();
		CreateMentorPageObj createMentorPageObj =new CreateMentorPageObj();
		objListOFTestDataForSunbird = ReadTestDataFromExcel.getTestDataForSunbird("testdatasheetcourse");
		
		//Step1: Login as mentor
		
		creatorLogin.userLogin(MENTOR);
		
		//Step2: search for the course created by other user and create invite only batch
		
		String courseName=createMentorPageObj.createInviteOnlyBatch();
		System.out.println(courseName);
		GenericFunctions.waitWebDriver(3000);
		
		//Step3: Logout as mentor
		
		GenericFunctions.waitWebDriver(3000);
		creatorLogin.userLogout();
		
		
		//Step4: Login as invited member  
			
		creatorLogin.userLogin(PUBLICUSER1);
		
		
		//Step5: Search for the particular course 
		
		createMentorPageObj.navigateToCourseAndSearch(courseName);
		
		//Step6: Logout as invited member
		
		GenericFunctions.waitWebDriver(2000);
		//GenericFunctions.refreshWebPage();
		GenericFunctions.waitWebDriver(1000);
		creatorLogin.userLogout();
		
		//Step7: Login as mentor
		
		creatorLogin.userLogin(CREATOR);
		
		//Step8: Search for the particular course and update the batch
		
		createMentorPageObj.navigateToCourseSearchAndUpdate(courseName);
		String expected = courseName;//objListOFTestDataForSunbird.get(1).getCourseName()+ GenericFunctions.readFromNotepad("./TestData/batchName.txt");
		System.out.println(expected);
		
		//Step9: Logout as mentor
		
		GenericFunctions.waitWebDriver(2000);
		//GenericFunctions.refreshWebPage();
		GenericFunctions.waitWebDriver(1000);
		creatorLogin.userLogout();
		
		//Step10: Login as invited member  
		
		creatorLogin.userLogin(PUBLICUSER1);
					
		//Step11: Search for the particular course 
				
		createMentorPageObj.navigateToCourseAndSearch(courseName);
		GenericFunctions.waitWebDriver(2000);
		createMentorPage.closeBatchIcon.click();
		GenericFunctions.waitWebDriver(2000);
		String Actual = createMentorPage.batchDetails.getText();
		System.out.println(Actual);
		
		//Step11: Verify the update 

		Assert.assertEquals(Actual, expected);
		System.out.println("updated data is verified");
		
		//Step12: Logout as mentor
		
		GenericFunctions.waitWebDriver(3000);
		creatorLogin.userLogout();
		
	}
}
