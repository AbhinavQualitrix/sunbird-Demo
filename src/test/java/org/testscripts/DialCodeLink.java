/**
* Created by Qualitrix Technologies Pvt Ltd.
* @author: Ajith Manjunath
* Date: 06/26/2018
* Purpose: Dial code link to book unit
*/

package org.testscripts;

import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import java.util.List;

import org.generic.ExtentTestManager;
import org.generic.GenericFunctions;
import org.generic.ReadTestDataFromExcel;
import org.openqa.selenium.support.PageFactory;
import org.page.CreatorUserPage;
import org.pageobjects.CreatorUserPageObj;
import org.pageobjects.SignUpPageObj;
import org.startup.BaseTest;
import org.testdata.TestDataForSunbird;
import org.testng.annotations.Test;

public class DialCodeLink extends BaseTest
{
	@Test(priority=17, groups={"Creator Group"})
	public void dialCodeLink() throws Exception
	{
		//MT done
		CreatorUserPage createUserPage=PageFactory.initElements(driver, CreatorUserPage.class);

		List <TestDataForSunbird> objListOFTestDataForSunbird= null ;
		objListOFTestDataForSunbird = ReadTestDataFromExcel.getTestDataForSunbird("testdatasheetcourse");

		SignUpPageObj signupObj = new SignUpPageObj();
		CreatorUserPageObj creatorUserPageObj = new CreatorUserPageObj();

		//Step 1:Login as Creator
		signupObj.userLogin(BOOKCREATOR);

		//Step 2:Navigate to workspace to Create a book
		creatorUserPageObj.navigateToWorkspace(BOOK);
		
		//Step 3,4:Create a Book
		creatorUserPageObj.createBook(objListOFTestDataForSunbird);
		
		//Step 5,6 and 7:Save the book and check the sucessful message
		creatorUserPageObj.saveBookAndCheckMessage();
		
		try
		{
			GenericFunctions.waitForElementToAppear(createUserPage.editorCloseIcon);
			createUserPage.editorCloseIcon.click();
		}
		catch(Exception e)
		{
			GenericFunctions.refreshWebPage();
			ExtentTestManager.getTest().log(LogStatus.INFO,"Could not close the content editor after saving the content.");
		}
		
		//Logout as Creator
		signupObj.userLogout();
	}
	
}
