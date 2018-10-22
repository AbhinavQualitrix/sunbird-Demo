/**
* Created by Qualitrix Technologies Pvt Ltd.
* @author: Ajith Manjunath
* Date: 06/26/2018
* Purpose: Dial code link to book unit
*/

package org.sunbird.testscripts;

import org.testng.annotations.Test;
import java.util.List;

import org.sunbird.generic.ReadTestDataFromExcel;
import org.sunbird.pageobjects.CreatorUserPageObj;
import org.sunbird.pageobjects.SignUpPageObj;
import org.sunbird.startup.BaseTest;
import org.sunbird.testdata.TestDataForSunbird;
import org.testng.annotations.Test;

public class DialCodeLink extends BaseTest
{
	@Test(priority=17, groups={"Creator Group"})
	public void dialCodeLink() throws Exception
	{

		List <TestDataForSunbird> objListOFTestDataForSunbird= null ;
		objListOFTestDataForSunbird = ReadTestDataFromExcel.getTestDataForSunbird("testdatasheetcourse");

		SignUpPageObj signupObj = new SignUpPageObj();
		CreatorUserPageObj creatorUserPageObj = new CreatorUserPageObj();

		//Step 1:Login as Creator
		signupObj.userLogin(CREATOR);

		//Step 2:Navigate to workspace to Create a book
		creatorUserPageObj.navigateToWorkspace(BOOK);
		
		//Step 3:Create a Book
		creatorUserPageObj.createBook(objListOFTestDataForSunbird);
		
		//Step 4:Save the book and check the sucessful message
		creatorUserPageObj.saveBookAndCheckMessage();
		
		//Step 5: Logout as Creator
		signupObj.userLogout();
		
		//Step 6: Login as Creator
		signupObj.userLogin(CREATOR);

		//Step 7: Navigate to WorkSpace
		creatorUserPageObj.navigateToWorkspace(PUBLISHED);

		//Step 8: Delete the Created item
		creatorUserPageObj.deleteCreatedItems();

		//Step 9: Logout as Creator
		signupObj.userLogout();
	}
	
}
