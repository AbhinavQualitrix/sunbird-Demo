package org.testscripts.regression;

import org.testng.annotations.Test;
import org.pageobjects.ContentCreationResourcePageObj;
import org.pageobjects.CreatorUserPageObj;
import org.pageobjects.SignUpPageObj;
import org.startup.BaseTest;
import org.testng.annotations.Test;

public class UpForReview_LatestContentInTop_SearchContent_FromSameChannel_ApplyAndResetFilters extends BaseTest
{
	//92_93_94_96a_b
	@Test
	public void upForReview_ContentValidation_SearchWithFilter_TC92_93_94_96a_b() throws Exception
	{
		SignUpPageObj userLogin = new SignUpPageObj();
		CreatorUserPageObj creatorUserPageObj = new CreatorUserPageObj();
		ContentCreationResourcePageObj contentReourcePageObj= new ContentCreationResourcePageObj();
		
		//Login as Content creator
		userLogin.userLogin(REVIEWER);

		//Navigate to workspace to create Resource
		creatorUserPageObj.navigateToWorkspace(RESOURCE);
		
		//Click on Up for review and search and verify contents 
		contentReourcePageObj.validateUpForReivew();

		//Click on Up for review verify contents based Applied and Reset filters
		contentReourcePageObj.contentFilterApply_Reset();
		
		//Logout as Reviewer
		userLogin.userLogout();
	}

}
