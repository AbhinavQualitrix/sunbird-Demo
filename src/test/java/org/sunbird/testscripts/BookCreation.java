/**
* Created by Qualitrix Technologies Pvt Ltd.
* @author: Ajith Manjunath
* Date: 06/12/2018
* Purpose: Create a New Book and validate it
*/

package org.sunbird.testscripts;

import org.testng.annotations.Test;
import java.util.List;

import org.sunbird.generic.GenericFunctions;
import org.sunbird.generic.ReadTestDataFromExcel;
import org.sunbird.pageobjects.CreatorUserPageObj;
import org.sunbird.pageobjects.SignUpPageObj;
import org.sunbird.startup.BaseTest;
import org.sunbird.testdata.TestDataForSunbird;
import org.testng.annotations.Test;

public class BookCreation extends BaseTest
{
	@Test(priority=2, groups={"Creator Group"})
	public void bookCreation() throws Exception
	{	
		List <TestDataForSunbird> objListOFTestDataForSunbird= null ;
		objListOFTestDataForSunbird = ReadTestDataFromExcel.getTestDataForSunbird("testdatasheetcourse");
		
		//Step 1: Login as Creator
		SignUpPageObj signupObj = new SignUpPageObj();
		signupObj.userLogin(CREATOR);

		//Step 2:Go to workspace , create a book,submit for reviewer
		CreatorUserPageObj creatorUserPageObj = new CreatorUserPageObj();
		creatorUserPageObj.navigateToWorkspace(BOOK);

		//Step 3: Create new Book
		creatorUserPageObj.createBook(objListOFTestDataForSunbird);

		//Step 4: Save and Send for Review
		creatorUserPageObj.saveAndSendBookForReview(objListOFTestDataForSunbird);
		GenericFunctions.waitWebDriver(2000);
		GenericFunctions.refreshWebPage();

		//Step 5: Check for course in review submissions 
		creatorUserPageObj.reviewInSubmissions(BOOK, objListOFTestDataForSunbird);
		
		//Step 6: Logout as creator
		signupObj.userLogout();

		//Step 7: Login as reviewer
		signupObj.userLogin(BOOKREVIEWER);

		//Step 8:Check in Up for Review ,publish and reject a Book
		creatorUserPageObj.searchInUpForReview(BOOK,objListOFTestDataForSunbird);
		
		//Step 9:Publish the book
		creatorUserPageObj.publishAndSearch(BOOK,objListOFTestDataForSunbird);
		
		//Step 10: Reject the book from the existing list
		creatorUserPageObj.rejectTheContent("BOOKA");
		
		//Step 11: Logout as reviewer
		signupObj.userLogout();
		
		//Step22: Login as Creator
		signupObj.userLogin(CREATOR);

		//Step23: Navigate to WorkSpace
		creatorUserPageObj.navigateToWorkspace(PUBLISHED);

		//Step24: Delete the Created item
		creatorUserPageObj.deleteCreatedItems();

		//Step25: Logout as Creator
		signupObj.userLogout();
	}

}
