/**
* Created by Qualitrix Technologies Pvt Ltd.
* @author: Ajith Manjunath
* Date: 06/20/2018
* Purpose: Create a New Collection and validate it
*/

package org.sunbird.testscripts;

import org.testng.annotations.Test;
import org.sunbird.generic.GenericFunctions;
import org.sunbird.pageobjects.CreatorUserPageObj;
import org.sunbird.pageobjects.SignUpPageObj;
import org.sunbird.startup.BaseTest;
import org.testng.annotations.Test;

public class CollectionCreation extends BaseTest
{
	@Test(priority=10, groups={"Creator Group"})
	public void collectionCreation() throws Exception
	{
		SignUpPageObj signupObj = new SignUpPageObj();
		CreatorUserPageObj creatorUserPageObj = new CreatorUserPageObj();
		
		//Step1:Login as content creator
		signupObj.userLogin(CREATOR);
		
		//Step2:Navigate to workspace and create a Collection 
		//And send the Collection for review
		creatorUserPageObj.createCollection();
		creatorUserPageObj.createCollection();
		
		//Step3:Logout as Creator 
		signupObj.userLogout();
		
		//Step4:Login as Reviewer
		signupObj.userLogin(REVIEWER);
		
		//Step5:Go to workspace and publish the content-h5p
		creatorUserPageObj.goToWorkspace("collection");
		
		GenericFunctions.waitWebDriver(2000);
		
		//Step6:Reject the Collection
		creatorUserPageObj.rejectTheContent(COLLECTION);
		
		//StepLogout as Reviewer
		signupObj.userLogout();
		
		//Step7: Login as Creator
		signupObj.userLogin(CREATOR);

		//Step8: Navigate to WorkSpace
		creatorUserPageObj.navigateToWorkspace(PUBLISHED);

		//Step9: Delete the Created item
		creatorUserPageObj.deleteCreatedItems();

		//Step10: Logout as Creator
		signupObj.userLogout();
	}

}
